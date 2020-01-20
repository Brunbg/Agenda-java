package modelo;
import java.util.ArrayList;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programa��o Orientada a Objetos
 * Prof. Fausto Maranh�o Ayres
 **********************************/
public class CompromissoEmGrupo extends Compromisso {
	private ArrayList<Contato> contatos = new ArrayList<>();
	public CompromissoEmGrupo(String titulo, int dia,int mes, int ano, int hora, int minuto,
			String tipo, int id) {
		super(titulo, dia, mes, ano, hora, minuto, tipo, id);
		// TODO Auto-generated constructor stub
	}

	
	public ArrayList<Contato> getContatos() {
		return contatos;
	}



	public void setContatos(ArrayList<Contato> contatos) {
		this.contatos = contatos;
	}
	public void adicionar(Contato p){
		contatos.add(p);
	}
	public void remover(Contato p){
		contatos.remove(p);
	}

	public Contato localizar(String nome){
		for(Contato p : contatos){
			if(p.getNome().equals(nome))
				return p;
		}
		return null;
	}
}
