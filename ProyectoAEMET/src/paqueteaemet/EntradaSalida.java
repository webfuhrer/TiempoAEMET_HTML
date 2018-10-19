package paqueteaemet;

import java.util.ArrayList;

public class EntradaSalida {

	public static String pintarHTML(Clima clima) {
		String html="";
		html+="<html><head>"
				+ "<style>"+
				"table{width: 100%}"
				+ ".tabla_padre"
				+ "{border: 1px solid, blue ; background-color: #cCcCcC}"
				+".tabla_hija"
				+ "{border: 1px solid, black ; background-color: #DFdFdF}"
				+"</style>"
				+ "<title> Tiempo de "+clima.getMunicipio()+"</title>";
		html+="<table class='tabla_padre'><tr><th>Fecha</th><th>T. mín</th><th>T. máx.</th><th>Cielo</th></tr>";
		for (int i=0; i<clima.getLista_dias().size(); i++)
		{
			Dia d=clima.getLista_dias().get(i);
			html+="<tr><td>"+d.getFecha()+"</td><td>"+d.getT_minima()+
					"</td><td>"+d.getT_maxima()+
					"</td><td>"+tablaEstadosCielo(d.getEstados_cielo())+"</td></tr>";
		}
		html+="</table>";
		html+="</body></html>";
		return html;
	}

	private static String tablaEstadosCielo(ArrayList<EstadoCielo> estados_cielo) {
		String tabla_estados_cielo="<table class='tabla_hija'>";
		for (int i=0; i<estados_cielo.size(); i++)
		{
			EstadoCielo e=estados_cielo.get(i);
			String numero=e.getNumero();
			tabla_estados_cielo+="<tr><td>"+e.getPeriodo()+"</td>";
				if (numero!="")
				{
					tabla_estados_cielo+="<td><img title='"+e.getDescripcion()+"' src='http://www.aemet.es/imagenes/png/estado_cielo/"+e.getNumero()+"_g.png'></td></tr>";
				}
				else
				{
					tabla_estados_cielo+="<td>&nbsp;</td>";
				}
			}
		tabla_estados_cielo+="</table>";		
	return tabla_estados_cielo;
	}
	

}
