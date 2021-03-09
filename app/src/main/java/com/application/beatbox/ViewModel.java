package com.application.beatbox;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class ViewModel extends BaseObservable {

    private BeatBox mBeatBox;
    private Sound mSound;

    public ViewModel(BeatBox beatBox){
        mBeatBox=beatBox;
    }

    public BeatBox getBeatBox() {
        return mBeatBox;
    }

    public Sound getSound() {
        return mSound;
    }

    @Bindable
    public String getTitle(){
        return mSound.getName();
    }


    public void setSound(Sound sound) {
        mSound = sound;
        notifyChange();
    }

    public void onButtonClicked() {
        mBeatBox.playSound(mSound);
    }
}
