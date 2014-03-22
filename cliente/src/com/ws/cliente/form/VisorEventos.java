package com.ws.cliente.form;

import java.awt.*;

import java.net.*;

import javax.help.*;

import javax.swing.*;
import javax.swing.event.TreeSelectionListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTree;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ToolTipManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.ImageIcon;
import java.awt.Component;

import com.ws.cliente.Cliente;
import java.awt.event.KeyEvent;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.io.File;
import java.io.IOException;

/**
 * Clase que define la pantalla para el visor de eventos de registros.
 */
public class VisorEventos extends JFrame implements TreeSelectionListener {
	private Cliente c;
	private String treeReg = "";
	private boolean primera = true;
	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 9102243477836854963L;

	private JPanel jContentPane = null;
	private JPanel panelDatos = null;
	private JButton btCancelar = null;
	private JButton btAyuda = null;
	private JScrollPane treeView = null;
	private JTextField tFCodContra = null;
	private JButton btnAplicarEspe = null;
	private JTextArea tADescripcion = null;
	private JComboBox cBTipoReg = null;
	private JRadioButton rdbtnAscd = null;
	private JRadioButton rdbtnDesc = null;
	private JTree tree;
	private DefaultMutableTreeNode top;
	private static boolean DEBUG = false;
	private JPanel panelEstado;
	private JTextField tFEstado;
	private JLabel lblFecha;
	private JPanel panelGene;
	private JLabel lblCdGeneral;
	private JTextField tFCodGeneral;
	private JButton btnAplicarGen;
	private JLabel lBCodGenerales;
	private JRadioButton rBAscd;
	private JRadioButton rBDesc;
	private JScrollPane scrollPaneListaEnlace = null;
	private JButton btnAbrirDocumento = null;
	private DefaultListModel modeloEnlace = null;
	private JList listaEnlaces = null;

	/**
	 * Método que se requiere para hacer funcionar el despliegue de los nodos
	 * del JTree.
	 */
	public void valueChanged(TreeSelectionEvent e) {
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree
				.getLastSelectedPathComponent();

		if (node == null || node.toString().indexOf("RH-") >= 0)
			return;

		Object nodeInfo = node.getUserObject();
		if (node.isLeaf()) {
			Info reg = (Info) nodeInfo;
			modeloEnlace.removeAllElements();
			display(reg.registroInfo);
			if (DEBUG) {
				// PANTALLA DE ERROR
				tFEstado.setText(reg.registroInfo + ":  \n    ");
			}
		} else {
			// INICIAL
			display("      Sistema de Registro de Eventos de Procesos Empresariales\n\n\t\t\t   Visor de Eventos\n\n\t\t        Pablo González Jiménez\n\n\t\t         Universidad de Oviedo");
		}
		if (DEBUG) {
			System.out.println(nodeInfo.toString());
		}
	}

	/**
	 * Constructor por defecto.
	 * 
	 * @param c
	 *            Objeto de tipo cliente.
	 */
	public VisorEventos(Cliente c) {

		super();
		this.c = c;
		setResizable(false);
		setIconImage(Toolkit
				.getDefaultToolkit()
				.getImage(
						"img\\iconos\\Pantalla\\Visor.png"));
		initialize();
	}

	/**
	 * Método para inicializar el marco principal.
	 */
	private void initialize() {
		this.setSize(830, 531);
		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Visor de Eventos");
		top = new DefaultMutableTreeNode("Trazabilidad de Procedimientos");
		setAyuda();
		this.Tree(top, 0, "");
	}

	/**
	 * Método que inicializa el panel principal donde se cargan los elementos.
	 * 
	 * @return javax.swing.JPanel.
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getBtCancelar(), null);
			jContentPane.add(getBtAyuda(), null);

			JScrollPane scrollPaneDescripcion = new JScrollPane();
			scrollPaneDescripcion.setBounds(11, 222, 555, 239);
			jContentPane.add(scrollPaneDescripcion);

			scrollPaneDescripcion.setViewportView(getTADescripcion());
			jContentPane.add(getPanelDatos());

			JScrollPane scrollPaneFiltro = new JScrollPane();
			scrollPaneFiltro.setBounds(301, 11, 513, 192);
			jContentPane.add(scrollPaneFiltro);
			scrollPaneFiltro.setBorder(new TitledBorder(null, "Filtro",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));

			JPanel panelFiltro = new JPanel();
			scrollPaneFiltro.setViewportView(panelFiltro);
			panelFiltro.setBorder(null);
			panelFiltro.setLayout(null);

			panelFiltro.add(getCBTipoReg(), null);

			JPanel panelEspe = new JPanel();
			panelEspe.setBorder(new TitledBorder(null, "Espec\u00EDfico",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelEspe.setBounds(341, 11, 150, 144);
			panelFiltro.add(panelEspe);
			panelEspe.setLayout(null);

			JLabel lblCodContra = new JLabel("Contrataci\u00F3n:");
			lblCodContra.setBounds(10, 21, 67, 14);
			panelEspe.add(lblCodContra);
			panelEspe.add(getTFCodContra());
			panelEspe.add(getBtnAplicarEspe());
			panelEspe.add(getLblFecha());

			jContentPane.add(getPanelEstado());

			panelEspe.add(getRdbtnAscd(), null);
			panelEspe.add(getRdbtnDesc(), null);
			panelFiltro.add(getPanelGene());

			// Agrupar Radiobutton
			ButtonGroup groupoG = new ButtonGroup();
			groupoG.add(rdbtnAscd);
			groupoG.add(rdbtnDesc);

			jContentPane.add(getBtnAbrirDocumento(), null);
			jContentPane.add(getScrollPaneListaEnlace(), null);
		}
		return jContentPane;
	}

	/**
	 * Método que inicializa el botón de salir del visor.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton();
			btCancelar.setMnemonic(KeyEvent.VK_S);
			btCancelar.setToolTipText("Salir del visor");
			btCancelar.setBounds(new Rectangle(738, 438, 65, 23));
			btCancelar.setText("Salir");
			btCancelar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					VisorEventos.this.dispose();
				}
			});
		}
		return btCancelar;
	}

	/**
	 * Método que inicializa el botón de la ayuda.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtAyuda() {
		if (btAyuda == null) {
			btAyuda = new JButton();
			btAyuda.setLocation(585, 437);
			btAyuda.setIcon(new ImageIcon(
					"img\\iconos\\Info.png"));
			btAyuda.setSize(new java.awt.Dimension(24, 24));
			// NO DEJAR MARGENES ENTRE LOS BOTONES
			btAyuda.setMargin(new java.awt.Insets(0, 0, 0, 0));
			btAyuda.setMaximumSize(new java.awt.Dimension(30, 30));
			btAyuda.setMinimumSize(new java.awt.Dimension(30, 30));
			// DESPINTAR EL BORDE
			btAyuda.setBorderPainted(false);
			btAyuda.setContentAreaFilled(false);
			btAyuda.setToolTipText("Ayuda");
		}
		return btAyuda;
	}

	/**
	 * Método que inicializa el TextArea para la información de los nodos.
	 * 
	 * @return javax.swing.JTextArea.
	 */
	private JTextArea getTADescripcion() {
		if (tADescripcion == null) {
			tADescripcion = new JTextArea();
			tADescripcion.setEditable(false);
			tADescripcion.setToolTipText("Informaci\u00F3n de los nodos");
			tADescripcion.setLineWrap(true);
			tADescripcion.setWrapStyleWord(true);
		}
		return tADescripcion;
	}

