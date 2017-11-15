package src;

import java.util.function.*;
import java.util.*;

interface QueueExt<E> extends Queue<E>{

    QueueExt<E> filtre(Predicate<E> p);
    <T extends Comparable<T>> QueueExt<T> map(Function<E,T> f);
    Optional<E> trouve(Predicate<E> p);
    <T> T reduit(T t, BiFunction<T,E,T> f);
    boolean offer(E e);
    E peek();
    E poll();
    int size();
    Iterator<E> iterator();
    void affiche();

}