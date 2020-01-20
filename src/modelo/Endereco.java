package modelo;

public class Endereco {
	private String lougradouro;
	private String bairro;
	private String estado;
	
	public Endereco(String loug,String bair,String esta) {
		this.lougradouro=loug;
		this.bairro=bair;
		this.estado=esta;
	}
	public String getLougradouro() {
		return lougradouro;
	}
	public String getBairro() {
		return bairro;
	}
	public String getEstado() {
		return estado;
	}
	
	@Override
	public String toString() {
		String texto = "Endereço [lougradouro=" + this.lougradouro+ ", Bairro="+this.bairro+", Estado="+this.estado;
		return texto + "]";
	}
}
