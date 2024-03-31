package com.example.allpurposeflour;

import android.app.Activity;
import android.app.Fragment;

import com.example.allpurposeflour.Fragments.Fragment_2D.Shape;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Shape_2D {
    private String shape_name;
    private String shape_description;
    private int shape_image;
    private androidx.fragment.app.Fragment shape_fragment;
    String[] shape_1index = {"Circle", "Hexagon", "Octagon", "Sphere", "Cube", "Square"};
    String[] shape_2index = {"Rectangle","Triangle","P.gram", "Diamond", "Cylinder", "Sq-Pyr"};
    String[] shape_3index = {"Tri-Prism", "Tri-Pyr", "Cuboid"};



    public float oneParams(float num1){
        float result = 0;
        switch (this.shape_name){
            case "Square":
                result = (float)Math.pow(num1,2);
                break;
            case "Circle":
                result = (float)(Math.PI * Math.pow(num1, 2));
                break;
            case "Hexagon":
                result = (float)(((3*Math.sqrt(3))/2)*Math.pow(num1, 2));
                break;
            case "Octagon":
                result = (float)(2*(1+Math.sqrt(2))*Math.pow(num1, 2));
                break;
            case "Sphere":
                result = (float)((4/3) * Math.PI * Math.pow(num1, 3));
                break;
            case "Cube":
                result = (float)(Math.pow(num1, 3));
                break;
            default:
                result = 0;
        }
        return result;
    }
    public float twoParams(float num1, float num2){
        float result = 0;
        switch (this.shape_name){
            case "Rectangle":
                result = (float)(num1*num2);
                break;
            case "Triangle":
                result = (float)(num1*num2)/2;
                break;
            case "P.gram":
                result = (float)(num1*num2);
                break;
            case "Diamond":
                result = (float)(num1*num2);
                break;
            case "Cylinder":
                result = (float)((Math.PI * Math.pow(num1, 2)) * num2);
                break;
            case "Sq-Pyr":
                result = (float)((Math.pow(num1, 2) * num2)/3);
                break;
            default:
                result = 0;
        }
        return result;
    }
    public float threeParams(float num1, float num2, float num3){
        float result = 0;
        switch (this.shape_name){
            case "Tri-Prism":
                result = (float)(((float)(num1*num2) / 2) * (float)num3);
                break;
            case "Tri-Pyr":
                result = (float)((float)(((float)num1 * (float) num2)/2) * (float) num3);
                break;
            case "Cuboid":
                result = (float)(num1*num2*num3);
                break;
            default:
                result = 0;
        }
        return result;
    }



    public float runCalculate(float num1, float num2, float num3){
        float result = 0;
        if (Arrays.asList(shape_2index).contains(shape_name)){
            result = twoParams(num1, num2);
        } else if (Arrays.asList(shape_1index).contains(shape_name)) {
            result = oneParams(num1);
        } else if (Arrays.asList(shape_3index).contains(shape_name)){
            result = threeParams(num1, num2, num3);
        }
        return result;
    }



    public androidx.fragment.app.Fragment getShape_fragment() {
        return shape_fragment;
    }
    public void setShape_fragment(androidx.fragment.app.Fragment shape_fragment) {
        this.shape_fragment = shape_fragment;
    }



    public String getShape_name() {
        return shape_name;
    }
    public void setShape_name(String shape_name) {
        this.shape_name = shape_name;
    }



    public String getShape_description() {
        return shape_description;
    }
    public void setShape_description(String shape_description) {
        this.shape_description = shape_description;
    }



    public int getShape_image() {
        return shape_image;
    }
    public void setShape_image(int shape_image) {
        this.shape_image = shape_image;
    }
}
