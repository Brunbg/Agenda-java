package ViaCep.src;
import org.json.JSONObject;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;

public class TesteViaCep {
	private static String JsonStr = "";
	static ArrayList<String> auxjson = new ArrayList<String>();
	static ArrayList<String> resultado = new ArrayList<String>();

	public static ArrayList<String> endereco(String cep) {
		try {
			URL url = new URL("http://viacep.com.br/ws/"+ cep +"/json");//pype
			//URL url = new URL("http://ifpb.edu.br");
			URLConnection conexao = url.openConnection();
			InputStream input = conexao.getInputStream();
			Scanner scan = new Scanner(input);
			String linha;
			while (scan.hasNext())	{
				linha = scan.nextLine(); 
				linha = linha.trim();		//remover brancos externos
				auxjson.add(linha);
			}
			scan.close();
			for(String i : auxjson) {
				JsonStr += i;
			}
//			System.out.println(JsonStr);
			JSONObject f = new JSONObject(JsonStr);
			resultado.add(f.getString("logradouro"));
			resultado.add(f.getString("bairro"));
			resultado.add(f.getString("localidade"));
			
			return resultado;
			
		
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
