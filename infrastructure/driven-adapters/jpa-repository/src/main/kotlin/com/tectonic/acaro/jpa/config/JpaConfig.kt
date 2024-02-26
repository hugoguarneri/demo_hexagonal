package com.tectonic.acaro.jpa.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EnableJpaRepositories(basePackages = ["com.tectonic.acaro.jpa"])
class JpaConfig
