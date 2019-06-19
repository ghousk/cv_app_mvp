package com.innovativequest.cv_app_mvp.screens.itemdetail.mvp

import android.annotation.SuppressLint
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import android.util.Log
import com.innovativequest.cv_app_mvp.R
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.FrameLayout
import android.widget.ImageView
import butterknife.BindView
import butterknife.ButterKnife
import com.innovativequest.cv_app_mvp.models.ItemDataResponse
import com.innovativequest.cv_app_mvp.models.ItemDetailFirst
import com.innovativequest.cv_app_mvp.screens.itemdetail.ItemDetailActivity
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.Observable

/**
 * Created by Ghous on 17/06/2019.
 */
@SuppressLint("ViewConstructor")
class DefaultItemDetailView (private val itemDetailActivity: ItemDetailActivity) : FrameLayout(itemDetailActivity), ItemDetailView {

    @BindView(R.id.title_bk_actionbar_btn_start)
    internal lateinit var mToolbarStartButton: ImageView

    @BindView(R.id.title_bk_actionbar_btn_end)
    internal lateinit var mToolbarEndButton: ImageView

    @BindView(R.id.title_bk_actionbar_title_centre)
    internal lateinit var mToolbarCentreTile: AppCompatTextView

    @BindView(R.id.item_name_tv)
    internal lateinit var mItemTitle: AppCompatTextView

    @BindView(R.id.sub_item_name_tv)
    internal lateinit var mItemArtist: AppCompatTextView

    @BindView(R.id.body_item_1_tv)
    internal lateinit var mBodyItem1Tv: AppCompatTextView

    @BindView(R.id.body_item_2_tv)
    internal lateinit var mBodyItem2Tv: AppCompatTextView

    @BindView(R.id.body_item_3_tv)
    internal lateinit var mBodyItem3Tv: AppCompatTextView

    @BindView(R.id.body_item_4_tv)
    internal lateinit var mBodyItem4Tv: AppCompatTextView

    @BindView(R.id.body_item_5_tv)
    internal lateinit var mBodyItem5Tv: AppCompatTextView

    @BindView(R.id.body_item_6_tv)
    internal lateinit var mBodyItem6Tv: AppCompatTextView

    @BindView(R.id.item_detail_iv)
    internal lateinit var mItemImageIv: AppCompatImageView

    @BindView(R.id.progress_bar)
    internal lateinit var progressBar: ProgressBar

    @BindView(R.id.did_more_btn)
    internal lateinit var mMoreButton: Button

    override val view: View
        get() = this


    init {
        //Inflate the layout into the viewgroup
        layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        View.inflate(context, R.layout.default_item_detail, this)
        ButterKnife.bind(this)
        mToolbarStartButton.visibility = GONE
        mToolbarEndButton.visibility = GONE
    }

    override fun toolbarStartBtnObs(): Observable<Any> {
        return RxView.clicks(mToolbarStartButton)
    }

    override fun moreButtonObs(): Observable<Any> {
        return RxView.clicks(mMoreButton)
    }

    override fun setItem(itemItem: ArrayList<ItemDataResponse>, itemDetailFirst: ItemDetailFirst?) {
        itemDetailActivity.runOnUiThread {
            try {
                mToolbarCentreTile.text = itemDetailActivity.getString(R.string.cv)
                mItemTitle.text = itemDetailFirst?.name
                mItemArtist.text = itemItem[0].jobTitle
                mBodyItem1Tv.text = itemDetailActivity.getString(R.string.mobile_field_format, itemDetailFirst?.mobile)
                mBodyItem2Tv.text = itemDetailActivity.getString(R.string.email_field_format, itemDetailFirst?.email)

                mBodyItem3Tv.text = itemDetailFirst?.summary
                mBodyItem4Tv.text = itemDetailFirst?.technicalKnowledge
                mBodyItem5Tv.text = itemItem[0].title
                mBodyItem6Tv.text = itemItem[0].achievements


            }
            catch (e: NullPointerException){
                Log.d(javaClass.name, e.message)
            }
        }
    }

    override fun showError(message: String) {
//        val view = itemDetailActivity.getLayoutInflater().inflate(R.layout.custom_toast_layout, null)
//        Utils.showCustomErrorToast(itemDetailActivity, message, view)
    }

}








