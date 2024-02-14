package dev.cad.credit.aplication.system.dto

import dev.cad.credit.aplication.system.entity.Adress
import dev.cad.credit.aplication.system.entity.Customer
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

data class CustomerUpdateDto(
    @field: NotEmpty(message = "Invalid Input") val firstName: String,
    @field: NotEmpty(message = "Invalid Input") val lastName: String,
    @field: NotNull(message = "Invalid Input") val income: BigDecimal,
    @field: NotEmpty(message = "Invalid Input") val zipCode: String,
    @field: NotEmpty(message = "Invalid Input") val street: String
) {
    fun toEntity(customer: Customer): Customer {
        customer.firstName = this.firstName
        customer.lastName = this.lastName
        customer.income = this.income
        customer.adress.zipCode = this.zipCode
        customer.adress.street = this.street
        return customer
    }
}
