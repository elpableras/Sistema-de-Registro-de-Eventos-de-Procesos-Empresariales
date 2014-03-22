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
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;

import javax.swing.border.EtchedBorder;

/**
 * Clase que define la interfaz de la pantalla del Administrador,
 * hereda de JFrame.
 */
public class RegistroAuto extends JFrame implements Printable{

	private boolean cerrar = false;

	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 3526777868741300578L;
	
	// Atributos Panel
	private JPanel jContentPane = null;

	private JMenuBar barraMenu = null;
	private JMenu menuArchivo = null;
	private JMenuItem mntmImprimir = null;
	private JMenuItem itemSalir = null;
	private JMenu menuProce = null;
	private JMenu mnNuevoProce2 = null;
	private JMenu menuAyuda = null;
	private JMenuItem mntmAcercade;

	private JToolBar barraHerramientas = null;
	private JButton btImprimir = null;

	private JPanel panelCentral = null;
	private JPanel panelOpciones = null;
	private JScrollPane panelScrollOpciones = null;
	private JLabel lblProcedimientoACrear;
	private JLabel lblAuto;
	private JButton btnAutoGene = null;
	private JButton btnAutoRRHH1 = null;
	private JButton btnAutoTrabajador1 = null;
	private JButton btnAutoTrabajador2 = null;
	private JButton btnAutoGerente = null;
	private JButton btnAutoRRHH2 = null;
	private JPanel barraEstado = null;

	private JTextField tFEstado;
	private JMenuItem mntmAdiministrador;
	private JMenuItem mntmRrhh;
	private JMenuItem mntmTrabajador;
	private JMenuItem mntmTrabajador_1;
	private JMenuItem mntmGerente;
	private JMenuItem mntmRrhh_1;
	private JMenuItem mntmAyuda;
	private JTextField tFProcedimiento;
	private JButton btnCerrar;
	
	// Atributos Registro Automático
	
	private Cliente cl;
	private String proce = "RH-2";
	private String regAdmin = "";
	private String regEspe = "";
	// Calendario y formatos de los números
	private Calendar cal;
	private Formatter fmt;
	// Contador de contratos y de registros
	private int codContrato;
	private int numRegistro = 0;

	private JTextArea tARegistrosCreados = null;
	private String[] index = { "T" };

	// Registro
	private String interno = "";
	private String procesoIni = "";
	private String codContra = "";
	private String indexacion = "";
	private String pass = "";
	private String codGeneral = "";
	private String generador = "";
	private String autorizado = "";
	private String descripcion = "";
	private String enlace = "";
			
	private JButton btnAyuda;

