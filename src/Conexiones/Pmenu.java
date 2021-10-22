package Conexiones;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Pmenu extends JFrame implements ActionListener {
	static JFrame añadirframe;
	static JTextField Nombretexto;
	static JTextField Edadtexto;
	
	static JLabel nombre;
	static JLabel edad;
	
	static JPanel listaPosicion;
	static JPanel save;
	static DefaultListModel<persona> dlm;
	static JButton añadir;
	static JButton editar;
	static JButton guardar;
	static JButton cancelar;
	static JList<persona> lista;

	public static void main(String[] args) {
		new Pmenu();

	}

	public Pmenu() {

		setTitle("Coleccion Peliculas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel marco = new JPanel(new FlowLayout(FlowLayout.CENTER));
		marco.add(añadir = new JButton("Añadir"));
		dlm = new DefaultListModel<persona>();
		añadir.addActionListener(this);
		lista = new JList<persona>(dlm);
		listaPosicion = new JPanel();
		listaPosicion.add(lista);
		listaPosicion.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(listaPosicion, BorderLayout.NORTH);
		add(marco, BorderLayout.CENTER);

		marco.add(editar = new JButton("Editar"));
		editar.addActionListener(this);
		setLocation(850, 450);
		setMinimumSize(new Dimension(400, 100));

		add(marco);

		pack();
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String botones = e.getActionCommand();
		if (botones.equals("Añadir")) {
			lista.clearSelection();
			añadir();
		}
		if (botones.equals("Editar")) {
			editar();
		}
		if (botones.equals("Guardar")) {
			guardar();
		}
		if (botones.equals("Cancelar")) {
			añadirframe.dispose();
			setVisible(true);
		}
	}

	public void añadir() {
		añadirframe = new JFrame();
		añadirframe.setTitle("Personas");
		JPanel save = new JPanel(new GridLayout(4, 2, 5, 10));
		añadirframe.add(save);
		save.add(new JLabel("Nombre"));
		save.add(Nombretexto = new JTextField(10));
		save.add(new JLabel("Edad"));
		save.add(Edadtexto = new JTextField(10));
		
		añadirframe.setMinimumSize(new Dimension(400, 100));
		añadirframe.setLocation(850, 450);

		save.add(guardar = new JButton("Guardar"));
		save.add(cancelar = new JButton("Cancelar"));
		cancelar.addActionListener(this);
		guardar.addActionListener(this);
		añadirframe.pack();
		añadirframe.setVisible(true);
		dispose();

	}

	public void guardar() {
		
		Scanner s=new Scanner(System.in);

		System.out.println("Introduce el nombre de la persona que quieres introducir");
		String nombre=s.next();
		System.out.println("Introduce la edad de la persona que quieres introducir");
		String edad=s.next();
		
		
		try {
			Connection miConexion=Conexion.conectar();
			
			persona p =new persona(nombre,edad);
			PreparedStatement insertar=miConexion.prepareStatement("INSERT INTO `personas1`(`nombre`, `edad`) VALUES ('[value-1]','[value-2]')");
			insertar.setString(1, nombre);
			insertar.setString(2, edad);
			insertar.executeUpdate();
			
			p=new persona(nombre,edad);
			int i=1;
			insertar.setString(i++, p.getNombre());
			insertar.setString(i++,p.getEdad());
			insertar.executeUpdate();
		}catch(SQLException e) {
			System.out.println("Excecpión "+e);
		}

		
		persona p = new persona(nombre.getText(), edad.getText());
		if (Nombretexto.getText().equals("") || Edadtexto.getText().equals("") ) {
			JOptionPane.showMessageDialog(null, "Debes rellenar todos los apartados");
		} else {
			if (lista.isSelectionEmpty()) {
				dlm.addElement(p);
			} else {
				dlm.setElementAt(p, lista.getSelectedIndex());
			}
			añadirframe.dispose();
			pack();
			setVisible(true);



		}
	}

	public void editar() {
			if (lista.getSelectedIndex() >= 0) {
				añadir();
				persona p = (persona)lista.getSelectedValue();
				Nombretexto.setText(p.getNombre());
				Edadtexto.setText(p.getEdad());
				
			} else {
				JOptionPane.showMessageDialog(null, "Hay que elegir un elemento de la lista");
			}
		}

}