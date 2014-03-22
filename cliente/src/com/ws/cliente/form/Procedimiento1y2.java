package com.ws.cliente.form;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.Rectangle;
import java.awt.Color;
import javax.swing.DropMode;

import com.ws.cliente.form.dialog.Autorizado;
import com.ws.cliente.form.dialog.Campo;
import com.ws.cliente.form.dialog.Documento;
import com.ws.cliente.form.dialog.Generador;
import com.ws.cliente.form.dialog.Indicador;
import com.ws.cliente.dato.ListaAutorizadoC;
import com.ws.cliente.dato.ListaGeneradorC;
import com.ws.cliente.dato.ListaCampoC;
import com.ws.cliente.dato.ListaDocumentoC;
import com.ws.cliente.dato.ListaIndicadorC;
import com.ws.cliente.dato.RegistroAdminC;

import java.awt.Cursor;
import java.awt.ComponentOrientation;
import java.awt.SystemColor;
import java.io.File;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 * Clase que define la interfaz de la pantalla de los registros del
 * administrador, hereda de JFrame e implementa la clase abstracta Printable.
 */
public class Procedimiento1y2 extends JFrame implements Printable {

	/**
	 * Serial.
	 */
	private static final long serialVersionUID = -7500847887521302612L;
	private JTabbedPane panelPestañas = null;
	private JPanel panelGeneral = null;
	private JPanel panelVida = null;
	private RegistroAdminC rac;
	private ListaDocumentoC d;
	private ListaCampoC c;
	private ListaIndicadorC i;
	private ListaGeneradorC g;
	private ListaAutorizadoC a;
	private String[] datos;

	// REGISTRO GENERAL

	private JLabel lblCdigoGeneral;
	private JLabel lblDescripcin;
	private JLabel lblTipo;
	private JLabel lblCodProcedimiento;
	private JLabel lblActividad;
	private JLabel lblDocVinculadaGeneral;
	private JLabel lblListaDeCampos;
	private JLabel lblFrecuencia;
	private JLabel lblMtodo;
	private JLabel lblListaIndicadores;
	private JLabel lblGeneradorDeRegistroGeneral;
	private JLabel lblAutorizadosParaConsultaGeneral;

	private JScrollPane scrollPanelNombre = null;
	private JTextArea tANombre = null;
	private JTextField tFC_General;
	private JScrollPane scrollPaneDescrip = null;
	private JTextArea tADescrip;
	private JComboBox comboTipo = null;
	private JTextField tFCodProcedimiento;
	private JTextField tFActividad;
	private JButton btAñadirDocu = null;
	private JButton btnAñadirCampos = null;
	private JTextField tFFrecuencia;
	private JScrollPane scrollPaneMetodo = null;
	private JTextArea tAMetodo;
	private JButton btnAñadirIndi = null;
	private JButton btnAñadirGene = null;
	private JButton btnAñadirAuto = null;

	// DIALOGO
	private Documento dlgD;
	private Campo dlgC;
	private Indicador dlgI;
	private Generador dlgG;
	private Autorizado dlgA;

	private JButton btnSiguienteGene = null;

	private List<Object> listaDocu = new LinkedList<Object>();

	private List<Object> listaCampo = new LinkedList<Object>();

	private List<Object> listaIndi = new LinkedList<Object>();

	private List<Object> listaGenerador = new LinkedList<Object>();

	private List<Object> listaAutorizado = new LinkedList<Object>();

	// FIN DE REGISTRO GENERAL

	// CILO DE VIDA

	private JTextField tFArch;
	private JTextField tFReten;
	private JTextField tFConser;
	private JComboBox comboDispo = null;
	private JTextField tFAlma;
	private JButton btnAtrasCiclo;
	private JButton btnEnviar = null;
	private JCheckBox chckVersinModificada = null;
	private JButton btnAyuda = null;

	// FIN DE CICLO DE VIDA

	/**
	 * Constructor por defecto.
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
	 * @param datos
	 *            Array de cadenas con los datos del registro.
	 * @wbp.parser.constructor
	 */
	public Procedimiento1y2(RegistroAdminC rac, ListaDocumentoC d,
			ListaCampoC c, ListaIndicadorC i, ListaGeneradorC g,
			ListaAutorizadoC a, String[] datos) {
		super();
		this.rac = rac;
		this.d = d;
		this.c = c;
		this.i = i;
		this.g = g;
		this.a = a;
		this.datos = datos;
		getPanelPestañas();
		inicializar();
		setAyuda();
	}

	/**
	 * Método que devuelve un panel de pestañas con los elementos creados para
	 * la pantalla de los registros del administrador.
	 * 
	 * @return javax.swing.JTabbedPane.
	 */
	public JTabbedPane getPanelPestañas() {
		if (panelPestañas == null) {
			panelPestañas = new JTabbedPane();
			panelPestañas.setBounds(new Rectangle(0, 0, 500, 528));
			panelPestañas.addTab("Información General", null,
					getPanelGeneral(), null);
			panelPestañas.addTab("Ciclo de Vida", null, getPanelVida(), null);
			getPanelPestañas().setVisible(true);
		}
		return panelPestañas;
	}

