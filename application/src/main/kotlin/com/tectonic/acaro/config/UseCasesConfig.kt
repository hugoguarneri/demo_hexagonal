package com.tectonic.acaro.config

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType

@Configuration
@ComponentScan(
    basePackages = ["com.tectonic.acaro.domain"],
    includeFilters = [ComponentScan.Filter(type = FilterType.REGEX, pattern = ["^.+UseCaseImpl$", "^.+UseCase$"])],
    useDefaultFilters = false
)
class UseCasesConfig
