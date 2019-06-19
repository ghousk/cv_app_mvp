package com.innovativequest.cv_app_mvp.screens.home.dagger

import com.innovativequest.cv_app_mvp.networkservices.DataService
import com.innovativequest.cv_app_mvp.utils.PreferencesManager
import com.innovativequest.cv_app_mvp.screens.home.HomeScreenActivity
import com.innovativequest.cv_app_mvp.screens.home.mvp.DefaultHomeScreenView
import com.innovativequest.cv_app_mvp.screens.home.mvp.HomeScreenModel
import com.innovativequest.cv_app_mvp.screens.home.mvp.HomeScreenPresenter
import com.innovativequest.cv_app_mvp.screens.home.mvp.HomeScreenView
import com.squareup.picasso.Picasso

import dagger.Module
import dagger.Provides

/**
 * Created by Ghous on 17/06/2019.
 */
@Module
class HomeScreenModule(internal val homeScreenActivity: HomeScreenActivity) {

    @Provides
    @HomeScreenScope
    fun homeScreenView(preferencesManager: PreferencesManager, picasso: Picasso): HomeScreenView {
        return DefaultHomeScreenView(homeScreenActivity, preferencesManager, picasso)
    }

    @Provides
    @HomeScreenScope
    fun homeScreenPresenter(homeScreenView: HomeScreenView,
                            homeScreenModel: HomeScreenModel): HomeScreenPresenter {
        return HomeScreenPresenter(homeScreenView, homeScreenModel)
    }

    @Provides
    @HomeScreenScope
    fun homeScreenModel(dataService: DataService, preferencesManager: PreferencesManager): HomeScreenModel {
        return HomeScreenModel(dataService, homeScreenActivity,  preferencesManager)
    }


}
