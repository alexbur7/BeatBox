package com.application.beatbox;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.application.beatbox.DaggerUtils.Components.DaggerBeatBoxComponent;
import com.application.beatbox.DaggerUtils.Modules.ContextModule;
import com.application.beatbox.databinding.FragmentBeatBoxBinding;
import javax.inject.Inject;

public class BeatBoxFragment extends Fragment {

    @Inject
    BeatBox box;

    @Inject
    FragmentBeatBoxBinding binding;

    public static BeatBoxFragment newInstance() {
        Bundle args = new Bundle();
        BeatBoxFragment fragment = new BeatBoxFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setRetainInstance(true);
        DaggerBeatBoxComponent.builder().contextModule(new ContextModule(getActivity(),container))
                .build().inject(this);
        return binding.getRoot();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        box.release();
    }
}
