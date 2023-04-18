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

public class ThirdFragment extends Fragment {
    AppCompatButton button;
    EditText placeOfStudy, placeOfWork;

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
        placeOfStudy = requireActivity().findViewById(R.id.etName);
        placeOfWork = requireActivity().findViewById(R.id.etSurname);
        button = requireActivity().findViewById(R.id.thirdButton);
    }

    private void setClick() {
        button.setOnClickListener(click -> {
            navigateToForth();
        });
    }

    private void navigateToForth() {

        Bundle bundle = new Bundle();
        bundle.putString("placeOfStudy", placeOfStudy.getText().toString());
        bundle.putString("placeOfWork", placeOfWork.getText().toString());


        ForthFragment forthFragment = new ForthFragment();
        forthFragment.setArguments(bundle);

        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_view, forthFragment)
                .commit();
    }
}
