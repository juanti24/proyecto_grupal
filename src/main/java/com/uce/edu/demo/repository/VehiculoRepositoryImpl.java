package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.ProyectoGrupalPa2Application;
import com.uce.edu.demo.repository.modelo.Vehiculo;
import com.uce.edu.demo.repository.modelo.VehiculoBuscar;

@Repository
@Transactional
public class VehiculoRepositoryImpl implements IVehiculoRepository {

	private static Logger LOG = Logger.getLogger(ProyectoGrupalPa2Application.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.SUPPORTS)

	public void insertar(Vehiculo vehiculo) {
		this.entityManager.persist(vehiculo);

	}

	@Override
	@Transactional(value = TxType.SUPPORTS)

	public Vehiculo buscar(Integer id) {

		return this.entityManager.find(Vehiculo.class, id);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)

	public void actualizar(Vehiculo vehiculo) {
		this.entityManager.merge(vehiculo);

	}

	@Override
	@Transactional(value = TxType.MANDATORY)

	public void borrar(Integer id) {
		Vehiculo vehiculo = this.buscar(id);
		this.entityManager.remove(vehiculo);

	}

	@Override
	@Transactional(value = TxType.SUPPORTS)

	public Vehiculo buscarPorPlaca(String placa) {
		TypedQuery<Vehiculo> myQuery = this.entityManager.createQuery("SELECT v FROM Vehiculo v WHERE v.placa=: placa",
				Vehiculo.class);
		myQuery.setParameter("placa", placa);
		try {
			return myQuery.getSingleResult();
		}
		catch(NoResultException e) {
			return null;
		}
		
	}

	// Aqui ocupo el objeto sencillo para buscar por marca y modelo
	@Override
	@Transactional(value = TxType.SUPPORTS)

	public List<VehiculoBuscar> buscarMarcaModelo(String marca, String modelo) {
		TypedQuery<VehiculoBuscar> myQuery = this.entityManager.createQuery(
				"Select NEW com.uce.edu.demo.repository.modelo.VehiculoBuscar(v.placa, v.modelo, v.marca, v.anioFabricacion, v.estado,v.valorPorDia) FROM Vehiculo v where v.marca=:dato1 and v.modelo=: dato2 ",
				VehiculoBuscar.class);
		myQuery.setParameter("dato1", marca);
		myQuery.setParameter("dato2", modelo);
		return myQuery.getResultList();
	}

	@Override
	@Transactional(value = TxType.SUPPORTS)

	public List<Vehiculo> buscarTodosVehiculos() {
		TypedQuery<Vehiculo> myQuery = this.entityManager.createQuery("Select v from Vehiculo v", Vehiculo.class);
		List<Vehiculo> listaVehiculos = myQuery.getResultList();
		return listaVehiculos;
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Vehiculo> buscarPorFechas(LocalDateTime fechaInicio, LocalDateTime fechaFinal) {
		TypedQuery<Vehiculo> myQuery = this.entityManager.createQuery(
				"Select v FROM Vehiculo v JOIN v.reservas j WHERE j.fechaInicio >=: fecha1 and j.fechaFin <=: fecha2 ",
				Vehiculo.class);
		myQuery.setParameter("fecha1", fechaInicio);
		myQuery.setParameter("fecha2", fechaFinal);

		List<Vehiculo> listaVehiculos = myQuery.getResultList();
		for (Vehiculo v : listaVehiculos) {
			LOG.info("reserva" + v.getReservas());
		}

		Set<Vehiculo> vehiculoNoRep = new HashSet<Vehiculo>(listaVehiculos);
		listaVehiculos.clear();
		listaVehiculos.addAll(vehiculoNoRep);

		return listaVehiculos;
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Vehiculo> buscarMarca(String marca) {
		// TODO Auto-generated method stub
		TypedQuery<Vehiculo> myQuery = this.entityManager.createQuery("SELECT v FROM Vehiculo v WHERE v.marca=:marca",
				Vehiculo.class);
		myQuery.setParameter("marca", marca);

		return myQuery.getResultList();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)

	public boolean verificarReserva(Integer id) {
		Vehiculo vehiculo = this.buscar(id);
		if (vehiculo.getReservas().isEmpty()) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)

	public List<Vehiculo> buscarFechas(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		TypedQuery<Vehiculo> myQuery = this.entityManager.createQuery(
				"Select v from Vehiculo v JOIN v.reservas r WHERE r.fechaInicio>=:valor1 AND r.fechaFin<=:valor2 ",
				Vehiculo.class);
		myQuery.setParameter("valor1", fechaInicio);
		myQuery.setParameter("valor2", fechaFin);
		List<Vehiculo> listaVehiculos = myQuery.getResultList();
		for (Vehiculo v : listaVehiculos) {
			LOG.info("reserva" + v.getReservas());
		}
		Set<Vehiculo> vehiculoNoRep = new HashSet<Vehiculo>(listaVehiculos);
		listaVehiculos.clear();
		listaVehiculos.addAll(vehiculoNoRep);

		return listaVehiculos;
	}
}
