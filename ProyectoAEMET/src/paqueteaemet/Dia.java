package paqueteaemet;

import java.util.ArrayList;

public class Dia {
	private String fecha;
	private ArrayList<EstadoCielo> estados_cielo;
	int t_minima, t_maxima;
	public Dia(String fecha, ArrayList<EstadoCielo> estados_cielo, int t_minima, int t_maxima) {
		super();
		this.fecha = fecha;
		this.estados_cielo = estados_cielo;
		this.t_minima = t_minima;
		this.t_maxima = t_maxima;
	}
	public String getFecha() {
		return fecha;
	}
	public ArrayList<EstadoCielo> getEstados_cielo() {
		return estados_cielo;
	}
	public int getT_minima() {
		return t_minima;
	}
	public int getT_maxima() {
		return t_maxima;
	}
	
}
