package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IVehiculoRepository;
import com.uce.edu.demo.repository.modelo.Vehiculo;
import com.uce.edu.demo.repository.modelo.VehiculoBuscar;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

	@Autowired
	private IVehiculoRepository ivehiculoRepository;

	@Override
	public void insertar(Vehiculo vehiculo) {
		this.ivehiculoRepository.insertar(vehiculo);

	}

	@Override
	public Vehiculo buscar(Integer id) {
		return this.ivehiculoRepository.buscar(id);
	}

	@Override
	public void actualizar(Vehiculo vehiculo) {
		this.ivehiculoRepository.actualizar(vehiculo);

	}

	@Override
	public void borrar(Integer id) {
		this.ivehiculoRepository.borrar(id);

	}

	@Override
	public Vehiculo buscarPorPlaca(String placa) {

		return this.ivehiculoRepository.buscarPorPlaca(placa);
	}

	@Override
	public List<VehiculoBuscar> buscarMarcaModelo(String marca, String modelo) {

		return this.ivehiculoRepository.buscarMarcaModelo(marca, modelo);
	}

	@Override
	public List<Vehiculo> buscarTodosVehiculos() {
		// TODO Auto-generated method stub
		return this.ivehiculoRepository.buscarTodosVehiculos();
	}

	@Override
	public List<Vehiculo> buscarMarca(String marca) {
		// TODO Auto-generated method stub
		return this.ivehiculoRepository.buscarMarca(marca);
	}

}
