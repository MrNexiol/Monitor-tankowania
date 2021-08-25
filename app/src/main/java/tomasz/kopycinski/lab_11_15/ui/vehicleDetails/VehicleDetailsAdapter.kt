package tomasz.kopycinski.lab_11_15.ui.vehicleDetails

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tomasz.kopycinski.lab_11_15.databinding.RefuellingHeaderRecyclerViewBinding
import tomasz.kopycinski.lab_11_15.databinding.RefuellingRecyclerItemBinding
import tomasz.kopycinski.lab_11_15.persistence.entity.Refueling

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
        if (holder is RefuellingViewHolder) {
            holder.binding.priceTextView.text = (data[position] as Refueling).date.toString()
        } else {
            holder as HeaderViewHolder
            holder.binding.refuellingHeader.text = (data[position] as String)
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