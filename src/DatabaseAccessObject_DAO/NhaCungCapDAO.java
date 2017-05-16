/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseAccessObject_DAO;

import Object_BusinessLogic.NhaCungCap;
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
public class NhaCungCapDAO {

    public List<NhaCungCap> selectAll() {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            Statement prst = conn.createStatement();
            ResultSet rs = prst.executeQuery("SELECT * FROM NHA_CUNG_CAP");
            List<NhaCungCap> nccList = new ArrayList<>();
            while (rs.next()) {
                NhaCungCap ncc = new NhaCungCap();
                ncc.setMaNhaCC(rs.getInt("Ma_Nha_Cung_Cap"));
                ncc.setTenNhaCC(rs.getString("Ten_Nha_Cung_Cap"));
                ncc.setDiaChi(rs.getString("Dia_Chi"));
                ncc.setSdt(rs.getInt("SDT"));
                ncc.setEmail(rs.getString("Email"));
                nccList.add(ncc);
            }
            return nccList;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public List<Integer> getListMaNhaCungCap() {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select Ma_Nha_Cung_Cap From NHA_CUNG_CAP");
            List<Integer> listMaNhaCungCap = new ArrayList<>();
            while (rs.next()) {
                listMaNhaCungCap.add(rs.getInt("Ma_Nha_Cung_Cap"));
            }
            return listMaNhaCungCap;
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public boolean insert(NhaCungCap ncc) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            PreparedStatement prst = conn.prepareStatement("INSERT INTO NHA_CUNG_CAP VALUES (?,?,?,?,?)");
            prst.setInt(1, ncc.getMaNhaCC());
            prst.setString(2, ncc.getTenNhaCC());
            prst.setString(3, ncc.getDiaChi());
            prst.setInt(4, ncc.getSdt());
            prst.setString(5, ncc.getEmail());
            return prst.execute();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean update(NhaCungCap ncc) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            PreparedStatement prst = conn.prepareStatement("UPDATE NHA_CUNG_CAP SET Dia_Chi = ?, "
                    + "Ten_Nha_Cung_Cap = ?, SDT = ?, Email = ? WHERE Ma_Nha_Cung_Cap = ?");
            prst.setString(1, ncc.getDiaChi());
            prst.setString(2, ncc.getTenNhaCC());
            prst.setInt(3, ncc.getSdt());
            prst.setString(4, ncc.getEmail());
            prst.setInt(5, ncc.getMaNhaCC());
            return prst.execute();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean delete(NhaCungCap ncc) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            PreparedStatement prst = conn.prepareStatement("DELETE FROM NHA_CUNG_CAP WHERE Ma_Nha_Cung_Cap = ?");
            prst.setInt(1, ncc.getMaNhaCC());
            return prst.execute();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public List<NhaCungCap> search(NhaCungCap ncco) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            String sql = "SELECT * FROM NHA_CUNG_CAP ncc WHERE 1=1 ";
            if (ncco.getMaNhaCC() != null) {
                sql = sql + "AND ncc.Ma_Nha_Cung_Cap LIKE N'%" + ncco.getMaNhaCC() + "%'";
            }
            if (ncco.getSdt() != null) {
                sql = sql + " AND ncc.SDT LIKE N'%" + ncco.getSdt() + "%'";
            }
            if (ncco.getTenNhaCC() != null) {
                sql = sql + " AND ncc.Ten_Nha_Cung_Cap LIKE N'%" + ncco.getTenNhaCC() + "%'";
            }
            Statement prst = conn.createStatement();
            ResultSet rs = prst.executeQuery(sql);
            List<NhaCungCap> nccList = new ArrayList<>();
            while (rs.next()) {
                NhaCungCap ncc = new NhaCungCap();
                ncc.setMaNhaCC(rs.getInt("Ma_Nha_Cung_Cap"));
                ncc.setTenNhaCC(rs.getString("Ten_Nha_Cung_Cap"));
                ncc.setDiaChi(rs.getString("Dia_Chi"));
                ncc.setSdt(rs.getInt("SDT"));
                ncc.setEmail(rs.getString("Email"));
                nccList.add(ncc);
            }
            return nccList;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public NhaCungCap getNhaCungCapByID(Integer maNhaCungCap) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            PreparedStatement prst = conn.prepareStatement("SELECT * FROM NHA_CUNG_CAP Where Ma_Nha_Cung_Cap = ?");
            prst.setInt(1, maNhaCungCap);
            ResultSet rs = prst.executeQuery();
            while (rs.next()) {
                NhaCungCap ncc = new NhaCungCap();
                ncc.setMaNhaCC(rs.getInt("Ma_Nha_Cung_Cap"));
                ncc.setTenNhaCC(rs.getString("Ten_Nha_Cung_Cap").trim());
                ncc.setDiaChi(rs.getString("Dia_Chi").trim());
                ncc.setSdt(rs.getInt("SDT"));
                ncc.setEmail(rs.getString("Email"));
                return ncc;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.getMessage();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
