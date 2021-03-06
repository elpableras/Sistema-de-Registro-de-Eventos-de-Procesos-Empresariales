package com.ws.cliente.form;

import java.awt.*;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.*;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import com.ws.cliente.Cliente;
import com.ws.cliente.form.dialog.Documento;
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
import javax.swing.border.EtchedBorder;

/**
 * Clase que define la interfaz de la pantalla Gerente,
 * hereda de JFrame e implementa la clase abstracta Printable.
 */
public class PantallaGerente extends JFrame implements Printable {

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
	private JMenu menuAyuda = null;
	private JMenuItem mntmAyuda;
	private JMenuItem mntmAcercadeGerente;

	// PANEL BARRA HERRAMIENTAS
	private JToolBar barraHerramientas = null;
	private JButton btVer = null;
	private JButton btImprimir = null;

	// PANEL CENTRAL
	private JPanel panelCentral = null;
	// PANEL OPCIONES
	private JPanel panelOpciones = null;
	private JLabel lblProce;
	private JTextField txtPlanDeAcogida;
	private JLabel lblOpcion;
	private JTextField txtValidacinGerente;
	private JButton btnVer = null;
	private JScrollPane scrollPanelListaContratos = null;
	private DefaultListModel modeloLista = null;
	private JList listaContratos = null;
	private JButton btnSeleccionar = null;
	private JButton btnAceptarValidacion = null;

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

	// Registro Gerente
	private String interno = "";
	private String procesoIni = "";
	private String codContra = "";
	private Documento dlgD;
	private String generador = "";
	private String autorizado = "";
	private String codGeneral = "";
	private String trabajador = "";
	private JTextArea tADocumentos;
	private JTextArea tAGenerador;
	private JTextArea tAAutorizado;

