package aplicacao_swing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import modelo.Contato;
import modelo.Telefone;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JToolBar;
import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JEditorPane;
import javax.swing.JTree;

public class TelaListagem extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
	private JButton button1;
	private JComboBox comboBox;
	private JTextField textField;
	private ArrayList<Contato> lista = new ArrayList<Contato>();

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
	public TelaListagem() {
		setResizable(false);
		
		setTitle("Listagem");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 478);		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(125, 181, 241, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.addItem("Nome");
		comboBox.addItem("Telefone");
		comboBox.addItem("Proximidade");
		comboBox.setBounds(24, 180, 91, 22);
		comboBox.setSelectedItem(null);
		contentPane.add(comboBox);
		
		textArea = new JTextArea();		
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(24, 29, 510, 140);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(scroll);
		
		

		button1 = new JButton("Listar Contato");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String escrito = textField.getText();
					String value = (String) comboBox.getSelectedItem();
					System.out.println(escrito+"ok");
					System.out.println(value+"ata");
					if (value=="Nome"){
						System.out.println("entrei fodac");
						ArrayList<Contato> lista = Fachada.listarContatosPorNome(escrito);
						String texto = "Listagem de contatos\n";
						if (lista.isEmpty())
							texto += "não tem contato cadastrada\n";
						else 
							System.out.println("oi");
							for(Contato p: lista) 
								texto +=  p + "\n"; 

						System.out.println(texto);
						textArea.setText(texto);
					}
					else if(value=="Telefone") {
						ArrayList<Contato> lista = Fachada.listarContatosPorTelefone(escrito);
						String texto = "Listagem de contatos\n";
						if (lista.isEmpty())
							texto += "não tem contato cadastrada\n";
						else 
							for(Contato p: lista) 
								texto +=  p + "\n"; 

						textArea.setText(texto);
					}
					else if(value=="Proximidade") {
						ArrayList<Contato> lista = Fachada.listarContatosPorProximidade(Integer.parseInt(escrito));
						String texto = "Listagem de contatos\n";
						if (lista.isEmpty())
							texto += "não tem contato cadastrada\n";
						else 
							for(Contato p: lista) 
								texto +=  p + "\n"; 

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
		button1.setBounds(387, 180, 115, 23);
		contentPane.add(button1);
		
		JList list = new JList();
		list.setBounds(56, 372, 218, -71);
		contentPane.add(list);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(153, 372, 231, -97);
		contentPane.add(desktopPane);
		
//		textArea = new JTextArea();		
//		JScrollPane scroll = new JScrollPane(textArea);
//		scroll.setBounds(24, 29, 510, 140);
//		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
//		contentPane.add(scroll);
		
		
		
		
	}
}
