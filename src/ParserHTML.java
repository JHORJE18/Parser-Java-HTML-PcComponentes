import java.io.File;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ParserHTML {
	
	public static void main(String [] args) {
		
		Document doc = null;
		String enlace = "https://www.pccomponentes.com/ofertas-especiales";
		
		System.out.println("Cargando Web: " + enlace + "\n" + limpiarln());
		try{
			doc = Jsoup.connect(enlace).get();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//Mostrar titulo Web
		String title = doc.title();
		System.out.println("Titulo " + title);
		
		Elements numArticulos = doc.getElementsByClass("tarjeta-articulo__elementos-basicos");
		System.out.println("Hay un total de " + numArticulos.size() + " articulos de oferta");
		
		for (int i=0; i<numArticulos.size(); i++) {
			//Revisa cada articulo
			String nombre = null;
			String precio_actual = null;
			String precio_anterior = null;
			
			try {
				nombre = numArticulos.get(i).getElementsByTag("a").get(0).text();
				precio_actual = numArticulos.get(i).getElementsByClass("tarjeta-articulo__precio-actual").text();
				precio_anterior = numArticulos.get(i).getElementsByClass("tarjeta-articulo__pvp").get(0).text();
			}catch (Exception e) {
				// TODO: handle exception
				nombre = "No localizado";
				precio_actual = "No localizado";
				precio_anterior = "No localizado";
			}
			
			//Creamos articulo
			Articulo newArtc = new Articulo(nombre, precio_actual, precio_anterior);
			
			//Imprimir datos
			System.out.println(limpiarln());
			System.out.println("Articulo Nº" + (i+1));
			System.out.println(newArtc.imprimir());
			System.out.println(limpiarln());
		}
		
		System.out.println("Gracias por usar esta app");
	}
	
	public static String limpiarln(){
		String linea = "";
		for (int i=0; i<20; i++) {
			linea += "-";
		}
		return linea;
	}

}
