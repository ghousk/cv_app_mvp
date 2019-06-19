package com.innovativequest.cv_app_mvp.screens.home.mvp.adapter

import android.content.Context
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife
import com.innovativequest.cv_app_mvp.R
import com.innovativequest.cv_app_mvp.models.ItemDataResponse
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import java.util.*

/**
 * Created by Ghous Khan on 17/06/2019.
 */

class  HomeScreenItemListAdapter(private val context: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

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
        (holder as ItemItemViewHolder).bindNearMeItemItemData(mItemList.get(position))
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


        @BindView(R.id.item_list_item_start_date_tv)
        internal lateinit var mStartDateTv: AppCompatTextView


        @BindView(R.id.item_list_item_end_date_tv)
        internal lateinit var mEndDateTv: AppCompatTextView

        @BindView(R.id.item_list_item_achievements_tv)
        internal lateinit var mAchievementsTv: AppCompatTextView


        @BindView(R.id.item_item_layout)
        internal lateinit var mLayout : View

        init {
            ButterKnife.bind(this,view)
        }

        fun bindNearMeItemItemData(item: ItemDataResponse) {
            this.mItem = item
            val relativePos = adapterPosition

            try {
                itemNameTv.text     = mItem.title

                artistNameTv.text   = mItem.jobTitle

                mStartDateTv.text   =   context.getString(R.string.single_key_value_field_format, context.getString(R.string.start), mItem.startDate)

                mEndDateTv.text     =   context.getString(R.string.single_key_value_field_format, context.getString(R.string.end), mItem.endDate)

                mAchievementsTv.text    = mItem.achievements

                mLayout.setOnClickListener{ clickSubject.onNext(mItemList[relativePos])}

            }
            catch (e: NullPointerException){
                e.printStackTrace()
            }
        }

    }

    companion object
}