/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseAccessObject_DAO;

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
public class TonKhoDAO {

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
                Logger.getLogger(TonKhoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public boolean insert(TonKho tk) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            PreparedStatement prst = conn.prepareStatement("INSERT INTO TON_KHO VALUES (?,?,?)");
            prst.setInt(1, tk.getSoKho());
            prst.setString(2, tk.getMaSanPham());
            prst.setInt(3, tk.getSoLuong());

            return prst.execute();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(TonKhoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean capNhat(TonKho tk) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            PreparedStatement prst = conn.prepareStatement("Update TON_KHO Set So_Luong = ? Where So_Kho = ? And Ma_San_Pham Like ?");
            prst.setInt(2, tk.getSoKho());
            prst.setString(3, "%" + tk.getMaSanPham() + "%");
            prst.setInt(1, tk.getSoLuong());

            return prst.execute();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(TonKhoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean update(String maSanPham, Integer soLuong) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            PreparedStatement prst = conn.prepareStatement("Select * From TON_KHO Where"
                    + " Ma_San_Pham Like ?");
            maSanPham = "%" + maSanPham + "%";
            prst.setString(1, maSanPham);
            ResultSet rs = prst.executeQuery();
            List<TonKho> listTonKho = new ArrayList<TonKho>();
            while (rs.next()) {
                TonKho tonKho = new TonKho();
                tonKho.setSoKho(rs.getInt("So_Kho"));
                tonKho.setMaSanPham(rs.getString("Ma_San_Pham"));
                tonKho.setSoLuong(rs.getInt("So_Luong"));
                listTonKho.add(tonKho);
            }
            String sql = "Update TON_KHO SET So_Luong = ? Where So_Kho = ? And Ma_San_Pham Like ?";
            PreparedStatement pr = conn.prepareStatement(sql);
            for (TonKho tonKho : listTonKho) {
                Integer soLuongTrongKho = tonKho.getSoLuong();
                if (soLuongTrongKho >= soLuong) {
                    pr.setInt(1, soLuongTrongKho - soLuong);
                    pr.setInt(2, tonKho.getSoKho());
                    pr.setString(3, maSanPham);
                    pr.execute();
                    break;
                } else {
                    pr.setInt(1, 0);
                    pr.setInt(2, tonKho.getSoKho());
                    pr.setString(3, maSanPham);
                    pr.execute();
                    soLuong = soLuong - soLuongTrongKho;
                }
            }
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(TonKhoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean delete(Integer soKho, String maSanPham) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            PreparedStatement prst = conn.prepareStatement("DELETE FROM TON_KHO WHERE So_Kho = ? And Ma_San_Pham Like ?");
            prst.setInt(1, soKho);
            prst.setString(2, "%" + maSanPham.trim() + "%");
            return prst.execute();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(TonKhoDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(TonKhoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public Integer getSoLuongConLai(TonKho tk) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            PreparedStatement prst = conn.prepareStatement("Select So_Luong From TON_KHO Where So_Kho = ? And Ma_San_Pham Like ?");
            prst.setInt(1, tk.getSoKho());
            prst.setString(2, "%" + tk.getMaSanPham() + "%");
            ResultSet rs = prst.executeQuery();
                while (rs.next()) {
                    return rs.getInt(1);
                }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.getMessage();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(TonKhoDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            ResultSet rs = st.executeQuery("Select Ma_San_Pham From TON_KHO");
            List<String> listMaSanPham = new ArrayList<>();
            while (rs.next()) {
                listMaSanPham.add(rs.getString("Ma_San_Pham").trim());
            }
            return listMaSanPham;
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
    
    public List<String> getListMaSanPhamConLai(Integer soKho) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select Ma_San_Pham From TON_KHO Where So_Kho = " + soKho);
            List<String> listMaSanPham = new ArrayList<>();
            while (rs.next()) {
                listMaSanPham.add(rs.getString("Ma_San_Pham").trim());
            }
            return listMaSanPham;
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

    public NhomKhachHang getNKHByID(Integer maNKH) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            PreparedStatement prst = conn.prepareStatement("Select * From NHOM_KHACH_HANG Where Ma_Nhom_Khach_Hang = ?");
            prst.setInt(1, maNKH);
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
                Logger.getLogger(TonKhoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