	/**
	 * Constructor por defecto.
	 * 
	 * @param c
	 *            Objeto de tipo cliente.
	 */
	public RegistroAuto(Cliente c) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		this.cl = c;
		initialize();
	}

	/**
	 * Método para inicializar el marco principal.
	 */
	private void initialize() {
		UIManager.put("OptionPane.background", Color.HSBtoRGB(212, 208, 200));
		UIManager.put("Button.background", Color.HSBtoRGB(212, 208, 200));
		UIManager.put("Panel.background", Color.HSBtoRGB(212, 208, 200));
		UIManager.put("ScrollPane.background", Color.HSBtoRGB(212, 208, 200));
		this.setSize(784, 629);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("img\\iconos\\Pantalla\\Autom\u00E1tico.png"));
		this.setJMenuBar(getBarraMenu());
		this.setContentPane(getJContentPane());
		this.setTitle("Registros Autom\u00E1ticos");
		setAyuda();
	}

	/**
	 * Método que devuelve un panel con los elementos creados para la pantalla
	 * de Administrador.
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
	 * Método que inicializa la barra de Menu.
	 * 
	 * @return javax.swing.JMenuBar.
	 */
	private JMenuBar getBarraMenu() {
		if (barraMenu == null) {
			barraMenu = new JMenuBar();
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
	 * Método para imprimir.
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
			mnProCrear.add(getMnNuevoProce2());
		}
		return menuProce;
	}
	
	/**
	 * Método que inicializa el item de crear automaticamente los Procedimientos.
	 * 
	 * @return javax.swing.JMenuItem.
	 */
	private JMenuItem getMntmAdiministrador() {
		if (mntmAdiministrador == null) {
			mntmAdiministrador = new JMenuItem("1 Administrador");
			mntmAdiministrador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					general();		
				}
			});
			mntmAdiministrador.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.CTRL_MASK));
			mntmAdiministrador.setMnemonic(KeyEvent.VK_1);
		}
		return mntmAdiministrador;
	}

	/**
	 * Método que inicializa el menu de Procedimiento.
	 * 
	 * @return javax.swing.JMenu..
	 */
	private JMenu getMnNuevoProce2() {
		if (mnNuevoProce2 == null) {
			mnNuevoProce2 = new JMenu("1 Plan de Acogida de Conductores");
			mnNuevoProce2.setToolTipText("");
			mnNuevoProce2.setMnemonic(KeyEvent.VK_1);
			mnNuevoProce2.add(getMntmAdiministrador());
			mnNuevoProce2.setMnemonic(KeyEvent.VK_2);
			
			mntmRrhh = new JMenuItem("2 RRHH 1");
			mntmRrhh.setMnemonic(KeyEvent.VK_2);
			mntmRrhh.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					registroRRHH(0);
				}
			});
			mntmRrhh.setEnabled(false);
			mntmRrhh.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, InputEvent.CTRL_MASK));
			mnNuevoProce2.add(mntmRrhh);
			
			mntmTrabajador = new JMenuItem("3 Trabajador 1");
			mntmTrabajador.setMnemonic(KeyEvent.VK_3);
			mntmTrabajador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					registroTrabajador(0);
				}
			});
			mntmTrabajador.setEnabled(false);
			mntmTrabajador.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, InputEvent.CTRL_MASK));
			mnNuevoProce2.add(mntmTrabajador);
			
			mntmTrabajador_1 = new JMenuItem("4 Trabajador 2");
			mntmTrabajador_1.setMnemonic(KeyEvent.VK_4);
			mntmTrabajador_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					registroTrabajador(1);
				}
			});
			mntmTrabajador_1.setEnabled(false);
			mntmTrabajador_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, InputEvent.CTRL_MASK));
			mnNuevoProce2.add(mntmTrabajador_1);
			
			mntmGerente = new JMenuItem("5 Gerente");
			mntmGerente.setMnemonic(KeyEvent.VK_5);
			mntmGerente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					registroGerente();
				}
			});
			mntmGerente.setEnabled(false);
			mntmGerente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_5, InputEvent.CTRL_MASK));
			mnNuevoProce2.add(mntmGerente);
			
			mntmRrhh_1 = new JMenuItem("6 RRHH 2");
			mntmRrhh_1.setMnemonic(KeyEvent.VK_6);
			mntmRrhh_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					registroRRHH(1);
				}
			});
			mntmRrhh_1.setEnabled(false);
			mntmRrhh_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_6, InputEvent.CTRL_MASK));
			mnNuevoProce2.add(mntmRrhh_1);
		}
		return mnNuevoProce2;
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
			menuAyuda.add(getMntmAcercade());
		}
		return menuAyuda;
	}

	/**
	 * Método que inicializa el item del Acerca de.
	 * 
	 * @return javax.swing.JMenuItem.
	 */
	private JMenuItem getMntmAcercade() {
		if (mntmAcercade == null) {
			mntmAcercade = new JMenuItem("Acerca de");
			mntmAcercade.setMnemonic(KeyEvent.VK_R);
			mntmAcercade.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane
							.showMessageDialog(
									null,
									" Aplicación para la creación de registros automáticos \n Proyecto de Sistema de Registro de Eventos de Procesos Empresariales \n Pablo González Jiménez",
									" Acerca de Registros Automáticos", 3);
				}
			});
		}
		return mntmAcercade;
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
					cl.despertarHilo();
					setCerrar(true);
					cl.setCerrar(true);
					System.exit(0);
				}
			});

		}
		return itemSalir;
	}

	/**
	 * Método que inicializa la barra de Herramientas.
	 * 
	 * @return javax.swing.JToolBar.
	 */
	private JToolBar getBarraHerramientas() {
		if (barraHerramientas == null) {
			barraHerramientas = new JToolBar();
			barraHerramientas.setBackground(new java.awt.Color(208, 204, 204));
			barraHerramientas.add(getBtImprimir());
		}
		return barraHerramientas;
	}

	/**
	 * Método que inicializa el botón de Imprimir.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtImprimir() {
		if (btImprimir == null) {
			btImprimir = new JButton();
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
			btImprimir.setIcon(new ImageIcon("img\\iconos\\Imprimir.png"));
		}
		return btImprimir;
	}

	/**
	 * Método que inicializa el panel de la barra de Estado.
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
	 * Método que inicializa el JTextField de la barra de Estado.
	 * 
	 * @return javax.swing.JTextField.
	 */
	private JTextField getTFEstado() {
		if (tFEstado == null) {
			tFEstado = new JTextField();
			tFEstado.setFont(new Font("Tahoma", Font.BOLD, 11));
			tFEstado.setForeground(Color.RED);
			tFEstado.setToolTipText("Mensaje de estado");
			tFEstado.setEditable(false);
			tFEstado.setBackground(SystemColor.scrollbar);
			tFEstado.setColumns(10);
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
	 * Setter.
	 * 
	 * @param tFEstado
	 *            JTextField con el estado.
	 */
	public void settFEstado(JTextField tFEstado) {
		this.tFEstado = tFEstado;
	}

	/**
	 * Método que inicializa el panel central.
	 * 
	 * @return javax.swing.JPanel.
	 */
	private JPanel getPanelCentral() {
		if (panelCentral == null) {
			panelCentral = new JPanel();
			panelCentral.setAlignmentX(Component.LEFT_ALIGNMENT);
			panelCentral.setLayout(null);
			panelCentral.add(getPanelScrollOpciones());
			
			tARegistrosCreados = new JTextArea();
			tARegistrosCreados.setBounds(1, 1, 116, 49);
			tARegistrosCreados.setEditable(false);
			tARegistrosCreados.setWrapStyleWord(true);
			tARegistrosCreados.setLineWrap(true);
			tARegistrosCreados.setBackground(UIManager.getColor("Panel.background"));
			tARegistrosCreados.setBorder(new TitledBorder(null, "Registros Creados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelCentral.add(tARegistrosCreados);
			
			//luego creamos un JScrollPane que contendra el text area
	        JScrollPane scrollTextArea = new JScrollPane(tARegistrosCreados);
	        scrollTextArea.setBounds(274, 0, 494, 518);
	        
	        //finalmente se agrega el scroll pane al formulario
	        panelCentral.add( scrollTextArea );
		}
		return panelCentral;
	}

	/**
	 * Método que inicializa el panel de scroll de Opciones.
	 * 
	 * @return javax.swing.JScrollPane.
	 */
	private JScrollPane getPanelScrollOpciones() {
		if (panelScrollOpciones == null) {
			panelScrollOpciones = new JScrollPane();
			panelScrollOpciones.setBounds(0, 0, 272, 518);
			panelScrollOpciones.setViewportView(getPanelOpciones());
		}
		return panelScrollOpciones;
	}

	/**
	 * Método que inicializa el panel de Opciones.
	 * 
	 * @return javax.swing.JPanel.
	 */
	private JPanel getPanelOpciones() {
		if (panelOpciones == null) {
			panelOpciones = new JPanel();
			panelOpciones.setToolTipText("");
			panelOpciones.setBounds(0, 0, 250, 700);
			panelOpciones.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Opciones Registros Autom\u00E1ticos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelOpciones.setLayout(null);
			panelOpciones.add(getBtnAutoGene());
			panelOpciones.add(getBtnAutoRRHH1());
			panelOpciones.add(getBtnAutoTrabajador1());
			panelOpciones.add(getBtnAutoTrabajador2());
			panelOpciones.add(getBtnAutoGerente());
			panelOpciones.add(getBtnAutoRRHH2());
			panelOpciones.add(getLblProcedimientoACrear());
			panelOpciones.add(getLblAuto());
			panelOpciones.add(getTFProcedimiento());
			panelOpciones.add(getBtnCerrar());
			panelOpciones.add(getBtnAyuda());
		}
		return panelOpciones;
	}

	/**
	 * Método que inicializa la etiqueta de Crear un Procedimiento.
	 * 
	 * @return javax.swing.JLabel.
	 */
	private JLabel getLblProcedimientoACrear() {
		if (lblProcedimientoACrear == null) {
			lblProcedimientoACrear = new JLabel("Procedimiento:");
			lblProcedimientoACrear.setBounds(23, 63, 118, 14);
		}
		return lblProcedimientoACrear;
	}

	/**
	 * Método que inicializa la etiqueta de Paso a Crear.
	 * 
	 * @return javax.swing.JLabel.
	 */
	private JLabel getLblAuto() {
		if (lblAuto == null) {
			lblAuto = new JLabel("Crear Registros Automaticos:");
			lblAuto.setBounds(23, 134, 155, 14);
		}
		return lblAuto;
	}

	/**
	 * Método que inicializa JTextField de la Lista de Registros.
	 * 
	 * @return javax.swing.JTextField.
	 */
	private JTextField getTFProcedimiento() {
		if (tFProcedimiento == null) {
			tFProcedimiento = new JTextField();
			tFProcedimiento.setToolTipText("Procedimiento");
			tFProcedimiento.setText("Plan de Acogida de Conductores");
			tFProcedimiento.setEditable(false);
			tFProcedimiento.setBounds(37, 88, 193, 20);
			tFProcedimiento.setColumns(10);
		}
		return tFProcedimiento;
	}

	/**
	 * Método que inicializa el botón de Cerrar.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtnCerrar() {
		if (btnCerrar == null) {
			btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cl.despertarHilo();
					setCerrar(true);
					cl.setCerrar(true);
					cl.setPantalla(false);
					dispose();
				}
			});
			btnCerrar.setToolTipText("Cerrar pantalla Admin");
			btnCerrar.setMnemonic(KeyEvent.VK_C);
			btnCerrar.setBounds(161, 482, 69, 23);
		}
		return btnCerrar;
	}
	
	private JButton getBtnAyuda() {
		if (btnAyuda == null) {
			btnAyuda = new JButton("");
			btnAyuda.setLocation(33, 482);
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
	 * Método que inicializa el botón de crear registros generales.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtnAutoGene() {
		if (btnAutoGene == null) {
			btnAutoGene = new JButton("Crear Registros Administrador");
			btnAutoGene.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					general();
				}
			});
			btnAutoGene.setToolTipText("Crear registros autom\u00E1ticos generales");
			btnAutoGene.setMnemonic(KeyEvent.VK_G);
			btnAutoGene.setBounds(44, 167, 182, 23);
		}
		return btnAutoGene;
	}
	
	/**
	 * Método que inicializa el botón de crear registros RRHH1.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtnAutoRRHH1() {
		if (btnAutoRRHH1 == null) {
			btnAutoRRHH1 = new JButton("Crear Registros RRHH 1\u00BA");
			btnAutoRRHH1.setEnabled(false);
			btnAutoRRHH1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					registroRRHH(0);
				}
			});
			btnAutoRRHH1.setMnemonic(KeyEvent.VK_G);
			btnAutoRRHH1.setToolTipText("Registros autom\u00E1ticos RRHH");
			btnAutoRRHH1.setBounds(57, 218, 155, 23);
		}
		return btnAutoRRHH1;
	}
	
	/**
	 * Método que inicializa el botón de crear registros trabajador1.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtnAutoTrabajador1() {
		if (btnAutoTrabajador1 == null) {
			btnAutoTrabajador1 = new JButton("Crear Registros Trabajador 1\u00BA");
			btnAutoTrabajador1.setEnabled(false);
			btnAutoTrabajador1.setMnemonic(KeyEvent.VK_G);
			btnAutoTrabajador1.setToolTipText("Registros autom\u00E1ticos Trabajador");
			btnAutoTrabajador1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					registroTrabajador(0);
				}
			});
			btnAutoTrabajador1.setBounds(44, 252, 182, 23);
		}
		return btnAutoTrabajador1;
	}
	
	/**
	 * Método que inicializa el botón de crear registros trabajador2.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtnAutoTrabajador2() {
		if (btnAutoTrabajador2 == null) {
			btnAutoTrabajador2 = new JButton("Crear Registros Trabajador 2\u00BA");
			btnAutoTrabajador2.setMnemonic(KeyEvent.VK_G);
			btnAutoTrabajador2.setEnabled(false);
			btnAutoTrabajador2.setToolTipText("Registros autom\u00E1ticos Trabajador");
			btnAutoTrabajador2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					registroTrabajador(1);
				}
			});
			btnAutoTrabajador2.setBounds(44, 286, 182, 23);
		}
		return btnAutoTrabajador2;
	}
	
	/**
	 * Método que inicializa el botón de crear registros gerente.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtnAutoGerente() {
		if (btnAutoGerente == null) {
			btnAutoGerente = new JButton("Crear Registros Gerente");
			btnAutoGerente.setEnabled(false);
			btnAutoGerente.setMnemonic(KeyEvent.VK_G);
			btnAutoGerente.setToolTipText("Registros autom\u00E1ticos Gerente");
			btnAutoGerente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					registroGerente();
				}
			});
			btnAutoGerente.setBounds(57, 320, 155, 23);
		}
		return btnAutoGerente;
	}
	
	
	/**
	 * Método que inicializa el botón de crear registros RRHH2.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtnAutoRRHH2() {
		if (btnAutoRRHH2 == null) {
			btnAutoRRHH2 = new JButton("Crear Registros RRHH 2\u00BA");
			btnAutoRRHH2.setEnabled(false);
			btnAutoRRHH2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					registroRRHH(1);
				}
			});
			btnAutoRRHH2.setMnemonic(KeyEvent.VK_G);
			btnAutoRRHH2.setToolTipText("Registros autom\u00E1ticos RRHH");
			btnAutoRRHH2.setBounds(57, 354, 155, 23);
		}
		return btnAutoRRHH2;
	}	
	
	
	/**
	 * Método para crear automaticamente los procedimientos de administrador.
	 */
	private void general() {
		
		String [] datos = new String[] {
				"Inicio de Procedimiento RH-2 - Plan de acogida de Conductores;RH-2-r00;" +
				"Se inicia el Procedimiento del Plan de acogida de Conductores.;E;RH-2;1.- Generar alerta de contratación;;;" +
				"Con cada solicitud de Plan de Acogida;Al generarse la solicitud del Plan de Acogida se genera el registro.;" +
				"Frecuencia de Planes de Acogida  por zona.;Departamento de RRHH;Departamento de RRHH;Archivo RRHH;" +
				"Hasta 5 años después de terminada la relación laboral;Sistema electrónico de registros;" +
				"Traslado al repositorio de registros históricos;Sistema electrónico de registros.",
				
				"Registro de actividades presenciales;RH-2-r01;" +
				"En un checklist el trabajador recoge la realización de las actividades presenciales contempladas en el Plan de Acogida.;" +
				"E;RH-2;Finalización del módulo de actividades presenciales.;;;Cada vez que se inicie un Plan de Acogida;" +
				"Una vez el trabajador ha realizado las actividades presenciales, acepta el checklist y se genera el registro.;;" +
				"Trabajador;Departamento de RRHH;Archivo RRHH;12 meses;Sistema electrónico de registros;Descartar;N/A;",
				
				"Registro de informe de formación del trabajador;RH-2-r02;" +
				"Registro de la generación del informe de la formación realizada por el trabajador.;E;RH-2;Informe sobre formación;;;" +
				"Cada vez que se termina la formación dentro del Plan de Acogida;" +
				"El trabajador termina la formación on-line y señala en el checklist la actividad con terminada.;;Trabajador;" +
				"Departamento de RRHH;Archivo RRHH;12 meses;Sistema electrónico de registros;Descartar;N/A;",
				
				"Validación gerente;RH-2-r03;Este registro recoge el visto bueno dado por el gerente al Plan de acogida realizado por el trabajador."
				+ "- Checklist del trabajador que recoge la realización de las actividades presenciales contempladas en el Plan de Acogida."
				+ "- Checklist que recoge las actividades on-line realizadas por el trabajador."
				+ "- Informe de la entrevista del gerente con el trabajador contemplada en las actividades presenciales del Plan de Acogida.;E;" +
				"RH-2;Posteriormente a la entrevista personal realizada por el gerente;;;Cada vez que se realiza una entrevista personal dentro del Plan de Acogida;" +
				"Una vez realizada la entrevista personal y comprobado por parte del gerente que el checklist de actividades ha sido completado por el trabajador;" +
				";Gerente;Departamento de RRHH;Archivo RRHH;12 meses;Sistema electrónico de registros;Descartar;N/A;",
				
				"Registrar la realización del archivo del checklist;RH-2-r04;Se registra el hecho de haberse archivado la copia digitalizada y física firmada por el gerente.;" +
				"E;RH-2;Cierre del proceso;;;Cada vez que el gerente cierra un Plan de Acogida;" +
				"Al aceptar y cerrar el proceso de alta de nueva relación laboral se genera este registro por la persona que realice la supervisión del proceso desde el Departamento de RRHH.;" +
				";Departamento de RRHH;Departamento de RRHH;Archivo RRHH;12 meses;Sistema electrónico de registros;Descartar;N/A;" };
		
		regAdmin += "Admin_";
		for (int i = 0; i < datos.length; i++) {
			regAdmin += datos[i]+"_";
		}
		
		enviar(0);
		JOptionPane.showMessageDialog(null,
				"Creados 5 registros generales correctamente.",
				"Registros Automáticos", JOptionPane.INFORMATION_MESSAGE);
		btnAutoGene.setEnabled(false);
		mntmAdiministrador.setEnabled(false);
		btnAutoRRHH1.setEnabled(true);
		mntmRrhh.setEnabled(true);
	}
	
	/**
	 * Método para crear los 10 primeros registros para la parte de RRHH opción
	 * 1.
	 */
	private void registroRRHH(int j) {
		if(j == 0){
			// Inicializamos calendario con el calendario actual.
			cal = Calendar.getInstance();
			codContrato = 0;
			regEspe = "";
			for (int i = 0; i < 10; i++) {
				this.interno = codInterno(0);
				this.procesoIni = this.proce+"-r00";
				this.codContra = codContrato();
				this.indexacion = (index[0] + i);
				this.pass = indexacion;
				this.codGeneral = "RH-2-r00";
				this.generador = "Departamento de RRHH;";
				this.autorizado = "Departamento de RRHH;";
				regEspe += interno+"@"+procesoIni+"@"+codContra+"@"+indexacion+"@"+codGeneral+"@"+generador+"@"+autorizado+"@"+pass+"_";
			}
			enviar(1);
			
			JOptionPane.showMessageDialog(null,
					"Creados 10 registros específicos de RRHH paso 1º correctamente.",
					"Registros Automáticos", JOptionPane.INFORMATION_MESSAGE);
			btnAutoRRHH1.setEnabled(false);
			mntmRrhh.setEnabled(false);
			btnAutoTrabajador1.setEnabled(true);
			mntmTrabajador.setEnabled(true);
		}else{
			// Inicializamos calendario con el calendario actual.
			cal = Calendar.getInstance();
			codContrato = 0;
			regEspe = "";
			for (int i = 0; i < 10; i++) {
				this.interno = codInterno(4);
				this.procesoIni = this.proce+"-r00";
				this.codContra = codContrato();
				this.indexacion = (index[0] + i);
				this.codGeneral = "RH-2-r04";
				this.generador = "Departamento de RRHH;";
				this.autorizado = "Departamento de RRHH;";
				this.descripcion = "Informes;";
				this.enlace = "C:/documentos/RH-2/4/Checklist firmado.pdf;";
				regEspe += interno+"@"+procesoIni+"@"+codContra+"@"+indexacion+"@"+codGeneral+"@"+generador+"@"+autorizado+"@"+descripcion+"@"+enlace+"_";
			}
			enviar(1);
			
			JOptionPane.showMessageDialog(null,
					"Creados 10 registros específicos de RRHH paso 2º correctamente.",
					"Registros Automáticos", JOptionPane.INFORMATION_MESSAGE);
			btnAutoRRHH2.setEnabled(false);
			mntmRrhh_1.setEnabled(false);
		}
	}

	/**
	 * Método para crear los 10 primeros registros para la parte de Trabajador
	 * opción 1 y seguidamnete los de Trabajador opción 2.
	 */
	private void registroTrabajador(int j) {
		
		if(j == 0){
			// PASO 1 DE TRABAJADOR
			// Inicializamos calendario con el calendario actual.
			cal = Calendar.getInstance();
			codContrato = 0;
			regEspe = "";
			for (int i = 0; i < 10; i++) {
				this.interno = codInterno(1);
				this.procesoIni = this.proce+"-r00";
				this.codContra = codContrato();
				this.indexacion = (index[0] + i);
				this.codGeneral = "RH-2-r01";
				this.generador = indexacion+";";
				this.autorizado = "Departamento de RRHH;";
				regEspe += interno+"@"+procesoIni+"@"+codContra+"@"+indexacion+"@"+codGeneral+"@"+generador+"@"+autorizado+"_";
			}
			enviar(1);
			
			JOptionPane.showMessageDialog(null,
					"Creados 10 registros específicos de Trabajador paso 1º correctamente.",
					"Registros Automáticos", JOptionPane.INFORMATION_MESSAGE);
			btnAutoTrabajador1.setEnabled(false);
			mntmTrabajador.setEnabled(false);
			btnAutoTrabajador2.setEnabled(true);
			mntmTrabajador_1.setEnabled(true);
		}else{
			// PASO 2 DE TRABAJADOR
			// Inicializamos calendario con el calendario actual.
			cal = Calendar.getInstance();
			codContrato = 0;
			regEspe = "";
			for (int i = 0; i < 10; i++) {
				this.interno = codInterno(2);
				this.procesoIni = this.proce+"-r00";
				this.codContra = codContrato();
				this.indexacion = (index[0] + i);
				this.codGeneral = "RH-2-r02";
				this.generador = indexacion+";";
				this.autorizado = "Departamento de RRHH;";
				this.descripcion = "Informe;";
				this.enlace = "C:/documentos/RH-2/2/Informe formación.pdf;";
				regEspe += interno+"@"+procesoIni+"@"+codContra+"@"+indexacion+"@"+codGeneral+"@"+generador+"@"+autorizado+"@"+descripcion+"@"+enlace+"_";
			}
			enviar(1);
			
			JOptionPane.showMessageDialog(null,
					"Creados 10 registros específicos de Trabajador paso 2º correctamente.",
					"Registros Automáticos", JOptionPane.INFORMATION_MESSAGE);
			btnAutoTrabajador2.setEnabled(false);
			mntmTrabajador_1.setEnabled(false);
			btnAutoGerente.setEnabled(true);
			mntmGerente.setEnabled(true);
		}
	}

	/**
	 * Método para crear los 10 primeros registros para la parte de Gerente.
	 */
	private void registroGerente() {
		// PASO 1 DE TRABAJADOR
		// Inicializamos calendario con el calendario actual.
		cal = Calendar.getInstance();
		codContrato = 0;
		regEspe = "";
		for (int i = 0; i < 10; i++) {
			this.interno = codInterno(3);
			this.procesoIni = this.proce+"-r00";
			this.codContra = codContrato();
			this.indexacion = (index[0] + i);
			this.codGeneral = "RH-2-r03";
			this.generador = "Gerente;";
			this.autorizado = "Departamneto de RRHH;";
			this.descripcion = "Informes;";
			this.enlace = ("C:/documentos/RH-2/3/Checklist Empleado.pdf;C:/documentos/RH-2/3/Informe CheckList Gerente.pdf;C:/documentos/RH-2/3/Informe Entrevista Gerente.pdf;C:/documentos/RH-2/3/Informe Entrevista Personal Gerente.pdf;");
			regEspe += interno+"@"+procesoIni+"@"+codContra+"@"+indexacion+"@"+codGeneral+"@"+generador+"@"+autorizado+"@"+descripcion+"@"+enlace+"_";
		}
		enviar(1);
		
		JOptionPane.showMessageDialog(null,
				"Creados 10 registros específicos de Gerente correctamente.",
				"Registros Automáticos", JOptionPane.INFORMATION_MESSAGE);
		btnAutoGerente.setEnabled(false);
		mntmGerente.setEnabled(false);
		btnAutoRRHH2.setEnabled(true);
		mntmRrhh_1.setEnabled(true);
	}

	/**
	 * Método para crear el código interno para el registro.
	 * 
	 * @return Cadena con número del código interno.
	 */
	private String codInterno(int tipo) {

		switch (tipo) {
		case 0:
			// si es para RRHH1 le añadimos 61 segundos a cada registro nuevo
			cal.add(Calendar.SECOND, 61);
			break;
		case 1:
			// si es para Trabajador1 le añadimos 61 minutos a cada registro
			// nuevo
			cal.add(Calendar.MINUTE, 61);
			break;
		case 2:
			// si es para Trabajador2 le añadimos 31 segundos y 61 minutos a
			// cada registro nuevo
			cal.add(Calendar.SECOND, 31);
			cal.add(Calendar.MINUTE, 61);
			break;
		case 3:
			// si es para Gerente le añadimos 61 minutos y 1 día a cada registro
			// nuevo
			cal.add(Calendar.MINUTE, 61);
			cal.add(Calendar.DATE, 1);
			break;
		case 4:
			// si es para RRHH2 le añadimos 31 segundos, 61 minutos y 2 días a
			// cada registro nuevo
			cal.add(Calendar.SECOND, 31);
			cal.add(Calendar.MINUTE, 61);
			cal.add(Calendar.DATE, 2);
			break;
		}

		String cod = "";

		// Año, mes y día
		String anyo = String.valueOf(cal.get(Calendar.YEAR));
		fmt = new Formatter();
		String mes = String.valueOf(fmt.format("%02d",
				(cal.get(Calendar.MONTH)) + 1));
		fmt = new Formatter();
		String dia = String.valueOf(fmt.format("%02d", cal.get(Calendar.DATE)));
		// Hora(24h), minutos y segundos
		fmt = new Formatter();
		String hora = String.valueOf(fmt.format("%02d",
				cal.get(Calendar.HOUR_OF_DAY)));
		fmt = new Formatter();
		String min = String
				.valueOf(fmt.format("%02d", cal.get(Calendar.MINUTE)));
		fmt = new Formatter();
		String seg = String
				.valueOf(fmt.format("%02d", cal.get(Calendar.SECOND)));

		fmt = new Formatter();
		String numReg = String.valueOf(fmt.format("%06d", numRegistro++));
		cod = anyo + mes + dia + hora + min + seg + numReg;
		return cod;
	}

	/**
	 * Método para crear el código de contratación para el registro.
	 * 
	 * @return Cadena con número del código de contratación.
	 */
	private String codContrato() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat();

		String annio = new String("yyyy");
		sdf.applyPattern(annio);
		annio = sdf.format(date);

		Formatter fmt = new Formatter();
		fmt.format("%03d", codContrato++);

		return "CON: " + annio + "/" + fmt;
	}

	/**
	 * Método para enviar el registro a almacenar.
	 */
	private void enviar(int i) {
		switch (i) {
		case 0:
			tARegistrosCreados.setText(cl.setRegistroAuto(regAdmin));
			break;
		case 1:
			tARegistrosCreados.setText(cl.setRegistroAuto(regEspe));
			break;
		}		
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
			hb.enableHelpOnButton(mntmAyuda, "automatico", hs);
			// Ayuda para botón
			hb.enableHelpOnButton(btnAyuda, "automatico", hs);
			// Desplega ayuda pulsando sobre F1
			hb.enableHelpKey(this.getContentPane(), "automatico", hs);
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

		jContentPane.printAll(graphics);

		return PAGE_EXISTS;
	}
} // @jve:decl-index=0:visual-constraint="10,10"
