import java.util.Iterator;
import java.util.LinkedList;

class IteratorTBD<E> implements Iterator<E>{

    LinkedList<E[]> list;
    int taille;
    int decompte;

    public IteratorTBD(int taille, LinkedList<E[]> list){
        this.taille = taille;
        this.list = new LinkedList<E[]>();
        this.list = list;
        this.decompte = 0;
    }

    public boolean hasNext(){
        return decompte < taille;
    }

    public E next(){
        decompte++;
        return list.get(decompte)[0];
    }
}