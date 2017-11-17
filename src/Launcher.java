package src;

import java.util.*;
import java.util.function.*;
import java.security.*;


class Launcher<E extends Comparable<E>>{

    public static void testQueue(Queue<Integer> list){
        SecureRandom r = new SecureRandom();
        TBQueue<Integer> view = (TBQueue<Integer>)list;
        Optional<Integer> o = Optional.empty();
        for(int i = 0; i < list.size(); i++){
            //q.offer(list.get(i));
            int tmp = r.nextInt(5);
            switch(tmp){
                case 0:
                    view = (TBQueue)view.map(x -> x.intValue() + 1);
                    break;
                case 1:
                    view = (TBQueue)view.filtre(x -> x.intValue() > 100);
                    break;
                case 2:
                    o = view.trouve(x -> x.intValue() == 5);
                    break;
                case 3:
                    int res = view.reduit(0, (a,x)-> a + x);
                    System.out.println("Reduit de view: "+res);
                    break;
                case 4:
                    System.out.println("Size de q: "+view.size());
                    break;
            }
        }
        for(Integer i: view){
            System.out.println(i);
        }
    }

    public static void testLinked(LinkedList<Integer> list){
        SecureRandom r = new SecureRandom();
        TBQueue<Integer> view = new TBQueue<Integer>(list.size());
        Optional<Integer> o = Optional.empty();
        for(int i = 0; i < list.size(); i++){
            view.offer(list.get(i));
        }
        for(int i = 0; i < list.size(); i++){
            //q.offer(list.get(i));
            int tmp = r.nextInt(5);
            switch(tmp){
                case 0:
                    view = (TBQueue)view.map(x -> x.intValue() + 1);
                    break;
                case 1:
                    view = (TBQueue)view.filtre(x -> x.intValue() > 2);
                    break;
                case 2:
                    o = view.trouve(x -> x.intValue() == 5);
                    break;
                case 3:
                    int res = view.reduit(0, (a,x)-> a + x);
                    System.out.println("Reduit de view: "+res);
                    break;
                case 4:
                    System.out.println("Size de q: "+view.size());
                    break;
            }
        }
        for(Integer i: view){
            System.out.println(i);
        }
    }

    public static void testArray(ArrayDeque<Integer> list){
        SecureRandom r = new SecureRandom();
        TBQueue<Integer> view = new TBQueue<Integer>(list.size());
        Optional<Integer> o = Optional.empty();
        for(int i = 0; i < list.size(); i++){
            view.offer(list.poll());
        }
        for(int i = 0; i < list.size(); i++){
            //q.offer(list.get(i));
            int tmp = r.nextInt(5);
            switch(tmp){
                case 0:
                    view = (TBQueue)view.map(x -> x.intValue() + 1);
                    break;
                case 1:
                    view = (TBQueue)view.filtre(x -> x.intValue() > 2);
                    break;
                case 2:
                    o = view.trouve(x -> x.intValue() == 5);
                    break;
                case 3:
                    int res = view.reduit(0, (a,x)-> a + x);
                    System.out.println("Reduit de view: "+res);
                    break;
                case 4:
                    System.out.println("Size de q: "+view.size());
                    break;
            }
        }
        for(Integer i: view){
            System.out.println(i);
        }
    }

    public static void testTBQueue(TBQueue<Integer> list){
        SecureRandom r = new SecureRandom();
        TBQueue<Integer> view = list;
        Optional<Integer> o = Optional.empty();
        for(int i = 0; i < list.size(); i++){
            int tmp = r.nextInt(5);
            switch(tmp){
                case 0:
                    view = (TBQueue)view.map(x -> x.intValue() + 1);
                    break;
                case 1:
                    view = (TBQueue)view.filtre(x -> x.intValue() > 2);
                    break;
                case 2:
                    o = view.trouve(x -> x.intValue() == 5);
                    break;
                case 3:
                    int res = view.reduit(0, (a,x)-> a + x);
                    System.out.println("Reduit de view: "+res);
                    break;
                case 4:
                    System.out.println("Size de q: "+view.size());
                    break;
            }
        }
        for(Integer i: view){
            System.out.println(i);
        }
    }

    public static void testTBDQueue(TBDQueue<Integer> list){
        SecureRandom r = new SecureRandom();
        TBDQueue<Integer> view = list;
        Optional<Integer> o = Optional.empty();
        for(int i = 0; i < list.size(); i++){
            int tmp = r.nextInt(5);
            switch(tmp){
                case 0:
                    view = (TBDQueue)view.map(x -> x.intValue() + 1);
                    break;
                case 1:
                    view = (TBDQueue)view.filtre(x -> x.intValue() > 2);
                    break;
                case 2:
                    o = view.trouve(x -> x.intValue() == 5);
                    break;
                case 3:
                    int res = view.reduit(0, (a,x)-> a + x);
                    System.out.println("Reduit de view: "+res);
                    break;
                case 4:
                    System.out.println("Size de q: "+view.size());
                    break;
            }
        }
        for(Integer i: view){
            System.out.println(i);
        }
    }

    public static void main(String [] args){
        /*
        String tab[] = {"","lundi", "mardi", "mercredi", "jeudi", "vendredi"};
        src.TBQueue test = new src.TBQueue(9, tab);
        System.out.println();
        test.offer("dimanche");
        test.offer("marmoulade");
        test.affiche();
        System.out.println("\n");
        System.out.println(test.poll()+"\n");
        test.affiche();
        
        TBDQueue test = new TBDQueue();
        test.offer("lun");
        test.offer("mer");
        test.offer("dim");
        test.offer("mar");
        test.offer("abc");
        //test.offer("a");
        System.out.println();
        test.affiche();
        System.out.println("taille de test: "+test.size());
        */
        LinkedList list = new LinkedList<Integer>();
        Queue<Integer> q = new TBQueue<Integer>(1000);
        for(int i = 0; i < 1000; i++){
            q.offer(i);
        }
        /*for(Integer i: q){
            System.out.println(i);
        }*/
        System.out.println();
        testQueue(q);
    }
}