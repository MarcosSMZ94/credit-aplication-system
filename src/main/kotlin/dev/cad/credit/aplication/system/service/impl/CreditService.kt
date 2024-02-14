package dev.cad.credit.aplication.system.service.impl

import dev.cad.credit.aplication.system.entity.Credit
import dev.cad.credit.aplication.system.exception.BusinessException
import dev.cad.credit.aplication.system.repository.CreditRepository
import dev.cad.credit.aplication.system.service.ICreditService
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.util.*

@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val customerService: CustomerService
) : ICreditService {

    override fun save(credit: Credit): Credit {
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }
        return this.creditRepository.save(credit)
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> =
        this.creditRepository.findAllByCustomerId(customerId)

    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
        val credit: Credit =
            (this.creditRepository.findByCreditCode(creditCode) ?: throw BusinessException("Credit code not found"))
        return if (credit.customer?.id!! == customerId) credit else throw BusinessException("Contact admin")
    }

}