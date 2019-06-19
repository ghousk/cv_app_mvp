package com.innovativequest.cv_app_mvp.builder;

import com.google.gson.Gson;
import com.innovativequest.cv_app_mvp.networkservices.DataService;
import com.innovativequest.cv_app_mvp.utils.EnvironmentParameters;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.twistedequations.rx2.AndroidRxSchedulers;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.inject.Named;

@Module
public class RestServiceModule {

    @AppScope
    @Provides
    @Named("LastFmService")
    public Retrofit retrofit(OkHttpClient okHttpClient, Gson gson, AndroidRxSchedulers androidSchedulers, EnvironmentParameters environmentParameters) {
        return new Retrofit.Builder()
                .baseUrl(environmentParameters.getBaseURL())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(androidSchedulers.network()))
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();
    }

    @AppScope
    @Provides
    public DataService lastFmService(@Named("LastFmService") Retrofit retrofit) {
        return retrofit.create(DataService.class);
    }

}
