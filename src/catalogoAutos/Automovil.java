package catalogoAutos;


abstract class Automovil {
	private String marca;
	private String nombre;
	private String tipo;
	private String imagenAuto;
	
	//Gettter y Setters
	public String getNombre() {
		return nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getImagenAuto() {
		return imagenAuto;
	}

	public void setImagenAuto(String imagenAuto) {
		this.imagenAuto = imagenAuto;
	}

	//Contructor 1
	public Automovil(String marca, String nombre, String tipo, String imagenAuto) {
		this.marca = marca;
		this.nombre = nombre;
		this.tipo = tipo;
		this.imagenAuto = imagenAuto;
	}
	
	//Constructor 2
	public Automovil() {
		
	}
	
	public abstract String mostrarInformacion();

}
