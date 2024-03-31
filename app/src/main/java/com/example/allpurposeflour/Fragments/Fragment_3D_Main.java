package com.example.allpurposeflour.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.allpurposeflour.Fragments.Fragment_2D.Shape;
import com.example.allpurposeflour.Fragments.Fragment_2D.Shape_1Index;
import com.example.allpurposeflour.Fragments.Fragment_2D.Shape_3Index;
import com.example.allpurposeflour.MainActivity;
import com.example.allpurposeflour.R;
import com.example.allpurposeflour.RV_Adapter;
import com.example.allpurposeflour.Shape_2D;

import java.util.ArrayList;

public class Fragment_3D_Main extends Fragment {

    RecyclerView main_2d_recycler;
    RV_Adapter main_2d_adapter;
    ArrayList<Shape_2D> main_2d_data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_3_d__main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        main_2d_recycler = view.findViewById(R.id.fragment_2D_recycler);
        main_2d_data = new ArrayList<Shape_2D>();

        Shape_2D sphere = new Shape_2D();
        sphere.setShape_name("Sphere");
        sphere.setShape_description("Tensile strenth is insane with this one");
        sphere.setShape_image(R.mipmap.ic_launcher);
        sphere.setShape_fragment(new Shape_1Index("Sphere", R.mipmap.ic_launcher, new Fragment_3D_Main()));

        Shape_2D cube = new Shape_2D();
        cube.setShape_name("Cube");
        cube.setShape_description("C U B E");
        cube.setShape_image(R.mipmap.ic_launcher);
        cube.setShape_fragment(new Shape_1Index("Cube", R.mipmap.ic_launcher, new Fragment_3D_Main()));

        Shape_2D cylinder = new Shape_2D();
        cylinder.setShape_name("Cylinder");
        cylinder.setShape_description("Fancy for a can of beer?");
        cylinder.setShape_image(R.mipmap.ic_launcher);
        cylinder.setShape_fragment(new Shape("Cylinder", R.mipmap.ic_launcher, new Fragment_3D_Main()));

        Shape_2D square_pyramid = new Shape_2D();
        square_pyramid.setShape_name("Pyramid (Sq)");
        square_pyramid.setShape_description("Is this Egypt reference?");
        square_pyramid.setShape_image(R.mipmap.ic_launcher);
        square_pyramid.setShape_fragment(new Shape("Sq-Pyr", R.mipmap.ic_launcher, new Fragment_3D_Main()));

        Shape_2D triangle_pyramid = new Shape_2D();
        triangle_pyramid.setShape_name("Pyramid (Tri)");
        triangle_pyramid.setShape_description("Simple, yet beautiful");
        triangle_pyramid.setShape_image(R.mipmap.ic_launcher);
        triangle_pyramid.setShape_fragment(new Shape_3Index("Tri-Pyr", R.mipmap.ic_launcher, new Fragment_3D_Main()));

        Shape_2D triangle_prism = new Shape_2D();
        triangle_prism.setShape_name("Prism (Tri)");
        triangle_prism.setShape_description("C H O D E");
        triangle_prism.setShape_image(R.mipmap.ic_launcher);
        triangle_prism.setShape_fragment(new Shape_3Index("Tri-Prism", R.mipmap.ic_launcher, new Fragment_3D_Main()));

        Shape_2D cuboid = new Shape_2D();
        cuboid.setShape_name("Cuboid");
        cuboid.setShape_description("Cube, but longer");
        cuboid.setShape_image(R.mipmap.ic_launcher);
        cuboid.setShape_fragment(new Shape_3Index("Cuboid", R.mipmap.ic_launcher, new Fragment_3D_Main()));

        main_2d_data.add(sphere);
        main_2d_data.add(cylinder);
        main_2d_data.add(triangle_prism);
        main_2d_data.add(cube);
        main_2d_data.add(cuboid);
        main_2d_data.add(triangle_pyramid);
        main_2d_data.add(square_pyramid);

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