package org.example.observer;

public class ObserverImpl2 implements Observer{
    int count;
    @Override
    public void update(Observable observable) {
        int state = ((ObservableImpl)observable).getState();
        if (state %2 == 0) {
            ++count;
        }
        System.out.println("******* ObserverImpl2 ***********");
        System.out.println(" Nouvelle mise à jour: state = " + state);
        System.out.println("Résultat de calcule: " + ((state%2)==0 ? "Pair" : "Impaire"));
        System.out.println(" Le compteur est: " + count);
        System.out.println("**********************************");
    }
    public void updatePush(int state) {

        if (state %2 == 0) {
            ++count;
        }
        System.out.println("******* ObserverImpl2 ***********");
        System.out.println(" Nouvelle mise à jour: state = " + state);
        System.out.println("Résultat de calcule: " + ((state%2)==0 ? "Pair" : "Impaire"));
        System.out.println(" Le compteur est: " + count);
        System.out.println("**********************************");
    }
}