	/**
	 * Método que carga los datos del registro, en los elementos de la interfaz
	 * del registro.
	 */
	private void inicializar() {
		tANombre.setText(datos[0]);
		tFC_General.setText(datos[1]);
		tADescrip.setText(datos[2]);
		comboTipo.setSelectedItem(datos[3]);
		tFCodProcedimiento.setText(datos[4]);
		tFActividad.setText(datos[5]);
		if (datos[6].compareTo("") != 0) {
			listaDocu.removeAll(listaDocu);
			listaDocu.add(datos[6]);
		}
		if (datos[7].compareTo("") != 0) {
			listaCampo.removeAll(listaCampo);
			listaCampo.add(datos[7]);
		}
		tFFrecuencia.setText(datos[8]);
		tAMetodo.setText(datos[9]);
		if (datos[10].compareTo("") != 0) {
			listaIndi.removeAll(listaIndi);
			listaIndi.add(datos[10]);
		}
		if (datos[11].compareTo("") != 0) {
			listaGenerador.removeAll(listaGenerador);
			listaGenerador.add(datos[11]);
		}
		if (datos[12].compareTo("") != 0) {
			listaAutorizado.removeAll(listaAutorizado);
			listaAutorizado.add(datos[12]);
		}
		tFArch.setText(datos[13]);
		tFReten.setText(datos[14]);
		tFConser.setText(datos[15]);
		comboDispo.setSelectedItem(datos[16]);
		tFAlma.setText(datos[17]);

		// FIN SETs
	}

	/**
	 * Constructor para crear la pantalla del registro, con los datos
	 * almacenados de la BBDD, que puede ser modificado.
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
	public Procedimiento1y2(RegistroAdminC rac, ListaDocumentoC d,
			ListaCampoC c, ListaIndicadorC i, ListaGeneradorC g,
			ListaAutorizadoC a) {
		super();
		this.rac = rac;
		this.d = d;
		this.c = c;
		this.i = i;
		this.g = g;
		this.a = a;
		getPanelPestañas();
		reinicializar();
	}

	/**
	 * Método que carga los datos del registro traido de la BBDD, en los
	 * elementos de la interfaz del registro que puede ser modificado.
	 */
	private void reinicializar() {
		tANombre.setText(rac.getNombre());
		tFC_General.setText(rac.getCodGeneral());
		tADescrip.setText(rac.getDescri());
		comboTipo.setSelectedItem(rac.getTipo());
		tFCodProcedimiento.setText(rac.getCodProce());
		tFActividad.setText(rac.getActi());

		if (d.getEnlace().length() > 0 && d.getTipoDescripcion().length() > 0) {
			String[] campoE = d.getEnlace().split(",");
			String[] campoT = d.getTipoDescripcion().split(";");
			for (int j = 0; j < campoE.length; j++) {
				listaDocu.removeAll(listaDocu);
				listaDocu.add(campoE[j] + " / " + campoT[j]);
			}
		}

		if (c.getNombre().length() > 0 && c.getDescripcion().length() > 0
				&& c.getTipo().length() > 0 && c.getUnidad().length() > 0
				&& c.getEnlace().length() > 0) {
			String[] campoN = c.getNombre().split(";");
			String[] campoD = c.getDescripcion().split(";");
			String[] campoTi = c.getTipo().split(";");
			String[] campoU = c.getUnidad().split(";");
			String[] campoEn = c.getEnlace().split(";");
			for (int j = 0; j < campoN.length; j++) {
				listaCampo.removeAll(listaCampo);
				listaCampo.add(campoN[j] + " " + campoD[j] + " " + campoTi[j]
						+ " " + campoU[j] + " / " + campoEn[j]);
			}
		}

		if (i.getIndicador().length() > 0) {
			String[] campoI = i.getIndicador().split(";");
			for (int j = 0; j < campoI.length; j++) {
				listaIndi.removeAll(listaIndi);
				listaIndi.add(campoI[j]);
			}
		}

		if (g.getGenerador().length() > 0) {
			String[] campoG = g.getGenerador().split(";");
			for (int j = 0; j < campoG.length; j++) {
				listaGenerador.removeAll(listaGenerador);
				listaGenerador.add(campoG[j]);
			}
		}

		if (a.getAutorizado().length() > 0) {
			String[] campoA = a.getAutorizado().split(";");
			for (int j = 0; j < campoA.length; j++) {
				listaAutorizado.removeAll(listaAutorizado);
				listaAutorizado.add(campoA[j]);
			}
		}

		tFFrecuencia.setText(rac.getFrecu());
		tAMetodo.setText(rac.getMeto());

		tFArch.setText(rac.getArchivo());
		tFReten.setText(rac.getRetencion());
		tFConser.setText(rac.getConservacion());
		comboDispo.setSelectedItem(rac.getDispo());
		tFAlma.setText(rac.getAlmacen());
		chckVersinModificada.setSelected(true);
	}

