package tomasz.kopycinski.lab_11_15.ui.refuellingForm

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.fragment.app.viewModels
import tomasz.kopycinski.lab_11_15.R
import tomasz.kopycinski.lab_11_15.databinding.FragmentRefuellingFormBinding

class RefuellingFormFragment : Fragment(), DatePickerDialog.OnDateSetListener {
    private var _binding: FragmentRefuellingFormBinding? = null
    private val binding get() = _binding!!
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

        binding.dateInput.setText(getString(R.string.date_format, viewModel.day, viewModel.month, viewModel.year))

        binding.dateInput.setOnClickListener {
            val datePickerDialog = DatePickerDialog(requireContext(), this, viewModel.year, viewModel.month, viewModel.day)
            datePickerDialog.show()
        }
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        viewModel.day = dayOfMonth
        viewModel.month = month
        viewModel.year = year
        binding.dateInput.setText(getString(R.string.date_format, dayOfMonth, month, year))
    }
}