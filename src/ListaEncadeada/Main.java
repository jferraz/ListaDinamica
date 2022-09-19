package ListaEncadeada;

public class Main {
    public static void main(String[] args) throws Exception {
        ListaEncadeada<Integer> lista = new ListaEncadeada<Integer>();
        lista.adiciona(1);

        System.out.println("Tamanho = " + lista.getTamanho());
        System.out.println(lista);
      
        lista.adiciona(10);
        lista.adiciona(32);
        lista.adiciona(14);
        lista.adiciona(28);
        lista.adiciona(32);
        lista.adiciona(32);
        lista.adiciona(115);
        System.out.println(lista);

        lista.repetidos();//remove os elementos repetidos

        lista.adicionaFinal(65);
        lista.adicionaFinal(33);
        System.out.println(lista);
             
        lista.removeInicio();
        System.out.println(lista);

        lista.removeFinal();
        System.out.println(lista);

        lista.adicionaPosicao(38, 5);
        System.out.println(lista);

        lista.removePosicao(2);
        System.out.println(lista);
		
        System.out.println("Ultimo elemento = " + lista.ultimoElemento());

        System.out.println("Penultimo elemento = " + lista.penultimoElemento());
				
		System.out.println(lista.retornaElementoNPos(2));
	    
	    lista.imprimirContrario();
	   
        System.out.println(lista);
	    

    }
}
