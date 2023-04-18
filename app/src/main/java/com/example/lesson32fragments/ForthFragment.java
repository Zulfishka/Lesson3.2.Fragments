package com.example.lesson32fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ForthFragment extends Fragment {

    TextView tvFirst, tvSecond, tvThird, tvForth, tvFifth, tvSixth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_forth, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
        if(getArguments() !=null) {
            tvFirst.setText(getArguments().getString("name"));
            tvSecond.setText(getArguments().getString("surname"));
            tvThird.setText(getArguments().getString("age"));
            tvForth.setText(getArguments().getString("gender"));
            tvFifth.setText(getArguments().getString("placeOfStudy"));
            tvSixth.setText(getArguments().getString("placeOfWork"));
        }
    }

    private void initViews() {
        tvFirst = requireActivity().findViewById(R.id.tvFirst);
        tvSecond = requireActivity().findViewById(R.id.tvSecond);
        tvThird = requireActivity().findViewById(R.id.tvThird);
        tvForth = requireActivity().findViewById(R.id.tvForth);
        tvFifth = requireActivity().findViewById(R.id.tvFifth);
        tvSixth = requireActivity().findViewById(R.id.tvSixth);

    }


}