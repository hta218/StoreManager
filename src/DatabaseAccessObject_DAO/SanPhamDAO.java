/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseAccessObject_DAO;

import Object_BusinessLogic.SanPham;
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
public class SanPhamDAO {

    public List<SanPham> selectAll() {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            Statement prst = conn.createStatement();
            ResultSet rs = prst.executeQuery("SELECT * FROM SAN_PHAM sp, NHA_CUNG_CAP ncc, LOAI_SAN_PHAM lsp Where "
                    + "sp.Ma_Loai_San_Pham = lsp.Ma_Loai_San_Pham And sp.Ma_Nha_Cung_Cap = ncc.Ma_Nha_Cung_Cap");
            List<SanPham> sanPhamList = new ArrayList<>();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSanPham(rs.getString("Ma_San_Pham"));
                sp.setTenSanPham(rs.getString("Ten_San_Pham"));
                sp.setMaLoaiSP(rs.getInt("Ma_Loai_San_Pham"));
                sp.setDonViTinh(rs.getString("Don_Vi_Tinh"));
                sp.setDonGia(rs.getInt("Don_Gia"));
                sp.setTenLoaiSP(rs.getString("Ten_Loai_San_Pham"));
                sp.setXuatXu(rs.getString("Xuat_Xu"));
                sp.setMaNhaCC(rs.getInt("Ma_Nha_Cung_Cap"));
                sp.setTenNhaCC(rs.getString("Ten_Nha_Cung_Cap"));
                sanPhamList.add(sp);
            }
            return sanPhamList;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public Integer getSoLuongConLai(String maSanPham) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            Statement prst = conn.createStatement();
            String sql = "Select sp.Ma_San_Pham, SUM(tk.So_Luong) As 'So Luong' "
                    + "From SAN_PHAM sp, TON_KHO tk Where sp.Ma_San_Pham = tk.Ma_San_Pham\n"
                    + " And sp.Ma_San_Pham Like " + "'%" + maSanPham.trim() + "%'" + " Group By sp.Ma_San_Pham";
            ResultSet rs = prst.executeQuery(sql);
            Integer soLuong = 0;
            while (rs.next()) {
                soLuong = rs.getInt("So Luong");
            }
            return soLuong;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public boolean insert(SanPham sp) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            PreparedStatement prst = conn.prepareStatement("INSERT INTO SAN_PHAM VALUES (?,?,?,?,?,?,?)");
            prst.setString(1, sp.getMaSanPham());
            prst.setInt(2, sp.getMaLoaiSP());
            prst.setString(3, sp.getTenSanPham());
            prst.setString(4, sp.getDonViTinh());
            prst.setInt(5, sp.getDonGia());
            prst.setInt(6, sp.getMaNhaCC());
            prst.setString(7, sp.getXuatXu());

