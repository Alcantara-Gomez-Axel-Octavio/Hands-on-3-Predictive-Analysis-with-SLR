package com.company;

import java.util.ArrayList;


public class MatematicasDiscretas {

    public static double SumaDeX(ArrayList<DataSet> data){
        double sumX=0;

        for (DataSet p : data) {
            sumX += p.getX();
        }
        return sumX;
    }

    public static double SumaDeY(ArrayList<DataSet> data){
        double sumY=0;

        for (DataSet p : data) {
            sumY += p.getY();
        }
        return sumY;
    }

    public static double SumaDeX2(ArrayList<DataSet> data){
        double sumX2=0;

        for (DataSet p : data) {
            sumX2 += p.getX() * p.getX();
        }
        return sumX2;
    }

    public static double SumaDeXY(ArrayList<DataSet> data){
        double sumXY=0;

        for (DataSet p : data) {
            sumXY += p.getX() * p.getY();
        }
        return sumXY;
    }

    public static double SumaDeY2(ArrayList<DataSet> data){
        double sumY2=0;

        for (DataSet p : data) {
            sumY2 += p.getY() * p.getY();
        }
        return sumY2;
    }

}
