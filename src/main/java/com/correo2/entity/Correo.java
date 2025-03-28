package com.correo2.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TC_CORREO")
public class Correo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "correo_seq")
    @SequenceGenerator(name = "correo_seq", sequenceName = "TC_CORREO_SEQ", allocationSize = 1)
    @Column(name = "N_ID")
    private Integer id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100)
    @Column(name = "S_NOMBRE", nullable = false)
    private String nombre;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "Debe ser un correo válido")
    @Column(name = "S_CORREO", nullable = false)
    private String correoElectronico;

    @NotNull(message="El tipo de correo es obligatorio")
    @ManyToOne
    @JoinColumn(name = "N_IDTIPOCORREO", nullable = false)
    private TipoCorreo tipoCorreo;

    public Correo() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public TipoCorreo getTipoCorreo() {
        return tipoCorreo;
    }

    public void setTipoCorreo(TipoCorreo tipoCorreo) {
        this.tipoCorreo = tipoCorreo;
    }
}
