package com.correo2.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.correo2.entity.TipoCorreo;
import com.correo2.repository.TipoCorreoDAO;
import com.correo2.service.TipoCorreoService;

@Service
@Transactional
public class TipoCorreoServiceImpl implements TipoCorreoService {

    @Autowired
    private TipoCorreoDAO tipoCorreoDAO;

    @Override
    public List<TipoCorreo> obtenerTodos() {
        return tipoCorreoDAO.obtenerTodos();
    }
}