	/**
	 * Método que inicializa el panel de carga de datos.
	 * 
	 * @return javax.swing.JPanel.
	 */
	private JPanel getPanelDatos() {
		if (panelDatos == null) {
			panelDatos = new JPanel();
			panelDatos.setBounds(11, 11, 280, 192);
			panelDatos.setLayout(null);
			panelDatos.add(getDatosServidor(), null);
		}
		return panelDatos;
	}

	/**
	 * Método que inicializa el panel de scroll del JTree del panel de datos.
	 * 
	 * @return javax.swing.JScrollPane.
	 */
	private JScrollPane getDatosServidor() {
		if (treeView == null) {
			treeView = new JScrollPane();
			treeView.setBounds(new Rectangle(-1, 0, 281, 192));
		}
		return treeView;
	}

	/**
	 * Método que inicializa el JTextField para el cód. contratación del filtro.
	 * 
	 * @return javax.swing.JTextField.
	 */
	private JTextField getTFCodContra() {
		if (tFCodContra == null) {
			tFCodContra = new JTextField();
			tFCodContra.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					rdbtnAscd.setSelected(false);
					rdbtnDesc.setSelected(false);
					btnAplicarEspe.setEnabled(true);
				}
			});
			tFCodContra.setEnabled(false);
			tFCodContra.setBounds(80, 18, 60, 20);
			tFCodContra.setToolTipText("C\u00F3d. Contrataci\u00F3n");
		}
		return tFCodContra;
	}

	/**
	 * Método que inicializa el botón para aplicar el filtro a los registros
	 * específicos.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtnAplicarEspe() {
		if (btnAplicarEspe == null) {
			btnAplicarEspe = new JButton();
			btnAplicarEspe.setMnemonic(KeyEvent.VK_A);
			btnAplicarEspe.setEnabled(false);
			btnAplicarEspe.setToolTipText("Aplicar filtros");
			btnAplicarEspe.setBounds(73, 116, 67, 20);
			btnAplicarEspe.setText("Aplicar");
			btnAplicarEspe
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							if (tFCodContra.getText().compareTo("") != 0) {
								filtro(2, tFCodContra.getText());
							} else if (rdbtnAscd.isSelected()) {
								filtro(2, "ascd");
							} else if (rdbtnDesc.isSelected()) {
								filtro(2, "desc");
							} else {
								JOptionPane.showMessageDialog(null,
										"Contratación ERRONEO",
										"Error Filtro Específico",
										JOptionPane.ERROR_MESSAGE);
							}
						}
					});
		}
		return btnAplicarEspe;
	}

	/**
	 * Método que inicializa la etiqueta para el filtro de la fecha.
	 * 
	 * @return javax.swing.JLabel.
	 */
	private JLabel getLblFecha() {
		if (lblFecha == null) {
			lblFecha = new JLabel("Fecha");
			lblFecha.setBounds(56, 46, 37, 14);
		}
		return lblFecha;
	}

	/**
	 * Método que inicializa el panel para los mensajes de estado.
	 * 
	 * @return javax.swing.JPanel.
	 */
	private JPanel getPanelEstado() {
		if (panelEstado == null) {
			panelEstado = new JPanel();
			panelEstado.setBounds(0, 486, 824, 20);
			GridLayout gl_panelEstado = new GridLayout();
			gl_panelEstado.setColumns(4);
			gl_panelEstado.setRows(1);
			panelEstado.setLayout(gl_panelEstado);
			panelEstado.add(getEstado());
		}
		return panelEstado;
	}

	/**
	 * Método que inicializa el JTextField para los mensajes de estado.
	 * 
	 * @return javax.swing.JTextField.
	 */
	public JTextField getEstado() {
		if (tFEstado == null) {
			tFEstado = new JTextField();
			tFEstado.setToolTipText("Mensaje de estado");
			tFEstado.setForeground(Color.RED);
			tFEstado.setFont(new Font("Tahoma", Font.BOLD, 11));
			tFEstado.setEditable(false);
			tFEstado.setColumns(10);
			tFEstado.setBackground(SystemColor.activeCaptionBorder);
		}
		return tFEstado;
	}

	/**
	 * Setter de estado.
	 * 
	 * @param tFEstado
	 *            JTextField del estado.
	 */
	public void setEstado(JTextField tFEstado) {
		this.tFEstado = tFEstado;
	}

	/**
	 * Método que inicializa los RadioButton para el filtro de registros
	 * específicos ascendentes.
	 * 
	 * @return javax.swing.JRadioButton.
	 */
	private JRadioButton getRdbtnAscd() {
		if (rdbtnAscd == null) {
			rdbtnAscd = new JRadioButton("Ascendente");
			rdbtnAscd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					getTFCodContra().setText("");
					getTFCodContra().setEnabled(false);
					btnAplicarEspe.setEnabled(true);
				}
			});
			rdbtnAscd.setEnabled(false);
			rdbtnAscd.setBounds(6, 67, 83, 23);
		}
		return rdbtnAscd;
	}

	/**
	 * Método que inicializa los RadioButton para el filtro de registros
	 * específicos descendentes.
	 * 
	 * @return javax.swing.JRadioButton.
	 */
	private JRadioButton getRdbtnDesc() {
		if (rdbtnDesc == null) {
			rdbtnDesc = new JRadioButton("Descendente");
			rdbtnDesc.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getTFCodContra().setText("");
					getTFCodContra().setEnabled(false);
					btnAplicarEspe.setEnabled(true);
				}
			});
			rdbtnDesc.setEnabled(false);
			rdbtnDesc.setBounds(6, 93, 96, 23);
		}
		return rdbtnDesc;
	}

	/**
	 * Método que inicializa el panel para el filtro de registros generales.
	 * 
	 * @return javax.swing.JPanel.
	 */
	private JPanel getPanelGene() {
		if (panelGene == null) {
			panelGene = new JPanel();
			panelGene.setBorder(new TitledBorder(null, "General",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelGene.setLayout(null);
			panelGene.setBounds(169, 11, 150, 144);
			panelGene.add(getLblCdGeneral());
			panelGene.add(getTFCodGeneral());
			panelGene.add(getBtnAplicarGen());
			panelGene.add(getLBCodGenerales());

			panelGene.add(getRBAscd());
			panelGene.add(getRBDesc());

			// Agrupar Radiobutton
			ButtonGroup groupoG = new ButtonGroup();
			groupoG.add(rBAscd);
			groupoG.add(rBDesc);
		}
		return panelGene;
	}

	/**
	 * Método que inicializa la etiqueta para el cód. general del filtro.
	 * 
	 * @return javax.swing.JLabel.
	 */
	private JLabel getLblCdGeneral() {
		if (lblCdGeneral == null) {
			lblCdGeneral = new JLabel("C\u00F3d General: ");
			lblCdGeneral.setBounds(10, 21, 67, 14);
		}
		return lblCdGeneral;
	}

	/**
	 * Método que inicializa el TextField para el cód. general del filtro.
	 * 
	 * @return javax.swing.JLabel.
	 */
	private JTextField getTFCodGeneral() {
		if (tFCodGeneral == null) {
			tFCodGeneral = new JTextField();
			tFCodGeneral.setEnabled(false);
			tFCodGeneral.setDocument(new LimitadorCaracteres(tFCodGeneral, 8));
			tFCodGeneral.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					rBAscd.setSelected(false);
					rBDesc.setSelected(false);
					btnAplicarGen.setEnabled(true);
				}
			});
			tFCodGeneral.setToolTipText("Cód. General");
			tFCodGeneral.setBounds(80, 18, 60, 20);
		}
		return tFCodGeneral;
	}

	/**
	 * Método que inicializa el botón para aplicar el filtro a los registros
	 * generales.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtnAplicarGen() {
		if (btnAplicarGen == null) {
			btnAplicarGen = new JButton();
			btnAplicarGen.setMnemonic(KeyEvent.VK_A);
			btnAplicarGen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (tFCodGeneral.getText().compareTo("") != 0
							&& tFCodGeneral.getText().indexOf("RH-") >= 0) {
						filtro(1, tFCodGeneral.getText());
					} else if (rBAscd.isSelected()) {
						filtro(1, "ascd");
					} else if (rBDesc.isSelected()) {
						filtro(1, "desc");
					} else {
						JOptionPane.showMessageDialog(null,
								"El código debe ser del tipo 'RH-2-r00'",
								"Error Filtro General",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			btnAplicarGen.setEnabled(false);
			btnAplicarGen.setToolTipText("Aplicar filtros");
			btnAplicarGen.setText("Aplicar");
			btnAplicarGen.setBounds(73, 116, 67, 20);
		}
		return btnAplicarGen;
	}

	/**
	 * Método que inicializa la etiqueta para los cód. generales.
	 * 
	 * @return javax.swing.JLabel.
	 */
	private JLabel getLBCodGenerales() {
		if (lBCodGenerales == null) {
			lBCodGenerales = new JLabel("C\u00F3d. Generales");
			lBCodGenerales.setBounds(33, 46, 83, 14);
		}
		return lBCodGenerales;
	}

	/**
	 * Método que inicializa los RadioButton para los registros generales
	 * ascendentes.
	 * 
	 * @return javax.swing.JRadioButton.
	 */
	private JRadioButton getRBAscd() {
		if (rBAscd == null) {
			rBAscd = new JRadioButton("Ascendente");
			rBAscd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getTFCodGeneral().setText("");
					getTFCodGeneral().setEnabled(false);
					btnAplicarGen.setEnabled(true);
				}
			});
			rBAscd.setEnabled(false);
			rBAscd.setBounds(6, 67, 83, 23);
		}
		return rBAscd;
	}

	/**
	 * Método que inicializa los RadioButton para los registros generales
	 * descendentes.
	 * 
	 * @return javax.swing.JRadioButton.
	 */
	private JRadioButton getRBDesc() {
		if (rBDesc == null) {
			rBDesc = new JRadioButton("Descendente");
			rBDesc.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getTFCodGeneral().setText("");
					getTFCodGeneral().setEnabled(false);
					btnAplicarGen.setEnabled(true);
				}
			});
			rBDesc.setEnabled(false);
			rBDesc.setBounds(6, 93, 96, 23);
		}
		return rBDesc;
	}

	/**
	 * Método que inicializa el botón de abrir documentos de los registros.
	 * 
	 * @return javax.swing.JButton.
	 */
	private JButton getBtnAbrirDocumento() {
		if (btnAbrirDocumento == null) {
			btnAbrirDocumento = new JButton("Abrir Documento");
			btnAbrirDocumento.setEnabled(false);
			btnAbrirDocumento.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (listaEnlaces.getSelectedValue() != null
							&& listaEnlaces.getSelectedValue().toString()
									.compareTo("") != 0) {
						try {
							// FUNCIÓN PARA ABRIR CUALQUIER ARCHIVO EN WINDOWS
							Runtime.getRuntime().exec(
									"rundll32 url.dll,FileProtocolHandler "
											+ listaEnlaces.getSelectedValue()
													.toString());
						} catch (IOException e) {
							tFEstado.setText(e.getMessage());
						}
					}
				}
			});
			btnAbrirDocumento.setMnemonic(KeyEvent.VK_D);
			btnAbrirDocumento.setToolTipText("Abrir documento");
			btnAbrirDocumento.setBounds(636, 382, 115, 23);
		}
		return btnAbrirDocumento;
	}

	/**
	 * Método que inicializa el panel de scroll para los enlaces de documentos
	 * de los registros.
	 * 
	 * @return javax.swing.JScrollPane.
	 */
	private JScrollPane getScrollPaneListaEnlace() {
		if (scrollPaneListaEnlace == null) {
			scrollPaneListaEnlace = new JScrollPane();
			scrollPaneListaEnlace.setBorder(new TitledBorder(null,
					"Enlace Documentos", TitledBorder.LEADING,
					TitledBorder.TOP, null, null));
			scrollPaneListaEnlace.setBounds(576, 276, 238, 95);
			scrollPaneListaEnlace.setViewportView(getListaEnlaces());
		}
		return scrollPaneListaEnlace;
	}

	/**
	 * Método que inicializa la lista de los enlaces de los registros.
	 * 
	 * @return javax.swing.JList.
	 */
	private JList getListaEnlaces() {
		modeloEnlace = new DefaultListModel();
		if (listaEnlaces == null) {
			listaEnlaces = new JList(modeloEnlace);
		}
		return listaEnlaces;
	}

	/**
	 * Método que inicializa el comboBox para los diferentes filtros para
	 * aplicar a los registros.
	 * 
	 * @return javax.swing.JScrollPane.
	 */
	private JComboBox getCBTipoReg() {
		if (cBTipoReg == null) {
			cBTipoReg = new JComboBox();
			cBTipoReg
					.setBackground(UIManager.getColor("ScrollPane.background"));
			cBTipoReg.setBorder(new TitledBorder(null, "Tipo de Filtro",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			cBTipoReg.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int tipo = cBTipoReg.getSelectedIndex();

					// Todos
					if (tipo == 0) {
						tFCodGeneral.setText("");
						tFCodGeneral.setEnabled(false);
						getRBAscd().setEnabled(false);
						getRBDesc().setEnabled(false);
						tFCodContra.setText("");
						tFCodContra.setEnabled(false);
						getRdbtnAscd().setEnabled(false);
						getRdbtnDesc().setEnabled(false);
						btnAplicarGen.setEnabled(false);
						btnAplicarEspe.setEnabled(false);
					}
					// Específico
					else if (tipo == 2) {
						tFCodGeneral.setText("");
						tFCodGeneral.setEnabled(false);
						getRBAscd().setEnabled(false);
						getRBDesc().setEnabled(false);
						tFCodContra.setEnabled(true);
						getRdbtnAscd().setEnabled(true);
						rdbtnAscd.setSelected(false);
						getRdbtnDesc().setEnabled(true);
						rdbtnDesc.setSelected(false);
						btnAplicarGen.setEnabled(false);
						// General
					} else if (tipo == 1) {
						tFCodContra.setText("");
						tFCodContra.setEnabled(false);
						getRdbtnAscd().setEnabled(false);
						getRdbtnDesc().setEnabled(false);
						tFCodGeneral.setEnabled(true);
						getRBAscd().setEnabled(true);
						rBAscd.setSelected(false);
						getRBDesc().setEnabled(true);
						rBAscd.setSelected(false);
						btnAplicarEspe.setEnabled(false);
					}
					filtro(tipo, "");
				}
			});
			cBTipoReg.setModel(new DefaultComboBoxModel(new String[] { "Todos",
					"General", "Espec\u00EDfico" }));
			cBTipoReg.setBounds(10, 11, 139, 44);
		}
		return cBTipoReg;
	}

	/**
	 * Método para almacenar el JTree con todos los registros en forma de nodos.
	 * 
	 * @param path
	 *            Objeto de tipo TreePath donde esta la ruta del JTree.
	 */
	private void getTree(TreePath path) {
		// siguiente nodo en la ruta
		Object lastNode = path.getLastPathComponent();
		for (int i = 0; i < tree.getModel().getChildCount(lastNode); i++) {
			Object child = tree.getModel().getChild(lastNode, i);

			if (child.toString().indexOf("RH") >= 0
					|| child.toString().indexOf("No hay") >= 0) {

			} else {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) child;
				Info nodeInfo = (Info) node.getUserObject();
				treeReg += nodeInfo.registroInfo + "·";
			}
			TreePath pathToChild = path.pathByAddingChild(child);
			getTree(pathToChild);
		}
	}

	/**
	 * Método para aplicar al JTree los diferentes filtros.
	 * 
	 * @param tipo
	 *            Entero para diferenciar el tipo de filtro.
	 * @param filtro
	 *            Cadena con el filtro a emplear al JTree
	 */
	private void filtro(int tipo, String filtro) {
		if (primera) {
			// Nodo root
			Object root = tree.getModel().getRoot();
			// Sera la ruta desde donde comenzar
			TreePath path = new TreePath(root);
			treeReg = "";
			getTree(path);
		}
		primera = false;
		switch (tipo) {
		case 1:
			top = new DefaultMutableTreeNode(
					"Trazabilidad Filtrado por Registros Generales");
			Tree(top, tipo, filtro);
			break;
		case 2:
			top = new DefaultMutableTreeNode(
					"Trazabilidad Filtrado por Registros Específicos");
			Tree(top, tipo, filtro);
			break;
		default:
			top = new DefaultMutableTreeNode("Trazabilidad de Procedimientos");
			Tree(top, tipo, filtro);
			break;
		}
	}

	/**
	 * Método para crear el JTree.
	 * 
	 * @param top
	 *            Objeto de tipo DefaultMutableTreeNode que lleva la cabeza del
	 *            árbol.
	 * @param tipo
	 *            Entero con el tipo de filtro.
	 * @param filtro
	 *            Cadena con el filtro a aplicar.
	 */
	public void Tree(DefaultMutableTreeNode top, int tipo, String filtro) {
		// Create the nodes.
		createNodes(top, tipo, filtro);

		// Create a tree that allows one selection at a time.
		tree = new JTree(top);
		tree.getSelectionModel().setSelectionMode(
				TreeSelectionModel.SINGLE_TREE_SELECTION);

		// Enable tool tips.
		ToolTipManager.sharedInstance().registerComponent(tree);

		// Set the icon for leaf nodes.
		ImageIcon r = new ImageIcon("img/iconos/Visor/Registro.png");
		ImageIcon l = new ImageIcon("img/iconos/Visor/Listas.png");
		ImageIcon e = new ImageIcon("img/iconos/Visor/Específico.png");
		ImageIcon i = new ImageIcon("img/iconos/Visor/Info.png");

		Object hijo0 = tree.getModel().getChild(top, 0);

		if (hijo0.toString().compareTo("No hay Registros") != 0 && r != null
				&& l != null && e != null && i != null) {
			tree.setCellRenderer(new MyRenderer(r, l, e, i));
		}

		// Listen for when the selection changes.
		tree.addTreeSelectionListener(this);

		// Create the scroll pane and add the tree to it.
		treeView.setViewportView(tree);

		// Descripcion general
		display("      Sistema de Registro de Eventos de Procesos Empresariales\n\n\t\t\t   Visor de Eventos\n\n\t\t        Pablo González Jiménez\n\n\t\t         Universidad de Oviedo");
	}

	/**
	 * Método para crear los nodos del JTree.
	 * 
	 * @param top
	 *            Objeto de tipo DefaultMutableTreeNode que lleva la cabeza del
	 *            árbol.
	 * @param tipo
	 *            Entero con el tipo de filtro.
	 * @param filtro
	 *            Cadena con el filtro a aplicar.
	 */
	private void createNodes(DefaultMutableTreeNode top, int tipo, String filtro) {

		DefaultMutableTreeNode proc = null;
		DefaultMutableTreeNode gene = null;
		DefaultMutableTreeNode regG = null;
		DefaultMutableTreeNode listaG = null;
		DefaultMutableTreeNode docuG = null;
		DefaultMutableTreeNode campG = null;
		DefaultMutableTreeNode indiG = null;
		DefaultMutableTreeNode genrG = null;
		DefaultMutableTreeNode autoG = null;

		DefaultMutableTreeNode espe = null;
		DefaultMutableTreeNode regE = null;
		DefaultMutableTreeNode listaE = null;
		DefaultMutableTreeNode docuE = null;
		DefaultMutableTreeNode genrE = null;
		DefaultMutableTreeNode autoE = null;

		String codGeneral = "";
		String[] general;
		String[] especifico;

		try {
			// nodo subpadre, si hubiera más de un procedimiento habría que descomentar, pero como es para el ejemplo
//			String[] procedimiento = c.getProcedimiento(this).split(",");
			String[] procedimiento = {"RH-2"};

			for (int i = 0; i < procedimiento.length; i++) {

				if (procedimiento[i].compareTo("") != 0) {

					proc = new DefaultMutableTreeNode(new Info(
							"- Procedimiento", procedimiento[i]));
					top.add(proc);

					if (tipo != 2) {
						// hijos de procedimiento
						int contg = 0;

						// CON FILTRO
						if (filtro.compareTo("") != 0) {
							FiltroGene(filtro, proc, procedimiento[i]);
						}
						// SIN FILTRO
						else {

							general = c.getAdmin(procedimiento[i], false)
									.split("·");
							int j = 0;

							if (general.length > 0
									&& general[j].toString().compareTo("") != 0) {
								do {
									gene = new DefaultMutableTreeNode(new Info(
											"\n\nGeneral", "- "
													+ procedimiento[i] + "-r0"
													+ contg));
									proc.add(gene);

									regG = new DefaultMutableTreeNode(new Info(
											general[j], "- General"));
									gene.add(regG);

									// HIJOS GENERAL 1
									listaG = new DefaultMutableTreeNode(
											new Info(
													"\nListas Registro General",
													"- Listas"));
									gene.add(listaG);

									// LISTA DOCUMENTO
									docuG = new DefaultMutableTreeNode(
											new Info(
													"\n- Enlace documento: "
															+ general[j + 2]
																	.toString()
															+ "\n- Descripcion: "
															+ general[j + 3]
																	.toString(),
													"- Documento"));
									listaG.add(docuG);

									// LA LISTA CAMPO
									campG = new DefaultMutableTreeNode(
											new Info(
													"\n- Campo: "
															+ general[j + 5]
																	.toString()
															+ "\n- Descripcion: "
															+ general[j + 6]
																	.toString()
															+ "\n- Tipo: "
															+ general[j + 7]
																	.toString()
															+ "\n- Unidad: "
															+ general[j + 8]
																	.toString()
															+ "\n- Enlace: "
															+ general[j + 9]
																	.toString(),
													"- Información Resumen"));
									listaG.add(campG);

									// LISTA INDICADOR
									indiG = new DefaultMutableTreeNode(
											new Info("\n- Indicadores: "
													+ general[j + 11]
															.toString(),
													"- Indicador"));
									listaG.add(indiG);

									// LISTA GENERADOR
									genrG = new DefaultMutableTreeNode(
											new Info("\n- Generadores: "
													+ general[j + 13]
															.toString(),
													"- Generador"));
									listaG.add(genrG);

									codGeneral = general[j + 14];

									// LISTA AUTORIZADO
									autoG = new DefaultMutableTreeNode(
											new Info("\n- Autorizados: "
													+ general[j + 15]
															.toString(),
													"- Autorizado"));
									listaG.add(autoG);

									if (tipo == 0) {
										// HIJOS GENERAL 2
										especifico = c
												.getEspecifico(codGeneral)
												.split("·");
										String codInterno = "";
										int k = 0;

										if (especifico.length > 0
												&& especifico[k].compareTo("") != 0) {
											do {
												codInterno = "";
												if (especifico[k]
														.toString()
														.indexOf(
																"\n  Cód. Interno: ") == 0) {
													for (int h = 16; h < 38; h++) {
														codInterno += especifico[k]
																.charAt(h);
													}
												}
												espe = new DefaultMutableTreeNode(
														new Info(
																"\n\nEspecífico",
																"- Específico "
																		+ codInterno));
												gene.add(espe);
												regE = new DefaultMutableTreeNode(
														new Info(especifico[k],
																"- Registro "));
												espe.add(regE);
												listaE = new DefaultMutableTreeNode(
														new Info(
																"Listas del registro Específico",
																"- Listas"));
												espe.add(listaE);
												docuE = new DefaultMutableTreeNode(
														new Info(
																"\n- Enlace Documento: "
																		+ especifico[++k]
																		+ "\n- Descripción: "
																		+ especifico[++k],
																"- Documento"));
												listaE.add(docuE);
												genrE = new DefaultMutableTreeNode(
														new Info(
																"\n- Generador: "
																		+ especifico[++k],
																"- Generador"));
												listaE.add(genrE);
												autoE = new DefaultMutableTreeNode(
														new Info(
																"\n- Autorizado: "
																		+ especifico[++k],
																"- Autorizado"));
												listaE.add(autoE);
												k++;

											} while (k < especifico.length);
										}// fin de if tipo == 0 o tipo == 2
									}
									j = j + 16;
									contg++;
								} while (j < general.length);
							}
						}
					}// fin tipo != 2 (todos menos especifico solo)

					// SOLO ESPECÍFICO
					if (tipo == 2) {
						Específico(filtro, proc);
					}

				}// fin del if procedimiento vacio
				else {
					proc = new DefaultMutableTreeNode("No hay Registros");
					top.add(proc);
					break;
				}
			}// fin del for proce

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Método para escribir la información de los registros en su pantalla
	 * correspondiente.
	 * 
	 * @param info
	 *            Cadena con la información a mostrar.
	 */
	private void display(String info) {
		if (info != null && info.compareTo("") != 0) {
			tADescripcion.setText(info);
			if (info.indexOf("- Enlace") > 0) {
				modeloEnlace.removeAllElements();
				String[] cadenas = info.split("\n");
				String[] rutas = cadenas[1].split(": ");
				if (rutas.length > 1) {
					if (rutas[1].compareTo(" ") != 0) {
						String[] path = rutas[1].split(";");
						for (int i = 0; i < path.length; i++) {
							modeloEnlace.addElement(path[i]);
							btnAbrirDocumento.setEnabled(true);
							tFEstado.setText("Cargados los enlaces");
						}
					}
				}
			}
		} else { // null ó ""
			tADescripcion.setText("ERROR Información Erronea");
			if (DEBUG) {
				tFEstado.setText("ERROR, al cargar información de los registros.");
			}
		}
	}

	/**
	 * Clase que define la información y el nombre del nodo.
	 */
	private class Info {
		public String registroNombre;
		public String registroInfo;

		/**
		 * Constructor por defecto.
		 * 
		 * @param registro
		 *            Cadena con el nombre del nodo.
		 * @param file
		 *            Cadena con la información del nodo.
		 */
		public Info(String registro, String file) {
			registroInfo = registro;
			registroNombre = file;
			if (file == null || file.compareTo("") == 0) {
				tFEstado.setText("ERROR, no se puede terner acceso a la información: "
						+ registroNombre);
			}
		}

		/**
		 * Método para mostrar el nombre del registro.
		 */
		public String toString() {
			return registroNombre;
		}
	}

	/**
	 * Método para crear el JTree de los registros específicos.
	 * 
	 * @param filtro
	 *            Cadena con el filtro a aplicar el registro específico.
	 * @param proc
	 *            Objeto de tipo DefaultMutableTreeNode con el primer nodo
	 *            padre.
	 */
	private void Específico(String filtro, DefaultMutableTreeNode proc) {

		DefaultMutableTreeNode espe;
		DefaultMutableTreeNode regE;
		DefaultMutableTreeNode listaE;
		DefaultMutableTreeNode docuE;
		DefaultMutableTreeNode genrE;
		DefaultMutableTreeNode autoE;

		// HIJOS PROC 1
		String[] registros = treeReg.split("·");
		String e = "";

		// FILTRO ASCENDENTE, DESCENDENTE, CONTRATACIÓN
		if (filtro.compareTo("") != 0) {
			FiltroEspe(filtro, proc, registros);
		}
		// SIN FILTRO
		else {

			for (int l = 0; l < registros.length; l++) {
				if (registros[l].toString().indexOf("\n  Cód. Interno") >= 0) {
					e += registros[l] + "·" + registros[++l] + "·"
							+ registros[++l] + "·" + registros[++l] + "·" + registros[++l] + "·";
				}
			}

			int k = 0;
			if (e.compareTo("") != 0) {
				String[] especifico = e.split("·");

				do {
					String[] codInterno = especifico[k].toString().split("\n");

					espe = new DefaultMutableTreeNode(new Info("Específico",
							"- Específico " + codInterno[2]));
					proc.add(espe);

					regE = new DefaultMutableTreeNode(new Info(especifico[k],
							"- Registro"));
					espe.add(regE);
					listaE = new DefaultMutableTreeNode(new Info(
							especifico[++k], "- Listas"));
					espe.add(listaE);
					docuE = new DefaultMutableTreeNode(new Info(
							especifico[++k], "- Documento"));
					listaE.add(docuE);
					genrE = new DefaultMutableTreeNode(new Info(
							especifico[++k], "- Generador"));
					listaE.add(genrE);
					autoE = new DefaultMutableTreeNode(new Info(
							especifico[++k], "- Autorizado"));
					listaE.add(autoE);
					k++;
				} while (k < especifico.length);
			} else {
				top.removeAllChildren();
				proc = new DefaultMutableTreeNode("No hay Registros");
				top.add(proc);
			}
		}
	}

	/**
	 * Método para crear el JTree con los registros específicos filtrados.
	 * 
	 * @param filtro
	 *            Cadena con el filtro a aplicar.
	 * @param proc
	 *            Objeto de tipo DefaultMutableTreeNode con el nodo padre.
	 * @param registros
	 *            Array de cadenas con todos los registros.
	 */
	private void FiltroEspe(String filtro, DefaultMutableTreeNode proc,
			String[] registros) {

		DefaultMutableTreeNode espe;
		DefaultMutableTreeNode regE;
		DefaultMutableTreeNode listaE;
		DefaultMutableTreeNode docuE;
		DefaultMutableTreeNode genrE;
		DefaultMutableTreeNode autoE;

		String[] ordenar = null;
		String e = "";

		// ASCENDENTE O DESCENDENTE
		if (filtro.compareTo("ascd") == 0 || filtro.compareTo("desc") == 0) {

			String fecha = "";

			for (int l = 0; l < registros.length; l++) {
				if (registros[l].toString().indexOf("\n  Cód. Interno") >= 0) {

					String[] campos = registros[l].toString().split("\n");

					for (int k = 0; k < 14; k++) {
						fecha += campos[2].toString().charAt(k);
					}

					e += fecha + "@" + registros[l] + "·" + registros[++l]
							+ "·" + registros[++l] + "·" + registros[++l] + "@";

					fecha = "";

				}
			}

			ordenar = e.split("@");
			String auxF = "";
			String auxR = "";
			int h = 1;
			boolean intercambios;

			// ASCENDENTE
			if (filtro.compareTo("ascd") == 0) {
				do {
					intercambios = false;
					for (int k = 2; k < ordenar.length - h; k = k + 2) {
						if (ordenar[k - 2].compareTo(ordenar[k]) > 0) {
							auxF = ordenar[k - 2];
							auxR = ordenar[k - 1];
							ordenar[k - 2] = ordenar[k];
							ordenar[k - 1] = ordenar[k + 1];
							ordenar[k] = auxF;
							ordenar[k + 1] = auxR;
							intercambios = true;
						}
					}
					h++;
				} while (intercambios && h <= ordenar.length - 1);

				// DESCENDENTE
			} else if (filtro.compareTo("desc") == 0) {
				do {
					intercambios = false;
					for (int k = 2; k < ordenar.length - h; k = k + 2) {
						if (ordenar[k - 2].compareTo(ordenar[k]) < 0) {
							auxF = ordenar[k - 2];
							auxR = ordenar[k - 1];
							ordenar[k - 2] = ordenar[k];
							ordenar[k - 1] = ordenar[k + 1];
							ordenar[k] = auxF;
							ordenar[k + 1] = auxR;
							intercambios = true;
						}
					}
					h++;
				} while (intercambios && h <= ordenar.length - 1);
			}
		}

		// FILTRO CONTRATACIÓN
		else {

			for (int l = 0; l < registros.length; l++) {
				if (registros[l].toString().indexOf("\n  Cód. Interno") >= 0) {

					String[] campos = registros[l].toString().split("\n");
					
					String[] contratacion = campos[6].toString().split(" ");
					
					if (contratacion[1].compareTo(filtro) == 0) {
						e += campos[6] + "@" + registros[l] + "·"
								+ registros[++l] + "·" + registros[++l] + "·"
								+ registros[++l] + "@";
					}
				}
			}
		}// Fin filtro contratación

		int t = 0;
		if (e.length() > 0) {
			if(ordenar == null){
				ordenar = e.split("@");
			}
			do {
				espe = new DefaultMutableTreeNode(new Info("Específico",
						"- Específico por " + ordenar[t]));
				proc.add(espe);

				int k = 0;
				String[] especifico = ordenar[++t].toString().split("·");

				regE = new DefaultMutableTreeNode(new Info(especifico[k],
						"- Registro"));
				espe.add(regE);
				listaE = new DefaultMutableTreeNode(new Info(
						"Listas Registro Específico", "- Listas"));
				espe.add(listaE);
				docuE = new DefaultMutableTreeNode(new Info(especifico[++k],
						"- Documento"));
				listaE.add(docuE);
				genrE = new DefaultMutableTreeNode(new Info(especifico[++k],
						"- Generador"));
				listaE.add(genrE);
				autoE = new DefaultMutableTreeNode(new Info(especifico[++k],
						"- Autorizado"));
				listaE.add(autoE);
				t++;
			} while (t < ordenar.length);
		}
	}

	/**
	 * Método para crear el JTree con los registros generales filtrados.
	 * 
	 * @param filtro
	 *            Cadena con el filtro a aplicar.
	 * @param proc
	 *            Objeto de tipo DefaultMutableTreeNode con el nodo padre.
	 * @param procedimiento
	 *            Cadena con el procedimiento.
	 */
	private void FiltroGene(String filtro, DefaultMutableTreeNode proc,
			String procedimiento) {

		DefaultMutableTreeNode gene;
		DefaultMutableTreeNode regG;
		DefaultMutableTreeNode listaG;
		DefaultMutableTreeNode docuG;
		DefaultMutableTreeNode campG;
		DefaultMutableTreeNode indiG;
		DefaultMutableTreeNode genrG;
		DefaultMutableTreeNode autoG;

		// HIJOS PROC 1
		String[] registros = treeReg.split("·");
		String g = "";
		String gU = "";

		for (int l = 0; l < registros.length; l++) {
			if (registros[l].toString().indexOf("\n\nRegistro General") >= 0) {

				String[] campo = registros[l].toString().split("\n");

				// REGISTRO FILTRO REGISTRO UNICO
				if (campo[6].compareTo(filtro) == 0) {
					gU += registros[l] + "·" + registros[++l] + "·"
							+ registros[++l] + "·" + registros[++l] + "·"
							+ registros[++l] + "·" + registros[++l] + "·"
							+ registros[++l] + "·";

					int k = 0;
					if (gU.compareTo("") != 0) {
						String[] general = gU.split("·");
						do {
							gene = new DefaultMutableTreeNode(new Info(
									"General", "- General " + filtro));
							proc.add(gene);

							regG = new DefaultMutableTreeNode(new Info(
									general[k], "- Registro"));
							gene.add(regG);
							k++;
							listaG = new DefaultMutableTreeNode(new Info(
									"Listas del registro General", "- Listas"));
							gene.add(listaG);

							docuG = new DefaultMutableTreeNode(new Info(
									general[++k], "- Documento"));
							listaG.add(docuG);

							campG = new DefaultMutableTreeNode(new Info(
									general[++k], "- Información Resúmen"));
							listaG.add(campG);

							indiG = new DefaultMutableTreeNode(new Info(
									general[++k], "- Indicador"));
							listaG.add(indiG);

							genrG = new DefaultMutableTreeNode(new Info(
									general[++k], "- Generador"));
							listaG.add(genrG);

							autoG = new DefaultMutableTreeNode(new Info(
									general[++k], "- Autorizado"));
							listaG.add(autoG);
							k++;
						} while (k < general.length);
						break;
					}

					// REGISTRO FILTRO ASCE Y DESC
				} else if (filtro.compareTo("ascd") == 0
						|| filtro.compareTo("desc") == 0) {
					g += campo[6] + "@" + registros[l] + "·" + registros[++l]
							+ "·" + registros[++l] + "·" + registros[++l] + "·"
							+ registros[++l] + "·" + registros[++l] + "·"
							+ registros[++l] + "@";
				}
			}
		}

		if (filtro.compareTo("ascd") == 0 || filtro.compareTo("desc") == 0) {

			String[] ordenar = g.split("@");
			String auxC = "";
			String auxR = "";
			int h = 1;
			boolean intercambios;

			// FILTRO ASCENDENTE
			if (filtro.compareTo("ascd") == 0) {
				do {
					intercambios = false;
					for (int k = 2; k < ordenar.length - h; k = k + 2) {
						if (ordenar[k - 2].compareTo(ordenar[k]) > 0) {
							auxC = ordenar[k - 2];
							auxR = ordenar[k - 1];
							ordenar[k - 2] = ordenar[k];
							ordenar[k - 1] = ordenar[k + 1];
							ordenar[k] = auxC;
							ordenar[k + 1] = auxR;
							intercambios = true;
						}
					}
					h++;
				} while (intercambios && h <= ordenar.length - 1);

				// FILTRO DESCENDENTE
			} else if (filtro.compareTo("desc") == 0) {

				do {
					intercambios = false;
					for (int k = 2; k < ordenar.length - h; k = k + 2) {
						if (ordenar[k - 2].compareTo(ordenar[k]) < 0) {
							auxC = ordenar[k - 2];
							auxR = ordenar[k - 1];
							ordenar[k - 2] = ordenar[k];
							ordenar[k - 1] = ordenar[k + 1];
							ordenar[k] = auxC;
							ordenar[k + 1] = auxR;
							intercambios = true;
						}
					}
					h++;
				} while (intercambios && h <= ordenar.length - 1);
			}

			int t = 0;
			if (ordenar.length > 0) {
				do {
					gene = new DefaultMutableTreeNode(new Info("General",
							"- General " + ordenar[t]));
					proc.add(gene);

					int k = 0;
					String[] general = ordenar[++t].toString().split("·");

					regG = new DefaultMutableTreeNode(new Info(general[k],
							"- Registro"));
					gene.add(regG);

					listaG = new DefaultMutableTreeNode(new Info(general[++k],
							"- Listas"));
					gene.add(listaG);

					docuG = new DefaultMutableTreeNode(new Info(general[++k],
							"- Documento"));
					listaG.add(docuG);

					campG = new DefaultMutableTreeNode(new Info(general[++k],
							"- Información Resúmen"));
					listaG.add(campG);

					indiG = new DefaultMutableTreeNode(new Info(general[++k],
							"- Indicador"));
					listaG.add(indiG);

					genrG = new DefaultMutableTreeNode(new Info(general[++k],
							"- Generador"));
					listaG.add(genrG);

					autoG = new DefaultMutableTreeNode(new Info(general[++k],
							"- Autorizado"));
					listaG.add(autoG);
					t++;
				} while (t < ordenar.length);
			}
		} // FIN FILTRO ASCE Y DESC
	}

	/**
	 * Método para cargar la ayuda de la aplicación.
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
			hb.enableHelpOnButton(btAyuda, "visor", hs);
			// Desplega ayuda pulsando sobre F1
			hb.enableHelpKey(this.getContentPane(), "visor", hs);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,
					"Fichero de Ayuda no encontrado " + e.getMessage(),
					"Ayuda", JOptionPane.INFORMATION_MESSAGE);
		}
	}

} // @jve:decl-index=0:visual-constraint="10,10"

/**
 * Clase MyRenderer hereda de DefaultTreeCellRenderer, y se utiliza para poner
 * los iconos y los tooltip en los nodos del JTree.
 */
class MyRenderer extends DefaultTreeCellRenderer {
	/**
	 * Serial.
	 */
	private static final long serialVersionUID = -8319609211278011024L;
	private Icon r;
	private Icon l;
	private Icon e;
	private Icon i;

	/**
	 * Constructor por defecto.
	 * 
	 * @param icon1
	 *            Objeto de tipo Icon con la imagen a aplicar.
	 * @param icon2
	 *            Objeto de tipo Icon con la imagen a aplicar.
	 * @param icon3
	 *            Objeto de tipo Icon con la imagen a aplicar.
	 * @param icon4
	 *            Objeto de tipo Icon con la imagen a aplicar.
	 */
	public MyRenderer(Icon icon1, Icon icon2, Icon icon3, Icon icon4) {
		this.r = icon1;
		this.l = icon2;
		this.e = icon3;
		this.i = icon4;
	}

	/**
	 * Método para poner los iconos y los tooltip a los nodos elegidos del
	 * JTree.
	 */
	public Component getTreeCellRendererComponent(JTree tree, Object value,
			boolean sel, boolean expanded, boolean leaf, int row,
			boolean hasFocus) {

		super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf,
				row, hasFocus);

		String val = value.toString();

		if (val.compareTo("RH-2") == 0) {
			setIcon(i);
			setToolTipText("Plan de acogida de Conductores");
		} else if (val.indexOf("- RH") >= 0) {
			setIcon(r);
			setToolTipText("Registros Generales");
		} else if (val.compareTo("- Listas") == 0
				|| val.indexOf("- Específico") >= 0) {
			if (val.toString().compareTo("- Listas") == 0) {
				setIcon(l);
				setToolTipText("Listas");
			} else if (val.indexOf("- Específico") >= 0) {
				setIcon(e);
				setToolTipText("Registros Específicos");
			}
		}
		return this;
	}
}

/**
 * Clase que hereda de PlainDocument para limitar la escritura de números.
 */
class LimitadorCaracteres extends PlainDocument {
	/**
	 * Serial.
	 */
	private static final long serialVersionUID = -9039095742861945172L;

	/**
	 * El editor del que estamos limitando caracteres.
	 */
	private JTextField editor;

	/**
	 * Número máximo de caracteres que deseamos en el editor.
	 */
	private int numeroMaximoCaracteres;

	/**
	 * Crea una instancia de LimitadorCaracteres.
	 * 
	 * @param editor
	 *            Editor en el que se quieren limitar los caracteres.
	 * @param numeroMaximoCaracteres
	 *            Número máximo de caracteres que queremos en el editor.
	 */
	public LimitadorCaracteres(JTextField editor, int numeroMaximoCaracteres) {
		this.editor = editor;
		this.numeroMaximoCaracteres = numeroMaximoCaracteres;
	}

	/**
	 * Método al que llama el editor cada vez que se intenta insertar
	 * caracteres. El método comprueba que no se sobrepasa el límite. Si es así,
	 * llama al método de la clase padre para que se inserten los caracteres. Si
	 * se sobrepasa el límite, retorna sin hacer nada.
	 */
	public void insertString(int arg0, String arg1, AttributeSet arg2)
			throws BadLocationException {
		if ((editor.getText().length() + arg1.length()) > this.numeroMaximoCaracteres)
			return;
		super.insertString(arg0, arg1, arg2);
	}

}