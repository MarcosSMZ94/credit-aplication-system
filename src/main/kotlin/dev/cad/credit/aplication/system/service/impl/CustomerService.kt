package dev.cad.credit.aplication.system.service.impl

import dev.cad.credit.aplication.system.entity.Customer
import dev.cad.credit.aplication.system.exception.BusinessException
import dev.cad.credit.aplication.system.repository.CustomerRepository
import dev.cad.credit.aplication.system.service.ICustomerService
import org.springframework.stereotype.Service

@Service
class CustomerService(private val customerRepository: CustomerRepository) : ICustomerService {
    override fun save(customer: Customer): Customer = this.customerRepository.save(customer)

    override fun findById(id: Long): Customer = this.customerRepository.findById(id)
        .orElseThrow {
            BusinessException("Id $id not found")
        }

    override fun delete(id: Long) = this.customerRepository.deleteById(id)
}