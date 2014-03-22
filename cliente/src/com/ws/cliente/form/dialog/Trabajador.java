package com.ws.cliente.form.dialog;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.awt.Toolkit;
import javax.swing.border.EtchedBorder;

import com.ws.cliente.form.PantallaTrabajador;

import java.awt.Font;
import javax.swing.ImageIcon;

/**
 * Clase que hereda de JDialog, para crear un panel dialogo para agregar la
 * lista de enlaces a documentos y rellenar checkboxes para trabajdores.
 */
public class Trabajador extends JDialog {

	private PantallaTrabajador pt;
	private JPanel panelTrabajador = null;
	private int paso;

	/**
	 * Seria.
	 */
	private static final long serialVersionUID = -355153293351333296L;

	private JLabel lblPresenciales = null;
	private JCheckBox cBActividadesPresenciales = null;
	private JCheckBox cBActividadesTerminadas = null;
	private JTextField tFEnlace;
	private JButton btnExaminar = null;
	private JFileChooser selector = new JFileChooser();
	private JButton btnAyuda = null;
	private JButton btnCancelar = null;
	private JButton btnAceptar = null;

	private List<Object> lista = new LinkedList<Object>();

	/**
	 * Constructor para crear JDialog por defecto.
	 * 
	 * @param paso
	 *            Entero que indica que opción es la primera o la segunda para
	 *            el trabajador.
	 * @param pt
	 *            Objeto de tipo PantallaTrabajador, que será donde se devuelva
	 *            los enlaces de los docuemntos.
	 */
	public Trabajador(int paso, PantallaTrabajador pt) {
		super();
		this.pt = pt;
		this.paso = paso;
		initialize();
	}

