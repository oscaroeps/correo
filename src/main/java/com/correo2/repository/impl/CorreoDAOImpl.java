package com.correo2.repository.impl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.correo2.entity.Correo;
import com.correo2.repository.CorreoDAO;

@Repository
@Transactional
public class CorreoDAOImpl implements CorreoDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Correo> obtenerTodos() {
        return sessionFactory.getCurrentSession()
                             .createQuery("from Correo", Correo.class)
                             .list();
    }

    @Override
    public Correo obtenerPorId(int id) {
        return sessionFactory.getCurrentSession().get(Correo.class, id);
    }

    @Override
    public void guardar(Correo correo) {
        sessionFactory.getCurrentSession().save(correo);
    }

    @Override
    public void actualizar(Correo correo) {
        sessionFactory.getCurrentSession().update(correo);
    }

    @Override
    public void eliminar(Correo correo) {
        sessionFactory.getCurrentSession().delete(correo);
    }
}
