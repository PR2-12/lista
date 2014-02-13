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
		long[] tiempo = probarInsertar();
		for (int i = 0; i < tiempo.length; i++) {
			System.out.println("el tiempo es:" + tiempo[i]);
		}

	}

	private static long[] probarInsertar() {
		Date actual ;
		long[] tiemposPorIncersion = new long[100000];
		for (int i = 0; i < elementos.length; i++) {
			actual=new Date();
			lista.insertar(elementos[i]);
			actual=new Date();
			guardarTiempoPorIncersion(actual,i ,tiemposPorIncersion);
		}
	return	calcularPromedio(tiemposPorIncersion);
	}

	private static long[] calcularPromedio(long[] tiemposPorIncersion) {
		long[] tiempos = new long[10];
		long contador = 0;
		for (int j = 0; j < tiemposPorIncersion.length; j++) {
			contador += tiemposPorIncersion[j];
			if ((j + 1) % 10000 == 0) {
				tiempos[((j + 1) / 10000) - 1] = contador / j + 1;
			}
		}
		return tiempos;
	}

	private static void guardarTiempoPorIncersion(Date actual, int i,long[] tiempos) {
		calendario.setTime(actual);
		tiempos[i] = calendario.getTimeInMillis();
	}

	

	private static void cargarVector() throws IOException {
		RandomAccessFile randomReader = new RandomAccessFile(new File(path),"rw");
		for (int i = 0; i < elementos.length; i++) {
			elementos[i] = randomReader.read();
		}
		randomReader.close();
	}
}
