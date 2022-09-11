package com.uce.edu.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.demo.repository.modelo.Vehiculo;
import com.uce.edu.demo.repository.modelo.VehiculoBuscar;
import com.uce.edu.demo.service.IVehiculoService;

@Controller
@RequestMapping("/clientes/")
public class ClienteController {

	@Autowired
	private IVehiculoService vehiculoService;

	//Primera vista donde el usuario debe ingresar el modelo y marca del vehículo a buscar
	@GetMapping("buscarVehiculos")
	public String obtenerPaginaIngresoMarcaModelo(Vehiculo vehiculo) {
		return "cliente/buscarVehiculoDisponible";

	}
	
	//Segunda vista donde ya aparecen las lista de vehículos buscados por los parámetros anteriores
	@GetMapping("buscar/disponibles")
	public String mostrarVehiculosDisponibles(Vehiculo vehiculo, Model modelom) {
		List<VehiculoBuscar> vehiculosBuscados = this.vehiculoService.buscarMarcaModelo(vehiculo.getMarca(),vehiculo.getModelo());
		modelom.addAttribute("vehiculos", vehiculosBuscados);
		return "cliente/listaVehiculosDisponibles";

	}

}
