package tomasz.kopycinski.lab_11_15.ui.vehicleDetails

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tomasz.kopycinski.lab_11_15.databinding.RefuellingRecyclerItemBinding
import tomasz.kopycinski.lab_11_15.persistence.entity.Refueling

class VehicleDetailsAdapter : RecyclerView.Adapter<VehicleDetailsAdapter.ViewHolder>() {
    private var data: List<Refueling> = listOf()

    class ViewHolder(
        val binding: RefuellingRecyclerItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RefuellingRecyclerItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.priceTextView.text = data[position].price.toString()
    }

    override fun getItemCount(): Int {
        return data.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<Refueling>) {
        this.data = data
        notifyDataSetChanged()
    }
}