package tomasz.kopycinski.lab_11_15.ui.vehicleList

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import tomasz.kopycinski.lab_11_15.databinding.VehicleRecyclerItemBinding
import tomasz.kopycinski.lab_11_15.persistence.entity.Vehicle

class VehicleListAdapter : RecyclerView.Adapter<VehicleListAdapter.ViewHolder>() {
    private var data: List<Vehicle> = listOf()

    class ViewHolder(
        val binding: VehicleRecyclerItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = VehicleRecyclerItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.vehicleBrand.text = data[position].brand
        holder.binding.vehicleModel.text = data[position].model
        holder.binding.vehiclePlate.text = data[position].licensePlate

        holder.binding.root.setOnClickListener {
            val action = VehicleListFragmentDirections.actionVehicleFragmentToVehicleDetailsFragment(data[position].uid)
            it.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<Vehicle>) {
        this.data = data
        notifyDataSetChanged()
    }
}