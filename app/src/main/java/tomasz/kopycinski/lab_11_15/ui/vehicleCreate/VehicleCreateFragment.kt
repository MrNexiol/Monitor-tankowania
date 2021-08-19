package tomasz.kopycinski.lab_11_15.ui.vehicleCreate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import tomasz.kopycinski.lab_11_15.databinding.FragmentVehicleCreateBinding

class VehicleCreateFragment : Fragment() {
    private var _binding: FragmentVehicleCreateBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVehicleCreateBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}