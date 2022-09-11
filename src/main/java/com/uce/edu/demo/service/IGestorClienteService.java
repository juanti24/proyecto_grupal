package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Vehiculo;

public interface IGestorClienteService {
	
	public List<String> buscarVehiculosDisponiblesTexto(String marca, String modelo);

	public List<Vehiculo> buscarVehiculosDisponibles(String marca, String modelo);

}
