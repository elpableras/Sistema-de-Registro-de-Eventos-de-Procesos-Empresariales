package com.ws.cliente.form;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.net.URL;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.*;

import com.ws.cliente.Cliente;

/**
 * Clase que define la interfaz para la identificación de usuarios para acceder
 * al trazador de procesos, hereda de JFrame e implementa la clase abstracta KeyListener.
 */
public class Administrador extends JFrame implements KeyListener {

	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 8412490461780373019L;
	private Cliente c;

	private String usuario = "";
	private String pass = "";
	private boolean pulsado = false;

	// LOGIN
	private boolean uno = false;
	private int cont = 0;
	private boolean dos = false;
	private int cont2 = 0;

	// CONTENEDOR
	private String ruta = "img\\";
	private JLabel lbAdmin = null;
	private JTextArea txtrUniversidadDeOviedo = null;

	// CONTENEDOR IDEN
	private JPanel panelIden = null;
	private JPasswordField pfPass = null;
	private JLabel lbUsuario = null;
	private JTextField tfUsuario = null;
	private JLabel lbPassword = null;
	private JButton btnAcceder = null;
	private JButton btnAyuda = null;

	/**
	 * Constructor.
	 * 
	 * @param c
	 *            Objecto de tipo Cliente.
	 */
	public Administrador(Cliente c) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.c = c;
		Initialize();
		contenedor();
		contenedorIden();
		setAyuda();
	} // fin del constructor

	/**
	 * Método para inicializar los elementos del marco principal.
	 */
	private void Initialize() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ruta+"iconos\\Pantalla\\Identificaci\u00F3n.png"));

		getContentPane().setBackground(Color.WHITE);
		setResizable(false);
		setTitle("Administrador");
		addKeyListener(this); // permitir al marco procesar eventos de teclas
		this.setSize(793, 629);
	}

	/**
	 * Método para inicializar los elemetos del panel secundario.
	 */
	private void contenedor() {

		lbAdmin = new JLabel();
		lbAdmin.setBackground(SystemColor.control);
		lbAdmin.setHorizontalTextPosition(SwingConstants.CENTER);
		lbAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lbAdmin.setToolTipText("Administrador");
		lbAdmin.setBounds(53, 41, 225, 225);
		lbAdmin.setIcon(new ImageIcon(ruta + "Admin.jpg"));
		getContentPane().add(lbAdmin, null);

	}

	/**
	 * Método para inicializar los elementos de identificación del
	 * administrador.
	 */
	private void contenedorIden() {
		panelIden = new JPanel();
		panelIden.setBackground(SystemColor.control);
		panelIden.setBounds(237, 329, 296, 182);
		getContentPane().add(panelIden);
		panelIden.setLayout(null);

		lbUsuario = new JLabel("Usuario:");
		lbUsuario.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		lbUsuario.setBounds(413, 275, 80, 30);

		lbPassword = new JLabel("Password:");
		lbPassword.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		lbPassword.setBounds(413, 317, 97, 30);

		pfPass = new JPasswordField();
		pfPass.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		pfPass.setToolTipText("Password");
		pfPass.setBounds(520, 318, 139, 28);

		panelIden.add(lbUsuario, null);
		panelIden.add(getTxtUsuario(), null);
		panelIden.add(lbPassword, null);
		panelIden.add(pfPass, null);

		txtrUniversidadDeOviedo = new JTextArea();
		txtrUniversidadDeOviedo.setBackground(SystemColor.control);
		panelIden.add(txtrUniversidadDeOviedo);
		txtrUniversidadDeOviedo.setFont(new Font("Microsoft Sans Serif",
				Font.BOLD, 27));
		txtrUniversidadDeOviedo.setWrapStyleWord(true);
		txtrUniversidadDeOviedo.setLineWrap(true);
		txtrUniversidadDeOviedo.setEditable(false);
		txtrUniversidadDeOviedo.setText("Administrador de Procesos");
		txtrUniversidadDeOviedo.setBounds(353, 196, 367, 33);

		panelIden.add(getBtnAcceder(), null);
		
		panelIden.add(getBtnAyuda(), null);
		
		panelIden.setVisible(false);
	}

	/**
	 * Método para crear un JTextField, para introducir el nombre de usuario del
	 * loguin.
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
	 * Método que se encarga de hacer de botón (no visible) que comprueba que el
	 * usuario y la contraseña son correctos, pero que solo se activa pulsando
	 * sobre dos diferentes teclas del teclado.
	 * 
	 * @return Un JButton btnAcceder.
	 */
	private JButton getBtnAcceder() {
		if (btnAcceder == null) {
			btnAcceder = new JButton("Acceder");
			btnAcceder.addKeyListener(new KeyAdapter() {
				@SuppressWarnings("static-access")
				public void keyPressed(KeyEvent evento) {
					if (evento.getKeyText(evento.getKeyCode()).compareTo("Alt") == 0) {
						if (!dos) {
							cont2++;
						}
						dos = true;
					} else if (cont2 == 1
							&& dos
							&& evento.getKeyText(evento.getKeyCode())
									.compareTo("G") == 0) {
						String usuario = tfUsuario.getText();
						String pass = new String(pfPass.getPassword());
						String rol = c.comprobarRol(usuario, pass, false, "A");
						if (rol.compareToIgnoreCase("true") == 0) {
							// CORRECTO
							c.setUsuario(usuario);
							dispose();
						} else if (rol.compareToIgnoreCase("false") == 0) {
							JOptionPane.showMessageDialog(null,
									"Datos Erroneos",
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
						cont2 = 0;
						dos = false;
					} else if (cont2 == 1) {
						cont2--;
						dos = false;
					}
				}
			});
		}
		return btnAcceder;
	}
	
	/**
	 * Método que inicializa el botón de Ayuda en el panel.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtnAyuda(){
		if(btnAyuda == null){
			btnAyuda = new JButton("");
			btnAyuda.setLocation(580, 357);
			btnAyuda.setToolTipText("Ayuda");
			btnAyuda.setSize(new java.awt.Dimension(24, 24));
			// NO DEJAR MARGENES ENTRE LOS BOTONES
			btnAyuda.setMargin(new java.awt.Insets(0, 0, 0, 0));
			btnAyuda.setMaximumSize(new java.awt.Dimension(30, 30));
			btnAyuda.setMinimumSize(new java.awt.Dimension(30, 30));
			// DESPINTAR EL BORDE
			btnAyuda.setBorderPainted(false);
			btnAyuda.setContentAreaFilled(false);
			btnAyuda.setIcon(new ImageIcon(ruta+"iconos\\Info.png"));
		}
		return btnAyuda;
	}

	@SuppressWarnings("static-access")
	/**
	 * Método manejador del evento de pulsación para cualquier tecla del teclado, pulsando una determinadas teclas
	 * hará aparecer el panel para la introducción del usuario y contraseña.
	 */
	public void keyPressed(KeyEvent evento) {
		if (evento.getKeyText(evento.getKeyCode()).compareTo("Ctrl") == 0) {
			if (!uno) {
				cont++;
			}
			uno = true;
		} else if (cont == 1 && uno
				&& evento.getKeyText(evento.getKeyCode()).compareTo("F1") == 0) {
			cont = 0;
			uno = false;
			panelIden.setVisible(true);
			tfUsuario.requestFocus();
		} else if (cont == 1) {
			cont--;
			uno = false;
		}
	}

	@Override
	/**
	 * Otro método no utilizado de la implementación de KeyListener.
	 */
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	/**
	 * Otro método no utilizado de la implementación de KeyListener.
	 */
	public void keyTyped(KeyEvent arg0) {
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