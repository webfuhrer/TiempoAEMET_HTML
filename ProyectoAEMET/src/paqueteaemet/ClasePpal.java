package paqueteaemet;

public class ClasePpal {

	public static void main(String[] args) {
		Clima clima=AccesoFichero.leerFichero();
		String html=EntradaSalida.pintarHTML(clima);
		System.out.println(html);
		AccesoFichero.grabarFicheroHTML(html);
	}

}
