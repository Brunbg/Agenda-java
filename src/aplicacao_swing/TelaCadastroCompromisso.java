package aplicacao_swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import aplicacao_console.TesteConsole1;
import modelo.Compromisso;
import modelo.Contato;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import java.awt.Color;
import java.awt.Font;

public class TelaCadastroCompromisso extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNome;
	private JLabel lblDia;
	private JLabel lblMes;
	private JLabel lblAno;
	private JLabel lblHora;
	private JLabel lblMinuto;
	private JLabel lblTipo;
	private JButton btnCriar;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel lblMsg;
	private JComboBox comboBox;
	private JTextField textField_6;
	private JToggleButton Equipeonoff;
	private JLabel Contatos;

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
	public TelaCadastroCompromisso() {
		setTitle("Cadastrar Compromisso");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 239, 452);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 102, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setForeground(new Color(255, 255, 255));
		textField.setBackground(new Color(204, 153, 153));
		textField.setBounds(77, 49, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		lblNome = new JLabel("titulo");
		lblNome.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setBounds(15, 52, 62, 14);
		contentPane.add(lblNome);
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(255, 255, 255));
		textField_1.setBackground(new Color(204, 153, 153));
		textField_1.setBounds(77, 78, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lblDia = new JLabel("dia");
		lblDia.setForeground(new Color(255, 255, 255));
		lblDia.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lblDia.setBounds(15, 81, 46, 14);
		contentPane.add(lblDia);
		
		textField_2 = new JTextField();
		textField_2.setForeground(new Color(255, 255, 255));
		textField_2.setBackground(new Color(204, 153, 153));
		textField_2.setBounds(77, 109, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		lblMes = new JLabel("mes");
		lblMes.setForeground(new Color(255, 255, 255));
		lblMes.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lblMes.setBounds(15, 112, 46, 14);
		contentPane.add(lblMes);
		
		textField_3 = new JTextField();
		textField_3.setForeground(new Color(255, 255, 255));
		textField_3.setBackground(new Color(204, 153, 153));
		textField_3.setBounds(77, 141, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		lblAno = new JLabel("ano");
		lblAno.setForeground(new Color(255, 255, 255));
		lblAno.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lblAno.setBounds(15, 144, 46, 14);
		contentPane.add(lblAno);
		
		textField_4 = new JTextField();
		textField_4.setForeground(new Color(255, 255, 255));
		textField_4.setBackground(new Color(204, 153, 153));
		textField_4.setBounds(77, 176, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		lblHora = new JLabel("hora");
		lblHora.setForeground(new Color(255, 255, 255));
		lblHora.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lblHora.setBounds(15, 179, 46, 14);
		contentPane.add(lblHora);
		
		textField_5 = new JTextField();
		textField_5.setForeground(new Color(255, 255, 255));
		textField_5.setBackground(new Color(204, 153, 153));
		textField_5.setBounds(77, 207, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		lblMinuto = new JLabel("minuto");
		lblMinuto.setForeground(new Color(255, 255, 255));
		lblMinuto.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lblMinuto.setBounds(15, 210, 46, 14);
		contentPane.add(lblMinuto);
		
		lblTipo = new JLabel("tipo");
		lblTipo.setForeground(new Color(255, 255, 255));
		lblTipo.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lblTipo.setBounds(135, 298, 32, 14);
		contentPane.add(lblTipo);
		
		lblMsg = new JLabel("");
		lblMsg.setBounds(25, 305, 185, 14);
		contentPane.add(lblMsg);
		
		
		comboBox = new JComboBox();
		comboBox.setForeground(new Color(255, 255, 255));
		comboBox.setBackground(new Color(204, 153, 153));
		comboBox.addItem("Lazer");
		comboBox.addItem("Trabalhos");
		comboBox.addItem("Tarefas");
		comboBox.setBounds(135, 313, 93, 20);
		comboBox.setSelectedItem(null);
		contentPane.add(comboBox);
		
		Contatos = new JLabel("Contatos");
		Contatos.setForeground(new Color(255, 255, 255));
		Contatos.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		Contatos.setBounds(15, 270, 82, 14);
		contentPane.add(Contatos);
		
		textField_6 = new JTextField();
		textField_6.setForeground(new Color(255, 255, 255));
		textField_6.setBackground(new Color(204, 153, 153));
		textField_6.setBounds(98, 267, 130, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		Contatos.setVisible(false);
		textField_6.setVisible(false);
		
		Equipeonoff = new JToggleButton("Equipe");
		Equipeonoff.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		Equipeonoff.setBackground(new Color(102, 51, 51));
		Equipeonoff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Equipeonoff.getSelectedObjects()!=null) {
					Contatos.setVisible(true);
					textField_6.setVisible(true);
				}
				else {
					Contatos.setVisible(false);
					textField_6.setVisible(false);
				}
			}
		});
		Equipeonoff.setForeground(new Color(255, 255, 255));
		Equipeonoff.setBounds(10, 236, 121, 23);
		contentPane.add(Equipeonoff);
		btnCriar = new JButton("Cadastrar");
		btnCriar.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		btnCriar.setForeground(new Color(255, 255, 255));
		btnCriar.setBackground(new Color(102, 51, 51));
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String titulo = textField.getText();
					int dia = Integer.parseInt(textField_1.getText());
					int mes = Integer.parseInt(textField_2.getText());
					int ano = Integer.parseInt(textField_3.getText());
					int hora = Integer.parseInt(textField_4.getText());
					int minuto = Integer.parseInt(textField_5.getText());
					String tipo  = (String) comboBox.getSelectedItem();
					String contato1 = textField_6.getText();
					if(Contatos.isVisible()) {
						ArrayList<String> arraycontato= QuebraString(contato1);
						Compromisso c=Fachada.cadastrarCompromissoGrupo(titulo, dia, mes, ano, hora, minuto, tipo, arraycontato);
						Fachada.notificarCompromissoGrupo(c.get_id(),"rosangela789");
					}
					else {
						Fachada.cadastrarCompromisso(titulo,dia,mes,ano,hora,minuto,tipo);
						
					}
					
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
					
					
				}
				catch(Exception erro){
					lblMsg.setText(erro.getMessage());

				}
			}
		});
		btnCriar.setBounds(77, 344, 115, 23);
		contentPane.add(btnCriar);
		
		JLabel lblCadastrarCompromisso = new JLabel("Cadastrar Compromisso");
		lblCadastrarCompromisso.setForeground(new Color(102, 51, 51));
		lblCadastrarCompromisso.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblCadastrarCompromisso.setBounds(15, 11, 213, 14);
		contentPane.add(lblCadastrarCompromisso);
		
	}
	public static ArrayList<String> QuebraString(String string) {
		string= string.replaceAll(" ,", ",");
		String[] arrays= string.split(",");
		ArrayList<String> arraystr=new ArrayList<String>();
		for(int i=0;i<arrays.length;i++) {
		arraystr.add(arrays[i]);}
		return arraystr;
	}

}
