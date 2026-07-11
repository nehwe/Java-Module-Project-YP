import java.util.ArrayList;
import java.util.Scanner;

import lemana.model.Auto;
import lemana.model.LemanaUserInput;
import lemana.model.Race;

public class Main {
    public static void main(String[] args) {

        LemanaUserInput userInput = new LemanaUserInput();
        userInput.startUserInput();

        ArrayList<Auto> raceAutos = userInput.getRaceAutos();

        // После успешного ввода рассчитываем,
        // сколько километров за 24 часа
        // смог проехать каждый участник гонки (автомобиль),
        // и запоминаем лидера.
        Race race = new Race(raceAutos);
        Auto leader = race.getLeader();

        // Выводим название автомобиля-лидера в консоль
        // в любом понятном формате.
        // Например: Самая быстрая машина: Москвич.
        System.out.println(String.format("Участник на автомобиле'%s' выигрывает гонку",
                leader.name));
    }
}
