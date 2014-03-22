package com.ws.cliente.form;

import java.awt.*;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.*;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import com.ws.cliente.Cliente;
import com.ws.cliente.form.dialog.Trabajador;
import com.ws.cliente.dato.ListaAutorizadoC;
import com.ws.cliente.dato.ListaDocumentoC;
import com.ws.cliente.dato.ListaGeneradorC;
import com.ws.cliente.dato.RegistroEspeC;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase que define la interfaz de la pantalla del Trabajador, hereda de JFrame
 * e implementa la clase abstracta Printable.
 */
public class PantallaTrabajador extends JFrame implements Printable {

	private Cliente c;
	private RegistroEspeC rec;
	private ListaDocumentoC d;
	private ListaGeneradorC g;
	private ListaAutorizadoC a;

	private String proce = "RH-2";
	private boolean correcto = false;
	private boolean cerrar = false;
	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 3526777868741300578L;
	private JPanel jContentPane = null;

	// PANEL BARRA MENU
	private JMenuBar barraMenu = null;
	private JMenu menuArchivo = null;
	private JMenuItem mntmImprimir = null;
	private JMenuItem itemSalir = null;
	private JMenu menuProce = null;
	private JMenu mntmEspeRH_2 = null;
	private JMenuItem mntmRH_2_0 = null;
	private JMenuItem mntmRH_2_1 = null;
	private JMenu menuAyuda = null;
	private JMenuItem mntmAyuda;
	private JMenuItem mntmAcercadeTrabajador;

	// PANEL BARRA HERRAMIENTAS
	private JToolBar barraHerramientas = null;
	private JButton btGenerar = null;
	private JButton btImprimir = null;

	// PANEL CENTRAL
	private JPanel panelCentral = null;
	// PANEL OPCIONES
	private JPanel panelOpciones = null;
	private JLabel lblProce;
	private JTextField tFProce;
	private JLabel lblOpciones;
	private JComboBox cBOpciones = null;
	private JButton btnConfirmar = null;
	private JButton btnInforme = null;

	// PANEL BARRA ESTADO
	private JPanel barraEstado = null;
	private JTextField tFEstado;

	// LISTAS
	private List<Object> listaDocu = new LinkedList<Object>();
	private List<Object> listaGenerador = new LinkedList<Object>();
	private List<Object> listaAutorizado = new LinkedList<Object>();

	// PANEL REGISTRO
	private JPanel panelRegistro = null;
	private JLabel lblC_Contra;
	private JLabel lblC_Procedimiento;
	private JLabel lblC_Interno;
	private JLabel lblDocVinculadaGeneral;
	private JLabel lblGeneradorDeRegistroGeneral;
	private JLabel lblAutorizadosParaConsultaGeneral;
	private JTextField tFC_Interno;
	private JButton btnAyuda = null;
	private JTextField tFC_Contra;
	private JTextField tFC_Proce;

	// Registro Trabajador
	private String interno = "";
	private String procesoIni = "";
	private String codContra = "";
	private Trabajador dlgT;
	private String generador = "";
	private String autorizado = "";
	private String codGeneral = "";
	private String trabajador = "";
	private JButton btnAceptarFormacin;
	private JTextArea tADocumentos;
	private JTextArea tAGenerador;
	private JTextArea tAAutorizado;

	/**
	 * Constructor por defecto.
	 * 
	 * @param c
	 *            Objeto de tipo cliente.
	 * @param usuario
	 *            Cadena con el rol de usuario.
	 * @param rec
	 *            Objeto tipo RegistroEspe con el registro especifico para
	 *            Gerente.
	 * @param d
	 *            Objeto con la lista de documentos.
	 * @param g
	 *            Objeto Generador con la lista de generadores.
	 * @param a
	 *            Objeto Autorizado con la lista de autorizados.
	 */
	public PantallaTrabajador(Cliente c, String usuario, RegistroEspeC rec,
			ListaDocumentoC d, ListaGeneradorC g, ListaAutorizadoC a) {
		super();
		setResizable(false);
		this.c = c;
		this.rec = rec;
		this.d = d;
		this.g = g;
		this.a = a;
		this.trabajador = usuario;
		initialize();
	}

	/**
	 * Método para inicializar el marco principal.
	 */
	private void initialize() {
		this.setBackground(Color.WHITE);
		this.setIconImage(Toolkit
				.getDefaultToolkit()
				.getImage(
						"img\\iconos\\Pantalla\\Usuarios.png"));
		UIManager.put("OptionPane.background", Color.WHITE);
		UIManager.put("Button.background", Color.WHITE);
		UIManager.put("Panel.background", Color.WHITE);
		UIManager.put("ScrollPane.background", Color.WHITE);
		this.setSize(784, 629);
		this.setJMenuBar(getBarraMenu());
		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle(this.trabajador);
		setAyuda();
	}

