
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class Input {

    public static Scanner scanner = new Scanner(System.in);

   public static int inputInt(String msg, int min, int max) {
        if (min > max) {
            int t = min;
            min = max;
            max = t;
        }
        int data = 0;
        boolean validInput = false;
        do {
            try {
                System.out.print(msg);
                String input = scanner.nextLine(); // Đọc dòng đầu tiên
                data = Integer.parseInt(input);
                if (data >= min && data <= max) {
                    validInput = true;
                } else {
                    System.out.println("Vui lòng nhập số nằm trong khoảng từ " + min + " đến " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số nguyên hợp lệ.");
            }
        } while (!validInput);
        return data;
    }

    public static double inputDouble(String msg, double min, double max) {
        if (min > max) {
            double t = min;
            min = max;
            max = t;
        }
        double data = 0;
        boolean validInput = false;
        do {
            try {
                System.out.print(msg);
                String input = scanner.nextLine();
                data = Double.parseDouble(input);
                if (data >= min && data <= max) {
                    validInput = true;
                } else {
                    System.out.println("Vui lòng nhập số thực nằm trong khoảng từ " + min + " đến " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số thực hợp lệ.");
            }
        } while (!validInput);
        return data;
    }

    public static String inputStr(String msg) {
        System.out.println(msg);
        String data = scanner.nextLine().trim();
        return data;
    }

    public static String inputNonBlankStr(String msg) {
        String data;
        do {
            System.out.print(msg);
            data = scanner.nextLine().trim();
            if(data.isEmpty()){
                System.out.println("Không được bỏ trống.");
            }
        } while (data.length() == 0);
        return data;
    }

    public static String inputPattern(String msg, String pattern) {
        String data;
        do {
            System.out.print(msg);
            data = scanner.nextLine().trim();
            if(!data.matches(pattern)){
                System.out.println("Sai định dạng.");
            }
        } while (!data.matches(pattern));
        return data;
    }

    public static String inputDate(String msg) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false); // Đặt kiểm tra tính hợp lệ

        while (true) {
            System.out.print(msg);
            String input = scanner.nextLine();

            try {
                Date date = sdf.parse(input);
                return sdf.format(date); // Trả về ngày tháng hợp lệ dưới dạng chuỗi
            } catch (ParseException e) {
                System.out.println("Ngày tháng không hợp lệ. Hãy nhập lại.");
            }
        }
    }

    public static String selectCategory() {
        String[] categories = {
            "Điện tử và Công nghệ",
            "Thời trang và Đồ dùng cá nhân",
            "Thực phẩm và Đồ uống",
            "Nội thất và Gia đình",
            "Sức khỏe và Sức khỏe cá nhân",
            "Thể thao và Giải trí",
            "Ô tô và Vận tải",
            "Ngoại trời và Câu lạc bộ",
            "Nghệ thuật và Văn hóa",
            "Dịch vụ và Kỹ thuật"
        };
        System.out.println("Danh mục sản phẩm:");
        for (int i = 0; i < categories.length; i++) {
            System.out.println((i + 1) + ". " + categories[i]);
        }

        int choice = inputInt("Chọn danh mục sản phẩm (1-" + categories.length + "): ", 1, categories.length);

        return categories[choice - 1];
    }
    
    public static Storekeeper selectStorekeeper(ArrayList<Storekeeper> KeeperList){
        System.out.println("Storekeeper: ");
        for(int i = 0; i< KeeperList.size(); i++){
            System.out.println((i+1) + ". " + KeeperList.get(i).getStorekeeperName());
        }
        
        int choice = inputInt("Choose keeper (1-"+ KeeperList.size() + "): ", 1, KeeperList.size());
        return KeeperList.get(choice - 1);
    }

}
