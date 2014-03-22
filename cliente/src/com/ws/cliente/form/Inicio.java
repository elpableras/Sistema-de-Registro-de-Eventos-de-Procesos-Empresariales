package com.ws.cliente.form;

import java.awt.*;
import java.io.File;
import java.net.URL;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.*;

import com.ws.cliente.Cliente;

import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clase que define la interfaz para la pantalla inicial, donde se podrá elegir
 * el trazador de procesos o la aplicación, hereda de JFrame.
 */
public class Inicio extends JFrame {

	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 8412490461780373019L;
	private Cliente c;
	private boolean cerrar = false;

	// CONTENEDOR
	private String ruta = "img\\";
	private JLabel lbUni = null;
	private JLabel lbEII = null;

	private JTextArea txtrProyecto = null;
	private JButton btnAdministrador = null;
	private JButton btnAplicacin = null;
	private JButton btnAutomatizacinRegistros = null;

	private Administrador ad;
	private Aplicacion ap;
	private RegistroAuto at;

	// CONTENEDOR IDEN
	private JPanel panelIden = null;
	private JButton btnAyuda;

	/**
	 * Constructor.
	 * 
	 * @param c
	 *            Objecto de tipo Cliente.
	 */
	public Inicio(Cliente c) {
		setResizable(false);
		this.c = c;
		initialize();
		setAyuda();
	} // fin del constructor

	/**
	 * Este método inicializa el marco principal de la clase Inicio.
	 */
	private void initialize() {
		this.setSize(784, 629);
		this.setIconImage(Toolkit
				.getDefaultToolkit()
				.getImage(ruta+"iconos\\Pantalla\\Inicio.png"));
		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		this.setContentPane(getContenedorIden());
		this.setTitle("Inicio");
	}

