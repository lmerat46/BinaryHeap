import java.util.Iterator;

class IteratorTB<E> implements Iterator<E>{
    E tab[];
    int taille;
    int decompte;

    public IteratorTB(int taille, E tab[]){
        this.taille = taille;
        this.tab = tab;
        this.decompte = 0;
    }

    public boolean hasNext(){
        return decompte < taille;
    }

    public E next(){
        decompte++;
        return tab[decompte];
    }
}