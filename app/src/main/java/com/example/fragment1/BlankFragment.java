package com.example.fragment1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.example.fragment1.databinding.FragmentBlankBinding;


public class BlankFragment extends Fragment {

    private FragmentBlankBinding mBinding;


    // buscar o llamar la clase binding

    public BlankFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate xml con binding

        mBinding = FragmentBlankBinding.inflate(inflater,container,false);
        return mBinding.getRoot();

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mBinding.radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {

                int index = mBinding.radiogroup.indexOfChild(mBinding.radiogroup.findViewById(i));

                switch (index){


                    case 0:
                        mBinding.textView.setText("Si lo conozco");
                        break;

                    case 1:
                        mBinding.textView.setText("No lo conozco");
                        break;

                    default:
                        break;

                }
            }
        });
    }
}