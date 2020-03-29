package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JPasswordField;

public class Login_vista {

	private JFrame frmControlDeUsuarios;
	private JTextField text_usuario;
	private JPasswordField text_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_vista window = new Login_vista();
					window.frmControlDeUsuarios.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login_vista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmControlDeUsuarios = new JFrame();
		frmControlDeUsuarios.setTitle("Control de usuarios");
		frmControlDeUsuarios.setResizable(false);
		frmControlDeUsuarios.setBounds(100, 100, 450, 269);
		frmControlDeUsuarios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmControlDeUsuarios.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Acceder");
		btnNewButton.setBounds(170, 195, 89, 28);
		frmControlDeUsuarios.getContentPane().add(btnNewButton);
		
		JLabel lb_pass = new JLabel("CONTRASE\u00D1A");
		lb_pass.setBounds(85, 130, 75, 14);
		frmControlDeUsuarios.getContentPane().add(lb_pass);
		
		JLabel lb_user = new JLabel("USUARIO");
		lb_user.setBounds(104, 98, 46, 14);
		frmControlDeUsuarios.getContentPane().add(lb_user);
		
		text_usuario = new JTextField();
		lb_user.setLabelFor(text_usuario);
		text_usuario.setColumns(10);
		text_usuario.setBounds(160, 95, 125, 20);
		frmControlDeUsuarios.getContentPane().add(text_usuario);
		
		JLabel lb_Bienvenido = new JLabel("Bienvenido a RCP");
		lb_Bienvenido.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lb_Bienvenido.setBounds(104, 21, 234, 48);
		frmControlDeUsuarios.getContentPane().add(lb_Bienvenido);
		
		text_password = new JPasswordField();
		lb_pass.setLabelFor(text_password);
		text_password.setBounds(160, 127, 125, 20);
		frmControlDeUsuarios.getContentPane().add(text_password);
	}
}
