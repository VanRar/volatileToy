import java.util.Random;

public class Toy extends Thread {
    public static final int MAX_SLEEP_TIME_TOY = 2500;//не более, чем пауза у юзера, хотя это можно решить поднятием COUNT при выполнении условия
    private Random random = new Random();

    private volatile boolean tumbler; //false - 0 или выключен

    public Toy() {
        this.tumbler = false;
    }

    public boolean tumblerIsOn() {
        return tumbler;
    }

    public void setTumbler(boolean tumbler) {
        this.tumbler = tumbler;
    }

    @Override
    public void run() {
        while (true) {

            //без задержки сообщение от игрушки может выводиться раньше чем от пользователя, хотя значения переменной верные
            //возможно дело в функции вывода.
            try {
                Thread.sleep(random.nextInt(MAX_SLEEP_TIME_TOY));//добавил задержку, иначе получалось что вывод потока опережал поток User
            } catch (InterruptedException e) {
                break;
            }
            if (this.tumblerIsOn()) {
                this.setTumbler(false);
                switch (random.nextInt(4)) {
                    //для разнообразия, эмуляция поведения игрушки
                    case (0):
                        System.out.println("игрушка выключила тумблер");
                        continue;
                    case (1):
                        System.out.println("игрушка выключила");
                        continue;
                    case (2):
                        System.out.println("выключила тумблер");
                        continue;
                    case (3):
                        System.out.println("игрушка вывывывыключила тумблер");
                }
            }
            if (isInterrupted()) break;

        }
    }
}