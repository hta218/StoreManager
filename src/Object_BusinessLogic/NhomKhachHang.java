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
public class NhomKhachHang {

    private Integer maNhomKH;
    private String tenNhomKH;
    private String moTa;

    public NhomKhachHang() {
    }

    public NhomKhachHang(Integer maNhomKH) {
        this.maNhomKH = maNhomKH;
    }

    public NhomKhachHang(String tenNhomKH, String moTa) {
        this.tenNhomKH = tenNhomKH;
        this.moTa = moTa;
    }

    public NhomKhachHang(Integer maNhomKH, String tenNhomKH, String moTa) {
        this.maNhomKH = maNhomKH;
        this.tenNhomKH = tenNhomKH;
        this.moTa = moTa;
    }

    public Integer getMaNhomKH() {
        return maNhomKH;
    }

    public void setMaNhomKH(Integer maNhomKH) {
        this.maNhomKH = maNhomKH;
    }

    public String getTenNhomKH() {
        return tenNhomKH;
    }

    public void setTenNhomKH(String tenNhomKH) {
        this.tenNhomKH = tenNhomKH;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public boolean equals(Object obj) {
        NhomKhachHang nkh = (NhomKhachHang) obj;
        if (nkh != null && nkh.getMaNhomKH() != null && this.getMaNhomKH() != null
                && this.getMaNhomKH().equals(nkh.getMaNhomKH())) {
            return true;
        }
        return false;
    }

}
