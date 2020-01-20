package aplicacao_swing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import javax.swing.JFormattedTextField;

public class TelaCadastroContato extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNome;
	private JLabel lblEmail;
	private JLabel lblCep;
	private JLabel lblNumero;
	private JLabel lblLink;
	private JLabel lblGrau;
	private JLabel lblDia;
	private JLabel lblMes;
	private JButton btnCriar;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JLabel lblMsg;

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
	public TelaCadastroContato() {
		setTitle("Cadastrar Contato");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 239, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(72, 11, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		lblNome = new JLabel("nome");
		lblNome.setBounds(10, 14, 62, 14);
		contentPane.add(lblNome);
		
		textField_1 = new JTextField();
		textField_1.setBounds(72, 40, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lblEmail = new JLabel("email");
		lblEmail.setBounds(10, 43, 46, 14);
		contentPane.add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setBounds(72, 71, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		lblCep = new JLabel("Cep");
		lblCep.setBounds(10, 74, 46, 14);
		contentPane.add(lblCep);
		
		textField_3 = new JTextField();
		textField_3.setBounds(72, 103, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		lblNumero = new JLabel("Numero");
		lblNumero.setBounds(10, 106, 46, 14);
		contentPane.add(lblNumero);
		
		textField_4 = new JTextField();
		textField_4.setBounds(72, 138, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		lblLink = new JLabel("Link");
		lblLink.setBounds(10, 141, 46, 14);
		contentPane.add(lblLink);
		
		textField_5 = new JTextField();
		textField_5.setBounds(72, 169, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		lblGrau = new JLabel("grau");
		lblGrau.setBounds(10, 172, 46, 14);
		contentPane.add(lblGrau);
		
		textField_6 = new JTextField();
		textField_6.setBounds(72, 200, 86, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		lblDia = new JLabel("Dia");
		lblDia.setBounds(10, 203, 46, 14);
		contentPane.add(lblDia);
		
		textField_7 = new JTextField();
		textField_7.setBounds(72, 231, 86, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		lblMes = new JLabel("Mes");
		lblMes.setBounds(10, 234, 46, 14);
		contentPane.add(lblMes);
		
		lblMsg = new JLabel("");
		lblMsg.setBounds(20, 267, 185, 14);
		contentPane.add(lblMsg);

		btnCriar = new JButton("Cadastrar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String nome = textField.getText();
					String email = textField_1.getText();
					String cep = textField_2.getText();
					String numero = textField_3.getText();
					String link = textField_4.getText();
					int grau = Integer.parseInt(textField_5.getText());
					int dia = Integer.parseInt(textField_6.getText());
					int mes = Integer.parseInt(textField_7.getText());
					
					Fachada.cadastrarContato(nome,email,cep,numero,link,grau,dia,mes);
					
					lblMsg.setText("cadastrado ");
					textField.setText("");
					textField.requestFocus();
					textField_1.setText("");
					textField_1.requestFocus();
					textField_2.setText("");
					textField_2.requestFocus();
					textField_3.setText("");
					textField_3.requestFocus();
					textField_4.setText("");
					textField_4.requestFocus();
					textField_5.setText("");
					textField_5.requestFocus();
					textField_6.setText("");
					textField_6.requestFocus();
					textField_7.setText("");
					textField_7.requestFocus();
				}
				catch(Exception erro){
					lblMsg.setText(erro.getMessage());

				}
			}
		});
		btnCriar.setBounds(64, 292, 115, 23);
		contentPane.add(btnCriar);
		
	}
}
