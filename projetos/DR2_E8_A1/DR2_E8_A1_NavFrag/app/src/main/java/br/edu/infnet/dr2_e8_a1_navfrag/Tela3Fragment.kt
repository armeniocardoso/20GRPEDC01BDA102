package br.edu.infnet.dr2_e8_a1_navfrag

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class Tela3Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_tela3, container, false)
        val frase = arguments?.get("frase").toString()
        val titulo = view.findViewById<TextView>(R.id.tela3Titulo)
        titulo.setText(titulo.text.toString() + "\n" + frase)
        return view
    }
}
