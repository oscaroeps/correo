package com.correo2.entity;

import javax.persistence.*;

@Entity
@Table(name = "TC_TIPOCORREO")
public class TipoCorreo {

    @Id
    @Column(name = "N_ID")
    private Integer id;

    @Column(name = "S_TIPOCORREO", nullable = false, length = 50)
    private String nombreTipo;

    public TipoCorreo() {}

    public TipoCorreo(Integer id, String nombreTipo) {
        this.id = id;
        this.nombreTipo = nombreTipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }
}
