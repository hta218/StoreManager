/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form_Presentation;

import DatabaseAccessObject_DAO.NhomKhachHangDAO;
import Object_BusinessLogic.KhachHang;
import Object_BusinessLogic.NhomKhachHang;
import java.awt.Component;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Huynh
 */
public class Form_ThongTinKhachHang extends javax.swing.JFrame {


    /**
     * Creates new form Edit_Profile_Form
     */

    public Form_ThongTinKhachHang(KhachHang kh) {
        initComponents();
        txt_MaNhanVien.setEditable(false);
        txt_TaiKhoan.setEditable(false);
        loadCombobox_NhomKhachHang();
        cbb_NhomKH.setEnabled(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        txt_MaNhanVien.setText(kh.getMaKH());
        txt_TenNhanVien.setText(kh.getHoTenKH());
        txt_TenNhanVien.setEditable(false);
        txt_SDT.setText(kh.getSdt().toString());
        txt_SDT.setEditable(false);
        txt_DiaChi.setText(kh.getDiachi());
        txt_DiaChi.setEditable(false);
        txt_Email.setText(kh.getEmail());
        txt_Email.setEditable(false);
        txt_SoCMND.setText(kh.getSoCMND().toString());
        txt_SoCMND.setEditable(false);
        txt_TaiKhoan.setText(kh.getDiemTichLuy().toString());
        if (kh.getGioiTinh().trim().equals("Nam")) {
            rbnNam.setSelected(true);
        } else {
            rbnNu.setSelected(true);
        }
        rbnNam.setEnabled(false);
        rbnNu.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgGioiTinh = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_MaNhanVien = new javax.swing.JTextField();
        txt_TenNhanVien = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbb_NhomKH = new javax.swing.JComboBox();
        txt_DiaChi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_SDT = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_Email = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        rbnNam = new javax.swing.JRadioButton();
        rbnNu = new javax.swing.JRadioButton();
        txt_TaiKhoan = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_SoCMND = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Customer ID:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(40, 30, 110, 17);

        txt_MaNhanVien.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(txt_MaNhanVien);
        txt_MaNhanVien.setBounds(172, 27, 270, 30);

        txt_TenNhanVien.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(txt_TenNhanVien);
        txt_TenNhanVien.setBounds(172, 72, 270, 30);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Customer Name");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(40, 75, 110, 17);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Customer Type");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(480, 79, 123, 17);

        cbb_NhomKH.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cbb_NhomKH.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbb_NhomKH);
        cbb_NhomKH.setBounds(610, 70, 220, 30);

        txt_DiaChi.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(txt_DiaChi);
        txt_DiaChi.setBounds(610, 180, 220, 30);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Address");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(480, 180, 70, 17);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Gender");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(480, 30, 70, 22);

        txt_SDT.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(txt_SDT);
        txt_SDT.setBounds(170, 170, 270, 30);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Phone Number");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(40, 180, 110, 17);

        txt_Email.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(txt_Email);
        txt_Email.setBounds(170, 220, 270, 30);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("Email");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(40, 220, 60, 17);

        bgGioiTinh.add(rbnNam);
        rbnNam.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        rbnNam.setText("Male");
        jPanel1.add(rbnNam);
        rbnNam.setBounds(610, 20, 63, 39);

        bgGioiTinh.add(rbnNu);
        rbnNu.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        rbnNu.setText("Female");
        jPanel1.add(rbnNu);
        rbnNu.setBounds(700, 20, 80, 39);

        txt_TaiKhoan.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(txt_TaiKhoan);
        txt_TaiKhoan.setBounds(610, 120, 220, 30);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("Bonus Score:");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(480, 126, 100, 17);

        txt_SoCMND.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(txt_SoCMND);
        txt_SoCMND.setBounds(172, 120, 270, 30);

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel16.setText("ID Number");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(40, 130, 100, 17);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/e.jpg"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(6, 18, 838, 250);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 847, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Form_ThongTinKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_ThongTinKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_ThongTinKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_ThongTinKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new Edit_Profile_Form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgGioiTinh;
    private javax.swing.JComboBox cbb_NhomKH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rbnNam;
    private javax.swing.JRadioButton rbnNu;
    private javax.swing.JTextField txt_DiaChi;
    private javax.swing.JTextField txt_Email;
    private javax.swing.JTextField txt_MaNhanVien;
    private javax.swing.JTextField txt_SDT;
    private javax.swing.JTextField txt_SoCMND;
    private javax.swing.JTextField txt_TaiKhoan;
    private javax.swing.JTextField txt_TenNhanVien;
    // End of variables declaration//GEN-END:variables
 private void loadCombobox_NhomKhachHang() {
        NhomKhachHangDAO nkhDAO = new NhomKhachHangDAO();
        //lấy toàn bộ bảng nhà cung cấp
        List<NhomKhachHang> nkhList = nkhDAO.selectAll();
        Vector v = new Vector(nkhList);
        //nvởi tạo dữ liệu cho combobox
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel(v);
        cbb_NhomKH.setModel(dcbm);
        //giúp tạo combobox hiển thị tên vai trò
        cbb_NhomKH.setRenderer(new ListCellRenderer() {
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
}