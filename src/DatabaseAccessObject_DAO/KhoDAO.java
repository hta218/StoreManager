/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseAccessObject_DAO;

import Object_BusinessLogic.Kho;
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
public class KhoDAO {

    public List<Kho> selectAll() {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            Statement prst = conn.createStatement();
            ResultSet rs = prst.executeQuery("SELECT kh.*, nv.Ma_Nhan_Vien, nv.Ho_Ten_Nhan_Vien FROM KHO kh Inner Join NHAN_VIEN nv On "
                    + "kh.Ma_Nhan_Vien = nv.Ma_Nhan_Vien");
            List<Kho> khList = new ArrayList<>();
            while (rs.next()) {
                Kho kh = new Kho();
                kh.setSoKho(rs.getInt("So_Kho"));
                kh.setTenKho(rs.getString("Ten_Kho"));
                kh.setDiaChi(rs.getString("Dia_Chi"));
                kh.setSdt(rs.getInt("SDT"));
                kh.setMaNhanVien(rs.getString("Ma_Nhan_Vien").trim());
                kh.setTenNhanVien(rs.getString("Ho_Ten_Nhan_Vien"));
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
                Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public List<Integer> getListSoKho() {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select So_Kho From KHO");
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

    public boolean insert(Kho kh) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            PreparedStatement prst = conn.prepareStatement("INSERT INTO KHO VALUES (?,?,?,?,?)");
            prst.setInt(1, kh.getSoKho());
            prst.setString(2, kh.getTenKho());
            prst.setString(3, kh.getDiaChi());
            prst.setString(4, kh.getMaNhanVien());
            prst.setInt(5, kh.getSdt());
            return prst.execute();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean update(Kho kh) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            PreparedStatement prst = conn.prepareStatement("UPDATE KHO SET Dia_Chi = ?, "
                    + "Ten_Kho = ?, SDT = ?, Ma_Nhan_Vien = ? WHERE So_Kho = ?");
            prst.setString(1, kh.getDiaChi());
            prst.setString(2, kh.getTenKho());
            prst.setInt(3, kh.getSdt());
            prst.setString(4, kh.getMaNhanVien());
            prst.setInt(5, kh.getSoKho());
            return prst.execute();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean delete(Kho kh) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            PreparedStatement prst = conn.prepareStatement("DELETE FROM KHO WHERE So_Kho = ?");
            prst.setInt(1, kh.getSoKho());
            return prst.execute();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public List<Kho> search(Kho kho) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            String sql = "SELECT * FROM KHO kh, NHAN_VIEN nv WHERE kh.Ma_Nhan_Vien = nv.Ma_Nhan_Vien ";
            if (kho.getSoKho() != null) {
                sql = sql + "AND kh.So_Kho LIKE N'%" + kho.getSoKho() + "%'";
            }
            if (kho.getSdt() != null) {
                sql = sql + " AND kh.SDT LIKE N'%" + kho.getSdt() + "%'";
            }
            if (kho.getTenKho() != null) {
                sql = sql + " AND kh.Ten_Kho LIKE N'%" + kho.getTenKho() + "%'";
            }
            if (kho.getMaNhanVien() != null) {
                sql = sql + " AND kh.Ma_Nhan_Vien Like N'%" + kho.getMaNhanVien() + "%' ";
            }
            Statement prst = conn.createStatement();
            ResultSet rs = prst.executeQuery(sql);
            List<Kho> khList = new ArrayList<>();
            while (rs.next()) {
                Kho kh = new Kho();
                kh.setSoKho(rs.getInt("So_Kho"));
                kh.setTenKho(rs.getString("Ten_Kho"));
                kh.setDiaChi(rs.getString("Dia_Chi"));
                kh.setSdt(rs.getInt("SDT"));
                kh.setMaNhanVien(rs.getString("Ma_Nhan_Vien").trim());
                kh.setTenNhanVien(rs.getString("Ho_Ten_Nhan_Vien"));
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
                Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public Kho getKhoByID(Integer soKho) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            PreparedStatement prst = conn.prepareStatement("SELECT kh.*, nv.Ma_Nhan_Vien, nv.Ho_Ten_Nhan_Vien "
                    + "FROM KHO kh Inner Join NHAN_VIEN nv On "
                    + "kh.Ma_Nhan_Vien = nv.Ma_Nhan_Vien And So_Kho = ?");
            prst.setInt(1, soKho);
            ResultSet rs = prst.executeQuery();
            while (rs.next()) {
                Kho kh = new Kho();
                kh.setSoKho(rs.getInt("So_Kho"));
                kh.setTenKho(rs.getString("Ten_Kho").trim());
                kh.setDiaChi(rs.getString("Dia_Chi").trim());
                kh.setSdt(rs.getInt("SDT"));
                kh.setMaNhanVien(rs.getString("Ma_Nhan_Vien").trim());
                kh.setTenNhanVien(rs.getString("Ho_Ten_Nhan_Vien"));
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
                Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
     public static List<String> getListMaNhanVien() {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select Ma_Nhan_Vien From KHO");
            List<String> listMaNhanVien = new ArrayList<>();
            while (rs.next()) {
                listMaNhanVien.add(rs.getString("Ma_Nhan_Vien").trim());
            }
            return listMaNhanVien;
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
}
