package com.innovativequest.cv_app_mvp.screens.home

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import com.innovativequest.cv_app_mvp.RxMvpApp
import com.innovativequest.cv_app_mvp.screens.home.dagger.HomeScreenModule
import com.innovativequest.cv_app_mvp.screens.home.mvp.HomeScreenPresenter
import com.innovativequest.cv_app_mvp.screens.home.mvp.HomeScreenView
import com.innovativequest.cv_app_mvp.screens.home.dagger.DaggerHomeScreenActivityComponent
import javax.inject.Inject

class HomeScreenActivity : AppCompatActivity() {

    @Inject
    lateinit var homeScreenView: HomeScreenView

    @Inject
    lateinit var homeScreenPresenter: HomeScreenPresenter

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerHomeScreenActivityComponent.builder()
                .rxMvpAppComponent(RxMvpApp.get(this).component())
                .homeScreenModule(HomeScreenModule(this))
                .build().inject(this)
        setContentView(homeScreenView.view)
        homeScreenPresenter.onCreate()

    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, HomeScreenActivity::class.java)
            context.startActivity(intent) }
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        homeScreenPresenter.onCreate()
    }

    override fun onDestroy() {
        super.onDestroy()
        homeScreenPresenter.onDestroy()
    }

}
