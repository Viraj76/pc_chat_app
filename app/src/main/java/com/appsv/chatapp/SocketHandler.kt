package com.appsv.chatapp

import io.socket.client.IO
import io.socket.client.Socket


class SocketHandler {

    private var socket : Socket = IO.socket("http://192.168.100.102:3000/")

    init {
        socket.connect()
    }


}