	/**
	 * Constructor por defecto.
	 * 
	 * @param c
	 *            Objeto de tipo cliente.
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
	public PantallaGerente(Cliente c, RegistroEspeC rec, ListaDocumentoC d,
			ListaGeneradorC g, ListaAutorizadoC a) {
		super();
		setResizable(false);
		this.c = c;
		this.rec = rec;
		this.d = d;
		this.g = g;
		this.a = a;
		initialize();
	}

	/**
	 * M�todo para inicializar el marco principal.
	 */
	private void initialize() {
		this.setBackground(Color.WHITE);
		UIManager.put("OptionPane.background", Color.WHITE);
		UIManager.put("Button.background", Color.WHITE);
		UIManager.put("Panel.background", Color.WHITE);
		UIManager.put("ScrollPane.background", Color.WHITE);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("img\\iconos\\Pantalla\\Usuarios.png"));
		this.setSize(784, 629);
		this.setJMenuBar(getBarraMenu());
		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Gerente");
		setAyuda();
	}

	/**
	 * M�todo que devuelve un panel con los elementos creados para la pantalla
	 * de Gerente.
	 * 
	 * @return javax.swing.JPanel.
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
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
	 * M�todo que inicializa la barra de Menu.
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
	 * M�todo que inicializa el menu de Archivo.
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
	 * M�todo que inicializa el item de Imprimir.
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
	 * M�todo para imprimir pantalla Gerente.
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
	 * M�todo que inicializa el item de Salir.
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
	 * M�todo que inicializa el menu de Procedimiento.
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
	 * M�todo que inicializa el item para el Procedimiento.
	 * 
	 * @return javax.swing.JMenuItem.
	 */
	private JMenuItem getMntmEspeRH_2() {
		if (mntmEspeRH_2 == null) {
			mntmEspeRH_2 = new JMenu("1 Plan de Acogida de Conductores");
			mntmEspeRH_2.add(getMntmRH_2_0());
			mntmEspeRH_2.setMnemonic(KeyEvent.VK_1);
		}
		return mntmEspeRH_2;
	}

	/**
	 * M�todo que inicializa el item de la 1� opci�n del Procedimiento.
	 * 
	 * @return javax.swing.JMenuItem.
	 */
	private JMenuItem getMntmRH_2_0() {
		if (mntmRH_2_0 == null) {
			mntmRH_2_0 = new JMenuItem("1 Validaci\u00F3n Gerente");
			mntmRH_2_0.setToolTipText("");
			mntmRH_2_0.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mostrarContratos();
				}
			});
			mntmRH_2_0.setMnemonic(KeyEvent.VK_1);
		}
		return mntmRH_2_0;
	}

	/**
	 * M�todo que inicializa el menu de Ayuda.
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
			menuAyuda.add(getMntmAcercadeGerente());
		}
		return menuAyuda;
	}

	/**
	 * M�todo que inicializa el item del Acerca de.
	 * 
	 * @return javax.swing.JMenuItem.
	 */
	private JMenuItem getMntmAcercadeGerente() {
		if (mntmAcercadeGerente == null) {
			mntmAcercadeGerente = new JMenuItem("Acerca de");
			mntmAcercadeGerente.setMnemonic(KeyEvent.VK_R);
			mntmAcercadeGerente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane
							.showMessageDialog(
									null,
									" Aplicaci�n para Gerente \n Proyecto de Sistema de Registro de Eventos de Procesos Empresariales \n Pablo Gonz�lez Jim�nez",
									" Acerca de Gerente", 3);
				}
			});
		}
		return mntmAcercadeGerente;
	}

	/**
	 * M�todo que inicializa el item de la Ayuda.
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
	 * M�todo que inicializa la barra de Herramientas.
	 * 
	 * @return javax.swing.JToolBar.
	 */
	private JToolBar getBarraHerramientas() {
		if (barraHerramientas == null) {
			barraHerramientas = new JToolBar();
			barraHerramientas.setBackground(Color.WHITE);
			barraHerramientas.add(getBtVer());
			barraHerramientas.add(getBtImprimir());
		}
		return barraHerramientas;
	}

	/**
	 * M�todo que inicializa el bot�n de Ver Contratos Pendientes.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtVer() {
		if (btVer == null) {
			btVer = new JButton();
			btVer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarContratos();
				}
			});
			btVer.setToolTipText("Ver contratos pendientes");
			btVer.setSize(new java.awt.Dimension(24, 24));
			// NO DEJAR MARGENES ENTRE LOS BOTONES
			btVer.setMargin(new java.awt.Insets(0, 0, 0, 0));
			btVer.setMaximumSize(new java.awt.Dimension(30, 30));
			btVer.setMinimumSize(new java.awt.Dimension(30, 30));
			// DESPINTAR EL BORDE
			btVer.setBorderPainted(false);
			btVer.setContentAreaFilled(false);
			btVer.setIcon(new ImageIcon("img/iconos/Nuevo.png"));
		}
		return btVer;
	}

	/**
	 * M�todo que inicializa el bot�n de Imprimir.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtImprimir() {
		if (btImprimir == null) {
			btImprimir = new JButton();
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
	 * M�todo que inicializa el panel de Estado.
	 * 
	 * @return javax.swing.JPanel.
	 */
	private JPanel getBarraEstado() {
		if (barraEstado == null) {
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(1);
			gridLayout.setColumns(4);
			barraEstado = new JPanel();
			barraEstado.setLayout(gridLayout);
			barraEstado.add(getTFEstado());
		}
		return barraEstado;
	}

	/**
	 * M�todo que inicializa el JTextField de la barra de Estado.
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
	 * M�todo que inicializa el panel central.
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
	 * M�todo que inicializa el panel de Opciones.
	 * 
	 * @return javax.swing.JPanel.
	 */
	private JPanel getPanelOpciones() {
		if (panelOpciones == null) {
			panelOpciones = new JPanel();
			panelOpciones.setBackground(Color.WHITE);
			panelOpciones.setBounds(0, 0, 270, 529);
			panelOpciones.setBorder(new TitledBorder(new EtchedBorder(
					EtchedBorder.LOWERED, null, null), "Opciones Gerente",
					TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0,
							0, 0)));
			panelOpciones.setLayout(null);

			panelOpciones.add(getBtnVer());
			panelOpciones.add(getBtnSeleccionar(), null);
			panelOpciones.add(getScrollPanelListaContratos(), null);
			panelOpciones.add(getLblProce());
			panelOpciones.add(getLblOpcion());

			txtPlanDeAcogida = new JTextField();
			txtPlanDeAcogida.setToolTipText("Procedimiento");
			txtPlanDeAcogida.setText("Plan de Acogida de Conductores");
			txtPlanDeAcogida.setEditable(false);
			txtPlanDeAcogida.setBounds(24, 88, 222, 20);
			panelOpciones.add(txtPlanDeAcogida);
			txtPlanDeAcogida.setColumns(10);

			txtValidacinGerente = new JTextField();
			txtValidacinGerente.setEditable(false);
			txtValidacinGerente.setText("Validaci\u00F3n Gerente");
			txtValidacinGerente.setBounds(24, 154, 222, 20);
			panelOpciones.add(txtValidacinGerente);
			txtValidacinGerente.setColumns(10);

			panelOpciones.add(getBtnValidar(), null);
		}
		return panelOpciones;
	}

	/**
	 * M�todo que inicializa la etiqueta de Procedimiento.
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
	 * M�todo que inicializa la etiqueta de Opci�n.
	 * 
	 * @return javax.swing.JLabel.
	 */
	private JLabel getLblOpcion() {
		if (lblOpcion == null) {
			lblOpcion = new JLabel("Opci\u00F3n:");
			lblOpcion.setBounds(23, 127, 49, 14);
		}
		return lblOpcion;
	}

	/**
	 * M�todo que inicializa el bot�n de Ver Pendientes.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtnVer() {
		if (btnVer == null) {
			btnVer = new JButton("Ver Pendientes");
			btnVer.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnVer.setBackground(Color.WHITE);
			btnVer.setToolTipText("Seleccionar registro para validar");
			btnVer.setMnemonic(KeyEvent.VK_P);
			btnVer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mostrarContratos();
				}
			});
			btnVer.setBounds(75, 185, 119, 23);
		}
		return btnVer;
	}

	/**
	 * M�todo que inicializa el panel de scroll de la Lista de Contratos.
	 * 
	 * @return javax.swing.JScrollPane.
	 */
	private JScrollPane getScrollPanelListaContratos() {
		if (scrollPanelListaContratos == null) {
			scrollPanelListaContratos = new JScrollPane();
			scrollPanelListaContratos.setBackground(Color.WHITE);
			scrollPanelListaContratos.setBorder(new TitledBorder(
					new EtchedBorder(EtchedBorder.LOWERED, null, null),
					"Contratos", TitledBorder.LEADING, TitledBorder.TOP, null,
					new Color(0, 0, 0)));
			scrollPanelListaContratos.setBounds(24, 239, 222, 152);
			scrollPanelListaContratos.setViewportView(getListaContratos());
		}
		return scrollPanelListaContratos;
	}

	/**
	 * M�todo que inicializa la Lista de Contratos.
	 * 
	 * @return javax.swing.JList.
	 */
	private JList getListaContratos() {
		modeloLista = new DefaultListModel();
		if (listaContratos == null) {
			listaContratos = new JList(modeloLista);
		}
		return listaContratos;
	}

	/**
	 * M�todo que para muestra los contratos por validar.
	 */
	public void mostrarContratos() {
		// PASO r03
		// CODIGO DE CONTRATACI�N DIFERENCIAREMOS LOS REGISTROS, RECOGERLO DE LA
		// BASE DE DATOS
		String[] contratos;
		try {
			contratos = this.c.getPasoAnte(this.proce + "-r02",
					this.proce + "-r03").split(",");

			modeloLista.removeAllElements();

			for (int i = 0; i < contratos.length; i++) {
				if (contratos[i] != null && contratos[i].compareTo("") != 0) {
					modeloLista.addElement(contratos[i]);
				}
			}
			if (modeloLista.size() != 0) {
				btnSeleccionar.setEnabled(true);
			}
		} catch (Exception e) {
			tFEstado.setText("ERROR " + e.getMessage());
		}
	}

	/**
	 * M�todo que inicializa el bot�n de A�adir Documentos.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtnSeleccionar() {
		if (btnSeleccionar == null) {
			btnSeleccionar = new JButton("A\u00F1adir Documentaci\u00F3n");
			btnSeleccionar.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnSeleccionar.setBackground(Color.WHITE);
			btnSeleccionar.setEnabled(false);
			btnSeleccionar.setMnemonic(KeyEvent.VK_D);
			btnSeleccionar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (listaContratos.getSelectedValue() != null
							&& listaContratos.getSelectedValue().toString()
									.compareTo("") != 0) {

						String codcontratos[] = listaContratos
								.getSelectedValue().toString().split(" ");
						codContra = codcontratos[0] + " " + codcontratos[1];
						trabajador = codcontratos[2];

						documentos(getListaDocu());

						if (correcto) {
							c.despertarHilo();
							rellenarInfoRegistro();
						} else {
							JOptionPane.showMessageDialog(null,
									"Validaci�n Cancelada", "Gerente",
									JOptionPane.INFORMATION_MESSAGE);
						}

					} else {
						JOptionPane.showMessageDialog(null,
								"El contrato seleccionado es inv�lido",
								"Contrato", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			btnSeleccionar.setToolTipText("Selecciona el contrato a cerrar");
			btnSeleccionar.setBounds(53, 402, 163, 23);
		}
		return btnSeleccionar;
	}

	/**
	 * M�todo para crear una ventana dialogo para agregar los documentos a
	 * a�adir.
	 * 
	 * @param lista
	 *            Lista con los documentos.
	 */
	private void documentos(List<Object> lista) {
		dlgD = new Documento(lista, this);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = dlgD.getSize();
		if (frameSize.height > screenSize.height)
			frameSize.height = screenSize.height;
		if (frameSize.width > screenSize.width)
			frameSize.width = screenSize.width;
		dlgD.setLocation((screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.height) / 2);
		// Para que el aspecto sea seg�n donde se abra, unix, mac....
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		dlgD.setModal(true);
		dlgD.setVisible(true);
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
	 *            Lista con los dicumentos.
	 */
	public void setListaDocu(List<Object> listaDocu) {
		this.listaDocu = listaDocu;
		correcto = true;
	}

	/**
	 * M�todo para rellenar el registro especifico de Gerente.
	 */
	private void rellenarInfoRegistro() {
		interno = codigo();
		this.tFC_Interno.setText(interno);

		procesoIni = this.proce + "-r00";
		this.tFC_Proce.setText(procesoIni);

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

		generador = "Gerente";
		this.listaGenerador.removeAll(listaGenerador);
		this.listaGenerador.add(generador);
		tAGenerador.setText(generador);

		autorizado = "Departamento de RRHH";
		this.listaAutorizado.removeAll(listaAutorizado);
		this.listaAutorizado.add(autorizado);
		tAAutorizado.setText(autorizado);

		codGeneral = this.proce + "-r03";

		// Activar botones para imprimir Panel Registro
		btImprimir.setEnabled(true);
		mntmImprimir.setEnabled(true);
		btnAceptarValidacion.setEnabled(true);
	}

	/**
	 * M�todo para crear el c�digo interno para el registro.
	 * 
	 * @return Cadena con n�mero del c�digo interno.
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
					"Error N�mero de Registros", JOptionPane.ERROR_MESSAGE);
		}
		fmt.format("%06d", numRegistro);
		cod = fecha + hora + fmt;
		return cod;
	}

	/**
	 * M�todo que inicializa el bot�n de Aceptar Validaci�n.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtnValidar() {
		if (btnAceptarValidacion == null) {
			btnAceptarValidacion = new JButton("Aceptar Validaci\u00F3n");
			btnAceptarValidacion.setEnabled(false);
			btnAceptarValidacion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					enviar();
				}
			});
			btnAceptarValidacion.setMnemonic(KeyEvent.VK_V);
			btnAceptarValidacion.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnAceptarValidacion.setBackground(Color.WHITE);
			btnAceptarValidacion.setBounds(64, 495, 141, 23);
		}
		return btnAceptarValidacion;
	}

	/**
	 * M�todo para enviar el registro a almacenar.
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

		btnAceptarValidacion.setEnabled(false);
	}

	/**
	 * M�todo que inicializa el panel del registro creado.
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

			lblGeneradorDeRegistroGeneral = new JLabel("Generadores de Registro:");
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
			scrollPaneDocus.setToolTipText("Documentos Registro Gerente");
			scrollPaneDocus.setBounds(new Rectangle(10, 244, 336, 126));
			scrollPaneDocus.setBounds(180, 188, 285, 65);
			panelRegistro.add(scrollPaneDocus);
			scrollPaneDocus.setViewportView(getTADocumentos());

			JScrollPane scrollPaneGenerador = new JScrollPane();
			scrollPaneGenerador.setToolTipText("Generadores Registro Gerente");
			scrollPaneGenerador.setBounds(new Rectangle(10, 244, 336, 126));
			scrollPaneGenerador.setBounds(180, 273, 285, 39);
			panelRegistro.add(scrollPaneGenerador);
			scrollPaneGenerador.setViewportView(getTAGenerador());

			JScrollPane scrollPaneAutorizado = new JScrollPane();
			scrollPaneAutorizado.setToolTipText("Autorizados Registro Gerente");
			scrollPaneAutorizado.setBounds(new Rectangle(10, 244, 336, 126));
			scrollPaneAutorizado.setBounds(179, 335, 285, 39);
			panelRegistro.add(scrollPaneAutorizado);
			scrollPaneAutorizado.setViewportView(getTAAutorizado());
		}
		return panelRegistro;
	}

	/**
	 * M�todo que inicializa el bot�n de Ayuda en el panel del registro.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtnAyuda() {
		if (btnAyuda == null) {
			btnAyuda = new JButton("");
			btnAyuda.setLocation(10, 480);
			btnAyuda.setIcon(new ImageIcon("img\\iconos\\Info.png"));
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
	 * M�todo que inicializa JTextArea de los documentos.
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
	 * M�todo que inicializa JTextArea de las personas generadoras.
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
	 * M�todo que inicializa JTextArea de las personas autorizadas.
	 * 
	 * @return javax.swing.JTextArea.
	 */
	private JTextArea getTAAutorizado() {
		if (tAAutorizado == null) {
			tAAutorizado = new JTextArea();
			tAAutorizado.setWrapStyleWord(true);
			tAAutorizado.setEditable(false);
			tAAutorizado.setLineWrap(true);
		}
		return tAAutorizado;
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
	 * M�todo para acceder a la ayuda en la aplicaci�n.
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

			// Ayuda para bot�n
			hb.enableHelpOnButton(mntmAyuda, "gerente", hs);
			// Ayuda para bot�n
			hb.enableHelpOnButton(btnAyuda, "gerente", hs);
			// Desplega ayuda pulsando sobre F1
			hb.enableHelpKey(this.getContentPane(), "gerente", hs);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,
					"Fichero de Ayuda no encontrado " + e.getMessage(),
					"Ayuda", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	/**
	 * M�todo que sobreescribe PRINT para poder imprimir por impresora.
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
