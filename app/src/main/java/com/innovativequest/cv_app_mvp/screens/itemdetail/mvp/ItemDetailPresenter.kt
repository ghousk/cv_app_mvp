package com.innovativequest.cv_app_mvp.screens.itemdetail.mvp

import android.util.Log
import com.innovativequest.cv_app_mvp.models.ItemDataResponse
import com.innovativequest.cv_app_mvp.models.ItemDetailFirst
import com.innovativequest.cv_app_mvp.utils.PreferencesManager
import com.innovativequest.cv_app_mvp.screens.itemdetail.ItemDetailActivity
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.BiFunction


/**
 * Created by Ghous on 17/06/2019.
 */
class ItemDetailPresenter (private val itemDetailActivity: ItemDetailActivity, private val itemDetailView: ItemDetailView, private  val itemDetailModel: ItemDetailModel,
                           private val preferencesManager: PreferencesManager
) {

    private val compositeDisposable = CompositeDisposable()

    fun onCreate() {

        compositeDisposable.addAll(
            subscribeMoreButton(),
                getData())
    }

//    private fun subscribeToBackButton(): Disposable {
//        return itemDetailView.toolbarStartBtnObs().subscribe {
//            itemDetailActivity.onBackPressed()
//        }
//    }

    private fun subscribeMoreButton(): Disposable {
        return itemDetailView.moreButtonObs().subscribe {
            itemDetailModel.showExperiencesScreen()
        }
    }

    private fun getData() : Disposable {

        return Observable.zip(itemDetailModel.getItems(), itemDetailModel.getItemDetailFirst(),
            BiFunction { dataItems: ArrayList<ItemDataResponse>, itemDetail: ItemDetailFirst ->
                itemDetailView.setItem(dataItems, itemDetail)
            }).subscribe({},{Log.d(javaClass.name, it.message)})
        }

    fun onDestroy() {
        compositeDisposable.clear()
    }

}