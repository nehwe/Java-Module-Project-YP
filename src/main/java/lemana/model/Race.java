package lemana.model;

import java.util.ArrayList;
import java.util.Iterator;

// Гонка – класс, в котором рассчитывается и запоминается лидер.
public class Race {

    private Auto leader;
    private ArrayList<Auto> raceAutos;
    // длительность гонки 24 часа
    private int raceTime = 24;

    public Race(ArrayList<Auto> raceAutos) {
        this.raceAutos = raceAutos;
    }

    // запомним лидера
    public Auto getLeader() {

        int maxDistance = 0;

        for (Auto raceAuto : raceAutos) {
            int distance = getDistanceForRaceAuto(raceAuto);
            if(distance > maxDistance) {
                maxDistance = distance;
                leader = raceAuto;
            }
        }
        return leader;
    }

    // путь пройденный участником(авто) за 24 часа;
    public int getDistanceForRaceAuto(Auto raceAuto) {
        int distance = raceAuto.velocity * raceTime;
        System.out.println(String.format("Авто '%s' за %d часа проехал %d км.",
                raceAuto.name, raceTime, distance));
        return distance;
    }
}
