package com.rsk.logger

import java.nio.file.Path

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