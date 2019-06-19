package com.innovativequest.cv_app_mvp.builder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dagger.Module;
import dagger.Provides;

@Module
public class GsonModule {

    @AppScope
    @Provides
    public Gson gson() {
        return new GsonBuilder().setLenient().create();
    }
}
