package at.fhs.swd;

class WollWaschmittel extends Waschmittel {

    public void reinigen() {
        super.reinigen();
        System.out.println("Reinigung durch WollWaschmittel");
    }

    public void wollePflegen() {
        System.out.println("WollPflege durch WollWaschmittel");
    }
}
