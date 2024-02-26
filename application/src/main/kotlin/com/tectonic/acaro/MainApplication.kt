package com.tectonic.acaro

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.tectonic.*"])
@ConfigurationPropertiesScan
class MainApplication

fun main(args: Array<String>) {
    runApplication<MainApplication>(*args)
}
