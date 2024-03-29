package dev.cad.credit.aplication.system.dto

import dev.cad.credit.aplication.system.entity.Adress
import dev.cad.credit.aplication.system.entity.Customer
import java.math.BigDecimal

data class CustomerView(
    val firstName: String,
    val lastName: String,
    val cpf: String,
    val income: BigDecimal,
    val email: String,
    val zipCode: String,
    val street: String
) {
    constructor(customer: Customer) : this(
        firstName = customer.firstName,
        lastName = customer.lastName,
        cpf = customer.cpf,
        income = customer.income,
        email = customer.email,
        zipCode = customer.adress.zipCode,
        street = customer.adress.street
    )
}
