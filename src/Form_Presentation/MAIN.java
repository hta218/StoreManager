/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form_Presentation;

import DatabaseAccessObject_DAO.NhanVienDAO;
import Object_BusinessLogic.NhanVien;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Huynh
 */
public class MAIN extends javax.swing.JFrame {

    NhanVien nhanVien;
    GridBagLayout layout = new GridBagLayout();
    Form_MuaHang form_MuaHang;
    FormKhachHang formKhachHang;
    FormKho formKho;
    FormLoaiSanPham formLoaiSanPham;
    FormNhaCungCap formNhaCungCap;
    FormNhanVien formNhanVien;
    FormNhomKhachHang formNhomKhachHang;
    FormSanPham formSanPham;
    Form_BaoCao form_BaoCao;
    FormVaiTro formVaiTro;
    Container ct_FormMuaHang;
    Container ct_FormKhachHang;
    Container ct_FormKho;
    Container ct_FormLoaiSanPham;
    Container ct_FormNhanVien;
    Container ct_FormNhaCungCap;
    Container ct_FormNhomKhachHang;
    Container ct_FormVaiTro;
    Container ct_FormSanPham;
    Container ct_FormBaoCao;

    /**
     * Creates new form MAIN
     */
    public MAIN(NhanVien nv) {
        try {
            this.nhanVien = nv;
            initComponents();
            this.setTitle("Main");
            switch (nv.getMaVaiTro()) {
                case 0:
                    break;
                case 1:
                    hideAllButton();
                    btn_NhanVien.setEnabled(true);
                    btn_VaiTro.setEnabled(true);
                    btn_BaoCao.setEnabled(true);
                    break;
                case 2:
                    hideAllButton();
                    btn_HoaDon.setEnabled(true);
                    btn_KhachHang.setEnabled(true);
                    btn_NhomKH.setEnabled(true);
                    break;
                case 3:
                    hideAllButton();
                    btn_Kho.setEnabled(true);
                    btn_NhaCungCap.setEnabled(true);
                    btn_SanPham.setEnabled(true);
                    btn_LoaiSanPham.setEnabled(true);
                    break;
                default:
                    hideAllButton();
                    break;
            }
            loadInfoNV(nv);
            // thêm form mua hàng   1
            ct_FormMuaHang = new Container();
            form_MuaHang = new Form_MuaHang(nv);
            mainPanel.setLayout(layout);
            GridBagConstraints gc = new GridBagConstraints();
            gc.gridx = 0;
            gc.gridy = 0;
            ct_FormMuaHang = form_MuaHang.getContentPane();
            ct_FormMuaHang.setVisible(false);
            mainPanel.add(ct_FormMuaHang, gc);
            //thêm form khách hàng  2
            ct_FormKhachHang = new Container();
            formKhachHang = new FormKhachHang();
            mainPanel.setLayout(layout);
            gc.gridx = 0;
            gc.gridy = 0;
            ct_FormKhachHang = formKhachHang.getContentPane();
            ct_FormKhachHang.setVisible(false);
            mainPanel.add(ct_FormKhachHang);
            //thêm form kho 3
            ct_FormKho = new Container();
            formKho = new FormKho();
            mainPanel.setLayout(layout);
            gc.gridx = 0;
            gc.gridy = 0;
            ct_FormKho = formKho.getContentPane();
            ct_FormKho.setVisible(false);
            mainPanel.add(ct_FormKho);
            //thêm form loại sp 4
            ct_FormLoaiSanPham = new Container();
            formLoaiSanPham = new FormLoaiSanPham();
            mainPanel.setLayout(layout);
            gc.gridx = 0;
            gc.gridy = 0;
            ct_FormLoaiSanPham = formLoaiSanPham.getContentPane();
            ct_FormLoaiSanPham.setVisible(false);
            mainPanel.add(ct_FormLoaiSanPham);
            //thêm form nhà cung cấp    5
            ct_FormNhaCungCap = new Container();
            formNhaCungCap = new FormNhaCungCap();
            mainPanel.setLayout(layout);
            gc.gridx = 0;
            gc.gridy = 0;
            ct_FormNhaCungCap = formNhaCungCap.getContentPane();
            ct_FormNhaCungCap.setVisible(false);
            mainPanel.add(ct_FormNhaCungCap);
            //thêm form nhân viên   6
            ct_FormNhanVien = new Container();
            formNhanVien = new FormNhanVien();
            mainPanel.setLayout(layout);
            gc.gridx = 0;
            gc.gridy = 0;
            ct_FormNhanVien = formNhanVien.getContentPane();
            ct_FormNhanVien.setVisible(false);
            mainPanel.add(ct_FormNhanVien);
            //thêm form nhóm khách hàng 7
            ct_FormNhomKhachHang = new Container();
            formNhomKhachHang = new FormNhomKhachHang();
            mainPanel.setLayout(layout);
            gc.gridx = 0;
            gc.gridy = 0;
            ct_FormNhomKhachHang = formNhomKhachHang.getContentPane();
            ct_FormNhomKhachHang.setVisible(false);
            mainPanel.add(ct_FormNhomKhachHang);
            //thêm form sản phẩm    8
            ct_FormSanPham = new Container();
            formSanPham = new FormSanPham();
            mainPanel.setLayout(layout);
            gc.gridx = 0;
            gc.gridy = 0;
            ct_FormSanPham = formSanPham.getContentPane();
            ct_FormSanPham.setVisible(false);
            mainPanel.add(ct_FormSanPham);
            //thêm form vai trò 9
            ct_FormVaiTro = new Container();
            formVaiTro = new FormVaiTro();
            mainPanel.setLayout(layout);
            gc.gridx = 0;
            gc.gridy = 0;
            ct_FormVaiTro = formVaiTro.getContentPane();
            ct_FormVaiTro.setVisible(false);
            mainPanel.add(ct_FormVaiTro);
            //thêm form báo cáo 10
            ct_FormBaoCao = new Container();
            form_BaoCao = new Form_BaoCao();
            mainPanel.setLayout(layout);
            gc.gridx = 0;
            gc.gridy = 0;
            ct_FormBaoCao = form_BaoCao.getContentPane();
            ct_FormBaoCao.setVisible(false);
            mainPanel.add(ct_FormBaoCao);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadInfoNV(NhanVien nv) {
        lbl_TenNhanVien.setText(nv.getHoTenNhanVien());
        lbl_maNhanVien.setText(nv.getMaNhanVien());
        lbl_sdt.setText(nv.getSdt().toString());
        lbl_tenVaiTro.setText(nv.getTenVaiTro());
    }

    public void addAllForm() {
        ct_FormMuaHang = new Container();
        form_MuaHang = new Form_MuaHang();
    }

    public void clearMainPanel() {
        ct_FormKhachHang.setVisible(false);
        ct_FormMuaHang.setVisible(false);
        ct_FormKho.setVisible(false);
        ct_FormLoaiSanPham.setVisible(false);
        ct_FormNhaCungCap.setVisible(false);
        ct_FormNhanVien.setVisible(false);
        ct_FormNhomKhachHang.setVisible(false);
        ct_FormVaiTro.setVisible(false);
        ct_FormSanPham.setVisible(false);
        ct_FormBaoCao.setVisible(false);
    }

    public void hideAllButton() {
        btn_HoaDon.setEnabled(false);
        btn_KhachHang.setEnabled(false);
        btn_Kho.setEnabled(false);
        btn_LoaiSanPham.setEnabled(false);
        btn_NhaCungCap.setEnabled(false);
        btn_NhanVien.setEnabled(false);
        btn_NhomKH.setEnabled(false);
        btn_SanPham.setEnabled(false);
        btn_VaiTro.setEnabled(false);
        btn_BaoCao.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_TenNhanVien = new javax.swing.JLabel();
        lbl_sdt = new javax.swing.JLabel();
        lbl_maNhanVien = new javax.swing.JLabel();
        lbl_tenVaiTro = new javax.swing.JLabel();
        btn_DangXuat = new javax.swing.JButton();
        btn_Thoat = new javax.swing.JButton();
        btn_CapNhatInFo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btn_HoaDon = new javax.swing.JButton();
        btn_KhachHang = new javax.swing.JButton();
        btn_NhomKH = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btn_Kho = new javax.swing.JButton();
        btn_NhaCungCap = new javax.swing.JButton();
        btn_SanPham = new javax.swing.JButton();
        btn_LoaiSanPham = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btn_NhanVien = new javax.swing.JButton();
        btn_VaiTro = new javax.swing.JButton();
        btn_BaoCao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "User", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Staff: ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 32, 55, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("ID:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 32, 43, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Position:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 32, 72, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Phone Number:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 32, 110, -1));

        lbl_TenNhanVien.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_TenNhanVien.setText("...");
        jPanel1.add(lbl_TenNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 32, 131, -1));

        lbl_sdt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_sdt.setText("...");
        jPanel1.add(lbl_sdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 32, 131, -1));

        lbl_maNhanVien.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_maNhanVien.setText("...");
        jPanel1.add(lbl_maNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 32, 131, -1));

        lbl_tenVaiTro.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_tenVaiTro.setText("...");
        jPanel1.add(lbl_tenVaiTro, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 32, 131, -1));

