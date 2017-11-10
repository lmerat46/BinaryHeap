class Launcher<E extends Comparable<E>>{

    public static void main(String [] args){
        /*
        String tab[] = {"","lundi", "mardi", "mercredi", "jeudi", "vendredi"};
        TBQueue test = new TBQueue(9, tab);
        System.out.println();
        test.offer("dimanche");
        test.offer("marmoulade");
        test.affiche();
        System.out.println("\n");
        System.out.println(test.poll()+"\n");
        test.affiche();
        */
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
    }
}