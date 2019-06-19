package com.innovativequest.cv_app_mvp.screens.home.mvp
import android.view.View
import com.innovativequest.cv_app_mvp.models.ItemDataResponse
import io.reactivex.Observable

/**
 * Created by Ghous on 17/06/2019.
 */
interface HomeScreenView {
    val view: View

    fun showError(message: String)

    fun setLoading(loading: Boolean)

    fun hideKeyBoard()

    fun toolbarStartBtnObs(): Observable<Any>

    fun setListItems(itemList: List<ItemDataResponse>?)

    fun listItemClicks(): Observable<ItemDataResponse>

}