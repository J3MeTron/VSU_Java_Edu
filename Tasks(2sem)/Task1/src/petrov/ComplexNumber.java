package petrov;

import java.lang.Math;

public class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public ComplexNumber add(ComplexNumber other) { //Складывает текущее комплексное число с другим комплексным числом
        double newReal = this.real + other.real;
        double newImaginary = this.imaginary + other.imaginary;
        return new ComplexNumber(newReal, newImaginary);
    }

    public ComplexNumber subtract(ComplexNumber other) { //Вычитает из текущего комплексного числа другое комплексное число
        double newReal = this.real - other.real;
        double newImaginary = this.imaginary - other.imaginary;
        return new ComplexNumber(newReal, newImaginary);
    }

    public ComplexNumber multiply(ComplexNumber other) { //Умножает текущее комплексное число на другое комплексное число
        double newReal = this.real * other.real - this.imaginary * other.imaginary;
        double newImaginary = this.real * other.imaginary + this.imaginary * other.real;
        return new ComplexNumber(newReal, newImaginary);
    }

    public ComplexNumber divide(ComplexNumber other) { //Делит текущее комплексное число на другое комплексное число
        double denominator = other.real * other.real + other.imaginary * other.imaginary;
        double newReal = (this.real * other.real + this.imaginary * other.imaginary) / denominator;
        double newImaginary = (this.imaginary * other.real - this.real * other.imaginary) / denominator;
        return new ComplexNumber(newReal, newImaginary);
    }

    public double getMagnitude() { //Вычисляет модуль (или абсолютное значение) комплексного числа
        return Math.sqrt(real * real + imaginary * imaginary);
    }

    public double getPhase() { //Вычисляет аргумент (или фазу) комплексного числа
        return Math.atan2(imaginary, real);
    }
}
