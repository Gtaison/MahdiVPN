package com.mlmvpn.scanner.ui.argo

import android.app.Activity
import android.net.VpnService
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mlmvpn.scanner.R
import com.mlmvpn.scanner.engines.argo.ArgoEngine
import com.mlmvpn.scanner.ui.settings.IosScreen
import kotlinx.coroutines.launch

@Composable
fun ArgoScreen(onBack: () -> Unit) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val state by ArgoEngine.state.collectAsState()
    val logs by ArgoEngine.logs.collectAsState()
    var rawConfig by rememberSaveable { mutableStateOf("") }
    var poolStats by remember { mutableStateOf(ArgoEngine.PoolStats(0, 0, 0, 0, 0)) }

    val vpnPermission = rememberLauncherForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            ArgoEngine.connectAsync(context, rawConfig = rawConfig.takeIf { it.isNotBlank() })
        }
    }

    LaunchedEffect(Unit) {
        ArgoEngine.init(context)
        poolStats = ArgoEngine.poolStats(context)
    }

    fun connect() {
        val prepare = VpnService.prepare(context)
        if (prepare != null) vpnPermission.launch(prepare)
        else ArgoEngine.connectAsync(context, rawConfig = rawConfig.takeIf { it.isNotBlank() })
    }

    IosScreen(
        title = stringResource(R.string.argo_title),
        onBack = onBack,
        backLabel = stringResource(R.string.home)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 12.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(stringResource(R.string.argo_status), style = MaterialTheme.typography.titleMedium)
                    Text(
                        when (state.phase) {
                            ArgoEngine.Phase.CONNECTED -> stringResource(R.string.argo_connected)
                            ArgoEngine.Phase.REFRESHING -> stringResource(R.string.argo_refreshing)
                            ArgoEngine.Phase.AUTHENTICATING -> stringResource(R.string.argo_authenticating)
                            ArgoEngine.Phase.STARTING -> stringResource(R.string.argo_starting)
                            ArgoEngine.Phase.VERIFYING -> stringResource(R.string.argo_verifying)
                            ArgoEngine.Phase.STOPPING -> stringResource(R.string.argo_stopping)
                            ArgoEngine.Phase.FAILED -> stringResource(R.string.argo_failed)
                            ArgoEngine.Phase.IDLE -> stringResource(R.string.argo_idle)
                        },
                        style = MaterialTheme.typography.bodyLarge
                    )
                    state.message?.let { Text(it, style = MaterialTheme.typography.bodySmall) }
                    if (state.connected) {
                        Text(state.host.orEmpty(), style = MaterialTheme.typography.bodyMedium)
                        Text(
                            "${state.exitCountry.orEmpty()} · ${state.exitIp.orEmpty()} · ${state.latencyMs ?: 0} ms",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                    Text(
                        stringResource(
                            R.string.argo_pool_summary,
                            poolStats.total,
                            poolStats.bridges,
                            poolStats.publicServers,
                            poolStats.falcons,
                            poolStats.falconOrigins
                        ),
                        style = MaterialTheme.typography.bodySmall
                    )
                    if (state.busy) CircularProgressIndicator()
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Button(onClick = ::connect, enabled = !state.busy && !state.connected) {
                            Text(stringResource(R.string.argo_connect))
                        }
                        OutlinedButton(
                            onClick = { ArgoEngine.disconnectAsync(context) },
                            enabled = state.connected || state.busy
                        ) {
                            Text(stringResource(R.string.argo_disconnect))
                        }
                    }
                    TextButton(
                        onClick = {
                            scope.launch {
                                ArgoEngine.refreshAsync(context).join()
                                poolStats = ArgoEngine.poolStats(context)
                            }
                        },
                        enabled = !state.busy
                    ) {
                        Text(stringResource(R.string.argo_refresh))
                    }
                }
            }

            OutlinedTextField(
                value = rawConfig,
                onValueChange = { rawConfig = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(stringResource(R.string.argo_manual_label)) },
                placeholder = { Text(stringResource(R.string.argo_manual_hint)) },
                minLines = 2,
                maxLines = 5
            )

            Card(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Text(stringResource(R.string.argo_logs), style = MaterialTheme.typography.titleMedium)
                    Column(
                        modifier = Modifier.fillMaxWidth().heightIn(max = 220.dp).verticalScroll(rememberScrollState()),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        if (logs.isEmpty()) {
                            Text(stringResource(R.string.argo_no_logs), style = MaterialTheme.typography.bodySmall)
                        } else {
                            logs.takeLast(10).asReversed().forEach { line ->
                                Text(line.substringAfter("] "), style = MaterialTheme.typography.bodySmall)
                            }
                        }
                    }
                }
            }
        }
    }
}
