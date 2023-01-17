import transport.Car;

public class Solution {
    public static void main(String[] args) {
        System.out.println("hi");

Car car = new Car("Lada",
        "Granta",
        2006,
        1.5,
        "МКПП",
        "Седан",
        5,
        "Баклажан",
        "А123ВЕ",
        "Россия",
        new Car.Key(true,true));

        System.out.println(car);

    }
}
