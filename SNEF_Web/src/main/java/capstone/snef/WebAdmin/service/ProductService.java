/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.snef.WebAdmin.service;

import capstone.snef.WebAdmin.dataform.ProductData;
import capstone.snef.WebAdmin.dataform.StoreProductData;
import capstone.snef.WebAdmin.entity.FlashsaleProduct;
import capstone.snef.WebAdmin.entity.Product;
import capstone.snef.WebAdmin.entity.Store;
import capstone.snef.WebAdmin.entity.StoreProduct;
import capstone.snef.WebAdmin.repository.IFlashSaleRepository;
import capstone.snef.WebAdmin.repository.IProductRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import capstone.snef.WebAdmin.repository.IStoreProductRepository;
import capstone.snef.WebAdmin.repository.IStoreRepository;
import java.util.Date;
import java.util.Optional;

/**
 *
 * @author Phuc Nguyen -VN
 */
@Service
public class ProductService {

    @Autowired
    private IProductRepository productRepos;

    @Autowired
    private IStoreProductRepository storeProductRepos;
    @Autowired
    private IStoreRepository storeRepos;
    @Autowired
    private IFlashSaleRepository flashSaleRepos;

    public List<Product> getAllProduct() {
        return productRepos.findAll();
    }

    public List<StoreProductData> getAllStoreProductByStoreId(Integer id) {
        System.out.println(id);
        List<StoreProductData> list = new ArrayList<>();
        List<FlashsaleProduct> products = flashSaleRepos.findAllWithStoreProductId(id);
        if (products.size() > 0) {
            for (FlashsaleProduct product : products) {
                StoreProductData productData = new StoreProductData();
                productData.setName(product.getStoreProductId().getProductName());
                productData.setImage(product.getStoreProductId().getProductId().getImageSrc());
                productData.setExpireDate(product.getStoreProductId().getExpiredDate());
                productData.setDiscPrice(Math.round(product.getFlashSalesId().getDiscount() * product.getStoreProductId().getPrice() / 100));
                productData.setTotalQuantity(product.getQuantity());
                int soldNum = 0;
                try {
                    //soldNum = product.getOrderDetailList().size();

                } catch (Exception e) {
                }
                productData.setSoldNum(soldNum);
                productData.setInStock(product.getQuantity() - soldNum);
                list.add(productData);
            }
        }
        return list;
    }

    public List<Product> getProductByName(String name) {
        return productRepos.searchAllByProductName(name);
    }

    public ProductData getProductById(Integer id) {
        Optional<Product> rs = productRepos.findById(id);
        if (rs.isPresent()) {
            Product product = rs.get();
            return new ProductData(product.getProductId(), product.getProductName(), product.getImageSrc());
        }
        return null;
    }

    public StoreProduct saveStoreProduct(Integer storeId, Integer productId, String name, Date expiredDate, Integer ammount, double price, String description) {
        Optional<Product> rs = productRepos.findById(productId);
        if (rs.isPresent()) {
            StoreProduct storeProduct = new StoreProduct(name, expiredDate, ammount, (float) price);
            Optional<Store> store = storeRepos.findById(storeId);
            storeProduct.setStoreId(store.get());
            storeProduct.setProductId(rs.get());
            storeProduct.setStoreProductImageList(null);
            storeProduct.setLike1List(null);
            return storeProductRepos.save(storeProduct);
        }
        return null;
    }

}
