package com.example.fragment1;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.fragment1.databinding.ActivityMainBinding;
import com.example.fragment1.databinding.FragmentBlankBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;
    private boolean isFragmentShow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());


        mBinding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isFragmentShow){
                    CloseFragment();
                } else{
                    openFragment();
                }

            }
        });


        mBinding.btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opendSecondFragment("Mario","Bross");
            }
        });




    }






    //metodo para abrir el fragmento

    private void openFragment(){

        // instanciar fragmento donde quiero ir
        BlankFragment blankFragment = new BlankFragment();
        FragmentManager manager = getSupportFragmentManager();

        // activar la trasaccion
        FragmentTransaction transaction = manager.beginTransaction()
                .replace(mBinding.Contenedor.getId(),blankFragment,
                     BlankFragment.class.getSimpleName());

         transaction.commit();
         mBinding.btn.setText("ABRIR");
         isFragmentShow= true;


    }


    private void CloseFragment(){
        FragmentManager manager = getSupportFragmentManager();
        BlankFragment blankFragment =(BlankFragment)manager.findFragmentById(mBinding.Contenedor.getId());

        if(blankFragment != null){

            FragmentTransaction transaction = manager.beginTransaction();
            transaction.remove(blankFragment).commit();
            mBinding.btn.setText("CERRAR");
            isFragmentShow= false;

        }

    }

    private void opendSecondFragment(String name , String lastName){

        BlankFragment2 blankFragment2 =BlankFragment2.newInstance(name,lastName);
        FragmentManager manager = getSupportFragmentManager();
        // verificamos si el contenedor no esta ocupado

        if(blankFragment2 !=null){

            FragmentTransaction transaction = manager.beginTransaction()
                            .replace(mBinding.Contenedor.getId(),blankFragment2,
                                    BlankFragment2.class.getSimpleName());
            mBinding.btn.setText("CERRAR");
            isFragmentShow= false;
            transaction.commit();

        }

    }









}