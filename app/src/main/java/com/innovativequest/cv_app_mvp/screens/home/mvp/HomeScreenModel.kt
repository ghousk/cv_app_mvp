package com.innovativequest.cv_app_mvp.screens.home.mvp

import com.innovativequest.cv_app_mvp.networkservices.DataService
import com.innovativequest.cv_app_mvp.utils.PreferencesManager
import com.innovativequest.cv_app_mvp.models.ItemDataResponse
import com.innovativequest.cv_app_mvp.screens.home.HomeScreenActivity
import com.innovativequest.cv_app_mvp.screens.itemdetail.ItemDetailActivity
import io.reactivex.Observable
import kotlin.collections.ArrayList

/**
 * Created by Ghous on 17/06/2019.
 */
class HomeScreenModel(private val mDataService: DataService, private val mHomeScreenActivity: HomeScreenActivity,
                      private val mPreferencesManager: PreferencesManager
) {

    fun getItems(): Observable<ArrayList<ItemDataResponse>> {
       return mDataService.dataItems
    }

    fun showItemDetailScreen(itemItem: ItemDataResponse){
        ItemDetailActivity.start(mHomeScreenActivity)
    }

    fun onBackPressed(){
        mHomeScreenActivity.onBackPressed()
    }

    fun deleteData(){
        mPreferencesManager.clear()
        //Delete DB data here if required
        // Delete Files and Folder here if required
    }

}


