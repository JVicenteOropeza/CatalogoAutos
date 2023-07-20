package catalogoAutos;

public class Renault extends Automovil {
	private String modelo;
	private String anio;
	private String numeroPasajeros;
	private String numeroBolsasA;
	private String pantalla;
	private String frenos;
	private String precio;
	
	//Getters y Setters
	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getAnio() {
		return anio;
	}


	public void setAnio(String anio) {
		this.anio = anio;
	}


	public String getNumeroPasajeros() {
		return numeroPasajeros;
	}


	public void setNumeroPasajeros(String numeroPasajeros) {
		this.numeroPasajeros = numeroPasajeros;
	}


	public String getNumeroBolsasA() {
		return numeroBolsasA;
	}


	public void setNumeroBolsasA(String numeroBolsasA) {
		this.numeroBolsasA = numeroBolsasA;
	}


	public String getPantalla() {
		return pantalla;
	}


	public void setPantalla(String pantalla) {
		this.pantalla = pantalla;
	}


	public String getFrenos() {
		return frenos;
	}


	public void setFrenos(String frenos) {
		this.frenos = frenos;
	}


	public String getPrecio() {
		return precio;
	}


	public void setPrecio(String precio) {
		this.precio = precio;
	}


	public Renault(String marca, String nombre, String tipo, String imagenAuto, String modelo,
			String anio, String numeroPasajeros, String numeroBolsasA, String pantalla,
			String frenos, String precio) {
		super(marca, nombre, tipo, imagenAuto);
		this.modelo = modelo;
		this.anio = anio;
		this.numeroPasajeros = numeroPasajeros;
		this.numeroBolsasA = numeroBolsasA;
		this.pantalla = pantalla;
		this.frenos = frenos;
		this.precio = precio;
	}
	
	public Renault() {
		
	}


	@Override
	public String mostrarInformacion() {		
		 //Se  crea el contenido HTML específico para Renault
		String contenidoHTML = "<html>" +
	            "<h1 style=\"font-size: 13px; color: #007bff; font-weight: bold;\">Información de Renault</h1>" +
	            "<p>Nombre: " + getNombre() + "</p>" +
	            "<p>Tipo: " + getTipo() + "</p>" +
	            "<p>Modelo: " + getModelo() + "</p>" +
	            "<p>Año: " + getAnio() + "</p>" +
	            "<p>Número de Pasajeros: " + getNumeroPasajeros() + "</p>" +
	            "<p>Número de Bolsas de Aire: " + getNumeroBolsasA() + "</p>" +
	            "<p>Pantalla: " + getPantalla() + "</p>" +
	            "<p>Frenos: " + getFrenos() + "</p>" +
	            "<p>Precio: " + getPrecio() + "</p>" +
	            "</html>";

        return contenidoHTML;
    }
	
		
}