	/**
	 * Método que devuelve un panel con los elementos creados para la pantalla
	 * del Trabajador.
	 * 
	 * @return javax.swing.JPanel.
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setBackground(Color.WHITE);
			jContentPane.setBounds(0, 0, 1200, 775);
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getBarraHerramientas(),
					java.awt.BorderLayout.NORTH);
			jContentPane.add(getBarraEstado(), java.awt.BorderLayout.SOUTH);
			jContentPane.add(getPanelCentral(), java.awt.BorderLayout.CENTER);
		}
		return jContentPane;
	}

	/**
	 * Método que inicializa la barra de Menu.
	 * 
	 * @return javax.swing.JMenuBar
	 */
	private JMenuBar getBarraMenu() {
		if (barraMenu == null) {
			barraMenu = new JMenuBar();
			barraMenu.setBorder(null);
			barraMenu.setBounds(new Rectangle(0, 0, 0, 775));
			barraMenu.add(getMenuArchivo());
			barraMenu.add(getMenuProce());
			barraMenu.add(getMenuAyuda());
		}
		return barraMenu;
	}

	/**
	 * Método que inicializa el menu de Archivo.
	 * 
	 * @return javax.swing.JMenu.
	 */
	private JMenu getMenuArchivo() {
		if (menuArchivo == null) {
			menuArchivo = new JMenu();
			menuArchivo.setText("Archivo");
			menuArchivo.setMnemonic(java.awt.event.KeyEvent.VK_A);
			menuArchivo.add(getItemImprimir());
			menuArchivo.addSeparator();
			menuArchivo.add(getItemSalir());
		}
		return menuArchivo;
	}

