package com.shashank.platform.moviefinder

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputLayout
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.shashank.platform.moviefinder.R
import kotlinx.android.synthetic.main.activity_login.*
import org.apache.commons.validator.routines.EmailValidator

class Login : AppCompatActivity(), ConnectivityReceiver.ConnectivityReceiverListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        checkConnection()
        login.setOnClickListener {
            email_til.error = null
            password_til.error = null

            //Uncomment the below code to add validations

            /*if (email.text.toString().equals(""))
                email_til.error = "Email cannot be empty!"
            else if (password.text.toString().equals(""))
                password_til.error = "Password cannot be empty!"
            else if (!EmailValidator.getInstance().isValid(email.getText().toString()))
                email_til.error = "Email address not valid!"
            else {
                if(checkConnection()){
                    Toast.makeText(applicationContext,"Login Successful",Toast.LENGTH_SHORT).show()
                    val intent = Intent(applicationContext,Home::class.java)
                    startActivity(intent)
                }
            }*/


            if(checkConnection()){
                Toast.makeText(applicationContext,"Login Successful",Toast.LENGTH_SHORT).show()
                val intent = Intent(applicationContext,Home::class.java)
                startActivity(intent)
            }
        }
        register.setOnClickListener {
            val intent = Intent(applicationContext, Register::class.java)
            startActivity(intent)

        }
    }

    //Check internet connectivity code
    // Method to manually check connection status
    private fun checkConnection(): Boolean {
        val isConnected = ConnectivityReceiver.isConnected()
        showToast(isConnected)
        return isConnected
    }

    // Showing the status in Toast
    private fun showToast(isConnected: Boolean) {
        if (!isConnected)
            Toast.makeText(applicationContext, getString(R.string.no_connectivity), Toast.LENGTH_LONG).show()
    }

    override fun onResume() {
        super.onResume()
        // register connection status listener
        MyApp.getInstance()?.setConnectivityListener(this)
    }

    override fun onNetworkConnectionChanged(isConnected: Boolean) {
        showToast(isConnected)
    }


}
