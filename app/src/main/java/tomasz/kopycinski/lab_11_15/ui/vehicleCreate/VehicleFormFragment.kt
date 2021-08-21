package tomasz.kopycinski.lab_11_15.ui.vehicleCreate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import tomasz.kopycinski.lab_11_15.databinding.FragmentVehicleFormBinding
import tomasz.kopycinski.lab_11_15.persistence.entity.Vehicle

class VehicleFormFragment : Fragment() {
    private var _binding: FragmentVehicleFormBinding? = null
    private val binding get() = _binding!!
    private val navArgs: VehicleFormFragmentArgs by navArgs()
    private lateinit var viewModel: VehicleFormViewModel
    private lateinit var viewModelFactory: VehicleFormViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentVehicleFormBinding.inflate(layoutInflater, container, false)
        viewModelFactory = VehicleFormViewModelFactory(navArgs.vehicleId)
        viewModel = ViewModelProvider(this, viewModelFactory).get(VehicleFormViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.vehicle.observe(viewLifecycleOwner, { vehicle ->
            vehicle?.let {
                binding.brandInput.setText(vehicle.brand)
                binding.modelInput.setText(vehicle.model)
                binding.plateNumberInput.setText(vehicle.licensePlate)
            }
        })

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