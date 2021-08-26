package tomasz.kopycinski.lab_11_15.ui.statistics

import androidx.lifecycle.ViewModel
import tomasz.kopycinski.lab_11_15.AppContainer
import java.time.LocalDate

class StatisticsViewModel : ViewModel() {
    private val localDate = LocalDate.now()

    val avg30Consumption = AppContainer.repository.getAvgRefuellingConsumptionFromDate(localDate.minusDays(30))
    val avg120Consumption = AppContainer.repository.getAvgRefuellingConsumptionFromDate(localDate.minusDays(120))
    val avg365Consumption = AppContainer.repository.getAvgRefuellingConsumptionFromDate(localDate.minusDays(365))
    val minConsumption = AppContainer.repository.getMinRefuellingConsumption()
    val maxConsumption = AppContainer.repository.getMaxRefuellingConsumption()
    val favouritePlace = AppContainer.repository.getFavouriteRefuellingPlace()
}