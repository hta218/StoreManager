/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object_BusinessLogic;

/**
 *
 * @author Huynh
 */
public class KhachHang {

    private String maKH;
    private String hoTenKH;
    private Integer soCMND;
    private String diachi;
    private String gioiTinh;
    private Integer sdt;
    private Integer maNhomKH;
    private String tenNhomKH;
    private String email;
    private Integer diemTichLuy;

    public KhachHang() {
    }

    public KhachHang(String maKH, String hoTenKH, String diachi, String gioiTinh, Integer sdt, Integer maNhomKH, String email, Integer soCMND, Integer diemTichLuy) {
        this.maKH = maKH;
        this.hoTenKH = hoTenKH;
        this.diachi = diachi;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.maNhomKH = maNhomKH;
        this.email = email;
        this.soCMND = soCMND;
        this.diemTichLuy = diemTichLuy;
    }

    public KhachHang(String maKH) {
        this.maKH = maKH;
    }

    public KhachHang(String hoTenKH, String diachi, String gioiTinh, Integer sdt, Integer maNhomKH, String email, Integer soCMND, Integer diemTichLuy) {
        this.hoTenKH = hoTenKH;
        this.diachi = diachi;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.maNhomKH = maNhomKH;
        this.email = email;
        this.soCMND = soCMND;
        this.diemTichLuy = diemTichLuy;
    }

    public String getTenNhomKH() {
        return tenNhomKH;
    }

    public void setTenNhomKH(String tenNhomKH) {
        this.tenNhomKH = tenNhomKH;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getHoTenKH() {
        return hoTenKH;
    }

    public void setHoTenKH(String hoTenKH) {
        this.hoTenKH = hoTenKH;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Integer getSdt() {
        return sdt;
    }

    public void setSdt(Integer sdt) {
        this.sdt = sdt;
    }

    public Integer getMaNhomKH() {
        return maNhomKH;
    }

    public void setMaNhomKH(Integer maNhomKH) {
        this.maNhomKH = maNhomKH;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(Integer soCMND) {
        this.soCMND = soCMND;
    }

    public Integer getDiemTichLuy() {
        return diemTichLuy;
    }

    public void setDiemTichLuy(Integer diemTichLuy) {
        this.diemTichLuy = diemTichLuy;
    }

    @Override
    public boolean equals(Object obj) {
        KhachHang kh = (KhachHang) obj;
        if (kh != null && kh.getMaKH() != null & this.getMaKH() != null && kh.getMaKH().equals(this.getMaKH())) {
            return true;
        }
        return false;
    }
}
