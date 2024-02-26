package com.tectonic.acaro.jpa.transaction

import com.tectonic.acaro.domain.driven_port.repository.Transaction
import org.springframework.transaction.annotation.Transactional

open class TransactionImpl: Transaction {

    @Transactional(readOnly = false)
    override fun <R> run(block: () -> R): R  {
        return block()
    }
}