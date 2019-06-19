package com.innovativequest.cv_app_mvp.networkservices;

import com.innovativequest.cv_app_mvp.models.ItemDataResponse;
import com.innovativequest.cv_app_mvp.models.ItemDetailFirst;
import com.innovativequest.cv_app_mvp.utils.AppConstants;
import io.reactivex.Observable;
import retrofit2.http.GET;

import java.util.ArrayList;

/**
 * Created by Ghous on 17/06/2019.
 */


public interface DataService {
    //************************************************
    //HEAD REQUESTS
    //************************************************

    //************************************************
    // GET REQUESTS
    //************************************************
    @GET(AppConstants.GET_POSTS)
    Observable<ArrayList<ItemDataResponse>> getDataItems();

    @GET(AppConstants.GET_USERS)
    Observable<ItemDetailFirst> getItemDetailFirst();

    //************************************************
    // POST REQUESTS
    //************************************************


}