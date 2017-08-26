package at.fhs.swd;

public class UML {

    public static void main(String[] args) {
        Guest g = new Guest();
        System.out.println(g.freundeEinladen());

        Restaurant r = new Restaurant();
        Chair[] s = new Chair[10];
        for (int i = 0; i < 10; i++) {
            s[i] = new Chair(i);
        }
        for (int i = 0; i < 10; i++) {
            r.addChair(s[i]);
        }
        for (int i = 0; i < 10; i++) {
            s[i] = r.removeChair();
        }
    }

}
