package productinventory;
import employeemanagement.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static List<Product> getProductData(String filePath) {
        List<Product> products = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            br.readLine();
            String[] data = null;
            String line = null;
            while((line = br.readLine()) != null){
                data = line.split(",");
                Product p = new Product();
                p.setName(data[0]);
                p.setCategory(data[1]);
                p.setPrice(Double.parseDouble(data[2]));
                p.setQuantity(Integer.parseInt(data[3]));
                products.add(p);
            }
        }catch (IOException e){
            e.getStackTrace();
        }
        return products;
    }
}
