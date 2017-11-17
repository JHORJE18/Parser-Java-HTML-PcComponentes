
public class Articulo {
	
	//Variables
	String nombre;
	float precio_actual;
	float precio_anterior;
	float ahorro;
	
	public Articulo(String nombre, String precio_actual, String precio_anterior) {
		super();
		this.nombre = nombre;
		this.precio_actual = limpiarCifras(precio_actual);
		this.precio_anterior = limpiarCifras(precio_anterior);
		this.ahorro = this.precio_anterior - this.precio_actual;
	}
	
	//Limpia el formato de los precios
	private float limpiarCifras(String cadena) {
		String aRemplazar = cadena;
		String remplazado = aRemplazar.replace("€", "");	//Eliminamos simbolo Euro
		String separado = remplazado.replace(",", ".");	//Cambiamos , x .
		float valor = 0f;
		try {
			valor = Float.parseFloat(separado);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return valor;
	}

	public String imprimir() {
		String datos = "";
		datos += ("Nombre: " + this.nombre + "\n");
		datos += ("Coste original: " + String.format("%.2f", this.precio_anterior) + " € \n");
		datos += ("Oferta: " + String.format("%.2f", this.precio_actual) + " € \n");
		datos += ("Ahorras: " + String.format("%.2f", this.ahorro) + " €");
		
		return datos;
	}
}