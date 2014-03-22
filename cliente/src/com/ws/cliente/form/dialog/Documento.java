package com.ws.cliente.form.dialog;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import javax.swing.UIManager;
import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JTextArea;

import com.ws.cliente.form.PantallaGerente;
import com.ws.cliente.form.PantallaRRHH;
import com.ws.cliente.form.Procedimiento1y2;

import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URL;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

/**
 * Clase que hereda de JDialog, para crear un panel dialogo para agregar la
 * lista de enlaces a documentos.
 */
public class Documento extends JDialog {

	/**
	 * Serial.
	 */
	private static final long serialVersionUID = -9221565200002587113L;
	private JScrollPane panelScrollDocu = null;
	private DefaultListModel modeloLista = null;
	private JList listaDocus = null;

	private JTextField tFCod;
	private JTextArea tFTipo;

	private JLabel lblCod = null;
	private JLabel lblTipo = null;

	private JButton btnExaminar = null;
	private JButton btAñadir = null;
	private JButton btEliminar = null;
	private JButton btnCancelar = null;
	private JButton btnAceptar = null;

	private Procedimiento1y2 p = null;
	private PantallaRRHH prh = null;
	private PantallaGerente pg = null;

	private List<Object> lista = new LinkedList<Object>();
	private int cont = 0;

	private JFileChooser selector = new JFileChooser();
	private JButton btnAyuda;

	/**
	 * Constructor para crear JDialog para Administrador.
	 * 
	 * @param lista
	 *            Lista con los enlaces a documentos.
	 * @param p
	 *            Objeto de tipo Procedimiento1y2, que será donde se devuelva la
	 *            lista creada.
	 */
	public Documento(List<Object> lista, Procedimiento1y2 p) {
		super();
		this.lista = lista;
		this.p = p;
		initialize();
	}

	/**
	 * Constructor para crear JDialog para RRHH.
	 * 
	 * @param lista
	 *            Lista con los enlaces a documentos.
	 * @param prh
	 *            Objeto de tipo PantallaRRHH, que será donde se devuelva la
	 *            lista creada.
	 */
	public Documento(List<Object> lista, PantallaRRHH prh) {
		super();
		this.lista = lista;
		this.prh = prh;
		initialize();
	}

	/**
	 * Constructor para crear JDialog para Gerente.
	 * 
	 * @param lista
	 *            Lista con los enlaces a documentos.
	 * @param pg
	 *            Objeto de tipo PantallaGerente, que será donde se devuelva la
	 *            lista creada.
	 */
	public Documento(List<Object> lista, PantallaGerente pg) {
		super();
		this.lista = lista;
		this.pg = pg;
		initialize();
	}

	/**
	 * Método para cargar los elementos del panel principal.
	 */
	private void initialize() {

		this.setIconImage(Toolkit
				.getDefaultToolkit()
				.getImage(
						"img\\iconos\\Pantalla\\Dialogo.png"));
		this.setTitle("Documentos");

		selector.setMultiSelectionEnabled(true);

		setBounds(100, 100, 372, 444);
		getContentPane().setLayout(null);

		JPanel panelDocumentos = new JPanel();
		panelDocumentos.setBounds(0, 0, 356, 406);
		panelDocumentos.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"),
				"Lista de Documentos Vinculados", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(panelDocumentos);
		panelDocumentos.setLayout(null);

		panelDocumentos.add(getPanelScrollDocu(), null);
		rellenarLista();
		panelDocumentos.add(getLabelCod(), null);
		panelDocumentos.add(getLblTipo(), null);

		panelDocumentos.add(getTFTipo(), null);
		panelDocumentos.add(getTFCod(), null);

		panelDocumentos.add(getBtnExaminar(), null);
		panelDocumentos.add(getBtAñadir(), null);
		panelDocumentos.add(getBtEliminar(), null);
		panelDocumentos.add(getBtCancelar(), null);
		panelDocumentos.add(getBtAceptar(), null);
		panelDocumentos.add(getBtnAyuda());
		setAyuda();
	}

	/**
	 * Método que inicializa el panel de scroll de la lista de enlaces a
	 * documentos.
	 * 
	 * @return javax.swing.JScrollPane.
	 */
	private JScrollPane getPanelScrollDocu() {
		if (panelScrollDocu == null) {
			panelScrollDocu = new JScrollPane();
			panelScrollDocu.setToolTipText("");
			panelScrollDocu.setBounds(new Rectangle(10, 244, 336, 126));
			panelScrollDocu.setBorder(new TitledBorder(UIManager
					.getBorder("TitledBorder.border"), "Lista de Documentos",
					TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null,
					new Color(51, 51, 51)));
			panelScrollDocu.setViewportView(getListaVisitas());
		}
		return panelScrollDocu;
	}

	/**
	 * Método que inicializa el JList de la lista de enlaces a documentos.
	 * 
	 * @return javax.swing.JList.
	 */
	private JList getListaVisitas() {
		modeloLista = new DefaultListModel();
		if (listaDocus == null) {
			listaDocus = new JList(modeloLista);
		}
		return listaDocus;
	}

	/**
	 * Método para rellenar la lista de enlaces a documentos.
	 */
	private void rellenarLista() {
		if (lista != null) {
			for (int j = 0; j < lista.size(); j++) {
				modeloLista.addElement(lista.get(j).toString());
			}
			cont = lista.size() + 1;
		}
	}

	/**
	 * Método que inicializa la etiqueta del Código de documento o enlace.
	 * 
	 * @return javax.swing.JLabel.
	 */
	private JLabel getLabelCod() {
		if (lblCod == null) {
			lblCod = new JLabel(
					"C\u00F3digo de documento o enlace al mismo si es digital:");
			lblCod.setBounds(27, 41, 254, 14);
		}
		return lblCod;
	}

