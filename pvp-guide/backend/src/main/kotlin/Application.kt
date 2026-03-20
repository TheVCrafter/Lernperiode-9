package com.vindev.pvpguide

import com.vindev.pvpguide.config.AppConfig.*
import com.vindev.pvpguide.plugins.configureHTTP
import com.vindev.pvpguide.plugins.configureRouting
import com.vindev.pvpguide.plugins.configureSerialization
import com.vindev.pvpguide.plugins.configureStatusPages
import com.vindev.pvpguide.plugins.configureSwagger
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    val appConfig = loadAppConfig()

    configureStatusPages()
    configureHTTP(appConfig)
    configureSerialization()
    configureRouting()
    configureSwagger()
}