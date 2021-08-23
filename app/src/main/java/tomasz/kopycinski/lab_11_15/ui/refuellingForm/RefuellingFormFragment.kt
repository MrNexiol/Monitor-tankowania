package tomasz.kopycinski.lab_11_15.ui.refuellingForm

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import tomasz.kopycinski.lab_11_15.R
import tomasz.kopycinski.lab_11_15.databinding.FragmentRefuellingFormBinding
import tomasz.kopycinski.lab_11_15.persistence.entity.Refueling
import java.util.*

class RefuellingFormFragment : Fragment(), DatePickerDialog.OnDateSetListener {
    private var _binding: FragmentRefuellingFormBinding? = null
    private val binding get() = _binding!!
    private val navArgs: RefuellingFormFragmentArgs by navArgs()
    private val viewModel: RefuellingFormViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRefuellingFormBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.dateInput.setText(
            getString(R.string.date_format,
            viewModel.calendar.get(Calendar.DAY_OF_MONTH),
            viewModel.calendar.get(Calendar.MONTH),
            viewModel.calendar.get(Calendar.YEAR)))

        binding.dateInput.setOnClickListener {
            val datePickerDialog = DatePickerDialog(
                requireContext(),this,
                viewModel.calendar.get(Calendar.YEAR),
                viewModel.calendar.get(Calendar.MONTH),
                viewModel.calendar.get(Calendar.DAY_OF_MONTH))
            datePickerDialog.show()
        }

        binding.saveButton.setOnClickListener {
            val price = binding.priceInput.text.toString().toDouble()
            val pricePerLiter = binding.pricePerLiterInput.text.toString().toDouble()
            val place = binding.placeInput.text.toString()
            val mileage = binding.mileageInput.text.toString().toInt()
            val date: Date = viewModel.calendar.time

            val refuelling = Refueling(navArgs.vehicleId, date, price, pricePerLiter, place, mileage)
            viewModel.insertRefuelling(refuelling)
        }
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        viewModel.calendar.set(Calendar.YEAR, year)
        viewModel.calendar.set(Calendar.MONTH, month)
        viewModel.calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
        binding.dateInput.setText(getString(R.string.date_format, dayOfMonth, month, year))
    }
}