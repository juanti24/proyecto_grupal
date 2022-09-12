package com.uce.edu.demo.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uce.edu.demo.repository.modelo.Cobro;
import com.uce.edu.demo.repository.modelo.Reserva;
import com.uce.edu.demo.repository.modelo.Vehiculo;
import com.uce.edu.demo.repository.modelo.VehiculoBuscar;
import com.uce.edu.demo.service.IClienteService;
import com.uce.edu.demo.service.IGestorClienteService;
import com.uce.edu.demo.service.IVehiculoService;

@Controller
@RequestMapping("/clientes/")
public class ClienteController {

	@Autowired
	private IVehiculoService vehiculoService;
	
	@Autowired
	private IGestorClienteService igestorClienteService;
	
	////////////////////// 1.a ////////////////////////////////////

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
	
	////////////////////// 1.b ////////////////////////////////////
	
	@GetMapping("reservar/buscarVehiculo")
	public String obtenerPaginaBuscarVehiculo(Reserva reserva, Model modelo) {
		modelo.addAttribute("reserva", reserva);
		return "cliente/reservarBuscarVehiculo";

	}

	// segundo metodo para reservar vehiculo
	@GetMapping("verificarVehiculo")
	public String verificarVehiculo(Model modelo, Reserva reserva, BindingResult result, RedirectAttributes redirect) {
		Vehiculo vehiculoBuscar = this.vehiculoService.buscarPorPlaca(reserva.getVehiculo().getPlaca());
		BigDecimal valorTotal=this.igestorClienteService.calcularPagoVehiculo(reserva.getVehiculo().getPlaca(),
				reserva.getCliente().getCedula(), reserva.getFechaInicio(), reserva.getFechaFin());
		Cobro cobro=new Cobro();
		cobro.setValorTotalPagar(valorTotal);
		reserva.setCobro(cobro);
		modelo.addAttribute("reserva", reserva);
		
		List<Reserva> reservasVehiculo = vehiculoBuscar.getReservas();
		if (reservasVehiculo == null || reservasVehiculo.isEmpty()) {
			return "cliente/pagarVehiculo";
		} else {
			for (Reserva r : reservasVehiculo) {
				if (this.igestorClienteService.verFechas(reserva.getFechaInicio(), reserva.getFechaFin(),
						r.getFechaInicio(), r.getFechaFin())) {
					return "cliente/reservarBuscarVehiculo"; 
					
				}
			}
			 return "cliente/pagarVehiculo";
		}

		

	}

	// tercer metodo para reservar vehiculo
	@PutMapping("reservar/pagarVehiculo")
	public String pagarVehiculo(Model modelo, Reserva reserva) {
		if(reserva.getCobro().getTarjeta().isEmpty()) {
			reserva.getCobro().setTarjeta(null);
		}
		Reserva reservaGenerada = this.igestorClienteService.reservarVehiculo(reserva.getVehiculo().getPlaca(),
				reserva.getCliente().getCedula(), reserva.getFechaInicio(), reserva.getFechaFin(),
				reserva.getCobro().getTarjeta());
		modelo.addAttribute("reservaGenerada", reservaGenerada);
		return "cliente/mostrarReserva";

	}
	
	

}
