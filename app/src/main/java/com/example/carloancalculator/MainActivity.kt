package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat
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
        if(editTextCarPrice.text.isEmpty()){
           editTextCarPrice.setError(getString(R.string.error))

        }else if(editTextDownPayment.text.isEmpty()){
            editTextDownPayment.setError(getString(R.string.error))

        }else if(editTextInterestRate.text.isEmpty()){
            editTextInterestRate.setError(getString(R.string.error))

        }else if(editTextLoanPeriod.text.isEmpty()){
            editTextLoanPeriod.setError(getString(R.string.error))

        }else if(editTextLoanPeriod.text.toString().toInt() > 9 || editTextLoanPeriod.text.toString().toInt() < 0){
            editTextLoanPeriod.setError(getString(R.string.error_loan))

        }else if(editTextDownPayment.text.toString().toInt() > editTextCarPrice.text.toString().toInt()){
            editTextDownPayment.setError(getString(R.string.error_interest_rate))
        }
        else {

            val carPrice = editTextCarPrice.text.toString().toFloat()
            val downPayment = editTextDownPayment.text.toString().toInt()
            val loanPeriod = editTextLoanPeriod.text.toString().toInt()
            val interestRate = editTextInterestRate.text.toString().toFloat()

            //TODO Display the outputs
            val loan = carPrice - downPayment
            val interest = loan * interestRate * loanPeriod
            val monthlyRepayment = (loan + interest) / loanPeriod / 12
            val currency = Currency.getInstance(Locale.getDefault())

            textViewLoan.setText(getString(R.string.loan) + " " + currency + "${loan.toInt()}")
            textViewInterest.setText(getString(R.string.interest) + " " + currency + "${interest.toInt()}")
            textViewMonthlyRepayment.setText(
                getString(R.string.monthly_repayment) + " " + currency + "${"%.2f".format(
                    monthlyRepayment
                ).toFloat()}"
            )
        }
    }

    fun resetInput(view: View) {
        //TODO: Clear all inputs and outputs
        editTextCarPrice.setText("")
        editTextDownPayment.setText("")
        editTextLoanPeriod.setText("")
        editTextInterestRate.setText("")
        textViewInterest.setText(getString(R.string.interest))
        textViewLoan.setText(getString(R.string.loan))
        textViewMonthlyRepayment.setText(getString(R.string.monthly_repayment))
    }
}
