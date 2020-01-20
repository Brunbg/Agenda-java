package aplicacao_console;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programa��o Orientada a Objetos
 * Prof. Fausto Maranh�o Ayres
 **********************************/


import java.util.ArrayList;
import java.util.Scanner;

//novo
import modelo.Compromisso;
import fachada.Fachada;
import modelo.Contato;
import modelo.Telefone;

public class TesteConsole1 {
	private Scanner teclado;
	public TesteConsole1() {
		cadastrar();
		atualizar();
		//excluir();
		//listar();
		//consultar();
		//excecoes();
	}

	public void cadastrar(){
		try {	
			//Telefone p;
			Fachada.cadastrarContato("joao","bgrynor@gmail.com","58040331","974","www",3,13,06);
			Fachada.cadastrarContato("jose","lobox30aqw@gmail.com","58040331","974","www",3,13,06);
			Fachada.cadastrarContato("maria","macau-pb@hotmail.com","58040331","974","www",2,13,06);
			Fachada.cadastrarContato("pedro","lobox30aqw@hotmail.com","58040331","974","www",2,13,06);
			Fachada.cadastrarContato("joca","farias-pb@hotmail.com","58040331","974","www",3,13,06);
			System.out.println("cadastro concluido");
		}catch (Exception e) {
			System.out.println("==>"+ e.getMessage());
		}
	}

	public static String[] QuebraString(String string) {
		string= string.replaceAll(" ,", ",");
		String[] arraystr= string.split(",");
		return arraystr;
	}
	public void atualizar(){
		try{
//			Fachada.adicionarTelefone("joao", "83", "888800000");
//			Fachada.adicionarTelefone("jose", "83", "888811110");
//			Fachada.adicionarTelefone("maria", "83", "888852220");
//			Fachada.adicionarTelefone("joao", "83", "888833330");
//			Fachada.adicionarTelefone("jose", "83", "888833330");
//			Fachada.adicionarTelefone("pedro", "83", "888833330");
			Fachada.adicionarcompromisso("isso", "28", "09", "2019", "14", "30", "Lazer");
			Fachada.adicionarcompromisso("eita", "28", "10", "2019", "14", "30", "Trabalhos");
			Fachada.adicionarcompromisso("valeu", "27", "05", "2019", "14", "30", "Tarefas");
			teclado = new Scanner(System.in);
			
			System.out.print("Digite os contatos (ex:fulano1,fulano2,fulano3)");
	        String[] arraystr = QuebraString(teclado.nextLine());
	        ArrayList<Contato> contatos= Fachada.retornaContatosPorNomes(arraystr);
	        System.out.println("os contatos antes de entrar"+contatos);
		    Fachada.cadastrarCompromissoGrupo("xhou","28","09", "2019", "14", "30", "quale", contatos);
		    
		    System.out.print("Digite os contatos (ex:fulano1,fulano2,fulano3)");
		    arraystr = QuebraString(teclado.nextLine());
	        contatos= Fachada.retornaContatosPorNomes(arraystr);
		    Fachada.cadastrarCompromissoGrupo("pou","28","09", "2019", "14", "30", "vei", contatos);
		    
		    System.out.print("Digite o id:");
	        int id = teclado.nextInt();
	        System.out.print("Digite sua senha");
	        String senha = teclado.next();
		    Fachada.notificarCompromissoGrupo(id, senha);
			//exce��o

//			Fachada.removerTelefone("jose", "88883333");
			System.out.println("atualizacao concluido");
		}catch (Exception e) {
			System.out.println("==>"+ e.getMessage());
		}
	}

	public static void excluir(){
		try {	
			Fachada.removerContato("maria");
			System.out.println("remo��o concluido");
		}catch (Exception e) {
			System.out.println("==>"+ e.getMessage());
		}
	}

	public void listar(){
		String texto;
		ArrayList<Telefone> lista1 = Fachada.listarTelefones();
		texto = "\nListagem de telefone: \n";
		if (lista1.isEmpty())
			texto += "n�o tem produto cadastrado\n";
		else 	
			for(Telefone p: lista1) 
				texto +=  p + "\n";
		System.out.println(texto);


		ArrayList<Contato> lista2 = Fachada.listarContatos();
		texto = "Listagem de contato: \n";
		if (lista2.isEmpty())
			texto += "n�o tem contato\n";
		else 
			for(Contato p: lista2) 
				texto +=  p + p.getEndereco()+"\n"; 
		System.out.println(texto);
		
		ArrayList<Contato> lista3 = Fachada.listarContatosPorTelefone("88885");
		texto = "Listagem de contato: \n";
		if (lista3.isEmpty())
			texto += "n�o tem contato\n";
		else 
			for(Contato p: lista3) 
				texto +=  p + "\n"; 
		System.out.println(texto);
		
		ArrayList<Contato> lista4 = Fachada.listarContatosPorNome("jo");
		texto = "Listagem de contato: \n";
		if (lista4.isEmpty())
			texto += "n�o tem contato\n";
		else 
			for(Contato p: lista4) 
				texto +=  p + "\n"; 
		System.out.println(texto);
	}
	
	
	

	public void consultar(){
	}


	public void excecoes() {

//	
	}
	//  ***********************************************
	public static void main (String[] args)   
	//  ***********************************************
	{
		new TesteConsole1();
	}

}
