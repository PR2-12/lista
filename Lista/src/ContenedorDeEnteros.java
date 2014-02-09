class Nodo {
	Nodo referencia;
	int valor;

	public Nodo() {
	}

	public Nodo(int valor, Nodo referencia) {
		this.valor = valor;
		this.referencia = referencia;
	}

	public Nodo(int valor) {
		this.valor = valor;
	}
}

public class ContenedorDeEnteros {
	private Nodo nodo;
	private Nodo iterador;
	private int cantidadElemento;

	public ContenedorDeEnteros() {
		nodo = new Nodo();
		cantidadElemento = 0;
		iterador = nodo;
	}

	public int cardinal() {
		return cantidadElemento;
	}

	public boolean insertar(int elemento) {
		if (cantidadElemento == 0)
			return insertarPrimerNodo(elemento);
		return insertarNodo(elemento);
	}

	private boolean insertarNodo(int elemento) {
		Nodo temporal = nodo.referencia;
		nodo.referencia = new Nodo(elemento, temporal);
		cantidadElemento++;
		return true;
	}

	private boolean insertarPrimerNodo(int elemento) {
		nodo.referencia = new Nodo(elemento);
		cantidadElemento++;
		return true;
	}

	public boolean extraer(int elemento) {
		iterador = nodo;
		while (iterador.referencia != null) {
			if (iterador.referencia.valor == elemento)
				return extraerElemento();
			iterador = iterador.referencia;
		}

		return false;
	}

	private boolean extraerElemento() {
		iterador.referencia = iterador.referencia.referencia;
		cantidadElemento--;
		return true;
	}

	public boolean buscar(int elemento) {
		iterador = nodo;
		while (iterador.referencia != null) {
			if (iterador.referencia.valor == elemento)
				return true;
			iterador = iterador.referencia;
		}
		return false;
	}

	public void vaciar() {
		nodo.referencia = null;
	}

	public int[] elementos() {
		iterador = nodo.referencia;
		int[] arreglo = new int[cantidadElemento];
		for (int i = 0; i < cantidadElemento; i++) {
			arreglo[i] = iterador.valor;
			iterador = iterador.referencia;
		}
		return arreglo;
	}
}
