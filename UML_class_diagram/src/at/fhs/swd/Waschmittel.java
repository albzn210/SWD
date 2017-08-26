package at.fhs.swd;

import java.util.ArrayList;

class Waschmittel {

    public String farbe;
    protected int pulvergroesse;
    private ArrayList bestandteil;

    public Waschmittel() {
        farbe = new String("Weiss");
        pulvergroesse = 3;
        bestandteil = new ArrayList();
        bestandteil.add("Waschpulver");
    }

    public void reinigen() {
        System.out.println("Reinigung durch Waschmittel");
    }
}
