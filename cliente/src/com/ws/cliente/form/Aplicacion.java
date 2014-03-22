package com.ws.cliente.form;

import java.awt.*;
import java.io.File;
import java.net.URL;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.*;

import com.ws.cliente.Cliente;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * Clase que define la interfaz para la identificación de usuarios para acceder
 * a la aplicación, hereda de JFrame.
 */
public class Aplicacion extends JFrame {

	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 8412490461780373019L;
	private Cliente c;

	private String usuario = "";
	private String pass = "";
	private boolean pulsado = false;

	// CONTENEDOR IDEN
	private JPanel panelIden = null;
	private JTextArea txtrAplicacion = null;
	private JLabel lbUsu = null;
	private JPasswordField pfPass = null;
	private JLabel lbUsuario = null;
	public JTextField tfUsuario = null;
	private JLabel lbPassword = null;
	private JButton btnAcceder = null;
	private JButton btnAyuda;

	/**
	 * Constructor.
	 * 
	 * @param c
	 *            Objecto de tipo Cliente.
	 */
	public Aplicacion(Cliente c) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.c = c;
		Initialize();
		setAyuda();
	} // fin del constructor

	/**
	 * Método para inicializar el marco principal.
	 */
	private void Initialize() {
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("img\\iconos\\Pantalla\\Identificaci\u00F3n.png"));
		this.setBackground(Color.WHITE);
		this.setResizable(false);
		this.setTitle("Aplicaci\u00F3n");
		this.setSize(793, 629);
		this.setContentPane(getContenedorIden());
	}

	/**
	 * Método que devuelve un panel con los elementos creados para loguearse.
	 * 
	 * @return Un JPanel panelIden.
	 */
	private JPanel getContenedorIden() {
		if (panelIden == null) {
			panelIden = new JPanel();
			panelIden.setBackground(Color.WHITE);
			panelIden.setBounds(237, 329, 296, 182);
			panelIden.setLayout(null);

			lbUsuario = new JLabel("Usuario:");
			lbUsuario.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
			lbUsuario.setBounds(413, 275, 80, 30);

			lbPassword = new JLabel("Password:");
			lbPassword
					.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
			lbPassword.setBounds(413, 317, 97, 30);

			pfPass = new JPasswordField();
			pfPass.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
			pfPass.setToolTipText("Password");
			pfPass.setBounds(520, 318, 139, 28);

			panelIden.add(lbUsuario, null);
			panelIden.add(getTxtUsuario(), null);
			panelIden.add(lbPassword, null);
			panelIden.add(pfPass, null);

			txtrAplicacion = new JTextArea();
			txtrAplicacion.setBackground(Color.WHITE);
			panelIden.add(txtrAplicacion);
			txtrAplicacion.setFont(new Font("Microsoft Sans Serif", Font.BOLD,
					27));
			txtrAplicacion.setWrapStyleWord(true);
			txtrAplicacion.setLineWrap(true);
			txtrAplicacion.setEditable(false);
			txtrAplicacion.setText("Aplicaci\u00F3n para Usuarios");
			txtrAplicacion.setBounds(369, 196, 340, 33);

			lbUsu = new JLabel();
			panelIden.add(lbUsu);
			lbUsu.setBackground(Color.WHITE);
			lbUsu.setToolTipText("RRHH, Trabajador, Gerente");
			lbUsu.setBounds(53, 41, 225, 225);
			lbUsu.setIcon(new ImageIcon("img\\Usuario.jpg"));

			panelIden.add(getBtnAcceder(), null);
			panelIden.add(getBtnAyuda());
		}
		return panelIden;
	}

	/**
	 * Método que crea un JTextField, para introducir el nombre del usuario.
	 * 
	 * @return Un JTextField tfUsuario.
	 */
	private JTextField getTxtUsuario() {
		if (tfUsuario == null) {
			tfUsuario = new JTextField();
			tfUsuario.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
			tfUsuario.setToolTipText("Usuario");
			tfUsuario.setBounds(520, 276, 139, 28);
			tfUsuario.setColumns(10);
		}
		return tfUsuario;
	}

	/**
	 * Método que crea un botón para comprobar que el usuario y la contraseña
	 * son correctas para poder ingresar dentro de la pantalla de Aplicación.
	 * 
	 * @return Un JButton btnAcceder.
	 */
	private JButton getBtnAcceder() {
		if (btnAcceder == null) {
			btnAcceder = new JButton("Acceder");
			btnAcceder.setMnemonic(KeyEvent.VK_A);
			btnAcceder.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					String usuario = tfUsuario.getText();
					String pass = new String(pfPass.getPassword());
					String rol = c.comprobarRol(usuario, pass, false, "P");
					if (rol.compareToIgnoreCase("true") == 0) {
						// CORRECTO
						c.setUsuario(usuario);
						// cerrar ventanita
						dispose();
					} else if (rol.compareToIgnoreCase("false") == 0) {
						JOptionPane.showMessageDialog(null, "Datos Erroneos",
								"USUARIO O PASSWORD INCORRECTO",
								JOptionPane.ERROR_MESSAGE);
						tfUsuario.setText("");
						pfPass.setText("");
						tfUsuario.requestFocus();
					} else {
						JOptionPane.showMessageDialog(null, rol, "ERROR",
								JOptionPane.ERROR_MESSAGE);
						tfUsuario.setText("");
						pfPass.setText("");
						tfUsuario.requestFocus();
					}

				}
			});
			btnAcceder
					.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
			btnAcceder.setToolTipText("Acceder a la aplicaci\u00F3n");
			btnAcceder.setBounds(488, 387, 107, 30);
		}
		return btnAcceder;
	}
	
	/**
	 * Método que inicializa el botón de Ayuda en el panel.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtnAyuda() {
		if (btnAyuda == null) {
			btnAyuda = new JButton("");
			btnAyuda.setLocation(635, 387);
			btnAyuda.setToolTipText("Ayuda");
			btnAyuda.setIcon(new ImageIcon("img\\iconos\\Info.png"));
			btnAyuda.setSize(new java.awt.Dimension(24, 24));
			// NO DEJAR MARGENES ENTRE LOS BOTONES
			btnAyuda.setMargin(new java.awt.Insets(0, 0, 0, 0));
			btnAyuda.setMaximumSize(new java.awt.Dimension(30, 30));
			btnAyuda.setMinimumSize(new java.awt.Dimension(30, 30));
			// DESPINTAR EL BORDE
			btnAyuda.setBorderPainted(false);
			btnAyuda.setContentAreaFilled(false);
		}
		return btnAyuda;
	}

	/**
	 * Getter synchronized que devuelve el usuario introducido en el login.
	 * 
	 * @return Una cadena con el usuario.
	 */
	public synchronized String getUsuario() {
		if (!pulsado) {
			try {
				wait();
				pulsado = true;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return usuario;
	}

	/**
	 * Setter synchronized, que almacena en el atributo usuario el usuario
	 * pasado como parametro.
	 * 
	 * @param usuario
	 *            Una cadena con el usuario.
	 */
	public synchronized void setUsuario(String usuario) {
		this.usuario = usuario;
		notify();
	}

	/**
	 * Getter que devuelve la contraseña.
	 * 
	 * @return Una cadena con la contraseña.
	 */
	public String getPass() {
		return pass;
	}

	/**
	 * Setter, que almacena en el atributo pass la contraseña pasado como
	 * parametro.
	 * 
	 * @param pass
	 *            Una cadena con la contraseña.
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	/**
	 * Método para cargar la ayuda, por medio de la pulsación F1, nos llevara a
	 * la introducción dentro de la ayuda.
	 */
	private void setAyuda() {
		// Carga el fichero de ayuda
		File fichero = new File("ayuda/Ayuda.hs");
		URL hsURL;
		try {
			hsURL = fichero.toURI().toURL();
			// Crea el HelpSet
			HelpSet hs = new HelpSet(getClass().getClassLoader(), hsURL);
			// Clase de ayuda de JavaHelp, para el uso por defecto de la ayuda
			HelpBroker hb = hs.createHelpBroker();
			// Ayuda para botón
			hb.enableHelpOnButton(btnAyuda, "introduccion", hs);
			// Desplega ayuda pulsando sobre F1
			hb.enableHelpKey(this.getContentPane(), "introduccion", hs);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,
					"Fichero de Ayuda no encontrado " + e.getMessage(),
					"Ayuda", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}