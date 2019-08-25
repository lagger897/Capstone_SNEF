/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.snef.WebAdmin.Utility;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Phuc Nguyen -VN
 */
public class csvUtility {

    public static List<String[]> readAllFile(File f){
        List<String[]> list = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            CSVReader csvReader = new CSVReader(reader);
            return csvReader.readAll();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(csvUtility.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(csvUtility.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public static void writeFile(List<String[]> data,String path,String name){
        try {
            File pathFile = new File(path);
            pathFile.mkdirs();
            String file=path+"/"+name;
            FileOutputStream fos=new FileOutputStream(file);
            OutputStreamWriter osw=new OutputStreamWriter(fos,StandardCharsets.UTF_8);
            CSVWriter csvWriter = new CSVWriter(osw);
            csvWriter.writeAll(data);
            csvWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(csvUtility.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
