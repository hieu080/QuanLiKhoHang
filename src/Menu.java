
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
public class Menu {
    public static int getChoice(List<Object> options) {
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + "-" + options.get(i));
        }
        System.out.println("Lựa chọn 1.." + options.size() + ": ");
        Scanner sc = new Scanner(System.in);
        int choice = -1; // Khởi tạo giá trị choice với một giá trị mặc định

        boolean validInput = false;
        while (!validInput) {
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice >= 1 && choice <= options.size()) {
                    validInput = true; // Nếu giá trị nằm trong phạm vi hợp lệ, thoát vòng lặp
                } else {
                    System.out.println("Vui lòng chọn một số hợp lệ.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số nguyên hợp lệ.");
            }
        }
        return choice;
    }
}
