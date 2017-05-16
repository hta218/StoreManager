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
public class Kho {

    private Integer soKho;
    private String tenKho;
    private String diaChi;
    private String maNhanVien;
    private String tenNhanVien;
    private Integer sdt;

    public Kho() {
    }

    public Kho(Integer soKho) {
        this.soKho = soKho;
    }

    public Kho(Integer soKho, String tenKho, String diaChi, Integer sdt) {
        this.soKho = soKho;
        this.tenKho = tenKho;
        this.diaChi = diaChi;
        this.sdt = sdt;
    }

    public Kho(String tenKho, String diaChi, Integer sdt) {
        this.tenKho = tenKho;
        this.diaChi = diaChi;
        this.sdt = sdt;
    }

    public Integer getSoKho() {
        return soKho;
    }

    public void setSoKho(Integer soKho) {
        this.soKho = soKho;
    }

    public String getTenKho() {
        return tenKho;
    }

    public void setTenKho(String tenKho) {
        this.tenKho = tenKho;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Integer getSdt() {
        return sdt;
    }

    public void setSdt(Integer sdt) {
        this.sdt = sdt;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }
}
