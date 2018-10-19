package paqueteaemet;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class AccesoFichero {
static String ruta_fichero="D:\\tiempo\\localidad_28079.xml";

public static Clima leerFichero() {
	Clima c=null;
	SAXBuilder saxBuilder = new SAXBuilder();
	ArrayList<Dia> lista_objetos_dia=new ArrayList<>();
    try {
		Document document = saxBuilder.build(new File(ruta_fichero));
		Element raiz=document.getRootElement();
		Element municipio=raiz.getChild("nombre");
		String nombre_municipio=municipio.getValue();
		Element provincia=raiz.getChild("provincia");
		String nombre_provincia=provincia.getValue();
		Element prediccion=raiz.getChild("prediccion");
		List<Element> lista_elementos_dia=prediccion.getChildren("dia");
		for (int i=0; i<lista_elementos_dia.size();i++)
		{
			Element elemento_dia=lista_elementos_dia.get(i);
			Attribute atributo_fecha=elemento_dia.getAttribute("fecha");
			String fecha=atributo_fecha.getValue();
			System.out.println(fecha);
			List<Element> lista_elementos_estado_cielo=elemento_dia.getChildren("estado_cielo");
			ArrayList<EstadoCielo> lista_estado_cielo=obtenerEstadosCielo(lista_elementos_estado_cielo);
			int t_minima=Integer.parseInt(elemento_dia.getChild("temperatura").getChild("minima").getValue());
			int t_maxima=Integer.parseInt(elemento_dia.getChild("temperatura").getChild("maxima").getValue());
			Dia d=new Dia(fecha, lista_estado_cielo, t_minima, t_maxima);
			lista_objetos_dia.add(d);
		}
		c=new Clima(nombre_municipio, nombre_provincia, lista_objetos_dia);
		
    } catch (JDOMException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
	return c;
}

private static ArrayList<EstadoCielo> obtenerEstadosCielo(List<Element> lista_elementos_estado_cielo) {
	ArrayList<EstadoCielo> lista_estados_cielo=new ArrayList();
	for (int i=0; i<lista_elementos_estado_cielo.size(); i++)
	{
		String periodo="";String descripcion="";
		Element elemento_cielo=lista_elementos_estado_cielo.get(i);
		Attribute atributo_periodo=elemento_cielo.getAttribute("periodo");
		if (atributo_periodo!=null)
		{
		periodo=atributo_periodo.getValue();
		}
		Attribute atributo_descripcion=elemento_cielo.getAttribute("descripcion");
		if (atributo_descripcion!=null)
		{
			descripcion=atributo_descripcion.getValue();
		}
		
		String numero=elemento_cielo.getText();
		EstadoCielo e=new EstadoCielo(periodo, descripcion, numero);
		System.out.println(periodo+", "+descripcion+", "+numero);
		lista_estados_cielo.add(e);
		
	}
	
	
	
	return lista_estados_cielo;
}

public static void grabarFicheroHTML(String html)
{
	try {
		FileWriter fw=new FileWriter(ruta_fichero+".html");
		fw.write(html);
		fw.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
}
