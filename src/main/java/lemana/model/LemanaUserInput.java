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
    private ArrayList<Auto> raceAutos;
    int maxVelocity = 0;
    Auto leader;

    public void startUserInput() {
        System.out.println("Добро пожаловать на автогонки!");
        System.out.println("Для их проведения требуются трое участников.");
        System.out.println("Oбъявите участников: ... ");

        String name;
        int velocity;
        int index = 1;

        raceAutos = new ArrayList<>();

        // Приложение умеет корректно обрабатывать невалидный ввод данных.
        // В случае невалидного ввода (нечисловое значение скорости, дробное значение скорости,
        // скорость вне допустимого диапазона от 0 до 250, пустое название автомобиля и скорость)
        // приложение выводит сообщение об ошибке и запрашивает повторный ввод данных до тех пор,
        // пока не будут введены корректные значения.
        while (raceAutos.size() < 3) {

            name = getValidInput("Введите название авто учаcтника №%d: ", index);
            velocity =  getValidInput("Укажите скорость '%s' (от 0 до 250): ", name);

            Auto raceAuto = new Auto(name, velocity);

            if (raceAutos.add(raceAuto)) {
                System.out.printf("Aвтомобиль '%s' успешно внесен " +
                        "в список участников\n", raceAuto.name);
                index++;
                if(isLeader(raceAuto)) {
                    leader = raceAuto;
                }
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

    public String getValidInput(String message, int index) {
        String input = "";
        boolean isValid = false;
        while (!isValid) {
            System.out.printf(message, index);
            input = scanner.next();
            isValid = !isEmptyValue(input);
        }
        return input;
    }

    public int getValidInput(String message, String str) {
        String input;
        int processedInput = -1;
        boolean isValid = false;
        while (!isValid) {
            System.out.printf(message, str);
            input = scanner.next();
            if (!isEmptyValue(input) && isValid(input)) {
                processedInput = Integer.parseInt(input);
            }
            isValid = isValid(processedInput);
        }
        return processedInput;
    }

    public boolean isLeader(Auto raceAuto) {
        if(raceAuto.velocity > getMaxVelocity()) {
            setMaxVelocity(raceAuto.velocity);
            return true;
        }
        return false;
    }

    public int getMaxVelocity(){
        return this.maxVelocity;
    }

    public void setMaxVelocity(int value){
        maxVelocity = value;
    }

    public Auto getLeader() {
        return this.leader;
    }

}
