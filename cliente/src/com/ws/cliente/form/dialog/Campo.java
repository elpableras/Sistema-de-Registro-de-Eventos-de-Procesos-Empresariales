package com.ws.cliente.form.dialog;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
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

import com.ws.cliente.form.Procedimiento1y2;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URL;

import javax.swing.border.EtchedBorder;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

/**
 * Clase que hereda de JDialog, para crear un panel dialogo para agregar la
 * lista de campos.
 */
public class Campo extends JDialog {

	/**
	 * Serial.
	 */
	private static final long serialVersionUID = -355153293351333296L;
	private JScrollPane panelListaCampos = null;
	private DefaultListModel modeloLista = null;
	private JList listaCampos = null;

	private JTextField tFRef;

	private JLabel lblRef = null;
	private JLabel lblNombre = null;

	private JButton btAñadir = null;
	private JButton btEliminar = null;
	private JButton btnCancelar = null;
	private JButton btnAceptar = null;

	private List<Object> lista = new LinkedList<Object>();
	private Procedimiento1y2 p;
	private int cont = 1;
	private JTextField tFNombre = null;
	private JTextField tFDescri = null;
	private JTextField tFTipo = null;
	private JTextField tFUni = null;
	private JButton btnAyuda;

	/**
	 * Constructor por defecto.
	 * 
	 * @param lista
	 *            Lista con los campos.
	 * @param p
	 *            Objeto de tipo Procedimiento1y2, que será donde se devuelva la
	 *            lista creada.
	 */
	public Campo(List<Object> lista, Procedimiento1y2 p) {
		super();
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\iconos\\Pantalla\\Dialogo.png"));
		setTitle("Informaci\u00F3n Resumen");
		this.lista = lista;
		this.p = p;
		initialize();
		setAyuda();
	}

	/**
	 * Método para cargar los elementos del panel principal.
	 */
	private void initialize() {
		setBounds(100, 100, 372, 444);
		getContentPane().setLayout(null);

		JPanel panelCampos = new JPanel();
		panelCampos.setBounds(0, 0, 356, 406);
		panelCampos.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Lista de Campos",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		getContentPane().add(panelCampos);
		panelCampos.setLayout(null);

		panelCampos.add(getPanelListaCampos(), null);
		rellenarLista();
		panelCampos.add(getLabelCod(), null);
		panelCampos.add(getLblNombre(), null);

		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setBounds(27, 49, 58, 14);
		panelCampos.add(lblDescripcin);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(27, 74, 49, 14);
		panelCampos.add(lblTipo);

		JLabel lblUnidad = new JLabel("Unidad:");
		lblUnidad.setBounds(27, 99, 49, 14);
		panelCampos.add(lblUnidad);

		panelCampos.add(getTFRef(), null);
		panelCampos.add(getTFNombre(), null);
		panelCampos.add(getTFDescri(), null);
		panelCampos.add(getTFTipo(), null);
		panelCampos.add(getTFUni(), null);

		panelCampos.add(getBtAñadir(), null);
		panelCampos.add(getBtEliminar(), null);
		panelCampos.add(getBtCancelar(), null);
		panelCampos.add(getBtAceptar(), null);

		panelCampos.add(getBtnAyuda());
	}

	/**
	 * Método que inicializa el panel de scroll de la lista de campos.
	 * 
	 * @return javax.swing.JScrollPane.
	 */
	private JScrollPane getPanelListaCampos() {
		if (panelListaCampos == null) {
			panelListaCampos = new JScrollPane();
			panelListaCampos.setToolTipText("");
			panelListaCampos.setBounds(new Rectangle(10, 213, 336, 154));
			panelListaCampos.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Lista de Informaci\u00F3nes de Resumen", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(51, 51, 51)));
			panelListaCampos.setViewportView(getListaVisitas());
		}
		return panelListaCampos;
	}

	/**
	 * Método que inicializa el JList de la lista de campos.
	 * 
	 * @return javax.swing.JList.
	 */
	private JList getListaVisitas() {
		modeloLista = new DefaultListModel();
		if (listaCampos == null) {
			listaCampos = new JList(modeloLista);
		}
		return listaCampos;
	}

	/**
	 * Método para rellenar la lista de campos.
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
	 * Método que inicializa la etiqueta de Referencia a la documentación.
	 * 
	 * @return javax.swing.JLabel.
	 */
	private JLabel getLabelCod() {
		if (lblRef == null) {
			lblRef = new JLabel("Referencia a la documentaci\u00F3n asociada:");
			lblRef.setBounds(27, 137, 254, 14);
		}
		return lblRef;
	}

