package dev.cad.credit.aplication.system.entity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class Adress(
    @Column(nullable = false) var zipCode: String = "",
    @Column(nullable = false) var street: String = ""
)