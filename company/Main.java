package com.company;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        int j=1;
        int NumeroDeDataSplitting = 2;

        RegressionLinealSimple(NumeroDeDataSplitting);


    }



    public static void RegressionLinealSimple(int NumeroDeDataSplitting){

        /* SLR */
        // Simulamos una lista de datos
        ArrayList<DataSet> data = DataSet.leerDatos();

        // Creamos una instancia de SimpleLinearRegression
        SimpleLinearRegression regresionLineal = new SimpleLinearRegression();

        // Calculamos el modelo basado en los datos
        Modelo modelo = regresionLineal.calcularModelo(data);

        // Creamos una instancia de la clase Modelo para almacenar y comparar
        Modelo comparadorDeModelos = new Modelo();

        // Agregamos el modelo generado a la lista de modelos
        comparadorDeModelos.agregarModelo(modelo);

        /* Simulaciones */
        double[] simulaciones = {20, 30, 40, 45, 50};
        for (double simulacion : simulaciones) {
            double prediccion = regresionLineal.predict(simulacion);
            System.out.println("Para x = " + simulacion + ", y = " + prediccion);
        }

        /* DataSplitting */
        for (int i = 0; i < NumeroDeDataSplitting; i++) {
            Modelo nuevoModelo = regresionLineal.PruebaDataSplitting(data);
            comparadorDeModelos.agregarModelo(nuevoModelo);  // Agregar cada modelo a la lista
        }

        /* Mostrar mejor modelo */
        comparadorDeModelos.encontrarMejorModelo();

    }





}


