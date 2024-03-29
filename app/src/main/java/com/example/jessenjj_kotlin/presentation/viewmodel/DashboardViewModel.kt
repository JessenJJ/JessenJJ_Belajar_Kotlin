package com.example.jessenjj_kotlin.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jessenjj_kotlin.R
import com.example.jessenjj_kotlin.data.remote.MenuDashboardRemoteDataSource
import com.example.jessenjj_kotlin.model.AccountNumberModel
import com.example.jessenjj_kotlin.model.MenuDashboardModel
import com.example.jessenjj_kotlin.model.MenuDashboardResponse
import com.example.jessenjj_kotlin.model.PromoModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val menuDashboardRemoteDataSource: MenuDashboardRemoteDataSource
) : ViewModel() {

    private val _homeAccount = MutableLiveData<List<AccountNumberModel>>()
    private val _homePromo = MutableLiveData<List<PromoModel>>()

    // menggunakan _ menunjukkan variabel private
    //_homeMenu menampung semua logic dari MutableLiveData<>, bersifat private karena menampung semua logic, sebagai setter
    private val _homeMenu = MutableLiveData<MenuDashboardResponse>()

    // homeMenu hanya akan berisi return value dari logic MutableLiveData<>, sebagai getter
    val homeMenu: LiveData<MenuDashboardResponse> get() = _homeMenu

    // sebagai setter
    private val _homeMenuError = MutableLiveData<String>()
    // sebagai getter
    val homeMenuError: LiveData<String> get() = _homeMenuError


    val homeAccount: LiveData<List<AccountNumberModel>>
        get() = _homeAccount

    val homePromo: LiveData<List<PromoModel>>
        get() = _homePromo

    // isi data homeMenu
    fun getHomeMenu( ) = viewModelScope.launch(Dispatchers.IO){
        menuDashboardRemoteDataSource.getMenuDashboard().let{
            if (it.isSuccessful) {
                _homeMenu.postValue(it.body())
            } else {
                _homeMenuError.postValue(it.message())
            }
        }
    }

    private fun populateDataMenu(): List<MenuDashboardModel> {
        return listOf(
            MenuDashboardModel(
                image = R.drawable.baseline_message_24,
                menuName = "Transfer",
            ),
            MenuDashboardModel(
                image = R.drawable.baseline_shopping_cart_24,
                menuName = "Pembelian",
            ),
            MenuDashboardModel(
                image = R.drawable.baseline_payment_24,
                menuName = "Pembayaran",
            ),
            MenuDashboardModel(
                image = R.drawable.baseline_payments_24,
                menuName = "Cardless",
            ),
            MenuDashboardModel(
                image = R.drawable.baseline_history_24,
                menuName = "History Pembayaran",
            ),
            MenuDashboardModel(
                image = R.drawable.baseline_currency_exchange_24,
                menuName = "Mutasi Rekening",
            ),
            MenuDashboardModel(
                image = R.drawable.baseline_access_time_24,
                menuName = "Jadwal Sholat",
            ),

            )
    }

    private fun populateDataAccount(): List<AccountNumberModel>{
        return listOf(
            AccountNumberModel(
                savingType = "Tahapan Mudarabah",
                numberRekening = "02141005",
                balanceAmount = 458659743
            ),
            AccountNumberModel(
                savingType = "Tahapan Mudarabah2",
                numberRekening = "02141325",
                balanceAmount = 1242647653
            ),
            AccountNumberModel(
                savingType = "Tahapan Mudarabah3",
                numberRekening = "021410012",
                balanceAmount = 345746352
            ),

            )
    }



    private fun populateDataPromo():List<PromoModel>{
        return listOf(
            PromoModel(
                image = R.drawable.kpr1
            ),
            PromoModel(
                image = R.drawable.kpr2
            ),
            PromoModel(
                image = R.drawable.emas
            ),
            PromoModel(
                image = R.drawable.kkb
            ),
            PromoModel(
                image = R.drawable.kpr3
            ),
        )
    }


    fun getAccountMenu() = viewModelScope.launch(Dispatchers.IO){
        _homeAccount.postValue(populateDataAccount())
    }

    fun getPromoMenu() = viewModelScope.launch (Dispatchers.IO){
        _homePromo.postValue(populateDataPromo())
    }

}