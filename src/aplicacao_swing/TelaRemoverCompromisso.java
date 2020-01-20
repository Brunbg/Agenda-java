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
import javax.swing.ScrollPaneConstants;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.CardLayout;
import javax.swing.JSplitPane;
import java.awt.Panel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.ScrollPane;
import java.awt.Font;

public class TelaRemoverCompromisso extends JFrame {
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
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextArea textArea;
	private JButton btnRemover;
	private JButton btnBuscar;
	private JLabel compromissobsc;
	private JLabel lblId;
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

	public TelaRemoverCompromisso() {
			setResizable(false);
			setTitle("Remover");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 550, 478);
			getContentPane().setLayout(null);
			
			textField_8 = new JTextField();
			textField_8.setBounds(136, 265, 128, 20);
			getContentPane().add(textField_8);
			textField_8.setColumns(10);
			
			lblId = new JLabel("ID");
			lblId.setBounds(116, 268, 33, 14);
			getContentPane().add(lblId);
			
			compromissobsc = new JLabel("");
			compromissobsc.setFont(new Font("Source Code Pro Semibold", Font.ITALIC, 13));
			compromissobsc.setBounds(116, 222, 231, 32);
			getContentPane().add(compromissobsc);
			
			
			btnRemover = new JButton("Remover");
			btnRemover.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String icompromisso= textField_8.getText();
					System.out.println(icompromisso);
					int idcompromisso= Integer.parseInt(icompromisso);
					try {
						Fachada.removerCompromisso(idcompromisso);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					compromissobsc.setText("");
				}
			});
			btnRemover.setBounds(160, 296, 89, 23);
			getContentPane().add(btnRemover);
			
			btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String icompromisso= textField_8.getText();
					int idcompromisso= Integer.parseInt(icompromisso);
					Compromisso c=null;
					try {
						c = Fachada.CompromissoPorId(idcompromisso);
						compromissobsc.setText("Titulo: "+c.get_titulo()+", Tipo: "+c.get_tipo());
					} catch (Exception erro) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null,erro.getMessage());
					}
					if(c!=null){
					compromissobsc.setText("Titulo: "+c.get_titulo()+", Tipo: "+c.get_tipo());}
				}
			});
			btnBuscar.setBounds(274, 264, 73, 23);
			getContentPane().add(btnBuscar);
			
			compromissobsc = new JLabel("");
			compromissobsc.setFont(new Font("Source Code Pro Semibold", Font.ITALIC, 13));
			compromissobsc.setBounds(116, 222, 231, 32);
			getContentPane().add(compromissobsc);
			
			
	
	}
	}




