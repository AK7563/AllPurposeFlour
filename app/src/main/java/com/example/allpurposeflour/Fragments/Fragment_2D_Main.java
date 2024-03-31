package com.example.allpurposeflour.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.allpurposeflour.Fragments.Fragment_2D.Shape;
import com.example.allpurposeflour.Fragments.Fragment_2D.Shape_1Index;
import com.example.allpurposeflour.MainActivity;
import com.example.allpurposeflour.R;
import com.example.allpurposeflour.RV_Adapter;
import com.example.allpurposeflour.Shape_2D;

import java.util.ArrayList;

public class Fragment_2D_Main extends Fragment {

    RecyclerView main_2d_recycler;
    RV_Adapter main_2d_adapter;
    ArrayList<Shape_2D> main_2d_data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_2_d__main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        main_2d_recycler = view.findViewById(R.id.fragment_2D_recycler);
        main_2d_data = new ArrayList<Shape_2D>();

        Shape_2D triangle = new Shape_2D();
        triangle.setShape_name("Triangle");
        triangle.setShape_description("Triangles are the strongest shape in the universe");
        triangle.setShape_image(R.mipmap.ic_launcher);
        triangle.setShape_fragment(new Shape("Triangle", R.mipmap.ic_launcher, new Fragment_2D_Main()));

        Shape_2D square = new Shape_2D();
        square.setShape_name("Square");
        square.setShape_description("Square is a four sided shape seen everywhere");
        square.setShape_image(R.mipmap.ic_launcher);
        square.setShape_fragment(new Shape_1Index("Square", R.mipmap.ic_launcher, new Fragment_2D_Main()));

        Shape_2D rectangle = new Shape_2D();
        rectangle.setShape_name("Rectangle");
        rectangle.setShape_description("Rectangle is a square but longer");
        rectangle.setShape_image(R.mipmap.ic_launcher);
        rectangle.setShape_fragment(new Shape("Rectangle", R.mipmap.ic_launcher, new Fragment_2D_Main()));

        Shape_2D parallelogram = new Shape_2D();
        parallelogram.setShape_name("P.gram");
        parallelogram.setShape_description("One of my most hated shapes :3");
        parallelogram.setShape_image(R.mipmap.ic_launcher);
        parallelogram.setShape_fragment(new Shape("P.gram", R.mipmap.ic_launcher, new Fragment_2D_Main()));

        Shape_2D diamond = new Shape_2D();
        diamond.setShape_name("Diamond");
        diamond.setShape_description("LIKE THE DIAMONDS IN THE SKY");
        diamond.setShape_image(R.mipmap.ic_launcher);
        diamond.setShape_fragment(new Shape("Diamond", R.mipmap.ic_launcher, new Fragment_2D_Main()));

        Shape_2D hexagon = new Shape_2D();
        hexagon.setShape_name("Hexagon");
        hexagon.setShape_description("Hexagon are thought to rival the triangle");
        hexagon.setShape_image(R.mipmap.ic_launcher);
        hexagon.setShape_fragment(new Shape_1Index("Hexagon", R.mipmap.ic_launcher, new Fragment_2D_Main()));

        Shape_2D octagon = new Shape_2D();
        octagon.setShape_name("Octagon");
        octagon.setShape_description("Octagon is just... an octagon");
        octagon.setShape_image(R.mipmap.ic_launcher);
        octagon.setShape_fragment(new Shape_1Index("Octagon", R.mipmap.ic_launcher, new Fragment_2D_Main()));

        Shape_2D circle = new Shape_2D();
        circle.setShape_name("Circle");
        circle.setShape_description("Circles has the best tensile strength");
        circle.setShape_image(R.mipmap.ic_launcher);
        circle.setShape_fragment(new Shape_1Index("Circle", R.mipmap.ic_launcher, new Fragment_2D_Main()));


        main_2d_data.add(triangle);
        main_2d_data.add(square);
        main_2d_data.add(rectangle);
        main_2d_data.add(parallelogram);
        main_2d_data.add(diamond);
        main_2d_data.add(hexagon);
        main_2d_data.add(octagon);
        main_2d_data.add(circle);

        main_2d_adapter = new RV_Adapter(getContext(), main_2d_data);
        main_2d_recycler.setAdapter(main_2d_adapter);
        main_2d_recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        main_2d_adapter.setClickListener(this::onItemClick);
    }

    public void onItemClick(View view, int position) {
//        startActivity(new Intent(getActivity(), main_2d_adapter.getActivity(position).getClass()));
        setFragment(main_2d_adapter.getFragment(position));
    }

    private void setFragment(Fragment fragment){
        FragmentManager manager = getParentFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.main_frame, fragment);
        transaction.commit();
    }
}