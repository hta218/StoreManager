/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form_Presentation;

import DatabaseAccessObject_DAO.ChiTietHoaDonDAO;
import DatabaseAccessObject_DAO.HoaDonDAO;
import DatabaseAccessObject_DAO.KhachHangDAO;
import DatabaseAccessObject_DAO.LoaiSanPhamDAO;
import DatabaseAccessObject_DAO.NhaCungCapDAO;
import DatabaseAccessObject_DAO.NhomKhachHangDAO;
import DatabaseAccessObject_DAO.SanPhamDAO;
import DatabaseAccessObject_DAO.TonKhoDAO;
import Functions.pdf_Export;
import Object_BusinessLogic.ChiTietHoaDon;
import Object_BusinessLogic.HoaDon;
import Object_BusinessLogic.KhachHang;
import Object_BusinessLogic.LoaiSanPham;
import Object_BusinessLogic.NhaCungCap;
import Object_BusinessLogic.NhanVien;
import Object_BusinessLogic.NhomKhachHang;
import Object_BusinessLogic.SanPham;
import SQL_Connection.Convert;
import java.awt.Component;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Huynh
 */
public class Form_MuaHang extends javax.swing.JFrame {

    DefaultTableModel tableModel = new DefaultTableModel();
    DefaultTableModel tm = new DefaultTableModel();
    DecimalFormat df = new DecimalFormat("#,###");

