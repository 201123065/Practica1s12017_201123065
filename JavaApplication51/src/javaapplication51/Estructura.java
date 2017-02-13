
package javaapplication51;

public class Estructura {
    class Nodo{
        int info;
        Nodo sig;
    }
    private Nodo raiz;
    
    class pila{
        public pila (){
            raiz=null;
        }
        public void insertar(int x){
            Nodo nuevo;
            nuevo=new Nodo();
            nuevo.info=x;
            if(raiz==null){
                nuevo.sig=null;
                raiz=nuevo;
            }
            else{
                nuevo.sig=raiz;
                raiz=nuevo;
            }
        }
        public int extraer(){
            if(raiz!=null){
                int informacion = raiz.info;
                raiz = raiz.sig;
                return informacion;
            }
            else{
                return Integer.MAX_VALUE;
            }
        }
        public void imprimir(){
            Nodo reco = raiz;
            System.out.println("Lista");
            while(reco!=null){
                System.out.println(reco.info+"-");
                reco=reco.sig;
            }
            System.out.println();
        }
    }
}
