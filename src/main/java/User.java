public class User extends Thread {
    public static final int SLEEP_TIME = 3000;
    private static int COUNT = 5;
    private String name;
    private Toy toy;

    public User(String name, Toy toy) {
        this.name = name;
        this.toy = toy;

    }

    @Override
    public void run() {
        while (COUNT != 0) {
            try {
                Thread.sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (!toy.tumblerIsOn()) {
                toy.setTumbler(true);
                System.out.println("пользователь " + name + ", нажал вкл.");
                COUNT -= 1;
            }
        }
    }
}