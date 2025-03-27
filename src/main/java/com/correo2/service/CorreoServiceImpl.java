package com.correo2.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.correo2.entity.Correo;
import com.correo2.repository.CorreoDAO;

@Service
@Transactional
public class CorreoServiceImpl implements CorreoService {

    @Autowired
    private CorreoDAO correoDAO;

    @Override
    public List<Correo> obtenerTodos() {
        return correoDAO.obtenerTodos();
    }

    @Override
    public Correo obtenerPorId(int id) {
        return correoDAO.obtenerPorId(id);
    }

    @Override
    public void guardar(Correo correo) {
        correoDAO.guardar(correo);
    }

    @Override
    public void actualizar(Correo correo) {
        correoDAO.actualizar(correo);
    }

    @Override
    public void eliminar(int id) {
        Correo correo = obtenerPorId(id);
        if(correo != null){
            correoDAO.eliminar(correo);
        }
    }
}