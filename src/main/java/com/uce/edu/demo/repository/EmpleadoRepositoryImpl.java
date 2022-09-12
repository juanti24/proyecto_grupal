package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.ProyectoGrupalPa2Application;
import com.uce.edu.demo.repository.modelo.Empleado;

@Repository
@Transactional
public class EmpleadoRepositoryImpl implements IEmpleadoRepository {

	private static Logger LOG = Logger.getLogger(ProyectoGrupalPa2Application.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.SUPPORTS)
	public void insertar(Empleado e) {
		this.entityManager.persist(e);

	}

	@Override
	@Transactional(value = TxType.SUPPORTS)

	public Empleado buscar(Integer id) {

		return this.entityManager.find(Empleado.class, id);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)

	public void actualizar(Empleado e) {
		this.entityManager.merge(e);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)

	public void eliminar(Integer id) {
		Empleado em = this.buscar(id);
		this.entityManager.remove(em);

	}

}
