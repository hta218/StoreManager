/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseAccessObject_DAO;

import Object_BusinessLogic.LoaiSanPham;
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
public class LoaiSanPhamDAO {

    public List<LoaiSanPham> selectAll() {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            Statement prst = conn.createStatement();
            ResultSet rs = prst.executeQuery("SELECT * FROM LOAI_SAN_PHAM");
            List<LoaiSanPham> loaiSanPhamList = new ArrayList<>();
            while (rs.next()) {
                LoaiSanPham lsp = new LoaiSanPham();
                lsp.setMaLoaiSP(rs.getInt("Ma_Loai_San_Pham"));
                lsp.setTenLoaiSP(rs.getString("Ten_Loai_San_Pham"));
                lsp.setMoTa(rs.getString("Mo_Ta"));
                loaiSanPhamList.add(lsp);
            }
            return loaiSanPhamList;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoaiSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public boolean insert(LoaiSanPham lsp) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            PreparedStatement prst = conn.prepareStatement("INSERT INTO LOAI_SAN_PHAM VALUES (?,?,?)");
            prst.setInt(1, lsp.getMaLoaiSP());
            prst.setString(2, lsp.getTenLoaiSP());
            prst.setString(3, lsp.getMoTa());

            return prst.execute();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoaiSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean update(LoaiSanPham lsp) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            PreparedStatement prst = conn.prepareStatement("UPDATE LOAI_SAN_PHAM SET"
                    + " Ten_Loai_San_Pham = ?,Mo_Ta = ? WHERE Ma_Loai_San_Pham = ?");
            prst.setString(1, lsp.getTenLoaiSP());
            prst.setString(2, lsp.getMoTa());
            prst.setInt(3, lsp.getMaLoaiSP());
            return prst.execute();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoaiSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean delete(LoaiSanPham lsp) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            PreparedStatement prst = conn.prepareStatement("DELETE FROM LOAI_SAN_PHAM WHERE Ma_Loai_San_Pham = ?");
            prst.setInt(1, lsp.getMaLoaiSP());
            return prst.execute();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoaiSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public List<LoaiSanPham> search(LoaiSanPham lsp) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            String sql = "SELECT * FROM LOAI_SAN_PHAM WHERE 1 = 1 ";
            if (lsp.getMaLoaiSP()!= null) {
                sql = sql + "AND Ma_Loai_San_Pham = " + lsp.getMaLoaiSP()+ " ";
            }
            if (lsp.getTenLoaiSP()!= null) {
                sql = sql + "AND Ten_Loai_San_Pham LIKE N'%" + lsp.getTenLoaiSP()+ "%'";
            }
            Statement prst = conn.createStatement();
            ResultSet rs = prst.executeQuery(sql);
            List<LoaiSanPham> loaiSanPhamList = new ArrayList<>();
            while (rs.next()) {
                LoaiSanPham vaiTro = new LoaiSanPham();
                vaiTro.setMaLoaiSP(rs.getInt("Ma_Loai_San_Pham"));
                vaiTro.setTenLoaiSP(rs.getString("Ten_Loai_San_Pham"));
                vaiTro.setMoTa(rs.getString("Mo_Ta"));
                loaiSanPhamList.add(vaiTro);
            }
            return loaiSanPhamList;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoaiSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public LoaiSanPham getLoaiSanPhamByID(Integer maLoaiSanPham) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            PreparedStatement prst = conn.prepareStatement("Select * From LOAI_SAN_PHAM Where Ma_Loai_San_Pham = ?");
            prst.setInt(1, maLoaiSanPham);
            ResultSet rs = prst.executeQuery();
            while (rs.next()) {
                LoaiSanPham lsp = new LoaiSanPham();
                lsp.setMaLoaiSP(rs.getInt("Ma_Loai_San_Pham"));
                lsp.setTenLoaiSP(rs.getString("Ten_Loai_San_Pham"));
                lsp.setMoTa(rs.getString("Mo_Ta"));
                return lsp;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.getMessage();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoaiSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public List<Integer> getListMaLoaiSanPham() {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select Ma_Loai_San_Pham From LOAI_SAN_PHAM");
            List<Integer> listMaLoaiSanPham = new ArrayList<>();
            while (rs.next()) {
                listMaLoaiSanPham.add(rs.getInt("Ma_Loai_San_Pham"));
            }
            return listMaLoaiSanPham;
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
