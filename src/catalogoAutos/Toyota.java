package catalogoAutos;

public class Toyota extends Automovil{
	private String modelo;
	private String numeroPasajeros;
	private String numeroBolsasA;
	private String anio;
	private String motor;
	private String precio;
	
	//Getters y Setters
	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
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


	public String getAnio() {
		return anio;
	}


	public void setAnio(String anio) {
		this.anio = anio;
	}


	public String getMotor() {
		return motor;
	}


	public void setMotor(String motor) {
		this.motor = motor;
	}


	public String getPrecio() {
		return precio;
	}


	public void setPrecio(String precio) {
		this.precio = precio;
	}


	public Toyota(String marca, String nombre, String tipo, String imagenAuto, String modelo,
			String numeroPasajeros, String numeroBolsasA, String anio,
			String motor, String precio) {
		super(marca, nombre, tipo, imagenAuto);
		this.modelo = modelo;
		this.numeroPasajeros = numeroPasajeros;
		this.numeroBolsasA = numeroBolsasA;
		this.anio = anio;
		this.motor = motor;
		this.precio = precio;
	}
	
	public Toyota() {
		
	}


	@Override
	public String mostrarInformacion() {
		 //Se  crea el contenido HTML específico para Renault
        String contenidoHTML = "<html>" +
        		"<h1 style=\"font-size: 13px; color: #007bff; font-weight: bold;\">Información de Toyota</h1>" +
        		"<p> Nombre: "+ getNombre() + "</p>" +
                "<p> Tipo: "+getTipo() + "</p>" +
                "<p> Modelo: "+getModelo() + "</p>" +
                "<p> Numero de Pasajeros: "+getNumeroPasajeros() + "</p>" +
                "<p> Numero de Bolsas de Aire: "+ getNumeroBolsasA() + "</p>" +
                "<p> Año: "+getAnio() + "</p>" +
                "<p> Motor: "+getMotor() + "</p>" +
                "<p> Precio: "+ getPrecio() + "</p>" +
                "</html>";

        return contenidoHTML;
		
	}
}
