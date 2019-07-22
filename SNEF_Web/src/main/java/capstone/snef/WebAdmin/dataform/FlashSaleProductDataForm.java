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
public class FlashSaleProductDataForm {
    private List<FlashSaleProductData> data;

    public FlashSaleProductDataForm() {
        
    }

    public FlashSaleProductDataForm(List<FlashSaleProductData> data) {
        this.data = data;
    }

    public List<FlashSaleProductData> getData() {
        return data;
    }

    public void setData(List<FlashSaleProductData> data) {
        this.data = data;
    }

    
}
