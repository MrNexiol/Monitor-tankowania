package tomasz.kopycinski.lab_11_15.ui.vehicleCreate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import tomasz.kopycinski.lab_11_15.databinding.FragmentVehicleCreateBinding
import tomasz.kopycinski.lab_11_15.persistence.entity.Vehicle

class VehicleCreateFragment : Fragment() {
    private var _binding: FragmentVehicleCreateBinding? = null
    private val binding get() = _binding!!
    private val viewModel: VehicleCreateViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentVehicleCreateBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addVehicleButton.setOnClickListener {
            val brand = binding.brandInput.text.toString()
            val model = binding.modelInput.text.toString()
            val plateNumber = binding.plateNumberInput.text.toString()

            if (brand.isBlank() || model.isBlank() || plateNumber.isBlank()) {
                Toast.makeText(context, "Pusto!", Toast.LENGTH_LONG).show()
            } else {
                val vehicle = Vehicle(brand, model, plateNumber, System.currentTimeMillis())
                viewModel.insertVehicle(vehicle)
                Toast.makeText(context, "Done", Toast.LENGTH_LONG).show()
            }
        }
    }
}