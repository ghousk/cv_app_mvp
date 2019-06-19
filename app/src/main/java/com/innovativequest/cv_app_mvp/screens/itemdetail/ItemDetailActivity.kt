package com.innovativequest.cv_app_mvp.screens.itemdetail

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.innovativequest.cv_app_mvp.RxMvpApp
import com.innovativequest.cv_app_mvp.screens.itemdetail.dagger.DaggerItemDetailActivityComponent
import com.innovativequest.cv_app_mvp.screens.itemdetail.dagger.ItemDetailModule
import com.innovativequest.cv_app_mvp.screens.itemdetail.mvp.ItemDetailPresenter
import com.innovativequest.cv_app_mvp.screens.itemdetail.mvp.ItemDetailView
import javax.inject.Inject

class ItemDetailActivity : AppCompatActivity() {

    @Inject
    lateinit var itemDetailView: ItemDetailView

    @Inject
    lateinit var itemDetailPresenter: ItemDetailPresenter

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerItemDetailActivityComponent.builder()
                .rxMvpAppComponent(RxMvpApp.get(this).component())
                .itemDetailModule(ItemDetailModule(this))
                .build().inject(this)
        setContentView(itemDetailView.view)
        itemDetailPresenter.onCreate()

    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, ItemDetailActivity::class.java)
            context.startActivity(intent) }

    }

    override fun onDestroy() {
        super.onDestroy()
        itemDetailPresenter.onDestroy()
    }

}
