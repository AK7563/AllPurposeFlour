package com.example.allpurposeflour.Fragments.Fragment_2D;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.allpurposeflour.Fragments.Fragment_2D_Main;
import com.example.allpurposeflour.Fragments.Fragment_3D_Main;
import com.example.allpurposeflour.R;
import com.example.allpurposeflour.Shape_2D;

public class Shape_3Index extends Fragment {
    String name;
    int imageID;
    TextView shapeName, shapeResult;
    ImageView shapeImage;
    Button shapeButton;
    ImageButton shapeBack;
    EditText shapeNum1, shapeNum2, shapeNum3;
    androidx.fragment.app.Fragment fragment_origin;

    public Shape_3Index(String name, int imageID, androidx.fragment.app.Fragment fragment){
        this.name = name;
        this.imageID = imageID;
        this.fragment_origin = fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shape_3index, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        shapeName = (TextView) view.findViewById(R.id.shape_name);
        shapeImage = (ImageView) view.findViewById(R.id.shape_image);
        shapeButton = (Button) view.findViewById(R.id.shape_calculate_btn);
        shapeBack = (ImageButton) view.findViewById(R.id.shape_image_btn);
        shapeNum1 = (EditText) view.findViewById(R.id.shape_sideA);
        shapeNum2 = (EditText) view.findViewById(R.id.shape_sideB);
        shapeNum3 = (EditText) view.findViewById(R.id.shape_sideC);
        shapeResult = (TextView) view.findViewById(R.id.shape_result);
        shapeName.setText(name);
        shapeImage.setImageResource(imageID);
        shapeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Shape_2D shape2D = new Shape_2D();
                shape2D.setShape_name(name);
                shapeResult.setText(Float.toString(shape2D.runCalculate
                        (Float.parseFloat(shapeNum1.getText().toString()), Float.parseFloat(shapeNum2.getText().toString()), Float.parseFloat(shapeNum3.getText().toString()))) + " cm²");
            }
        });
        shapeBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(fragment_origin);
            }
        });
    }

    private void setFragment(Fragment fragment){
        FragmentManager manager = getParentFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.main_frame, fragment);
        transaction.commit();
    }
}