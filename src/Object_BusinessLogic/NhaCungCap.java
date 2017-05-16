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
public class NhaCungCap {

    private Integer maNhaCC;
    private String tenNhaCC;
    private String diaChi;
    private Integer sdt;
    private String email;

    public NhaCungCap(String tenNhaCC, String diaChi, Integer sdt, String email) {
        this.tenNhaCC = tenNhaCC;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
    }

    public NhaCungCap(Integer maNhaCC, String tenNhaCC, String diaChi, Integer sdt, String email) {
        this.maNhaCC = maNhaCC;
        this.tenNhaCC = tenNhaCC;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
    }

    public NhaCungCap(Integer maNhaCungCap) {
        this.maNhaCC = maNhaCungCap;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public NhaCungCap() {
    }

    @Override
    public boolean equals(Object obj) {
        NhaCungCap nhaCungCap = (NhaCungCap) obj;
        if (nhaCungCap != null && nhaCungCap.getMaNhaCC() != null && this.getMaNhaCC() != null
                && (this.getMaNhaCC().equals(nhaCungCap.getMaNhaCC()))) {
            return true;
        }
        return false;
    }

}
