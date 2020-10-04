package com.rsk

import java.nio.file.Path

interface Logger {
    fun debug(msg: String)
    fun warn(msg: String)
    fun info(msg: String){
        warn(msg)
    }
}
interface Message {
    fun info(){}
}

class FileLogger(val file: Path) : Logger, Message {
    override fun debug(msg: String) {
    }

    override fun warn(msg: String) {
    }

    override fun info(msg: String){
        super<Logger>.info(msg)
        super<Message>.info()
    }
}

class ConsoleLogger : Logger {
    override fun debug(msg: String) {
        println("[DEBUG] $msg")
    }

    override fun warn(msg: String) {
        println("[WARN] $msg")
    }
}