	// REGISTRO GENERAL

	/**
	 * Método que devuelve el panel del formulario de la pestaña de General de
	 * los registros del administrador con los elementos creados.
	 * 
	 * @return javax.swing.JPanel.
	 */
	private JPanel getPanelGeneral() {
		if (panelGeneral == null) {
			panelGeneral = new JPanel();
			panelGeneral.setLayout(null);

			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(28, 37, 55, 14);
			panelGeneral.add(lblNombre);

			lblCdigoGeneral = new JLabel("C\u00F3d. General:");
			lblCdigoGeneral.setBounds(28, 75, 97, 14);
			panelGeneral.add(lblCdigoGeneral);

			lblDescripcin = new JLabel("Descripci\u00F3n:");
			lblDescripcin.setBounds(28, 111, 82, 14);
			panelGeneral.add(lblDescripcin);

			lblTipo = new JLabel("Tipo:");
			lblTipo.setBounds(28, 150, 82, 14);
			panelGeneral.add(lblTipo);

			lblCodProcedimiento = new JLabel("Cod. Procedimiento:");
			lblCodProcedimiento.setBounds(28, 175, 125, 14);
			panelGeneral.add(lblCodProcedimiento);

			lblActividad = new JLabel("Actividad:");
			lblActividad.setBounds(28, 200, 82, 14);
			panelGeneral.add(lblActividad);

			lblDocVinculadaGeneral = new JLabel("Documentos Vinculados:");
			lblDocVinculadaGeneral.setBounds(28, 225, 142, 14);
			panelGeneral.add(lblDocVinculadaGeneral);

			lblListaDeCampos = new JLabel("Informaci\u00F3n Res\u00FAmen:");
			lblListaDeCampos.setBounds(28, 250, 125, 14);
			panelGeneral.add(lblListaDeCampos);

			lblFrecuencia = new JLabel("Frecuencia:");
			lblFrecuencia.setBounds(28, 275, 82, 14);
			panelGeneral.add(lblFrecuencia);

			lblMtodo = new JLabel("M\u00E9todo:");
			lblMtodo.setBounds(28, 309, 82, 14);
			panelGeneral.add(lblMtodo);

			lblListaIndicadores = new JLabel("Indicadores:");
			lblListaIndicadores.setBounds(28, 350, 113, 14);
			panelGeneral.add(lblListaIndicadores);

			lblGeneradorDeRegistroGeneral = new JLabel("Generador de Registro:");
			lblGeneradorDeRegistroGeneral.setBounds(28, 375, 142, 14);
			panelGeneral.add(lblGeneradorDeRegistroGeneral);

			lblAutorizadosParaConsultaGeneral = new JLabel(
					"Autorizados Consulta:");
			lblAutorizadosParaConsultaGeneral.setBounds(28, 400, 125, 14);
			panelGeneral.add(lblAutorizadosParaConsultaGeneral);

			tFC_General = new JTextField();
			tFC_General.setBounds(180, 72, 55, 20);
			panelGeneral.add(tFC_General);
			tFC_General
					.setToolTipText("Cod. Procedimiento + Cod. Correlativo del Registro del Procesamiento.");
			tFC_General.setColumns(10);

			tFCodProcedimiento = new JTextField();
			tFCodProcedimiento.setBounds(179, 172, 34, 20);
			panelGeneral.add(tFCodProcedimiento);
			tFCodProcedimiento.setToolTipText("Cod. Procedimiento");
			tFCodProcedimiento.setColumns(10);

			tFActividad = new JTextField();
			tFActividad.setBounds(180, 197, 286, 20);
			panelGeneral.add(tFActividad);
			tFActividad
					.setToolTipText("Actividad del proceso donde se realiza el registro");
			tFActividad.setColumns(10);

			tFFrecuencia = new JTextField();
			tFFrecuencia.setBounds(180, 272, 286, 20);
			panelGeneral.add(tFFrecuencia);
			tFFrecuencia.setToolTipText("Frecuencia de la toma de registro");
			tFFrecuencia.setColumns(10);

			panelGeneral.add(getSPNombre(), null);
			panelGeneral.add(getSPDescrip(), null);
			panelGeneral.add(getComboTipo(), null);
			panelGeneral.add(getSPMetodo(), null);
			panelGeneral.add(getBtAñadirDocu(), null);
			panelGeneral.add(getBtAñadirCampos(), null);
			panelGeneral.add(getBtAñadirIndi(), null);
			panelGeneral.add(getBtAñadirGene(), null);
			panelGeneral.add(getBtAñadirAuto(), null);
			panelGeneral.add(getBtnAyuda(), null);
			panelGeneral.add(getBtnSiguiente(), null);

		}
		return panelGeneral;
	}

