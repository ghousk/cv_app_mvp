package com.innovativequest.cv_app_mvp.screens.itemdetail.dagger

import com.innovativequest.cv_app_mvp.networkservices.DataService
import com.innovativequest.cv_app_mvp.utils.PreferencesManager
import com.innovativequest.cv_app_mvp.screens.itemdetail.ItemDetailActivity
import com.innovativequest.cv_app_mvp.screens.itemdetail.mvp.DefaultItemDetailView
import com.innovativequest.cv_app_mvp.screens.itemdetail.mvp.ItemDetailModel
import com.innovativequest.cv_app_mvp.screens.itemdetail.mvp.ItemDetailPresenter
import com.innovativequest.cv_app_mvp.screens.itemdetail.mvp.ItemDetailView

import dagger.Module
import dagger.Provides

/**
 * Created by Ghous on 17/06/2019.
 */
@Module
class ItemDetailModule(internal val itemDetailActivity: ItemDetailActivity) {

    @Provides
    @ItemDetailScope
    fun itemDetailView(): ItemDetailView {
        return DefaultItemDetailView(itemDetailActivity)
    }

    @Provides
    @ItemDetailScope
    fun itemDetailPresenter(itemDetailView: ItemDetailView,
                            itemDetailModel: ItemDetailModel,
                            preferencesManager: PreferencesManager
    ): ItemDetailPresenter {
        return ItemDetailPresenter(itemDetailView, itemDetailModel)
    }

    @Provides
    @ItemDetailScope
    fun itemDetailModel(dataService: DataService): ItemDetailModel {
        return ItemDetailModel(itemDetailActivity, dataService)
    }


}
