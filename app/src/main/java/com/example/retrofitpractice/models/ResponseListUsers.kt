package com.example.retrofitpractice.models


import android.provider.ContactsContract.Contacts.Data

data class ResponseListUsers(
    var data: List<Data>,
    var page: Int,
    var per_page: Int,
    var total: Int,
    var totalPages: Int

)
