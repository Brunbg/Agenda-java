package aplicacao_swing;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programação Orientada a Objetos
 * Prof. Fausto Maranhão Ayres
 **********************************/

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import aplicacao_console.TesteConsole1;
import fachada.Fachada;
import modelo.Contato;
import modelo.Telefone;

public class TelaPrincipal {

	private JFrame frame;
	private JMenu mnCompromissos;
	private JMenu mnContatos;
	private JMenu mnTelefones;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.e	
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Agenda Bem Muito Mais");

		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				try{
					//TesteConsole1.main(null);
					Fachada.cadastrarContato("joao","bgrynor@gmail.com","58040331","974","www",3,13,06);
					Fachada.cadastrarContato("jose","lobox30aqw@gmail.com","58040331","974","www",3,13,06);
					Fachada.cadastrarContato("maria","macau-pb@hotmail.com","58040331","974","www",2,13,06);
					Fachada.cadastrarContato("pedro","lobox30aqw@hotmail.com","58040331","974","www",2,13,06);
					Fachada.cadastrarContato("joca","farias-pb@hotmail.com","58040331","974","www",3,13,06);
					Fachada.adicionarTelefone("joao", "83", "888800000");
					Fachada.adicionarTelefone("jose", "83", "888811110");
					Fachada.adicionarTelefone("maria", "83", "888852220");
					Fachada.adicionarTelefone("joao", "83", "888833330");
					Fachada.adicionarTelefone("jose", "83", "888833330");
					Fachada.adicionarTelefone("pedro", "83", "888833330");
					System.out.println("pre-cadastro concluido");

				}catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
			@Override
			public void windowClosing(WindowEvent e) {
				JOptionPane.showMessageDialog(null, "até breve !");
			}
		});

		frame.setBounds(100, 100, 384, 271);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		label = new JLabel("");
		label.setBounds(0, 0, 378, 221);
		ImageIcon imagem = new ImageIcon(TelaPrincipal.class.getResource("/imagens/imagem1.jpg"));
		imagem = new ImageIcon(imagem.getImage().getScaledInstance(label.getWidth(),label.getHeight(), Image.SCALE_DEFAULT
				));

		label.setIcon(imagem);
	
		frame.getContentPane().add(label);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		mnCompromissos = new JMenu("Compromissos");
		menuBar.add(mnCompromissos);
		
		JMenuItem mnscCadastrar = new JMenuItem("Cadastrar");
		mnscCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroCompromisso j = new TelaCadastroCompromisso();
				j.setVisible(true);
			}
		});
		JMenuItem mnscRemover = new JMenuItem("Remover");
		mnscRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaRemoverCompromisso j = new TelaRemoverCompromisso();
				j.setVisible(true);
			}
		});
		JMenuItem mnscListar = new JMenuItem("Listar");
		mnscListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListagemComp j = new TelaListagemComp();
				j.setVisible(true);
			}
		});
		mnCompromissos.add(mnscCadastrar);
		mnCompromissos.add(mnscRemover);
		mnCompromissos.add(mnscListar);

		mnTelefones = new JMenu("Telefone");
		menuBar.add(mnTelefones);

		JMenuItem mnsTListar = new JMenuItem("Listar");
		mnsTListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListagem j = new TelaListagem();
				j.setVisible(true);
			}
		});

		JMenuItem mnsTRemover = new JMenuItem("Remover");
		mnsTRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		JMenuItem mnsTAdicionar = new JMenuItem("Adicionar");
		 mnsTAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAdicionarTelefone j = new TelaAdicionarTelefone();
				j.setVisible(true);
			}
		});
		

		mnTelefones.add(mnsTRemover);
		mnTelefones.add(mnsTListar);
		mnTelefones.add(mnsTAdicionar);

		mnContatos = new JMenu("Contatos");
		menuBar.add(mnContatos);

		JMenuItem mnsConCadastrar = new JMenuItem("Cadastrar");
		mnsConCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroContato j = new TelaCadastroContato();
				j.setVisible(true);
			}
		});
		JMenuItem mnsConRemover = new JMenuItem("Remover");
		mnsConRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaRemoverContato j = new TelaRemoverContato();
				j.setVisible(true);
			}
		});
		
		JMenuItem mnsConListar = new JMenuItem("Listar");
		mnsConListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListagem j = new TelaListagem();
				j.setVisible(true);
			}
		});
		mnContatos.add(mnsConCadastrar);
		mnContatos.add(mnsConRemover);
		mnContatos.add(mnsConListar);

		JMenu mnConsulta = new JMenu("Consulta");
		mnConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		menuBar.add(mnConsulta);
		JMenuItem mnscoConsulta1 = new JMenuItem("Consulta1");
		mnscoConsulta1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaConsulta j = new TelaConsulta(1);
				j.setVisible(true);
			}
		});
		JMenuItem mnscoConsulta2 = new JMenuItem("Consulta2");
		mnscoConsulta2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaConsulta j = new TelaConsulta(2);
				j.setVisible(true);
			}
		});
		mnConsulta.add(mnscoConsulta1);
		mnConsulta.add(mnscoConsulta2);
		
	}
}
