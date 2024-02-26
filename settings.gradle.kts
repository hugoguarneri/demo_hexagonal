rootProject.name = "acaro"

include(":application")
project(":application").projectDir = file("./application")

include(":domain")
project(":domain").projectDir = file("./domain")

include(":rest-api")
project(":rest-api").projectDir = file("./infrastructure/entry-points/rest-api")

include(":feign-client")
project(":feign-client").projectDir = file("./infrastructure/driven-adapters/feign-client")

include(":jpa-repository")
project(":jpa-repository").projectDir = file("./infrastructure/driven-adapters/jpa-repository")

include(":event-handler")
project(":event-handler").projectDir = file("./infrastructure/event-handler")

pluginManagement {
    val pluginVersion: String by settings
    val kotlinVersion: String by settings
    val springManagementVersion: String by settings
    val springBootVersion: String by settings
    val ktLintVersion: String by settings

    repositories {
        mavenCentral()
        gradlePluginPortal()
    }

    plugins {
        kotlin("jvm") version kotlinVersion
        kotlin("plugin.spring") version kotlinVersion
        kotlin("plugin.allopen") version kotlinVersion
        kotlin("kapt") version kotlinVersion
        id("io.spring.dependency-management") version springManagementVersion
        id("org.springframework.boot") version springBootVersion
        id("org.jlleitschuh.gradle.ktlint") version ktLintVersion
    }
}
