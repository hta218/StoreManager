/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseAccessObject_DAO;

import Object_BusinessLogic.ChiTietHoaDon;
import Object_BusinessLogic.NhomKhachHang;
import Object_BusinessLogic.TonKho;
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
public class ChiTietHoaDonDAO {

    public List<TonKho> selectAll(Integer soKho) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            PreparedStatement prst = conn.prepareStatement("SELECT tk.*, sp.Ten_San_Pham, lsp.Ten_Loai_San_Pham "
                    + "FROM TON_KHO tk, SAN_PHAM sp, LOAI_SAN_PHAM lsp Where tk.So_Kho = ? And "
                    + "tk.Ma_San_Pham = sp.Ma_San_Pham And sp.Ma_Loai_San_Pham = lsp.Ma_Loai_San_Pham");
            prst.setInt(1, soKho);
            ResultSet rs = prst.executeQuery();
            List<TonKho> tonKhoList = new ArrayList<>();
            while (rs.next()) {
                TonKho tonKho = new TonKho();
                tonKho.setSoKho(rs.getInt("So_Kho"));
                tonKho.setMaSanPham(rs.getString("Ma_San_Pham"));
                tonKho.setTenSanPham(rs.getString("Ten_San_Pham"));
                tonKho.setTenLoaiSanPham(rs.getString("Ten_Loai_San_Pham"));
                tonKho.setSoLuong(rs.getInt("So_Luong"));
                tonKhoList.add(tonKho);
            }
            return tonKhoList;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public boolean insert(ChiTietHoaDon cthd) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            PreparedStatement prst = conn.prepareStatement("INSERT INTO CHI_TIET_HOA_DON VALUES (?,?,?,?)");
            prst.setInt(1, cthd.getSoHoaDon());
            prst.setString(2, cthd.getMaSanPham());
            prst.setInt(3, cthd.getSoLuong());
            prst.setInt(4, cthd.getThanhTien());

            return prst.execute();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean delete(NhomKhachHang nkh) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            PreparedStatement prst = conn.prepareStatement("DELETE FROM NHOM_KHACH_HANG WHERE Ma_Nhom_Khach_Hang = ?");
            prst.setInt(1, nkh.getMaNhomKH());
            return prst.execute();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public List<NhomKhachHang> search(NhomKhachHang nkhh) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            String sql = "SELECT * FROM NHOM_KHACH_HANG WHERE 1 = 1 ";
            if (nkhh.getMaNhomKH() != null) {
                sql = sql + "AND Ma_Nhom_Khach_Hang = " + nkhh.getMaNhomKH() + " ";
            }
            if (nkhh.getTenNhomKH() != null) {
                sql = sql + "AND Ten_Nhom_Khach_Hang LIKE N'%" + nkhh.getTenNhomKH() + "%'";
            }
            Statement prst = conn.createStatement();
            ResultSet rs = prst.executeQuery(sql);
            List<NhomKhachHang> nhomKH_List = new ArrayList<>();
            while (rs.next()) {
                NhomKhachHang nkh = new NhomKhachHang();
                nkh.setMaNhomKH(rs.getInt("Ma_Nhom_Khach_Hang"));
                nkh.setTenNhomKH(rs.getString("Ten_Nhom_Khach_Hang"));
                nkh.setMoTa(rs.getString("Mo_Ta"));
                nhomKH_List.add(nkh);
            }
            return nhomKH_List;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public NhomKhachHang getNhomKHByID(Integer maNhomKH) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            PreparedStatement prst = conn.prepareStatement("Select * From NHOM_KHACH_HANG Where Ma_Nhom_Khach_Hang = ?");
            prst.setInt(1, maNhomKH);
            ResultSet rs = prst.executeQuery();
            while (rs.next()) {
                NhomKhachHang nkh = new NhomKhachHang();
                nkh.setMaNhomKH(rs.getInt("Ma_Nhom_Khach_Hang"));
                nkh.setTenNhomKH(rs.getString("Ten_Nhom_Khach_Hang"));
                nkh.setMoTa(rs.getString("Mo_Ta"));
                return nkh;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.getMessage();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public List<Integer> getListSoKho() {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select So_Kho From TON_KHO");
            List<Integer> listSoKho = new ArrayList<>();
            while (rs.next()) {
                listSoKho.add(rs.getInt("So_Kho"));
            }
            return listSoKho;
        } catch (SQLException ex) {
            Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public List<String> getListMaSanPham() {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select Ma_San_Pham From CHI_TIET_HOA_DON");
            List<String> listMSP = new ArrayList<>();
            while (rs.next()) {
                listMSP.add(rs.getString("Ma_San_Pham").trim());
            }
            return listMSP;
        } catch (SQLException ex) {
            Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public List<ChiTietHoaDon> getListChiTietHoaDon(Integer soHoaDon) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            PreparedStatement prst = conn.prepareStatement("Select * From CHI_TIET_HOA_DON ct, SAN_PHAM sp"
                    + " Where So_Hoa_Don = ? And ct.Ma_San_Pham = sp.Ma_San_Pham");
            prst.setInt(1, soHoaDon);
            ResultSet rs = prst.executeQuery();
            List<ChiTietHoaDon> listCTDH = new ArrayList<ChiTietHoaDon>();
            while (rs.next()) {
                ChiTietHoaDon cthd = new ChiTietHoaDon();
                cthd.setSoHoaDon(rs.getInt("So_Hoa_Don"));
                cthd.setMaSanPham(rs.getString("Ma_San_Pham"));
                cthd.setTenSanPham(rs.getString("Ten_San_Pham"));
                cthd.setDonGiaSanPham(rs.getString("Don_Gia"));
                cthd.setDonViTinh(rs.getString("Don_Vi_Tinh"));
                cthd.setSoLuong(rs.getInt("So_Luong"));
                cthd.setThanhTien(rs.getInt("Thanh_Tien"));
                listCTDH.add(cthd);
            }
            return listCTDH;
        } catch (ClassNotFoundException | SQLException ex) {
            ex.getMessage();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
