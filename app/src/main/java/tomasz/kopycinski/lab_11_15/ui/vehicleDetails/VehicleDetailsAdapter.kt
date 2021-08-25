package tomasz.kopycinski.lab_11_15.ui.vehicleDetails

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tomasz.kopycinski.lab_11_15.R
import tomasz.kopycinski.lab_11_15.databinding.RefuellingHeaderRecyclerViewBinding
import tomasz.kopycinski.lab_11_15.databinding.RefuellingRecyclerItemBinding
import tomasz.kopycinski.lab_11_15.persistence.RefuellingHeader
import tomasz.kopycinski.lab_11_15.persistence.entity.Refueling
import java.time.format.DateTimeFormatter

const val HEADER_VIEW_HOLDER = 0
const val REFUELLING_VIEW_HOLDER = 1

class VehicleDetailsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var data: List<Any> = listOf()

    class HeaderViewHolder(
        val binding: RefuellingHeaderRecyclerViewBinding) : RecyclerView.ViewHolder(binding.root)

    class RefuellingViewHolder(
        val binding: RefuellingRecyclerItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == HEADER_VIEW_HOLDER) {
            val binding = RefuellingHeaderRecyclerViewBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            HeaderViewHolder(binding)
        } else {
            val binding = RefuellingRecyclerItemBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            RefuellingViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is RefuellingViewHolder -> {
                val item = data[position] as Refueling
                holder.binding.dateTextView.text = item.date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
                holder.binding.placeTextView.text = item.place
                holder.binding.priceTextView.text = holder.binding.root.resources.getString(R.string.currency, item.price)
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
        return if (data[position] is Refueling) REFUELLING_VIEW_HOLDER else HEADER_VIEW_HOLDER
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<Any>) {
        this.data = data
        notifyDataSetChanged()
    }
}