package tomasz.kopycinski.lab_11_15.ui.vehicleList

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import tomasz.kopycinski.lab_11_15.R
import tomasz.kopycinski.lab_11_15.databinding.FragmentVehicleBinding

class VehicleListFragment : Fragment() {
    private var _binding: FragmentVehicleBinding? = null
    private val binding get() = _binding!!
    private val viewModel: VehicleListFragmentViewModel by viewModels()
    private val adapter = VehicleListAdapter()
    private val layoutManager = LinearLayoutManager(context)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentVehicleBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.vehiclesRecycler.adapter = adapter
        binding.vehiclesRecycler.layoutManager = layoutManager

        viewModel.vehicleList.observe(viewLifecycleOwner, {
            adapter.setData(it)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.vehicle_list_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.action_add -> {
                val action = VehicleListFragmentDirections.actionVehicleFragmentToVehicleCreateFragment()
                findNavController().navigate(action)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}