	/**
	 * Método para cargar los elementos del panel principal.
	 */
	private void initialize() {
		this.setBounds(100, 100, 372, 368);
		this.getContentPane().setLayout(null);
		this.getContentPane().setBackground(Color.WHITE);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("img\\iconos\\Pantalla\\Dialogo.png"));
		this.setTitle("Trabajador");
		this.setContentPane(panelTrabajador());
	}

	/**
	 * Método que devuelve un panel con los elementos creados para la pantalla
	 * dialogo para Trabajador.
	 * 
	 * @return javax.swing.JPanel.
	 */
	private JPanel panelTrabajador() {
		if (panelTrabajador == null) {
			panelTrabajador = new JPanel();
			panelTrabajador.setBackground(Color.WHITE);
			panelTrabajador.setBounds(0, 0, 356, 338);
			panelTrabajador.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Realizaci\u00F3n de Actividades", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelTrabajador.setLayout(null);

			panelTrabajador.add(getLblPresenciales(), null);
			panelTrabajador.add(getCBActividadesPresenciales(), null);
			panelTrabajador.add(getCBActividadesTerminadas(), null);
			panelTrabajador.add(getBtnAyuda(), null);
			panelTrabajador.add(getBtCancelar(), null);
			panelTrabajador.add(getBtAceptar(), null);

			JLabel lblterminado = new JLabel(
					"Informe sobre formaci\u00F3n terminado:");
			lblterminado.setBounds(26, 109, 173, 14);
			panelTrabajador.add(lblterminado);

			JLabel lblInforme = new JLabel(
					"A\u00F1adir informe sobre formaci\u00F3n:");
			lblInforme.setBounds(26, 160, 163, 14);
			panelTrabajador.add(lblInforme);

			panelTrabajador.add(getTFEnlace(), null);

			panelTrabajador.add(getBtnExaminar(), null);

			activar();

			setAyuda();
		}
		return panelTrabajador;
	}

	/**
	 * Método que inicializa la etiqueta del finalización de actividades
	 * presenciales.
	 * 
	 * @return javax.swing.JLabel.
	 */
	private JLabel getLblPresenciales() {
		if (lblPresenciales == null) {
			lblPresenciales = new JLabel(
					"Finalizaci\u00F3n del m\u00F3dulo de actividades presenciales:");
			lblPresenciales.setBounds(26, 34, 246, 14);
		}
		return lblPresenciales;
	}

	/**
	 * Método que inicializa el checkBox de actividades presenciales.
	 * 
	 * @return javax.swing.JCheckBox.
	 */
	private JCheckBox getCBActividadesPresenciales() {
		if (cBActividadesPresenciales == null) {
			cBActividadesPresenciales = new JCheckBox(
					"Actividades Presenciales");
			cBActividadesPresenciales.setEnabled(false);
			cBActividadesPresenciales.setBackground(Color.WHITE);
			cBActividadesPresenciales.setBounds(180, 55, 143, 23);
			cBActividadesPresenciales
					.setToolTipText("CheckBox de realizaci\u00F3n de m\u00F3dulos");
		}
		return cBActividadesPresenciales;
	}

	/**
	 * Método que inicializa el checkBox de actividades terminadas.
	 * 
	 * @return javax.swing.JCheckBox.
	 */
	private JCheckBox getCBActividadesTerminadas() {
		if (cBActividadesTerminadas == null) {
			cBActividadesTerminadas = new JCheckBox("Actividades Terminadas");
			cBActividadesTerminadas.setEnabled(false);
			cBActividadesTerminadas.setBackground(Color.WHITE);
			cBActividadesTerminadas
					.setToolTipText("CheckBox de actividades terminadas");
			cBActividadesTerminadas.setBounds(180, 130, 143, 23);
		}
		return cBActividadesTerminadas;
	}

	/**
	 * Método que inicializa el botón para la ayuda.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtnAyuda() {
		if (btnAyuda == null) {
			btnAyuda = new JButton("");
			btnAyuda.setLocation(32, 298);
			btnAyuda.setIcon(new ImageIcon("img\\iconos\\Info.png"));
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
	 * Método que inicializa el botón de cancelar, cierra el JDialog.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton();
			btnCancelar.setBackground(new Color(255, 255, 255));
			btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnCancelar.setMnemonic(KeyEvent.VK_C);
			btnCancelar.setToolTipText("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnCancelar.setText("Cancelar");
			btnCancelar.setBounds(new Rectangle(166, 375, 78, 20));
			btnCancelar.setBounds(158, 302, 92, 20);
		}
		return btnCancelar;
	}

	/**
	 * Método que inicializa el botón de aceptar, almacena la lista de enlaces
	 * de documentos para el trabajdor y comprueba que se pulso sobre los
	 * checkboxes.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton();
			btnAceptar.setBackground(new Color(255, 255, 255));
			btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnAceptar.setMnemonic(KeyEvent.VK_T);
			btnAceptar.setToolTipText("Guardar lista");
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					switch (paso) {
					case 1:
						if (cBActividadesPresenciales.isSelected()) {

							pt.setCorrecto(true);
						} else {
							if (JOptionPane
									.showConfirmDialog(
											null,
											"No ha confirmado las actividades presenciales, ¿desea confirmarlas?",
											"Aviso", JOptionPane.YES_NO_OPTION) == 0) {
								pt.setCorrecto(true);
							} else {
								mostrarMensaje();
								pt.setCorrecto(false);
							}
						}
						break;
					case 2:
						if (cBActividadesTerminadas.isSelected()) {
							if (tFEnlace.getText().compareTo("") != 0) {
								pt.setCorrecto(true);
								pt.setListaDocu(lista);
							} else {
								mostrarMensaje();
								pt.setCorrecto(false);
							}
						} else {
							if (JOptionPane
									.showConfirmDialog(
											null,
											"No ha confirmado las actividades terminadas, ¿desea confirmarlas?",
											"Aviso", JOptionPane.YES_NO_OPTION) == 0) {
								if (tFEnlace.getText().compareTo("") != 0) {
									pt.setCorrecto(true);
									pt.setListaDocu(lista);
								} else {
									mostrarMensaje();
									pt.setCorrecto(false);
								}
								pt.setListaDocu(lista);
							} else {
								mostrarMensaje();
								pt.setCorrecto(false);
							}
						}
						break;
					}
					dispose();
				}
			});
			btnAceptar.setText("Aceptar");
			btnAceptar.setBounds(new Rectangle(166, 375, 78, 20));
			btnAceptar.setBounds(260, 302, 86, 20);
		}
		return btnAceptar;
	}

	/**
	 * Método para sacar por pantalla que ha habido un error al cargar los
	 * enlaces o al no pulsar en los checkbox.
	 */
	private void mostrarMensaje() {
		JOptionPane.showMessageDialog(this,
				"ERROR, no se almacenara el registro", "Informacion",
				JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Método que inicializa el TextField del código o del enlace.
	 * 
	 * @return javax.swing.JTextField.
	 */
	private JTextField getTFEnlace() {
		if (tFEnlace == null) {
			tFEnlace = new JTextField();
			tFEnlace.setEnabled(false);
			tFEnlace.setToolTipText("C\u00F3digo o enlace");
			tFEnlace.setColumns(10);
			tFEnlace.setBounds(26, 185, 303, 20);
		}
		return tFEnlace;
	}

	/**
	 * Método que inicializa el botón de examinar en el disco para elegir el
	 * documento/s a agregar a la lista de enlaces a documentos.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtnExaminar() {
		if (btnExaminar == null) {
			btnExaminar = new JButton("Examinar");
			btnExaminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					lista.removeAll(lista);
					String nombre = "";
					int respuesta = selector.showOpenDialog(null);
					if (respuesta == JFileChooser.APPROVE_OPTION) {
						nombre = selector.getSelectedFile().getAbsolutePath();
					}
					tFEnlace.setText(nombre);
					lista.add(tFEnlace.getText() + " / "
							+ "Formación Trabajador");
				}
			});
			btnExaminar.setEnabled(false);
			btnExaminar.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnExaminar.setBackground(Color.WHITE);
			btnExaminar.setMnemonic(KeyEvent.VK_E);
			btnExaminar.setBounds(237, 216, 92, 20);
		}
		return btnExaminar;
	}

	/**
	 * Método para activar diferentes checkboxes, dependiendo del paso del
	 * trabajador a completar.
	 */
	private void activar() {
		if (paso == 1) {
			cBActividadesPresenciales.setEnabled(true);
		} else {
			cBActividadesTerminadas.setEnabled(true);
			tFEnlace.setEnabled(true);
			btnExaminar.setEnabled(true);
		}
	}

	/**
	 * Método que carga el sistema de ayuda.
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
			hb.enableHelpOnButton(btnAyuda, "documentacionT", hs);
			// Desplega ayuda pulsando sobre F1
			hb.enableHelpKey(this.getContentPane(), "documentacionT", hs);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,
					"Fichero de Ayuda no encontrado " + e.getMessage(),
					"Ayuda", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
