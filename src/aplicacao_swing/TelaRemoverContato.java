package aplicacao_swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import aplicacao_console.TesteConsole1;
import modelo.Compromisso;
import modelo.Contato;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.Panel;

public class TelaRemoverContato extends JFrame {
    
	private JPanel contentPane;
	private JTextField textField_8;
	private Panel panel;
	private JLabel nome;
	private JLabel lblfoto;
	private JLabel numero;
	private JLabel label;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaCadastroContato frame = new TelaCadastroContato();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */

public TelaRemoverContato() {
		setResizable(false);
		setTitle("Remover");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 478);
		getContentPane().setLayout(null);
		
		textField_8 = new JTextField();
		textField_8.setBounds(188, 314, 128, 20);
		getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblId = new JLabel(" Nome");
		lblId.setBounds(130, 317, 59, 14);
		getContentPane().add(lblId);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String escrito = textField_8.getText();
				try {
					Fachada.removerContato(escrito);
				} catch (Exception erro) {
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}
			}
		});
		btnRemover.setBounds(212, 345, 89, 23);
		getContentPane().add(btnRemover);
		
		panel = new Panel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(130, 10, 290, 298);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblfoto = new JLabel();
		lblfoto.setBounds(86, 28, 127, 125);
		panel.add(lblfoto);
		
		nome = new JLabel();
		nome.setBounds(10, 164, 105, 14);
		panel.add(nome);
		
		numero = new JLabel();
		numero.setBounds(10, 210, 105, 14);
		panel.add(numero);
		
		label = new JLabel();
		label.setBounds(10, 235, 270, 52);
		panel.add(label);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String escrito = textField_8.getText();
					Contato c = Fachada.ContatoPorNome(escrito);
					System.out.println(c.getNome());
					
					lblfoto = new JLabel("teste");
					
					
					nome.setText(c.getNome());
					
					
					numero.setText(c.getNumero());
					
					
					label.setText(c.getEndereco());
					
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}
			}
		});
		btnBuscar.setBounds(326, 313, 94, 23);
		getContentPane().add(btnBuscar);
		
		
		

}
	
}
	
	
