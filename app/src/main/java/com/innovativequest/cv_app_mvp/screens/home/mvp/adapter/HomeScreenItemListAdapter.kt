package com.innovativequest.cv_app_mvp.screens.home.mvp.adapter

import android.content.Context
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import butterknife.BindView
import butterknife.ButterKnife
import com.innovativequest.cv_app_mvp.R
import com.innovativequest.cv_app_mvp.models.ItemDataResponse
import com.squareup.picasso.Picasso
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import java.util.*

/**
 * Created by Ghous Khan on 17/06/2019.
 */

class  HomeScreenItemListAdapter(private val context: Context, private val mPicasso: Picasso): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    internal var mItemList: MutableList<ItemDataResponse> = ArrayList()

    val clickSubject : PublishSubject<ItemDataResponse> = PublishSubject.create<ItemDataResponse>()
    val clickEvent: Observable<ItemDataResponse> = clickSubject

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val rootView = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_row, parent,false)
        return ItemItemViewHolder(rootView)
    }

    override fun getItemCount(): Int {
        return mItemList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ItemItemViewHolder).bindNearMeItemItemData(mItemList.get(position), position)
    }


    internal fun setData(items: List<ItemDataResponse>){
        mItemList.clear()
        mItemList.addAll(items)
        notifyDataSetChanged()
    }

    inner class ItemItemViewHolder(private val view: View): RecyclerView.ViewHolder(view){

        internal lateinit var mItem: ItemDataResponse

        @BindView(R.id.item_list_item_name_tv)
        internal lateinit var itemNameTv: AppCompatTextView

        @BindView(R.id.item_list_item_artist_tv)
        internal lateinit var artistNameTv: AppCompatTextView

        @BindView(R.id.item_list_item_listeners_tv)
        internal lateinit var listenersTv: AppCompatTextView


        @BindView(R.id.item_item_layout)
        internal lateinit var mLayout : View

        @BindView(R.id.progress_bar)
        lateinit var progressBar  : ProgressBar

        init {
            ButterKnife.bind(this,view)
        }

        fun bindNearMeItemItemData(item: ItemDataResponse, currentPosition: Int) {
            this.mItem = item
            val relativePos = adapterPosition

            try {
//                itemNameTv.text    = mItem.schoolName
//
//                artistNameTv.text   = mItem.location
//
//                listenersTv.text    = mItem.schoolEmail

                mLayout.setOnClickListener{ clickSubject.onNext(mItemList[relativePos])}

            }
            catch (e: NullPointerException){
                e.printStackTrace()
            }
        }

    }

    companion object
}