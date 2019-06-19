package com.innovativequest.cv_app_mvp.screens.itemdetail.mvp
import android.view.View
import com.innovativequest.cv_app_mvp.models.ItemDataResponse
import com.innovativequest.cv_app_mvp.models.ItemDetailFirst
import io.reactivex.Observable

/**
 * Created by Ghous on 17/06/2019.
 */
interface ItemDetailView {
    val view: View

    fun showError(message: String)

    fun setItem(itemItem: ArrayList<ItemDataResponse>, itemDetailFirst: ItemDetailFirst?)

    fun moreButtonObs(): Observable<Any>
}