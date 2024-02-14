package dev.cad.credit.aplication.system.dto

import dev.cad.credit.aplication.system.entity.Credit
import dev.cad.credit.aplication.system.entity.Customer
import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    @field: NotNull(message = "Invalid Input") val creditValue: BigDecimal,
    @field: Future(message = "Invalid Input") val dayOfFirstInstallment: LocalDate,
    @field: NotNull(message = "Invalid Input") val numberOfInstallment: Int,
    @field: NotNull(message = "Invalid Input") val customerId: Long
) {
    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayOfFirstInstallment = this.dayOfFirstInstallment,
        numberOfInstallment = this.numberOfInstallment,
        customer = Customer(id = this.customerId)
    )

}