	/**
	 * Método que inicializa el panel de scroll para la descripción corta del
	 * registro.
	 * 
	 * @return javax.swing.JScrollPane.
	 */
	private JScrollPane getSPNombre() {
		if (scrollPanelNombre == null) {

			scrollPanelNombre = new JScrollPane();
			scrollPanelNombre.setBounds(180, 23, 286, 45);
			scrollPanelNombre
					.setBorder(UIManager.getBorder("TextField.border"));
			scrollPanelNombre.setFont(UIManager.getFont("TextField.font"));
			scrollPanelNombre.setToolTipText("Descripci\u00F3n corta");

			tANombre = new JTextArea();
			tANombre.setToolTipText("Descripci\u00F3n corta");
			tANombre.setBounds(new Rectangle(180, 9, 286, 45));
			tANombre.setBackground(UIManager.getColor("TextField.background"));
			tANombre.setCaretColor(UIManager.getColor("TextField.foreground"));
			tANombre.setColumns(10);
			tANombre.setComponentOrientation(ComponentOrientation.UNKNOWN);
			tANombre.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
			tANombre.setDisabledTextColor(UIManager
					.getColor("TextField.darkShadow"));
			tANombre.setDropMode(DropMode.USE_SELECTION);
			tANombre.setForeground(UIManager
					.getColor("TextField.caretForeground"));
			tANombre.setRows(0);
			tANombre.setTabSize(8);
			tANombre.setVerifyInputWhenFocusTarget(true);
			tANombre.setRequestFocusEnabled(true);
			tANombre.setOpaque(true);
			tANombre.setInheritsPopupMenu(false);
			tANombre.setIgnoreRepaint(false);
			tANombre.setFont(UIManager.getFont("TextField.font"));
			tANombre.setFocusable(true);
			tANombre.setFocusTraversalPolicyProvider(false);
			tANombre.setFocusCycleRoot(false);
			tANombre.setFocusTraversalKeysEnabled(true);
			tANombre.setDragEnabled(false);
			tANombre.setDoubleBuffered(false);
			tANombre.setBorder(null);
			tANombre.setWrapStyleWord(true);
			tANombre.setLineWrap(true);
			tANombre.setEnabled(true);
			tANombre.setEditable(true);
			scrollPanelNombre.setViewportView(tANombre);
		}
		return scrollPanelNombre;
	}

	/**
	 * Método que inicializa el panel de scroll para la descripción larga del
	 * registro.
	 * 
	 * @return javax.swing.JScrollPane.
	 */
	private JScrollPane getSPDescrip() {
		if (scrollPaneDescrip == null) {

			scrollPaneDescrip = new JScrollPane();
			scrollPaneDescrip
					.setBorder(UIManager.getBorder("TextField.border"));
			scrollPaneDescrip.setToolTipText("Descripci\u00F3n larga");
			scrollPaneDescrip.setFont(UIManager.getFont("TextField.font"));
			scrollPaneDescrip.setBounds(180, 97, 286, 45);

			tADescrip = new JTextArea();
			tADescrip.setToolTipText("Descripci\u00F3n detallada");
			tADescrip.setBorder(null);
			tADescrip.setWrapStyleWord(true);
			tADescrip.setVerifyInputWhenFocusTarget(true);
			tADescrip.setTabSize(8);
			tADescrip.setRows(0);
			tADescrip.setRequestFocusEnabled(true);
			tADescrip.setOpaque(true);
			tADescrip.setLineWrap(true);
			tADescrip.setInheritsPopupMenu(false);
			tADescrip.setIgnoreRepaint(false);
			tADescrip.setForeground(UIManager.getColor("windowText"));
			tADescrip.setFont(UIManager.getFont("TextField.font"));
			tADescrip.setFocusable(true);
			tADescrip.setFocusTraversalPolicyProvider(false);
			tADescrip.setFocusTraversalKeysEnabled(true);
			tADescrip.setFocusCycleRoot(false);
			tADescrip.setEnabled(true);
			tADescrip.setEditable(true);
			tADescrip.setDropMode(DropMode.USE_SELECTION);
			tADescrip.setDragEnabled(false);
			tADescrip.setDoubleBuffered(false);
			tADescrip.setDisabledTextColor(SystemColor.controlDkShadow);
			tADescrip.setComponentOrientation(ComponentOrientation.UNKNOWN);
			tADescrip.setColumns(10);
			tADescrip.setCaretColor(Color.BLACK);
			tADescrip.setBounds(new Rectangle(180, 9, 286, 45));
			tADescrip.setBackground(Color.WHITE);
			scrollPaneDescrip.setViewportView(tADescrip);
		}
		return scrollPaneDescrip;
	}

	/**
	 * Método que inicializa el comboBox para elegir si el registro es
	 * electrónico o en papel.
	 * 
	 * @return javax.swing.JComboBox.
	 */
	private JComboBox getComboTipo() {
		if (comboTipo == null) {
			comboTipo = new JComboBox();
			comboTipo.setBounds(180, 147, 46, 20);
			comboTipo
					.setToolTipText("E - Registro electr\u00F3nico       P - Registro en papel");
			comboTipo.setModel(new DefaultComboBoxModel(
					new String[] { "E", "P" }));
		}
		return comboTipo;
	}

