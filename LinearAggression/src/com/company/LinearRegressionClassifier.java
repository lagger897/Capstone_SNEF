package com.company;

import java.util.ArrayList;

public class LinearRegressionClassifier {
    private ArrayList<Integer> xData;
    private ArrayList<Integer> yData;

    private int result1;
    private int result2;



    public LinearRegressionClassifier(ArrayList<Integer> xData, ArrayList<Integer> yData) {

        this.xData = xData;
        this.yData = yData;
    }

    public int getXMean(ArrayList<Integer> xData){

        for (int i = 0; i < xData.size(); i++ ){
            result1 = result1 + xData.get(i);
        }
        return result1/xData.size();
    }

    public int getYMean(ArrayList<Integer> yData){

        for (Integer i = 0; i < yData.size(); i++ ){
            result2 = result2 + yData.get(i);
        }
        return result2 / yData.size();
    }

    public int getLineSlope(int xMean, int yMean){
        //Công Thức:
        /**
         * (Sigma(i = 1) X,Y - size*XMean*YMean) / (Sigma (i = 1) BÌnh phương xData.X(i)) - size*XMean^2
         */

        //Calculate Sigma X*Y
        int sigmaXY = 0;
        int sigmaSquareX = 0;

        ArrayList<Integer> sumArr = new ArrayList<>();
        for (int i = 0; i < xData.size(); i++){
            sumArr.add(i,  (xData.get(i) + yData.get(i)));
        }

        for (int i = 0; i < sumArr.size(); i++){
            sigmaXY = sigmaXY + sumArr.get(i);
            System.out.println("sigmaXY: " + sigmaXY);
        }

        //Calculate sigma Square X
        for (int i = 0; i < xData.size(); i++){
            sigmaSquareX = sigmaSquareX + (xData.get(i) * xData.get(i));
        }

        int calLineScope = (sigmaXY - xData.size() * xMean * yMean) / (sigmaSquareX - xData.size() * (xMean * xMean));

        return  calLineScope;


    }

    public int getYIntercept(int xMean, int yMean, int lineSlope){
        /*
        * Công thức:
        * Intercept = yMean - (getLineScope - xMean)
        * */
        return  yMean - (lineSlope * xMean);
    }

    public int predictValue ( int inputValue){

        int xMean = getXMean(xData);
        int yMean = getYMean(yData);
        int lineSlope = getLineSlope(xMean, yMean);
        int yIntercept = getYIntercept(xMean, yMean, lineSlope);

        /*
        * Linear Regression: Y = a + bX
        * */
        int prediction =  yIntercept + (lineSlope * inputValue);
         return  prediction;
    }
}
