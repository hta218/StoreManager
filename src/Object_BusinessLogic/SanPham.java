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
public class SanPham {

    private String maSanPham;
    private String tenSanPham;
    private Integer donGia;
    private String donViTinh;
    private Integer maNhaCC;
    private String tenNhaCC;
    private String xuatXu;
    private Integer maLoaiSP;
    private String tenLoaiSP;

     public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }
    public SanPham() {
    }

    public SanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public Integer getDonGia() {
        return donGia;
    }

    public void setDonGia(Integer donGia) {
        this.donGia = donGia;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public Integer getMaNhaCC() {
        return maNhaCC;
    }

    public void setMaNhaCC(Integer maNhaCC) {
        this.maNhaCC = maNhaCC;
    }

    public String getTenNhaCC() {
        return tenNhaCC;
    }

    public void setTenNhaCC(String tenNhaCC) {
        this.tenNhaCC = tenNhaCC;
    }

    public Integer getMaLoaiSP() {
        return maLoaiSP;
    }

    public void setMaLoaiSP(Integer maLoaiSP) {
        this.maLoaiSP = maLoaiSP;
    }

    public String getTenLoaiSP() {
        return tenLoaiSP;
    }

    public void setTenLoaiSP(String tenLoaiSP) {
        this.tenLoaiSP = tenLoaiSP;
    }

    @Override
    public boolean equals(Object obj) {
        SanPham sp = (SanPham) obj;
        if (sp != null && sp.getMaSanPham()!= null && this.getMaSanPham()!= null && (sp.getMaSanPham().equalsIgnoreCase(this.getMaSanPham()))) {
            return true;
        }
        return false;
    }

}