        btn_DangXuat.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_DangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Logout-icon.png"))); // NOI18N
        btn_DangXuat.setText("LogOut");
        btn_DangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DangXuatActionPerformed(evt);
            }
        });
        jPanel1.add(btn_DangXuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 20, 133, 40));

        btn_Thoat.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_Thoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Extras-Close-icon.png"))); // NOI18N
        btn_Thoat.setText("Exit");
        btn_Thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThoatActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Thoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 20, 133, 40));

        btn_CapNhatInFo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_CapNhatInFo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/profile-settings-icon.png"))); // NOI18N
        btn_CapNhatInFo.setText("Edit Profile");
        btn_CapNhatInFo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CapNhatInFoActionPerformed(evt);
            }
        });
        jPanel1.add(btn_CapNhatInFo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1023, 20, 140, 40));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Purchase", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N

        btn_HoaDon.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_HoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/note-add-icon.png"))); // NOI18N
        btn_HoaDon.setText("Bill");
        btn_HoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HoaDonActionPerformed(evt);
            }
        });

        btn_KhachHang.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_KhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user-male-white-blue-features-icon.png"))); // NOI18N
        btn_KhachHang.setText("Customer");
        btn_KhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_KhachHangActionPerformed(evt);
            }
        });

        btn_NhomKH.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_NhomKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user-group-icon.png"))); // NOI18N
        btn_NhomKH.setText("Customer Type");
        btn_NhomKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NhomKHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_HoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_KhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_NhomKH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_NhomKH, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        mainPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        mainPanel.setMaximumSize(new java.awt.Dimension(1271, 704));
        mainPanel.setMinimumSize(new java.awt.Dimension(1271, 704));
        mainPanel.setPreferredSize(new java.awt.Dimension(1271, 704));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1270, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 702, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Goods Management", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N

        btn_Kho.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_Kho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Toolbar-Home-icon.png"))); // NOI18N
        btn_Kho.setText("Warehouse");
        btn_Kho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_KhoActionPerformed(evt);
            }
        });

        btn_NhaCungCap.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_NhaCungCap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/rss-icon.png"))); // NOI18N
        btn_NhaCungCap.setText("Supplier");
        btn_NhaCungCap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NhaCungCapActionPerformed(evt);
            }
        });

        btn_SanPham.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_SanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Box-icon.png"))); // NOI18N
        btn_SanPham.setText("Product");
        btn_SanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SanPhamActionPerformed(evt);
            }
        });

        btn_LoaiSanPham.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_LoaiSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/basket-full-icon.png"))); // NOI18N
        btn_LoaiSanPham.setText("Product Type");
        btn_LoaiSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LoaiSanPhamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Kho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_NhaCungCap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_SanPham, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_LoaiSanPham, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_Kho, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_NhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_LoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "System Management", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N

        btn_NhanVien.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_NhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Preppy-icon.png"))); // NOI18N
        btn_NhanVien.setText("Staff");
        btn_NhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NhanVienActionPerformed(evt);
            }
        });

        btn_VaiTro.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_VaiTro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/System-icon.png"))); // NOI18N
        btn_VaiTro.setText("Position");
        btn_VaiTro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VaiTroActionPerformed(evt);
            }
        });

        btn_BaoCao.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_BaoCao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/analytics-icon.png"))); // NOI18N
        btn_BaoCao.setText("Report");
        btn_BaoCao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BaoCaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_NhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_VaiTro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_BaoCao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_VaiTro, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_BaoCao, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1272, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1484, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_HoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HoaDonActionPerformed
        // TODO add your handling code here:
        clearMainPanel();
        ct_FormMuaHang.setVisible(true);
    }//GEN-LAST:event_btn_HoaDonActionPerformed

    private void btn_ThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThoatActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btn_ThoatActionPerformed

    private void btn_DangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DangXuatActionPerformed
        // TODO add your handling code here:
        this.dispose();
