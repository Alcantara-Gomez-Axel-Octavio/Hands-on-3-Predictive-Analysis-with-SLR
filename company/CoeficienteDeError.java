package com.company;

import java.util.ArrayList;

public class CoeficienteDeError {

    public static double calcularErrorCuadraticoMedio(ArrayList<DataSet> data, SimpleLinearRegression modelo) {
        double error = 0;
        for (DataSet p: data) {
            double prediccion = modelo.predict(p.getX());
            error += Math.pow(prediccion - p.getY(), 2);
        }
        return error / data.size();
    }

    public static double correlacion(double n,double sumXY, double sumX, double sumY, double sumX2, double sumY2){
        double Correlacion=(n * sumXY - sumX * sumY) /
                Math.sqrt((n * sumX2 - sumX * sumX) * (n * sumY2 - sumY * sumY));

        return Correlacion;
    }

    public static double R2(ArrayList<DataSet> data, double B0, double B1) {
        double sumSquaredTotal = 0;
        double sumSquaredResidual = 0;
        double meanY = 0;

        // Calcular la media de Y
        for (DataSet p : data) {
            meanY += p.getY();
        }
        meanY /= data.size();

        for (DataSet p : data) {
            // Total sum of squares
            sumSquaredTotal += Math.pow(p.getY() - meanY, 2);
            // Residual sum of squares
            sumSquaredResidual += Math.pow(p.getY() - (B0 + B1 * p.getX()), 2);
        }

        // R^2 = 1 - (SS_res / SS_tot)
        return 1 - (sumSquaredResidual / sumSquaredTotal);
    }






}

