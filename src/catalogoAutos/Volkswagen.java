package catalogoAutos;

public class Volkswagen extends Automovil{
	private String modelo;
	private String anio;
	private String numeroPasajeros;
	private String numeroBolsasA;
	private String motor;
	private String transmision;
	private String potencia;
	private String torque;
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

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public String getTransmision() {
		return transmision;
	}

	public void setTransmision(String transmision) {
		this.transmision = transmision;
	}

	public String getPotencia() {
		return potencia;
	}

	public void setPotencia(String potencia) {
		this.potencia = potencia;
	}

	public String getTorque() {
		return torque;
	}

	public void setTorque(String torque) {
		this.torque = torque;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	//Constructor 1
	public Volkswagen(String marca, String nombre, String tipo, String imagenAuto, String modelo,
			String anio, String numeroPasajeros, String numeroBolsasA, String motor,
			String transmision, String potencia, String torque, String precio) {
		super(marca, nombre, tipo, imagenAuto);
		this.modelo = modelo;
		this.anio = anio;
		this.numeroPasajeros = numeroPasajeros;
		this.numeroBolsasA = numeroBolsasA;
		this.motor = motor;
		this.transmision = transmision;
		this.potencia = potencia;
		this.torque = torque;
		this.precio = precio;
	}
	
	public Volkswagen() {
		
	}
	
	@Override
	public String mostrarInformacion() {
		String contenidoHTML = "<html>" +
				"<h1 style=\"font-size: 13px; color: #007bff; font-weight: bold;\">Información de Volkswagen</h1>" +
        		"<p> Nombre: "+ getNombre() + "</p>" +
                "<p> Tipo: "+getTipo() + "</p>" +
                "<p> Modelo: "+getModelo() + "</p>" +
                "<p> Año: "+getAnio() + "</p>" +
                "<p> Numero de Pasajeros: "+getNumeroPasajeros() + "</p>" +
                "<p> Numero de Bolsas de Aire: "+ getNumeroBolsasA() + "</p>" +
                "<p> Motor: "+ getMotor() + "</p>" +
                "<p> Transmisión: "+ getTransmision() + "</p>" +
                "<p> Potencia: "+ getPotencia() + "</p>" +
                "<p> Torque: "+ getTorque() + "</p>" +
                "<p> Precio: "+ getPrecio() + "</p>" +
                "</html>";

        return contenidoHTML;
		
	}

	
}
