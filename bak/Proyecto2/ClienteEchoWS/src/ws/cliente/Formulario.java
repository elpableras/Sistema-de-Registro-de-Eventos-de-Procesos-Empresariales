package ws.cliente;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Rectangle;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.util.Date;

public class Formulario extends JFrame {

	/**
   * 
   */
	private static final long serialVersionUID = 7475686240841350326L;

	private JPanel jContentPane = null;
	private JPanel jPanel = null;

	private JTextField txtNombre = null;
	private JTextField txtCorreo = null;
	private JTextField txtEdad = null;
	private JTextField txtDocuemntoDNI = null;

	private JLabel jLabelNombre = null;
	private JLabel jLabelCorreo = null;
	private JLabel jLabelEdad = null;
	private JLabel jLabelDocumentoDNI = null;

	private JButton bRegistrar = null;
	private JButton bCancelar = null;
	
	/** Un Registro serializable */
    private Registro reg = null;

	/**
	 * This is the default constructor
	 */
	public Formulario() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(new Dimension(304, 121));
		this.setContentPane(getJContentPane());
		this.setSize(300, 200);
		this.setContentPane(getJContentPane());
		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		this.setTitle("Log de Registro");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJPanel(), BorderLayout.CENTER);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			// Nombre
			jLabelNombre = new JLabel();
			jLabelNombre.setBounds(new Rectangle(7, 15, 59, 16));
			jLabelNombre.setText("Nombre");

			// Correo
			jLabelCorreo = new JLabel();
			jLabelCorreo.setBounds(new Rectangle(7, 41, 59, 16));
			jLabelCorreo.setText("Correo");

			// Edad
			jLabelEdad = new JLabel();
			jLabelEdad.setBounds(new Rectangle(7, 67, 59, 16));
			jLabelEdad.setText("Edad");

			// Documento DNI
			jLabelDocumentoDNI = new JLabel();
			jLabelDocumentoDNI.setBounds(new Rectangle(7, 93, 59, 16));
			jLabelDocumentoDNI.setText("URL DNI");

			jPanel = new JPanel();
			jPanel.setLayout(null);

			// Añadir campos al panel
			jPanel.add(getTxtNombre(), null);
			jPanel.add(getTxtCorreo(), null);
			jPanel.add(getTxtEdad(), null);
			jPanel.add(getTxtDocumentoDNI(), null);

			// Añadir etiquetas al panel
			jPanel.add(jLabelNombre, null);
			jPanel.add(jLabelCorreo, null);
			jPanel.add(jLabelEdad, null);
			jPanel.add(jLabelDocumentoDNI, null);

			// Añadir botones
			jPanel.add(getbRegistrar(), null);
			jPanel.add(getbCancelar(), null);
		}
		return jPanel;
	}

	/**
	 * This method initializes txtMensaje
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtNombre() {
		if (txtNombre == null) {
			txtNombre = new JTextField();
			txtNombre.setBounds(new java.awt.Rectangle(68, 15, 133, 20));
		}
		return txtNombre;
	}

	/**
	 * This method initializes txtMensaje
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtCorreo() {
		if (txtCorreo == null) {
			txtCorreo = new JTextField();
			txtCorreo.setBounds(new java.awt.Rectangle(68, 40, 133, 20));
		}
		return txtCorreo;
	}

	/**
	 * This method initializes txtMensaje
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtEdad() {
		if (txtEdad == null) {
			txtEdad = new JTextField();
			txtEdad.setBounds(new java.awt.Rectangle(68, 65, 133, 20));
		}
		return txtEdad;
	}

	/**
	 * This method initializes txtMensaje
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtDocumentoDNI() {
		if (txtDocuemntoDNI == null) {
			txtDocuemntoDNI = new JTextField();
			txtDocuemntoDNI.setBounds(new java.awt.Rectangle(68, 90, 133, 20));
		}
		return txtDocuemntoDNI;
	}
	
	private JButton getbRegistrar(){
		if(bRegistrar == null){
			bRegistrar = new JButton();
			bRegistrar.setBounds(new java.awt.Rectangle(100, 125, 81, 21));
			bRegistrar.setActionCommand("Cancelar");
			bRegistrar.setText("Submit");
		}
		return bRegistrar;
	}
	
	private JButton getbCancelar(){
		if(bCancelar == null){
			bCancelar = new JButton();
			bCancelar.setBounds(new java.awt.Rectangle(190, 125, 91, 21));
			bCancelar.setActionCommand("Cancelar");
			bCancelar.setText("Cancelar");
			bCancelar.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					System.exit(0);
				}
			});
		}
		return bCancelar;
	}
	
	public  Registro getFormulario(){
		if(reg == null){
			
				//durmiendo el hilo
				return reg;
			
		}
		return reg;
	}
	
}
