package capstone.snef.WebAdmin.Utility;

import java.util.ArrayList;

public class LinearRegressionClassifier {
    
    private ArrayList<Double> xData;
    private ArrayList<Double> yData;

    private double result1;
    private double result2;
   


    public LinearRegressionClassifier(ArrayList<Double> xData, ArrayList<Double> yData) {

        this.xData = xData;
        this.yData = yData;
    }

    public double getXMean(ArrayList<Double> xData){

        for (int i = 0; i < xData.size(); i++ ){
            result1 = result1 + xData.get(i);
        }
        return result1/xData.size();
    }

    public double getYMean(ArrayList<Double> yData){

        for (int i = 0; i < yData.size(); i++ ){
            result2 = result2 + yData.get(i);
        }
        return result2 / yData.size();
    }

    public double getLineSlope(double xMean, double yMean){
        //Công Thức:
        /**
         * (Sigma(i = 1) X,Y - size*XMean*YMean) / (Sigma (i = 1) BÌnh phương xData.X(i)) - size*XMean^2
         */

        //Calculate Sigma X*Y
        double sigmaXY = 0;
        double sigmaSquareX = 0;

        ArrayList<Double> sumArr = new ArrayList<>();
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

        double calLineScope = (sigmaXY - xData.size() * xMean * yMean) / (sigmaSquareX - xData.size() * (xMean * xMean));

        return  calLineScope;


    }

    public double getYIntercept(double xMean, double yMean, double lineSlope){
        /*
        * Công thức:
        * Intercept = yMean - (getLineScope - xMean)
        * */
        return  yMean - (lineSlope * xMean);
    }

    public double predictValue ( double inputValue){

        double xMean = getXMean(xData);
        double yMean = getYMean(yData);
        double lineSlope = getLineSlope(xMean, yMean);
        double yIntercept = getYIntercept(xMean, yMean, lineSlope);

        /*
        * Linear Regression: Y = a + bX
        * */
        double prediction =  yIntercept + (lineSlope * inputValue);
         return  prediction;
    }
}
