package com.innovativequest.cv_app_mvp.screens.home.mvp

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


/**
 * Created by Ghous on 17/06/2019.
 */
class HomeScreenPresenter ( private val homeScreenView: HomeScreenView, private  val homeScreenModel: HomeScreenModel ) {

    private val compositeDisposable = CompositeDisposable()

    fun onCreate() {

        compositeDisposable.addAll(
                loadData(),
                subscribeToListItemClicks(),
                subscribeToBackButton())
    }

    private fun loadData(): Disposable {
        return homeScreenModel.getItems()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    try {
                        homeScreenView.setListItems(it)
                    }
                    catch (e: NullPointerException){
                        e.printStackTrace()
                    }
                },
                        { throwable -> homeScreenView.showError(throwable.message!!) })
    }

    private fun subscribeToBackButton(): Disposable {
        return homeScreenView.toolbarStartBtnObs().subscribe {
            homeScreenModel.onBackPressed()
        }
    }

    private fun subscribeToListItemClicks(): Disposable {
        return homeScreenView.listItemClicks().subscribe {
            homeScreenModel.showItemDetailScreen(it)
        }
    }

    fun onDestroy() {
        compositeDisposable.clear()
    }

}