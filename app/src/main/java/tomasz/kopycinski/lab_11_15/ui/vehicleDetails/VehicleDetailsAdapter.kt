package tomasz.kopycinski.lab_11_15.ui.vehicleDetails

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import tomasz.kopycinski.lab_11_15.R
import tomasz.kopycinski.lab_11_15.databinding.RefuellingHeaderRecyclerViewBinding
import tomasz.kopycinski.lab_11_15.databinding.RefuellingRecyclerItemBinding
import tomasz.kopycinski.lab_11_15.databinding.VehicleDetailsTopBinding
import tomasz.kopycinski.lab_11_15.persistence.RefuellingHeader
import tomasz.kopycinski.lab_11_15.persistence.entity.Refueling
import tomasz.kopycinski.lab_11_15.persistence.entity.Vehicle
import java.time.format.DateTimeFormatter

const val VEHICLE_TOP_HOLDER = 0
const val HEADER_VIEW_HOLDER = 1
const val REFUELLING_VIEW_HOLDER = 2

class VehicleDetailsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var data: List<Any> = listOf()

    class VehicleViewHolder(
        val binding: VehicleDetailsTopBinding) : RecyclerView.ViewHolder(binding.root)

    class HeaderViewHolder(
        val binding: RefuellingHeaderRecyclerViewBinding) : RecyclerView.ViewHolder(binding.root)

    class RefuellingViewHolder(
        val binding: RefuellingRecyclerItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VEHICLE_TOP_HOLDER -> {
                val binding = VehicleDetailsTopBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false)
                VehicleViewHolder(binding)
            }
            HEADER_VIEW_HOLDER -> {
                val binding = RefuellingHeaderRecyclerViewBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false)
                HeaderViewHolder(binding)
            }
            else -> {
                val binding = RefuellingRecyclerItemBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false)
                RefuellingViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is VehicleViewHolder -> {
                val item = data[position] as Vehicle
                holder.binding.brand.text = item.brand
                holder.binding.model.text = item.model
                holder.binding.plateNumber.text = item.licensePlate
            }
            is RefuellingViewHolder -> {
                val item = data[position] as Refueling
                holder.binding.dateTextView.text = item.date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
                holder.binding.placeTextView.text = item.place
                holder.binding.priceTextView.text = holder.binding.root.resources.getString(R.string.currency, item.price)

                holder.binding.root.setOnClickListener {
                    val action = VehicleDetailsFragmentDirections.actionVehicleDetailsFragmentToRefuellingDetailsFragment(item.uid)
                    holder.binding.root.findNavController().navigate(action)
                }
            }
            is HeaderViewHolder -> {
                val item = data[position] as RefuellingHeader
                holder.binding.headerTitle.text = item.title
                holder.binding.headerPrice.text = holder.binding.root.resources.getString(R.string.currency, item.price)
            }
            else -> {}
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun getItemViewType(position: Int): Int {
        return when(data[position]) {
            is Refueling -> REFUELLING_VIEW_HOLDER
            is RefuellingHeader -> HEADER_VIEW_HOLDER
            is Vehicle -> VEHICLE_TOP_HOLDER
            else -> -1
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<Any>) {
        this.data = data
        notifyDataSetChanged()
    }
}