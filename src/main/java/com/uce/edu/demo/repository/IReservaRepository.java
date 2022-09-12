package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Reserva;

public interface IReservaRepository {

	public void insertar(Reserva reserva);

	public Reserva buscar(Integer id);

	public void actualizar(Reserva reserva);

	public void eliminar(Integer id);
	
	public Reserva buscarNumero(String numero);
	
	

}
