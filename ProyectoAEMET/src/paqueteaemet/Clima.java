package paqueteaemet;

import java.util.ArrayList;

public class Clima {
private String municipio, provincia;
private ArrayList<Dia> lista_dias;
public Clima(String municipio, String provincia, ArrayList<Dia> lista_dias) {
	super();
	this.municipio = municipio;
	this.provincia = provincia;
	this.lista_dias = lista_dias;
}
public String getMunicipio() {
	return municipio;
}
public String getProvincia() {
	return provincia;
}
public ArrayList<Dia> getLista_dias() {
	return lista_dias;
}

}
