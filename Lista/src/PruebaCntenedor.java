import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class PruebaCntenedor {
	static int[] elementos = new int[100000];
	static String path = "C:\\Users\\osvaldo\\git\\GitRepository\\Lista\\src\\datos.dat";
	static ContenedorDeEnteros lista = new ContenedorDeEnteros();
	static Calendar calendario = new GregorianCalendar();

	public static void main(String[] args) throws IOException {
		cargarVector();
		long []tiempo=probarInsertar();
		for (int i = 0; i < tiempo.length; i++) {
			System.out.println("el tiempo es:"+tiempo[i]);
		}

	}

	private static long[] probarInsertar() {
		Date actual = new Date();
		calendario.setTime(actual);
		int contadorFecha = 0;
		long[] tiempos = new long[10];
		for (int i = 0; i < elementos.length; i++) {
			lista.insertar(elementos[i]);
			if ((i+1)%10000==0 && i!=0) {
				guardarTiempo(actual, contadorFecha, tiempos);
				actual=new Date();
				contadorFecha++;
			}
		}
		return tiempos;
	}

	private static void guardarTiempo(Date fecha, int contadorFecha,long[] tiempos) {
		calendario.setTime(fecha);
		tiempos[contadorFecha] = calendario.getTimeInMillis();
		
	}

	private static void cargarVector() throws IOException {
		RandomAccessFile randomReader = new RandomAccessFile(new File(path),"rw");
		for (int i = 0; i < elementos.length; i++) {
			elementos[i] = randomReader.read();
		}
		randomReader.close();
	}
}
