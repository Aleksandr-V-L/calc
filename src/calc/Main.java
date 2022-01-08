package calc;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Input: ");
            String line = scanner.nextLine();

            if (line.equals("exit")) {
                break;
            }

            try {
                String[] symbols = line.split(" ");
                if (symbols.length < 3) throw new Exception("строка не является математической операцией");
                if (symbols.length > 3) throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                Number firstNumber = NumberService.parseAndValidate(symbols[0]);
                Number secondNumber = NumberService.parseAndValidate(symbols[2], firstNumber.getType());
                String result = ActionService.calculate(firstNumber, secondNumber, symbols[1]);
                System.out.println("Output: \n" + result);

            } catch (Exception e) {
                System.out.println(e.getMessage());
                break;
            }

        }

        scanner.close();
    }

}