	/**
	 * Método que inicializa el item de Imprimir.
	 * 
	 * @return javax.swing.JMenuItem.
	 */
	private JMenuItem getItemImprimir() {
		if (mntmImprimir == null) {
			mntmImprimir = new JMenuItem("Imprimir");
			mntmImprimir.setMnemonic(KeyEvent.VK_P);
			mntmImprimir.setEnabled(false);
			mntmImprimir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					imprimir();
				}
			});
			mntmImprimir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,
					InputEvent.CTRL_MASK));
		}
		return mntmImprimir;
	}

	/**
	 * Método para imprimir pantalla del Trabajador.
	 */
	private void imprimir() {
		try {
			PrinterJob job = PrinterJob.getPrinterJob();
			job.setPrintable(this);
			job.printDialog();
			job.print();
		} catch (PrinterException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(),
					"Error Impresora", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Método que inicializa el item de Salir.
	 * 
	 * @return javax.swing.JMenuItem.
	 */
	private JMenuItem getItemSalir() {
		if (itemSalir == null) {
			itemSalir = new JMenuItem();
			itemSalir.setText("Salir");
			itemSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
					java.awt.event.KeyEvent.VK_ESCAPE, 0, false));
			itemSalir.setMnemonic(java.awt.event.KeyEvent.VK_S);
			itemSalir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					setCerrar(true);
					c.setCerrar(true);
					c.despertarHilo();
					dispose();
				}
			});

		}
		return itemSalir;
	}

	/**
	 * Método que inicializa el menu de Procedimiento.
	 * 
	 * @return javax.swing.JMenu.
	 */
	private JMenu getMenuProce() {
		if (menuProce == null) {
			menuProce = new JMenu();
			menuProce.setText("Procedimientos");
			menuProce.setMnemonic(KeyEvent.VK_P);

			JMenu mnProCrear = new JMenu("Crear");
			mnProCrear.setMnemonic(KeyEvent.VK_C);
			menuProce.add(mnProCrear);
			mnProCrear.add(getMntmEspeRH_2());
		}
		return menuProce;
	}

	/**
	 * Método que inicializa el item para el Procedimiento.
	 * 
	 * @return javax.swing.JMenuItem.
	 */
	private JMenuItem getMntmEspeRH_2() {
		if (mntmEspeRH_2 == null) {
			mntmEspeRH_2 = new JMenu("1 Plan de Acogida de Conductores");
			mntmEspeRH_2.add(getMntmRH_2_0());
			mntmEspeRH_2.add(getMntmRH_2_1());
			mntmEspeRH_2.setMnemonic(KeyEvent.VK_1);
		}
		return mntmEspeRH_2;
	}

	/**
	 * Método que inicializa el item de la 1º opción del Procedimiento.
	 * 
	 * @return javax.swing.JMenuItem.
	 */
	private JMenuItem getMntmRH_2_0() {
		if (mntmRH_2_0 == null) {
			mntmRH_2_0 = new JMenuItem("1 Registro de actividades presenciales");
			mntmRH_2_0.setToolTipText("");
			mntmRH_2_0.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					PantallaTrabajador.this.proce = "RH-2";
					setNuevoProce(0);
				}
			});
			mntmRH_2_0.setMnemonic(KeyEvent.VK_1);
		}
		return mntmRH_2_0;
	}

	/**
	 * Método que inicializa el item de la 2º opción del Procedimiento.
	 * 
	 * @return javax.swing.JMenuItem.
	 */
	private JMenuItem getMntmRH_2_1() {
		if (mntmRH_2_1 == null) {
			mntmRH_2_1 = new JMenuItem("2 Registro de informe de formación de "
					+ this.trabajador);
			mntmRH_2_1
					.setText("2 Registro de informe de formaci\u00F3n del trabajador");
			mntmRH_2_1.setToolTipText("");
			mntmRH_2_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					PantallaTrabajador.this.proce = "RH-2";
					setNuevoProce(1);
				}
			});
			mntmRH_2_1.setMnemonic(KeyEvent.VK_2);
		}
		return mntmRH_2_1;
	}

	/**
	 * Método que inicializa el menu de Ayuda.
	 * 
	 * @return javax.swing.JMenu.
	 */
	private JMenu getMenuAyuda() {
		if (menuAyuda == null) {
			menuAyuda = new JMenu();
			menuAyuda.setText("Ayuda");
			menuAyuda.setMnemonic(java.awt.event.KeyEvent.VK_Y);
			menuAyuda.add(getMntmAyuda());
			menuAyuda.addSeparator();
			menuAyuda.add(getMntmAcercadeTrabajador());
		}
		return menuAyuda;
	}

	/**
	 * Método que inicializa el item del Acerca de.
	 * 
	 * @return javax.swing.JMenuItem.
	 */
	private JMenuItem getMntmAcercadeTrabajador() {
		if (mntmAcercadeTrabajador == null) {
			mntmAcercadeTrabajador = new JMenuItem("Acerca de");
			mntmAcercadeTrabajador.setMnemonic(KeyEvent.VK_R);
			mntmAcercadeTrabajador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane
							.showMessageDialog(
									null,
									" Aplicación para "
											+ PantallaTrabajador.this.trabajador
											+ "\n Proyecto de Sistema de Registro de Eventos de Procesos Empresariales "
											+ "\n Pablo González Jiménez",
									" Acerca de "
											+ PantallaTrabajador.this.trabajador,
									3);
				}
			});
		}
		return mntmAcercadeTrabajador;
	}

	/**
	 * Método que inicializa el item de la Ayuda.
	 * 
	 * @return javax.swing.JMenuItem.
	 */
	private JMenuItem getMntmAyuda() {
		if (mntmAyuda == null) {
			mntmAyuda = new JMenuItem("Ayuda");
			mntmAyuda.setMnemonic(KeyEvent.VK_A);
			mntmAyuda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		}
		return mntmAyuda;
	}

	/**
	 * Método que inicializa la barra de Herramientas.
	 * 
	 * @return javax.swing.JToolBar.
	 */
	private JToolBar getBarraHerramientas() {
		if (barraHerramientas == null) {
			barraHerramientas = new JToolBar();
			barraHerramientas.setBackground(Color.WHITE);
			barraHerramientas.add(getBtGenerar());
			barraHerramientas.add(getBtImprimir());
		}
		return barraHerramientas;
	}

	/**
	 * Método que inicializa el botón de Generar o Validar informes.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtGenerar() {
		if (btGenerar == null) {
			btGenerar = new JButton();
			btGenerar.setBackground(Color.WHITE);
			btGenerar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int n = 0;
					String pa = "";
					pa = JOptionPane
							.showInputDialog(" Registro de actividades presenciales -> 1 \n Registro de informe de formación de "
									+ PantallaTrabajador.this.trabajador
									+ " -> 2 ");

					if (pa != null && pa.compareTo("") != 0) {
						n = Integer.parseInt(pa);
						n--;
						setNuevoProce(n);
					}
				}
			});
			btGenerar.setToolTipText("Generar o a\u00F1adir informe");
			btGenerar.setSize(new java.awt.Dimension(24, 24));
			// NO DEJAR MARGENES ENTRE LOS BOTONES
			btGenerar.setMargin(new java.awt.Insets(0, 0, 0, 0));
			btGenerar.setMaximumSize(new java.awt.Dimension(30, 30));
			btGenerar.setMinimumSize(new java.awt.Dimension(30, 30));
			// DESPINTAR EL BORDE
			btGenerar.setBorderPainted(false);
			btGenerar.setContentAreaFilled(false);
			btGenerar.setIcon(new ImageIcon("img/iconos/Nuevo.png"));
		}
		return btGenerar;
	}

	/**
	 * Método que inicializa el botón de Imprimir.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtImprimir() {
		if (btImprimir == null) {
			btImprimir = new JButton();
			btImprimir.setBackground(Color.WHITE);
			btImprimir.setEnabled(false);
			btImprimir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					imprimir();
				}
			});
			btImprimir.setToolTipText("Imprimir");
			btImprimir.setSize(new java.awt.Dimension(24, 24));
			btImprimir.setMargin(new java.awt.Insets(0, 0, 0, 0));
			btImprimir.setMaximumSize(new java.awt.Dimension(30, 30));
			btImprimir.setMinimumSize(new java.awt.Dimension(30, 30));
			btImprimir.setPreferredSize(new java.awt.Dimension(30, 30));
			btImprimir.setBorderPainted(false);
			btImprimir.setContentAreaFilled(false);
			btImprimir.setIcon(new ImageIcon("img/iconos/Imprimir.png"));
		}
		return btImprimir;
	}

	/**
	 * Método que inicializa el panel de Estado.
	 * 
	 * @return javax.swing.JPanel.
	 */
	private JPanel getBarraEstado() {
		if (barraEstado == null) {
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(1);
			gridLayout.setColumns(4);
			barraEstado = new JPanel();
			barraEstado.setBackground(Color.WHITE);
			barraEstado.setLayout(gridLayout);
			barraEstado.add(getTFEstado());
		}
		return barraEstado;
	}

	/**
	 * Método que inicializa el JTextField de la barra de Estado.
	 * 
	 * @return javax.swing.JTextField.
	 */
	private JTextField getTFEstado() {
		if (tFEstado == null) {
			tFEstado = new JTextField();
			tFEstado.setToolTipText("Mensaje de estado");
			tFEstado.setForeground(Color.RED);
			tFEstado.setFont(new Font("Tahoma", Font.BOLD, 11));
			tFEstado.setEditable(false);
			tFEstado.setColumns(10);
			tFEstado.setBackground(Color.WHITE);
		}
		return tFEstado;
	}

	/**
	 * Getter.
	 * 
	 * @return JTextField con el estado.
	 */
	public JTextField getEstado() {
		return tFEstado;
	}

	/**
	 * Método que inicializa el panel central.
	 * 
	 * @return javax.swing.JPanel.
	 */
	private JPanel getPanelCentral() {
		if (panelCentral == null) {
			panelCentral = new JPanel();
			panelCentral.setBackground(Color.WHITE);
			panelCentral.setAlignmentX(Component.LEFT_ALIGNMENT);
			panelCentral.setLayout(null);
			panelCentral.add(getPanelOpciones());
			panelCentral.add(getPanelRegistro());
		}
		return panelCentral;
	}

	/**
	 * Método que inicializa el panel de Opciones.
	 * 
	 * @return javax.swing.JPanel.
	 */
	private JPanel getPanelOpciones() {
		if (panelOpciones == null) {
			panelOpciones = new JPanel();
			panelOpciones.setBackground(Color.WHITE);
			panelOpciones.setBounds(0, 0, 270, 529);
			panelOpciones.setBorder(new TitledBorder(null,
					"Opciones Trabajador " + this.trabajador,
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelOpciones.setLayout(null);
			panelOpciones.add(getbtnConfirmar());
			panelOpciones.add(getComboProce(), null);
			panelOpciones.add(getLblProce());
			panelOpciones.add(getLblOpciones());

			tFProce = new JTextField();
			tFProce.setToolTipText("Procedimiento");
			tFProce.setText("Plan de Acogida de Conductores");
			tFProce.setEditable(false);
			tFProce.setBounds(24, 88, 222, 20);
			panelOpciones.add(tFProce);
			tFProce.setColumns(10);

			panelOpciones.add(getBtnInforme(), null);
			panelOpciones.add(getBtnAceptarFormacin(), null);
		}
		return panelOpciones;
	}

	/**
	 * Método que inicializa la etiqueta de Procedimiento.
	 * 
	 * @return javax.swing.JLabel.
	 */
	private JLabel getLblProce() {
		if (lblProce == null) {
			lblProce = new JLabel("Procedimiento:");
			lblProce.setBounds(23, 63, 81, 14);
		}
		return lblProce;
	}

	/**
	 * Método que inicializa la etiqueta de Opciónes.
	 * 
	 * @return javax.swing.JLabel.
	 */
	private JLabel getLblOpciones() {
		if (lblOpciones == null) {
			lblOpciones = new JLabel("Opciones:");
			lblOpciones.setBounds(23, 127, 69, 14);
		}
		return lblOpciones;
	}

	/**
	 * Método que inicializa el combobox de las opciones para el procedimiento.
	 * 
	 * @return javax.swing.JComboBox.
	 */
	private JComboBox getComboProce() {
		if (cBOpciones == null) {
			UIManager.put("ComboBox.disabledBackground", Color.WHITE);
			cBOpciones = new JComboBox();
			cBOpciones.setModel(new DefaultComboBoxModel(new String[] {
					"Confirmar Actividades Presenciales",
					"Informe de Formaci\u00F3n del Trabajador" }));
			cBOpciones.setBackground(Color.WHITE);
			cBOpciones.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (cBOpciones.getSelectedIndex() == 0) {
						btnConfirmar.setEnabled(true);
					} else {
						btnInforme.setEnabled(true);
					}
				}
			});
			cBOpciones.setBounds(24, 152, 222, 22);
		}
		return cBOpciones;
	}

	/**
	 * Método que inicializa el botón de Confirmar actividades del Trabajador.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getbtnConfirmar() {
		if (btnConfirmar == null) {
			btnConfirmar = new JButton("Confirmar");
			btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnConfirmar.setBackground(Color.WHITE);
			btnConfirmar
					.setToolTipText("Confirmar realizaci\u00F3n de actividades");
			btnConfirmar.setEnabled(false);
			btnConfirmar.setMnemonic(KeyEvent.VK_C);
			btnConfirmar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int n = cBOpciones.getSelectedIndex();
					setNuevoProce(n);
				}
			});
			btnConfirmar.setBounds(24, 185, 91, 23);
		}
		return btnConfirmar;
	}

	/**
	 * Método que inicializa el botón de Añadir Informe.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtnInforme() {
		if (btnInforme == null) {
			btnInforme = new JButton("A\u00F1adir Informe");
			btnInforme.setMnemonic(KeyEvent.VK_I);
			btnInforme.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mntmRH_2_1.setEnabled(true);
					int n = cBOpciones.getSelectedIndex();
					setNuevoProce(n);
				}
			});
			btnInforme.setEnabled(false);
			btnInforme.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnInforme.setBackground(Color.WHITE);
			btnInforme.setBounds(125, 185, 121, 23);
		}
		return btnInforme;
	}

	/**
	 * Método que dependiendo lo que se selecciono en el combo realizará una
	 * opción o la otra.
	 * 
	 * @param n
	 *            Entero con la opción a realizar.
	 */
	private void setNuevoProce(int n) {
		tFEstado.setText("");
		switch (n) {
		case 0:
			try {
				// PASO 1, AL EXISTIR TRABAJADOR EXISTIRA EL COD. CONTRATO
				trabajador(1);

				if (correcto) {
					c.despertarHilo();
					rellenarInfoRegistro(n);
				} else {
					JOptionPane.showMessageDialog(null,
							"Confirmar Actividades Presenciales, Cancelado",
							this.trabajador, JOptionPane.INFORMATION_MESSAGE);
				}

			} catch (Exception e) {
				tFEstado.setText("ERROR " + e.getMessage());
			}
			break;

		case 1:
			// PASO 2
			// SI EXISTE EL ANTERIOR CREAMOS EL PASO 2 CON SU CODCONTRATACION
			try {
				setCorrecto(false);
				codContra = this.c.getContratoTrabajador(this.trabajador,
						this.proce + "-r01");
				if (this.codContra.compareTo("") != 0) {

					trabajador(2);

					if (correcto) {
						c.despertarHilo();
						rellenarInfoRegistro(n);
					} else {
						JOptionPane
								.showMessageDialog(
										null,
										"Mandar Informe y confirmar Actividades Terminadas, Cancelado",
										this.trabajador,
										JOptionPane.INFORMATION_MESSAGE);
					}

				} else {
					tFEstado.setText("Cód. Contrato erroneo para "
							+ this.trabajador);
				}
			} catch (Exception e) {
				tFEstado.setText("ERROR Cargar paso 2" + e.getMessage());
			}
			break;
		}
	}

	/**
	 * Método que crea una pantalla dialogo, para que el trabajador confirme
	 * actividades y agregue documentos.
	 * 
	 * @param i
	 *            Entero con la opción elegida por el trabajador a completar.
	 */
	private void trabajador(int i) {
		dlgT = new Trabajador(i, this);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = dlgT.getSize();
		if (frameSize.height > screenSize.height)
			frameSize.height = screenSize.height;
		if (frameSize.width > screenSize.width)
			frameSize.width = screenSize.width;
		dlgT.setLocation((screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.height) / 2);
		// Para que el aspecto sea según donde se abra, unix, mac....
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		dlgT.setModal(true);
		dlgT.setVisible(true);
	}

	/**
	 * Getter.
	 * 
	 * @return Lista con la lista de documentos.
	 */
	public List<Object> getListaDocu() {
		return listaDocu;
	}

	/**
	 * Setter.
	 * 
	 * @param listaDocu
	 *            Lista con los documentos.
	 */
	public void setListaDocu(List<Object> listaDocu) {
		this.listaDocu = listaDocu;
		correcto = true;
	}

	/**
	 * Método para rellenar el registro especifico de Trabajador.
	 */
	private void rellenarInfoRegistro(int n) {
		interno = codigo();
		this.tFC_Interno.setText(interno);

		procesoIni = this.proce + "-r00";
		this.tFC_Proce.setText(procesoIni);

		try {
			this.codContra = this.c.getContratoTrabajador(this.trabajador,
					this.proce + "-r00");
		} catch (Exception e) {
			tFEstado.setText("ERROR, " + e.getMessage());
		}
		this.tFC_Contra.setText(codContra);

		String docu = "";
		for (int i = 0; i < getListaDocu().size(); i++) {
			if (i == 0) {
				docu = getListaDocu().get(i).toString();
			} else {
				docu += ", " + getListaDocu().get(i).toString();
			}
		}
		tADocumentos.setText(docu);

		generador = trabajador;
		this.listaGenerador.removeAll(listaGenerador);
		this.listaGenerador.add(generador);
		tAGenerador.setText(generador);

		autorizado = "Departamento de RRHH";
		this.listaAutorizado.removeAll(listaAutorizado);
		this.listaAutorizado.add(autorizado);
		tAAutorizado.setText(autorizado);

		if (n == 0) {
			codGeneral = this.proce + "-r01";
		} else if (n == 1) {
			codGeneral = this.proce + "-r02";
		}

		// Activar botones
		btImprimir.setEnabled(true);
		mntmImprimir.setEnabled(true);
		mntmRH_2_1.setEnabled(true);
		btnAceptarFormacin.setEnabled(true);
	}

	/**
	 * Método para crear el código interno para el registro.
	 * 
	 * @return Cadena con número del código interno.
	 */
	private String codigo() {
		Date date = new Date();
		String cod = "";
		SimpleDateFormat sdf = new SimpleDateFormat();

		// Fecha
		String fecha = new String("yyyyMMdd");
		sdf.applyPattern(fecha);
		fecha = sdf.format(date);

		// Hora
		/*
		 * Imprimimos la hora en formato 24h, IMPORTANTE LOS MILISEGUNDOS
		 * TAMBIEN DIA Y MES
		 */
		String hora = new String("HHmmss");
		sdf.applyPattern(hora);
		hora = sdf.format(date);

		// Numero
		Formatter fmt = new Formatter();

		int numRegistro = -1;
		try {
			numRegistro = c.getNumRegistro(proce);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"Error Número de Registros", JOptionPane.ERROR_MESSAGE);
		}
		fmt.format("%06d", numRegistro);
		cod = fecha + hora + fmt;
		return cod;
	}

	/**
	 * Método que inicializa el botón de Aceptar Formación.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtnAceptarFormacin() {
		if (btnAceptarFormacin == null) {
			btnAceptarFormacin = new JButton("Aceptar Formaci\u00F3n");
			btnAceptarFormacin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					enviar();
				}
			});
			btnAceptarFormacin.setEnabled(false);
			btnAceptarFormacin.setMnemonic(KeyEvent.VK_F);
			btnAceptarFormacin.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnAceptarFormacin.setBackground(Color.WHITE);
			btnAceptarFormacin.setBounds(64, 495, 141, 23);
		}
		return btnAceptarFormacin;
	}

	/**
	 * Método para enviar el registro a almacenar.
	 */
	private void enviar() {
		// REGISTRO ESPECIFICO
		rec.setC_Interno(interno);
		rec.setC_Proce(procesoIni);
		rec.setC_Contra(codContra);
		rec.setIndexacion(trabajador);
		rec.setCodGeneral(codGeneral);

		// LISTA DOCUMENTOS
		d.ListaDocumento(interno, listaDocu);

		// LISTA GENERADOR
		g.ListaGenerador(interno, listaGenerador);

		// LISTA AUTORIZADO
		a.ListaAutorizado(interno, listaAutorizado);

		rec.despertarHilo();

		btnAceptarFormacin.setEnabled(false);
	}

	/**
	 * Método que inicializa el panel del registro creado.
	 * 
	 * @return javax.swing.JPanel.
	 */
	private JPanel getPanelRegistro() {
		if (panelRegistro == null) {
			panelRegistro = new JPanel();
			panelRegistro.setBorder(new TitledBorder(null,
					"Informaci\u00F3n Registro", TitledBorder.LEADING,
					TitledBorder.TOP, null, null));
			panelRegistro.setBounds(new Rectangle(280, 0, 496, 529));
			panelRegistro.setBackground(Color.WHITE);
			panelRegistro.setLayout(null);

			lblC_Contra = new JLabel("C\u00F3d. Contrataci\u00F3n:");
			lblC_Contra.setBounds(28, 150, 114, 14);
			panelRegistro.add(lblC_Contra);

			lblC_Procedimiento = new JLabel("Cod. Procedimiento:");
			lblC_Procedimiento.setBounds(28, 113, 125, 14);
			panelRegistro.add(lblC_Procedimiento);

			lblC_Interno = new JLabel("C\u00F3d. Interno:");
			lblC_Interno.setBounds(28, 75, 82, 14);
			panelRegistro.add(lblC_Interno);

			lblDocVinculadaGeneral = new JLabel("Documentos Vinculados:");
			lblDocVinculadaGeneral.setBounds(28, 188, 142, 14);
			panelRegistro.add(lblDocVinculadaGeneral);

			lblGeneradorDeRegistroGeneral = new JLabel(
					"Generadores de Registro:");
			lblGeneradorDeRegistroGeneral.setBounds(28, 273, 142, 14);
			panelRegistro.add(lblGeneradorDeRegistroGeneral);

			lblAutorizadosParaConsultaGeneral = new JLabel(
					"Autorizados Consulta:");
			lblAutorizadosParaConsultaGeneral.setBounds(28, 335, 125, 14);
			panelRegistro.add(lblAutorizadosParaConsultaGeneral);

			tFC_Proce = new JTextField();
			tFC_Proce.setBackground(SystemColor.control);
			tFC_Proce.setEditable(false);
			tFC_Proce.setBounds(179, 110, 55, 20);
			panelRegistro.add(tFC_Proce);
			tFC_Proce.setToolTipText("C\u00F3digo del primer registro");
			tFC_Proce.setColumns(10);

			tFC_Interno = new JTextField();
			tFC_Interno.setBackground(SystemColor.control);
			tFC_Interno.setEditable(false);
			tFC_Interno.setBounds(179, 72, 286, 20);
			panelRegistro.add(tFC_Interno);
			tFC_Interno
					.setToolTipText("AAAAMMDD - Fecha    HHMMSS - Hora    RRRRRR - N\u00FAmero correlativo de seis cifras que guarda la secuencia de generaci\u00F3n de registros");
			tFC_Interno.setColumns(10);

			tFC_Contra = new JTextField();
			tFC_Contra.setBackground(SystemColor.control);
			tFC_Contra.setEditable(false);
			tFC_Contra.setBounds(180, 147, 286, 20);
			panelRegistro.add(tFC_Contra);
			tFC_Contra.setToolTipText("C\u00F3digo de contrataci\u00F3n ");
			tFC_Contra.setColumns(10);

			panelRegistro.add(getBtnAyuda(), null);

			JScrollPane scrollPaneDocus = new JScrollPane();
			scrollPaneDocus.setToolTipText("Documentos Registro " + trabajador);
			scrollPaneDocus.setBounds(new Rectangle(10, 244, 336, 126));
			scrollPaneDocus.setBounds(180, 188, 285, 65);
			panelRegistro.add(scrollPaneDocus);
			scrollPaneDocus.setViewportView(getTADocumentos());

			JScrollPane scrollPaneGenerador = new JScrollPane();
			scrollPaneGenerador.setToolTipText("Generadores Registro "
					+ trabajador);
			scrollPaneGenerador.setBounds(new Rectangle(10, 244, 336, 126));
			scrollPaneGenerador.setBounds(180, 273, 285, 39);
			panelRegistro.add(scrollPaneGenerador);
			scrollPaneGenerador.setViewportView(getTAGenerador());

			JScrollPane scrollPaneAutorizado = new JScrollPane();
			scrollPaneAutorizado.setToolTipText("Autorizados Registro "
					+ trabajador);
			scrollPaneAutorizado.setBounds(new Rectangle(10, 244, 336, 126));
			scrollPaneAutorizado.setBounds(179, 335, 285, 39);
			panelRegistro.add(scrollPaneAutorizado);
			scrollPaneAutorizado.setViewportView(getTAAutorizado());
		}
		return panelRegistro;
	}

	/**
	 * Método que inicializa JTextArea de los documentos.
	 * 
	 * @return javax.swing.JTextArea.
	 */
	private JTextArea getTADocumentos() {
		if (tADocumentos == null) {
			tADocumentos = new JTextArea();
			tADocumentos.setWrapStyleWord(true);
			tADocumentos.setLineWrap(true);
			tADocumentos.setEditable(false);
		}
		return tADocumentos;
	}

	/**
	 * Método que inicializa JTextArea de las personas generadoras.
	 * 
	 * @return javax.swing.JTextArea.
	 */
	private JTextArea getTAGenerador() {
		if (tAGenerador == null) {
			tAGenerador = new JTextArea();
			tAGenerador.setEditable(false);
			tAGenerador.setLineWrap(true);
			tAGenerador.setWrapStyleWord(true);
		}
		return tAGenerador;
	}

	/**
	 * Método que inicializa JTextArea de las personas autorizadas.
	 * 
	 * @return javax.swing.JTextArea.
	 */
	private JTextArea getTAAutorizado() {
		if (tAAutorizado == null) {
			tAAutorizado = new JTextArea();
			tAAutorizado.setWrapStyleWord(true);
			tAAutorizado.setLineWrap(true);
			tAAutorizado.setEditable(false);
		}
		return tAAutorizado;
	}

	/**
	 * Método que inicializa el botón de Ayuda en el panel del registro.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtnAyuda() {
		if (btnAyuda == null) {
			btnAyuda = new JButton("");
			btnAyuda.setLocation(10, 480);
			btnAyuda.setIcon(new ImageIcon(
					"img\\iconos\\Info.png"));
			btnAyuda.setToolTipText("Ayuda");
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
	 * Getter.
	 * 
	 * @return correcto Boolean con true o false si el añadir documentos y
	 *         checklist de actividades fue correcto.
	 */
	public boolean isCorrecto() {
		return correcto;
	}

	/**
	 * Setter.
	 * 
	 * @param correcto
	 *            Boolean true si todo a ido bien false para caso contrario.
	 */
	public void setCorrecto(boolean correcto) {
		this.correcto = correcto;
	}

	/**
	 * Getter.
	 * 
	 * @return cerrar Boolean con true o false si se cerro o no la ventana.
	 */
	public boolean isCerrar() {
		return cerrar;
	}

	/**
	 * Setter.
	 * 
	 * @param cerrar
	 *            Booleano true o false de si se ha cerrado la ventana.
	 */
	public void setCerrar(boolean cerrar) {
		this.cerrar = cerrar;
	}

	/**
	 * Método para acceder a la ayuda en la aplicación.
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
			hb.enableHelpOnButton(mntmAyuda, "trabajador", hs);
			// Ayuda para botón
			hb.enableHelpOnButton(btnAyuda, "trabajador", hs);
			// Desplega ayuda pulsando sobre F1
			hb.enableHelpKey(this.getContentPane(), "trabajador", hs);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,
					"Fichero de Ayuda no encontrado " + e.getMessage(),
					"Ayuda", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	/**
	 * Método que sobreescribe PRINT para poder imprimir por impresora.
	 */
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
			throws PrinterException {

		if (pageIndex > 0) { /* We have only one page, and 'page' is zero-based */
			return NO_SUCH_PAGE;
		}

		Graphics2D g2d = (Graphics2D) graphics;
		g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

		panelRegistro.printAll(graphics);

		return PAGE_EXISTS;
	}
} // @jve:decl-index=0:visual-constraint="10,10"
