package com.correo2.service;

import java.util.List;

import com.correo2.entity.Correo;

public interface CorreoService {
    List<Correo> obtenerTodos();
    Correo obtenerPorId(int id);
    void guardar(Correo correo);
    void actualizar(Correo correo);
    void eliminar(int id);
}