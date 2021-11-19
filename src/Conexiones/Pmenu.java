package Conexiones;
import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	static JFrame a�adirframe;
	static JTextField Nombre;
	static JTextField Edad;
	static JPanel listaPosicion;
	static DefaultListModel<persona> dlm;
	DefaultListModel dm = new DefaultListModel();
	static JButton a�adir;
	static JButton editar;
	static JButton guardar;
	static JButton eliminar;
	static JList<persona> lista;

	public static void main(String[] args)  {
		
		new Pmenu();
	}
	public void loadlist() {
		try {
			String query = "select * from personas1";
			PreparedStatement pst = Conexion1.conectar().prepareStatement(query);
			ResultSet rs =pst.executeQuery();
			while (rs.next()) {
				persona aux=new persona(rs.getString("nombre"), rs.getString("edad"));
				
				dlm.addElement(aux);
		
			}
			
			pst.close();
			rs.close();

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	 
	 //Creo la interfaz gr�fica

	public Pmenu() {

		setTitle("Coleccion Personas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel marco = new JPanel(new FlowLayout(FlowLayout.CENTER));
		marco.add(a�adir = new JButton("A�adir"));
		dlm = new DefaultListModel<persona>();
		a�adir.addActionListener(this);
		lista = new JList<persona>(dlm);
		listaPosicion = new JPanel();
		listaPosicion.add(lista);
		listaPosicion.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(listaPosicion, BorderLayout.NORTH);
		add(marco, BorderLayout.CENTER);

		marco.add(editar = new JButton("Eliminar"));
		editar.addActionListener(this);
		setLocation(850, 450);
		setMinimumSize(new Dimension(400, 100));

		add(marco);

		pack();
		setVisible(true);
		loadlist();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String botones = e.getActionCommand();
		if (botones.equals("A�adir")) {
			lista.clearSelection();
			a�adir();
		}
		if (botones.equals("Eliminar")) {
			eliminar();
		}
		if (botones.equals("Guardar")) {
			guardar();
		}
		if (botones.equals("Cancelar")) {
			a�adirframe.dispose();
			setVisible(true);
		}
	}
//Le doy funci�n al boton a�adir para poder guardar las personas que quiera en la base de datos
	
	public void a�adir() {
		a�adirframe = new JFrame();
		a�adirframe.setTitle("Personas");
		JPanel save = new JPanel(new GridLayout(4, 2, 5, 10));
		a�adirframe.add(save);
		save.add(new JLabel("Nombre"));
		save.add(Nombre = new JTextField(10));
		save.add(new JLabel("Edad"));
		save.add(Edad = new JTextField(10));
		
		a�adirframe.setMinimumSize(new Dimension(400, 100));
		a�adirframe.setLocation(850, 450);

		save.add(guardar = new JButton("Guardar"));
		
		JButton cancelar;
		save.add(cancelar = new JButton("Cancelar"));
		cancelar.addActionListener(this);
		guardar.addActionListener(this);
		a�adirframe.pack();
		a�adirframe.setVisible(true);
		dispose();

	}
//Le doy funci�n al bot�n guardar para que lo inserte en la base de datos 
	public void guardar() {

		
		try {
			Connection miConexion=Conexion1.conectar();
			
			
			PreparedStatement insertar=miConexion.prepareStatement("INSERT INTO `personas1`(`nombre`, `edad`) values (?,?)");
			insertar.setString(1,String.valueOf(Nombre.getText()));
			insertar.setString(2, String.valueOf(Edad.getText()));
			insertar.executeUpdate();
		}catch(SQLException e) {
			System.out.println("Excecpi�n "+e);
		}
		persona p = new persona(Nombre.getText(), Edad.getText());
        if (Nombre.getText().equals("") || Edad.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debes rellenar todos los apartados");
        } else {
            if (lista.isSelectionEmpty()) {
                dlm.addElement(p);
            } else {
                dlm.setElementAt(p, lista.getSelectedIndex());
            }
            a�adirframe.dispose();
            pack();
            setVisible(true);

        }
		


		}
	//Le doy funci�n al bot�n eliminar y que elimine la persona que quiero de la base de datos

	public void eliminar() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = Conexion1.conectar();
            preparedStatement = connection.prepareStatement("DELETE FROM personas1 WHERE nombre = ?");
            preparedStatement.setString(1, String.valueOf(dlm.get(lista.getSelectedIndex()).getNombre()));
            preparedStatement.executeUpdate();

            System.out.println("La persona selecionada se ha eliminado");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}