package com.application.beatbox.DaggerUtils.Components;


import com.application.beatbox.BeatBox;
import com.application.beatbox.BeatBoxFragment;
import com.application.beatbox.DaggerUtils.Modules.BeatBoxBindingModule;
import com.application.beatbox.DaggerUtils.Modules.BeatBoxModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {BeatBoxBindingModule.class,BeatBoxModule.class})
public interface BeatBoxComponent {

    void inject(BeatBoxFragment fragment);

}
