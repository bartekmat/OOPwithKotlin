package com.rsk.logger

class ConsoleLogger : Logger {
    override fun debug(msg: String) {
        println("[DEBUG] $msg")
    }

    override fun warn(msg: String) {
        println("[WARN] $msg")
    }
}