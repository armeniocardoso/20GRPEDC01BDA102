package br.edu.infnet.tabtest2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {

        lateinit var fragment : Fragment
        when(position) {

            0 -> fragment = FornecedoresFragment()
            1 -> fragment = ContatosFragment()
            2 -> fragment = ProdutosFragment()
        }
        return fragment
    }
}
