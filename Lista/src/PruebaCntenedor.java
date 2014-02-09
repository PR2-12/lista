public class PruebaCntenedor {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	ContenedorDeEnteros a = new ContenedorDeEnteros();
//		a.insertar(4);
//		a.insertar(5);
//		a.insertar(6);
//		a.insertar(7);
//		if(a.buscar(5))
//			System.out.println("el elemento 5 está");
//		a.extraer(5);
//		if (!a.buscar(5)) {
//			System.out.println("El elemento nos está");
//		}
//		System.out.println("la cantidad total es :"+a.cardinal());
//		int [] e=a.elementos();
//		 for (int i = 0; i < e.length; i++) {
//			System.out.println("elemento"+e[i]);
//		} 
//		
		
		 int[] v;
		 System.out.println("El contenedor a tiene "+a.cardinal()+" elementos.");
		 for(int i=0; i<10; i++){
		 a.insertar(i);
		 a.buscar(i);
		 }
		 v = a.elementos();
		 for(int i=0; i<a.cardinal(); i++) System.out.println(v[i]);
		 a.vaciar();
		 for(int i=0; i<100; i++){
		 a.insertar(i);
		 a.extraer(i);
		 }
	}
}
