package business;

import entity.Degrees;
import util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class DegreeBusiness {
    public static List<Degrees> getAllDegreesList() {
        List<Degrees> degreesList = new ArrayList<>();
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = ConnectionDB.getConnection();
            stmt = conn.prepareCall("{call get_all_degree()}");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Degrees degrees = new Degrees();
                degrees.setId(rs.getInt("degree_id"));
                degrees.setDegreesName(rs.getString("degree_name"));
                degrees.setEmpId(rs.getString("emp_id"));
                degrees.setSchoolName(rs.getString("school_name"));
                degrees.setDegreesDate(rs.getTimestamp("degree_date").toLocalDateTime());
                degrees.setDegreeClassification(rs.getString("degree_classification"));
                degreesList.add(degrees);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn);
        }
        return degreesList;
    }

    public static boolean addDegrees(Degrees degrees) {
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = ConnectionDB.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareCall("{call add_degree(?,?,?,?,?,?)}");
            stmt.setString(1, degrees.getDegreesName());
            stmt.setString(2, degrees.getEmpId());
            stmt.setTimestamp(3, Timestamp.valueOf(degrees.getDegreesDate()));
            stmt.setString(4, degrees.getSchoolName());
            stmt.setInt(5,degrees.getDegreesYear());
            stmt.setString(6, degrees.getDegreeClassification());
            stmt.executeUpdate();
            conn.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn);
        }return  false;
    }

    public static Degrees findDegreeByEmployeeID(int degreeId) {
        Connection conn = null;
        CallableStatement stmt = null;
        Degrees degrees = null;
        try {
            conn = ConnectionDB.getConnection();
            stmt = conn.prepareCall("{call find_degree_by_degree_id(?)}");
            stmt.setInt(1, degreeId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
               degrees = new Degrees();
                degrees.setId(rs.getInt("degree_id"));
                degrees.setDegreesName(rs.getString("degree_name"));
                degrees.setEmpId(rs.getString("emp_id"));
                degrees.setDegreesDate(rs.getTimestamp("degree_date").toLocalDateTime());
                degrees.setSchoolName(rs.getString("school_name"));
                degrees.setDegreesYear(rs.getInt("degree_year"));
                degrees.setDegreeClassification(rs.getString("degree_classification"));

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn);
        }return degrees;
    }

    public static boolean updateDegrees(Degrees degrees) {
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = ConnectionDB.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareCall("{call update_degree_by_id(?,?,?,?,?,?,?)}");
            stmt.setInt(1, degrees.getId());
            stmt.setString(2, degrees.getDegreesName());
            stmt.setString(3, degrees.getEmpId());
            stmt.setTimestamp(4, Timestamp.valueOf(degrees.getDegreesDate()));
            stmt.setString(5, degrees.getSchoolName());
            stmt.setInt(6, degrees.getDegreesYear());
            stmt.setString(7, degrees.getDegreeClassification());
            stmt.executeUpdate();
            conn.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn);
        }return  false;
    }

    public static boolean deleteDegrees(int degrees) {
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = ConnectionDB.getConnection();
            stmt =  conn.prepareCall("{call delete_degree_by_id(?)}");
            stmt.setInt(1, degrees);
            stmt.executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn);
        }return  false;
    }

    public static List<Degrees> searchDegreesByDegreeName(String searchDegreeName) {
        Connection conn = null;
        CallableStatement stmt = null;
        List<Degrees> degreesList = null;
        try {
            conn = ConnectionDB.getConnection();
            stmt = conn.prepareCall("{call search_degree_by_degree_name(?)}");
            stmt.setString(1,searchDegreeName);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                degreesList = new ArrayList<>();
                Degrees degrees = new Degrees();
                degrees.setId(rs.getInt("degree_id"));
                degrees.setDegreesName(rs.getString("degree_name"));
                degrees.setEmpId(rs.getString("emp_id"));
                degrees.setDegreesDate(rs.getTimestamp("degree_date").toLocalDateTime());
                degrees.setSchoolName(rs.getString("school_name"));
                degrees.setDegreesYear(rs.getInt("degree_year"));
                degrees.setDegreeClassification(rs.getString("degree_classification"));
                degreesList.add(degrees);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn);
        }return  degreesList;
    }
}
