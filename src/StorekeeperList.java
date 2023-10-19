
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author HELLO
 */
public class StorekeeperList extends ArrayList<Storekeeper> {

    public StorekeeperList() {
        super();
    }

    public Storekeeper search(String code) {
        code = code.trim().toUpperCase();
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getStorekeeperID().equals(code)) {
                return this.get(i);
            }
        }
        return null;
    }

    private boolean isCodeDupplicated(String code) {
        code = code.trim().toUpperCase();
        return search(code) != null;
    }

    public void addStorekeeper() {
        String keeperID, keeperName;
        int keeperAge;
        boolean codeDupplicated = false;
        do {
            keeperID = Input.inputPattern("Mã thủ kho S000: ", "[sS][\\d]{3}");
            keeperID = keeperID.trim().toUpperCase();
            codeDupplicated = isCodeDupplicated(keeperID);
            if (codeDupplicated) {
                System.out.println("Mã thủ kho trùng lặp!");
            }
        } while (codeDupplicated == true);

        keeperName = Input.inputNonBlankStr("Tên thủ kho: ");
        keeperName = keeperName.toUpperCase();
        keeperAge = Input.inputInt("Tuổi: ", 18, 65);
        Storekeeper keeper = new Storekeeper(keeperID, keeperName, keeperAge);
        this.add(keeper);
        System.out.println("Thủ kho " + keeperID + " được thêm thành công.");

    }
    
    public void add5Keeper(){
        this.add(new Storekeeper("S001", "Phan Trung Hieu", 21));
        this.add(new Storekeeper("S002", "Bui Thi Minh Trang", 19));
        this.add(new Storekeeper("S003", "Trinh Pham Doan Trang", 19));
        this.add(new Storekeeper("S004", "Ngo An Binh", 20));
        this.add(new Storekeeper("S005", "Chu Quoc Khanh Chung", 20));
    }
}
