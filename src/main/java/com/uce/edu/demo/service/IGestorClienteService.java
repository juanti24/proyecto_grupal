package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.uce.edu.demo.repository.modelo.Reserva;

public interface IGestorClienteService {

	public BigDecimal calcularPagoVehiculo(String placa, String cedula, LocalDateTime fechaInicio,
			LocalDateTime fechaFinal);

	public boolean verFechas(LocalDateTime fechaInicio, LocalDateTime fechaFin, LocalDateTime fechaInicio2,
			LocalDateTime fechaFin2);
	
	public Reserva reservarVehiculo(String placa, String cedula, LocalDateTime fechaInicio, LocalDateTime fechaFinal,
			String numeroTarjeta);

}
