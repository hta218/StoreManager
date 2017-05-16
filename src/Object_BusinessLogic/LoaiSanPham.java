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
public class LoaiSanPham {
    private Integer maLoaiSP;
    private String tenLoaiSP;
    private String moTa;

    public LoaiSanPham() {
    }

    public LoaiSanPham(Integer maLoaiSP) {
        this.maLoaiSP = maLoaiSP;
    }

    public LoaiSanPham(String tenLoaiSP, String moTa) {
        this.tenLoaiSP = tenLoaiSP;
        this.moTa = moTa;
    }

    public LoaiSanPham(Integer maLoaiSP, String tenLoaiSP, String moTa) {
        this.maLoaiSP = maLoaiSP;
        this.tenLoaiSP = tenLoaiSP;
        this.moTa = moTa;
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

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public boolean equals(Object obj) {
         //To change body of generated methods, choose Tools | Templates.
         LoaiSanPham lsp = (LoaiSanPham) obj;
         if (lsp != null && lsp.getMaLoaiSP() != null && this.getMaLoaiSP() != null
                 && lsp.getMaLoaiSP().equals(this.getMaLoaiSP())) {
            return true;
        }
         return false;
    }
    
    
}