	/**
	 * Método que inicializa el panel de scroll para el método de captura del
	 * registro.
	 * 
	 * @return javax.swing.JScrollPane.
	 */
	private JScrollPane getSPMetodo() {
		if (scrollPaneMetodo == null) {

			scrollPaneMetodo = new JScrollPane();
			scrollPaneMetodo.setBorder(UIManager.getBorder("TextField.border"));
			scrollPaneMetodo
					.setToolTipText("M\u00E9todo de captura del registro");
			scrollPaneMetodo.setFont(UIManager.getFont("TextField.font"));
			scrollPaneMetodo.setBounds(180, 297, 286, 45);
			panelGeneral.add(scrollPaneMetodo);

			tAMetodo = new JTextArea();
			tAMetodo.setToolTipText("M\u00E9todo de captura del registro");
			tAMetodo.setBorder(null);
			tAMetodo.setWrapStyleWord(true);
			tAMetodo.setVerifyInputWhenFocusTarget(true);
			tAMetodo.setTabSize(8);
			tAMetodo.setRows(0);
			tAMetodo.setRequestFocusEnabled(true);
			tAMetodo.setOpaque(true);
			tAMetodo.setLineWrap(true);
			tAMetodo.setInheritsPopupMenu(false);
			tAMetodo.setIgnoreRepaint(false);
			tAMetodo.setForeground(UIManager.getColor("windowText"));
			tAMetodo.setFont(UIManager.getFont("TextField.font"));
			tAMetodo.setFocusable(true);
			tAMetodo.setFocusTraversalPolicyProvider(false);
			tAMetodo.setFocusTraversalKeysEnabled(true);
			tAMetodo.setFocusCycleRoot(false);
			tAMetodo.setEnabled(true);
			tAMetodo.setEditable(true);
			tAMetodo.setDropMode(DropMode.USE_SELECTION);
			tAMetodo.setDragEnabled(false);
			tAMetodo.setDoubleBuffered(false);
			tAMetodo.setDisabledTextColor(SystemColor.controlDkShadow);
			tAMetodo.setComponentOrientation(ComponentOrientation.UNKNOWN);
			tAMetodo.setColumns(10);
			tAMetodo.setCaretColor(Color.BLACK);
			tAMetodo.setBounds(new Rectangle(180, 297, 286, 45));
			tAMetodo.setBackground(Color.WHITE);
			scrollPaneMetodo.setViewportView(tAMetodo);
		}
		return scrollPaneMetodo;
	}

