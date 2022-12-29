package com.example.retrofitpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.example.retrofitpractice.models.ApiInterface
import com.example.retrofitpractice.models.RetrofitClient
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    var txtData: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtData = findViewById(R.id.txtData)
        getUserList()
    }


    private fun getUserList() {
        //TODO("Not yet implemented")


        var retrofit = RetrofitClient.getInstance()
        var apiInterface = retrofit.create(ApiInterface::class.java)


        try {
            val response = apiInterface.getAllUsers()


            if (response.isSuccessful) {
                //your code for handaling success response


                var json = Gson().toJson(response.body())
                if (response.body()?.data?.size!! <= 0) {
                    Toast.makeText(
                        this@MainActivity,
                        "No Data ",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    txtData?.text = json
                }
            } else {
                Toast.makeText(
                    this@MainActivity,
                    response.errorBody().toString(),
                    Toast.LENGTH_LONG
                ).show()
            }
        } catch (Ex: Exception) {
            Log.e("Error", Ex.localizedMessage)
        }

    }
}



