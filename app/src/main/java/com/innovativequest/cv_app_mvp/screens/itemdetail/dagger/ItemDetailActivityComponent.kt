package com.innovativequest.cv_app_mvp.screens.itemdetail.dagger

import com.innovativequest.cv_app_mvp.builder.RxMvpAppComponent
import com.innovativequest.cv_app_mvp.screens.itemdetail.ItemDetailActivity
import dagger.Component

/**
 * Created by Ghous on 17/06/2019.
 */
@ItemDetailScope
@Component(modules = arrayOf(ItemDetailModule::class), dependencies = arrayOf(RxMvpAppComponent::class))
interface ItemDetailActivityComponent {
    fun inject(itemDetailActivity: ItemDetailActivity)
}