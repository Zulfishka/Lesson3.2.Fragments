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

public class FirstFragment extends Fragment {

    AppCompatButton button;
    EditText name, surname;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
        setClick();
    }

    private void initViews() {
        name = requireActivity().findViewById(R.id.etName);
        surname = requireActivity().findViewById(R.id.etSurname);
        button = requireActivity().findViewById(R.id.firstButton);
    }

    private void setClick() {
        button.setOnClickListener(click -> {
            navigateToSecond();
        });
    }

    private void navigateToSecond() {

        Bundle bundle = new Bundle();
        bundle.putString("name", name.getText().toString());
        bundle.putString("surname", surname.getText().toString());
        SecondFragment secondFragment = new SecondFragment();
        ForthFragment forthFragment = new ForthFragment();
        forthFragment.setArguments(bundle);

        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_view, secondFragment)
                .commit();
    }
}