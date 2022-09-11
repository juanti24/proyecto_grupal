package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Vehiculo;
import com.uce.edu.demo.repository.modelo.VehiculoBuscar;

public interface IVehiculoService {

	public void insertar(Vehiculo vehiculo);

	public Vehiculo buscar(Integer id);

	public void actualizar(Vehiculo vehiculo);

	public void borrar(Integer id);

	public Vehiculo buscarPorPlaca(String placa);

	public List<VehiculoBuscar> buscarMarcaModelo(String marca, String modelo);
	public List<Vehiculo> buscarMarca(String marca);
	public List<Vehiculo> buscarTodosVehiculos();
}
