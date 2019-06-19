package com.innovativequest.cv_app_mvp.builder;

import android.content.Context;
import com.franmontiel.persistentcookiejar.ClearableCookieJar;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.innovativequest.cv_app_mvp.utils.EnvironmentParameters;
import com.innovativequest.cv_app_mvp.utils.PreferencesManager;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;
import dagger.Module;
import dagger.Provides;
import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;

import javax.inject.Named;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Module
public class NetworkModule {

    @AppScope
    @Provides
    public OkHttpClient okHttpClient(Interceptor loggingInterceptor, Cache cache, ClearableCookieJar cookieJar) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .cookieJar(cookieJar)
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .addNetworkInterceptor(loggingInterceptor)
                .addInterceptor(httpLoggingInterceptor)
                .cache(cache)
                .build();
    }

    @AppScope
    @Provides
    public Cache cache(Context context, @Named("OkHttpCacheDir") String cacheDir, @Named("OkHttpCacheSize") int cacheSize) {
        return new Cache(new File(context.getFilesDir(), cacheDir), cacheSize);
    }


    @AppScope
    @Provides
    public ClearableCookieJar cookieJar(Context context){
        return new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(context));
    }

    @AppScope
    @Provides
    @Named("OkHttpCacheDir")
    public String cacheDir() {
        return "OkHttpCache";
    }


    @AppScope
    @Provides
    @Named("OkHttpCacheSize")
    public int cacheSize() {
        return 10 * 1024 * 1024; //10MB cache
    }

    @AppScope
    @Provides
    public Interceptor Interceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder().build();
                Response response = chain.proceed(request);

//                if(response.code() == 401) {
//
//                }
                return response;
            }
        };
    }

    @AppScope
    @Provides
    public Picasso picasso(Context context, OkHttpClient okHttpClient) {
        return new Picasso.Builder(context)
                .downloader(new OkHttp3Downloader(okHttpClient))
                .build();
    }

    @AppScope
    @Provides
    public EnvironmentParameters environmentParameters(){
        return new EnvironmentParameters();
    }

    @AppScope
    @Provides
    public PreferencesManager preferencesManager(Context context){
        return new PreferencesManager(context);
    }
}
