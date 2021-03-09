package com.application.beatbox;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.application.beatbox.databinding.ListItemSoundBinding;

import java.util.ArrayList;

public class SoundAdapter extends RecyclerView.Adapter<SoundAdapter.SoundViewHolder> {

    private ArrayList<Sound> mSounds;
    private BeatBox mBeatBox;

    public SoundAdapter(BeatBox box) {
        this.mBeatBox=box;
        this.mSounds = mBeatBox.getSounds();
    }

    @NonNull
    @Override
    public SoundViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SoundViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.list_item_sound, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SoundViewHolder holder, int position) {
        holder.bind(mSounds.get(position));
    }

    @Override
    public int getItemCount() {
        return mSounds.size();
    }

    public class SoundViewHolder extends RecyclerView.ViewHolder {
        private ListItemSoundBinding binding;

        public SoundViewHolder(ListItemSoundBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            this.binding.setViewModel(new ViewModel(mBeatBox));
        }

        public void bind(Sound sound) {
            binding.getViewModel().setSound(sound);
            binding.executePendingBindings();
        }
    }
}
