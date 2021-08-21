package tomasz.kopycinski.lab_11_15.ui.vehicleForm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import tomasz.kopycinski.lab_11_15.R
import tomasz.kopycinski.lab_11_15.databinding.FragmentVehicleFormBinding
import tomasz.kopycinski.lab_11_15.persistence.entity.Vehicle
import java.util.*

class VehicleFormFragment : Fragment() {
    private var _binding: FragmentVehicleFormBinding? = null
    private val binding get() = _binding!!
    private val navArgs: VehicleFormFragmentArgs by navArgs()
    private var isEditing = false
    private var vehicle: Vehicle? = null
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

        viewModel.vehicle.observe(viewLifecycleOwner, {
            it?.let {
                vehicle = it
                binding.brandInput.setText(vehicle!!.brand)
                binding.modelInput.setText(vehicle!!.model)
                binding.plateNumberInput.setText(vehicle!!.licensePlate)
                isEditing = true
            }
        })

        binding.addVehicleButton.setOnClickListener {
            val brand = binding.brandInput.text.toString()
            val model = binding.modelInput.text.toString()
            val plateNumber = binding.plateNumberInput.text.toString()

            if (brand.isBlank() || model.isBlank() || plateNumber.isBlank()) {
                Toast.makeText(context, getString(R.string.empty_fields), Toast.LENGTH_LONG).show()
            } else {
                if (isEditing) {
                    vehicle!!.brand = brand
                    vehicle!!.model = model
                    vehicle!!.licensePlate = plateNumber
                    viewModel.updateVehicle(vehicle!!)
                } else {
                    val vehicleToSave = Vehicle(brand, model, plateNumber, Date(System.currentTimeMillis()))
                    viewModel.insertVehicle(vehicleToSave)
                }
            }
        }
    }
}