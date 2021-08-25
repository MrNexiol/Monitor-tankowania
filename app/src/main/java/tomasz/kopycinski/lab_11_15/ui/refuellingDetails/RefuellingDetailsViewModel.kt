package tomasz.kopycinski.lab_11_15.ui.refuellingDetails

import androidx.lifecycle.ViewModel
import tomasz.kopycinski.lab_11_15.AppContainer

class RefuellingDetailsViewModel(refuellingId: Int) : ViewModel() {
    val refuelling = AppContainer.repository.getRefuelling(refuellingId)
}