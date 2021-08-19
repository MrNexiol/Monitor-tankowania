package tomasz.kopycinski.lab_11_15.ui.vehicleFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import tomasz.kopycinski.lab_11_15.R
import tomasz.kopycinski.lab_11_15.databinding.FragmentVehicleBinding

class VehicleFragment : Fragment() {
    private var _binding: FragmentVehicleBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentVehicleBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}