package com.example.jessenjj_kotlin.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class TransactionInboxModel (
    val transferType: String,
    val transferDestination: String,
    val transferDate: String,
    val transferStatus: String,
    val transferAmount: Double,
):Parcelable