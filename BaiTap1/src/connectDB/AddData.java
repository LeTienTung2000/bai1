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
public class AddData {
    CreateTable table = new CreateTable();
    ConnectDB conn = new ConnectDB();

    public void add_Class() {
        table.Create_TableSanPham();
        String sp1 = "insert into SanPham values('S01','TiVi','SONY','H01')";
        String sp2 = "insert into SanPham values('S02','Tủ Lạnh','FUTABA','H01')";
       

        conn.doSQL(sp1);
        conn.doSQL(sp2);
        
        
    }

    public void add_GiaoVien() {
        table.Create_TableLoaiSanPham();
        String cbgv1 = "insert into LoaiSanPham values('H01','Đồ Gia Dụng')";
        
        conn.doSQL(cbgv1);
       
       
    }
}
