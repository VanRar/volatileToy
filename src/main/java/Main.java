public class Main {
    public static void main(String[] args) {

        //создаем наши классы
        Toy toy = new Toy();
        User user = new User("Майкл", toy);

        //запускаем потоки
        toy.start();
        user.start();

        //завершаем потоки
        try {
            user.join();
            Thread.sleep(Toy.MAX_SLEEP_TIME_TOY); //выделим время время на закрытие коробки
            toy.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}