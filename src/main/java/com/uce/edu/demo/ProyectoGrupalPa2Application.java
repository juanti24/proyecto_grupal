package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Reserva;
import com.uce.edu.demo.repository.modelo.Vehiculo;
import com.uce.edu.demo.service.IClienteService;
import com.uce.edu.demo.service.IVehiculoService;
import org.apache.log4j.Logger;
@SpringBootApplication
public class ProyectoGrupalPa2Application implements CommandLineRunner{

	private static Logger LOG = Logger.getLogger(ProyectoGrupalPa2Application.class);
	
	@Autowired
	private IVehiculoService ivehiculoService;
	
	@Autowired
	private IClienteService iclienteService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoGrupalPa2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Vehiculo v = new Vehiculo();
		v.setAnioFabricacion("2010");
		v.setAvaluo(new BigDecimal(15000));
		v.setCilindraje("2000cc");
		v.setEstado("D");
		v.setFechaDisponibilidad(LocalDateTime.now());
		v.setMarca("Toyota");
		v.setModelo("Prius");
		v.setPaisFabricacion("Alemania");
		v.setPlaca("DJK-1741");
		v.setReservas(null);
		v.setValorPorDia(new BigDecimal(75));
		
		Vehiculo v1 = new Vehiculo();
		v1.setAnioFabricacion("2015");
		v1.setAvaluo(new BigDecimal(17000));
		v1.setCilindraje("2000cc");
		v1.setEstado("D");
		v1.setFechaDisponibilidad(LocalDateTime.now());
		v1.setMarca("Toyota");
		v1.setModelo("Prius");
		v1.setPaisFabricacion("Alemania");
		v1.setPlaca("AJJ-4142");
		v1.setReservas(null);
		v1.setValorPorDia(new BigDecimal(90));
		
		Vehiculo v2 = new Vehiculo();
		v2.setAnioFabricacion("2018");
		v2.setAvaluo(new BigDecimal(20000));
		v2.setCilindraje("2000cc");
		v2.setEstado("ND");
		v2.setFechaDisponibilidad(LocalDateTime.now());
		v2.setMarca("Toyota");
		v2.setModelo("Prius");
		v2.setPaisFabricacion("Alemania");
		v2.setPlaca("BBC-123");
		v2.setReservas(null);
		v2.setValorPorDia(new BigDecimal(120));
		
		//this.ivehiculoService.insertar(v);
		//this.ivehiculoService.insertar(v1);
		//this.ivehiculoService.insertar(v2);
	LOG.info(this.iclienteService.buscarPorCedula("1725776650"));
		//System.out.println(this.iclienteService.verificarReserva(7));
		System.out.println(this.iclienteService.buscarPorCedula("1725776650"));
		System.out.println(this.iclienteService.buscarPorCedula("a"));
	//LOG.info(this.ivehiculoService.buscarTodosVehiculos());
		
	}

}
