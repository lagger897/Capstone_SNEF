/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.snef.WebAdmin.repository;

import capstone.snef.WebAdmin.entity.Product;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Phuc Nguyen -VN
 */
public interface IProductRepository extends CrudRepository<Product, Integer> {

    @Override
    public List<Product> findAll();

    public List<Product> findAllByProductName(String productName);
    
    @Query(value="SELECT * FROM Product p WHERE p.ProductName LIKE %?1%",nativeQuery = true)
    public List<Product> searchAllByProductName(String productName);

    @Override
    public Optional<Product> findById(Integer id);
    
    @Query(nativeQuery = true, value = "SELECT sum(od.Quantity) as QuantityBought, "
                + "((fs.Discount * sp.Price) / 100) as PriceD , DATEDIFF(fs.EndDate, fs.StartDate) as DateSale "
                + "from snef_part2.OrderDetail od, snef_part2.FlashsaleProduct fsp , snef_part2.StoreProduct sp  "
                + ", snef_part2.Flashsales fs "
                + " where od.FlashSaleProductId = fsp.FlashSaleProductId and sp.StoreProductId = fsp.StoreProductId  "
                + " and fs.FlashSalesId = fsp.FlashSalesId and sp.ProductId = :productId "
                + "group by od.FlashSaleProductId")
    public List<Long[]> calData(@Param("productId") Integer productId);
}
