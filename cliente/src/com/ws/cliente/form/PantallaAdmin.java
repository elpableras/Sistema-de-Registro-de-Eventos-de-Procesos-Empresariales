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
import com.ws.cliente.dato.ListaAutorizadoC;
import com.ws.cliente.dato.ListaGeneradorC;
import com.ws.cliente.dato.ListaCampoC;
import com.ws.cliente.dato.ListaDocumentoC;
import com.ws.cliente.dato.ListaIndicadorC;
import com.ws.cliente.dato.RegistroAdminC;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import javax.swing.border.EtchedBorder;

/**
 * Clase que define la interfaz de la pantalla del Administrador,
 * hereda de JFrame.
 */
public class PantallaAdmin extends JFrame {

	private Cliente c;
	private Procedimiento1y2 p;
	String[] datos;
	private RegistroAdminC rac;
	private ListaDocumentoC d;
	private ListaCampoC cm;
	private ListaIndicadorC in;
	private ListaGeneradorC g;
	private ListaAutorizadoC a;
	private VisorEventos ve;

	private boolean cerrar = false;
	private String proce = "RH-2";

	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 3526777868741300578L;
	private JPanel jContentPane = null;

	private JMenuBar barraMenu = null;
	private JMenu menuArchivo = null;
	private JMenuItem mntmImprimir = null;
	private JMenuItem itemSalir = null;
	private JMenu menuProce = null;
	private JMenu mnNuevoProce2 = null;
	private JMenuItem mntmRH_2_1 = null;
	private JMenuItem mntmRH_2_2 = null;
	private JMenuItem mntmModificar = null;
	private JMenu menuAyuda = null;
	private JMenuItem mntmAcercadeAdmin;

	private JToolBar barraHerramientas = null;
	private JButton btCrear = null;
	private JButton btModificar = null;
	private JButton btImprimir = null;

	private JPanel panelCentral = null;
	private JPanel panelOpciones = null;
	private JScrollPane panelScrollOpciones = null;
	private JLabel lblProcedimientoACrear;
	private JLabel lblPasoACrear;
	private JComboBox comboBoxPasos = null;
	private JButton btnSeleccionarOpc = null;
	private JButton btnModificar = null;
	private JScrollPane scrollPanelListaR = null;
	private JButton btnSeleccionar = null;
	private JScrollPane panelScrollProcedimiento = null;
	private JPanel panelProce = null;

	private JPanel barraEstado = null;

	private DefaultListModel modeloLista = null;
	private List<String> listaRegistrosModi = new LinkedList<String>();
	private JList listaRegistros = null;
	private JMenuItem mntmRH_2_3;
	private JMenuItem mntmRH_2_4;
	private JMenuItem mntmRegistroDe;
	private JTextField tFEstado;
	private JButton btVisor;
	private JMenuItem mntmVisor;
	private JMenuItem mntmAyuda;
	private JTextField tFProcedimiento;
	private JButton btnCerrar;

