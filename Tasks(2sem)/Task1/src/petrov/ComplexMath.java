package petrov;

public class ComplexMath {
    public static ComplexNumber exp(ComplexNumber z) { //Вычисляет экспоненту комплексного числа
        double realPart = Math.exp(z.getReal()) * Math.cos(z.getImaginary());
        double imaginaryPart = Math.exp(z.getReal()) * Math.sin(z.getImaginary());
        return new ComplexNumber(realPart, imaginaryPart);
    }

    public static ComplexNumber sin(ComplexNumber z) { //Вычисляет синус комплексного числа
        double realPart = Math.sin(z.getReal()) * Math.cosh(z.getImaginary());
        double imaginaryPart = Math.cos(z.getReal()) * Math.sinh(z.getImaginary());
        return new ComplexNumber(realPart, imaginaryPart);
    }

    public static ComplexNumber cos(ComplexNumber z) { //Вычисляет косинус комплексного числа
        double realPart = Math.cos(z.getReal()) * Math.cosh(z.getImaginary());
        double imaginaryPart = -Math.sin(z.getReal()) * Math.sinh(z.getImaginary());
        return new ComplexNumber(realPart, imaginaryPart);
    }

    public static ComplexNumber tan(ComplexNumber z) { //Вычисляет тангенс комплексного числ
        ComplexNumber sinZ = sin(z);
        ComplexNumber cosZ = cos(z);
        return sinZ.divide(cosZ);
    }
}
