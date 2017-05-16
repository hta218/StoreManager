package Object_BusinessLogic;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Huynh
 */
public class VaiTro {

    private Integer maVaiTro;
    private String tenVaiTro;
    private String moTa;

    @Override
    public boolean equals(Object obj) {
        VaiTro vt = (VaiTro) obj;
        if (vt != null && vt.getMaVaiTro() != null && this.maVaiTro != null && (vt.getMaVaiTro().equals(this.maVaiTro))) {
            return true;
        }
        return false;
    }

    public VaiTro() {
    }

    public VaiTro(String tenVaiTro, String moTa) {
        this.tenVaiTro = tenVaiTro;
        this.moTa = moTa;
    }

    public VaiTro(Integer maVaiTro) {
        this.maVaiTro = maVaiTro;
    }

    public VaiTro(Integer maVaiTro, String tenVaiTro, String moTa) {
        this.maVaiTro = maVaiTro;
        this.tenVaiTro = tenVaiTro;
        this.moTa = moTa;
    }

    public Integer getMaVaiTro() {
        return maVaiTro;
    }

    public void setMaVaiTro(Integer maVaiTro) {
        this.maVaiTro = maVaiTro;
    }

    public String getTenVaiTro() {
        return tenVaiTro;
    }

    public void setTenVaiTro(String tenVaiTro) {
        this.tenVaiTro = tenVaiTro;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

}
