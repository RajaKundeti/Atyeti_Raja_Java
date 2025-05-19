package productinventory;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductService {

    public Map<String, List<Product>> groupProductsByCategory(List<Product> productData) {
        return productData.stream()
                .collect(Collectors.groupingBy(Product::getCategory,Collectors.toList()));
    }


    public Map<String, Optional<Product>> findExpensiveProductInEachCategory(List<Product> productData) {
        return productData.stream()
                .collect(Collectors
                        .groupingBy(Product::getCategory,Collectors.maxBy(Comparator.comparing(Product::getPrice))));
    }

    public List<Product> getProductsWithinQuantity(List<Product> productData, int i) {
        return productData.stream()
                .filter(p->p.getQuantity()>=i)
                .collect(Collectors.toList());
    }
}
