package paqueteaemet;

public class EstadoCielo {
private String periodo, descripcion,numero;

public EstadoCielo(String periodo, String descripcion, String numero) {
	super();
	this.periodo = periodo;
	this.descripcion = descripcion;
	this.numero = numero;
}

public String getPeriodo() {
	return periodo;
}

public String getDescripcion() {
	return descripcion;
}

public String getNumero() {
	return numero;
}

}
