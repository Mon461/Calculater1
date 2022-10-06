package Calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        //Конвертируем арабские и римские числа
        Converter converter = new Converter();
        String[] actions = {"+", "-", "/", "*"};
        String[] regexActions = {"\\+", "-", "/", "\\*"};
        Scanner scn = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String exp = scn.nextLine();
        //Определяем арифметическое действие:
        int actionIndex=-1;
        for (int i = 0; i < actions.length; i++) {
            if(exp.contains(actions[i])){
                actionIndex = i;
                break;
            }
        }
        //Если не возможно выполнить арифметическое действие, завершаем программу
        if(actionIndex==-1){
            System.out.println("Некорректное выражение");
            return;
        }
        //Делим строчку по найденному арифметическому знаку


        String[] data = exp.split(regexActions[actionIndex]);
        //Определяем, находятся ли числа в одном формате (оба римские или оба арабские)
        if(converter.Ilya(data[0]) == converter.Ilya(data[1])){
            int a = 10;
            int b = 10;
            //Определяем, римские ли это числа
            boolean Ilya = converter.Ilya(data[0]);

            if(Ilya){
                //если римские, то конвертируем их в арабские
                a = converter.romanToInt(data[0]);
                b = converter.romanToInt(data[1]);

            }else{
                //если арабские, конвертируем их из строки в число
                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);
            }
            // Проверка арабских и римских чисел на ввод больше или меньше 10
            if(a>10){
                System.out.println("Запрещено вводить число больше 10");
                return;
            }else {
                System.out.println("Ответ");
            }
            if(b>10){
                System.out.println("Запрещено вводить число больше 10");
                return;
            }else {
                System.out.println();
            }

            //выполняем с числами арифметическое действие
            int result;
            switch (actions[actionIndex]) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                default:
                    result = a / b;
                    break;
            }
            //15->XV
            if(Ilya){
                //если числа были римские, возвращаем результат в римском числе
                System.out.println(converter.Ilya(result));
            }
            else{
                //если числа были арабские, возвращаем результат в арабском числе
                System.out.println(result);
            }
        }else{
            System.out.println("Числа должны быть в одном формате");
        }

    }
}
