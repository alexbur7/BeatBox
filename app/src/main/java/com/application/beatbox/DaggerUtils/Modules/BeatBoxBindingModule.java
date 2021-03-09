package com.application.beatbox.DaggerUtils.Modules;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.SeekBar;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import com.application.beatbox.BeatBox;
import com.application.beatbox.R;
import com.application.beatbox.SoundAdapter;
import com.application.beatbox.databinding.FragmentBeatBoxBinding;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module(includes = {ContextModule.class,AdapterModule.class,BeatBoxModule.class})
public class BeatBoxBindingModule {

    private FragmentBeatBoxBinding binding;


    @Provides
    @Singleton
    FragmentBeatBoxBinding provideBinging(Context context, ViewGroup group, BeatBox box,SoundAdapter adapter){
        this.binding= DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.fragment_beat_box,group,false);
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(context,3));
        binding.seekBar.setProgress((int) (box.getPlaybackSpeed()*100));
        binding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                box.setPlaybackSpeed(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        return binding;
    }

}
