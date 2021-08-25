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
import java.time.LocalDate

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
            viewModel.localDate.dayOfMonth,
            viewModel.localDate.monthValue,
            viewModel.localDate.year))

        binding.dateInput.setOnClickListener {
            val datePickerDialog = DatePickerDialog(
                requireContext(),this,
                viewModel.localDate.year,
                viewModel.localDate.monthValue,
                viewModel.localDate.dayOfMonth)
            datePickerDialog.show()
        }

        binding.saveButton.setOnClickListener {
            val price = binding.priceInput.text.toString().toDouble()
            val pricePerLiter = binding.pricePerLiterInput.text.toString().toDouble()
            val place = binding.placeInput.text.toString()
            val mileage = binding.mileageInput.text.toString().toInt()

            val refuelling = Refueling(navArgs.vehicleId, viewModel.localDate, price, pricePerLiter, place, mileage)
            viewModel.insertRefuelling(refuelling)
        }
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        viewModel.localDate = LocalDate.of(year, month, dayOfMonth)
        binding.dateInput.setText(getString(R.string.date_format, dayOfMonth, month, year))
    }
}