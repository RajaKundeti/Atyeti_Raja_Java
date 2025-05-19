package productinventory;


import java.util.List;

public class ProductManagement {

    private static final String path = "C:\\Users\\RajaNarasimhanKundet\\OneDrive - Atyeti Inc\\Desktop\\Self\\JavaPOC\\Atyeti_Raja_Java\\Raja_19052025\\src\\productinventory\\products.csv";
    private static final ProductService productService = new ProductService();

    public static void main(String[] args) {

        List<Product> productData = FileUtil.getProductData(path);

        System.out.println("Products by Category: ");
        System.out.println(productService.groupProductsByCategory(productData));
        System.out.println();

        System.out.println("Expensive Products in each Category: ");
        System.out.println(productService.findExpensiveProductInEachCategory(productData));
        System.out.println();

        System.out.println("Products available within the quantity: ");
        System.out.println(productService.getProductsWithinQuantity(productData,10));
        System.out.println();
    }
}
