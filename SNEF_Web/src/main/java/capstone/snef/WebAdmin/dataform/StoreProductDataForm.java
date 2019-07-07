/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.snef.WebAdmin.dataform;

import java.util.List;

/**
 *
 * @author Phuc Nguyen -VN
 */
public class StoreProductDataForm {
    private List<StoreProductData> data;

    public StoreProductDataForm() {
    }

    public StoreProductDataForm(List<StoreProductData> data) {
        this.data = data;
    }

    public List<StoreProductData> getData() {
        return data;
    }

    public void setData(List<StoreProductData> data) {
        this.data = data;
    }

    
}
