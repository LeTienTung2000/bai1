/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectDB;

/**
 *
 * @author Admin
 */
public class CreateTable {
    ConnectDB conn = new ConnectDB();

    

    public void Create_TableLoaiSanPham() {
        String sql = "Create table LoaiSanPham(maloaisp varchar(50) primary key,TenLoaiSanPham varchar(50))";
        conn.doSQL(sql);
    }
    public void Create_TableSanPham() {
        String sql = "Create table SanPham(masp varchar(50) primary key,tensp varchar(50), "
                + "nhasx  varchar(50),FOREIGN KEY (maloaisp) REFERENCES LoaiSanPham(maloaisp))";
        conn.doSQL(sql);
    }
}
