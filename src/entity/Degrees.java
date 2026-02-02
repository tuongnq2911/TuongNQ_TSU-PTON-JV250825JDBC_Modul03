package entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Degrees {
    private int id;
    private String degreesName;
    private String empId;
    private LocalDateTime degreesDate;
    private String schoolName;
    private int degreesYear;
    private String degreeClassification;

    public Degrees() {
    }

    public Degrees(int id, String degreesName, String empId, LocalDateTime degreesDate, String schoolName, int degreesYear, String degreeClassification) {
        this.id = id;
        this.degreesName = degreesName;
        this.empId = empId;
        this.degreesDate = degreesDate;
        this.schoolName = schoolName;
        this.degreesYear = degreesYear;
        this.degreeClassification = degreeClassification;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDegreesName() {
        return degreesName;
    }

    public void setDegreesName(String degreesName) {
        this.degreesName = degreesName;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public LocalDateTime getDegreesDate() {
        return degreesDate;
    }

    public void setDegreesDate(LocalDateTime degreesDate) {
        this.degreesDate = degreesDate;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public int getDegreesYear() {
        return degreesYear;
    }

    public void setDegreesYear(int degreesYear) {
        this.degreesYear = degreesYear;
    }

    public String getDegreeClassification() {
        return degreeClassification;
    }

    public void setDegreeClassification(String degreeClassification) {
        this.degreeClassification = degreeClassification;
    }

    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Vui lòng nhập tên bằng cấp: ");
            String input = scanner.nextLine();
            if (input.isEmpty() || input.length() > 150) {
                System.err.println("Lỗi: Tên bằng cấp không được để trống hoặc quá 150 ký tự!");
            } else {
                this.degreesName = input;
                break;
            }
        }

        while (true) {
            System.out.println("Vui lòng nhập mã nhân viên: ");
            String input = scanner.nextLine();
            if (input.isEmpty() || input.length() > 15) {
                System.err.println("Lỗi: Mã nhân viên không được để trống hoặc quá 15 ký tự!");
            } else {
                this.empId = input;
                break;
            }
        }
        System.out.println("Vui lòng nhập ngày cấp bằng theo định dạng (dd/MM/yyyy HH:mm:ss)");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        while (true) {
            String input = scanner.nextLine();
            try {
                this.degreesDate = LocalDateTime.parse(input, dateTimeFormatter);
                break;
            } catch (DateTimeParseException e) {
                System.err.println("Sai định dạng vui lòng nhập lại");
            }
        }


        while (true) {
            System.out.println("Vui lòng nhập tên trường cấp băng: ");
            String input = scanner.nextLine();
            if (input.isEmpty() || input.length() > 100) {
                System.err.println("Lỗi: Tên trường không được để trống hoặc quá 100 ký tự!");
            } else {
                this.schoolName = input;
                break;
            }
        }


        System.out.println("Vui lòng nhập năm cấp băng: ");
        this.degreesYear = Integer.parseInt(scanner.nextLine());
        while (true) {
            System.out.println("Vui lòng nhập xếp loại: ");
            String input = scanner.nextLine();
            if (input.isEmpty() || input.length() > 20) {
                System.err.println("Lỗi: Xếp loại không được để trống hoặc quá 20 ký tự!");
            } else {
                this.degreeClassification = input;
                break;
            }
        }
    }

    public void displayData() {
        System.out.println("ID: " + this.id);
        System.out.println("DegreesName: " + this.degreesName);
        System.out.println("EmployeeId: " + this.empId);
        System.out.println("DegreesDate: " + this.degreesDate);
        System.out.println("SchoolName: " + this.schoolName);
        System.out.println("DegreesYear: " + this.degreesYear);
        System.out.println("DegreeClassification: " + this.degreeClassification);

    }
}