	/**
	 * Constructor por defecto.
	 * 
	 * @param c
	 *            Objeto de tipo cliente.
	 * @param rac
	 *            Objeto tipo RegistroAdmin con el registro del administrador.
	 * @param d
	 *            Objeto con la lista de documentos.
	 * @param cm
	 *            Objeto con la lista de campos.
	 * @param in
	 *            Objeto con la lista de indicadores.
	 * @param g
	 *            Objeto Generador con la lista de generadores.
	 * @param a
	 *            Objeto Autorizado con la lista de autorizados.
	 */
	public PantallaAdmin(Cliente c, RegistroAdminC rac, ListaDocumentoC d,
			ListaCampoC cm, ListaIndicadorC in, ListaGeneradorC g,
			ListaAutorizadoC a) {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		this.c = c;
		this.rac = rac;
		this.d = d;
		this.cm = cm;
		this.in = in;
		this.g = g;
		this.a = a;
		initialize();
		setAyuda();
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
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("img\\iconos\\Pantalla\\Admin.png"));
		this.setJMenuBar(getBarraMenu());
		this.setContentPane(getJContentPane());
		this.setTitle("Administrador");
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
			job.setPrintable(this.p);
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
			menuProce.add(getMntmModificar());
			menuProce.add(getMntmVisor());
		}
		return menuProce;
	}

	/**
	 * Método que inicializa el item de Modificar Procedimiento.
	 * 
	 * @return javax.swing.JMenuItem.
	 */
	private JMenuItem getMntmModificar() {
		if (mntmModificar == null) {
			mntmModificar = new JMenuItem("Modificar");
			mntmModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mostrarRegistros();
				}
			});
			mntmModificar.setMnemonic(KeyEvent.VK_M);
			mntmModificar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,
					InputEvent.CTRL_MASK));
		}
		return mntmModificar;
	}

	/**
	 * Método que inicializa el item de Visor de Eventos.
	 * 
	 * @return javax.swing.JMenuItem.
	 */
	private JMenuItem getMntmVisor() {
		if (mntmVisor == null) {
			mntmVisor = new JMenuItem("Visor de Eventos...");
			mntmVisor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					visorEventos();
				}
			});
			mntmVisor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,
					InputEvent.SHIFT_MASK));
			mntmVisor.setMnemonic(KeyEvent.VK_V);
		}
		return mntmVisor;
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
			mnNuevoProce2.add(getMntmRH_2_1());
			mnNuevoProce2.add(getMntmRH_2_2());
			mnNuevoProce2.add(getMntmRH_2_3());
			mnNuevoProce2.add(getMntmRH_2_4());
			mnNuevoProce2.add(getMntmRH_2_5());
			mnNuevoProce2.setMnemonic(KeyEvent.VK_2);
		}
		return mnNuevoProce2;
	}

	/**
	 * Método que inicializa el item de la 1º opción del Procedimiento.
	 * 
	 * @return javax.swing.JMenuItem.
	 */
	private JMenuItem getMntmRH_2_1() {
		if (mntmRH_2_1 == null) {
			mntmRH_2_1 = new JMenuItem("1 Inicio de Procedimiento");
			mntmRH_2_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setNuevoProce(0);
				}
			});
			mntmRH_2_1.setMnemonic(KeyEvent.VK_1);
		}
		return mntmRH_2_1;
	}

	/**
	 * Método que inicializa el item de la 2º opción del Procedimiento.
	 * 
	 * @return javax.swing.JMenuItem.
	 */
	private JMenuItem getMntmRH_2_2() {
		if (mntmRH_2_2 == null) {
			mntmRH_2_2 = new JMenuItem("2 Registro de Actividades Presenciales");
			mntmRH_2_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setNuevoProce(1);
				}
			});
			mntmRH_2_2.setMnemonic(KeyEvent.VK_2);
		}
		return mntmRH_2_2;
	}

	/**
	 * Método que inicializa el item de la 3º opción del Procedimiento.
	 * 
	 * @return javax.swing.JMenuItem.
	 */
	private JMenuItem getMntmRH_2_3() {
		if (mntmRegistroDe == null) {
			mntmRegistroDe = new JMenuItem(
					"3 Registro de Informe de Formación del Trabajador");
			mntmRegistroDe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setNuevoProce(2);
				}
			});
			mntmRegistroDe.setMnemonic(KeyEvent.VK_3);
		}
		return mntmRegistroDe;
	}

	/**
	 * Método que inicializa el item de la 4º opción del Procedimiento.
	 * 
	 * @return javax.swing.JMenuItem.
	 */
	private JMenuItem getMntmRH_2_4() {
		if (mntmRH_2_3 == null) {
			mntmRH_2_3 = new JMenuItem("4 Validación Gerente ");
			mntmRH_2_3.setMnemonic(KeyEvent.VK_4);
			mntmRH_2_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setNuevoProce(3);
				}
			});
		}
		return mntmRH_2_3;
	}

	/**
	 * Método que inicializa el item de la 5º opción del Procedimiento.
	 * 
	 * @return javax.swing.JMenuItem.
	 */
	private JMenuItem getMntmRH_2_5() {
		if (mntmRH_2_4 == null) {
			mntmRH_2_4 = new JMenuItem(
					"5 Registrar la Realización del Archivo del Checklist");
			mntmRH_2_4.setMnemonic(KeyEvent.VK_5);
			mntmRH_2_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setNuevoProce(4);
				}
			});
		}
		return mntmRH_2_4;
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
			menuAyuda.add(getMntmAcercadeAdmin());
		}
		return menuAyuda;
	}

	/**
	 * Método que inicializa el item del Acerca de.
	 * 
	 * @return javax.swing.JMenuItem.
	 */
	private JMenuItem getMntmAcercadeAdmin() {
		if (mntmAcercadeAdmin == null) {
			mntmAcercadeAdmin = new JMenuItem("Acerca de");
			mntmAcercadeAdmin.setMnemonic(KeyEvent.VK_R);
			mntmAcercadeAdmin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane
							.showMessageDialog(
									null,
									" Aplicación para el Administrador \n Proyecto de Sistema de Registro de Eventos de Procesos Empresariales \n Pablo González Jiménez",
									" Acerca de Administrador", 3);
				}
			});
		}
		return mntmAcercadeAdmin;
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
					c.despertarHilo();
					setCerrar(true);
					c.setCerrar(true);
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
			barraHerramientas.add(getBtCrear());
			barraHerramientas.add(getBtModificar());
			barraHerramientas.add(getBtImprimir());
			barraHerramientas.add(getBtVisor());
		}
		return barraHerramientas;
	}

	/**
	 * Método que inicializa el botón de Crear Procedimiento.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtCrear() {
		if (btCrear == null) {
			btCrear = new JButton();
			btCrear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int n = 0;
					String pa = "";
					pa = JOptionPane
							.showInputDialog(" Inicio de Procedimiento -> 1 \n Registro de Actividades Presenciales -> 2"
									+ " \n Registro de Informe de Formación del Trabajador -> 3 \n Validación Gerente -> 4"
									+ " \n Registrar la Realización del Archivo del Checklist -> 5 ");

					if (pa != null && pa.compareTo("") != 0) {
						n = Integer.parseInt(pa);
						n--;
						setNuevoProce(n);
					}
				}
			});
			btCrear.setToolTipText("Nuevo");
			btCrear.setSize(new java.awt.Dimension(24, 24));
			// NO DEJAR MARGENES ENTRE LOS BOTONES
			btCrear.setMargin(new java.awt.Insets(0, 0, 0, 0));
			btCrear.setMaximumSize(new java.awt.Dimension(30, 30));
			btCrear.setMinimumSize(new java.awt.Dimension(30, 30));
			// DESPINTAR EL BORDE
			btCrear.setBorderPainted(false);
			btCrear.setContentAreaFilled(false);
			btCrear.setIcon(new ImageIcon("img\\iconos\\Nuevo.png"));
		}
		return btCrear;
	}

	/**
	 * Método que inicializa el botón de Modificar Procedimiento.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtModificar() {
		if (btModificar == null) {
			btModificar = new JButton();
			btModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mostrarRegistros();
				}
			});
			btModificar.setToolTipText("Modificar");
			btModificar.setSize(new java.awt.Dimension(24, 24));
			btModificar.setMargin(new java.awt.Insets(0, 0, 0, 0));
			btModificar.setMaximumSize(new java.awt.Dimension(30, 30));
			btModificar.setMinimumSize(new java.awt.Dimension(30, 30));
			btModificar.setBorderPainted(false);
			btModificar.setContentAreaFilled(false);
			btModificar.setIcon(new ImageIcon("img\\iconos\\Modificar.png"));

		}
		return btModificar;
	}

	/**
	 * Método que inicializa el botón de Imprimir.
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
			btImprimir.setIcon(new ImageIcon("img\\iconos\\Imprimir.png"));
		}
		return btImprimir;
	}

	/**
	 * Método que inicializa el botón de Visor de Eventos.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtVisor() {
		if (btVisor == null) {
			btVisor = new JButton();
			btVisor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					visorEventos();
				}
			});
			btVisor.setToolTipText("Visor de eventos");
			btVisor.setSize(new java.awt.Dimension(24, 24));
			// NO DEJAR MARGENES ENTRE LOS BOTONES
			btVisor.setMargin(new java.awt.Insets(0, 0, 0, 0));
			btVisor.setMaximumSize(new java.awt.Dimension(30, 30));
			btVisor.setMinimumSize(new java.awt.Dimension(30, 30));
			// DESPINTAR EL BORDE
			btVisor.setBorderPainted(false);
			btVisor.setContentAreaFilled(false);
			btVisor.setIcon(new ImageIcon("img\\iconos\\Pantalla\\Visor.png"));
		}
		return btVisor;
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
			GridBagLayout gbl_panelCentral = new GridBagLayout();
			gbl_panelCentral.columnWidths = new int[] { 277, 277, 0 };
			gbl_panelCentral.rowHeights = new int[] { 198, 0 };
			gbl_panelCentral.columnWeights = new double[] { 0.0, 0.0,
					Double.MIN_VALUE };
			gbl_panelCentral.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
			panelCentral.setLayout(gbl_panelCentral);
			GridBagConstraints gbc_panelScrollOpciones = new GridBagConstraints();
			gbc_panelScrollOpciones.gridheight = 4;
			gbc_panelScrollOpciones.fill = GridBagConstraints.BOTH;
			gbc_panelScrollOpciones.insets = new Insets(0, 0, 0, 5);
			gbc_panelScrollOpciones.gridx = 0;
			gbc_panelScrollOpciones.gridy = 0;
			panelCentral.add(getPanelScrollOpciones(), gbc_panelScrollOpciones);
			GridBagConstraints gbc_panelScrollProcedimiento = new GridBagConstraints();
			gbc_panelScrollProcedimiento.gridwidth = 4;
			gbc_panelScrollProcedimiento.gridheight = 4;
			gbc_panelScrollProcedimiento.fill = GridBagConstraints.BOTH;
			gbc_panelScrollProcedimiento.gridx = 1;
			gbc_panelScrollProcedimiento.gridy = 0;
			panelCentral.add(getPanelScrollProcedimiento(),
					gbc_panelScrollProcedimiento);
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
			panelScrollOpciones.setViewportView(getPanelOpciones());
		}
		return panelScrollOpciones;
	}

	/**
	 * Método que inicializa el panel de scroll de Procedimiento.
	 * 
	 * @return javax.swing.JScrollPane.
	 */
	private JScrollPane getPanelScrollProcedimiento() {
		if (panelScrollProcedimiento == null) {
			panelScrollProcedimiento = new JScrollPane();
		}
		return panelScrollProcedimiento;
	}

	/**
	 * Método que inicializa el panel de Opciones.
	 * 
	 * @return javax.swing.JPanel.
	 */
	private JPanel getPanelOpciones() {
		if (panelOpciones == null) {
			panelOpciones = new JPanel();
			panelOpciones.setBounds(0, 0, 250, 700);
			panelOpciones.setBorder(new TitledBorder(null,
					"Opciones Administrador", TitledBorder.LEADING,
					TitledBorder.TOP, null, null));
			panelOpciones.setLayout(null);
			panelOpciones.add(getBtnSeleccionarOpc());
			panelOpciones.add(getBtnModificar());
			panelOpciones.add(getComboPasos(), null);
			panelOpciones.add(getScrollPanelListaR(), null);
			panelOpciones.add(getBtnSeleccionar(), null);
			panelOpciones.add(getLblProcedimientoACrear());
			panelOpciones.add(getLblPasoACrear());
			panelOpciones.add(getTFProcedimiento());
			panelOpciones.add(getBtnCerrar());
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
	private JLabel getLblPasoACrear() {
		if (lblPasoACrear == null) {
			lblPasoACrear = new JLabel("Opciones:");
			lblPasoACrear.setBounds(23, 127, 69, 14);
		}
		return lblPasoACrear;
	}

	/**
	 * Método que inicializa el botón de Seleccionar.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtnSeleccionar() {
		if (btnSeleccionar == null) {
			btnSeleccionar = new JButton("Seleccionar Registro");
			btnSeleccionar.setToolTipText("Selecciona registro a modificar");
			btnSeleccionar.setEnabled(false);
			btnSeleccionar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String reg = (String) listaRegistros.getSelectedValue();
					componerRegistro(reg);
				}
			});
			btnSeleccionar.setMnemonic(KeyEvent.VK_L);
			btnSeleccionar.setBounds(61, 442, 146, 23);
		}
		return btnSeleccionar;
	}

	/**
	 * Método que inicializa el panel de scroll de la Lista de Registros.
	 * 
	 * @return javax.swing.JScrollPane.
	 */
	private JScrollPane getScrollPanelListaR() {
		if (scrollPanelListaR == null) {
			scrollPanelListaR = new JScrollPane();
			scrollPanelListaR.setBorder(new TitledBorder(new EtchedBorder(
					EtchedBorder.LOWERED, null, null), "Lista de Registros",
					TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0,
							0, 0)));
			scrollPanelListaR.setBounds(23, 279, 222, 152);
			scrollPanelListaR.setViewportView(getListaRegistros());
		}
		return scrollPanelListaR;
	}

	/**
	 * Método que inicializa la Lista de Registros.
	 * 
	 * @return javax.swing.JList.
	 */
	private JList getListaRegistros() {
		modeloLista = new DefaultListModel();
		if (listaRegistros == null) {
			listaRegistros = new JList(modeloLista);
		}
		return listaRegistros;
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
			tFProcedimiento.setBounds(23, 88, 222, 20);
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
					c.despertarHilo();
					setCerrar(true);
					c.setCerrar(true);
					dispose();
				}
			});
			btnCerrar.setToolTipText("Cerrar pantalla Admin");
			btnCerrar.setMnemonic(KeyEvent.VK_C);
			btnCerrar.setBounds(99, 491, 69, 23);
		}
		return btnCerrar;
	}

	/**
	 * Método que compone el registro general.
	 * 
	 * @param reg
	 *            cadena con el regsitro a componer.
	 */
	private void componerRegistro(String reg) {
		tFEstado.setText("");
		c.despertarHilo();
		String aux = "";

		if (reg != null && reg.compareTo("") != 0) {
			int k = reg.length() - 1;
			int j = 0;
			do {
				// CODIGO REGISTRO
				if (reg.charAt(k) != ' ') {
					aux += reg.charAt(k);
					j++;
				}
				k--;
			} while (j < 8);
			reg = "";
			for (int i = aux.length() - 1; i >= 0; i--) {
				reg += aux.charAt(i);
			}

			for (int i = 0; i < listaRegistrosModi.size(); i = i + 16) {

				String[] general = listaRegistrosModi.get(i).toString()
						.split("\n");
				// REGISTROS GENERAL (i)
				if (general[6].toString().compareTo(reg) == 0) {
					rac.setNombre(general[4]);
					rac.setCodGeneral(general[6]);
					rac.setDescri(general[8]);
					rac.setTipo(general[10]);
					rac.setCodProce(general[12]);
					rac.setActi(general[14]);
					rac.setFrecu(general[16]);
					rac.setMeto(general[18]);

					rac.setArchivo(general[22]);
					rac.setRetencion(general[24]);
					rac.setConservacion(general[26]);
					rac.setDispo(general[28]);
					rac.setAlmacen(general[30]);
					rac.setModi(true);
				}

				// LA LISTA DOCUMENTO (i+1)(i+2)(i+3)
				if (listaRegistrosModi.get(i + 1).toString().compareTo(reg) == 0) {
					d.setCodigo(listaRegistrosModi.get(i + 1).toString());
					if ((listaRegistrosModi.size() > (i + 9))
							&& listaRegistrosModi.get(i + 2).toString()
									.compareTo("") != 0) {
						d.setEnlace(listaRegistrosModi.get(i + 2).toString());
						d.setTipoDescripcion(listaRegistrosModi.get(i + 3)
								.toString());
					} else {
						d.setEnlace("");
						d.setTipoDescripcion("");
					}
				}

				// LA LISTA CAMPO (i+4)(i+5)(i+6)(i+7)(i+8)(i+9)
				if (listaRegistrosModi.get(i + 4).toString().compareTo(reg) == 0) {
					cm.setCodRegistro(listaRegistrosModi.get(i + 4).toString());
					if ((listaRegistrosModi.size() > (i + 9))
							&& listaRegistrosModi.get(i + 5).toString()
									.compareTo("") != 0) {
						cm.setNombre(listaRegistrosModi.get(i + 5).toString());
						cm.setDescripcion(listaRegistrosModi.get(i + 6)
								.toString());
						cm.setTipo(listaRegistrosModi.get(i + 7).toString());
						cm.setUnidad(listaRegistrosModi.get(i + 8).toString());
						cm.setEnlace(listaRegistrosModi.get(i + 9).toString());
					} else {
						cm.setNombre("");
						cm.setDescripcion("");
						cm.setTipo("");
						cm.setUnidad("");
						cm.setEnlace("");
					}
				}

				// LISTA INDICADOR (i+10)(i+11)
				if (listaRegistrosModi.get(i + 10).toString().compareTo(reg) == 0) {
					in.setCodRegistro(listaRegistrosModi.get(i + 10).toString());
					if ((listaRegistrosModi.size() > (i + 11))
							&& listaRegistrosModi.get(i + 11).toString()
									.compareTo("") != 0) {
						in.setIndicador(listaRegistrosModi.get(i + 11)
								.toString());
					} else {
						in.setIndicador("");
					}
				}

				// LISTA GENERADOR (i+12)(i+13)
				if (listaRegistrosModi.get(i + 12).toString().compareTo(reg) == 0) {
					g.setCodigo(listaRegistrosModi.get(i + 12).toString());
					if ((listaRegistrosModi.size() > (i + 13))
							&& listaRegistrosModi.get(i + 13).toString()
									.compareTo("") != 0) {
						g.setGenerador(listaRegistrosModi.get(i + 13)
								.toString());
					} else {
						g.setGenerador("");
					}
				}

				// LISTA AUTORIZADO(i+14)(i+15)
				if (listaRegistrosModi.get(i + 14).toString().compareTo(reg) == 0) {
					a.setCodigo(listaRegistrosModi.get(i + 14).toString());
					if ((listaRegistrosModi.size() > (i + 15))
							&& listaRegistrosModi.get(i + 15).toString()
									.compareTo("") != 0) {
						a.setAutorizado(listaRegistrosModi.get(i + 15)
								.toString());
						break;
					} else {
						a.setAutorizado("");
						break;
					}
				}
			}
			setModiProce(rac, d, cm, in, g, a);
		} else {
			JOptionPane.showMessageDialog(null, "Seleccione un registro",
					"Error Registro", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Método que inicializa el ComboBox de Pasos a Crear.
	 * 
	 * @return javax.swing.JComboBox.
	 */
	private JComboBox getComboPasos() {
		if (comboBoxPasos == null) {
			comboBoxPasos = new JComboBox();
			comboBoxPasos.setToolTipText("Opciones");
			comboBoxPasos
					.setModel(new DefaultComboBoxModel(
							new String[] {
									"Inicio de Procedimiento",
									"Registro de Actividades Presenciales",
									"Registro de Informe de Formaci\u00F3n del Trabajador",
									"Validaci\u00F3n Gerente",
									"Registrar la Realizaci\u00F3n del Archivo del Checklist" }));
			comboBoxPasos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					btnSeleccionarOpc.setEnabled(true);
					btCrear.setEnabled(true);
				}
			});
			comboBoxPasos.setBounds(23, 152, 222, 22);
		}
		return comboBoxPasos;
	}

	/**
	 * Método que inicializa el botón de Seleccionar Registro.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtnSeleccionarOpc() {
		if (btnSeleccionarOpc == null) {
			btnSeleccionarOpc = new JButton("Seleccionar");
			btnSeleccionarOpc.setToolTipText("Seleccionar nuevo registro");
			btnSeleccionarOpc.setEnabled(false);
			btnSeleccionarOpc.setMnemonic(KeyEvent.VK_S);
			btnSeleccionarOpc.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int n = comboBoxPasos.getSelectedIndex();
					setNuevoProce(n);
				}
			});
			btnSeleccionarOpc.setBounds(89, 185, 89, 23);
		}
		return btnSeleccionarOpc;
	}

	/**
	 * Método que inicializa el botón de Modificar Registro.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtnModificar() {
		if (btnModificar == null) {
			btnModificar = new JButton("Modificar Registro");
			btnModificar.setToolTipText("Lista de registros a poder modificar");
			btnModificar.setMnemonic(KeyEvent.VK_M);
			btnModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mostrarRegistros();
				}
			});
			btnModificar.setBounds(69, 245, 129, 23);
		}
		return btnModificar;
	}

	/**
	 * Método que hace mostrar la lista de registros.
	 */
	public void mostrarRegistros() {
		String r = "";
		try {
			r = this.c.getAdmin(this.proce, true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString(),
					"ERROR al Mostrar Registros", JOptionPane.ERROR_MESSAGE);
		}

		// 16 partes con todos las listas y registros
		String[] reg = r.split("·");
		modeloLista.removeAllElements();
		listaRegistrosModi.removeAll(listaRegistrosModi);

		for (int i = 0; i < reg.length; i++) {
			listaRegistrosModi.add(reg[i]);
		}

		int i = 0;
		if (reg.length > 1) {
			do {

				// OBTENGO EL GENERAL
				String[] gene = reg[i].split("\n");
				if (gene.length > 1) {
					modeloLista.addElement(gene[4].toString() + " "
							+ gene[6].toString());
					btnSeleccionar.setEnabled(true);
					i = i + 16;
				} else {
					i = i + 16;
				}

			} while (i < reg.length);
		}
		if (modeloLista.getSize() == 0) {
			JOptionPane
					.showMessageDialog(
							null,
							"No se ha podido recuperar ningún registro de la base de datos",
							"Error Registro", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Método para crear nuevos Registros Generales.
	 * 
	 * @param n
	 *            entero con la opción del registro a crear.
	 */
	private void setNuevoProce(int n) {
		tFEstado.setText("");
		c.despertarHilo();
		switch (n) {
		case 0:
			panelProce = new JPanel();
			panelScrollProcedimiento.setViewportView(panelProce);
			panelProce.setLayout(null);
			this.datos = new String[] {
					"Inicio de Procedimiento RH-2 - Plan de acogida de Conductores",
					"RH-2-r00",
					"Se inicia el Procedimiento del Plan de acogida de Conductores.",
					"E",
					"RH-2",
					"1.- Generar alerta de contratación",
					"",
					"",
					"Con cada solicitud de Plan de Acogida",
					"Al generarse la solicitud del Plan de Acogida se genera el registro.",
					"Frecuencia de Planes de Acogida  por zona.",
					"Departamento de RRHH", "Departamento de RRHH",
					"Archivo RRHH",
					"Hasta 5 años después de terminada la relación laboral",
					"Sistema electrónico de registros",
					"Traslado al repositorio de registros históricos.",
					"Sistema electrónico de registros." };
			this.p = new Procedimiento1y2(this.rac, this.d, this.cm, this.in,
					this.g, this.a, this.datos);
			panelProce.add(this.p.getPanelPestañas(), null);
			btImprimir.setEnabled(true);
			mntmImprimir.setEnabled(true);
			break;
		case 1:
			panelProce = new JPanel();
			panelScrollProcedimiento.setViewportView(panelProce);
			panelProce.setLayout(null);
			this.datos = new String[] {
					"Registro de Actividades Presenciales",
					"RH-2-r01",
					"En un checklist el trabajador recoge la realización de las actividades presenciales contempladas en el Plan de Acogida.",
					"E",
					"RH-2",
					"Finalización del módulo de actividades presenciales.",
					"",
					"",
					"Cada vez que se inicie un Plan de Acogida",
					"Una vez el trabajador ha realizado las actividades presenciales, acepta el checklist y se genera el registro.",
					"", "Trabajador", "Departamento de RRHH", "Archivo RRHH",
					"12 meses", "Sistema electrónico de registros",
					"Descartar", "N/A" };
			this.p = new Procedimiento1y2(this.rac, this.d, this.cm, this.in,
					this.g, this.a, this.datos);
			panelProce.add(this.p.getPanelPestañas(), null);
			btImprimir.setEnabled(true);
			mntmImprimir.setEnabled(true);
			break;
		case 2:
			panelProce = new JPanel();
			panelScrollProcedimiento.setViewportView(panelProce);
			panelProce.setLayout(null);
			this.datos = new String[] {
					"Registro de Informe de Formación del Trabajador",
					"RH-2-r02",
					"Registro de la generación del informe de la formación realizada por el trabajador.",
					"E",
					"RH-2",
					"Informe sobre formación",
					"",
					"",
					"Cada vez que se termina la formación dentro del Plan de Acogida",
					"El trabajador termina la formación on-line y señala en el checklist la actividad con terminada.",
					"", "Trabajador", "Departamento de RRHH", "Archivo RRHH",
					"12 meses", "Sistema electrónico de registros",
					"Descartar", "N/A" };
			this.p = new Procedimiento1y2(this.rac, this.d, this.cm, this.in,
					this.g, this.a, this.datos);
			panelProce.add(this.p.getPanelPestañas(), null);
			btImprimir.setEnabled(true);
			mntmImprimir.setEnabled(true);
			break;
		case 3:
			panelProce = new JPanel();
			panelScrollProcedimiento.setViewportView(panelProce);
			panelProce.setLayout(null);
			this.datos = new String[] {
					"Validación Gerente",
					"RH-2-r03",
					"Este registro recoge el visto bueno dado por el gerente al Plan de acogida realizado por el trabajador."
							+ "- Checklist del trabajador que recoge la realización de las actividades presenciales contempladas en el Plan de Acogida."
							+ "- Checklist que recoge las actividades on-line realizadas por el trabajador."
							+ "- Informe de la entrevista del gerente con el trabajador contemplada en las actividades presenciales del Plan de Acogida.",
					"E",
					"RH-2",
					"Posteriormente a la entrevista personal realizada por el gerente",
					"",
					"",
					"Cada vez que se realiza una entrevista personal dentro del Plan de Acogida",
					"Una vez realizada la entrevista personal y comprobado por parte del gerente que el checklist de actividades ha sido completado por el trabajador",
					"", "Gerente", "Departamento de RRHH", "Archivo RRHH",
					"12 meses", "Sistema electrónico de registros",
					"Descartar", "N/A" };
			this.p = new Procedimiento1y2(this.rac, this.d, this.cm, this.in,
					this.g, this.a, this.datos);
			panelProce.add(this.p.getPanelPestañas(), null);
			btImprimir.setEnabled(true);
			mntmImprimir.setEnabled(true);
			break;
		case 4:
			panelProce = new JPanel();
			panelScrollProcedimiento.setViewportView(panelProce);
			panelProce.setLayout(null);
			this.datos = new String[] {
					"Registrar la Realización del Archivo del Checklist",
					"RH-2-r04",
					"Se registra el hecho de haberse archivado la copia digitalizada y física firmada por el gerente.",
					"E",
					"RH-2",
					"Cierre del proceso",
					"",
					"",
					"Cada vez que el gerente cierra un Plan de Acogida",
					"Al aceptar y cerrar el proceso de alta de nueva relación laboral se genera este registro por la persona que realice la supervisión del proceso desde el Departamento de RRHH.",
					"", "Departamento de RRHH", "Departamento de RRHH",
					"Archivo RRHH", "12 meses",
					"Sistema electrónico de registros", "Descartar", "N/A" };
			this.p = new Procedimiento1y2(this.rac, this.d, this.cm, this.in,
					this.g, this.a, this.datos);
			panelProce.add(this.p.getPanelPestañas(), null);
			btImprimir.setEnabled(true);
			mntmImprimir.setEnabled(true);
			break;
		}
	}

	/**
	 * Método que crea el panel y lo muestra con los datos del registro general
	 * que puede ser modificado.
	 * 
	 * @param rac
	 *            Objeto tipo RegistroAdmin con el registro del administrador.
	 * @param d
	 *            Objeto con la lista de documentos.
	 * @param c
	 *            Objeto con la lista de campos.
	 * @param i
	 *            Objeto con la lista de indicadores.
	 * @param g
	 *            Objeto Generador con la lista de generadores.
	 * @param a
	 *            Objeto Autorizado con la lista de autorizados.
	 */
	private void setModiProce(RegistroAdminC rac, ListaDocumentoC d,
			ListaCampoC c, ListaIndicadorC i, ListaGeneradorC g,
			ListaAutorizadoC a) {

		panelProce = new JPanel();
		panelScrollProcedimiento.setViewportView(panelProce);
		panelProce.setLayout(null);
		this.p = new Procedimiento1y2(rac, d, c, i, g, a);
		panelProce.add(this.p.getPanelPestañas(), null);

	}

	/**
	 * Método que crea la ventana que muestra la aplicación del Visor de
	 * eventos.
	 */
	private void visorEventos() {
		ve = new VisorEventos(c);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = ve.getSize();
		if (frameSize.height > screenSize.height)
			frameSize.height = screenSize.height;
		if (frameSize.width > screenSize.width)
			frameSize.width = screenSize.width;
		ve.setLocation((screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.height) / 2);

		ve.setVisible(true);
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
			hb.enableHelpOnButton(mntmAyuda, "administrador", hs);
			// Desplega ayuda pulsando sobre F1
			hb.enableHelpKey(this.getContentPane(), "administrador", hs);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,
					"Fichero de Ayuda no encontrado " + e.getMessage(),
					"Ayuda", JOptionPane.INFORMATION_MESSAGE);
		}
	}
} // @jve:decl-index=0:visual-constraint="10,10"
