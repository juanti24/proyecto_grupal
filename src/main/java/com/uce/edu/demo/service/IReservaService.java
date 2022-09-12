package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.Reserva;

public interface IReservaService {
	
	public void insertar(Reserva reserva);

	public Reserva buscar(Integer id);

	public void actualizar(Reserva reserva);

	public void eliminar(Integer id);
	
	public Reserva buscarNumero(String numero);

}
