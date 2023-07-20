package catalogoAutos;

public class CreacionCatalogoAutos {

	//Creación de los Autos por Marca ya que las Marcas son las que heredan de Automovil
	public static Automovil[] crearCatalogo() {
		//Sección RENAULT
		//Elctricos
		Automovil renaultE_1 = new Renault("Renault", "Kangoo", "Eléctricos","images/renault/electricos/kangooElectricos.png", "E-TECH",
				"2023","5 personas", "2 Frontales", "NO integrada","ABS", "$768,900");
		//Particulares
		Automovil renaultP_1 = new Renault("Renault", "Duster", "Particulares","images/renault/paticulares/duster2Particulares.png", "DUSTER",
				"2023","5 personas", "2 Frontales", "Pantalla 8\"","ABS", "$379,300");
		Automovil renaultP_2 = new Renault("Renault", "Kwid", "Particulares","images/renault/paticulares/kwidParticulares.png", "ETSILO SUV",
				"2023","5 personas", "2 Frontales/2 Laterales", "Pantalla táctil 8\" cob radio MP3","ABS", "$230,100");
		Automovil renaultP_3 = new Renault("Renault", "Logan", "Particulares","images/renault/paticulares/loganParticulares.png", "Familiar",
				"2023","5 personas", "2 Frontales/2 Laterales", "Pantalla táctil 7\" con Applre CarPlay","ABS", "$319,000");
		Automovil renaultP_4 = new Renault("Renault", "Stepway", "Particulares","images/renault/paticulares/stepwayParticulares.png", "Familiar",
				"2023","5 personas", "2 Frontales/2 Laterales", "Pantalla táctil 7\" con Apple CarPlay","ABS", "$354,300");
		//Utilitarios
		Automovil renaultU_1 = new Renault("Renault", "Kangoo-Utilitario", "Utilitarios","images/renault/utilitarios/kangooUtilitarios.png", "Carga",
				"2023","2 personas", "2 Frontales", "NO integrada","ABS", "$338,900");
		Automovil renaultU_2 = new Renault("Renault", "Oroch-Utilitario", "Utilitarios","images/renault/utilitarios/orochUtilitarios.png", "Carga",
				"2023","5 personas", "2 Frontales", "Pantalla táctil 8\" con Apple CardPlay","ABS", "$375,000");
		
		//Sección Toyota
		//Autos
		Automovil toyotaA_1 = new Toyota("Toyota", "Corolla", "Familiares", "images/toyota/autos/CorollaAutosToyota.png", "Base CVT",
				"5 personas", "6 Bolsas", "2023", "2 Litros con 169 HP", "$410,900");
		Automovil toyotaA_2 = new Toyota("Toyota", "Camry", "Familiares", "images/toyota/autos/MenuCamryAutosToyota.png", "LE CVT",
				"5 personas", "10 Bolsas", "2023", "2.5 Litros con 201 HP", "$558,200");
		Automovil toyotaA_3 = new Toyota("Toyota", "Yaris", "Familiares", "images/toyota/autos/yarisAutosToyota.png", "Base MT",
				"5 personas", "6 Bolsas", "2023", "1.5 Litros con 105 HP", "$307,900");
		//Hibridos
		Automovil toyotaH_1 = new Toyota("Toyota", "Corolla-Híbrido", "Híbrido", "images/toyota/hibrido/CorollaHibridoToyota.png", "HEV LE HV",
				"5 personas", "10 Bolsas", "2023", "1.8 Litros Dual 97 HP", "$490,900");
		Automovil toyotaH_2 = new Toyota("Toyota", "Highlander", "Híbrido", "images/toyota/hibrido/HighlanderHibridoToyota.png", "LE HEV",
				"8 personas", "8 Bolsas", "2023", "2.5 Litros con 235 HP", "$865,900");
		Automovil toyotaH_3 = new Toyota("Toyota", "RAV4", "Híbrido", "images/toyota/hibrido/RAV04Hibridopng.png", "LTD HV",
				"8 personas", "7 Bolsas", "2023", "2.5 Litros con 176 HP", "$773,700");
		Automovil toyotaH_4 = new Toyota("Toyota", "Tundra", "Híbrido", "images/toyota/hibrido/tundraHibrido.png", "LIMITED",
				"5 personas", "8 Bolsas", "2023", "3.5 Litros con 437 HP", "$1,342,300");
		//Minivan
		Automovil toyotaM_1 = new Toyota("Toyota", "Sienna", "Minivan", "images/toyota/minivan/sinnaMinivan.png", "HEV XLE",
				"7/8 personas", "10 Bolsas", "2023", "2.5 Litros", "$873,400");
		//Pickup
		Automovil toyotaP_1 = new Toyota("Toyota", "Hilux", "Pick Up", "images/toyota/pickup/HiluxPickup.png", "Base",
				"5 personas", "7 Bolsas", "2023", "2.7 Litros con 166 HP", "$514,000");
		//SUV
		Automovil toyotaS_1 = new Toyota("Toyota", "Hiace", "SUV", "images/toyota/suv/HiaceSUV.png", "Ventana Superlarga",
				"12 personas", "3 Bolsas", "2023", "3.5 Litros con 277 HP", "$625,300");
		Automovil toyotaS_2 = new Toyota("Toyota", "Raize", "SUV", "images/toyota/suv/RaizeSUV.png", "XLE MT",
				"5 personas", "6 Bolsas", "2023", "1 Litros con 97 HP", "$356,000");
		
		//Seccion Volkswagen
		//Camionetas
		Automovil volkswagenC_1 = new Volkswagen("Volkswagen", "Cross Sport", "Camioneta", "images/volkswagen/camionetas/crossSportCamioneta.png", 
				"R-Line", "2023", "5 personas", "6 Bolsas", "3.6 L V6", "Tiptronic 8", "280 HP", "361 Nm", "$1,116,990");
		Automovil volkswagenC_2 = new Volkswagen("Volkswagen", "Teramont", "Camioneta", "images/volkswagen/camionetas/teramontCamioneta.png", 
				"Trendline", "2023", "7/6 personas", "6 Bolsas", "2.5 L V4","Tiptronic 8", "238 HP", "350 Nm", "$889,990");
		//Deportivo
		Automovil volkswagenD_1 = new Volkswagen("Volkswagen", "Jetta GLI", "Deportivo", "images/volkswagen/deportivos/jettaGLIDeportivos.png", "GLI",
				"2023", "5 personas", "6 Bolsas", "2.0 L TSI",
				"DSG 7", "230 HP", "250 Nm", "$619,990");
		//Familiares
		Automovil volkswagenF_1 = new Volkswagen("Volkswagen", "Jetta", "Familiares", "images/volkswagen/familiares/jettaFamiliares.png", "Sportline",
				"2023", "5 personas", "6 Bolsas", "1.4 L TSI", "Manual 6 - TipTronic 6", "150 HP", "250 Nm", "$534,990");
		Automovil volkswagenF_2 = new Volkswagen("Volkswagen", "Virtus", "Familiares", "images/volkswagen/familiares/vitusFamiliares.png", "Highline",
				"2023", "5 personas", "6 Bolsas", "1.6 L - 1.0 L TSI", "Manual 5 - Tiptronic 6", "114 HP", "178 Nm", "$431,490");
		//Pickup
		Automovil volkswagenP_1 = new Volkswagen("Volkswagen", "Saveiro", "Pick Up", "images/volkswagen/pickup/saveiroPickup.png", "Robust",
				"2023", "2 personas", "2 Bolsas", "1.6 L", "Manual 5", "101 HP", "143 Nm", "$297,490");
		//SUV
		Automovil volkswagenS_1 = new Volkswagen("Volkswagen", "Nivus", "SUV", "images/volkswagen/suv/nivusSUV.png", "Black",
				"2023", "5 personas", "6 Bolsas", "1.0 L TSI", "Tiptronic 6", "114 HP", "200 Nm", "$459,664");
		Automovil volkswagenS_2 = new Volkswagen("Volkswagen", "Taigun", "SUV", "images/volkswagen/suv/taigunSUV.png", "Highline",
				"2023", "5 peersonas", "6 Bolsas", "1.0 L TSI", "Tiptronic 6", "114 HP", "178 Nm", "$488,990");
		Automovil volkswagenS_3 = new Volkswagen("Volkswagen", "T-Cross", "SUV", "images/volkswagen/suv/tCrossSUV.png", "Trendline",
				"2023", "5 personas", "6 Bolsas", "1.0 L", "Tiptronic 6", "110 HP", "155 Nm", "$427,504");
		
		//Se crea el Array para crear el Catálago
		Automovil[] catalogoCargado = {renaultE_1, renaultP_1, renaultP_2, renaultP_3, renaultP_4, renaultU_1, renaultU_2, 
				toyotaA_1, toyotaA_2, toyotaA_3, toyotaH_1, toyotaH_2, toyotaH_3, toyotaH_4, toyotaM_1, toyotaP_1, toyotaS_1, toyotaS_2, 
				volkswagenC_1, volkswagenC_2, volkswagenD_1, volkswagenF_1, volkswagenF_2, volkswagenP_1, volkswagenS_1, volkswagenS_2, volkswagenS_3};
		
		
		return catalogoCargado;
	}
	
	
}
