
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programa��o Orientada a Objetos
 * Prof. Fausto Maranh�o Ayres
 **********************************/
package repositorio;
import java.util.ArrayList;
import java.util.TreeMap;

import modelo.Contato;
import modelo.Telefone;
import modelo.Compromisso;
import modelo.CompromissoEmGrupo;

public class Agenda {
	private ArrayList<Telefone> telefones = new ArrayList<Telefone>();
	private TreeMap<String,Contato> contatos = new TreeMap<>();
	//private ArrayList<Contato> contatos = new ArrayList<Contato>();
	private ArrayList<Compromisso> compromissos = new ArrayList<Compromisso>();
	
	public void adicionar(Telefone p){
		telefones.add(p);
	}
	public void remover(Telefone p){
		telefones.remove(p);
	}
	public Telefone localizarTelefone(String numero){
		for(Telefone p : telefones){
			if(p.getNumero().equals(numero))
				return p;
		}
		return null;
	}


	public void adicionar(Contato p){
		contatos.put(p.getNome(),p);
	}
	public void remover(Contato p){
		contatos.remove(p.getNome());
	}
	//novo
	public void adicionar(Compromisso p){
		compromissos.add(p);
	}
	public void remover(Compromisso p){
		compromissos.remove(p);
	}
	
	public int ordemcomp(){
		return compromissos.size()+1;
	}
	public Compromisso localizarcompromissos(String titulo,String tipo){
		for(Compromisso c : compromissos){
			if(c.get_titulo().equals(titulo)){
				if(c.get_tipo().equals(tipo)){
					return c;
				}
			}
		}
		return null;
	}
	public Compromisso localizarcompromissos(int id){
		for(Compromisso c : compromissos){
			if(c.get_id()==id){
				if (c instanceof CompromissoEmGrupo){
					return (CompromissoEmGrupo)c;
				}
			}
		}
		return localizarcompromissos2(id);
	}
	
	public Compromisso localizarcompromissos2(int id){
		for(Compromisso c : compromissos){
			if(c.get_id()==id){
				return c;
			}
		}
		return null;
	}

	public Contato localizarContato(String nome){
		for(Contato p : contatos.values()){
			if(p.getNome().equals(nome))
				return p;
		}
		return null;
	}

	
	public ArrayList<Telefone> getTelefones() {
		return telefones;
	}

	
	public ArrayList<Contato> getContatos() {
		ArrayList<Contato>aux=new ArrayList<Contato>();
		aux.addAll(contatos.values());
		return aux;
	}

	
	public ArrayList<Compromisso> getCompromissos(){
		return compromissos;
	}



}

