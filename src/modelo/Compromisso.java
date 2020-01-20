package modelo;

/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programa��o Orientada a Objetos
 * Prof. Fausto Maranh�o Ayres
 **********************************/
import java.time.LocalDateTime;


public class Compromisso {
private int id;
private String titulo;
private LocalDateTime datahora;
private String tipo;
//novo
public Compromisso(String titulo,int dia,int mes, int ano, int hora, int minuto, String tipo,int id) {
    super();
    this.titulo = titulo;
    this.tipo=tipo;
    this.id=id;
//    String anoS;
//    String mesS;
//    String diaS;
//    String horaS;
//    String minutoS;
//    if(ano > 9) {anoS=Integer.toString(ano);}
//    else {anoS="0"+Integer.toString(ano);}
//    if(dia > 9) {diaS=Integer.toString(dia);}
//    else {diaS="0"+Integer.toString(dia);}
//    if(mes > 9) {mesS=Integer.toString(mes);}
//    else {mesS="0"+Integer.toString(mes);}
//    if(hora > 9) {horaS=Integer.toString(hora);}
//    else {horaS="0"+Integer.toString(hora);}
//    if(minuto > 9) {minutoS=Integer.toString(minuto);}
//    else {minutoS="0"+Integer.toString(minuto);}
    
    this.datahora = LocalDateTime.of(ano,mes,dia,hora,minuto,0);
    //this.datahora = LocalDateTime.parse(anoS+"-"+mesS+"-"+diaS+"T"+horaS+":"+minutoS+":00");
   // this.datahora = LocalDateTime.of, time)
}


public String get_titulo(){
    return titulo;
}
public int get_id(){
    return id;
}
public String get_tipo(){
    return tipo;
}
public LocalDateTime get_data(){
	return datahora;
}
public void set_data(String dia,String mes, String ano, String hora, String minuto){
	this.datahora = LocalDateTime.parse(ano+"-"+mes+"-"+dia+"T"+hora+":"+minuto+":00");
}
public void set_titulo(String novo){
    this.titulo=novo;
}

public void set_tipo(String novo){
    this.tipo=novo;
}
@Override
public String toString() {
	String texto = "Compromisso [Titulo=" + titulo + ", Data:"+this.datahora+", Tipo:" + tipo + ", Id:"+id;

	return texto + "]";
}

}
