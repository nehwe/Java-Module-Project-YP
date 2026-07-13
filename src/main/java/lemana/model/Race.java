package lemana.model;

import java.util.ArrayList;

// Гонка – класс, в котором рассчитывается и запоминается лидер.
public class Race {

    final ArrayList<Auto> raceAutos;
    // длительность гонки 24 часа
    final int raceTime = 24;

    public Race(ArrayList<Auto> raceAutos) {
        this.raceAutos = raceAutos;
    }

    // путь пройденный участником(авто) за 24 часа;
    public void getDistanceForRaceAuto(Auto raceAuto) {
        int distance = raceAuto.velocity * raceTime;
        System.out.printf("\nАвто '%s' за %d часа проехал %d км.",
                raceAuto.name, raceTime, distance);
    }
}
