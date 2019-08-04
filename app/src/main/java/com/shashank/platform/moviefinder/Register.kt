package com.shashank.platform.moviefinder

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.shashank.platform.moviefinder.R
import kotlinx.android.synthetic.main.activity_register.*
import org.apache.commons.validator.routines.EmailValidator

class Register : AppCompatActivity(), ConnectivityReceiver.ConnectivityReceiverListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        checkConnection()
        sign_up.setOnClickListener {
            firstname_til.error = null
            lastname_til.error = null
            email_til.error = null
            password_til.error = null
            retype_password_til.error = null
            contact_til.error = null
            if (firstname.text.toString().equals(""))
                firstname_til.error = "First name cannot be empty!"
            else if (lastname.text.toString().equals(""))
                lastname_til.error = "Last name cannot be empty!"
            else if (password.text.toString().equals(""))
                password_til.error = "Password cannot be empty!"
            else if (retype_password.text.toString().equals(""))
                retype_password_til.error = "Password cannot be empty!"
            else if (!EmailValidator.getInstance().isValid(email.text.toString()))
                email_til.error = "Email address not valid!"
            else if (password.text.toString().length < 8)
                password_til.error = "Password must have at least 8 characters!"
            else if (retype_password.text.toString().length < 8)
                retype_password_til.error = "Password must have at least 8 characters!"
            else if (!retype_password.text.toString().equals(password.text.toString()))
                retype_password_til.error = "Your passwords don't match!"
            else if (contact.text.toString().equals(""))
                contact_til.error = "Contact no. cannot be empty!"
            else if (contact.text.toString().length < 10)
                contact_til.error = "Contact no. is not valid!"
            else {
                if (checkConnection()) {
                    Toast.makeText(applicationContext,"Registered Successful",Toast.LENGTH_SHORT).show()
                    val intent = Intent(applicationContext, Login::class.java)
                    startActivity(intent)
                }

            }

        }
        sign_in.setOnClickListener {
            finish()
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
