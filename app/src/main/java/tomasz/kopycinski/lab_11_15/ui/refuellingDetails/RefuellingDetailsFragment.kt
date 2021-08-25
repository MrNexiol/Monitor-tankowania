package tomasz.kopycinski.lab_11_15.ui.refuellingDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import tomasz.kopycinski.lab_11_15.R
import tomasz.kopycinski.lab_11_15.databinding.FragmentRefuellingDetailsBinding
import java.time.format.DateTimeFormatter

class RefuellingDetailsFragment : Fragment() {
    private var _binding: FragmentRefuellingDetailsBinding? = null
    private val binding get() = _binding!!
    private val navArgs: RefuellingDetailsFragmentArgs by navArgs()
    private lateinit var viewModel: RefuellingDetailsViewModel
    private lateinit var viewModelFactory: RefuellingDetailsViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRefuellingDetailsBinding.inflate(inflater, container, false)

        viewModelFactory = RefuellingDetailsViewModelFactory(navArgs.refuellingId)
        viewModel = ViewModelProvider(this, viewModelFactory).get(RefuellingDetailsViewModel::class.java)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.refuelling.observe(viewLifecycleOwner, { refuelling ->
            binding.refuellingPrice.text = getString(R.string.currency, refuelling.price)
            binding.refuellingPricePerLiter.text = getString(R.string.currency, refuelling.pricePerLiter)
            binding.refuellingConsumption.text = refuelling.consumption.toString()
            binding.refuellingMileage.text = getString(R.string.distance_unit, refuelling.mileage)
            binding.refuellingPlace.text = refuelling.place
            binding.refuellingDate.text = refuelling.date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
            binding.refuellingDistance.text = getString(R.string.distance_unit, refuelling.distanceSinceRefuelled)
        })
    }
}