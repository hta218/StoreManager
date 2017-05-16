/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseAccessObject_DAO;

import Object_BusinessLogic.KhachHang;
import SQL_Connection.Convert;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import SQL_Connection.SQL_Connection;

/**
 *
 * @author Huynh
 */
public class KhachHangDAO {

    public List<KhachHang> selectAll() {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            Statement prst = conn.createStatement();
            ResultSet rs = prst.executeQuery("SELECT * FROM KHACH_HANG kh, NHOM_KHACH_HANG nkh Where "
                    + "kh.Ma_Nhom_Khach_Hang = nkh.Ma_Nhom_Khach_Hang");
            List<KhachHang> khList = new ArrayList<>();
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getString("Ma_Khach_Hang"));
                kh.setHoTenKH(rs.getString("Ho_Ten_Khach_Hang"));
                kh.setDiachi(rs.getString("Dia_Chi"));
                kh.setGioiTinh(rs.getString("Gioi_Tinh").trim());
                kh.setSdt(rs.getInt("SDT"));
                kh.setMaNhomKH(rs.getInt("Ma_Nhom_Khach_Hang"));
                kh.setTenNhomKH(rs.getString("Ten_Nhom_Khach_Hang"));
                kh.setEmail(rs.getString("Email"));
                kh.setSoCMND(rs.getInt("So_CMND"));
                kh.setDiemTichLuy(rs.getInt("Diem_Tich_Luy"));
                khList.add(kh);
            }
            return khList;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public List<String> getListMaKhachHang() {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select Ma_Khach_Hang From KHACH_HANG");
            List<String> listMaKhachHang = new ArrayList<>();
            while (rs.next()) {
                listMaKhachHang.add(rs.getString("Ma_Khach_Hang").trim().toUpperCase());
            }
            return listMaKhachHang;
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public boolean insert(KhachHang kh) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            PreparedStatement prst = conn.prepareStatement("INSERT INTO KHACH_HANG VALUES (?,?,?,?,?,?,?,?,?)");
            prst.setString(1, kh.getMaKH());
            prst.setString(2, (new Convert()).convertName(kh.getHoTenKH()));
            prst.setInt(3, kh.getSoCMND());
            prst.setString(4, kh.getGioiTinh());
            prst.setInt(5, kh.getSdt());
            prst.setString(6, kh.getEmail());
            prst.setString(7, kh.getDiachi());
            prst.setInt(8, kh.getMaNhomKH());
            prst.setInt(9, kh.getDiemTichLuy());
            return prst.execute();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean update(KhachHang kh) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            PreparedStatement prst = conn.prepareStatement("UPDATE KHACH_HANG SET Dia_Chi = ?,"
                    + "Ho_Ten_Khach_Hang = ?,SDT = ?, Email = ?,Gioi_Tinh = ?, Ma_Nhom_Khach_Hang = ?"
                    + " ,So_CMND = ?, Diem_Tich_Luy = ? WHERE Ma_Khach_Hang = ?");
            prst.setString(1, kh.getDiachi());
            prst.setString(2, (new Convert()).convertName(kh.getHoTenKH()));
            prst.setInt(3, kh.getSdt());
            prst.setString(4, kh.getEmail());
            prst.setString(5, kh.getGioiTinh());
            prst.setInt(6, kh.getMaNhomKH());
            prst.setInt(7, kh.getSoCMND());
            prst.setInt(8, kh.getDiemTichLuy());
            prst.setString(9, kh.getMaKH());

            return prst.execute();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean delete(KhachHang kh) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            PreparedStatement prst = conn.prepareStatement("DELETE FROM KHACH_HANG WHERE Ma_Khach_Hang = ?");
            prst.setString(1, kh.getMaKH());
            return prst.execute();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public List<KhachHang> search(KhachHang khachHang) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            String sql = "SELECT * FROM KHACH_HANG kh, NHOM_KHACH_HANG nkh WHERE kh.Ma_Nhom_Khach_Hang = nkh.Ma_Nhom_Khach_Hang ";
            if (!khachHang.getHoTenKH().isEmpty()) {
                sql = sql + "AND kh.Ho_Ten_Khach_Hang LIKE N'%" + khachHang.getHoTenKH() + "%'";
            }
            if (khachHang.getSdt() != null) {
                sql = sql + " AND kh.SDT LIKE N'%" + khachHang.getSdt() + "%'";
            }
            if (khachHang.getGioiTinh() != null) {
                sql = sql + " AND kh.Gioi_Tinh LIKE N'" + khachHang.getGioiTinh() + "%'";
            }
            if (khachHang.getMaNhomKH() != null) {
                sql = sql + " AND kh.Ma_Nhom_Khach_Hang = " + khachHang.getMaNhomKH() + "";
            }
            Statement prst = conn.createStatement();
            ResultSet rs = prst.executeQuery(sql);
            List<KhachHang> khList = new ArrayList<>();
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getString("Ma_Khach_Hang"));
                kh.setHoTenKH(rs.getString("Ho_Ten_Khach_Hang"));
                kh.setDiachi(rs.getString("Dia_Chi"));
                kh.setGioiTinh(rs.getString("Gioi_Tinh").trim());
                kh.setSdt(rs.getInt("SDT"));
                kh.setMaNhomKH(rs.getInt("Ma_Nhom_Khach_Hang"));
                kh.setTenNhomKH(rs.getString("Ten_Nhom_Khach_Hang"));
                kh.setEmail(rs.getString("Email"));
                kh.setSoCMND(rs.getInt("So_CMND"));
                kh.setDiemTichLuy(rs.getInt("Diem_Tich_Luy"));
                khList.add(kh);
            }
            return khList;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public KhachHang getKHByID(String maKH) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            PreparedStatement prst = conn.prepareStatement("Select * From KHACH_HANG Where Ma_Khach_Hang = ?");
            prst.setString(1, maKH);
            ResultSet rs = prst.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getString("Ma_Khach_Hang").trim());
                kh.setHoTenKH(rs.getString("Ho_Ten_Khach_Hang").trim());
                kh.setDiachi(rs.getString("Dia_Chi").trim());
                kh.setGioiTinh(rs.getString("Gioi_Tinh").trim());
                kh.setSdt(rs.getInt("SDT"));
                kh.setMaNhomKH(rs.getInt("Ma_Nhom_Khach_Hang"));
                kh.setEmail(rs.getString("Email").trim());
                kh.setSoCMND(rs.getInt("So_CMND"));
                kh.setDiemTichLuy(rs.getInt("Diem_Tich_Luy"));
                return kh;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.getMessage();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
     public static List<Integer> getListMaNhomKhachHang() {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select Ma_Nhom_Khach_Hang From KHACH_HANG");
            List<Integer> listMaNhomKhachHang = new ArrayList<>();
            while (rs.next()) {
                listMaNhomKhachHang.add(rs.getInt("Ma_Nhom_Khach_Hang"));
            }
            return listMaNhomKhachHang;
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
