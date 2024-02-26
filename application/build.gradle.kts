dependencies {
    implementation(project(":domain"))
    implementation(project(":rest-api"))
    implementation(project(":jpa-repository"))
    implementation(project(":feign-client"))
    implementation(project(":event-handler"))

    implementation("org.reactivecommons.utils:object-mapper:0.1.0")
    implementation("org.springframework.cloud:spring-cloud-starter-bootstrap")
    implementation("org.springframework.cloud:spring-cloud-starter-config")
    implementation("org.springframework.cloud:spring-cloud-starter-sleuth")
}

tasks.getByName<Jar>("jar") {
    enabled = false
}

tasks.getByName<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
    this.archiveFileName.set("${project.parent?.name}.${archiveExtension.get()}")
}
