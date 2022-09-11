package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IClienteRepository;
import com.uce.edu.demo.repository.modelo.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteRepository iclienteRepository;

	@Override
	public void insertar(Cliente c) {
		this.iclienteRepository.insertar(c);

	}

	@Override
	public Cliente buscar(Integer id) {

		return this.iclienteRepository.buscar(id);
	}

	@Override
	public void actualizar(Cliente c) {
		this.iclienteRepository.actualizar(c);

	}

	@Override
	public void eliminar(Integer id) {
		this.iclienteRepository.eliminar(id);

	}

	@Override
	public Cliente buscarPorCedula(String cedula) {

		return this.iclienteRepository.buscarPorCedula(cedula);
	}

	@Override
	public List<Cliente> buscarTodosClientes() {

		return this.iclienteRepository.buscarTodosClientes();
	}

	@Override
	public List<Cliente> buscarClientesPorApellido(String apellido) {
	
		return this.iclienteRepository.buscarClientesPorApellido(apellido);
	}

	@Override
	public boolean verificarReserva(Integer id) {
		
		return this.iclienteRepository.verificarReserva(id);
	}

}