    NhanVien nhanVien;
    public String ghiChu = "";

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    /**
     * Creates new form MuaHang
     */
    public Form_MuaHang() {
        try {
            initComponents();
            loadDataIntoTaBle_SanPham();
            loadDataIntoTaBle_KhachHang();
            loadCombobox_NhomKhachHang_Search();
            cbb_Search_NhomKH.setSelectedItem(null);
            loadCombobox_NhaCungCap_Search();
            cbb_Search_NhaCC.setSelectedItem(null);
            loadCombobox_LoaiSP_Search();
            cbb_Search_LoaiSP.setSelectedItem(null);
            btn_export_2_PDF.setToolTipText("Export this bill to PDF");

            lbl_GiaMax_Hint.setVisible(false);
            lbl_GiaMin_Hint.setVisible(false);
            lbl_SoLuong_SanPham_Hint.setVisible(false);
            lbl_sdt_Search_Hint.setVisible(false);
            lbl_soLuong_sanPham_Bo_Hint.setVisible(false);
            tm.addColumn("Product ID");
            tm.addColumn("Product Name");
            tm.addColumn("Unit");
            tm.addColumn("Price (VND)");
            tm.addColumn("Quantity");
            tm.addColumn("Amount");
            date_ngayBanHang.setDate(new Date());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Form_MuaHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Form_MuaHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Form_MuaHang(NhanVien nv) {
        try {
            nhanVien = nv;
            initComponents();
            loadDataIntoTaBle_SanPham();
            loadDataIntoTaBle_KhachHang();
            loadCombobox_NhomKhachHang_Search();
            cbb_Search_NhomKH.setSelectedItem(null);
            loadCombobox_NhaCungCap_Search();
            cbb_Search_NhaCC.setSelectedItem(null);
            loadCombobox_LoaiSP_Search();
            cbb_Search_LoaiSP.setSelectedItem(null);
            btn_export_2_PDF.setToolTipText("Export this bill to PDF");

            lbl_NhanVienBanHang.setText(nv.getHoTenNhanVien() + "     (ID: " + nv.getMaNhanVien() + ")");
            lbl_GiaMax_Hint.setVisible(false);
            lbl_GiaMin_Hint.setVisible(false);
            lbl_SoLuong_SanPham_Hint.setVisible(false);
            lbl_sdt_Search_Hint.setVisible(false);
            lbl_soLuong_sanPham_Bo_Hint.setVisible(false);
            tm.addColumn("Product ID");
            tm.addColumn("Product Name");
            tm.addColumn("Unit");
            tm.addColumn("Price (VND)");
            tm.addColumn("Quantity");
            tm.addColumn("Amount");
            date_ngayBanHang.setDate(new Date());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Form_MuaHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Form_MuaHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg_GioiTinh = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txt_Search_TenSanPham = new javax.swing.JTextField();
        cbb_Search_NhaCC = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        btn_TimKiem = new javax.swing.JButton();
        btn_Search_Clear = new javax.swing.JButton();
        cbb_Search_LoaiSP = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txt_Search_GiaMin = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_Search_GiaMax = new javax.swing.JTextField();
        lbl_GiaMin_Hint = new javax.swing.JLabel();
        lbl_GiaMax_Hint = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tab_SanPham = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;   //Disallow the editing of any cell
            }
        };
        btn_List_SanPHam = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txt_SoLuong_SanPhamMua = new javax.swing.JTextField();
        btn_ThemVaoGio = new javax.swing.JButton();
        lbl_SoLuong_SanPham_Hint = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_refresh_cbb1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txt_Search_TenKH = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txt_Search_sdt = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        cbb_Search_NhomKH = new javax.swing.JComboBox();
        jLabel20 = new javax.swing.JLabel();
        btn_TimKiem_KhachHang = new javax.swing.JButton();
        rbn_SearchNam = new javax.swing.JRadioButton();
        rbn_SearchNu = new javax.swing.JRadioButton();
        btn_Search_KH_Clear = new javax.swing.JButton();
        lbl_sdt_Search_Hint = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tab_KhachHang = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;   //Disallow the editing of any cell
            }
        };
        btn_ListKH = new javax.swing.JButton();
        btn_ChonKhachHang = new javax.swing.JButton();
        btn_refresh_cbb = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        date_ngayBanHang = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_DiaChi = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbl_TenKhachHang = new javax.swing.JLabel();
        lbl_Sdt = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txt_HinhThucThanhToan = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tab_ThongTinHangHoa = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;   //Disallow the editing of any cell
            }
        };
        jLabel22 = new javax.swing.JLabel();
        lbl_SoTienPhaiTra = new javax.swing.JLabel();
        btn_TaoMoiHoaDon = new javax.swing.JButton();
        btn_ThanhToan = new javax.swing.JButton();
        btn_BoSanPham = new javax.swing.JButton();
        lbl_soLuong_sanPham_Bo_Hint = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_soLuong_SanPhamBo = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        lbl_NhanVienBanHang = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btn_ghiChu = new javax.swing.JButton();
        lbl_SoHoaDon = new javax.swing.JLabel();
        lbl_MaKhachHang = new javax.swing.JLabel();
        btn_export_2_PDF = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1271, 704));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Bill Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        jTabbedPane1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "Search"));
        jPanel3.setForeground(new java.awt.Color(0, 204, 0));
        jPanel3.setLayout(null);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setText("Product Name");
        jPanel3.add(jLabel12);
        jLabel12.setBounds(15, 25, 86, 17);

        txt_Search_TenSanPham.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel3.add(txt_Search_TenSanPham);
        txt_Search_TenSanPham.setBounds(119, 20, 209, 30);

        cbb_Search_NhaCC.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cbb_Search_NhaCC.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(cbb_Search_NhaCC);
        cbb_Search_NhaCC.setBounds(119, 111, 209, 30);

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel15.setText("Supplier");
        jPanel3.add(jLabel15);
        jLabel15.setBounds(15, 118, 73, 17);

        btn_TimKiem.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_TimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search-b-icon.png"))); // NOI18N
        btn_TimKiem.setText("Search");
        btn_TimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TimKiemActionPerformed(evt);
            }
        });
        jPanel3.add(btn_TimKiem);
        btn_TimKiem.setBounds(40, 159, 119, 43);

        btn_Search_Clear.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_Search_Clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Actions-edit-clear-icon.png"))); // NOI18N
        btn_Search_Clear.setText("Clear");
        btn_Search_Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Search_ClearActionPerformed(evt);
            }
        });
        jPanel3.add(btn_Search_Clear);
        btn_Search_Clear.setBounds(169, 159, 115, 43);

        cbb_Search_LoaiSP.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cbb_Search_LoaiSP.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(cbb_Search_LoaiSP);
        cbb_Search_LoaiSP.setBounds(119, 61, 209, 32);

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel16.setText("Product Type");
        jPanel3.add(jLabel16);
        jLabel16.setBounds(15, 69, 86, 17);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "Unit Price (VND)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel17.setText("To");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 102, -1, -1));

        txt_Search_GiaMin.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel4.add(txt_Search_GiaMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 30, 214, 30));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setText("From");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 36, -1, -1));

        txt_Search_GiaMax.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel4.add(txt_Search_GiaMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 96, 214, 30));

        lbl_GiaMin_Hint.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lbl_GiaMin_Hint.setForeground(new java.awt.Color(204, 51, 0));
        lbl_GiaMin_Hint.setText("  Invalid!");
        jPanel4.add(lbl_GiaMin_Hint, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 61, 90, 20));

        lbl_GiaMax_Hint.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lbl_GiaMax_Hint.setForeground(new java.awt.Color(204, 51, 0));
        lbl_GiaMax_Hint.setText("  Invalid!");
        jPanel4.add(lbl_GiaMax_Hint, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 132, 90, 20));

        jPanel3.add(jPanel4);
        jPanel4.setBounds(340, 20, 300, 180);

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 644, 230));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Product List", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N

        tab_SanPham.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tab_SanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tab_SanPham.getTableHeader().setReorderingAllowed(false);
        tab_SanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab_SanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tab_SanPham);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 299, 644, -1));

        btn_List_SanPHam.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_List_SanPHam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Actions-view-calendar-list-icon.png"))); // NOI18N
        btn_List_SanPHam.setText("Product List");
        btn_List_SanPHam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_List_SanPHamActionPerformed(evt);
            }
        });
        jPanel2.add(btn_List_SanPHam, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 247, 184, 40));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Quantity*");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 70, 25));

        txt_SoLuong_SanPhamMua.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel2.add(txt_SoLuong_SanPhamMua, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 540, 173, 30));

        btn_ThemVaoGio.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_ThemVaoGio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/shop-cart-add-icon.png"))); // NOI18N
        btn_ThemVaoGio.setText("Add To Cart");
        btn_ThemVaoGio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemVaoGioActionPerformed(evt);
            }
        });
        jPanel2.add(btn_ThemVaoGio, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 550, 182, 43));

        lbl_SoLuong_SanPham_Hint.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lbl_SoLuong_SanPham_Hint.setForeground(new java.awt.Color(204, 51, 0));
        lbl_SoLuong_SanPham_Hint.setText("  Invalid!");
        jPanel2.add(lbl_SoLuong_SanPham_Hint, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 570, 90, 20));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("(Enter a number)");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 540, 120, 25));

        btn_refresh_cbb1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_refresh_cbb1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/system-software-update-icon.png"))); // NOI18N
        btn_refresh_cbb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refresh_cbb1ActionPerformed(evt);
            }
        });
        jPanel2.add(btn_refresh_cbb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 247, -1, 40));

        jTabbedPane1.addTab("Product", jPanel2);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Search"));
        jPanel7.setForeground(new java.awt.Color(0, 204, 0));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setText("Customer Name");

        txt_Search_TenKH.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel18.setText("Phone Number");

        txt_Search_sdt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel19.setText("Gender");

        cbb_Search_NhomKH.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cbb_Search_NhomKH.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel20.setText("Customer Type");

        btn_TimKiem_KhachHang.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_TimKiem_KhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search-b-icon.png"))); // NOI18N
        btn_TimKiem_KhachHang.setText("Search");
        btn_TimKiem_KhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TimKiem_KhachHangActionPerformed(evt);
            }
        });

        bg_GioiTinh.add(rbn_SearchNam);
        rbn_SearchNam.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        rbn_SearchNam.setText("Male");

        bg_GioiTinh.add(rbn_SearchNu);
        rbn_SearchNu.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        rbn_SearchNu.setText("Female");

        btn_Search_KH_Clear.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_Search_KH_Clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Actions-edit-clear-icon.png"))); // NOI18N
        btn_Search_KH_Clear.setText("Clear");
        btn_Search_KH_Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Search_KH_ClearActionPerformed(evt);
            }
        });

        lbl_sdt_Search_Hint.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lbl_sdt_Search_Hint.setForeground(new java.awt.Color(204, 0, 0));
        lbl_sdt_Search_Hint.setText(" Not valid field!");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(348, 348, 348)
                                .addComponent(rbn_SearchNam, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rbn_SearchNu, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(216, 216, 216)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbb_Search_NhomKH, 0, 168, Short.MAX_VALUE)))
                        .addContainerGap(13, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_sdt_Search_Hint, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_Search_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_Search_TenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_TimKiem_KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Search_KH_Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Search_TenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbn_SearchNam, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbn_SearchNu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(5, 5, 5)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Search_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(cbb_Search_NhomKH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_sdt_Search_Hint, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Search_KH_Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_TimKiem_KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "Customer List", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N

        tab_KhachHang.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tab_KhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tab_KhachHang.getTableHeader().setReorderingAllowed(false);
        tab_KhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab_KhachHangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tab_KhachHang);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
        );

        btn_ListKH.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_ListKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Actions-view-calendar-list-icon.png"))); // NOI18N
        btn_ListKH.setText("Customer List");
        btn_ListKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ListKHActionPerformed(evt);
            }
        });

        btn_ChonKhachHang.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_ChonKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Accept-icon.png"))); // NOI18N
        btn_ChonKhachHang.setText("Select");
        btn_ChonKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ChonKhachHangActionPerformed(evt);
            }
        });

        btn_refresh_cbb.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_refresh_cbb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/system-software-update-icon.png"))); // NOI18N
        btn_refresh_cbb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refresh_cbbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_refresh_cbb, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 373, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(btn_ListKH, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(btn_ChonKhachHang)
                        .addContainerGap())))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_ListKH)
                    .addComponent(btn_refresh_cbb))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_ChonKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 79, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Customer", jPanel6);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 670));

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Bill", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel9.add(date_ngayBanHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 87, 220, 30));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("BILL OF SALE");
        jPanel9.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 19, 178, 51));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Date");
        jPanel9.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 93, 43, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Sales Staff");
        jPanel9.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 134, 81, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Customer Name:");
        jPanel9.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 170, 116, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Phone Number:");
        jPanel9.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 216, 116, -1));

        lbl_DiaChi.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_DiaChi.setText("...");
        jPanel9.add(lbl_DiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 249, 312, 29));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Address:");
        jPanel9.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 247, 103, 33));

        lbl_TenKhachHang.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_TenKhachHang.setText("...");
        jPanel9.add(lbl_TenKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 164, 154, 29));

        lbl_Sdt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_Sdt.setText("...");
        jPanel9.add(lbl_Sdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 208, 250, 33));

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel21.setText("Payment:");
        jPanel9.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 295, 103, -1));

        txt_HinhThucThanhToan.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel9.add(txt_HinhThucThanhToan, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 289, 420, 30));

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "Product Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N

        tab_ThongTinHangHoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tab_ThongTinHangHoa);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel9.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 334, 570, -1));

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel22.setText("Total:");
        jPanel9.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 550, 46, 33));

        lbl_SoTienPhaiTra.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbl_SoTienPhaiTra.setText("...");
        jPanel9.add(lbl_SoTienPhaiTra, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 552, 95, 29));

        btn_TaoMoiHoaDon.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_TaoMoiHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/note-add-icon.png"))); // NOI18N
        btn_TaoMoiHoaDon.setText("New");
        btn_TaoMoiHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TaoMoiHoaDonActionPerformed(evt);
            }
        });
        jPanel9.add(btn_TaoMoiHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 598, 120, 43));

        btn_ThanhToan.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_ThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Money-icon.png"))); // NOI18N
        btn_ThanhToan.setText("PAY");
        btn_ThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThanhToanActionPerformed(evt);
            }
        });
        jPanel9.add(btn_ThanhToan, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 598, 120, 43));

        btn_BoSanPham.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_BoSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/shop-cart-exclude-icon (1).png"))); // NOI18N
        btn_BoSanPham.setText("Remove");
        btn_BoSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BoSanPhamActionPerformed(evt);
            }
        });
        jPanel9.add(btn_BoSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 546, 161, 43));

        lbl_soLuong_sanPham_Bo_Hint.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lbl_soLuong_sanPham_Bo_Hint.setForeground(new java.awt.Color(204, 51, 0));
        lbl_soLuong_sanPham_Bo_Hint.setText("  Invalid!");
        jPanel9.add(lbl_soLuong_sanPham_Bo_Hint, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 634, 90, 20));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("Quantity*");
        jPanel9.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 598, 65, 25));

        txt_soLuong_SanPhamBo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel9.add(txt_soLuong_SanPhamBo, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 598, 90, 30));

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel23.setText("(VND)");
        jPanel9.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(521, 550, 46, 33));

        lbl_NhanVienBanHang.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_NhanVienBanHang.setText("...");
        jPanel9.add(lbl_NhanVienBanHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 128, 220, 29));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Customer ID:");
        jPanel9.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(397, 170, 96, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("Bill No.:");
        jPanel9.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 25, -1, -1));

        btn_ghiChu.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_ghiChu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Notes-icon (1).png"))); // NOI18N
        btn_ghiChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ghiChuActionPerformed(evt);
            }
        });
        jPanel9.add(btn_ghiChu, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 230, 50, 40));

        lbl_SoHoaDon.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_SoHoaDon.setText("...");
        jPanel9.add(lbl_SoHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 39, 29));

        lbl_MaKhachHang.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_MaKhachHang.setText("...");
        jPanel9.add(lbl_MaKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 164, 70, 29));

        btn_export_2_PDF.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_export_2_PDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/document-filetype-pdf-icon.png"))); // NOI18N
        btn_export_2_PDF.setText("Export");
        btn_export_2_PDF.setEnabled(false);
        btn_export_2_PDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_export_2_PDFActionPerformed(evt);
            }
        });
        jPanel9.add(btn_export_2_PDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 598, 120, 43));

        getContentPane().add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(665, 0, 590, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_TimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TimKiemActionPerformed
        lbl_GiaMin_Hint.setVisible(false);
        lbl_GiaMax_Hint.setVisible(false);
        //spởi tạo lại model, xóa hết cột cũ dòng cũ đi
        tableModel = new DefaultTableModel();
        //tạo cột
        tableModel.addColumn("Product ID");
        tableModel.addColumn("Product Name");
        tableModel.addColumn("Unit");
        tableModel.addColumn("Price (VND)");
        tableModel.addColumn("Available");
        SanPhamDAO sanPhamDAO = new SanPhamDAO();
        //lấy ra thông tin tìm kiếm
        SanPham sp = new SanPham();
        if (txt_Search_TenSanPham.getText().trim().equals("") && cbb_Search_NhaCC.getSelectedItem() == null
                && cbb_Search_LoaiSP.getSelectedItem() == null && txt_Search_GiaMin.getText().trim().equals("")
                && txt_Search_GiaMax.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Enter information into the search box to search !");
            return;
        }
        Integer giaMax = null;
        Integer giaMin = null;

        if (!txt_Search_GiaMin.getText().trim().equals("")) {
            while (true) {
                try {
                    giaMin = (Integer.parseInt(txt_Search_GiaMin.getText().trim()));
                    lbl_GiaMin_Hint.setVisible(false);
                    break;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Informations entered is invalid!! \n"
                            + "Some fields are not allowed to contain letters or special characters");
                    lbl_GiaMin_Hint.setVisible(true);
                    return;
                }
            }
        }

        if (!txt_Search_GiaMax.getText().trim().equals("")) {
            while (true) {
                try {
                    giaMax = (Integer.parseInt(txt_Search_GiaMax.getText().trim()));
                    lbl_GiaMax_Hint.setVisible(false);
                    break;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Informations entered is invalid!! \n"
                            + "Some fields are not allowed to contain letters or special characters");
                    lbl_GiaMax_Hint.setVisible(true);
                    return;
                }
            }
        }
        sp.setTenSanPham(txt_Search_TenSanPham.getText().trim());
        NhaCungCap ncc = (NhaCungCap) cbb_Search_NhaCC.getSelectedItem();
        sp.setMaNhaCC(ncc != null ? ncc.getMaNhaCC() : null);
        LoaiSanPham lsp = (LoaiSanPham) cbb_Search_LoaiSP.getSelectedItem();
        sp.setMaLoaiSP(lsp != null ? lsp.getMaLoaiSP() : null);
        List<SanPham> sanPhamList = sanPhamDAO.search(sp, giaMax, giaMin);
        for (SanPham sanPham : sanPhamList) {
            Vector vector = new Vector();
            vector.add(sanPham.getMaSanPham());
            vector.add(sanPham.getTenSanPham());
            vector.add(sanPham.getDonViTinh());
            vector.add(df.format(sanPham.getDonGia()));
            vector.add(sanPhamDAO.getSoLuongConLai(sanPham.getMaSanPham()));
            //tạo hàng
            tableModel.addRow(vector);
        }
        //đưa dữ liệu từ model vào bảng
        tab_SanPham.setModel(tableModel);
    }//GEN-LAST:event_btn_TimKiemActionPerformed

    private void btn_Search_ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Search_ClearActionPerformed
        // TODO add your handling code here:
        xoaTrangSanPham();

    }//GEN-LAST:event_btn_Search_ClearActionPerformed

    public void xoaTrangSanPham() {
        txt_Search_TenSanPham.setText("");
        txt_Search_GiaMax.setText("");
        txt_Search_GiaMin.setText("");
        cbb_Search_NhaCC.setSelectedItem(null);
        cbb_Search_LoaiSP.setSelectedItem(null);
        lbl_GiaMin_Hint.setVisible(false);
        lbl_GiaMax_Hint.setVisible(false);
        txt_SoLuong_SanPhamMua.setText("");
        lbl_SoLuong_SanPham_Hint.setVisible(false);
        tab_SanPham.clearSelection();
    }
    private void tab_SanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_SanPhamMouseClicked
    }//GEN-LAST:event_tab_SanPhamMouseClicked

    private void btn_List_SanPHamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_List_SanPHamActionPerformed
        loadDataIntoTaBle_SanPham();
    }//GEN-LAST:event_btn_List_SanPHamActionPerformed

    private void btn_ThemVaoGioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemVaoGioActionPerformed
        //Kiểm tra sản phẩm đc chọn đủ hợp lệ
        if (!lbl_SoHoaDon.getText().trim().equals("...")) {
            JOptionPane.showMessageDialog(this, "Create new Bill!");
            return;
        }
        lbl_GiaMax_Hint.setVisible(false);
        lbl_GiaMin_Hint.setVisible(false);
        int row = tab_SanPham.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Sellect product!!");
            return;
        }
        Integer soLuongMua = 0;
        if (txt_SoLuong_SanPhamMua.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter number of product!");
            lbl_SoLuong_SanPham_Hint.setVisible(false);
            return;
        }
        while (true) {
            try {
                soLuongMua = Integer.parseInt(txt_SoLuong_SanPhamMua.getText().trim());
                lbl_SoLuong_SanPham_Hint.setVisible(false);
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid!! \n"
                        + "Some fields are not allowed to contain letters or special characters");
                lbl_SoLuong_SanPham_Hint.setVisible(true);
                return;
            }
        }
        Integer soLuongConLai = (Integer) tab_SanPham.getValueAt(row, 4);
        if (soLuongMua > soLuongConLai) {
            if (soLuongConLai == 0) {
                JOptionPane.showMessageDialog(this, "Out of stock!!");
            } else {
                JOptionPane.showMessageDialog(this, "Not Enough! \n Only " + soLuongConLai + " available!!");
            }
            return;
        }
        if (soLuongMua <= 0) {
            JOptionPane.showMessageDialog(this, "Invalid!!");
            lbl_SoLuong_SanPham_Hint.setVisible(true);
            return;
        }

        //thêm vài giở hàng
        String maSP = (String) tab_SanPham.getValueAt(row, 0);
        String tenSP = (String) tab_SanPham.getValueAt(row, 1);
        String donViTinh = (String) tab_SanPham.getValueAt(row, 2);
        String donGia = (String) (tab_SanPham.getValueAt(row, 3));
        SanPham sp = new SanPham();
        sp.setMaSanPham(maSP);
        sp.setTenSanPham(tenSP);
        sp.setDonViTinh(donViTinh);
        sp.setDonGia(Integer.parseInt(donGia.trim().replaceAll(",", "")));

        loadDataIntoTaBle_ThongTinHangHoa(sp, soLuongMua);
        Integer tongTien = 0;
        for (int i = 0; i < tm.getRowCount(); i++) {
            Integer thanhTien = Integer.parseInt(((String) tm.getValueAt(i, 5)).trim().replaceAll(",", ""));
            tongTien += thanhTien;
        }
        lbl_SoTienPhaiTra.setText(df.format(tongTien));
        updateDataInTable_SanPham(sp, soLuongMua);
        tab_SanPham.clearSelection();
    }//GEN-LAST:event_btn_ThemVaoGioActionPerformed

    private void btn_TimKiem_KhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TimKiem_KhachHangActionPerformed
        xoaTrangSanPham();
        //khởi tạo lại model, xóa hết cột cũ dòng cũ đi
        tableModel = new DefaultTableModel();
        //tạo cột
        tableModel.addColumn("Customer ID");
        tableModel.addColumn("Customer Name");
        tableModel.addColumn("Gender");
        tableModel.addColumn("Phone Number");
        tableModel.addColumn("Address");
        tableModel.addColumn("Bonus Score");
        KhachHangDAO khachHangDAO = new KhachHangDAO();
        //lấy ra thông tin tìm kiếm
        KhachHang kh = new KhachHang();
        if (txt_Search_TenKH.getText().trim().equals("") && rbn_SearchNam.isSelected() == false
                && rbn_SearchNu.isSelected() == false && cbb_Search_NhomKH.getSelectedItem() == null
                && txt_Search_sdt.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Enter information into the search box to search !");
            lbl_sdt_Search_Hint.setVisible(false);
            return;
        }
        if (!txt_Search_sdt.getText().trim().equals("")) {
            while (true) {
                try {
                    kh.setSdt(Integer.parseInt(txt_Search_sdt.getText().trim()));
                    lbl_sdt_Search_Hint.setVisible(false);
                    break;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Informations entered is invalid!! \n"
                            + "Some fields are not allowed to contain letters or special characters");
                    lbl_sdt_Search_Hint.setVisible(true);
                    return;
                }
            }
        }
        kh.setHoTenKH(txt_Search_TenKH.getText().trim());
        if (rbn_SearchNam.isSelected()) {
            kh.setGioiTinh("Nam");
        }
        if (rbn_SearchNu.isSelected()) {
            kh.setGioiTinh("Nữ");
        }
        NhomKhachHang nkh = (NhomKhachHang) cbb_Search_NhomKH.getSelectedItem();
        kh.setMaNhomKH(nkh != null ? nkh.getMaNhomKH() : null);
        List<KhachHang> khachHangList = khachHangDAO.search(kh);
        for (KhachHang khachHang : khachHangList) {
            Vector vector = new Vector();
            vector.add(khachHang.getMaKH());
            vector.add(khachHang.getHoTenKH());
            vector.add(khachHang.getGioiTinh().equals("Nam") ? "Nam" : "Nữ");
            vector.add(khachHang.getSdt());
            vector.add(khachHang.getDiachi());
            vector.add(khachHang.getDiemTichLuy());
            //tạo hàng
            tableModel.addRow(vector);
        }
        //đưa dữ liệu từ model vào bảng
        tab_KhachHang.setModel(tableModel);
        lbl_sdt_Search_Hint.setVisible(false);
    }//GEN-LAST:event_btn_TimKiem_KhachHangActionPerformed

    private void btn_Search_KH_ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Search_KH_ClearActionPerformed
        // TODO add your handling code here:
        xoaTrang_KhachHang();
    }//GEN-LAST:event_btn_Search_KH_ClearActionPerformed

    public void xoaTrang_KhachHang() {
        txt_Search_TenKH.setText("");
        txt_Search_sdt.setText("");
        lbl_sdt_Search_Hint.setVisible(false);
        bg_GioiTinh.clearSelection();
        cbb_Search_NhomKH.setSelectedItem(null);
        tab_KhachHang.clearSelection();
    }
    private void tab_KhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_KhachHangMouseClicked

    }//GEN-LAST:event_tab_KhachHangMouseClicked

    private void btn_ListKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ListKHActionPerformed
        try {
            loadDataIntoTaBle_KhachHang();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Form_MuaHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Form_MuaHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_ListKHActionPerformed

    private void btn_ChonKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ChonKhachHangActionPerformed
        // TODO add your handling code here:
        if (!lbl_SoHoaDon.getText().trim().equals("...")) {
            JOptionPane.showMessageDialog(this, "Create new Bill!");
            return;
        }
        lbl_sdt_Search_Hint.setVisible(false);
        int row = tab_KhachHang.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Sellect customer!!");
            return;
        }
        String maKhachHang = (String) tab_KhachHang.getValueAt(row, 0);
        String tenKH = (String) tab_KhachHang.getValueAt(row, 1);
        Integer sdt = (Integer) tab_KhachHang.getValueAt(row, 3);
        String diaChi = (String) tab_KhachHang.getValueAt(row, 4);
        lbl_MaKhachHang.setText(maKhachHang.trim());
        lbl_TenKhachHang.setText(tenKH);
        lbl_Sdt.setText(sdt.toString());
        lbl_DiaChi.setText(diaChi);
        tab_KhachHang.clearSelection();
    }//GEN-LAST:event_btn_ChonKhachHangActionPerformed

    private void btn_TaoMoiHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TaoMoiHoaDonActionPerformed
        try {
            // TODO add your handling code here:
            date_ngayBanHang.setDate(new Date());
            lbl_SoHoaDon.setText("...");
            lbl_TenKhachHang.setText("...");
            lbl_MaKhachHang.setText("...");
            lbl_Sdt.setText("...");
            lbl_DiaChi.setText("...");
            txt_HinhThucThanhToan.setText("");
            tab_ThongTinHangHoa.setModel(new DefaultTableModel());
            lbl_SoTienPhaiTra.setText("...");
            txt_soLuong_SanPhamBo.setText("");
            lbl_soLuong_sanPham_Bo_Hint.setVisible(false);
            setGhiChu("");
            xoaTrangSanPham();
            xoaTrang_KhachHang();
            loadDataIntoTaBle_KhachHang();
            loadDataIntoTaBle_SanPham();
            tm.setRowCount(0);
            btn_export_2_PDF.setEnabled(false);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Form_MuaHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Form_MuaHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_TaoMoiHoaDonActionPerformed

    private void btn_ThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThanhToanActionPerformed
        try {
            if (!lbl_SoHoaDon.getText().trim().equals("...")) {
                JOptionPane.showMessageDialog(this, "Create new Bill!");
                return;
            }
            // TODO add your handling code here:
            String textOnJDateChooser = ((JTextField) date_ngayBanHang.getDateEditor().getUiComponent()).getText();
            if (lbl_MaKhachHang.getText().isEmpty() || tab_ThongTinHangHoa.getRowCount() < 0
                    || txt_HinhThucThanhToan.getText().trim().isEmpty() || textOnJDateChooser.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Fill in all fields, except Bill No.!!");
                return;
            }
            if (date_ngayBanHang.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Invalid!! Choose the Date");
                return;
            }
            //Cập nhập vào bảng Hóa Đơn
            HoaDon hd = new HoaDon();
            hd.setNgayLapHoaDon(Convert.convertDate(date_ngayBanHang.getDate()));
            hd.setMaKhachHang(lbl_MaKhachHang.getText().trim());
            hd.setHinhThucThanhToan(txt_HinhThucThanhToan.getText().trim());
            hd.setTongTien(Integer.parseInt(lbl_SoTienPhaiTra.getText().trim().replaceAll(",", "")));
            hd.setGhiChu(ghiChu);
            hd.setMaNhanVien(nhanVien.getMaNhanVien());
            Integer soHoaDon = (new HoaDonDAO()).insert(hd);
            //Cập nhật bảng Chi Tiết Hóa Đơn
            capNhatChiTietHoaDon(soHoaDon);
            //Cập nhật lại tồn kho
            capNhapTonKho();
            lbl_SoHoaDon.setText(soHoaDon.toString());
            tab_ThongTinHangHoa.clearSelection();
            JOptionPane.showMessageDialog(this, "Successfully");
            btn_export_2_PDF.setEnabled(true);
        } catch (SQLException ex) {
            Logger.getLogger(Form_MuaHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_ThanhToanActionPerformed

    private void btn_BoSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BoSanPhamActionPerformed
        // TODO add your handling code here:
        if (!lbl_SoHoaDon.getText().trim().equals("...")) {
            JOptionPane.showMessageDialog(this, "Create new Bill!");
            return;
        }
        int row = tab_ThongTinHangHoa.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Sellect product!!");
            return;
        }
        Integer soLuongBo = 0;
        if (txt_soLuong_SanPhamBo.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter remove number of product!");
            lbl_soLuong_sanPham_Bo_Hint.setVisible(false);
            return;
        }
        while (true) {
            try {
                soLuongBo = Integer.parseInt(txt_soLuong_SanPhamBo.getText().trim());
                lbl_soLuong_sanPham_Bo_Hint.setVisible(false);
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid!! \n"
                        + "Some fields are not allowed to contain letters or special characters");
                lbl_soLuong_sanPham_Bo_Hint.setVisible(true);
                return;
            }
        }

        if (soLuongBo <= 0) {
            JOptionPane.showMessageDialog(this, "Invalid!!");
            lbl_soLuong_sanPham_Bo_Hint.setVisible(true);
            return;
        }
        Integer soLuongMua = 0;
        soLuongMua = (Integer) tab_ThongTinHangHoa.getValueAt(row, 4);
        if (soLuongBo > soLuongMua) {
            JOptionPane.showMessageDialog(this, "Invalid!! Out of number of products purchased");
            return;
        }
        //lấy ra sp đc chọn
        String maSanPham = (String) tab_ThongTinHangHoa.getValueAt(row, 0);
        SanPham sp = (new SanPhamDAO()).getSanPhamByID(maSanPham.trim());
        //bỏ luôn sp
        if (soLuongBo == soLuongMua) {
            ((DefaultTableModel) tab_ThongTinHangHoa.getModel()).removeRow(row);
            updateDataInTable_SanPham(sp, -soLuongBo);
        } else {
            //giảm số lượng sp
            tab_ThongTinHangHoa.setValueAt(soLuongMua - soLuongBo, row, 4);
            tab_ThongTinHangHoa.setValueAt(df.format((soLuongMua - soLuongBo) * sp.getDonGia()), row, 5);
            updateDataInTable_SanPham(sp, -soLuongBo);
        }
        //tính lại tổng tiền
        Integer tongTien = 0;
        for (int i = 0; i < tm.getRowCount(); i++) {
            Integer thanhTien = Integer.parseInt(((String) tm.getValueAt(i, 5)).trim().replaceAll(",", ""));
            tongTien += thanhTien;
        }
        lbl_SoTienPhaiTra.setText(df.format(tongTien));
        txt_soLuong_SanPhamBo.setText("");
        tab_ThongTinHangHoa.clearSelection();
    }//GEN-LAST:event_btn_BoSanPhamActionPerformed

    private void btn_ghiChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ghiChuActionPerformed
        // TODO add your handling code here:
        if (!lbl_SoHoaDon.getText().trim().equals("...")) {
            JOptionPane.showMessageDialog(this, "Create new Bill!");
            return;
        }
        NoteForm noteForm = new NoteForm(this, ghiChu);
        noteForm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        noteForm.setLocationRelativeTo(null);
        noteForm.setVisible(true);
    }//GEN-LAST:event_btn_ghiChuActionPerformed

    private void btn_refresh_cbbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refresh_cbbActionPerformed
        // TODO add your handling code here:
        Object obj1 = cbb_Search_LoaiSP.getSelectedItem();
        Object obj2 = cbb_Search_NhaCC.getSelectedItem();
        Object obj3 = cbb_Search_NhomKH.getSelectedItem();
        loadCombobox_LoaiSP_Search();
        loadCombobox_NhaCungCap_Search();
        loadCombobox_NhomKhachHang_Search();
        cbb_Search_LoaiSP.setSelectedItem(obj1);
        cbb_Search_NhaCC.setSelectedItem(obj2);
        cbb_Search_NhomKH.setSelectedItem(obj3);
    }//GEN-LAST:event_btn_refresh_cbbActionPerformed

    private void btn_refresh_cbb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refresh_cbb1ActionPerformed
        // TODO add your handling code here:
        Object obj1 = cbb_Search_LoaiSP.getSelectedItem();
        Object obj2 = cbb_Search_NhaCC.getSelectedItem();
        Object obj3 = cbb_Search_NhomKH.getSelectedItem();
        loadCombobox_LoaiSP_Search();
        loadCombobox_NhaCungCap_Search();
        loadCombobox_NhomKhachHang_Search();
        cbb_Search_LoaiSP.setSelectedItem(obj1);
        cbb_Search_NhaCC.setSelectedItem(obj2);
        cbb_Search_NhomKH.setSelectedItem(obj3);
    }//GEN-LAST:event_btn_refresh_cbb1ActionPerformed

    Boolean done = false;
    private void btn_export_2_PDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_export_2_PDFActionPerformed
        // TODO add your handling code here:
        if (done) {
            JOptionPane.showMessageDialog(this, "This bill already created!", "Meessage",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setApproveButtonText("Save");

            ArrayList<String> specialChars = new ArrayList();
            specialChars.addAll(Arrays.asList(">", "<", "|", "?", "*", "/", "\\", "\""));
            String path;
            int res = (fileChooser.showOpenDialog(this));
            if (res == JFileChooser.APPROVE_OPTION) {
                path = fileChooser.getSelectedFile().toString();
                String fileName = fileChooser.getSelectedFile().getName();
                System.out.println(path);
                System.out.println(fileName);
                for (String character : specialChars) {
                    if (fileName.contains(character)) {
                        JOptionPane.showMessageDialog(this, "Invalid file name or this file already exist!",
                                "Export Failed!", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }
                path += ".pdf";
                Integer soHoaDon = Integer.parseInt(lbl_SoHoaDon.getText());
                // create bill
                new pdf_Export().billExportToPDF(soHoaDon, path);
                JOptionPane.showMessageDialog(this, "Bill successfully generated!",
                        "Done", JOptionPane.INFORMATION_MESSAGE);
            }
            done = true;
        }

    }//GEN-LAST:event_btn_export_2_PDFActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form_MuaHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_MuaHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_MuaHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_MuaHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_MuaHang().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bg_GioiTinh;
    private javax.swing.JButton btn_BoSanPham;
    private javax.swing.JButton btn_ChonKhachHang;
    private javax.swing.JButton btn_ListKH;
    private javax.swing.JButton btn_List_SanPHam;
    private javax.swing.JButton btn_Search_Clear;
    private javax.swing.JButton btn_Search_KH_Clear;
    private javax.swing.JButton btn_TaoMoiHoaDon;
    private javax.swing.JButton btn_ThanhToan;
    private javax.swing.JButton btn_ThemVaoGio;
    private javax.swing.JButton btn_TimKiem;
    private javax.swing.JButton btn_TimKiem_KhachHang;
    private javax.swing.JButton btn_export_2_PDF;
    private javax.swing.JButton btn_ghiChu;
    private javax.swing.JButton btn_refresh_cbb;
    private javax.swing.JButton btn_refresh_cbb1;
    private javax.swing.JComboBox cbb_Search_LoaiSP;
    private javax.swing.JComboBox cbb_Search_NhaCC;
    private javax.swing.JComboBox cbb_Search_NhomKH;
    private com.toedter.calendar.JDateChooser date_ngayBanHang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbl_DiaChi;
    private javax.swing.JLabel lbl_GiaMax_Hint;
    private javax.swing.JLabel lbl_GiaMin_Hint;
    private javax.swing.JLabel lbl_MaKhachHang;
    private javax.swing.JLabel lbl_NhanVienBanHang;
    private javax.swing.JLabel lbl_Sdt;
    private javax.swing.JLabel lbl_SoHoaDon;
    private javax.swing.JLabel lbl_SoLuong_SanPham_Hint;
    private javax.swing.JLabel lbl_SoTienPhaiTra;
    private javax.swing.JLabel lbl_TenKhachHang;
    private javax.swing.JLabel lbl_sdt_Search_Hint;
    private javax.swing.JLabel lbl_soLuong_sanPham_Bo_Hint;
    private javax.swing.JRadioButton rbn_SearchNam;
    private javax.swing.JRadioButton rbn_SearchNu;
    private javax.swing.JTable tab_KhachHang;
    private javax.swing.JTable tab_SanPham;
    private javax.swing.JTable tab_ThongTinHangHoa;
    private javax.swing.JTextField txt_HinhThucThanhToan;
    private javax.swing.JTextField txt_Search_GiaMax;
    private javax.swing.JTextField txt_Search_GiaMin;
    private javax.swing.JTextField txt_Search_TenKH;
    private javax.swing.JTextField txt_Search_TenSanPham;
    private javax.swing.JTextField txt_Search_sdt;
    private javax.swing.JTextField txt_SoLuong_SanPhamMua;
    private javax.swing.JTextField txt_soLuong_SanPhamBo;
    // End of variables declaration//GEN-END:variables

    private void loadDataIntoTaBle_SanPham() {
        //spởi tạo lại model, xóa hết cột cũ dòng cũ đi
        tableModel = new DefaultTableModel();
        //tạo cột
        tableModel.addColumn("Product ID");
        tableModel.addColumn("Product Name");
        tableModel.addColumn("Unit");
        tableModel.addColumn("Price (VND)");
        tableModel.addColumn("Available");
        SanPhamDAO sanPhamDAO = new SanPhamDAO();
        //lấy ra toàn bộ vai trò
        List<SanPham> spList = sanPhamDAO.selectAll();
        for (SanPham sp : spList) {
            Vector vector = new Vector();
            vector.add(sp.getMaSanPham());
            vector.add(sp.getTenSanPham());
            vector.add(sp.getDonViTinh());
            vector.add(df.format(sp.getDonGia()));
            vector.add(sanPhamDAO.getSoLuongConLai(sp.getMaSanPham()));
            //tạo hàng
            tableModel.addRow(vector);
        }
        //đưa dữ liệu từ model vào bảng
        tab_SanPham.setModel(tableModel);
    }

    private void loadDataIntoTaBle_ThongTinHangHoa(SanPham sp, Integer soLuongMua) {
        //check
        List<String> listMaSanPham = new ArrayList<>();
        for (int i = 0; i < tm.getRowCount(); i++) {
            listMaSanPham.add(((String) tm.getValueAt(i, 0)).trim());
        }
        if (listMaSanPham.contains(sp.getMaSanPham().trim())) {
            int dong = listMaSanPham.indexOf(sp.getMaSanPham().trim());
            Integer soLuongDaCo = (Integer) tm.getValueAt(dong, 4);
            tm.setValueAt(soLuongDaCo + soLuongMua, dong, 4);
            tm.setValueAt(df.format((soLuongDaCo + soLuongMua) * sp.getDonGia()), dong, 5);
        } else {
            Vector vector = new Vector();
            vector.add(sp.getMaSanPham());
            vector.add(sp.getTenSanPham());
            vector.add(sp.getDonViTinh());
            vector.add(df.format(sp.getDonGia()));
            vector.add(soLuongMua);
            vector.add(df.format(sp.getDonGia() * soLuongMua));
            //tạo hàng
            tm.addRow(vector);
            //đưa dữ liệu từ model vào bảng
            tab_ThongTinHangHoa.setModel(tm);
        }
    }

    private void loadDataIntoTaBle_KhachHang() throws ClassNotFoundException, SQLException {
        //khởi tạo lại model, xóa hết cột cũ dòng cũ đi
        tableModel = new DefaultTableModel();
        //tạo cột
        tableModel.addColumn("Customer ID");
        tableModel.addColumn("Customer Name");
        tableModel.addColumn("Gender");
        tableModel.addColumn("Phone Number");
        tableModel.addColumn("Address");
        tableModel.addColumn("Bonus Score");
        KhachHangDAO khachHangDAO = new KhachHangDAO();
        //lấy ra toàn bộ vai trò
        List<KhachHang> khachHangList = khachHangDAO.selectAll();
        for (KhachHang kh : khachHangList) {
            Vector vector = new Vector();
            vector.add(kh.getMaKH());
            vector.add(kh.getHoTenKH());
            vector.add(kh.getGioiTinh().equals("Nam") ? "Nam" : "Nữ");
            vector.add(kh.getSdt());
            vector.add(kh.getDiachi());
            vector.add(kh.getDiemTichLuy());
            //tạo hàng
            tableModel.addRow(vector);
        }
        //đưa dữ liệu từ model vào bảng
        tab_KhachHang.setModel(tableModel);
    }

    private void loadCombobox_NhomKhachHang_Search() {
        NhomKhachHangDAO nhomKhachHangDAO = new NhomKhachHangDAO();
        //lấy toàn bộ bảng nhà cung cấp
        List<NhomKhachHang> NccList = nhomKhachHangDAO.selectAll();
        Vector v = new Vector(NccList);
        //khởi tạo dữ liệu cho combobox
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel(v);
        cbb_Search_NhomKH.setModel(dcbm);
        //giúp tạo combobox hiển thị tên vai trò
        cbb_Search_NhomKH.setRenderer(new ListCellRenderer() {
            DefaultListCellRenderer dlcr = new DefaultListCellRenderer();

            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                // gọi method giống hệt method cần viết, truyền vào tham số y như nguyên
                JLabel label = (JLabel) dlcr.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value != null) {
                    label.setText(((NhomKhachHang) value).getTenNhomKH());
                }
                return label;
            }
        });
    }

    private void loadCombobox_NhaCungCap_Search() {
        NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAO();
        //lấy toàn bộ bảng nhà cung cấp
        List<NhaCungCap> NccList = nhaCungCapDAO.selectAll();
        Vector v = new Vector(NccList);
        //spởi tạo dữ liệu cho combobox
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel(v);
        cbb_Search_NhaCC.setModel(dcbm);
        //giúp tạo combobox hiển thị tên vai trò
        cbb_Search_NhaCC.setRenderer(new ListCellRenderer() {
            DefaultListCellRenderer dlcr = new DefaultListCellRenderer();

            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                // gọi method giống hệt method cần viết, truyền vào tham số y như nguyên
                JLabel label = (JLabel) dlcr.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value != null) {
                    label.setText(((NhaCungCap) value).getTenNhaCC());
                }
                return label;
            }
        });
    }

    private void loadCombobox_LoaiSP_Search() {
        LoaiSanPhamDAO loaiSP_DAO = new LoaiSanPhamDAO();
        //lấy toàn bộ bảng nhà cung cấp
        List<LoaiSanPham> NccList = loaiSP_DAO.selectAll();
        Vector v = new Vector(NccList);
        //spởi tạo dữ liệu cho combobox
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel(v);
        cbb_Search_LoaiSP.setModel(dcbm);
        //giúp tạo combobox hiển thị tên vai trò
        cbb_Search_LoaiSP.setRenderer(new ListCellRenderer() {
            DefaultListCellRenderer dlcr = new DefaultListCellRenderer();

            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                // gọi method giống hệt method cần viết, truyền vào tham số y như nguyên
                JLabel label = (JLabel) dlcr.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value != null) {
                    label.setText(((LoaiSanPham) value).getTenLoaiSP());
                }
                return label;
            }
        });
    }

    private void updateDataInTable_SanPham(SanPham sp, Integer soLuongMua) {
        List<String> listMaSanPham = (new SanPhamDAO()).getListMaSanPham();
        Integer row = listMaSanPham.indexOf(sp.getMaSanPham().trim());
        Integer soLuongCu = (Integer) tab_SanPham.getValueAt(row, 4);
        tab_SanPham.setValueAt(soLuongCu - soLuongMua, row, 4);
    }

    private void capNhatChiTietHoaDon(Integer soHoaDon) {
        ChiTietHoaDon cthd = new ChiTietHoaDon();
        cthd.setSoHoaDon(soHoaDon);
        cthd.setMaSanPham(ghiChu);
        for (int i = 0; i < tab_ThongTinHangHoa.getRowCount(); i++) {
            cthd.setMaSanPham((String) tab_ThongTinHangHoa.getValueAt(i, 0));
            cthd.setSoLuong((Integer) tab_ThongTinHangHoa.getValueAt(i, 4));
            cthd.setThanhTien(Integer.parseInt(((String) tab_ThongTinHangHoa.getValueAt(i, 5)).trim().replaceAll(",", "")));
            (new ChiTietHoaDonDAO()).insert(cthd);
        }
    }

    private void capNhapTonKho() {
        for (int i = 0; i < tab_ThongTinHangHoa.getRowCount(); i++) {
            String maSanPham = (String) tab_ThongTinHangHoa.getValueAt(i, 0);
            Integer soLuong = (Integer) tab_ThongTinHangHoa.getValueAt(i, 4);
            (new TonKhoDAO()).update(maSanPham.trim(), soLuong);
        }
    }
}
