package com.tectonic.acaro.config

import feign.okhttp.OkHttpClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FeignClientConfiguration {
    @Bean
    fun feignClient(): OkHttpClient {
        return OkHttpClient()
    }
}
