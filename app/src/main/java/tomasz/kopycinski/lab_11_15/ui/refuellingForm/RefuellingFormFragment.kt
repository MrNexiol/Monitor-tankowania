package tomasz.kopycinski.lab_11_15.ui.refuellingForm

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import tomasz.kopycinski.lab_11_15.R
import tomasz.kopycinski.lab_11_15.databinding.FragmentRefuellingFormBinding
import tomasz.kopycinski.lab_11_15.persistence.entity.Refueling
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class RefuellingFormFragment : Fragment(), DatePickerDialog.OnDateSetListener {
    private var _binding: FragmentRefuellingFormBinding? = null
    private val binding get() = _binding!!
    private val navArgs: RefuellingFormFragmentArgs by navArgs()
    private lateinit var refuellingToEdit: Refueling
    private lateinit var viewModel: RefuellingFormViewModel
    private lateinit var viewModelFactory: RefuellingFormViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRefuellingFormBinding.inflate(inflater, container, false)

        viewModelFactory = RefuellingFormViewModelFactory(navArgs.refuellingId)
        viewModel = ViewModelProvider(this, viewModelFactory).get(RefuellingFormViewModel::class.java)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.dateInput.setText(viewModel.localDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")))

        viewModel.refuelling.observe(viewLifecycleOwner, {
            if (it != null) {
                refuellingToEdit = it
                binding.priceInput.setText(it.price.toString())
                binding.pricePerLiterInput.setText(it.pricePerLiter.toString())
                binding.mileageInput.setText(it.mileage.toString())
                binding.consumptionInput.setText(it.consumption.toString())
                binding.placeInput.setText(it.place)
                binding.dateInput.setText(it.date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")))
                viewModel.localDate = it.date
                viewModel.isEditing = true
            }
        })

        binding.dateInput.setOnClickListener {
            val datePickerDialog = DatePickerDialog(
                requireContext(),this,
                viewModel.localDate.year,
                viewModel.localDate.monthValue-1,
                viewModel.localDate.dayOfMonth)
            datePickerDialog.show()
        }

        binding.saveButton.setOnClickListener {
            val price = binding.priceInput.text.toString().toDouble()
            val pricePerLiter = binding.pricePerLiterInput.text.toString().toDouble()
            val mileage = binding.mileageInput.text.toString().toInt()
            val consumption = binding.consumptionInput.text.toString().toDouble()
            val place = binding.placeInput.text.toString()

            if (viewModel.isEditing) {
                refuellingToEdit.price = price
                refuellingToEdit.pricePerLiter = pricePerLiter
                refuellingToEdit.mileage = mileage
                refuellingToEdit.consumption = consumption
                refuellingToEdit.place = place
                refuellingToEdit.date = viewModel.localDate
                viewModel.updateRefuelling(refuellingToEdit)
            } else {
                val refuellingToInsert = Refueling(navArgs.vehicleId, viewModel.localDate, price, pricePerLiter, place, mileage, consumption)
                viewModel.insertRefuelling(refuellingToInsert)
            }
            findNavController().navigateUp()
        }
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        viewModel.localDate = LocalDate.of(year, month+1, dayOfMonth)
        binding.dateInput.setText(getString(R.string.date_format, dayOfMonth, month, year))
    }
}