package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener{
            calculateLoan()
        }
    }

    private fun calculateLoan(){
        /*if(editTextCarPrice.text.isEmpty()){
           editTextCarPrice.setError(getString(R.string.error))
       }*/

        val carPrice = editTextCarPrice.text.toString().toFloat()
        val downPayment = editTextDownPayment.text.toString().toInt()
        val loanPeriod = editTextLoanPeriod.text.toString().toInt()
        val interestRate = editTextInterestRate.text.toString().toFloat()

        //TODO Display the outputs
        val loan = carPrice - downPayment
        val interest = loan * interestRate * loanPeriod
        val monthlyRepayment = (loan + interest) / loanPeriod / 12
        //val currencyFormat = NumberFormat.getCurrencyInstance()

        textViewLoan.setText(getString(R.string.loan) + "${loan}")
        textViewInterest.setText(getString(R.string.interest) + "${interest}")
        textViewMonthlyRepayment.setText(getString(R.string.monthly_repayment) + "${monthlyRepayment}")
    }

    fun resetInput(view: View) {
        //TODO: Clear all inputs and outputs
    }
}