//        NhanVien nv = (new NhanVienDAO()).getNVByID(lbl_maNhanVien.getText().trim());
        Form_Login form_Login = new Form_Login(nhanVien.getTaiKhoan(), nhanVien.getMatKhau());
        form_Login.setVisible(true);
    }//GEN-LAST:event_btn_DangXuatActionPerformed

    private void btn_KhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_KhachHangActionPerformed
        // TODO add your handling code here:
        clearMainPanel();
        ct_FormKhachHang.setVisible(true);
    }//GEN-LAST:event_btn_KhachHangActionPerformed

    private void btn_NhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NhanVienActionPerformed
        // TODO add your handling code here:
        clearMainPanel();
        ct_FormNhanVien.setVisible(true);
    }//GEN-LAST:event_btn_NhanVienActionPerformed

    private void btn_VaiTroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VaiTroActionPerformed
        // TODO add your handling code here:
        clearMainPanel();
        ct_FormVaiTro.setVisible(true);
    }//GEN-LAST:event_btn_VaiTroActionPerformed

    private void btn_KhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_KhoActionPerformed
        // TODO add your handling code here:
        clearMainPanel();
        ct_FormKho.setVisible(true);
    }//GEN-LAST:event_btn_KhoActionPerformed

    private void btn_NhaCungCapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NhaCungCapActionPerformed
        // TODO add your handling code here:
        clearMainPanel();
        ct_FormNhaCungCap.setVisible(true);
    }//GEN-LAST:event_btn_NhaCungCapActionPerformed

    private void btn_SanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SanPhamActionPerformed
        // TODO add your handling code here:
        clearMainPanel();
        ct_FormSanPham.setVisible(true);
    }//GEN-LAST:event_btn_SanPhamActionPerformed

    private void btn_LoaiSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LoaiSanPhamActionPerformed
        // TODO add your handling code here:
        clearMainPanel();
        ct_FormLoaiSanPham.setVisible(true);
    }//GEN-LAST:event_btn_LoaiSanPhamActionPerformed

    private void btn_NhomKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NhomKHActionPerformed
        // TODO add your handling code here:
        clearMainPanel();
        ct_FormNhomKhachHang.setVisible(true);
    }//GEN-LAST:event_btn_NhomKHActionPerformed

    private void btn_CapNhatInFoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CapNhatInFoActionPerformed
        // TODO add your handling code here:
        Edit_Profile_Form epf = new Edit_Profile_Form(this, (new NhanVienDAO()).getNVByID(lbl_maNhanVien.getText().trim()));
        epf.setVisible(true);
    }//GEN-LAST:event_btn_CapNhatInFoActionPerformed

    private void btn_BaoCaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BaoCaoActionPerformed
        // TODO add your handling code here:
        clearMainPanel();
        ct_FormBaoCao.setVisible(true);
    }//GEN-LAST:event_btn_BaoCaoActionPerformed

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
            java.util.logging.Logger.getLogger(MAIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MAIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MAIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MAIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new MAIN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_BaoCao;
    private javax.swing.JButton btn_CapNhatInFo;
    private javax.swing.JButton btn_DangXuat;
    private javax.swing.JButton btn_HoaDon;
    private javax.swing.JButton btn_KhachHang;
    private javax.swing.JButton btn_Kho;
    private javax.swing.JButton btn_LoaiSanPham;
    private javax.swing.JButton btn_NhaCungCap;
    private javax.swing.JButton btn_NhanVien;
    private javax.swing.JButton btn_NhomKH;
    private javax.swing.JButton btn_SanPham;
    private javax.swing.JButton btn_Thoat;
    private javax.swing.JButton btn_VaiTro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lbl_TenNhanVien;
    private javax.swing.JLabel lbl_maNhanVien;
    private javax.swing.JLabel lbl_sdt;
    private javax.swing.JLabel lbl_tenVaiTro;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}
