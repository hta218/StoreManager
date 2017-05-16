/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseAccessObject_DAO;

import Object_BusinessLogic.NhanVien;
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
public class NhanVienDAO {

    public List<NhanVien> selectAll() {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            Statement prst = conn.createStatement();
            ResultSet rs = prst.executeQuery("SELECT * FROM NHAN_VIEN nv, VAI_TRO vt Where "
                    + "nv.Ma_Vai_Tro = vt.Ma_Vai_Tro");
            List<NhanVien> nvList = new ArrayList<>();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNhanVien(rs.getString("Ma_Nhan_Vien").trim());
                nv.setHoTenNhanVien(rs.getString("Ho_Ten_Nhan_Vien").trim());
                nv.setNgaySinh(rs.getDate("Ngay_Sinh"));
                nv.setGioiTinh(rs.getString("Gioi_Tinh").trim());
                nv.setDiaChi(rs.getString("Dia_Chi"));
                nv.setSdt(rs.getInt("SDT"));
                nv.setEmail(rs.getString("Email"));
                nv.setMaVaiTro(rs.getInt("Ma_Vai_Tro"));
                nv.setTenVaiTro(rs.getString("Ten_Vai_Tro"));
                nv.setTaiKhoan(rs.getString("Tai_Khoan").trim());
                nv.setMatKhau(rs.getString("Mat_Khau").trim());
                nvList.add(nv);
            }
            return nvList;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public NhanVien dangNhap(NhanVien nv, String taiKhoan, String matKhau) {
        try {
            Connection conn = null;
            conn = SQL_Connection.getConnection();
            PreparedStatement st = conn.prepareStatement("Select Ma_Nhan_Vien, Ho_Ten_Nhan_Vien "
                    + "From NHAN_VIEN Where Tai_Khoan = ? And Mat_Khau = ?");
            st.setString(1, taiKhoan);
            st.setString(2, matKhau);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                nv.setMaNhanVien(rs.getString("Ma_Nhan_Vien"));
                nv.setHoTenNhanVien(rs.getString("Ho_Ten_Nhan_Vien"));
                return nv;
            }
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<String> getListMaNhanVien() {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select Ma_Nhan_Vien From NHAN_VIEN");
            List<String> listMaNhanVien = new ArrayList<>();
            while (rs.next()) {
                listMaNhanVien.add(rs.getString("Ma_Nhan_Vien").trim());
            }
            return listMaNhanVien;
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public boolean insert(NhanVien nv) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            PreparedStatement prst = conn.prepareStatement("INSERT INTO NHAN_VIEN VALUES (?,?,?,?,?,?,?,?,?,?)");
            prst.setString(1, nv.getMaNhanVien().trim());
            prst.setString(2, (new Convert()).convertName(nv.getHoTenNhanVien()));
            prst.setDate(3, Convert.convertDate(nv.getNgaySinh()));
            prst.setString(4, nv.getGioiTinh().trim());
            prst.setString(5, nv.getDiaChi().trim());
            prst.setInt(6, nv.getSdt());
            prst.setString(7, nv.getEmail());
            prst.setInt(8, nv.getMaVaiTro());
            prst.setString(9, nv.getTaiKhoan());
            prst.setString(10, nv.getMatKhau());
            return prst.execute();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean update(NhanVien nv) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            PreparedStatement prst = conn.prepareStatement("UPDATE NHAN_VIEN SET Ho_Ten_Nhan_Vien = ?, Ngay_Sinh = ?, Gioi_Tinh = ?, "
                    + "Dia_Chi = ?, SDT = ?, Email = ?, Ma_Vai_Tro = ?, Tai_Khoan = ?, Mat_Khau = ? WHERE Ma_Nhan_Vien = ?");
            prst.setString(1, (new Convert()).convertName(nv.getHoTenNhanVien()));
            prst.setDate(2, Convert.convertDate(nv.getNgaySinh()));
            prst.setString(3, nv.getGioiTinh());
            prst.setString(4, nv.getDiaChi());
            prst.setInt(5, nv.getSdt());
            prst.setString(6, nv.getEmail());
            prst.setInt(7, nv.getMaVaiTro());
            prst.setString(8, nv.getTaiKhoan());
            prst.setString(9, nv.getMatKhau());
            prst.setString(10, nv.getMaNhanVien().trim());

            return prst.execute();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean delete(NhanVien nv) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            PreparedStatement prst = conn.prepareStatement("DELETE FROM NHAN_VIEN WHERE Ma_Nhan_Vien = ?");
            prst.setString(1, nv.getMaNhanVien());
            return prst.execute();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public List<NhanVien> search(NhanVien nhanVien) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            String sql = "SELECT * FROM NHAN_VIEN nv, VAI_TRO vt WHERE nv.Ma_Vai_Tro = vt.Ma_Vai_Tro ";
            if (!nhanVien.getHoTenNhanVien().isEmpty()) {
                sql = sql + "AND nv.Ho_Ten_Nhan_Vien LIKE N'%" + nhanVien.getHoTenNhanVien() + "%'";
            }
            if (nhanVien.getSdt() != null) {
                sql = sql + " AND nv.SDT LIKE N'%" + nhanVien.getSdt() + "%'";
            }
            if (nhanVien.getGioiTinh() != null) {
                sql = sql + " AND nv.Gioi_Tinh LIKE N'" + nhanVien.getGioiTinh() + "%'";
            }
            if (nhanVien.getMaVaiTro() != null) {
                sql = sql + " AND nv.Ma_Vai_Tro = " + nhanVien.getMaVaiTro() + "";
            }
            Statement prst = conn.createStatement();
            ResultSet rs = prst.executeQuery(sql);
            List<NhanVien> nvList = new ArrayList<>();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNhanVien(rs.getString("Ma_Nhan_Vien").trim());
                nv.setHoTenNhanVien(rs.getString("Ho_Ten_Nhan_Vien").trim());
                nv.setNgaySinh(rs.getDate("Ngay_Sinh"));
                nv.setGioiTinh(rs.getString("Gioi_Tinh").trim());
                nv.setDiaChi(rs.getString("Dia_Chi"));
                nv.setSdt(rs.getInt("SDT"));
                nv.setEmail(rs.getString("Email"));
                nv.setMaVaiTro(rs.getInt("Ma_Vai_Tro"));
                nv.setTenVaiTro(rs.getString("Ten_Vai_Tro"));
                nv.setTaiKhoan(rs.getString("Tai_Khoan").trim());
                nv.setMatKhau(rs.getString("Mat_Khau").trim());
                nvList.add(nv);
            }
            return nvList;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public NhanVien getNVByID(String maNV) {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            PreparedStatement prst = conn.prepareStatement("Select * From NHAN_VIEN nv, VAI_TRO vt Where "
                    + "nv.Ma_Vai_Tro = vt.Ma_Vai_Tro And nv.Ma_Nhan_Vien Like ?");
            prst.setString(1, "%" + maNV + "%");
            ResultSet rs = prst.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNhanVien(rs.getString("Ma_Nhan_Vien").trim());
                nv.setHoTenNhanVien(rs.getString("Ho_Ten_Nhan_Vien").trim());
                nv.setNgaySinh(rs.getDate("Ngay_Sinh"));
                nv.setGioiTinh(rs.getString("Gioi_Tinh").trim());
                nv.setDiaChi(rs.getString("Dia_Chi").trim());
                nv.setSdt(rs.getInt("SDT"));
                nv.setEmail(rs.getString("Email").trim());
                nv.setMaVaiTro(rs.getInt("Ma_Vai_Tro"));
                nv.setTenVaiTro(rs.getString("Ten_Vai_Tro"));
                nv.setTaiKhoan(rs.getString("Tai_Khoan").trim());
                nv.setMatKhau(rs.getString("Mat_Khau").trim());
                return nv;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.getMessage();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public static List<Integer> getListMaVaiTro() {
        Connection conn = null;
        try {
            conn = SQL_Connection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select Ma_Vai_Tro From NHAN_VIEN");
            List<Integer> listMVT = new ArrayList<>();
            while (rs.next()) {
                listMVT.add(rs.getInt("Ma_Vai_Tro"));
            }
            return listMVT;
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
