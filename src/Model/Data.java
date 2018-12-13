package Model;

import java.util.GregorianCalendar;

public class Data {
	
	StringBuilder sb = new StringBuilder();
	// cria um GregorianCalendar que vai conter a hora atual
	GregorianCalendar d = new GregorianCalendar();
	// anexa do StringBuilder os dados da hora
	
	private int second = d.get( GregorianCalendar.SECOND );
	private int min = d.get( GregorianCalendar.MINUTE );
	private int hora = d.get( GregorianCalendar.HOUR_OF_DAY );
	private int dia = d.get( GregorianCalendar.DAY_OF_MONTH );
	private int mes = d.get( GregorianCalendar.MONTH );
	private int ano = d.get( GregorianCalendar.YEAR );
	
public String dataCompleta() {
		sb.append( "Hora: " );
		sb.append( d.get( GregorianCalendar.HOUR_OF_DAY ) );
		sb.append( ":" );
		sb.append( d.get( GregorianCalendar.MINUTE ) );
		sb.append( ":" );
		sb.append( d.get( GregorianCalendar.SECOND ) );
		
		sb.append( " Dia: " );
		sb.append( d.get( GregorianCalendar.DAY_OF_MONTH ) );
		sb.append( " Mes: " );
		sb.append( d.get( GregorianCalendar.MONTH ) + 1);
		sb.append( " Ano: " );
		sb.append( d.get( GregorianCalendar.YEAR ) );
		
		return sb.toString();
	}

public static void main(String[] args) {
	Data data = new Data();
	System.out.print(data.dataCompleta());
}
	
	
}
