/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseAccessObject_DAO;

import Object_BusinessLogic.HoaDon;
import Object_BusinessLogic.KhachHang;
import Object_BusinessLogic.NhanVien;
import SQL_Connection.Convert;
import SQL_Connection.SQL_Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Huynh
 */
public class HoaDonDAO {

    public List<HoaDon> selectAll() {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            Statement prst = conn.createStatement();
            ResultSet rs = prst.executeQuery("SELECT hd.*, kh.Ho_Ten_Khach_Hang, nv.Ho_Ten_Nhan_Vien"
                    + " FROM HOA_DON hd, KHACH_HANG kh, NHAN_VIEN nv Where "
                    + "hd.Ma_Khach_Hang = kh.Ma_Khach_Hang And hd.Ma_Nhan_Vien = nv.Ma_Nhan_Vien");
            List<HoaDon> hdList = new ArrayList<>();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setSoHoaDon(rs.getInt("So_Hoa_Don"));
                hd.setNgayLapHoaDon(rs.getDate("Ngay_Lap_Hoa_Don"));
                hd.setMaKhachHang(rs.getString("Ma_Khach_Hang").trim());
                hd.setHoTenKhachHang(rs.getString("Ho_Ten_Khach_Hang").trim());
                hd.setMaNhanVien(rs.getString("Ma_Nhan_Vien").trim());
                hd.setHoTenNhanVien(rs.getString("Ho_Ten_Nhan_Vien").trim());
                hd.setHinhThucThanhToan(rs.getString("Hinh_Thuc_Thanh_Toan"));
                hd.setTongTien(rs.getInt("Tong_Tien"));
                hd.setGhiChu(rs.getString("Ghi_Chu"));
                hdList.add(hd);
            }
            return hdList;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public List<HoaDon> search(Integer soHoaDon, Date ngayBanHang, NhanVien nv, KhachHang kh) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            String sql = "SELECT hd.*, kh.Ho_Ten_Khach_Hang, nv.Ho_Ten_Nhan_Vien"
                    + " FROM HOA_DON hd, KHACH_HANG kh, NHAN_VIEN nv Where "
                    + "hd.Ma_Khach_Hang = kh.Ma_Khach_Hang And hd.Ma_Nhan_Vien = nv.Ma_Nhan_Vien ";
            if (nv != null) {
                sql = sql + " AND nv.Ma_Nhan_Vien LIKE N'%" + nv.getMaNhanVien() + "%'";
            }
            if (kh != null) {
                sql = sql + " AND kh.Ma_Khach_Hang LIKE N'%" + kh.getMaKH() + "%'";
            }
            if (soHoaDon != null) {
                sql = sql + " AND hd.So_Hoa_Don = " + soHoaDon + " ";
            }
            if (ngayBanHang != null) {
                sql = sql + " AND hd.Ngay_Lap_Hoa_Don = '" + Convert.convertDate(ngayBanHang) + "' ";
            }
            Statement prst = conn.createStatement();
            ResultSet rs = prst.executeQuery(sql);
            List<HoaDon> hdList = new ArrayList<>();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setSoHoaDon(rs.getInt("So_Hoa_Don"));
                hd.setNgayLapHoaDon(rs.getDate("Ngay_Lap_Hoa_Don"));
                hd.setMaKhachHang(rs.getString("Ma_Khach_Hang").trim());
                hd.setHoTenKhachHang(rs.getString("Ho_Ten_Khach_Hang").trim());
                hd.setMaNhanVien(rs.getString("Ma_Nhan_Vien").trim());
                hd.setHoTenNhanVien(rs.getString("Ho_Ten_Nhan_Vien").trim());
                hd.setHinhThucThanhToan(rs.getString("Hinh_Thuc_Thanh_Toan"));
                hd.setTongTien(rs.getInt("Tong_Tien"));
                hd.setGhiChu(rs.getString("Ghi_Chu"));
                hdList.add(hd);
            }
            return hdList;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public List<HoaDon> report(Date from, Date to) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            String sql = "SELECT hd.*, kh.Ho_Ten_Khach_Hang, nv.Ho_Ten_Nhan_Vien"
                    + " FROM HOA_DON hd, KHACH_HANG kh, NHAN_VIEN nv Where "
                    + "hd.Ma_Khach_Hang = kh.Ma_Khach_Hang And hd.Ma_Nhan_Vien = nv.Ma_Nhan_Vien ";
            if (from != null) {
                sql = sql + " AND hd.Ngay_Lap_Hoa_Don >= '" + Convert.convertDate(from) + "'";
            }
            if (to != null) {
                sql = sql + " AND hd.Ngay_Lap_Hoa_Don <= N'" + Convert.convertDate(to) + "'";
            }

            Statement prst = conn.createStatement();
            ResultSet rs = prst.executeQuery(sql);
            List<HoaDon> hdList = new ArrayList<>();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setSoHoaDon(rs.getInt("So_Hoa_Don"));
                hd.setNgayLapHoaDon(rs.getDate("Ngay_Lap_Hoa_Don"));
                hd.setMaKhachHang(rs.getString("Ma_Khach_Hang").trim());
                hd.setHoTenKhachHang(rs.getString("Ho_Ten_Khach_Hang").trim());
                hd.setMaNhanVien(rs.getString("Ma_Nhan_Vien").trim());
                hd.setHoTenNhanVien(rs.getString("Ho_Ten_Nhan_Vien").trim());
                hd.setHinhThucThanhToan(rs.getString("Hinh_Thuc_Thanh_Toan"));
                hd.setTongTien(rs.getInt("Tong_Tien"));
                hd.setGhiChu(rs.getString("Ghi_Chu"));
                hdList.add(hd);
            }
            return hdList;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public HoaDon getHoaDon(Integer soHoaDon) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            Statement prst = conn.createStatement();
            ResultSet rs = prst.executeQuery("Select * From HOA_DON Where So_Hoa_Don = " + soHoaDon);
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setSoHoaDon(rs.getInt("So_Hoa_Don"));
                hd.setNgayLapHoaDon(rs.getDate("Ngay_Lap_Hoa_Don"));
                hd.setMaKhachHang(rs.getString("Ma_Khach_Hang").trim());
                hd.setMaNhanVien(rs.getString("Ma_Nhan_Vien").trim());
                hd.setHinhThucThanhToan(rs.getString("Hinh_Thuc_Thanh_Toan"));
                hd.setTongTien(rs.getInt("Tong_Tien"));
                hd.setGhiChu(rs.getString("Ghi_Chu"));
                return hd;
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public static List<String> getListMaKhachHang() {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select Ma_Khach_Hang From HOA_DON");
            List<String> listMaKhachHang = new ArrayList<>();
            while (rs.next()) {
                listMaKhachHang.add(rs.getString("Ma_Khach_Hang").trim());
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

    public static List<String> getListMaNhanVien() {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select Ma_Nhan_Vien From HOA_DON");
            List<String> listMaNhanVien = new ArrayList<>();
            while (rs.next()) {
                listMaNhanVien.add(rs.getString("Ma_Nhan_Vien").trim());
            }
            return listMaNhanVien;
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

    public Integer getSoHoaDon() {
        Connection conn = null;
        Integer soHoaDon = 0;
        try {
            conn = SQL_Connection.getConnection();
            Statement st = conn.createStatement();
            PreparedStatement statement = conn.prepareStatement("Select So_Hoa_Don From HOA_DON",
                    Statement.RETURN_GENERATED_KEYS);
            statement.execute();
            st.executeQuery("Select So_Hoa_Don From HOA_DON");
            ResultSet key = statement.getGeneratedKeys();
            if (key.next()) {
                soHoaDon = key.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return soHoaDon;
    }

    public Integer insert(HoaDon hoaDon) throws SQLException {
        try (
                Connection connection = SQL_Connection.getConnection();
                PreparedStatement statement = connection.prepareStatement("Insert Into HOA_DON Values(?,?,?,?,?,?)",
                        Statement.RETURN_GENERATED_KEYS);) {
            statement.setDate(1, Convert.convertDate(hoaDon.getNgayLapHoaDon()));
            statement.setString(2, hoaDon.getMaKhachHang());
            statement.setString(3, hoaDon.getMaNhanVien());
            statement.setString(4, hoaDon.getHinhThucThanhToan());
            statement.setInt(5, hoaDon.getTongTien());
            statement.setString(6, hoaDon.getGhiChu());
            // ...
            Integer soHoaDon = 0;
            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    soHoaDon = (generatedKeys.getInt(1));
                    return soHoaDon;
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
