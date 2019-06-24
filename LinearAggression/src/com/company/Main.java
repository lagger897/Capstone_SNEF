package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Linear Regression");
        ArrayList<Integer> duration = new ArrayList<>(); // Tưởng ứng với giá trị X
        ArrayList<Integer> priceProduct = new ArrayList<>(); // Tương ứng với giá trị Y
        ArrayList<Integer> sumArray = new ArrayList<>();
        // Tính thời gian bán hết sản phẩm dựa trên giá tiền của sản phẩm

        duration.add(23);
        duration.add(12);
        duration.add(32);
        duration.add(6);
        duration.add(13);

        priceProduct.add(100000);
        priceProduct.add(23000);
        priceProduct.add(80000);
        priceProduct.add(7000);
        priceProduct.add(63000);



        LinearRegressionClassifier linearRegressionClassifier
                = new LinearRegressionClassifier(priceProduct, duration);

        /**
         * Prediction duration
         * Show will know how many product sells
         */

        int prediction = linearRegressionClassifier.predictValue(25000);
        System.out.println("Durations: " + prediction);

//        for (int i = 0; i < priceProduct.size(); i++){
//            sumArray.add(i, (duration.get(i) + priceProduct.get(i)));
//            System.out.println("Sum Array: " + sumArray.get(i));
//        }
    }

}
