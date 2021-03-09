package com.application.beatbox.DaggerUtils.Modules;

import com.application.beatbox.BeatBox;
import com.application.beatbox.SoundAdapter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module(includes = BeatBoxModule.class)
public class AdapterModule {
    private SoundAdapter mAdapter;

    @Provides
    @Singleton
    SoundAdapter provideAdapter(BeatBox box){
        mAdapter=new SoundAdapter(box);
        return mAdapter;
    }

}
