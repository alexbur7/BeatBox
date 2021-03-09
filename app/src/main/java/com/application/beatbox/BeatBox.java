package com.application.beatbox;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;

import java.io.IOException;
import java.util.ArrayList;

public class BeatBox {
    private static final String SOUNDS_FOLDER="sample_sounds";

    private static final int MAX_STREAMS=3;

    private ArrayList<Sound> mSounds;

    private AssetManager mAssetManager;

    private float playbackSpeed;

    private SoundPool mSoundPool;

    public BeatBox(Context context){
        mAssetManager=context.getAssets();
        mSounds=new ArrayList<>();
        playbackSpeed =1.0f;
        mSoundPool=new SoundPool(MAX_STREAMS, AudioManager.STREAM_MUSIC,0);
        loadsounds();
    }

    private void loadsounds(){
        String[] sounds=null;
        try {
            sounds=mAssetManager.list(SOUNDS_FOLDER);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String soundName:sounds){
            Sound sound=new Sound(SOUNDS_FOLDER+"/"+soundName);
            loadSound(sound);
            mSounds.add(sound);
        }
    }

    public void playSound(Sound sound){
        if (sound.getId()==null) return;
        mSoundPool.play(sound.getId(),1.0f,1.0f,1,0, playbackSpeed);
    }

    private void loadSound(Sound sound){
        AssetFileDescriptor afd= null;
        try {
            afd = mAssetManager.openFd(sound.getAssetPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        sound.setId(mSoundPool.load(afd,1));
    }

    public void release(){
        mSoundPool.release();
    }

    public ArrayList<Sound> getSounds() {
        return mSounds;
    }

    public void setPlaybackSpeed(float playbackSpeed) {
        this.playbackSpeed = playbackSpeed/100f;
    }

    public float getPlaybackSpeed() {
        return playbackSpeed;
    }
}
