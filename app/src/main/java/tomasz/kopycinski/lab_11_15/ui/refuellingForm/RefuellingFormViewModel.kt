package tomasz.kopycinski.lab_11_15.ui.refuellingForm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import tomasz.kopycinski.lab_11_15.AppContainer
import tomasz.kopycinski.lab_11_15.persistence.entity.Refueling
import java.time.LocalDate

class RefuellingFormViewModel(refuellingId: Int) : ViewModel() {
    var localDate: LocalDate = LocalDate.now()
    var isEditing = false

    val refuelling = AppContainer.repository.getRefuelling(refuellingId)

    fun insertRefuelling(refueling: Refueling) = viewModelScope.launch {
        AppContainer.repository.insertRefuelling(refueling)
    }

    fun updateRefuelling(refueling: Refueling) = viewModelScope.launch {
        AppContainer.repository.updateRefuelling(refueling)
    }
}