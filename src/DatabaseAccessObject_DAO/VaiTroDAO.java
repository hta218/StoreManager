/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseAccessObject_DAO;

import Object_BusinessLogic.VaiTro;
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
public class VaiTroDAO {

    public List<VaiTro> selectAll() {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            Statement prst = conn.createStatement();
            ResultSet rs = prst.executeQuery("SELECT * FROM VAI_TRO");
            List<VaiTro> vaiTroList = new ArrayList<>();
            while (rs.next()) {
                VaiTro vt = new VaiTro();
                vt.setMaVaiTro(rs.getInt("Ma_Vai_Tro"));
                vt.setTenVaiTro(rs.getString("Ten_Vai_Tro"));
                vt.setMoTa(rs.getString("Mo_Ta"));
                vaiTroList.add(vt);
            }
            return vaiTroList;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(VaiTroDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public boolean insert(VaiTro vt) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            PreparedStatement prst = conn.prepareStatement("INSERT INTO VAI_TRO VALUES (?,?,?)");
            prst.setInt(1, vt.getMaVaiTro());
            prst.setString(2, vt.getTenVaiTro());
            prst.setString(3, vt.getMoTa());

            return prst.execute();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(VaiTroDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean update(VaiTro vt) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            PreparedStatement prst = conn.prepareStatement("UPDATE VAI_TRO SET"
                    + " Ten_Vai_Tro = ?,Mo_Ta = ? WHERE Ma_Vai_Tro = ?");
            prst.setString(1, vt.getTenVaiTro());
            prst.setString(2, vt.getMoTa());
            prst.setInt(3, vt.getMaVaiTro());
            return prst.execute();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(VaiTroDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean delete(VaiTro vt) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            PreparedStatement prst = conn.prepareStatement("DELETE FROM VAI_TRO WHERE Ma_Vai_Tro = ?");
            prst.setInt(1, vt.getMaVaiTro());
            return prst.execute();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(VaiTroDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public List<VaiTro> search(VaiTro vt) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            String sql = "SELECT * FROM VAI_TRO WHERE 1 = 1 ";
            if (vt.getMaVaiTro()!= null) {
                sql = sql + "AND Ma_Vai_Tro = " + vt.getMaVaiTro()+ " ";
            }
            if (vt.getTenVaiTro()!= null) {
                sql = sql + "AND Ten_Vai_Tro LIKE N'%" + vt.getTenVaiTro()+ "%'";
            }
            Statement prst = conn.createStatement();
            ResultSet rs = prst.executeQuery(sql);
            List<VaiTro> vaiTroList = new ArrayList<>();
            while (rs.next()) {
                VaiTro vaiTro = new VaiTro();
                vaiTro.setMaVaiTro(rs.getInt("Ma_Vai_Tro"));
                vaiTro.setTenVaiTro(rs.getString("Ten_Vai_Tro"));
                vaiTro.setMoTa(rs.getString("Mo_Ta"));
                vaiTroList.add(vaiTro);
            }
            return vaiTroList;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(VaiTroDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public VaiTro getVaiTroByID(Integer maVaiTro) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            PreparedStatement prst = conn.prepareStatement("Select * From VAI_TRO Where Ma_Vai_Tro = ?");
            prst.setInt(1, maVaiTro);
            ResultSet rs = prst.executeQuery();
            while (rs.next()) {
                VaiTro vt = new VaiTro();
                vt.setMaVaiTro(rs.getInt("Ma_Vai_Tro"));
                vt.setTenVaiTro(rs.getString("Ten_Vai_Tro"));
                vt.setMoTa(rs.getString("Mo_Ta"));
                return vt;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.getMessage();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(VaiTroDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public List<Integer> getListMaVaiTro() {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select Ma_Vai_Tro From VAI_TRO");
            List<Integer> listMaVaiTro = new ArrayList<>();
            while (rs.next()) {
                listMaVaiTro.add(rs.getInt("Ma_Vai_Tro"));
            }
            return listMaVaiTro;
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
