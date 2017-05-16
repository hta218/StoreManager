/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseAccessObject_DAO;

import Object_BusinessLogic.NhomKhachHang;
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
public class NhomKhachHangDAO {

    public List<NhomKhachHang> selectAll() {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            Statement prst = conn.createStatement();
            ResultSet rs = prst.executeQuery("SELECT * FROM NHOM_KHACH_HANG");
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
                Logger.getLogger(NhomKhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public boolean insert(NhomKhachHang nkh) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            PreparedStatement prst = conn.prepareStatement("INSERT INTO NHOM_KHACH_HANG VALUES (?,?,?)");
            prst.setInt(1, nkh.getMaNhomKH());
            prst.setString(2, nkh.getTenNhomKH());
            prst.setString(3, nkh.getMoTa());

            return prst.execute();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(NhomKhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean update(NhomKhachHang nkh) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            PreparedStatement prst = conn.prepareStatement("UPDATE NHOM_KHACH_HANG SET"
                    + " Ten_Nhom_Khach_Hang = ?,Mo_Ta = ? WHERE Ma_Nhom_Khach_Hang = ?");
            prst.setString(1, nkh.getTenNhomKH());
            prst.setString(2, nkh.getMoTa());
            prst.setInt(3, nkh.getMaNhomKH());
            return prst.execute();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(NhomKhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(NhomKhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(NhomKhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(NhomKhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public List<Integer> getListMaNhomKhachHang() {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select Ma_Nhom_Khach_Hang From NHOM_KHACH_HANG");
            List<Integer> listMNKH = new ArrayList<>();
            while (rs.next()) {
                listMNKH.add(rs.getInt("Ma_Nhom_Khach_Hang"));
            }
            return listMNKH;
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
                Logger.getLogger(NhomKhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
