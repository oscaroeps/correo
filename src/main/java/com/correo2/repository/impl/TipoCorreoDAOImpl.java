package com.correo2.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.correo2.entity.TipoCorreo;
import com.correo2.repository.TipoCorreoDAO;

@Repository
@Transactional
public class TipoCorreoDAOImpl implements TipoCorreoDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<TipoCorreo> obtenerTodos() {
        return sessionFactory.getCurrentSession()
                             .createQuery("from TipoCorreo", TipoCorreo.class)
                             .list();
    }

    @Override
    public TipoCorreo obtenerPorId(int id) {
        return sessionFactory.getCurrentSession().get(TipoCorreo.class, id);
    }
}
