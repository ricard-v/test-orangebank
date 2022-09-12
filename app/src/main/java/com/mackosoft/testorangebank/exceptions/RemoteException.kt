package com.mackosoft.testorangebank.exceptions

data class RemoteException(private val errorMessage: String) : Exception(errorMessage)
