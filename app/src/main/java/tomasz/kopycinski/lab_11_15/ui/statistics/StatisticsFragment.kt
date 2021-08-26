package tomasz.kopycinski.lab_11_15.ui.statistics

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import tomasz.kopycinski.lab_11_15.R
import tomasz.kopycinski.lab_11_15.databinding.FragmentStatisticsBinding
import tomasz.kopycinski.lab_11_15.persistence.RefuellingHeader

class StatisticsFragment : Fragment() {
    private var _binding: FragmentStatisticsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: StatisticsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStatisticsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.avg30Consumption.observe(viewLifecycleOwner, {
            binding.day30Consumption.text = getString(R.string.liters, it)
        })
        viewModel.avg120Consumption.observe(viewLifecycleOwner, {
            binding.day120Consumption.text = getString(R.string.liters, it)
        })
        viewModel.avg365Consumption.observe(viewLifecycleOwner, {
            binding.day365Consumption.text = getString(R.string.liters, it)
        })
        viewModel.minConsumption.observe(viewLifecycleOwner, {
            binding.minConsumption.text = getString(R.string.liters, it)
        })
        viewModel.maxConsumption.observe(viewLifecycleOwner, {
            binding.maxConsumption.text = getString(R.string.liters, it)
        })
        viewModel.favouritePlace.observe(viewLifecycleOwner, {
            binding.favouritePlace.text = it
        })
        viewModel.allRefuellings.observe(viewLifecycleOwner, {
            val refuellingsGroupedByMonth = it.groupBy { refuelling -> Pair(refuelling.date.monthValue, refuelling.date.year) }
            var moneySum = 0.0
            var divider = 0

            for ((_, refuellings) in refuellingsGroupedByMonth) {
                divider++
                var monthPrice = 0.0

                for (refuelling in refuellings) {
                    monthPrice += refuelling.price
                }
                moneySum+=monthPrice
            }
            val averagePrice = moneySum / divider
            binding.averageExpenses.text = getString(R.string.currency, averagePrice)
        })
    }
}