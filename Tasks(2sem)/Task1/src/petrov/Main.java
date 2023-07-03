package petrov;

public class Main {
    public static final String START_TEXT = "Task 1(3). Petrov Artem group 1.1 \n\nКласс для описания комплексных чисел. Реализовать основные арифметические\n" +
            "операции для комплексных чисел. Дополнительно реализовать аналог класса Math для\n" +
            "комплексных чисел с несколькими тригонометрическими функциями (в реализации\n" +
            "можно использовать стандартный класс Math).\n";

    public static void startProgram() {
        System.out.printf(START_TEXT);
    }

    public static void print(String text) {
        System.out.print(text);
    }


    public static void main(String[] args) {
        startProgram();
        ComplexNumber z1 = new ComplexNumber(2, 3);
        ComplexNumber z2 = new ComplexNumber(-1, 2);
        ComplexNumber z3 = new ComplexNumber(343, 712);
        ComplexNumber z4 = new ComplexNumber(511, -111);

        ComplexNumber sum = z1.add(z2);
        System.out.println("Sum: " + sum.getReal() + " + " + sum.getImaginary() + "i");

        ComplexNumber subtraction = z1.subtract(z2);
        System.out.println("Subtraction: " + subtraction.getReal() + " + " + subtraction.getImaginary() + "i");

        ComplexNumber product = z1.multiply(z2);
        System.out.println("Product: " + product.getReal() + " + " + product.getImaginary() + "i");

        double magnitude = z1.getMagnitude();
        System.out.println("Magnitude: " + magnitude);

        double phase = z1.getPhase();
        System.out.println("Phase: " + phase);

        ComplexNumber expZ = ComplexMath.exp(z1);
        System.out.println("exp(z1): " + expZ.getReal() + " + " + expZ.getImaginary() + "i");

        ComplexNumber sinZ = ComplexMath.sin(z1);
        System.out.println("sin(z1): " + sinZ.getReal() + " + " + sinZ.getImaginary() + "i");

        ComplexNumber cosZ = ComplexMath.cos(z1);
        System.out.println("cos(z1): " + cosZ.getReal() + " + " + cosZ.getImaginary() + "i");

        ComplexNumber tanZ = ComplexMath.tan(z1);
        System.out.println("tan(z1): " + tanZ.getReal() + " + " + tanZ.getImaginary() + "i");

        ComplexNumber q = z3.divide(z4);
        ComplexNumber v = q.multiply(z4);
        ComplexNumber e = z3.subtract(v);
        System.out.print(e.getReal() + " + " + e.getImaginary() + "i");

    }
}