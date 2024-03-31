package com.example.allpurposeflour.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.allpurposeflour.Login_Page;
import com.example.allpurposeflour.MainActivity;
import com.example.allpurposeflour.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;

public class Fragment_Profile extends Fragment {

    private boolean is_logged_in;
    MaterialButton profile_main_edit, profile_main_about, profile_main_logIn;
    TextView username;
    TextView email;
    ImageView profile_main_background;
    ShapeableImageView profile_main_picture;

    public Fragment_Profile(boolean is_logged_in){
        this.is_logged_in = is_logged_in;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment__profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        username = view.findViewById(R.id.profile_username);
        email = view.findViewById(R.id.profile_email);
        profile_main_logIn = view.findViewById(R.id.profile_logIn);
        profile_main_picture = view.findViewById(R.id.profile_picture);
        profile_main_background = view.findViewById(R.id.profile_image_background);

        if (is_logged_in){
            username.setText("Nail Zhavier");
            email.setText("ayy.kayy7563@gmail.com");
            profile_main_logIn.setText("Log Out");
            profile_main_picture.setImageResource(R.drawable.nail_profile);
            profile_main_background.setImageResource(R.drawable.nail_background);
            profile_main_logIn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getContext(), MainActivity.class);
                    i.putExtra("username", "");
                    i.putExtra("email", "");
                    startActivity(i);
                }
            });
        }
        else {
            username.setText("Guest");
            email.setText("guest.email.com");
            profile_main_logIn.setText("Log In");
            profile_main_picture.setImageResource(R.mipmap.ic_launcher);
            profile_main_background.setImageResource(R.drawable.ic_launcher_background);
            profile_main_logIn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getContext(), Login_Page.class));
                }
            });
        }
    }
}