	/**
	 * Método que inicializa la etiqueta de Tipo o descripción del enlace a
	 * documento.
	 * 
	 * @return javax.swing.JLabel.
	 */
	private JLabel getLblTipo() {
		if (lblTipo == null) {
			lblTipo = new JLabel("Tipo y descripci\u00F3n del documento: ");
			lblTipo.setBounds(27, 127, 254, 14);
		}
		return lblTipo;
	}

	/**
	 * Método que inicializa el TextArea de Tipo o descripción del enlace a
	 * documento.
	 * 
	 * @return javax.swing.JTextArea.
	 */
	private JTextArea getTFTipo() {
		if (tFTipo == null) {
			tFTipo = new JTextArea();
			tFTipo.setBorder(UIManager.getBorder("TextField.border"));
			tFTipo.setFont(UIManager.getFont("TextField.font"));
			tFTipo.setLineWrap(true);
			tFTipo.setWrapStyleWord(true);
			tFTipo.setToolTipText("Tipo y descripci\u00F3n");
			tFTipo.setBounds(37, 152, 244, 50);
			tFTipo.setColumns(10);
		}
		return tFTipo;
	}

	/**
	 * Método que inicializa el TextField de Código o enlace.
	 * 
	 * @return javax.swing.JTextField.
	 */
	private JTextField getTFCod() {
		if (tFCod == null) {
			tFCod = new JTextField();
			tFCod.setToolTipText("C\u00F3digo o enlace");
			tFCod.setBounds(37, 66, 244, 20);
			tFCod.setColumns(10);
		}
		return tFCod;
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
			btnExaminar.setMnemonic(KeyEvent.VK_X);
			btnExaminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String nombre = "";
					int respuesta = selector.showOpenDialog(null);
					if (respuesta == JFileChooser.APPROVE_OPTION) {
						for (int i = 0; i < selector.getSelectedFiles().length; i++) {
							nombre += selector.getSelectedFiles()[i]
									.getAbsolutePath() + ",";
						}
					}
					tFCod.setText(nombre);
				}
			});
			btnExaminar.setBounds(203, 97, 78, 20);
		}
		return btnExaminar;
	}

	/**
	 * Método que inicializa el botón de añadir elementos a la lista de enlaces
	 * a documentos.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtAñadir() {
		if (btAñadir == null) {
			btAñadir = new JButton();
			btAñadir.setMnemonic(KeyEvent.VK_A);
			btAñadir.setToolTipText("A\u00F1adir a la lista");
			btAñadir.setBounds(new Rectangle(203, 213, 78, 20));
			btAñadir.setText("A\u00F1adir");
			btAñadir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					modeloLista.addElement(tFCod.getText() + " / "
							+ tFTipo.getText());
					tFCod.setText("");
					tFTipo.setText("");
					cont++;
					btEliminar.setEnabled(true);
				}
			});
		}
		return btAñadir;
	}

	/**
	 * Método que inicializa el botón de eliminar elementos de la lista de
	 * enlaces a documentos.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtEliminar() {
		if (btEliminar == null) {
			btEliminar = new JButton();
			btEliminar.setMnemonic(KeyEvent.VK_E);
			btEliminar.setToolTipText("Eliminar de la lista");
			if (cont > 1) {
				btEliminar.setEnabled(true);
			} else {
				btEliminar.setEnabled(false);
			}
			btEliminar.setBounds(new Rectangle(92, 378, 78, 20));
			btEliminar.setText("Eliminar");
			btEliminar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					modeloLista.removeElement(listaDocus.getSelectedValue());
					cont--;
					if (cont < 2) {
						btEliminar.setEnabled(false);
					}
				}
			});
		}
		return btEliminar;
	}

	/**
	 * Método que inicializa el botón de cancelar, cierra el JDialog.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton();
			btnCancelar.setMnemonic(KeyEvent.VK_C);
			btnCancelar.setToolTipText("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnCancelar.setText("Cancelar");
			btnCancelar.setBounds(new Rectangle(166, 375, 78, 20));
			btnCancelar.setBounds(180, 378, 78, 20);
		}
		return btnCancelar;
	}

	/**
	 * Método que inicializa el botón de aceptar, almacena la lista de enlaces a
	 * documentos.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton();
			btnAceptar.setMnemonic(KeyEvent.VK_T);
			btnAceptar.setToolTipText("Guardar lista");
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for (int i = 0; i < modeloLista.getSize(); i++) {
						lista.add(modeloLista.elementAt(i));
					}
					if (p != null) {
						// LISTA DE DOCUMENTOS PARA GENERAL
						p.setListaDocu(lista);
					} else if (prh != null) {
						// LISTA DE DOCUMENTOS RRHH
						prh.setListaDocu(lista);
					} else if (pg != null && cont > 0) {
						// LISTA DE DOCUMENTOS GERENTE
						pg.setListaDocu(lista);
					}
					dispose();
				}
			});
			btnAceptar.setText("Aceptar");
			btnAceptar.setBounds(new Rectangle(166, 375, 78, 20));
			btnAceptar.setBounds(268, 378, 78, 20);
		}
		return btnAceptar;
	}

	/**
	 * Método que inicializa el botón para la ayuda.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtnAyuda() {
		if (btnAyuda == null) {
			btnAyuda = new JButton("");
			btnAyuda.setLocation(20, 374);
			btnAyuda.setIcon(new ImageIcon(
					"img\\iconos\\Info.png"));
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
			hb.enableHelpOnButton(btnAyuda, "documentacion", hs);
			// Desplega ayuda pulsando sobre F1
			hb.enableHelpKey(this.getContentPane(), "documentacion", hs);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,
					"Fichero de Ayuda no encontrado " + e.getMessage(),
					"Ayuda", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