	/**
	 * Método que inicializa la etiqueta de Nombre.
	 * 
	 * @return javax.swing.JLabel.
	 */
	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(27, 24, 49, 14);
		}
		return lblNombre;
	}

	/**
	 * Método que inicializa el TextField de Nombre.
	 * 
	 * @return javax.swing.JTextField.
	 */
	private JTextField getTFNombre() {
		if (tFNombre == null) {
			tFNombre = new JTextField();
			tFNombre.setToolTipText("Nombre");
			tFNombre.setBounds(100, 21, 219, 20);
			tFNombre.setColumns(10);
		}
		return tFNombre;
	}

	/**
	 * Método que inicializa el TextField de Descripción.
	 * 
	 * @return javax.swing.JTextField.
	 */
	private JTextField getTFDescri() {
		if (tFDescri == null) {
			tFDescri = new JTextField();
			tFDescri.setToolTipText("Descripci\u00F3n");
			tFDescri.setColumns(10);
			tFDescri.setBounds(100, 46, 219, 20);
		}
		return tFDescri;
	}

	/**
	 * Método que inicializa el TextField de Tipo.
	 * 
	 * @return javax.swing.JTextField.
	 */
	private JTextField getTFTipo() {
		if (tFTipo == null) {
			tFTipo = new JTextField();
			tFTipo.setToolTipText("Tipo");
			tFTipo.setColumns(10);
			tFTipo.setBounds(100, 71, 219, 20);
		}
		return tFTipo;
	}

	/**
	 * Método que inicializa el TextField de Unidad.
	 * 
	 * @return javax.swing.JTextField.
	 */
	private JTextField getTFUni() {
		if (tFUni == null) {
			tFUni = new JTextField();
			tFUni.setToolTipText("Unidad");
			tFUni.setColumns(10);
			tFUni.setBounds(100, 96, 219, 20);
		}
		return tFUni;
	}

	/**
	 * Método que inicializa el TextField del Cód. o enlace a la referencia.
	 * 
	 * @return javax.swing.JTextField.
	 */
	private JTextField getTFRef() {
		if (tFRef == null) {
			tFRef = new JTextField();
			tFRef.setToolTipText("C\u00F3digo o enlace a la referencia");
			tFRef.setBounds(75, 162, 244, 20);
			tFRef.setColumns(10);
		}
		return tFRef;
	}

	/**
	 * Método que inicializa el botón de añadir elementos a la lista de campos.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtAñadir() {
		if (btAñadir == null) {
			btAñadir = new JButton();
			btAñadir.setMnemonic(KeyEvent.VK_A);
			btAñadir.setToolTipText("A\u00F1adir a la lista");
			btAñadir.setBounds(new Rectangle(241, 193, 78, 20));
			btAñadir.setText("A\u00F1adir");
			btAñadir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (tFNombre.getText().compareTo("") == 0) {
						modeloLista.addElement(" " + " " + " " + " / " + " ");
					} else {
						modeloLista.addElement(tFNombre.getText() + " "
								+ tFDescri.getText() + " " + tFTipo.getText()
								+ " " + tFUni.getText() + " / "
								+ tFRef.getText());
					}

					tFNombre.setText("");
					tFDescri.setText("");
					tFTipo.setText("");
					tFUni.setText("");
					tFRef.setText("");
					cont++;
					btEliminar.setEnabled(true);
				}
			});
		}
		return btAñadir;
	}

	/**
	 * Método que inicializa el botón de eliminar elementos de la lista de
	 * campos.
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
			btEliminar.setBounds(new Rectangle(99, 378, 71, 20));
			btEliminar.setText("Eliminar");
			btEliminar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					modeloLista.removeElement(listaCampos.getSelectedValue());
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
	 * Método que inicializa el botón de aceptar, almacena la lista de campos.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton();
			btnAceptar.setMnemonic(KeyEvent.VK_T);
			btnAceptar.setToolTipText("Guardar lista");
			lista = new LinkedList<Object>();
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for (int i = 0; i < modeloLista.getSize(); i++) {
						lista.add(modeloLista.elementAt(i));
					}
					p.setListaCampo(lista);
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
			hb.enableHelpOnButton(btnAyuda, "campos", hs);
			// Desplega ayuda pulsando sobre F1
			hb.enableHelpKey(this.getContentPane(), "campos", hs);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,
					"Fichero de Ayuda no encontrado " + e.getMessage(),
					"Ayuda", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
