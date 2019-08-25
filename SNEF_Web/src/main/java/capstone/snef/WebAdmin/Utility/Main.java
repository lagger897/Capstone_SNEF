package capstone.snef.WebAdmin.Utility;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println(System.getProperty("user.dir") + "/config.csv");
        // write your code here
        System.out.println("Linear Regression");
        ArrayList<Double> SalePerWeek = new ArrayList<>(); // Tưởng ứng với giá trị X
        ArrayList<Double> priceProduct = new ArrayList<>(); // Tương ứng với giá trị Y
//        ArrayList<Double> sumArray = new ArrayList<>();
        // Tính thời gian bán hết sản phẩm dựa trên giá tiền của sản phẩm
        File f = new File(System.getProperty("user.dir") + "/config.csv");
        if (f.exists()) {
            List<String[]> list = csvUtility.readAllFile(f);

            for (String data : list.get(0)) {
                SalePerWeek.add(Double.parseDouble(data));
            }
            for (String data : list.get(1)) {
                priceProduct.add(Double.parseDouble(data));
            }

        } else {
            SalePerWeek.add(0.12);
            SalePerWeek.add(5.83);
            SalePerWeek.add(1.9);
            priceProduct.add(30000.0);
            priceProduct.add(28000.0);
            priceProduct.add(24750.0);
            List<String[]> data = new ArrayList();
            List<String> sale = new ArrayList();
            sale.add(0.12 + "");
            sale.add(5.83 + "");
            sale.add(1.9 + "");
            data.add(sale.toArray(new String[sale.size()]));
            List<String> price = new ArrayList();
            price.add(30000.0 + "");
            price.add(28000.0 + "");
            price.add(24750.0 + "");
            data.add(price.toArray(new String[price.size()]));
            csvUtility.writeFile(data, System.getProperty("user.dir"), "config.csv");

        }
        LinearRegressionClassifier linearRegressionClassifier
                = new LinearRegressionClassifier(SalePerWeek, priceProduct);

        /**
         * Prediction duration Show will know how many product sells
         */
        double prediction = linearRegressionClassifier.predictValue(3.0);
        System.out.println("Price Product: " + prediction);

//        for (int i = 0; i < priceProduct.size(); i++){
//            sumArray.add(i, (duration.get(i) + priceProduct.get(i)));
//            System.out.println("Sum Array: " + sumArray.get(i));
//        }
    }

}
