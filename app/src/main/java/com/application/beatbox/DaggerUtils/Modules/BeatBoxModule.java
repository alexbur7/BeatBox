package com.application.beatbox.DaggerUtils.Modules;


import android.content.Context;

import com.application.beatbox.BeatBox;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = ContextModule.class)
public class BeatBoxModule {
    private BeatBox mBeatBox;

    @Provides
    @Singleton
    BeatBox provideBeatBox(Context context){
        mBeatBox=new BeatBox(context);
        return mBeatBox;
    }

}
