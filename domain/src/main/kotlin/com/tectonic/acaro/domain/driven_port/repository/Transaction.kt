package com.tectonic.acaro.domain.driven_port.repository

interface Transaction {
    fun <R> run(block: () -> R): R
}