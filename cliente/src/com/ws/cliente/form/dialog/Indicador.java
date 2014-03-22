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
import java.awt.Toolkit;
import javax.swing.ImageIcon;

/**
 * Clase que hereda de JDialog, para crear un panel dialogo para agregar la
 * lista de indicadores.
 */
public class Indicador extends JDialog {

	/**
	 * Serial.
	 */
	private static final long serialVersionUID = -355153293351333296L;
	private JScrollPane panelListaIndicadores = null;
	private DefaultListModel modeloLista = null;
	private JList listaIndi = null;

	private JTextField tFIndicador;

	private JLabel lblIndicador = null;

	private JButton btAñadir = null;
	private JButton btnAyuda = null;
	private JButton btEliminar = null;
	private JButton btnCancelar = null;
	private JButton btnAceptar = null;

	private List<Object> lista = new LinkedList<Object>();
	private Procedimiento1y2 p;
	private int cont = 1;

	/**
	 * Constructor para crear JDialog para Administrador.
	 * 
	 * @param lista
	 *            Lista con los indicadores.
	 * @param p
	 *            Objeto de tipo Procedimiento1y2, que será donde se devuelva la
	 *            lista creada.
	 */
	public Indicador(List<Object> lista, Procedimiento1y2 p) {
		super();
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\iconos\\Pantalla\\Dialogo.png"));
		setTitle("Indicadores");
		this.lista = lista;
		this.p = p;
		initialize();
		setAyuda();
	}

	/**
	 * Método para cargar los elementos del panel principal.
	 */
	private void initialize() {
		setBounds(100, 100, 372, 368);
		getContentPane().setLayout(null);

		JPanel panelIndi = new JPanel();
		panelIndi.setBounds(0, 0, 356, 338);
		panelIndi.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Lista de Indicadores",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		getContentPane().add(panelIndi);
		panelIndi.setLayout(null);

		panelIndi.add(getPanelListaIndicadores(), null);
		rellenarLista();
		panelIndi.add(getLabelCod(), null);
		panelIndi.add(getTFIndicador(), null);

		panelIndi.add(getBtAñadir(), null);
		panelIndi.add(getBtnAyuda(), null);
		panelIndi.add(getBtEliminar(), null);
		panelIndi.add(getBtCancelar(), null);
		panelIndi.add(getBtAceptar(), null);
	}

	/**
	 * Método que inicializa el panel de scroll de la lista de indicadores.
	 * 
	 * @return javax.swing.JScrollPane.
	 */
	private JScrollPane getPanelListaIndicadores() {
		if (panelListaIndicadores == null) {
			panelListaIndicadores = new JScrollPane();
			panelListaIndicadores.setToolTipText("");
			panelListaIndicadores.setBounds(new Rectangle(10, 121, 336, 170));
			panelListaIndicadores.setBorder(new TitledBorder(UIManager
					.getBorder("TitledBorder.border"), "Indicadores",
					TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null,
					new Color(51, 51, 51)));
			panelListaIndicadores.setViewportView(getListaVisitas());
		}
		return panelListaIndicadores;
	}

	/**
	 * Método que inicializa el JList de la lista de indicadores.
	 * 
	 * @return javax.swing.JList.
	 */
	private JList getListaVisitas() {
		modeloLista = new DefaultListModel();
		if (listaIndi == null) {
			listaIndi = new JList(modeloLista);
		}
		return listaIndi;
	}

	/**
	 * Método para rellenar la lista de indicadores.
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
	 * Método que inicializa la etiqueta del Indicador a aplicar.
	 * 
	 * @return javax.swing.JLabel.
	 */
	private JLabel getLabelCod() {
		if (lblIndicador == null) {
			lblIndicador = new JLabel("Indicador a aplicar:");
			lblIndicador.setBounds(26, 34, 254, 14);
		}
		return lblIndicador;
	}

	/**
	 * Método que inicializa el TextField de Indicador.
	 * 
	 * @return javax.swing.JTextField.
	 */
	private JTextField getTFIndicador() {
		if (tFIndicador == null) {
			tFIndicador = new JTextField();
			tFIndicador.setToolTipText("Indicador");
			tFIndicador.setBounds(77, 59, 244, 20);
			tFIndicador.setColumns(10);
		}
		return tFIndicador;
	}

	/**
	 * Método que inicializa el botón de añadir elementos a la lista de
	 * indicadores.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtAñadir() {
		if (btAñadir == null) {
			btAñadir = new JButton();
			btAñadir.setMnemonic(KeyEvent.VK_A);
			btAñadir.setToolTipText("A\u00F1adir a la lista");
			btAñadir.setBounds(new Rectangle(243, 90, 78, 20));
			btAñadir.setText("A\u00F1adir");
			btAñadir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					modeloLista.addElement(tFIndicador.getText());
					tFIndicador.setText("");
					cont++;
					btEliminar.setEnabled(true);
				}
			});
		}
		return btAñadir;
	}

	/**
	 * Método que inicializa el botón de eliminar elementos de la lista de
	 * indicadores.
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
			btEliminar.setBounds(new Rectangle(99, 302, 71, 20));
			btEliminar.setText("Eliminar");
			btEliminar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					modeloLista.removeElement(listaIndi.getSelectedValue());
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
			btnCancelar.setBounds(180, 302, 78, 20);
		}
		return btnCancelar;
	}

	/**
	 * Método que inicializa el botón de aceptar, almacena la lista de
	 * indicadores.
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
					p.setListaIndi(lista);
					dispose();
				}
			});
			btnAceptar.setText("Aceptar");
			btnAceptar.setBounds(new Rectangle(166, 375, 78, 20));
			btnAceptar.setBounds(268, 302, 78, 20);
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
			btnAyuda.setLocation(20, 298);
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
			hb.enableHelpOnButton(btnAyuda, "indicadores", hs);
			// Desplega ayuda pulsando sobre F1
			hb.enableHelpKey(this.getContentPane(), "indicadores", hs);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,
					"Fichero de Ayuda no encontrado " + e.getMessage(),
					"Ayuda", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
