package com.example.hwlalapractice.mvvm.view.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hwlalapractice.databinding.FragmentSecondBinding;
import com.example.hwlalapractice.mvvm.repository.model.Profile;
import com.example.hwlalapractice.utils.Constants;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private static final String TAG = "SECOND";
//    ArrayList<String> list;

    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttached: ");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreated: ");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        list = new ArrayList<>();

        if(getArguments() != null)
        {
            Profile profile = getArguments().getParcelable(Constants.KEY);
            if(profile != null)
            {
                profile.getId();
            }
//            list = getArguments().getStringArrayList("KEY");
//            if(!list.isEmpty())
//            {
//                populate(list);
//            }
        }
    }



//    private void populate(ArrayList<String> list) {
//        binding.tvSecondFragId.setText(list.get(0));
//        binding.tvSecondFragName.setText(list.get(1));
//        binding.tvSecondFragEmail.setText(list.get(2));
//    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStarted: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResumed: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPaused: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStopped: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyedView: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroyed: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetached: ");
    }

}