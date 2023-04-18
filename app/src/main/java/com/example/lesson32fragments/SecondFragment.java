package com.example.lesson32fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class SecondFragment extends Fragment {

    AppCompatButton button;
    EditText age, gender;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
        setClick();
    }

    private void initViews() {
        age = requireActivity().findViewById(R.id.etAge);
        gender = requireActivity().findViewById(R.id.etGender);
        button = requireActivity().findViewById(R.id.secondButton);
    }

    private void setClick() {
        button.setOnClickListener(click -> {
            navigateToThird();
        });
    }

    private void navigateToThird() {

        Bundle bundle = new Bundle();
        bundle.putString("age", age.getText().toString());
        bundle.putString("gender", gender.getText().toString());

        ThirdFragment thirdFragment = new ThirdFragment();
        ForthFragment forthFragment = new ForthFragment();
        forthFragment.setArguments(bundle);

        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_view, thirdFragment)
                .commit();
    }
}
