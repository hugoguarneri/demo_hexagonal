dependencies {
    implementation("io.github.microutils:kotlin-logging-jvm:3.0.5")
    implementation("commons-io:commons-io:2.11.0")
    implementation("org.yaml:snakeyaml:1.27")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.14.2")
    testImplementation("com.github.javafaker:javafaker:1.0.2") {
        exclude(module = "org.yaml")
    }
}
repositories {
    mavenCentral()
}
