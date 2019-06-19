package com.innovativequest.cv_app_mvp.screens.home.mvp

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.widget.*
import androidx.appcompat.widget.Toolbar
import com.innovativequest.cv_app_mvp.R
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.*
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.innovativequest.cv_app_mvp.utils.PreferencesManager
import com.innovativequest.cv_app_mvp.models.ItemDataResponse
import com.innovativequest.cv_app_mvp.screens.home.HomeScreenActivity
import com.innovativequest.cv_app_mvp.screens.home.mvp.adapter.HomeScreenItemListAdapter
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.Observable
import com.squareup.picasso.Picasso

/**
 * Created by Ghous on 17/06/2019.
 */
@SuppressLint("ViewConstructor")
class DefaultHomeScreenView (private val homeScreenActivity: HomeScreenActivity, private val preferencesManager: PreferencesManager, private val mPicasso: Picasso) : FrameLayout(homeScreenActivity), HomeScreenView {

    @BindView(R.id.default_homeview_toolbar)
    internal lateinit var mToolbar: Toolbar

    @BindView(R.id.title_bk_actionbar_btn_start)
    internal lateinit var mToolbarStartButton: ImageView

    @BindView(R.id.title_bk_actionbar_btn_end)
    internal lateinit var mToolbarEndButton: ImageView

    @BindView(R.id.title_bk_actionbar_title_centre)
    internal lateinit var mToolbarCentreTitle: AppCompatTextView

    @BindView(R.id.progressBar)
    internal lateinit var progressBar: ProgressBar

    @BindView(R.id.home_item_list_recycler_view)
    internal lateinit var mItemsRecyclerView: RecyclerView

    private val mAdapter: HomeScreenItemListAdapter

    override val view: View
        get() = this


    init {
        //Inflate the layout into the viewgroup
        layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        View.inflate(context, R.layout.default_home_screen_view, this)
        ButterKnife.bind(this)

        mToolbarCentreTitle.text = homeScreenActivity.getString(R.string.experience)
        mToolbarEndButton.visibility    =   View.GONE
        mAdapter = HomeScreenItemListAdapter(homeScreenActivity)
        mItemsRecyclerView.layoutManager = LinearLayoutManager(homeScreenActivity)
        mItemsRecyclerView.adapter = mAdapter
    }

    override fun toolbarStartBtnObs(): Observable<Any> {
        return RxView.clicks(mToolbarStartButton)
    }

    override fun setLoading(loading: Boolean) {
        if (loading) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }

    override fun showError(message: String) {
//        val view = homeScreenActivity.getLayoutInflater().inflate(R.layout.custom_toast_layout, null)
//        Utils.showCustomErrorToast(homeScreenActivity, message, view)
    }

    override fun listItemClicks(): Observable<ItemDataResponse> {
        return mAdapter.clickEvent
    }

    override fun setListItems(itemList: List<ItemDataResponse>?) {
        if(itemList!=null && itemList.isNotEmpty()){
            mAdapter.setData(itemList)
        }
    }

    override fun hideKeyBoard() {
        (homeScreenActivity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
                .hideSoftInputFromWindow(view.windowToken, 0)
    }

}








