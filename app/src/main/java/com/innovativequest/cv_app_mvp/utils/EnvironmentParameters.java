package com.innovativequest.cv_app_mvp.utils;


import com.innovativequest.cv_app_mvp.BuildConfig;

/**
 * Created by Ghous on 17/06/2019.
 */
public class EnvironmentParameters {
    private String mBaseUrl;
    private String mCurrentEnv;

    public EnvironmentParameters(){
        if(BuildConfig.FLAVOR == "baseDev"){
           setBaseDevEnvironment();
        }
        else if (BuildConfig.FLAVOR == "baseUat") {
           setBaseUatEnvironment();
        }
        else if (BuildConfig.FLAVOR == "baseLive") {
            setBaseLiveEnvironment();
        }
    }

    public void setBaseDevEnvironment(){
        mCurrentEnv = "BaseDev";
        mBaseUrl        = AppConstants.BASE_URL_DEV;
    }

    public void setBaseUatEnvironment(){
        mCurrentEnv = "BaseUat";
    }

    public void setBaseLiveEnvironment(){
        mCurrentEnv = "BaseLive";

    }

    public String getBaseURL(){ return mBaseUrl; }

    //Sets
    // Add any Late Initialised Sets here

}
