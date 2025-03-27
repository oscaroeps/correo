package com.correo2.entity;

import javax.persistence.*;

@Entity
@Table(name = "TC_TIPOCORREO")
public class TipoCorreo {

    @Id
    @Column(name = "N_ID")
    private int nId;

    @Column(name = "S_TIPOCORREO")
    private String sTipoCorreo;

    public TipoCorreo() {
    }

    public TipoCorreo(int nId, String sTipoCorreo) {
        this.nId = nId;
        this.sTipoCorreo = sTipoCorreo;
    }

    public int getnId() {
        return nId;
    }
    public void setnId(int nId) {
        this.nId = nId;
    }
    public String getsTipoCorreo() {
        return sTipoCorreo;
    }
    public void setsTipoCorreo(String sTipoCorreo) {
        this.sTipoCorreo = sTipoCorreo;
    }
}