            return prst.execute();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean update(SanPham sp) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            PreparedStatement prst = conn.prepareStatement("UPDATE SAN_PHAM SET Ma_Loai_San_Pham = ?, Ten_San_Pham = ?, "
                    + " Don_Vi_Tinh = ?, Don_Gia = ?, Ma_Nha_Cung_Cap = ?, Xuat_Xu = ? WHERE Ma_San_Pham = ?");
            prst.setInt(1, sp.getMaLoaiSP());
            prst.setString(2, sp.getTenSanPham());
            prst.setString(3, sp.getDonViTinh());
            prst.setInt(4, sp.getDonGia());
            prst.setInt(5, sp.getMaNhaCC());
            prst.setString(6, sp.getXuatXu());
            prst.setString(7, sp.getMaSanPham());
            return prst.execute();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean delete(SanPham sp) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            PreparedStatement prst = conn.prepareStatement("DELETE FROM SAN_PHAM WHERE Ma_San_Pham = ?");
            prst.setString(1, sp.getMaSanPham());
            return prst.execute();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public List<SanPham> search(SanPham sanPham, Integer giaMax, Integer giaMin) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            String sql = "SELECT * FROM SAN_PHAM sp, NHA_CUNG_CAP ncc, LOAI_SAN_PHAM lsp Where "
                    + "sp.Ma_Loai_San_Pham = lsp.Ma_Loai_San_Pham And sp.Ma_Nha_Cung_Cap = ncc.Ma_Nha_Cung_Cap";
            if (sanPham.getTenSanPham() != null) {
                sql = sql + " AND sp.Ten_San_Pham Like N'%" + sanPham.getTenSanPham() + "%' ";
            }
            if (sanPham.getMaLoaiSP() != null) {
                sql = sql + " AND sp.Ma_Loai_San_Pham = " + sanPham.getMaLoaiSP() + " ";
            }
            if (sanPham.getMaNhaCC() != null) {
                sql = sql + "AND sp.Ma_Nha_Cung_Cap = " + sanPham.getMaNhaCC() + " ";
            }
            if (giaMin != null) {
                sql = sql + " And sp.Don_Gia >= " + giaMin;
            }
            if (giaMax != null) {
                sql = sql + " And sp.Don_Gia <= " + giaMax;
            }
            Statement prst = conn.createStatement();
            ResultSet rs = prst.executeQuery(sql);
            List<SanPham> sanPhamList = new ArrayList<>();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSanPham(rs.getString("Ma_San_Pham"));
                sp.setTenSanPham(rs.getString("Ten_San_Pham"));
                sp.setMaLoaiSP(rs.getInt("Ma_Loai_San_Pham"));
                sp.setDonViTinh(rs.getString("Don_Vi_Tinh"));
                sp.setDonGia(rs.getInt("Don_Gia"));
                sp.setTenLoaiSP(rs.getString("Ten_Loai_San_Pham"));
                sp.setXuatXu(rs.getString("Xuat_Xu"));
                sp.setMaNhaCC(rs.getInt("Ma_Nha_Cung_Cap"));
                sp.setTenNhaCC(rs.getString("Ten_Nha_Cung_Cap"));
                sanPhamList.add(sp);
            }
            return sanPhamList;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public SanPham getSanPhamByID(String maSanPham) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            PreparedStatement prst = conn.prepareStatement("SELECT * FROM SAN_PHAM sp, NHA_CUNG_CAP ncc, LOAI_SAN_PHAM lsp Where "
                    + "sp.Ma_Loai_San_Pham = lsp.Ma_Loai_San_Pham And sp.Ma_Nha_Cung_Cap = ncc.Ma_Nha_Cung_Cap And sp.Ma_San_Pham Like ?");
            prst.setString(1, "%" + maSanPham.trim() + "%");
            ResultSet rs = prst.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSanPham(rs.getString("Ma_San_Pham").trim());
                sp.setTenSanPham(rs.getString("Ten_San_Pham").trim());
                sp.setMaLoaiSP(rs.getInt("Ma_Loai_San_Pham"));
                sp.setDonViTinh(rs.getString("Don_Vi_Tinh").trim());
                sp.setDonGia(rs.getInt("Don_Gia"));
                sp.setTenLoaiSP(rs.getString("Ten_Loai_San_Pham").trim());
                sp.setXuatXu(rs.getString("Xuat_Xu").trim());
                sp.setMaNhaCC(rs.getInt("Ma_Nha_Cung_Cap"));
                sp.setTenNhaCC(rs.getString("Ten_Nha_Cung_Cap").trim());
                return sp;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.getMessage();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public List<String> getListMaSanPham() {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select Ma_San_Pham From SAN_PHAM");
            List<String> listMaSanPham = new ArrayList<>();
            while (rs.next()) {
                listMaSanPham.add(rs.getString("Ma_San_Pham").trim().toUpperCase());
            }
            return listMaSanPham;
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

    public List<Integer> getListMaLoaiSanPham() {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select Ma_Loai_San_Pham From SAN_PHAM");
            List<Integer> listMaSanPham = new ArrayList<>();
            while (rs.next()) {
                listMaSanPham.add(rs.getInt("Ma_Loai_San_Pham"));
            }
            return listMaSanPham;
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

    public List<Integer> getListMaNhaCC() {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select Ma_Nha_Cung_Cap From SAN_PHAM");
            List<Integer> listMaNCC = new ArrayList<>();
            while (rs.next()) {
                listMaNCC.add(rs.getInt("Ma_Nha_Cung_Cap"));
            }
            return listMaNCC;
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
