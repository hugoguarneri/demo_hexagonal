package com.tectonic.acaro.feign.config

import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Configuration

@Configuration
@EnableFeignClients(basePackages = ["com.tectonic.acaro.feign.client"])
class FeignConfig
