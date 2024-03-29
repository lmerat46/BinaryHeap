package src;

import java.util.*;
import java.lang.Comparable;
import java.util.function.*;
import java.util.LinkedList;


class TBDQueue<E extends Comparable<E>> extends AbstractQueue<E> implements QueueExt<E>,Iterable<E>{

    LinkedList<E[]> list;

    public TBDQueue(){
        list = new LinkedList<E[]>();
    }

    public boolean isFull(){
        for(E[] e: this.list){
            for(int i = 0; i < e.length; i++){
                if(e[i] == null) return false;
            }
        }
        return true;
    }

    public int plusPetitPere(int parcours, int i){
        int res = i;
        for(int j = 0; j < list.get(parcours).length-1; j++){
            if(list.get(parcours)[j+1].compareTo(list.get(parcours)[j]) < 0) res = j;
            else res = j+1;
        }
        return res;
    }

    public void entasser(E e, int ind, int pere){
        int parcours =list.size()-1;
        list.get(parcours)[ind] = e;
        while(parcours >= 1 && list.get(parcours)[ind].compareTo(list.get(parcours-1)[pere]) < 0){
            E tmp = list.get(parcours)[ind];
            list.get(parcours)[ind] = list.get(parcours-1)[plusPetitPere(parcours-1, pere)];
            list.get(parcours-1)[plusPetitPere(parcours-1, pere)] = tmp;
            ind = pere;
            pere = pere/2;
            parcours --;   
        }

    }

   public boolean offer(E e){ // AJOUTE
        if(list.isEmpty()){
            E tab[] = (E[])(new Comparable[1]);
            tab[0] = e;
            list.add(tab);
            return true;
        }else if(isFull()){
            E tab[] = (E[])(new Comparable[2*(list.get(list.size()-1).length)]);
            tab[0] = e;
            list.add(tab);
            entasser(e, 0, 0);
            return true;
        }else{
            int length = list.get(list.size()-1).length;
            for(int i = 0; i < length; i++){
                if(list.get(list.size()-1)[i] == null){
                    entasser(e, i, i/2);                
                    return true;
                }
            }
        }
        return false;
    }

    public E peek(){ // REGARDE
        return list.get(0)[0];
    }

    public E poll(){ // POP
        E tmp = peek();
        int i = 0;
        int j = 0;
        while(i < list.size()){
            j = 0;
            while(j < list.get(i).length){
                if(j == list.get(i).length-1){
                    list.get(i)[j] = list.get(i+1)[0];
                }
                list.get(i)[j] = list.get(i)[j+1];
                j++;
            }
            i++;
        }
        return tmp;
    }

    public int size(){
        int cmp = 0;
        for(E[] e: this.list){
            for(int i = 0; i < e.length; i++){
                if(e[i] != null) cmp++;
            }
        }
        return cmp;
    }

    public Iterator<E> iterator(){

        Iterator<E> it = new Iterator<E>() {
            int decompte = 0;
            int empla = 0;
            @Override
            public boolean hasNext() {
                return empla < list.size() && decompte < list.get(empla).length && list.get(empla)[decompte] != null;
            }

            @Override
            public E next() {
                E e = list.get(empla)[decompte];
                decompte++;
                if(decompte >= list.get(empla).length){
                    decompte = 0;
                    empla++;
                }
                    return e;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }

    public void affiche(){
        for(E e: this){
            System.out.println(e);
        }
    }

    public QueueExt<E> filtre(Predicate<E> p){
        TBDQueue<E> res = new TBDQueue();
        for(E e: this){
            if(p.test(e)) res.add(e);
        }
        return res;
    }

    public <T extends Comparable <T>> QueueExt<T> map(Function<E,T> f){
        QueueExt<T> res = new TBDQueue();
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

    public static void main (String[] args){
        TBDQueue<Integer> t = new TBDQueue<Integer>();
        for(int i = 1; i < 20;i++){
            t.offer(new Integer(i));
        }
        t.offer(new Integer(0));
        t.affiche();
        QueueExt<Integer> e = t.filtre((Integer x) -> x.intValue() > 2);
        QueueExt<Integer> z = (t.filtre((Integer x) -> x.intValue() > 10)).map(x -> x.intValue() + 1);
        for (Integer i : z) {
            System.out.println(i);
        }
    }



}