
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author HELLO
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Object> options = new ArrayList<>();
        options.add("Thêm thủ kho");
        options.add("Thêm sản phẩm");
        options.add("Cập nhật thông tin sản phẩm");
        options.add("Tìm kiếm theo ...");
        options.add("Sắp xếp theo ...");
        
        int choice = 0;
        ProductList productList = new ProductList();
        StorekeeperList keeperList = new StorekeeperList();
        keeperList.add5Keeper();
        productList.add10Product(keeperList);
        
        do {
            System.out.println("\nChương trình quản lí sản phẩm: ");
            choice = Menu.getChoice(options);
            switch (choice) {
                case 1:
                    keeperList.addStorekeeper();
                    break;
                case 2:
                    productList.addProduct(keeperList);
                    break;
                case 3:
                    productList.updateProductAttribute(keeperList);
                    break;
                case 4:
                    productList.searchProduct(keeperList);
                    break;
                case 5:
                    productList.sortProduct();
                    break;
                default:
                    System.out.println("Bye!");
            }
        } while (choice > 0 && choice < 6);
    }
}
