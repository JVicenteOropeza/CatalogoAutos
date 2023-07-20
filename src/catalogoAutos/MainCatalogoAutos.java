package catalogoAutos;

import java.awt.EventQueue;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class MainCatalogoAutos extends JFrame implements ActionListener, OnGuardarListener {

	private FondoCat panelCat;
	private JComboBox comCatalogoGeneral, comCatMarca, comCatTipo;
	private JLabel lblDespliegueImage;
	private JButton btnBuscar, btnMasInfo;
	private JEditorPane editorInfo;
	private Image fondo;
	private JLabel lblTituloCatBuscar;
	private JLabel lblTituloBuscarMarcaTipo;
	private JButton btnAgregar;
	private Automovil[] catalogoAutos;
    private Automovil encontrado; 
    private List<Automovil> marcaTipoEncontrada;
    private JScrollPane scrollPane;
    private JLabel lblMostrarPrecio;
    private String marcaSelec;
    private String tipoSelec;
    private JList listBuscar;
    private Automovil agragadoJFA;

	/**
	 * Despliegue de la aplicación
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainCatalogoAutos frame = new MainCatalogoAutos();
					//JFAgregarNuevo ventana = nre JFAgregarNuevo();
					//ventana.setVisible(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Se crea el Frame
	 */
	public MainCatalogoAutos() {
		
		setTitle("Catálogo Automoviles JVOS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 738, 509);
		panelCat = new FondoCat("images/general/fondoCat.jpg");
		panelCat.setBackground(new Color(64, 128, 128));
		panelCat.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));

		setContentPane(panelCat);
		panelCat.setLayout(null);
		iniciarComponentes();
		
		//Se carga el catálago General
		cargaCatalogoGeneral();
	}
	
	//Se inicializan los componentes
	private void iniciarComponentes() {
		
		//Labels
		lblDespliegueImage = new JLabel("");
		lblDespliegueImage.setBounds(10, 78, 303, 192);
		panelCat.add(lblDespliegueImage);
		//Botones
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(530, 193, 162, 22);
		btnBuscar.setEnabled(false);
		btnBuscar.addActionListener(this);
		panelCat.add(btnBuscar);
		//ComboBox
		comCatalogoGeneral = new JComboBox();
		comCatalogoGeneral.setBounds(121, 45, 192, 22);
		comCatalogoGeneral.addActionListener(this);
		panelCat.add(comCatalogoGeneral);
		
		comCatMarca = new JComboBox();
		comCatMarca.setModel(new DefaultComboBoxModel(new String[] {"Renault", "Toyota", "Volkswagen"}));
		comCatMarca.setBounds(530, 76, 162, 22);
		comCatMarca.addActionListener(this);
		panelCat.add(comCatMarca);
		
		comCatTipo = new JComboBox();
		comCatTipo.setBounds(530, 140, 162, 22);
		comCatTipo.setEnabled(false);
		comCatTipo.addActionListener(this);
		panelCat.add(comCatTipo);
		
		JLabel lblCatAutos = new JLabel("Catálogo de Autos:");
		lblCatAutos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCatAutos.setForeground(new Color(255, 255, 255));
		lblCatAutos.setBounds(10, 41, 114, 31);
		panelCat.add(lblCatAutos);
		
		JLabel lblMarca = new JLabel("MARCA");
		lblMarca.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMarca.setForeground(new Color(255, 255, 255));
		lblMarca.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarca.setBounds(530, 45, 162, 22);
		panelCat.add(lblMarca);
		
		JLabel lblTipoAuto = new JLabel("TIPO");
		lblTipoAuto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTipoAuto.setForeground(new Color(255, 255, 255));
		lblTipoAuto.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoAuto.setBounds(530, 109, 162, 22);
		panelCat.add(lblTipoAuto);
		
		btnMasInfo = new JButton("Información");
		btnMasInfo.setBounds(10, 285, 124, 22);
		btnMasInfo.setEnabled(false);
		btnMasInfo.addActionListener(this);
		panelCat.add(btnMasInfo);
	    
	    scrollPane = new JScrollPane();
	    scrollPane.setBounds(10, 321, 430, 138);
	    panelCat.add(scrollPane);
	    
	    editorInfo = new JEditorPane();
	    scrollPane.setViewportView(editorInfo);
	    editorInfo.setFont(new Font("Times New Roman", Font.PLAIN, 12));
	    editorInfo.setEditable(false);
	    editorInfo.setContentType("text/html");
	    editorInfo.setCaretPosition(0);
	    Dimension tamanioPreferido = editorInfo.getPreferredSize();
	    editorInfo.setPreferredSize(tamanioPreferido);
	    editorInfo.setEnabled(false);
		
		lblTituloCatBuscar = new JLabel("BUSCAR EN EL CATÁLOGO");
		lblTituloCatBuscar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblTituloCatBuscar.setForeground(new Color(255, 255, 255));
		lblTituloCatBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloCatBuscar.setBounds(10, 11, 303, 31);
		panelCat.add(lblTituloCatBuscar);
		
		lblTituloBuscarMarcaTipo = new JLabel("BUSCAR POR");
		lblTituloBuscarMarcaTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloBuscarMarcaTipo.setForeground(Color.WHITE);
		lblTituloBuscarMarcaTipo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblTituloBuscarMarcaTipo.setBounds(530, 11, 162, 31);
		panelCat.add(lblTituloBuscarMarcaTipo);
		
		btnAgregar = new JButton("Agregar Nuevo");
		btnAgregar.setBounds(560, 420, 132, 39);
		btnAgregar.addActionListener(this);
		panelCat.add(btnAgregar);
		
		lblMostrarPrecio = new JLabel("Precio: ");
		lblMostrarPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMostrarPrecio.setForeground(new Color(255, 255, 255));
		lblMostrarPrecio.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMostrarPrecio.setBounds(138, 275, 175, 39);
		panelCat.add(lblMostrarPrecio);
		
		listBuscar = new JList();
		listBuscar.setBounds(530, 240, 162, 149);
		listBuscar.setEnabled(false);
		panelCat.add(listBuscar);
		listBuscar.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	            if (e.getClickCount() == 2) {
	            	editorInfo.setEnabled(true);
	                int index = listBuscar.locationToIndex(e.getPoint());
	                if (index >= 0) {
	                    String selectedItem = (String) listBuscar.getModel().getElementAt(index);
	                    // Aquí puedes realizar alguna acción con el elemento seleccionado en el JList
	                    System.out.println("Elemento seleccionado en el JList: " + selectedItem);
	                    String[] buscando = selectedItem.split(" ");
	                    String nombreBuscarPor = buscando[0];
	                    encontrado = buscarNombre(nombreBuscarPor);
	                    
	                    if(marcaTipoEncontrada != null) {
	                    	String verImagen = encontrado.getImagenAuto().trim();
	                    	ImageIcon imagenB = new ImageIcon(verImagen);
	                    	lblDespliegueImage.setIcon(imagenB);
	                    	
	                    	if(encontrado.getMarca().equals("Renault")) {
	                        	lblMostrarPrecio.setText("Precio: "+((Renault)encontrado).getPrecio());
	                        }else if(encontrado.getMarca().equals("Toyota")) {
	                        	lblMostrarPrecio.setText("Precio: "+((Toyota)encontrado).getPrecio());
	                        }else if(encontrado.getMarca().equals("Volkswagen")) {
	                        	lblMostrarPrecio.setText("Precio: "+((Volkswagen)encontrado).getPrecio());
	                        }else {
	                        	lblMostrarPrecio.setText("Precio: $000,00");
	                        }
	                    	String infoHTMLB = encontrado.mostrarInformacion();
	                        // Agregar estilo CSS para ajustar el texto al área del JEditorPane
	                        editorInfo.setText(infoHTMLB);
	                    	
	                    }
	                    
	                }
	            }
	        }
	    });
		
	}
	//Método para cargar el catalgo general
	private void cargaCatalogoGeneral() {
		//Aquí tenemos nuestro array de autos
		catalogoAutos = CreacionCatalogoAutos.crearCatalogo();
		
		List<String> nombresAuto = new ArrayList<>();
		
		for(Automovil auto: catalogoAutos) {
			nombresAuto.add(auto.getNombre());
		}
		
		String[] arregloNombresAutos = nombresAuto.toArray(new String[0]);
		DefaultComboBoxModel<String> catalogoGeneralModel = new DefaultComboBoxModel<>(arregloNombresAutos);
		comCatalogoGeneral.setModel(catalogoGeneralModel);
	}
	
	private Automovil buscarNombre(String nombre) {
		for(Automovil auto : catalogoAutos) {
			if(auto.getNombre().equals(nombre)) {
				return auto;
			}
		}
		return null;
	}
	
	private List<Automovil> buscarMarcaTipo(String marca, String tipo) {
		List<Automovil> listaMarcaTipo = new ArrayList<>();
		for(Automovil auto : catalogoAutos) {
			if(auto.getMarca().equals(marca) && auto.getTipo().equals(tipo)) {
				listaMarcaTipo.add(auto);
				System.out.println("Auto: -->"+ auto.getNombre()+ " "+auto.getTipo());
			}	
		}
		return listaMarcaTipo;
	}
	
	public Automovil[] sobrescrituraCatalogoAutos(Automovil[] catalogoAutos, Automovil agregadoJFA) {
		int tamOriginal = catalogoAutos.length;
		int tamNuevo = tamOriginal + 1;
		
		Automovil[] tempCatalogoAutos = Arrays.copyOf(catalogoAutos, tamNuevo);
		tempCatalogoAutos[tamNuevo - 1] = agregadoJFA;
		
		return tempCatalogoAutos;
	}
	
	//@Override
    public void onGuardar(Automovil nuevoAgregado) {
        // Agregar el nuevo automóvil al catálogo actual
    	
        catalogoAutos = sobrescrituraCatalogoAutos(catalogoAutos, nuevoAgregado);
        cargaCatalogoGeneral();
    }

	@Override
	public void actionPerformed(ActionEvent e) {

        
        if(e.getSource() == comCatalogoGeneral) {
        	String seleccionCatGen = comCatalogoGeneral.getSelectedItem().toString();
        	System.out.println("Lo que hizo el catGn---> "+seleccionCatGen);
        	
        	btnMasInfo.setEnabled(true);
        	comCatTipo.setEnabled(false);
        	btnBuscar.setEnabled(false);
        	listBuscar.setEnabled(true);
        	
        	encontrado = buscarNombre(seleccionCatGen);
        	
        	if(encontrado != null) {
        		
        		String dirImage = encontrado.getImagenAuto().trim();
        		ImageIcon imagenAuto = new ImageIcon(dirImage);
        		
        		Image img = imagenAuto.getImage();
        	    Image imgEscalada = img.getScaledInstance(lblDespliegueImage.getWidth(), lblDespliegueImage.getHeight(), Image.SCALE_SMOOTH);
        	    ImageIcon imagenFotrmatoLbl = new ImageIcon(imgEscalada);
        		
        		System.out.println("Iamgen --> "+dirImage);
        		lblDespliegueImage.setIcon(imagenFotrmatoLbl);
        		
        	}else {
        		lblDespliegueImage.setIcon(null);
                lblDespliegueImage.setText("Imagen no disponible");
        	}
        //Evento para buscar por Marca y Tipo	
        }else if(e.getSource() == comCatMarca){
        	String seleccionCatMarca = comCatMarca.getSelectedItem().toString();
        	System.out.println("Lo que hizo el catGn---> "+seleccionCatMarca);
        	
        	
        	comCatTipo.setEnabled(true);
        	btnMasInfo.setEnabled(false);
        	
        	marcaSelec = comCatMarca.getSelectedItem().toString().trim();
        	
        	if(seleccionCatMarca == "Renault") {
        		
        		comCatTipo.setModel(new DefaultComboBoxModel(new String[] {"Eléctricos","Particulares","Utilitarios"}));
        	}
        	if(seleccionCatMarca == "Toyota") {
        		
        		comCatTipo.setModel(new DefaultComboBoxModel(new String[] {"Familiares","Híbrido","Minivan", "Pick Up", "SUV"}));
        	}
        	if(seleccionCatMarca == "Volkswagen") {
        		
        		comCatTipo.setModel(new DefaultComboBoxModel(new String[] {"Camioneta","Deportivo","Familiares", "Pick Up", "SUV"}));
        	}
        	
        }else if(e.getSource() == comCatTipo){
        	
        	btnBuscar.setEnabled(true);
        	tipoSelec = comCatTipo.getSelectedItem().toString().trim();
        	
        }else if(e.getSource() == btnMasInfo) {
        	
        	
        	editorInfo.setEnabled(true);
        	 String infoHTML = encontrado.mostrarInformacion();
             // Agregar estilo CSS para ajustar el texto al área del JEditorPane
             editorInfo.setText(infoHTML);
             
            if(encontrado.getMarca().equals("Renault")) {
            	lblMostrarPrecio.setText("Precio: "+((Renault)encontrado).getPrecio());
            }else if(encontrado.getMarca().equals("Toyota")) {
            	lblMostrarPrecio.setText("Precio: "+((Toyota)encontrado).getPrecio());
            }else if(encontrado.getMarca().equals("Volkswagen")) {
            	lblMostrarPrecio.setText("Precio: "+((Volkswagen)encontrado).getPrecio());
            }else {
            	lblMostrarPrecio.setText("Precio: $000,00");
            }
             
        	
        }else if(e.getSource() == btnBuscar) {
        	String textBtnBuscar = ((JButton) e.getSource()).getText();
        	System.out.println("Lo que hizo el catGn---> "+textBtnBuscar);
        	System.out.println("Marca y Tipo---> "+marcaSelec+" "+tipoSelec);
        	
        	listBuscar.setEnabled(true);
        	
        	marcaTipoEncontrada = buscarMarcaTipo(marcaSelec, tipoSelec);
        	for(Automovil auto:marcaTipoEncontrada) {
        		System.out.println("El nombre: -->"+auto.getNombre());
        	}
        	
        	if(marcaTipoEncontrada != null) {
        		DefaultListModel<String> listModel = new DefaultListModel<>();
        		for(Automovil auto : marcaTipoEncontrada) {
        			listModel.addElement(auto.getNombre()+" "+auto.getMarca());
        		}
        		listBuscar.setModel(listModel);
        		
        	}else {
        		lblDespliegueImage.setIcon(null);
                lblDespliegueImage.setText("Imagen no disponible");
                
                listBuscar.setModel(new DefaultListModel<>());
        	}
        	
        	
        }else if(e.getSource() == btnAgregar) {
        	String textBtnAgregar = ((JButton) e.getSource()).getText();
        	System.out.println("Lo que hizo el catGn---> "+textBtnAgregar);
        	
        	JFAgregarNuevo ventanaAgregar = new JFAgregarNuevo();
            ventanaAgregar.setGuardarListener(this); // Asignar el listener
            ventanaAgregar.setVisible(true);
            agragadoJFA = ventanaAgregar.getNuevoAgregado();
            
            onGuardar(agragadoJFA);
            
        	
        }
	}
}

