/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.snef.WebAdmin.api;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Phuc Nguyen -VN
 */
@RestController
@RequestMapping("/api/image")
public class ImageAPIController {
    private static final String CLOUDINARY_CLOUD_NAME = "dr4hpc9gi";
    private static final String CLOUDINARY_API_KEY = "166957351197671";
    private static final String CLOUDINARY_API_SECRET = "zakaWJRkTxjvVutIlhrhqOxpWDk";
    @PostMapping("/upload")
    public String uploadImg(@RequestParam(value = "file") MultipartFile file){
        try{
            byte[] bytes =file.getBytes();
            Path path = Paths.get("" + file.getOriginalFilename());
//            Cloudinary cloudinary = new Cloudinary();
            File myFile = new File(String.valueOf(Files.write(path, bytes)));
            HashMap<String, String> config = new HashMap<>();
            config.put("cloud_name", CLOUDINARY_CLOUD_NAME);
            config.put("api_key", CLOUDINARY_API_KEY);
            config.put("api_secret", CLOUDINARY_API_SECRET);
            Cloudinary cloudinary = new Cloudinary(config);
            HashMap<String, String> uploadResult= (HashMap<String, String>) cloudinary.uploader().upload(myFile, ObjectUtils.emptyMap());
           
            return String.valueOf(uploadResult.get("url"));

        }catch (IOException e){
            e.printStackTrace();
        }
        return "uploadcloud";
    }
}
