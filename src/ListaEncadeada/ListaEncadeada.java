package ListaEncadeada;

public class ListaEncadeada<T> {

    public Node<T> inicio;
    public Node<T> ultimo;
    public int tamanho = 0;

    public void adiciona(T elemento) {
        Node<T> celula = new Node<T>(elemento);
        if (this.tamanho == 0) {
            this.inicio = celula;
        } else {
            this.ultimo.setProximo(celula);
        }
        this.ultimo = celula;
        this.tamanho++;
    }

    public void adicionaFinal(T elemento) {
		Node<T> celula = new Node<T>(elemento);
		if(ListaVazia()) {
			this.inicio = celula;
		}else {
			Node<T> aux = this.inicio;
			while(aux.proximo != null) {
				aux = aux.proximo;
			}
			aux.proximo = celula;
		}
		this.tamanho++;
	}

    public Node<T> removeInicio(){
        Node<T> removido = null;
        
        if(ListaVazia()) {
            System.out.println("Vetor Vazio"); 
        }else {
            removido = this.inicio;
            this.inicio = inicio.proximo;                    
            this.tamanho--;
        } 
        return removido;
    }

    public Node<T> removeFinal(){
		Node<T> removido = null;
		Node<T> aux = null;
		if(ListaVazia()) {
			System.out.println("Vetor Vazio"); 
		}else {
			removido = aux = inicio;
			while(removido.proximo != null) {
				aux = removido;
				removido = removido.proximo;
			}
			aux.proximo = null;
			this.tamanho--;
		}
		return removido;
	}

    public void adicionaPosicao(T elemento, int i) {
		if(ListaVazia() || i <= 0) {
			adiciona(elemento);
		}else {
			Node<T> novo = new Node<T>(elemento);
			Node<T> aux = inicio;
			int indice = 1;
			while(indice < i && aux != null) {
				aux = aux.proximo;
				indice++;
			}
			if(aux == null) {
				adicionaFinal(elemento);
			}else {
				novo.proximo = aux.proximo;
				aux.proximo = novo;
			}
			this.tamanho++;
		}
		
	}
	
	public Node<T> removePosicao(int i){
		Node<T> removido = null;
		Node<T> aux = null;
		if(ListaVazia() || i <= 1) {
			removido = removeInicio();
		}else {
			removido = aux = inicio;
			int indice = 1;
			while(indice <i && removido != null) {
				aux = removido;
				removido = removido.proximo;
				indice++;		
			}
			this.tamanho--;
			if(removido == null) {
				removido = removeFinal();
			}else {
				aux.proximo = removido.proximo;
			}
		}
		return removido;
	}

// 2) Criar um método para imprimir os elemento da lista da esquerda para direita (do inicio para o fim).
  
//     public void mostraLista(int indice){
//         Node<T> atual = inicio;

//         while (atual.proximo != null) {
//             //System.out.print(atual.elemento + ", ");
//             atual = atual.proximo;
        
//         }
//         //System.out.print(atual.elemento + " ");
//         System.out.println(indice);
//   }

    //1) Fazer um método para retornar o último elemento.
    
    public T ultimoElemento() {
        //Acessar o ultimo elemento
        // Imprimir
        Node<T> temp = inicio;
    
        while(temp.getProximo() != null) {
           temp = temp.getProximo();
        }
        return temp.getElemento();
    
      }

    //2) Fazer um método para retornar o penúltimo elemento.
   
         
    public T penultimoElemento() {
      
        Node<T> temp = inicio;
    
        while(temp.getProximo() != null && temp.getProximo().getProximo() != null) {
           temp = temp.getProximo();
        }
        return temp.getElemento();
    
      }

     //3) Fazer um método para retornar um elemento da n-ésima posição.

	 public String retornaElementoNPos(int i) throws Exception {
        Node<T> aux = null;
        Node<T> aux2 = null;
		 T item = null;
		 if(ListaVazia()) {
	        	return "Vetor Vazio";
	        }else if(i >= getTamanho()) {
	        	ultimoElemento();
	        }else {
	        	String str = "Posição = "+ i +", elemento: ";
			 	aux = aux2 = inicio;
				int indice = 1;
				while(indice < i && aux2 != null) {
					aux = aux2;
					aux2 = aux2.getProximo();
					item = aux2.getElemento();
					indice++;		
				}
		        return str + item + "\n ";
	        }
		 	
		 return "/n";
	 }

	 //4) Fazer um método para inverter a lista de forma referencial:

        public void imprimirContrario() {
            Node<T> ante = null;
            Node<T> prox = null;
            Node<T> temp = inicio;
            
            while(temp.getProximo() != null) {
              prox = temp.getProximo();
              temp.setProximo(ante);
              ante = temp;
              temp = prox;
            }
            temp.setProximo(ante);
            System.out.println("Lista invertida: " + ante);
            
          }

	 //5) Fazer um método para verificar se tem elementos repetidos em uma LSE.

	 public void repetidos(){
        
        if(ListaVazia()) {
          System.err.println("Vetor Vazio");
        }
        
        //T repete = null;
		int indice = 2;
		for (Node<T> i = inicio; i != null; i = i.getProximo()) {
              
		    for(Node<T> j = inicio; j != null; j = j.getProximo()){
                             		
                        if(i.elemento == j.elemento) {
		        			removePosicao(indice);
		        		}else {
		        			indice++;
		        		}                 
		    }
	    }
        
	}
        	 
	
	 
	 
	//  public void inverterLista() {
	// 	 if(ListaVazia()) {
	// 		 System.out.println("Vetor Vazio");
	//         }else {
	//         	int cont = 0;
	//         	int vet = tamanho;
	//         	while(cont <= vet-1) {
	//         		int elem = Integer.parseInt(ultimoElemento());
	//         		//adicionar_posicao(elem, cont);
    //                 adicionaPosicao(null, elem);
	//         		removeFinal();
    //                 //remover_final();
	//         		cont++;
	//         	}
	//         }
		 
	//  }


    public int getTamanho(){
        return this.tamanho;
    }

    public boolean ListaVazia(){
        if (this.inicio == null){
            return true;
        }            
        else return false;                 
    }

    @Override
	public String toString() {
		return ""+ inicio;
	}

	public void imprimirContrario(int i) {
	}

    // @Override
    // public String toString() {
    // //     return "ListaEncadeada [inicio=" + inicio + "]";
    // // }
    //     if(this.tamanho == 0){
    //         return "[]";
    //     }

    //     StringBuilder builder = new StringBuilder("[");

    //     Node<T> atual = this.inicio;
    //     for(int i = 0; i < this.tamanho - 1; i++) {
    //         builder.append(atual.getElemento()).append(",");
    //         atual = atual.getProximo();
    //     }
    //     builder.append(atual.getElemento()).append("]");
    //     return builder.toString();
    // }
}