	/**
	 * Método que inicializa el botón de ayuda.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtnAyuda() {
		if (btnAyuda == null) {
			btnAyuda = new JButton("");
			btnAyuda.setLocation(10, 452);
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
	 * Método que inicializa el botón para pasar a la pestaña siguiente del
	 * panel General.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtnSiguiente() {
		if (btnSiguienteGene == null) {
			btnSiguienteGene = new JButton("Siguiente");
			btnSiguienteGene.setMnemonic(KeyEvent.VK_G);
			btnSiguienteGene.setToolTipText("Ir a Ciclo de Vida de Registro");
			btnSiguienteGene.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelPestañas.setSelectedComponent(panelVida);
				}
			});
			btnSiguienteGene.setBounds(377, 452, 89, 23);

		}
		return btnSiguienteGene;
	}

	// ELEMENTOS PARA LA LISTA DE DOCUMENTOS

	/**
	 * Método que inicializa el botón para añadir documentos.
	 * 
	 * @return javax.swing.JButton.
	 */
	private synchronized JButton getBtAñadirDocu() {
		if (btAñadirDocu == null) {
			btAñadirDocu = new JButton();
			btAñadirDocu.setToolTipText("Lista de documentos vinculados");
			btAñadirDocu.setBounds(new Rectangle(180, 222, 85, 20));
			btAñadirDocu.setText("A\u00F1adir...");
			btAñadirDocu.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					// AGREGAR A LA LISTA
					ventanaDialogDocu(getListaDocu());
				}
			});
		}
		return btAñadirDocu;
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
	}

	/**
	 * Método que crea una pantalla dialogo, para añadir los diferentes
	 * documentos.
	 * 
	 * @param lista
	 *            Objeto lista con los documentos si los hay.
	 */
	private void ventanaDialogDocu(List<Object> lista) {
		dlgD = new Documento(lista, this);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = dlgD.getSize();
		if (frameSize.height > screenSize.height)
			frameSize.height = screenSize.height;
		if (frameSize.width > screenSize.width)
			frameSize.width = screenSize.width;
		dlgD.setLocation((screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.height) / 2);
		// Para que el aspecto sea según donde se abra, unix, mac....
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		dlgD.setModal(true);
		dlgD.setVisible(true);
	}

	// FIN LISTA DE DOCUMENTOS

	// ELEMENTOS PARA LA LISTA DE CAMPOS

	/**
	 * Método que inicializa el botón para añadir la lista de campos.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtAñadirCampos() {
		if (btnAñadirCampos == null) {
			btnAñadirCampos = new JButton();
			btnAñadirCampos.setToolTipText("Lista de campos registro");
			btnAñadirCampos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					// AGREGAR A LA LISTA
					ventanaDialogCampos(getListaCampo());
				}
			});
			btnAñadirCampos.setText("A\u00F1adir...");
			btnAñadirCampos.setBounds(new Rectangle(180, 222, 75, 20));
			btnAñadirCampos.setBounds(180, 247, 85, 20);
		}
		return btnAñadirCampos;
	}

	/**
	 * Getter.
	 * 
	 * @return Lista con la lista de campos.
	 */
	public List<Object> getListaCampo() {
		return listaCampo;
	}

	/**
	 * Setter.
	 * 
	 * @param listaCampo
	 *            Lista con los campos.
	 */
	public void setListaCampo(List<Object> listaCampo) {
		this.listaCampo = listaCampo;
	}

	/**
	 * Método que crea una pantalla dialogo, para añadir los diferentes campos.
	 * 
	 * @param lista
	 *            Objeto lista con los campos si los hay.
	 */
	private void ventanaDialogCampos(List<Object> lista) {
		dlgC = new Campo(lista, this);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = dlgC.getSize();
		if (frameSize.height > screenSize.height)
			frameSize.height = screenSize.height;
		if (frameSize.width > screenSize.width)
			frameSize.width = screenSize.width;
		dlgC.setLocation((screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.height) / 2);
		// Para que el aspecto sea según donde se abra, unix, mac....
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		dlgC.setModal(true);
		dlgC.setVisible(true);
	}

	// FIN DE LISTA CAMPOS

	// ELEMENTOS PARA LA LISTA DE INDICADORES

	/**
	 * Método que inicializa el botón para añadir la lista de indicadores.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtAñadirIndi() {
		if (btnAñadirIndi == null) {
			btnAñadirIndi = new JButton();
			btnAñadirIndi.setToolTipText("Lista de Indicadores");
			btnAñadirIndi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					// AGREGAR A LA LISTA
					ventanaDialogIndi(getListaIndi());
				}
			});
			btnAñadirIndi.setText("A\u00F1adir...");
			btnAñadirIndi.setBounds(new Rectangle(180, 222, 75, 20));
			btnAñadirIndi.setBounds(180, 348, 85, 20);
		}
		return btnAñadirIndi;
	}

	/**
	 * Getter.
	 * 
	 * @return Lista con la lista de indicadores.
	 */
	public List<Object> getListaIndi() {
		return listaIndi;
	}

	/**
	 * Setter.
	 * 
	 * @param listaIndi
	 *            Lista con los indicadores.
	 */
	public void setListaIndi(List<Object> listaIndi) {
		this.listaIndi = listaIndi;
	}

	/**
	 * Método que crea una pantalla dialogo, para añadir los diferentes
	 * indicadores.
	 * 
	 * @param lista
	 *            Objeto lista con los indicadores si los hay.
	 */
	private void ventanaDialogIndi(List<Object> lista) {
		dlgI = new Indicador(lista, this);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = dlgI.getSize();
		if (frameSize.height > screenSize.height)
			frameSize.height = screenSize.height;
		if (frameSize.width > screenSize.width)
			frameSize.width = screenSize.width;
		dlgI.setLocation((screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.height) / 2);
		// Para que el aspecto sea según donde se abra, unix, mac....
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		dlgI.setModal(true);
		dlgI.setVisible(true);
	}

	// FIN DE LISTA INDICADORES

	// ELEMENTOS PARA LA LISTA DE GENERADORES

	/**
	 * Método que inicializa el botón para añadir la lista de generadores.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtAñadirGene() {
		if (btnAñadirGene == null) {
			btnAñadirGene = new JButton();
			btnAñadirGene.setToolTipText("Lista de generadores de registro");
			btnAñadirGene.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					// AGREGAR A LA LISTA
					ventanaDialogGene(getListaGene());
				}
			});
			btnAñadirGene.setText("A\u00F1adir...");
			btnAñadirGene.setBounds(new Rectangle(180, 222, 75, 20));
			btnAñadirGene.setBounds(180, 373, 85, 20);
		}
		return btnAñadirGene;
	}

	/**
	 * Getter.
	 * 
	 * @return Lista con la lista de generadores.
	 */
	public List<Object> getListaGene() {
		return listaGenerador;
	}

	/**
	 * Setter.
	 * 
	 * @param listaGene
	 *            Lista con los generadores.
	 */
	public void setListaGene(List<Object> listaGene) {
		this.listaGenerador = listaGene;
	}

	/**
	 * Método que crea una pantalla dialogo, para añadir los diferentes
	 * generadores.
	 * 
	 * @param lista
	 *            Objeto lista con los generadores si los hay.
	 */
	private void ventanaDialogGene(List<Object> lista) {
		dlgG = new Generador(lista, this);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = dlgG.getSize();
		if (frameSize.height > screenSize.height)
			frameSize.height = screenSize.height;
		if (frameSize.width > screenSize.width)
			frameSize.width = screenSize.width;
		dlgG.setLocation((screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.height) / 2);
		// Para que el aspecto sea según donde se abra, unix, mac....
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		dlgG.setModal(true);
		dlgG.setVisible(true);
	}

	// FIN DE LISTA GENERADORES

	// ELEMENTOS PARA LA LISTA DE AUTORIZADO

	/**
	 * Método que inicializa el botón para añadir la lista de autorizados.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtAñadirAuto() {
		if (btnAñadirAuto == null) {
			btnAñadirAuto = new JButton();
			btnAñadirAuto.setToolTipText("Lista de autorizados");
			btnAñadirAuto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					// AGREGAR A LA LISTA
					ventanaDialogAuto(getListaAuto());
				}
			});
			btnAñadirAuto.setText("A\u00F1adir...");
			btnAñadirAuto.setBounds(new Rectangle(180, 222, 75, 20));
			btnAñadirAuto.setBounds(180, 398, 85, 20);
		}
		return btnAñadirAuto;
	}

	/**
	 * Getter.
	 * 
	 * @return Lista con la lista de autorizados.
	 */
	public List<Object> getListaAuto() {
		return listaAutorizado;
	}

	/**
	 * Setter.
	 * 
	 * @param listaAuto
	 *            Lista con los autorizados.
	 */
	public void setListaAuto(List<Object> listaAuto) {
		this.listaAutorizado = listaAuto;
	}

	/**
	 * Método que crea una pantalla dialogo, para añadir los diferentes
	 * autorizados.
	 * 
	 * @param lista
	 *            Objeto lista con los autorizados si los hay.
	 */
	private void ventanaDialogAuto(List<Object> lista) {
		dlgA = new Autorizado(lista, this);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = dlgA.getSize();
		if (frameSize.height > screenSize.height)
			frameSize.height = screenSize.height;
		if (frameSize.width > screenSize.width)
			frameSize.width = screenSize.width;
		dlgA.setLocation((screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.height) / 2);
		// Para que el aspecto sea según donde se abra, unix, mac....
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		dlgA.setModal(true);
		dlgA.setVisible(true);
	}

	// FIN DE LISTA AUTORIZADO

	// FIN DE REGISTRO GENERAL

	// CICLO DE VIDA

	/**
	 * Método que devuelve el panel del formulario de la pestaña de Ciclo de
	 * Vida de los registros del administrador con los elementos creados.
	 * 
	 * @return javax.swing.JPanel.
	 */
	private JPanel getPanelVida() {
		if (panelVida == null) {

			panelVida = new JPanel();
			panelVida.setLayout(null);

			JLabel lblArchivo = new JLabel("Archivo:");
			lblArchivo.setBounds(39, 54, 69, 14);
			lblArchivo.setAlignmentX(Component.CENTER_ALIGNMENT);
			panelVida.add(lblArchivo);

			JLabel lblRetencin = new JLabel("Retenci\u00F3n:");
			lblRetencin.setAlignmentX(0.5f);
			lblRetencin.setBounds(39, 104, 69, 14);
			panelVida.add(lblRetencin);

			JLabel lblConservacin = new JLabel("Conservaci\u00F3n:");
			lblConservacin.setAlignmentX(0.5f);
			lblConservacin.setBounds(39, 154, 83, 14);
			panelVida.add(lblConservacin);

			JLabel lblDisposicin = new JLabel("Disposici\u00F3n:");
			lblDisposicin.setAlignmentX(0.5f);
			lblDisposicin.setBounds(39, 204, 69, 14);
			panelVida.add(lblDisposicin);

			JLabel lblAlmacen = new JLabel("Almac\u00E9n:");
			lblAlmacen.setAlignmentX(0.5f);
			lblAlmacen.setBounds(39, 254, 69, 14);
			panelVida.add(lblAlmacen);

			tFArch = new JTextField();
			tFArch.setToolTipText("Ubicaci\u00F3n donde se guardan los registros activos");
			tFArch.setBounds(127, 51, 339, 20);
			panelVida.add(tFArch);
			tFArch.setColumns(10);

			tFReten = new JTextField();
			tFReten.setToolTipText("Es el tiempo que debe ser mantenido hasta que es descartado o destruido, o enviado a un almac\u00E9n de larga duraci\u00F3n");
			tFReten.setColumns(10);
			tFReten.setBounds(127, 101, 339, 20);
			panelVida.add(tFReten);

			tFConser = new JTextField();
			tFConser.setToolTipText("Tipo de conservaci\u00F3n de los datos de los registros");
			tFConser.setColumns(10);
			tFConser.setBounds(127, 151, 339, 20);
			panelVida.add(tFConser);

			tFAlma = new JTextField();
			tFAlma.setToolTipText("Tipo de almacenamiento de los datos de los registros");
			tFAlma.setColumns(10);
			tFAlma.setBounds(127, 251, 339, 20);
			panelVida.add(tFAlma);

			panelVida.add(getComboDispo(), null);
			panelVida.add(getChckVersinModificada(), null);

			panelVida.add(getBtnAtrasCiclo(), null);
			panelVida.add(getBtnEnviar(), null);

		}
		return panelVida;
	}

	/**
	 * Método que inicializa el comboBox para elegir que hacer con el registro
	 * cuando exceda el tiempo de retención.
	 * 
	 * @return javax.swing.JComboBox.
	 */
	private JComboBox getComboDispo() {
		if (comboDispo == null) {
			comboDispo = new JComboBox();
			comboDispo
					.setToolTipText("Cuando se exceda el tiempo de retenci\u00F3n que hacer");
			comboDispo.setModel(new DefaultComboBoxModel(new String[] {
					"Descartar", "Destruir",
					"Contactar con la Oficina de Gesti\u00F3n" }));
			comboDispo.setBounds(127, 201, 224, 20);
		}
		return comboDispo;
	}

	/**
	 * Método que inicializa el checkBox para saber si es un registro modificado
	 * o no.
	 * 
	 * @return javax.swing.JCheckBox.
	 */
	private JCheckBox getChckVersinModificada() {
		if (chckVersinModificada == null) {
			chckVersinModificada = new JCheckBox("Versi\u00F3n Modificada");
			chckVersinModificada.setMnemonic(KeyEvent.VK_V);
			chckVersinModificada.setEnabled(false);
			chckVersinModificada.setBounds(39, 311, 122, 23);
		}
		return chckVersinModificada;
	}

	/**
	 * Método que inicializa el botón para volver hacia la pestaña del registro
	 * General.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtnAtrasCiclo() {
		if (btnAtrasCiclo == null) {
			btnAtrasCiclo = new JButton("Atr\u00E1s");
			btnAtrasCiclo.setMnemonic(KeyEvent.VK_T);
			btnAtrasCiclo.setToolTipText("Ir a Registro General");
			btnAtrasCiclo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelPestañas.setSelectedComponent(panelGeneral);
				}
			});
			btnAtrasCiclo.setBounds(26, 452, 89, 23);

		}
		return btnAtrasCiclo;
	}

	// BOTÓN ENVIAR DATOS
	/**
	 * Método que inicializa el botón para mandar los datos a almacenar.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtnEnviar() {
		if (btnEnviar == null) {
			btnEnviar = new JButton("Enviar");
			btnEnviar.setMnemonic(KeyEvent.VK_V);
			btnEnviar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					rac.setNombre(tANombre.getText());
					rac.setCodGeneral(tFC_General.getText());
					rac.setDescri(tADescrip.getText());
					rac.setTipo(comboTipo.getSelectedItem().toString());
					rac.setCodProce(tFCodProcedimiento.getText());
					rac.setActi(tFActividad.getText());
					rac.setFrecu(tFFrecuencia.getText());
					rac.setMeto(tAMetodo.getText());
					rac.setArchivo(tFArch.getText());
					rac.setRetencion(tFReten.getText());
					rac.setConservacion(tFConser.getText());
					rac.setDispo(comboDispo.getSelectedItem().toString());
					rac.setAlmacen(tFAlma.getText());
					rac.setModi(chckVersinModificada.isSelected());

					// LISTA DOCUMENTOS
					d.ListaDocumento(tFC_General.getText(), listaDocu);

					// LISTA CAMPOS
					c.ListaCampo(tFC_General.getText(), listaCampo);

					// LISTA INDICADORES
					i.ListaIndicador(tFC_General.getText(), listaIndi);

					// LISTA GENERADOR
					g.ListaGenerador(tFC_General.getText(), listaGenerador);

					// LISTA AUTORIZADO
					a.ListaAutorizado(tFC_General.getText(), listaAutorizado);

					rac.despertarHilo();

					btnEnviar.setEnabled(false);
				}
			});
			btnEnviar.setToolTipText("Enviar");
			btnEnviar.setBounds(377, 452, 89, 23);
		}
		return btnEnviar;
	}

	// FIN CICLO DE VIDA

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
			hb.enableHelpOnButton(btnAyuda, "general", hs);
			// Desplega ayuda pulsando sobre F1
			hb.enableHelpKey(this.getPanelPestañas(), "general", hs);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,
					"Fichero de Ayuda no encontrado " + e.getMessage(),
					"Ayuda", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	/**
	 * Método que sobreescribe PRINT para poder imprimir por impresora la
	 * pestaña que esta en pantalla.
	 */
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
			throws PrinterException {

		if (pageIndex > 0) { /* We have only one page, and 'page' is zero-based */
			return NO_SUCH_PAGE;
		}

		Graphics2D g2d = (Graphics2D) graphics;
		g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

		panelPestañas.printAll(graphics);

		return PAGE_EXISTS;
	}
}
