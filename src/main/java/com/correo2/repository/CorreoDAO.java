package com.correo2.repository;

import java.util.List;

import com.correo2.entity.Correo;

public interface CorreoDAO {
    List<Correo> obtenerTodos();
    Correo obtenerPorId(int id);
    void guardar(Correo correo);
    void actualizar(Correo correo);
    void eliminar(Correo correo);
}