package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Reserva;

@Repository
@Transactional
public class ReservaRepositoryImpl implements IReservaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Reserva reserva) {
		this.entityManager.persist(reserva);
		
	}

	@Override
	public Reserva buscar(Integer id) {
		
		return this.entityManager.find(Reserva.class, id);
	}

	@Override
	public void actualizar(Reserva reserva) {
		this.entityManager.merge(reserva);
		
	}

	@Override
	public void eliminar(Integer id) {
		Reserva res = this.buscar(id);
		this.entityManager.remove(res);
		
	}

	@Override
	public Reserva buscarNumero(String numero) {
		TypedQuery<Reserva> myQuery=this.entityManager.createQuery("Select r from Reserva r where r.numero=:valor", Reserva.class);
		myQuery.setParameter("valor", numero);
		return myQuery.getSingleResult();
	}

}
