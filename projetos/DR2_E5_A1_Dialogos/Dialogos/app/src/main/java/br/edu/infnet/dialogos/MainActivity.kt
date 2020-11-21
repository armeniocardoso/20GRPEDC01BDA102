package br.edu.infnet.dialogos

import android.app.DatePickerDialog
import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.util.Log.*
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener,
    DialogInterface.OnClickListener, DatePickerDialog.OnDateSetListener {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAlertDialog = this.findViewById<Button>(R.id.btnAlertDialog)
        btnAlertDialog.setOnClickListener(this)

        val btnProgressBar = this.findViewById<Button>(R.id.btnProgressBar)
        btnProgressBar.setOnClickListener(this)

        val btnDatePicker = this.findViewById<Button>(R.id.btnDatePicker)
        btnDatePicker.setOnClickListener(this)

        val btnSnackBar = this.findViewById<Button>(R.id.btnSnackBar)
        btnSnackBar.setOnClickListener(this)
    }

    override fun onClick(view: View?) {

        val button = view as Button
        when(button.text) {

            "AlertDialog" -> alertDialogTest()
            "ProgressBar" -> progressBarTest()
            "DatePicker" -> datePickerTest()
            "SnackBar" -> snackBarTest()
            //Botão do Snackbar
            "Clique Aqui" -> Toast.makeText(this, "Snack Bar clicado", Toast.LENGTH_SHORT).show()
        }
    }

    //----------------------------------------------------------------------------------------------
    //Testes do AlertDialog
    private fun alertDialogTest() {

        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Teste")
        alertDialog.setMessage("Esta é uma mensagem de alerta bem simples")
        alertDialog.setNegativeButton("Nada Bem", this)
        alertDialog.setPositiveButton("Tudo Bem", this)
        alertDialog.setCancelable(false) //diálogo "modal"
        alertDialog.show()
    }

    override fun onClick(dialog: DialogInterface?, indiceBotao: Int) {

        val alertDialog = dialog as AlertDialog
        val texto = alertDialog.getButton(indiceBotao).text
        Toast.makeText(this, "Botão $texto Clicado", Toast.LENGTH_SHORT).show()
    }
    //----------------------------------------------------------------------------------------------

    //----------------------------------------------------------------------------------------------
    //Testes do ProgressBar
    private fun progressBarTest() {

        val prgProgressBar = this.findViewById<ProgressBar>(R.id.prgProgressBar)
        val lblProgressBar = this.findViewById<TextView>(R.id.lblProgressBar)
        Thread(Runnable {

            for (i in 0..100) {

                this@MainActivity.runOnUiThread(Runnable {

                    prgProgressBar.progress = i
                    lblProgressBar.text = i.toString() + "%"
                })
                Thread.sleep(200)
            }
        }).start()
    }
    //----------------------------------------------------------------------------------------------

    //----------------------------------------------------------------------------------------------
    //Testes do DatePicker
    private fun datePickerTest() {

        val calendar = Calendar.getInstance()
        val dia = calendar.get(Calendar.DAY_OF_MONTH)
        val mes = calendar.get(Calendar.MONTH)
        val ano = calendar.get(Calendar.YEAR)

        val datePicker = DatePickerDialog(this, this, ano, mes, dia).show()
    }

    override fun onDateSet(datePicker: DatePicker?, ano: Int, mes: Int, dia: Int) {

        Toast.makeText(this, "Data Selecionada = $dia/${mes+1}/$ano", Toast.LENGTH_SHORT).show()
    }
    //----------------------------------------------------------------------------------------------

    //----------------------------------------------------------------------------------------------
    //Testes de Snackbar
    private fun snackBarTest() {

        val snackBar = Snackbar
            .make(this.findViewById(R.id.pnlMain), "Teste de Snack Bar", Snackbar.LENGTH_INDEFINITE)
            .setActionTextColor(Color.WHITE)
            .setAction("Clique Aqui", this)
            .show()
    }
    //----------------------------------------------------------------------------------------------
}


















