package catalogoAutos;



import javax.swing.JFrame;

import javax.swing.border.BevelBorder;

import javax.swing.border.SoftBevelBorder;


import javax.swing.JLabel;

import javax.swing.JTextField;


import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.ComponentOrientation;



public class JFAgregarNuevo extends JFrame implements ActionListener{
	private JTextField textAgFieldNombre;
	private JTextField textAgFieldTipo;
	private JTextField textAgFieldPrecio;
	private FondoCat panelAgregar;
	private JButton btnAgGuardar;
	private JLabel lblAgConfirmacion;
	private JComboBox comboBoxAgMarca;
	private String marca, nombre, tipo, precio;
	private Automovil nuevo;
	public Automovil nuevoAgregado;
	private OnGuardarListener guardarListener;
	
	

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					JFAgregarNuevo frame = new JFAgregarNuevo();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public Automovil getNuevoAgregado() {
		return nuevoAgregado;
	}

	public void setNuevoAgregado(Automovil nuevoAgregado) {
		this.nuevoAgregado = nuevoAgregado;
	}

	/**
	 * Create the frame.
	 */
	public JFAgregarNuevo() {
		//panelAgregar = new FondoCat("images/general/fondoCat.jpg");
		getContentPane().setBackground(new Color(64, 128, 128));
		setTitle("Agregar Nuevo JVOS");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Cierra solo esta ventana (JFAgregarNuevo) al hacer clic en el botón de cerrar
                dispose();
            }
        });
		setBounds(100, 100, 640, 361);
		panelAgregar = new FondoCat("images/general/fondoCat.jpg");
		panelAgregar.setBackground(new Color(64, 128, 128));
		panelAgregar.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));

		
		
		setContentPane(panelAgregar);
		panelAgregar.setLayout(null);
		getContentPane().setLayout(null);
		
		JLabel lblAgMarca = new JLabel("Marca: ");
		lblAgMarca.setForeground(new Color(255, 255, 255));
		lblAgMarca.setBounds(32, 67, 65, 26);
		getContentPane().add(lblAgMarca);
		
		JLabel lblAgNombre = new JLabel("Nombre:");
		lblAgNombre.setForeground(new Color(255, 255, 255));
		lblAgNombre.setBounds(32, 114, 65, 26);
		getContentPane().add(lblAgNombre);
		
		JLabel lblAgTipo = new JLabel("Tipo:");
		lblAgTipo.setForeground(new Color(255, 255, 255));
		lblAgTipo.setBounds(32, 163, 65, 26);
		getContentPane().add(lblAgTipo);
		
		comboBoxAgMarca = new JComboBox();
		comboBoxAgMarca.setModel(new DefaultComboBoxModel(new String[] {"Renault", "Toyota", "Volkswagen"}));
		comboBoxAgMarca.setBounds(107, 70, 121, 20);
		getContentPane().add(comboBoxAgMarca);
		
		textAgFieldNombre = new JTextField();
		textAgFieldNombre.setBounds(107, 116, 121, 23);
		getContentPane().add(textAgFieldNombre);
		textAgFieldNombre.setColumns(10);
		
		textAgFieldTipo = new JTextField();
		textAgFieldTipo.setBounds(107, 165, 121, 23);
		getContentPane().add(textAgFieldTipo);
		textAgFieldTipo.setColumns(10);
		
		JLabel lblAgPrecio = new JLabel("Precio:");
		lblAgPrecio.setForeground(Color.WHITE);
		lblAgPrecio.setBounds(32, 212, 65, 26);
		getContentPane().add(lblAgPrecio);
		
		textAgFieldPrecio = new JTextField();
		textAgFieldPrecio.setColumns(10);
		textAgFieldPrecio.setBounds(107, 215, 121, 23);
		getContentPane().add(textAgFieldPrecio);
		
		btnAgGuardar = new JButton("Guardar");
		btnAgGuardar.setBounds(434, 22, 115, 26);
		btnAgGuardar.addActionListener(this);
		getContentPane().add(btnAgGuardar);
		
		JLabel lblAgTituloAgregar = new JLabel("Ingresa Datos del Auto Nuevo");
		lblAgTituloAgregar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblAgTituloAgregar.setForeground(new Color(255, 255, 255));
		lblAgTituloAgregar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgTituloAgregar.setBounds(10, 11, 321, 35);
		getContentPane().add(lblAgTituloAgregar);
		
		lblAgConfirmacion = new JLabel("Agregado Éxitoso !");
		lblAgConfirmacion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAgConfirmacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgConfirmacion.setForeground(new Color(255, 255, 255));
		lblAgConfirmacion.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblAgConfirmacion.setBounds(365, 139, 227, 50);
		lblAgConfirmacion.setVisible(false);
		panelAgregar.add(lblAgConfirmacion);
	}
	
	
	public void setGuardarListener(OnGuardarListener guardarListener) {
        this.guardarListener = guardarListener;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == comboBoxAgMarca) {
			marca = comboBoxAgMarca.getSelectedItem().toString().trim();
		}
		
		if(e.getSource() == btnAgGuardar) {
			lblAgConfirmacion.setVisible(true);
			
			nombre = textAgFieldNombre.getText();
			
			tipo = textAgFieldTipo.getText().trim();
			
			precio = "$"+textAgFieldPrecio.getText();
			//marca este objeto como null PROBLEMA DE CARGA DEL CATLAGO PARA AGREGAR
			nuevoAgregado = autoCreado(marca, nombre, tipo, precio);
		
		}
		
		if (guardarListener != null) {
            guardarListener.onGuardar(nuevoAgregado);
        }
		
	}
	
	public Automovil autoCreado(String marca, String nombre, String tipo, String precio) {
		if(marca == "Renault") {
			nuevo = new Renault(marca, nombre, tipo, "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", precio);
		}
		
		if(marca == "Toyota") {
			nuevo = new Toyota(marca, nombre, tipo,  "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", precio);
		}
		
		if(marca == "Volkswagen") {
			nuevo = new Volkswagen(marca, nombre, tipo, "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", precio);
		}
		
		
		return nuevo;
	}
	
}
