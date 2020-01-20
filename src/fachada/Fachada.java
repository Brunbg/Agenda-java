/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POO - Programaï¿½ï¿½o Orientada a Objetos
 * Prof. Fausto Ayres
 *
 */
package fachada;
import java.util.ArrayList;
import modelo.Compromisso;
import modelo.CompromissoEmGrupo;
import modelo.Contato;
import modelo.Telefone;
import repositorio.Agenda;
import repositorio.JavaMailApp;

import java.time.LocalDateTime;


public class Fachada {

	private static Agenda agenda = new Agenda();
	


	public static Contato cadastrarContato(String nome,String email,String cep,String numero,String link,int grau,int dia,int mes) 	throws  Exception{
		Contato c = agenda.localizarContato(nome);
		if (c!=null)
			throw new Exception("cadastrar contato - nome ja cadastrado:" + nome);
		if(grau>3 || grau<1)
			throw new Exception("cadastrar contato - O grau tem que ser no intervalo de 1 a 3");
		c = new Contato(nome,email,cep,numero,link,grau,dia,mes);
		agenda.adicionar(c);
		return c;
	}
	//novo
	public static Compromisso cadastrarCompromisso(String titulo,int dia,int mes, int ano, int hora, int minuto, String tipo) throws Exception{
		int id= agenda.ordemcomp();
		Compromisso c = agenda.localizarcompromissos(titulo,tipo);
		if (c!=null)
			throw new Exception("Compromisso" + titulo +"do tipo:"+ tipo + "já está na sua agenda!");
		c= new Compromisso(titulo,dia,mes,ano,hora,minuto,tipo,id);
		agenda.adicionar(c);
		return c;

	}
	public static Compromisso cadastrarCompromissoGrupo(String titulo,int dia,int mes, int ano, int hora, int minuto, String tipo, ArrayList<String> contatos) throws Exception{
		int id= agenda.ordemcomp();
		//System.out.println("o id"+id);
		ArrayList<Contato>contatoss=retornaContatosPorNomes(contatos);
		Compromisso c = agenda.localizarcompromissos(titulo,tipo);
		if (c!=null)
			throw new Exception("Compromisso" + titulo +"do tipo:"+ tipo + "já está na sua agenda!");
		CompromissoEmGrupo d= new CompromissoEmGrupo(titulo,dia,mes,ano,hora,minuto,tipo,id);
		d.setContatos(contatoss);
		//System.out.println("os contatos"+d.getContatos());
		agenda.adicionar(d);
		//System.out.println("os compromissos"+agenda.getCompromissos());
		return d;
		// cria um objeto
//		CompromissoGrupo com os dados, incluindo a lista de nomes dos contatos, e o adiciona na lista
//		de compromissos da Agenda
	}
	public static ArrayList<Contato> retornaContatosPorNomes(ArrayList<String> nomes){
		int tam=nomes.size();
		ArrayList<Contato> aux = new ArrayList<Contato>();
		Contato nome=null;
		for(int i=0;i<tam;i++) {
			for (Contato c : agenda.getContatos()) {
				if (c.getNome().equals(nomes.get(i))){
					nome=c;
				}}	
			aux.add(nome);
		}
	   return aux;	
	}

	public static void adicionarTelefone(String nome,String ddd, String numero)	throws  Exception{
		Contato c = agenda.localizarContato(nome);
		if (c==null)
			throw new Exception("adicionar telefone - contato nao cadastrado:" + nome);

		if(numero.length()!=9)
			throw new Exception("adicionar telefone - numero de telefone precisa ter 9 digitos");
		Telefone t = agenda.localizarTelefone(numero);
		if (t==null) {
			t = new Telefone(ddd,numero);
			agenda.adicionar(t);
			c.adicionar(t);
			t.adicionar(c);
		}
		else {
			Telefone t2 = c.localizarTelefone(numero);
			if(t2!=null)
				throw new Exception("adicionar telefone - contato ja possui este numero:" + numero);
			else {
				c.adicionar(t);
				t.adicionar(c);
			}

		}

	}
//	public static void Telefone(nome,numero...) {
//		
//	}
// novo	+++++++
	public static void removerContato(String nome) throws Exception{
		Contato c = agenda.localizarContato(nome);
		if (c==null)
			throw new Exception("Contato nao cadastrado:" + nome);
		else {
			agenda.remover(c);
			
			for (Telefone telefones : c.getTelefones()) {
				//int value=0;
				//c.remover(telefones);
				for(Contato contatos : telefones.getContatos()){
					if(contatos.getNome()==nome) {
					    telefones.remover(contatos);	
					}
				}
			}
		}
		
	}
	public static void removerTelefone(String nome,String numero) throws Exception{ 
		Contato c= agenda.localizarContato(nome);
		if (c==null)
			throw new Exception("Contato nao cadastrado:" + nome);
		else {
			for(Telefone Telefones : c.getTelefones()) {
				if(Telefones.getNumero()==numero) {
					c.remover(Telefones);
					Telefones.remover(c);
				}
				
			}
		}
			
		
	}
	
