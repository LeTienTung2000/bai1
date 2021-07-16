/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectDB;
import Class.LoaiSanPham;
import Class.SanPham;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ConnectDB {
    Statement stm = null;
    ResultSet rs = null;
    Connection cnn = null;

    String uRl = "jdbc:derby://localhost:1527/BTSanPham";
    String userName = "BAITAP1";
    String pas = "123456";

    public ConnectDB() {
        try {
            //org.apache.derby.jdbc.ClientDriver
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            cnn = DriverManager.getConnection(uRl, userName, pas);
            System.out.println("ket noi thanh cong");
        } catch (Exception ex) {
            System.out.println("ket noi that bai" + ex.toString());
        }
    }

    protected Statement getStatement() throws Exception {
        if (this.stm == null || this.stm.isClosed()) {
            this.stm = this.cnn.createStatement();
        }
        return this.stm;
    }

    public void updateData(String sql) throws Exception {
        try {
            getStatement().executeUpdate(sql);
        } catch (Exception e) {

        }
    }

    public ResultSet executeSql(String sql) {
        try {
            stm = cnn.createStatement();
            rs = stm.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            System.out.println(" khong thuc hien dc cau lẹnh sql\n" + sql);
            return rs;
        }

    }

    public void doSQL(String sql) {
        try {
            stm = cnn.createStatement();
            stm.execute(sql);
            System.out.println("Thực thi thành công");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println(" khong thuc hien dc cau lẹnh sql\n" + sql);
        }

    }
    public ArrayList getData_SP(String sql) {
        ArrayList<SanPham> ds = new ArrayList<SanPham>();
        try {
            stm = (Statement) cnn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                SanPham sv = new SanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                ds.add(sv);
            }
        } catch (Exception ex) {
            System.out.println("loi getData " + ex.toString());
            return null;
        }
        return ds;
    }

    public ArrayList getData_LoaiSP(String sql) {
        ArrayList<LoaiSanPham> svi = new ArrayList<LoaiSanPham>();
        try {
            stm = (Statement) cnn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                LoaiSanPham sv = new LoaiSanPham(rs.getString(1), rs.getString(2));
                svi.add(sv);
            }
        } catch (Exception ex) {
            System.out.println("loi getData " + ex.toString());
            return null;
        }
        return svi;
    }
}
