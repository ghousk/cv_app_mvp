package com.innovativequest.cv_app_mvp.screens.itemdetail.mvp

import com.innovativequest.cv_app_mvp.networkservices.DataService
import com.innovativequest.cv_app_mvp.models.ItemDataResponse
import com.innovativequest.cv_app_mvp.models.ItemDetailFirst
import com.innovativequest.cv_app_mvp.screens.home.HomeScreenActivity
import com.innovativequest.cv_app_mvp.screens.itemdetail.ItemDetailActivity
import io.reactivex.Observable
import kotlin.collections.ArrayList

/**
 * Created by Ghous on 17/06/2019.
 */
class ItemDetailModel(private val mItemDetailActivity: ItemDetailActivity, private val mDataService: DataService) {

    fun getItemDetailFirst() : Observable<ItemDetailFirst> {
        return mDataService.itemDetailFirst
    }

    fun getItems(): Observable<ArrayList<ItemDataResponse>> {
        return mDataService.dataItems
    }

    fun showExperiencesScreen(){
        HomeScreenActivity.start(mItemDetailActivity)
    }
}


