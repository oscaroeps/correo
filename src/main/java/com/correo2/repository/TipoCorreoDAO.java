package com.correo2.repository;

import java.util.List;

import com.correo2.entity.TipoCorreo;

public interface TipoCorreoDAO {
    List<TipoCorreo> obtenerTodos();
    TipoCorreo obtenerPorId(int id);
}