	public static void removerCompromisso(int id) throws Exception{
		Compromisso c = agenda.localizarcompromissos(id);
		if (c==null)
			throw new Exception("Compromisso com id"+ id + " não cadastrado:");
		else {
			agenda.remover(c);
			
			
		}
	}
	public static ArrayList<Contato> listarContatosPorNome(String termo){
		ArrayList<Contato> aux = new ArrayList<Contato>();
		for (Contato c : agenda.getContatos()) {
			if (c.getNome().contains(termo)){
				aux.add(c);
			}	
		}
	   return aux;
	}
	public static Contato ContatoPorNome(String termo){
		for (Contato c : agenda.getContatos()) {
			if (c.getNome().contains(termo)){
				return c;
			}	
		}
	   return null;
	}
	public static ArrayList<Contato> listarContatosPorTelefone(String digitos){
		ArrayList<Contato> aux = new ArrayList<Contato>();
		for (Telefone c : agenda.getTelefones()) {
			if (c.getNumero().contains(digitos)) {
				for(Contato adc : c.getContatos()) {
					aux.add(adc);
				}
			}
		}
		return aux;
	}
	public static ArrayList<Contato> listarContatosPorProximidade(int valor){
		ArrayList<Contato> aux = new ArrayList<Contato>();
		for (Contato c : agenda.getContatos()) {
			if (c.getGrauproximidade()==valor){
				aux.add(c);
			}
	   }
		return aux;
	}	
	public static ArrayList<Compromisso> listarCompromissosPorTitulo(String termo){
		ArrayList<Compromisso> aux = new ArrayList<Compromisso>();
		for(Compromisso x : agenda.getCompromissos()) {
			if (x.get_titulo().contains(termo)){
				aux.add(x);
			}
		}
		return aux;
	}
	public static ArrayList<Compromisso> listarCompromissosPorDatas(LocalDateTime data1, LocalDateTime data2){
		ArrayList<Compromisso> aux = new ArrayList<Compromisso>();
        LocalDateTime maior= data2;
    	LocalDateTime menor= data1;
        if(data1.isAfter(data2)) {
            maior= data1;
        	menor= data2;
        }
        
		for (Compromisso x : agenda.getCompromissos()) {
			int a2=x.get_data().getYear();
			int m2=x.get_data().getMonthValue();
			int d2=x.get_data().getDayOfMonth();
			int h2=x.get_data().getHour();
			int mi2=x.get_data().getMinute();
			int s2=x.get_data().getSecond();
			LocalDateTime xdata= LocalDateTime.of(a2,m2,d2,h2,mi2,s2);
			if(xdata.isAfter(menor) && xdata.isBefore(maior)) {
				aux.add(x);
			}
		}
		return aux;
		
	}
	public static ArrayList<Compromisso> listarCompromissosPorTipo(String tipo){
		ArrayList<Compromisso> aux = new ArrayList<Compromisso>();
		for(Compromisso x : agenda.getCompromissos()) {
			//System.out.println(x.get_tipo());
			if (x.get_tipo().equals(tipo)){
				//System.out.println(x.get_tipo());
				aux.add(x);
			}
		}
		return aux;
		
	}
	
	public static Compromisso CompromissoPorId(int id) throws Exception{ 
		for(Compromisso c : agenda.getCompromissos()) {
			if(c.get_id()==id) {
				return c;}}
		
		throw new Exception("id invalido");
		}
	
	
	

	public static ArrayList<Contato> listarContatos() {
		return agenda.getContatos();
	}
	public static ArrayList<Telefone> listarTelefones() {
		return agenda.getTelefones();
	}
	public static void notificarCompromissoGrupo(int id,String senha) {
		CompromissoEmGrupo c = (CompromissoEmGrupo)agenda.localizarcompromissos(id);
		ArrayList<Contato> aux = new ArrayList<Contato>();
		aux=c.getContatos();
		JavaMailApp.notifica(senha, c.get_titulo(), aux);
		
	}
	

	//------Consultas-----------------
	public static ArrayList<String> consulta1(){ //– retorna o nome dos contatos que tem 2 telefones ou mais
		ArrayList<String> aux = new ArrayList<String>();
		for(Contato c : agenda.getContatos()) {
			if(c.getTelefones().size()>1) {
				aux.add(c.getNome());
			}
		}
		return aux;
	}
	public static ArrayList<String> consulta2(){ //– retorna o numero de telefone que tem 2 contatos ou mais
		ArrayList<String> aux = new ArrayList<String>();
		for(Telefone c : agenda.getTelefones()) {
			if(c.getContatos().size()>1) {
				aux.add(c.getNumero());
			}
		}
		return aux;
		
	}

}//class
