package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class DataSplitting {

    // Método para dividir los datos en un 70% de entrenamiento y 30% de prueba
    public static SplitResult DataSpliting(ArrayList<DataSet> data) {
        ArrayList<DataSet> trainData = new ArrayList<>();
        ArrayList<DataSet> testData = new ArrayList<>();

        // Barajar los datos para una distribución aleatoria
        Collections.shuffle(data);

        // Calcular el índice para dividir los datos en 70% y 30%
        int trainSize = (int) (data.size() * 0.7);

        // Separar los datos en entrenamiento (70%) y prueba (30%)
        for (int i = 0; i < data.size(); i++) {
            if (i < trainSize) {
                trainData.add(data.get(i));
            } else {
                testData.add(data.get(i));
            }
        }
        return new SplitResult(trainData, testData);
    }


    public static double PruebaDataSplitting(ArrayList<DataSet> data) {
        System.out.println("\n\n");

        // Creamos una instancia de SimpleLinearRegression
        SimpleLinearRegression regresion = new SimpleLinearRegression();

        // Realizamos el data splitting
        SplitResult result = DataSplitting.DataSpliting(data);

        ArrayList<DataSet> trainData = result.getTrainData();
        ArrayList<DataSet> testData = result.getTestData();

        // Calculamos el modelo basado en los datos de entrenamiento
        Modelo modelo2 = regresion.calcularModelo(trainData);

        // Calculamos el error en el conjunto de prueba
        double mseTest = 0;
        for (DataSet p : testData) {
            double prediccion = regresion.predict(p.getX());  // Predicción
            double error = p.getY() - prediccion;             // Error entre real y predicho
            mseTest += Math.pow(error, 2);                    // Sumar el cuadrado del error
        }
        mseTest /= testData.size();  // Promediar el error cuadrático


        // Imprimimos los resultados de este split
        System.out.println("Error Cuadrático Medio en Prueba: " + mseTest);

        // Imprimimos los valores del modelo
        System.out.println("Pendiente: " + modelo2.getPendiente());
        System.out.println("Intercepto: " + modelo2.getIntercept());
        System.out.println("Error Medio en Entrenamiento: " + modelo2.getError());

        // Imprimimos predicciones sobre los datos de prueba
        for (DataSet p : testData) {
            double prediccion = regresion.predict(p.getX()); // Usamos el valor X de los datos de prueba
            System.out.println("Para x = " + p.getX() + ", y real = " + p.getY() + ", predicción = " + prediccion);
        }

        return mseTest;
    }
}
