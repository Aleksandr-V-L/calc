package calc;

public class ArithmeticOperation {

    public static String calculate(Number first, Number second, String action) throws Exception {

        int result = switch (action) {
            case "+" -> first.getValue() + second.getValue();
            case "-" -> first.getValue() - second.getValue();
            case "*" -> first.getValue() * second.getValue();
            case "/" -> first.getValue() / second.getValue();
            default -> throw new Exception("Не правильно введен символ операции, используйте только +, -, *, /");
        };

        if (first.getType() == NumberType.ROMAN) {
            if (result < 1) throw new Exception("В римской системе нет 0 и отрицательных чисел");
            return NumberProcessing.toRomanNumber(result);
        } else return String.valueOf(result);

    }

}