package com.application.beatbox.DaggerUtils.Modules;


import android.content.Context;
import android.view.ViewGroup;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    private Context mContext;

    private ViewGroup mViewGroup;

    public ContextModule(Context context, ViewGroup group){
        this.mContext=context;
        this.mViewGroup=group;
    }

    @Singleton
    @Provides
    Context provideContext(){
        return mContext;
    }

    @Singleton
    @Provides
    ViewGroup provideGroup(){
        return mViewGroup;
    }


}