	/**
	 * Método que devuelve un panel con los elementos del contenedor de la
	 * Pantalla de la clase de Inicio.
	 * 
	 * @return Un panel donde se cargan los diferentes elementos que integran la
	 *         pantalla.
	 */
	private JPanel getContenedorIden() {
		if (panelIden == null) {

			panelIden = new JPanel();
			panelIden.setBackground(Color.WHITE);
			panelIden.setLayout(null);

			txtrProyecto = new JTextArea();
			txtrProyecto.setBackground(Color.WHITE);
			panelIden.add(txtrProyecto);
			txtrProyecto.setFont(new Font("Tahoma", Font.BOLD, 27));
			txtrProyecto.setWrapStyleWord(true);
			txtrProyecto.setLineWrap(true);
			txtrProyecto.setEditable(false);
			txtrProyecto
					.setText("Sistema de Registro de Eventos\r\n    de Procesos Empresariales");
			txtrProyecto.setBounds(169, 233, 439, 70);

			panelIden.add(getBtnAdministrador(), null);
			panelIden.add(getBtnAplicacin(), null);
			panelIden.add(getBtnAutomatizacinRegistros(), null);

			lbUni = new JLabel();
			panelIden.add(lbUni);
			lbUni.setBounds(42, 42, 142, 123);
			lbUni.setIcon(new ImageIcon(ruta + "Universidad.png"));

			lbEII = new JLabel();
			panelIden.add(lbEII);
			lbEII.setBounds(619, 42, 116, 123);
			lbEII.setIcon(new ImageIcon(ruta + "EII.png"));

			JButton btnSalir = new JButton("Salir");
			btnSalir.setToolTipText("Salir");
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setCerrar(true);
					System.exit(0);
				}
			});
			btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnSalir.setMnemonic(KeyEvent.VK_S);
			btnSalir.setBounds(335, 464, 108, 30);
			panelIden.add(btnSalir);
			panelIden.add(getBtnAyuda());
		}
		return panelIden;
	}

	/**
	 * Método para crear el botón que por medio de su pulsación, nos llevará a
	 * la pantalla de identificación del trazador de procesos.
	 * 
	 * @return El JButton btnAdministrador.
	 */
	private JButton getBtnAdministrador() {
		if (btnAdministrador == null) {
			btnAdministrador = new JButton("Administrador de Procesos");
			btnAdministrador.setBackground(SystemColor.control);
			btnAdministrador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ad = new Administrador(Inicio.this.c);

					Dimension screenSize = Toolkit.getDefaultToolkit()
							.getScreenSize();
					Dimension frameSize = ad.getSize();
					if (frameSize.height > screenSize.height)
						frameSize.height = screenSize.height;
					if (frameSize.width > screenSize.width)
						frameSize.width = screenSize.width;
					ad.setLocation((screenSize.width - frameSize.width) / 2,
							(screenSize.height - frameSize.height) / 2);
					// Para que el aspecto sea según donde se abra, unix,
					// mac....
					try {
						UIManager.setLookAndFeel(UIManager
								.getSystemLookAndFeelClassName());
					} catch (Exception e) {
						e.printStackTrace();
					}
					dispose();
					ad.setVisible(true);
				}
			});
			btnAdministrador.setMnemonic(KeyEvent.VK_A);
			btnAdministrador.setToolTipText("Administrador");
			btnAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnAdministrador.setBounds(246, 341, 285, 30);
		}
		return btnAdministrador;
	}

	/**
	 * Método para crear el botón que por medio de su pulsación, nos llevará a
	 * la pantalla de identificación de la aplicación.
	 * 
	 * @return El JButton btnAplicacin.
	 */
	private JButton getBtnAplicacin() {
		if (btnAplicacin == null) {
			btnAplicacin = new JButton("Aplicaci\u00F3n");
			btnAplicacin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ap = new Aplicacion(Inicio.this.c);

					Dimension screenSize = Toolkit.getDefaultToolkit()
							.getScreenSize();
					Dimension frameSize = ap.getSize();
					if (frameSize.height > screenSize.height)
						frameSize.height = screenSize.height;
					if (frameSize.width > screenSize.width)
						frameSize.width = screenSize.width;
					ap.setLocation((screenSize.width - frameSize.width) / 2,
							(screenSize.height - frameSize.height) / 2);
					// Para que el aspecto sea según donde se abra, unix,
					// mac....
					try {
						UIManager.setLookAndFeel(UIManager
								.getSystemLookAndFeelClassName());
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					dispose();
					ap.setVisible(true);
					ap.tfUsuario.requestFocus();
				}
			});
			btnAplicacin.setToolTipText("RRHH, Trabajador y Gerente");
			btnAplicacin.setMnemonic(KeyEvent.VK_P);
			btnAplicacin.setBackground(Color.WHITE);
			btnAplicacin
					.setFont(new Font("Tahoma", Font.BOLD, 20));
			btnAplicacin.setBounds(297, 382, 183, 30);
		}
		return btnAplicacin;
	}

	private JButton getBtnAutomatizacinRegistros() {
		if (btnAutomatizacinRegistros == null) {
			btnAutomatizacinRegistros = new JButton(
					"Automatizaci\u00F3n Registros");
			btnAutomatizacinRegistros
					.setToolTipText("Crear registros autom\u00E1ticos");
			btnAutomatizacinRegistros.setMnemonic(KeyEvent.VK_T);
			btnAutomatizacinRegistros.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					at = new RegistroAuto(Inicio.this.c);

					Dimension screenSize = Toolkit.getDefaultToolkit()
							.getScreenSize();
					Dimension frameSize = at.getSize();
					if (frameSize.height > screenSize.height)
						frameSize.height = screenSize.height;
					if (frameSize.width > screenSize.width)
						frameSize.width = screenSize.width;
					at.setLocation((screenSize.width - frameSize.width) / 2,
							(screenSize.height - frameSize.height) / 2);
					// Para que el aspecto sea según donde se abra, unix,
					// mac....
					try {
						UIManager.setLookAndFeel(UIManager
								.getSystemLookAndFeelClassName());
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					dispose();
					at.setVisible(true);
				}
			});
			btnAutomatizacinRegistros.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnAutomatizacinRegistros.setBounds(254, 423, 270, 30);
		}
		return btnAutomatizacinRegistros;
	}

	/**
	 * Método para crear el botón de acceso al sistema de ayuda.
	 * 
	 * @return El JButton btnAyuda.
	 */
	private JButton getBtnAyuda() {
		if (btnAyuda == null) {
			btnAyuda = new JButton("");
			btnAyuda.setLocation(377, 505);
			btnAyuda.setIcon(new ImageIcon(ruta+"iconos\\Info.png"));
			btnAyuda.setSize(new java.awt.Dimension(24, 24));
			// NO DEJAR MARGENES ENTRE LOS BOTONES
			btnAyuda.setMargin(new java.awt.Insets(0, 0, 0, 0));
			btnAyuda.setMaximumSize(new java.awt.Dimension(30, 30));
			btnAyuda.setMinimumSize(new java.awt.Dimension(30, 30));
			// DESPINTAR EL BORDE
			btnAyuda.setBorderPainted(false);
			btnAyuda.setContentAreaFilled(false);
			btnAyuda.setToolTipText("Ayuda");
		}
		return btnAyuda;
	}

	/**
	 * Getter.
	 * 
	 * @return cerrar un boolean con true o false si se cerro o no la ventana.
	 */
	public boolean isCerrar() {
		return cerrar;
	}

	/**
	 * Setter.
	 * 
	 * @param cerrar
	 *            un booleano true o false de si se ha cerrado la ventana.
	 */
	public void setCerrar(boolean cerrar) {
		this.cerrar = cerrar;
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