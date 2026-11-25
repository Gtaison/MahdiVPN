cmake_minimum_required(VERSION 3.22.1)
project(tunneljni CXX C)

# The Aether tunnel core is optional at build time: it is distributed through the
# signed engine channel, not checked into this repository. Build the JNI shim only
# when that exact ABI's core has been supplied in jniLibs.
set(TUNNEL_CORE ${CMAKE_CURRENT_LIST_DIR}/../jniLibs/${ANDROID_ABI}/libtunnelcore.so)
if(EXISTS ${TUNNEL_CORE})
    add_library(tunnelcore SHARED IMPORTED)
    set_target_properties(tunnelcore PROPERTIES IMPORTED_LOCATION ${TUNNEL_CORE})
    add_library(tunneljni SHARED tunnel_jni.cpp)
    find_library(log-lib log)
    target_link_libraries(tunneljni tunnelcore ${log-lib})
    target_link_options(tunneljni PRIVATE
        "-Wl,-z,max-page-size=16384"
        "-Wl,-z,common-page-size=16384")
endif()

# badvpn tun2socks (lwIP TCP/IP stack in userspace) -> libtun2socks.so.
#
# This is the path for transports that hand us a local SOCKS5 port rather than
# driving the tun themselves. lwIP terminates TCP in userspace and udpgw carries
# UDP, which is what makes QUIC and games work; a hand-written stack that only
# forwarded port 53 would not.
add_subdirectory(badvpn)
