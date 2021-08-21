package tomasz.kopycinski.lab_11_15.ui.refuellingForm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import tomasz.kopycinski.lab_11_15.R
import tomasz.kopycinski.lab_11_15.databinding.FragmentRefuellingFormBinding

class RefuellingForm : Fragment() {
    private var _binding: FragmentRefuellingFormBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRefuellingFormBinding.inflate(inflater, container, false)
        return binding.root
    }
}