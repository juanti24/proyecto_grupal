package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IReservaRepository;
import com.uce.edu.demo.repository.modelo.Reserva;

@Service
public class ReservaServiceImpl implements IReservaService {
	
	@Autowired
	private IReservaRepository ireservaRepository;

	@Override
	public void insertar(Reserva reserva) {
		this.ireservaRepository.insertar(reserva);

	}

	@Override
	public Reserva buscar(Integer id) {
		return this.ireservaRepository.buscar(id);
	}

	@Override
	public void actualizar(Reserva reserva) {
		this.ireservaRepository.actualizar(reserva);

	}

	@Override
	public void eliminar(Integer id) {
		this.ireservaRepository.eliminar(id);

	}

	@Override
	public Reserva buscarNumero(String numero) {
		// TODO Auto-generated method stub
		return this.ireservaRepository.buscarNumero(numero);
	}

}
