package com.correo2.repository;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.correo2.entity.Correo;

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
        // Asigna el nombre del tipo basado en nIdTipoCorreo (similar a la lógica anterior)
        if (correo.getnIdTipoCorreo() != null) {
            switch (correo.getnIdTipoCorreo()) {
                case 1:
                    correo.setsTipoCorreo("Personal");
                    break;
                case 2:
                    correo.setsTipoCorreo("Laboral");
                    break;
                case 3:
                    correo.setsTipoCorreo("Otro");
                    break;
                default:
                    correo.setsTipoCorreo("Desconocido");
                    break;
            }
        } else {
            correo.setsTipoCorreo("No especificado");
        }
        sessionFactory.getCurrentSession().save(correo);
    }

    @Override
    public void actualizar(Correo correo) {
        if (correo.getnIdTipoCorreo() != null) {
            switch (correo.getnIdTipoCorreo()) {
                case 1:
                    correo.setsTipoCorreo("Personal");
                    break;
                case 2:
                    correo.setsTipoCorreo("Laboral");
                    break;
                case 3:
                    correo.setsTipoCorreo("Otro");
                    break;
                default:
                    correo.setsTipoCorreo("Desconocido");
                    break;
            }
        } else {
            correo.setsTipoCorreo("No especificado");
        }
        sessionFactory.getCurrentSession().update(correo);
    }

    @Override
    public void eliminar(Correo correo) {
        sessionFactory.getCurrentSession().delete(correo);
    }
}