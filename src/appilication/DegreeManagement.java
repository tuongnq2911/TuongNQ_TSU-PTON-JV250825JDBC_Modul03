package appilication;

import business.DegreeBusiness;
import entity.Degrees;

import java.util.List;
import java.util.Scanner;

public class DegreeManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("*************DEGREES MANAGEMENT*************\n");
            System.out.println("1. Danh sách các bằng cấp");
            System.out.println("2. Thêm mới một bằng cấp");
            System.out.println("3. Cập nhật bằng cấp");
            System.out.println("4. Xóa bằng cấp");
            System.out.println("5. Tìm kiếm bằng cấp theo tên");
            System.out.println("6. Thoát");

            System.out.println("Mời bạn nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    displayAllDegrees();
                    break;
                case 2:
                    addDegree(scanner);
                    break;
                case 3:
                    updateDegree(scanner);
                    break;
                case 4:
                    deleteDegree(scanner);
                    break;
                case 5:
                    searchDegreeByDegreeName(scanner);
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Mời bạn nhập lựa chon bằng số từ 1-6!!");
            }
        } while (true);
    }

    public static void displayAllDegrees() {
        List<Degrees> degrees = DegreeBusiness.getAllDegreesList();
        System.out.println("Danh sách tất cả bằng cấp:");
        for (Degrees degree : degrees) {
            degree.displayData();
        }
    }

    public static void addDegree(Scanner scanner) {
        System.out.println("Vui lòng nhập thông tin bằng cấp: ");
        Degrees degrees = new Degrees();
        degrees.inputData();
        if (DegreeBusiness.addDegrees(degrees)) {
            System.out.println("Thêm mới thông tin thành công!");
        }else {
            System.err.println("Thêm mới thông tin thất bại");
        }
    }

    public static void updateDegree(Scanner scanner) {
        System.out.println("Mời bạn nhập vào DegreeID cần chỉnh sửa: ");
        int updateEmployeeID = Integer.parseInt(scanner.nextLine());
        Degrees degrees = DegreeBusiness.findDegreeByEmployeeID(updateEmployeeID);
        if (degrees != null) {
            System.out.println("Mời bạn nhập vào thông tin cần cập nhật: ");
            degrees.inputData();
            if (DegreeBusiness.updateDegrees(degrees)) {
                System.out.println("Cập nhật thành công!");
            }else {
                System.err.println("Cập nhật thất bại");
            }
        }else {
            System.err.println("Không tìm thấy EmployeeID cần cập nhật !");
        }
    }

    public static void deleteDegree(Scanner scanner) {
        System.out.println("Mời banh nhập ID cần xoá: ");
        int deleteEmployeeID = Integer.parseInt(scanner.nextLine());
        if (DegreeBusiness.findDegreeByEmployeeID(deleteEmployeeID) != null) {
            if (DegreeBusiness.deleteDegrees(deleteEmployeeID)){
                System.out.println("Xoá thành công!");
            }else {
                System.err.println("Xoá thất bại");
            }
        }else {
            System.err.println("Không tìm thấy ID cần xoá");
        }
    }

    public static void searchDegreeByDegreeName(Scanner scanner) {
        System.out.println("Mời bạn nhập tên bằng cấp muốn tìm: ");
        String searchDegreeName = scanner.nextLine();
        List<Degrees> degrees = DegreeBusiness.searchDegreesByDegreeName(searchDegreeName);
        System.out.println("Có " + degrees.size()+ " bằng cấp tìm thấy");
        for (Degrees degree : degrees) {
            degree.displayData();
        }
    }
}
