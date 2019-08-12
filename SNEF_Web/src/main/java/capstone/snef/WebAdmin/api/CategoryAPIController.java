/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.snef.WebAdmin.api;

import capstone.snef.WebAdmin.entity.Categories;
import capstone.snef.WebAdmin.service.CategoryService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Phuc Nguyen -VN
 */
@RestController
@RequestMapping("/api/category")
public class CategoryAPIController {

    @Autowired
    private CategoryService cateServ;

    @GetMapping("/getAll")
    public List<Category> getAllCategories() {
        List<Category> list = new ArrayList();
        List<Categories> rs = cateServ.getAllCategories();
        if (rs != null && rs.size() > 0) {
            for (Categories r : rs) {
                list.add(new Category(r.getCategoriesId(), r.getCategoryName()));
            }
            return list;
        }
        return null;
    }
}

class Category {

    private Integer id;
    private String name;

    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
