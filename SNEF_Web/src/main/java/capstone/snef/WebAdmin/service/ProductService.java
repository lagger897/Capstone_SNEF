/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.snef.WebAdmin.service;

import capstone.snef.WebAdmin.dataform.FlashSaleForm;
import capstone.snef.WebAdmin.dataform.InStoreProduct;
import capstone.snef.WebAdmin.dataform.Message;
import capstone.snef.WebAdmin.dataform.ProductData;
import capstone.snef.WebAdmin.dataform.FlashSaleProductData;
import capstone.snef.WebAdmin.dataform.StoreProductData;
import capstone.snef.WebAdmin.entity.FlashsaleProduct;
import capstone.snef.WebAdmin.entity.Flashsales;
import capstone.snef.WebAdmin.entity.Product;
import capstone.snef.WebAdmin.entity.Store;
import capstone.snef.WebAdmin.entity.StoreProduct;
import capstone.snef.WebAdmin.repository.IProductRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import capstone.snef.WebAdmin.repository.IStoreProductRepository;
import capstone.snef.WebAdmin.repository.IStoreRepository;
import java.util.Date;
import java.util.Optional;
import capstone.snef.WebAdmin.repository.IFlashSaleProductRepository;
import capstone.snef.WebAdmin.repository.IFlashsaleRepository;

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
    private IFlashSaleProductRepository flashSaleProductRepos;
    @Autowired
    private IFlashsaleRepository flashSaleRepos;

    public List<Product> getAllProduct() {
        return productRepos.findAll();
    }

    public List<FlashSaleProductData> getAllStoreProductWithFlashSaleByStoreId(Integer id) {
        System.out.println(id);
        List<FlashSaleProductData> list = new ArrayList<>();
        Optional<Store> store = storeRepos.findById(id);
        if (!store.isPresent()) {
            return null;
        }
        List<Flashsales> flashsales = flashSaleRepos.findAllByStoreId(store.get());
        for (Flashsales flashsale : flashsales) {
//            if (flashsale.getEndDate().compareTo(new Date()) <= 0) {
            List<FlashsaleProduct> products = flashSaleProductRepos.findAllByFlashSalesId(flashsale);
            if (products.size() > 0) {
                for (FlashsaleProduct product : products) {

                    FlashSaleProductData productData = new FlashSaleProductData();
                    productData.setName(product.getStoreProductId().getProductName());
                    productData.setImage(product.getStoreProductId().getStoreProductImageList().get(0).getImageSrc());
                    productData.setExpireDate(product.getStoreProductId().getExpiredDate());
                    productData.setDiscPrice(Math.round((100-product.getFlashSalesId().getDiscount()) * product.getStoreProductId().getPrice() / 100));
                    productData.setTotalQuantity(product.getQuantity());
                    int soldNum = 0;
                    try {
                        soldNum = product.getOrderDetailList().size();
                    } catch (Exception e) {
                    }
                    productData.setSoldNum(soldNum);
                    productData.setInStock(product.getQuantity() - soldNum);
                    productData.setStatus(product.getStatus());
                    list.add(productData);
                }
            }
//            }
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

    public List<InStoreProduct> getAllStoreProduct(Integer storeId) {
        Optional<Store> store = storeRepos.findById(storeId);
        if (store.isPresent()) {
            List<StoreProduct> storeProducts = storeProductRepos.findAllByStoreId(store.get());
            if (storeProducts.size() > 0) {
                List<InStoreProduct> list = new ArrayList<>();
                for (StoreProduct storeProduct : storeProducts) {
                    list.add(new InStoreProduct(storeProduct.getStoreProductId(), storeProduct.getProductName(), storeProduct.getStoreProductImageList().isEmpty()
                            ? "" : storeProduct.getStoreProductImageList().get(0).getImageSrc(), storeProduct.getExpiredDate(), storeProduct.getQuantity(),
                            storeProduct.getPrice(), storeProduct.getDescription(), storeProduct.getSku()));
                }
                if (!list.isEmpty()) {
                    return list;
                }
            }
        }
        return null;
    }

    public Message saleProduct(FlashSaleForm body) {
        Optional<StoreProduct> storeProductRs = storeProductRepos.findById(body.getStoreProductId());
        if (storeProductRs.isPresent()) {
            StoreProduct storeProduct = storeProductRs.get();
            if (body.getQuantity() > storeProduct.getQuantity()) {
                return new Message(false, "Exceed the store product quantity");
            }
            if (body.getStartDate().compareTo(storeProduct.getExpiredDate()) > 0) {
                return new Message(false, "Start date must be before the expired date");
            }
            if (body.getEndDate().compareTo(storeProduct.getExpiredDate()) > 0) {
                return new Message(false, "End date must be before the expired date");
            }
            Flashsales flashsale = new Flashsales(body.getDiscount(), body.getStartDate(), body.getEndDate(), storeProduct.getStoreId());

            Flashsales rs = flashSaleRepos.save(flashsale);
            if (rs != null) {
                FlashsaleProduct fsp = new FlashsaleProduct();
                fsp.setQuantity(body.getQuantity());
                storeProduct.setQuantity(storeProduct.getQuantity() - body.getQuantity());
                fsp.setFlashSalesId(rs);
                fsp.setStoreProductId(storeProductRs.get());
//                    fsp.setStatus(1);
                FlashsaleProduct fspRs = flashSaleProductRepos.save(fsp);
                StoreProduct sp = storeProductRepos.save(storeProduct);
                if (fspRs != null && sp != null) {
                    return new Message(true, "Add success, return to home page");
                }
            }
        }
        return new Message(false, "Error somewhere i dont know");
    }

    public boolean deleteStoreProduct(Integer productId) {
        Optional<StoreProduct> spResult = storeProductRepos.findById(productId);
        if (spResult.isPresent()) {
            storeProductRepos.delete(spResult.get());
            return true;
        }
        return false;
    }

    public StoreProductData getStoreProduct(Integer productId) {
        Optional<StoreProduct> spResult = storeProductRepos.findById(productId);
        if (spResult.isPresent()) {
            StoreProduct storeProduct = spResult.get();
            return new StoreProductData(storeProduct.getStoreProductId(), storeProduct.getStoreProductImageList().get(0).getImageSrc(),
                    storeProduct.getProductName(), storeProduct.getExpiredDate(), storeProduct.getQuantity(),
                    (double) storeProduct.getPrice(), storeProduct.getDescription(), storeProduct.getSku());
        }
        return null;
    }

    public boolean updateStoreProduct(StoreProductData storeProductData) {
        Optional<StoreProduct> spResult = storeProductRepos.findById(storeProductData.getStoreProductId());
        if (spResult.isPresent()) {
            StoreProduct storeProduct = spResult.get();
            storeProduct.getStoreProductImageList().get(0).setImageSrc(storeProductData.getImageSrc());
            storeProduct.setProductName(storeProductData.getName());
            storeProduct.setQuantity(storeProductData.getQuantity());
            storeProduct.setPrice((float) storeProductData.getPrice());
            storeProduct.setDescription(storeProductData.getDescription());
            storeProduct.setSku(storeProductData.getSku());
            StoreProduct result = storeProductRepos.save(storeProduct);
            if (result != null) {
                return true;
            }
        }
        return false;
    }

}
