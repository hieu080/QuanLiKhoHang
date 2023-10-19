
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
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
public class ProductList extends HashMap<String, Product> {

    public ProductList() {
        super();
    }

    public Product search(String code) {
        code = code.trim().toUpperCase();
        if (this.containsKey(code)) {
            return this.get(code);
        }
        return null;
    }

    private boolean isCodeDupplicated(String code) {
        code = code.trim().toUpperCase();
        return search(code) != null;
    }

    private boolean compareDates(String dateStr1, String dateStr2) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            Date date1 = dateFormat.parse(dateStr1);
            Date date2 = dateFormat.parse(dateStr2);
            return date1.compareTo(date2) >= 0;
        } catch (ParseException e) {
            // Xử lý ngoại lệ nếu định dạng không hợp lệ
            e.printStackTrace();
            return false;
        }
    }

    public void addProduct(ArrayList<Storekeeper> KeeperList) {
        if (KeeperList.isEmpty()) {
            System.out.println("Chưa có thủ kho. Hãy thêm thủ kho trước.");
            return;
        }
        String id, name, location, expirydate, dateOfManufacture, category, receiptdate;
        Storekeeper storekeeper;
        double price;

        boolean codeDupplicated = false;
        do {
            id = Input.inputPattern("Mã sản phẩm P000: ", "[pP][\\d]{3}");
            id = id.trim().toUpperCase();
            codeDupplicated = isCodeDupplicated(id);
            if (codeDupplicated) {
                System.out.println("Mã sản phẩm trùng lặp!");
            }
        } while (codeDupplicated == true);

        name = Input.inputNonBlankStr("Tên sản phẩm: ");

        location = Input.inputNonBlankStr("Xuất xứ: ");
        location = location.toUpperCase();

        price = Input.inputDouble("Giá: ", 0, Integer.MAX_VALUE);

        expirydate = Input.inputDate("Ngày hết hạn: ");
        do {
            dateOfManufacture = Input.inputDate("Ngày sản xuất: ");
            if (compareDates(dateOfManufacture, expirydate) == false) {
                System.out.println("Ngày sản xuất phải trước ngày hết hạn.");
            }
        } while (compareDates(dateOfManufacture, expirydate));

        category = Input.selectCategory();

        storekeeper = Input.selectStorekeeper(KeeperList);
        do {
            receiptdate = Input.inputDate("Ngày nhập kho: ");
            if (compareDates(dateOfManufacture, receiptdate) == false) {
                System.out.println("Ngày nhập kho phải sau ngày sản xuất.");
            }
        } while (compareDates(dateOfManufacture, receiptdate));

        Product newProduct = new Product(id, name, location, price, expirydate, dateOfManufacture, category, storekeeper, receiptdate);
        this.put(id, newProduct);
        System.out.println("Sản phẩm " + id + " được nhập kho.");

    }

    public void updateProductAttribute(ArrayList<Storekeeper> KeeperList) {
        if (this.isEmpty()) {
            System.out.println("Kho hiện tại rỗng. Hãy nhập sản phẩm vào kho.");
            return;
        }
        String id = Input.inputPattern("Mã sản phẩm P000: ", "[pP][\\d]{3}");
        Product pr = this.search(id);
        if (pr == null) {
            System.out.println("Sản phẩm " + id + " không tồn tại");
        } else {
            boolean continueUpdating = true;
            String[] ListUpdate = {"Mã sản phẩm", "Tên sản phẩm", "Giá", "Ngày hết hạn", "Ngày sản xuất", "Danh mục", "Thủ kho", "Ngày nhập hàng", "Kết thúc cập nhật"};
            while (continueUpdating) {
                for (int i = 0; i < ListUpdate.length; i++) {
                    System.out.println((i + 1) + ". " + ListUpdate[i]);
                }

                int choice = Input.inputInt("Lựa chọn cập nhật (1-" + ListUpdate.length + "): ", 1, ListUpdate.length);
                Product oldValue = this.get(id);
                switch (choice) {
                    case 1:
                        String newID ;
                        do {                            
                            newID = Input.inputPattern("Mã sản phẩm P000: ", "[pP][\\d]{3}");
                            if(isCodeDupplicated(newID)){
                                System.out.println("Sản phẩm có mã " + newID + " đã tồn tại. Hãy nhập mã khác.");
                            }
                        } while (isCodeDupplicated(newID));
                                
                        this.remove(id);
                        this.put(newID, oldValue);
                        id = newID;
                        break;
                    case 2:
                        String newName = Input.inputStr("Tên mới của sản phẩm: ");
                        oldValue.setName(newName);
                        this.put(id, oldValue);
                        break;
                    case 3:
                        double newPrice = Input.inputDouble("Giá mới: ", 0, 1000000000);
                        oldValue.setPrice(newPrice);
                        this.put(id, oldValue);
                        break;
                    case 4:
                        String newExpiryDate = Input.inputDate("Nhập ngày hết hạn mới: ");
                        oldValue.setExpirydate(newExpiryDate);
                        this.put(id, oldValue);
                        break;
                    case 5:
                        String newManufactureDate = Input.inputDate("Nhập ngày sản xuất mới: ");
                        oldValue.setDateOfManufacture(newManufactureDate);
                        this.put(id, oldValue);
                        break;
                    case 6:
                        String newCategory = Input.selectCategory();
                        oldValue.setCategory(newCategory);
                        this.put(id, oldValue);
                        break;
                    case 7:
                        Storekeeper newKeeper = Input.selectStorekeeper(KeeperList);
                        oldValue.setStorekeeper(newKeeper);
                        this.put(id, oldValue);
                        break;
                    case 8:
                        String newReceiptDate = Input.inputDate("Nhập ngày nhập hàng mới: ");
                        oldValue.setReceiptdate(newReceiptDate);
                        this.put(id, oldValue);
                        break;
                    case 9:
                        continueUpdating = false; // Kết thúc vòng lặp
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ.");
                }
            }
        }
    }

    public void printProductList(ArrayList<Product> productList) {
        if (productList.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống.");
        } else {
            System.out.println("Danh sách sản phẩm:");
            for (Product product : productList) {
                System.out.println(product.toString());
                System.out.println("");
            }
        }
    }

    public void searchProduct(ArrayList<Storekeeper> KeeperList) {
        ArrayList<Product> ProductList = new ArrayList<>();
        System.out.println("Tìm kiếm theo ....: ");
        System.out.println("1. Tên: ");
        System.out.println("2. Danh mục: ");
        System.out.println("3. Thủ kho: ");
        System.out.println("4. Ngày nhập kho: ");

        int choice = Input.inputInt("Chọn cách tìm kiếm: ", 1, 4);
        switch (choice) {

            case 1:
                String name = Input.inputStr("Nhập tên sản phẩm: ");
                for (Product product : this.values()) {
                    if (product.getName().equalsIgnoreCase(name)) {
                        ProductList.add(product);
                    }
                }
                break;
            case 2:
                String category = Input.selectCategory();
                for (Product product : this.values()) {
                    if (product.getCategory().equalsIgnoreCase(category)) {
                        ProductList.add(product);
                    }
                }
                break;
            case 3:
                Storekeeper keeper = Input.selectStorekeeper(KeeperList);
                for (Product product : this.values()) {
                    if (product.getStorekeeper().equals(keeper)) {
                        ProductList.add(product);
                    }
                }
                break;
            case 4:
                String receiptDate = Input.inputDate("Nhập ngày nhập hàng: ");
                for (Product product : this.values()) {
                    if (product.getReceiptdate().equals(receiptDate)) {
                        ProductList.add(product);
                    }
                }
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
        }
        printProductList(ProductList);
    }

    public static void sortProductsByDate(ArrayList<Product> ProductList, int choice) {
        Collections.sort(ProductList, new Comparator<Product>() {
            @Override
            public int compare(Product product1, Product product2) {
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    dateFormat.setLenient(false);

                    if (choice == 1) {
                        Date date1 = dateFormat.parse(product1.getExpirydate());
                        Date date2 = dateFormat.parse(product2.getExpirydate());
                        return date1.compareTo(date2);
                    } else {
                        Date date1 = dateFormat.parse(product1.getDateOfManufacture());
                        Date date2 = dateFormat.parse(product1.getDateOfManufacture());
                        return date1.compareTo(date2);
                    }

                } catch (ParseException e) {
                    e.printStackTrace();
                    return 0;
                }
            }
        });
    }

    public void sortProduct() {
        ArrayList<Product> ProductList = new ArrayList<>(this.values());
        System.out.println("Sắp xếp theo....: ");
        System.out.println("1. Ngày hết hạn");
        System.out.println("2. Ngày sản xuất");

        int choice = Input.inputInt("Nhập lựa chọn cách sắp xếp: ", 1, 2);
        sortProductsByDate(ProductList, choice);
        printProductList(ProductList);
    }
    
    public void add10Product(ArrayList<Storekeeper> KeeperList){
        this.put("P001", new Product("P001", "Tivi", "VietNam", 15000000, "12/12/2025", "01/01/2020", "Điện tử và Công nghệ", KeeperList.get(0), "01/02/2020"));
        this.put("P002", new Product("P002", "SmartPhone", "China", 25000000, "11/9/2050", "11/9/2021", "Điện tử và Công nghệ", KeeperList.get(0), "01/02/2020"));
        this.put("P003", new Product("P003", "Tu lanh", "Malaysia", 10000000, "08/12/2040", "08/12/2022", "Điện tử và Công nghệ", KeeperList.get(1), "01/02/2020"));
        this.put("P004", new Product("P004", "Bep Gas", "China", 5000000, "01/12/2030", "01/12/2020", "Điện tử và Công nghệ", KeeperList.get(1), "01/02/2020"));
        this.put("P005", new Product("P005", "Xe hoi Toyota", "Japan", 1500000000, "10/02/2050", "10/02/2020", "Ô tô và Vận tải", KeeperList.get(2), "01/02/2020"));
        this.put("P006", new Product("P006", "Xe may Honda", "Japan", 30000000, "07/10/2029", "07/10/2021", "Ô tô và Vận tải", KeeperList.get(2), "01/02/2020"));
        this.put("P007", new Product("P007", "Quan ao", "VietNam", 150000, "06/06/2025", "06/06/2020", "Thời trang và Đồ dùng cá nhân", KeeperList.get(3), "01/02/2020"));
        this.put("P008", new Product("P008", "Ghe nhua", "Lao", 30000, "30/12/2025", "30/12/2022", "Nội thất và Gia đình", KeeperList.get(3), "01/02/2020"));
        this.put("P009", new Product("P009", "Quat tran", "China", 1000000, "11/11/2035", "11/11/2020", "Nội thất và Gia đình", KeeperList.get(4), "01/02/2020"));
        this.put("P010", new Product("P010", "Son moi", "English", 1500000, "12/05/2025", "12/05/2019", "Thời trang và Đồ dùng cá nhân", KeeperList.get(4), "01/02/2020"));
    }
}
