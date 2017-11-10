import java.util.*;
import java.lang.Comparable;
import java.util.Collection;
import java.lang.Iterable;
import java.util.function.*;

public class TBQueue<E extends Comparable <E>> extends AbstractQueue<E> implements QueueExt<E>{

    E tab[];

    public TBQueue(int n){
        tab = (E[])(new Comparable[n]);
    }

    public TBQueue(int n, E tab[]){
        this.tab = (E[])(new Comparable[n]);
        for(int i = 1; i < tab.length; i++){
            this.tab[i] = tab[i];
        }
    }

    public boolean isEmpty(){
        for(int i = 1; i < this.tab.length; i++){
            if(this.tab[i] != null) return false;
        }
        return true;
    }

    public boolean isFull(E tab[]){
        for(int i = 1; i < tab.length; i++){
            if(tab[i] == null) return false;
        }
        return true;
    }

    public int indiceFree(E tab[]){
        for(int i = 1; i < tab.length; i++){
            if(tab[i] == null) return i;
        }
        return -1;
    }

   public boolean offer(E e){ // AJOUTE
       if(isFull(this.tab)) return false;
        else{
            int tmp = indiceFree(this.tab);
            int indTmpPere = tmp/2;
            while(tmp > 1 && e.compareTo(tab[indTmpPere]) < 0){
                indTmpPere = tmp/2;
                tmp = indTmpPere;
            }
            for(int i = indiceFree(this.tab); i > indTmpPere; i--){
                tab[i] = tab[i-1];
            }
            tab[indTmpPere] = e;
            return true;
        }
    }

    public E peek(){ // REGARDE
        return this.tab[1];
    }

    public E poll(){ // POP
        E tmp = peek();
        for(int i = 1; i < this.tab.length-1; i++){
            this.tab[i] = this.tab[i+1];
        }
        return tmp;
    }

    public int size(){
        int cmp = 0;
        for(int i =0; i < this.tab.length; i++){
            if(tab[i] != null) cmp++;
        }
        return cmp;
    }

    public Iterator<E> iterator(){
        return new IteratorTB<E>(0,this.tab);
    }

    public void affiche(){
        for(E e: tab){
            System.out.println(e);
        }
    }

    public QueueExt<E> filtre(Predicate<E> p){
        TBQueue<E> res = new TBQueue(this.tab.length);
        for(E e: this){
            if(p.test(e)) res.add(e);
        }
        return res;
    }

    public <T extends Comparable <T>> QueueExt<T> map(Function<E,T> f){
        QueueExt<T> res = new TBQueue(this.tab.length);
        for(E e: this){
            res.add(f.apply(e));
        }
        return res;
    }

    public Optional<E> trouve(Predicate<E> p){
        for(E e: this){
            if(p.test(e)) return Optional.of(e);
        }
        return Optional.empty();
    }

    public <T> T reduit(T t, BiFunction<T,E,T> f){
        T res = t;
        for(E e: this){
            res = f.apply(res,e);
        }
        return res;
    }

}