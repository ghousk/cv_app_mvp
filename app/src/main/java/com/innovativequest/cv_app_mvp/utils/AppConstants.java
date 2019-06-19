package com.innovativequest.cv_app_mvp.utils;

/**
 * Created by Ghous on 17/06/2019.
 */
public class AppConstants {

    private static final String TAG = "AppConstants";


    // ENV DEPENDENT BASE URLs
    public static final String BASE_URL_DEV = "https://my-json-server.typicode.com/ghousk/fake_json_data/";
    private static final String DEFAULT_LOCALE = "en-GB";

    public static String getLocale()
    {
        return DEFAULT_LOCALE;
    }

    public static final String GET_POSTS = "experiences";
    public static final String GET_USERS = "person";
    public static final String GET_COMMENTS = "comments";
}

