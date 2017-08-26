package at.fhs.swd;

public class Guest {

    public static final double MIN = 200.0;
    public static String state = "King";
    private double amount;
    boolean hunger;
    protected String[] friends;
    public char[] alphabet;

    public boolean freundeEinladen() {
        return amount > MIN;
    }

    public Guest() {
        friends = new String[10];
        alphabet = new char[26];
        hunger = true;
        friends[0] = new String();
        for (int i = 0; i < 26; i++) {
            alphabet[i] = (char) ('a' + i);
        }
    }

    public void setAmount(double amount) {
        if (amount > 0) {
            this.amount = amount;
        }
    }

    public double getAmount() {
        return this.amount;
    }

    public static String getMINAsString() {
        return "MinAmount: " + MIN;
    }

    public void setFriend(final String friend, int pos) {
        if (pos <= 9 && pos >= 0) {
            friends[pos] = friend;
        }
    }

    protected void getBestFried(StringBuffer friend) {
        friend.append(friends[0]);
    }

    public String[] getFriends() {
        return friends;
    }

    public String getAlphabet(int start, int end) {
        StringBuffer temp = new StringBuffer();
        for (int i = start - 1; i < alphabet.length && i < end; i++) {
            temp.append(alphabet[i]);
        }
        return temp.toString();
    }

    public Dish order(Course course) {
        Cook cook = new Cook();
        Dish dish = cook.cook(course);
        return dish;
    }

    public Dish bestellt(int number) {
        Course course = new Course(number);
        Cook cook = new Cook();
        Dish dish = cook.cook(course);
        return dish;
    }

    public double pay(double d) {
        return 0.0;
    }

    public Restaurant host;

    public Guest(Restaurant r) {
        host = r;
    }
}


