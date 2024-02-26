dependencies {
    implementation(project(":domain"))

    implementation("org.flywaydb:flyway-core")
    runtimeOnly("org.postgresql:postgresql")

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("com.sipios:spring-search:0.2.0")
}
