/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.snef.WebAdmin.Utility;

import capstone.snef.WebAdmin.dataform.Message;
import capstone.snef.WebAdmin.entity.StoreProduct;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Phuc Nguyen -VN
 */
@Component
public class ImageUtility {

    @Autowired
    private Environment env;
    private final String CLOUDINARY_CLOUD_NAME = env.getProperty("cloud_name");
    private final String CLOUDINARY_API_KEY = env.getProperty("cloudinary.api.key");
    private final String CLOUDINARY_API_SECRET = env.getProperty("cloudinary.api.secrect");

    @Bean
    public String uploadImage(MultipartFile file) {
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get("" + file.getOriginalFilename());
//            Cloudinary cloudinary = new Cloudinary();
            File myFile = new File(String.valueOf(Files.write(path, bytes)));
            HashMap<String, String> config = new HashMap<>();
            config.put("cloud_name", CLOUDINARY_CLOUD_NAME);
            config.put("api_key", CLOUDINARY_API_KEY);
            config.put("api_secret", CLOUDINARY_API_SECRET);
            Cloudinary cloudinary = new Cloudinary(config);
            HashMap<String, String> uploadResult = (HashMap<String, String>) cloudinary.uploader().upload(myFile, ObjectUtils.emptyMap());
            String imageSrc = String.valueOf(uploadResult.get("url"));
            if (imageSrc != "") {
                return imageSrc;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
