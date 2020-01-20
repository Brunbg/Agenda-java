package aplicacao_swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;


import fachada.Fachada;
import modelo.Compromisso;
import modelo.Contato;
import modelo.Telefone;

public class TelaListagemComp extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
	private JButton button1;
	private JComboBox comboBox;
	private JTextField textField;
	private ArrayList<Compromisso> lista = new ArrayList<Compromisso>();
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaListagem frame = new TelaListagem();
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
	public TelaListagemComp() {
		
		setTitle("Listagem");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 242);		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(125, 181, 241, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.addItem("Tipo");
		comboBox.addItem("Data");
		comboBox.addItem("Titulo");
		comboBox.setBounds(24, 180, 91, 22);
		comboBox.setSelectedItem(null);
		contentPane.add(comboBox);
		
		textArea = new JTextArea();		
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(24, 29, 510, 140);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(scroll);
		
		

		button1 = new JButton("Listar compromissos");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String escrito = textField.getText();
					String value = (String) comboBox.getSelectedItem();
					System.out.println(escrito);
					System.out.println(value);
					if (value=="Tipo"){
						System.out.println("entrei");
						ArrayList<Compromisso> lista = Fachada.listarCompromissosPorTipo(escrito);
						System.out.println(Fachada.listarCompromissosPorTipo(escrito));
						String texto = "Listagem de contatos\n";
						if (lista.isEmpty())
							texto += "não tem contato cadastrada\n";
						else 
							for(Compromisso p: lista) 
								texto +=  p.get_titulo() + "\n"; 
						System.out.println(texto);

						textArea.setText(texto);
					}
					else if(value=="Data") {
						String[] data = escrito.split(" ");
						String[] data1=data[0].split("/");
						String[] data2=data[1].split("/");
						LocalDateTime pdata= LocalDateTime.parse(data1[2]+"-"+data1[1]+"-"+data1[0]+"T00:00:00");
						LocalDateTime sdata= LocalDateTime.parse(data2[2]+"-"+data2[1]+"-"+data2[0]+"T00:00:00");
						ArrayList<Compromisso> lista = Fachada.listarCompromissosPorDatas(pdata, sdata);
						String texto = "Listagem de contatos\n";
						if (lista.isEmpty())
							texto += "não tem contato cadastrada\n";
						else 
							for(Compromisso p: lista) 
								texto +=  p.get_titulo() + "\n"; 
						System.out.println(texto);

						textArea.setText(texto);
					}
					else if(value=="Titulo") {
						ArrayList<Compromisso> lista = Fachada.listarCompromissosPorTitulo(escrito);
						String texto = "Listagem de contatos\n";
						if (lista.isEmpty())
							texto += "não tem contato cadastrada\n";
						else 
							for(Compromisso p: lista) 
								texto +=  p + "\n";
						System.out.println(texto);

						textArea.setText(texto);
					}
					//ArrayList<Contato> lista = Fachada.listarContatos();
					
//					String texto = "Listagem de contatos\n";
//			
//					if (lista.isEmpty())
//						texto += "não tem contato cadastrada\n";
//					else 
//						for(Contato p: lista) 
//							texto +=  p + "\n"; 
//
//					textArea.setText(texto);
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}
			}
		});
		button1.setBounds(387, 180, 147, 23);
		contentPane.add(button1);
		
//		textArea = new JTextArea();		
//		JScrollPane scroll = new JScrollPane(textArea);
//		scroll.setBounds(24, 29, 510, 140);
//		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
//		contentPane.add(scroll);
		
		
		
		
	}
}