package modelo;
//ala
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programa��o Orientada a Objetos
 * Prof. Fausto Maranh�o Ayres
 **********************************/
import java.util.ArrayList;
import ViaCep.src.TesteViaCep;
import modelo.Endereco;


public class Contato {
	private String nome;
	private String email;
	private String cep;
	private Endereco endereco;
	private String linkfacebook;
	private String numero;
	private int grauproximidade;
	private int mesaniversario;
	private int diaaniversario;
	
	private ArrayList<Telefone> telefones = new ArrayList<Telefone>();
	private ArrayList<String> strEnde = new ArrayList<String>();

	
	public Contato(String nome,String email,String cep,String numero,String link,int grau,int dia,int mes) {
		super();
		this.nome = nome;
		this.email=email;
		this.cep=cep;
		this.numero=numero;
		this.linkfacebook=link;
		this.grauproximidade=grau;
		this.diaaniversario=dia;
		this.mesaniversario=mes;
		strEnde=TesteViaCep.endereco(cep);
		this.endereco= new Endereco(strEnde.get(0),strEnde.get(1),strEnde.get(2));
	}
	
	
	public String getLinkfacebook() {
		return linkfacebook;
	}
	
	public String getNumero() {
		return numero;
	}
	public String getEmail() {
		return email;
	}
	
	public String getCep() {
		return cep;
	}
	public String getEndereco() {
		String texto = endereco.getLougradouro()+ ","+endereco.getBairro()+","+endereco.getEstado();
		return texto + "]";
	}
	public String getNome() {
		return nome;
	}
	public int getDiaaniversario() {
		return diaaniversario;
	}
	public int getMesaniversario() {
		return mesaniversario;
	}
	public int getGrauproximidade() {
		return  grauproximidade;
	}
	
	public void setDiaaniversario(int dia) {
		this.diaaniversario=dia;
	}
	public void setMesaniversario(int mes) {
		this.mesaniversario=mes;
	}
	public void setGrauproximidade(int grau) {
		this.grauproximidade=grau;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	
	public void setCep(String cep) {
		this.cep=cep;
	}
	
	
	public void setNumero(String numero) {
		this.numero=numero;
	}
	public void setLinkfacebook(String link) {
		this.linkfacebook=link;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}


	public void adicionar(Telefone p){
		telefones.add(p);
	}
	public void remover(Telefone p){
		telefones.remove(p);
	}
	//novo
	public ArrayList<Telefone> getTelefones() {
		return telefones;
	}

	public Telefone localizarTelefone(String numero){
		for(Telefone p : telefones){
			if(p.getNumero().equals(numero))
				return p;
		}
		return null;
	}
	


	@Override
	public String toString() {
		String texto = "Contato [nome=" + nome ;
		texto += ", telefones:";
		if (telefones.isEmpty())
			texto += " vazia";
		else 	
			for(Telefone p: telefones) 
				texto += " " + p.getNumero() ;

		return texto + "]";
	}


}
	


