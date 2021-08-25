package tomasz.kopycinski.lab_11_15.ui.vehicleDetails

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import tomasz.kopycinski.lab_11_15.R
import tomasz.kopycinski.lab_11_15.databinding.FragmentVehicleDetailsBinding
import tomasz.kopycinski.lab_11_15.persistence.entity.Vehicle

class VehicleDetailsFragment : Fragment() {
    private var _binding: FragmentVehicleDetailsBinding? = null
    private val binding get() = _binding!!
    private val navArgs: VehicleDetailsFragmentArgs by navArgs()
    private val adapter: VehicleDetailsAdapter = VehicleDetailsAdapter()
    private lateinit var vehicle: Vehicle
    private lateinit var viewModel: VehicleDetailsViewModel
    private lateinit var viewModelFactory: VehicleDetailsViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVehicleDetailsBinding.inflate(inflater, container, false)

        viewModelFactory = VehicleDetailsViewModelFactory(navArgs.vehicleId)
        viewModel = ViewModelProvider(this, viewModelFactory).get(VehicleDetailsViewModel::class.java)

        binding.refuellingsRecyclerView.adapter = adapter
        binding.refuellingsRecyclerView.layoutManager = LinearLayoutManager(context)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.vehicle.observe(viewLifecycleOwner, {
            vehicle = it
            binding.brand.text = it.brand
            binding.model.text = it.model
            binding.licensePlate.text = it.licensePlate
            binding.checkDate.text = it.date.toString()
        })

        viewModel.refuellings.observe(viewLifecycleOwner, {
            val refuellingsList = mutableListOf<Any>()
            var currentMonth = 0

            for (refuelling in it) {
                if (refuelling.date.monthValue != currentMonth) {
                    currentMonth = refuelling.date.monthValue
                    val item = "${resources.getStringArray(R.array.months)[currentMonth]} ${refuelling.date.year}"
                    refuellingsList.add(item)
                }
                refuellingsList.add(refuelling)
            }

            adapter.setData(refuellingsList)
        })

        binding.addRefuellingButton.setOnClickListener {
            val action = VehicleDetailsFragmentDirections.actionVehicleDetailsFragmentToRefuellingForm(navArgs.vehicleId)
            findNavController().navigate(action)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.vehicle_details_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.edit_vehicle -> {
                val action = VehicleDetailsFragmentDirections.actionVehicleDetailsFragmentToVehicleFormFragment(vehicle.uid)
                findNavController().navigate(action)
                true
            }
            R.id.remove_vehicle -> {
                vehicle.let {
                    viewModel.deleteVehicle(it)
                    findNavController().navigateUp()
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}