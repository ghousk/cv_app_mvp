package com.innovativequest.cv_app_mvp.screens.home.dagger

import com.innovativequest.cv_app_mvp.builder.RxMvpAppComponent
import com.innovativequest.cv_app_mvp.screens.home.HomeScreenActivity
import dagger.Component

/**
 * Created by Ghous on 17/06/2019.
 */
@HomeScreenScope
@Component(modules = arrayOf(HomeScreenModule::class), dependencies = arrayOf(RxMvpAppComponent::class))
interface HomeScreenActivityComponent {
    fun inject(homeScreenActivity: HomeScreenActivity)
}