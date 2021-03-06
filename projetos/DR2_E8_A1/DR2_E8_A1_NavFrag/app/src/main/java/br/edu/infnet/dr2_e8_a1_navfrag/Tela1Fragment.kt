package br.edu.infnet.dr2_e8_a1_navfrag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class Tela1Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_tela1, container, false)
        val btnTela2 = view.findViewById<Button>(R.id.btnTela2)
        btnTela2.setOnClickListener {

            val bundle = Bundle()
            bundle.putString("frase", "Instituto Infnet")

            val navController = findNavController()
            navController.navigate(R.id.action_tela1Fragment_to_tela2Fragment, bundle)
        }
        val btnTela3 = view.findViewById<Button>(R.id.btnTela3)
        btnTela3.setOnClickListener {

            val bundle = Bundle()
            bundle.putString("frase", "Rio de Janeiro")

            val navController = findNavController()
            navController.navigate(R.id.action_tela1Fragment_to_tela3Fragment, bundle)
        }
        return view
    }
}
