package com.uce.edu.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.demo.repository.modelo.ClienteVip;
import com.uce.edu.demo.repository.modelo.MesAnio;
import com.uce.edu.demo.repository.modelo.VehiculoVip;
import com.uce.edu.demo.service.IClienteService;
import com.uce.edu.demo.service.IVehiculoService;

@Controller
@RequestMapping("/reportes/")
public class ReporteController {
	

	@Autowired
	private IClienteService clienteService;
	
	@Autowired
	private IVehiculoService vehiculoService;

	// reporte Clientes VIP
	
	@GetMapping("reporteClientesVIP")
	public String reporteClientesVIP(Model modelo, ClienteVip clienteVIP) {
		List<ClienteVip> listaClientesVIP = this.clienteService.reporteClientesVip();
		modelo.addAttribute("listaClientesVIP", listaClientesVIP);
		return "reporte/reporteClientesVip";

		}
	
	/////////////////////////// 3.c ////////////////////////////////
	
	// primer metodo reporteVehiculosVIP
		@GetMapping("reporteVehiculosVIP")
		public String obtenerPaginaIngresarDatosReporteVehiculosVIP(MesAnio mesAnio) {
			return "reporte/reporteVehiculosVip";

		}

		// segundo metodo reporteReservas
		@GetMapping("reporteVehiculosVIPMostrar")
		public String reporteVehiculosVIPMostrar(Model modelo, MesAnio mesAnio) {
			List<VehiculoVip> listaVechiculoVIP = this.vehiculoService.reporteVehiculosVip(mesAnio.getMes(), mesAnio.getAnio());
			modelo.addAttribute("listaVechiculoVIP", listaVechiculoVIP);
			return "reporte/reporteVehiculosVipMostrar";

		}
	}
	
	