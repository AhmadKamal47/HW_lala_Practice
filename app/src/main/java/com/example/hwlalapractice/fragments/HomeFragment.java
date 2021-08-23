package com.example.hwlalapractice.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hwlalapractice.R;
import com.example.hwlalapractice.databinding.FragmentHomeBinding;
import com.example.hwlalapractice.model.Profile;
import com.example.hwlalapractice.utils.Constants;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    public FragmentHomeBinding homeBinding;
//    ArrayList<String> list;
private static final String TAG = "HOME";
    NavController navController;



    public HomeFragment() {
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
        homeBinding = FragmentHomeBinding.inflate(inflater, container, false);
        return homeBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.d(TAG, "onViewCreated: ");
//        list = new ArrayList<>();
        navController = Navigation.findNavController(view);

        homeBinding.btn3.setOnClickListener(view1 -> {
            String id = homeBinding.etHomeFragId.getText().toString().trim();
            String name = homeBinding.etHomeFragName.getText().toString().trim();
            String email = homeBinding.etHomeFragEmail.getText().toString().trim();

            if(TextUtils.isEmpty(name)){
                homeBinding.etHomeFragName.setError("Name required!");
                return;
            }

            if(TextUtils.isEmpty(email)){
                homeBinding.etHomeFragEmail.setError("Email required!");
                return;
            }

//            list.add(id);
//            list.add(name);
//            list.add(email);
            Bundle bundle = new Bundle();
            bundle.putParcelable(Constants.KEY, new Profile(name, id, email));
//            bundle.putStringArrayList("KEY", list);

            navController.navigate(R.id.secondFragment, bundle);
        });
    }
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