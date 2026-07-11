// Алиса AI подсказала вариант с использованием регулярных выражений
// для проверки валидности ввода пользователя
package lemana.model;

import java.util.ArrayList;
import java.util.Scanner;

public class LemanaUserInput {
    // Запрашиваем у пользователя 3 автомобиля,
    // каждый из которых имеет два параметра:
    // название и скорость.
    Scanner scanner = new Scanner(System.in);
    private ArrayList<Auto> raceAutos = new ArrayList<>();

    public void startUserInput() {
        System.out.println("Добро пожаловать на автогонки!");
        System.out.println("Для их проведения требуются трое участников.");
        System.out.println("Oбъявите участников: ... ");

        String name = "";
        String velocityValue = "";
        int velocity;
        int index = 1;

        // Приложение умеет корректно обрабатывать невалидный ввод данных.
        // В случае невалидного ввода (нечисловое значение скорости, дробное значение скорости,
        // скорость вне допустимого диапазона от 0 до 250, пустое название автомобиля и скорость)
        // приложение выводит сообщение об ошибке и запрашивает повторный ввод данных до тех пор,
        // пока не будут введены корректные значения.
        while (true) {

            if (raceAutos.size() >= 3) {
                break;
            }

            while (true) {
                System.out.printf("Введите название авто учаcтника №%d: ", index);
                name = scanner.next();
                if (!isEmptyValue(name)) {
                    break;
                }
            }

            while (true) {
                System.out.printf("Укажите скорость '%s' (от 0 до 250): ", name);
                velocityValue = scanner.next();
                if (!isEmptyValue(velocityValue) && isValid(velocityValue)) {
                    velocity = Integer.parseInt(velocityValue);
                    if (isValid(velocity)) {
                        break;
                    }
                }
            }

            Auto raceAuto = new Auto(name, velocity);

            if (raceAutos.add(raceAuto)) {
                System.out.println(String.format("Aвтомобиль '%s' успешно внесен " +
                        "в список участников", raceAuto.name));
                index++;
            } else {
                System.out.println("Что-то пошло не так, участник не в списке");
            }

        }
        scanner.close();
    }

    public ArrayList<Auto> getRaceAutos() {
        return raceAutos;
    }

    // Проверяем ввод на валидность
    public boolean isValid(String userInput){
        if (!userInput.matches("-?\\d+(\\.\\d+)?")) {
            System.out.println("Невалидный ввод: нечисловое значение скорости.");
            return false;
        } else if (!userInput.matches("-?\\d+")) {
            System.out.println("Невалидный ввод: дробное значение скорости.");
            return false;
        } else {
            return true;
        }
    }

    public boolean isValid(int userInput){
        if (userInput > 0 && userInput < 251) {
            return true;
        } else {
            System.out.println("Невалидный ввод: скорость превышает допустимый диапазон.");
            return false;
        }
    }

    public boolean isEmptyValue(String userInput) {
        if (userInput.trim().isEmpty()) {
            System.out.println("Невалидный ввод: пустое значение.");
            return true;
        } else  {
            return false;
        }
    }
}
