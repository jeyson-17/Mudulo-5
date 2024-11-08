package com.mycompany.formasherencia;

import java.util.Scanner;

abstract class Formas {
    protected String color;

    public Formas(String color) {
        this.color = color;
    }

    public abstract void dibujar();
    
    public abstract double calcularArea();
}

class Circulo extends Formas {
    protected double radio;

    public Circulo(String color, double radio) {
        super(color);
        this.radio = radio;
    }

    @Override
    public void dibujar() {
        System.out.println("Dibujando un circulo de color " + color + " con radio " + radio);
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }
}

class Linea extends Formas {
    protected double largo;

    public Linea(String color, double largo) {
        super(color);
        this.largo = largo;
    }

    @Override
    public void dibujar() {
        System.out.println("Dibujando una linea de color " + color + " con largo " + largo);
    }

    @Override
    public double calcularArea() {
        return 0;
    }
}

class Triangulo extends Formas {
    protected double base;
    protected double altura;

    public Triangulo(String color, double base, double altura) {
        super(color);
        this.base = base;
        this.altura = altura;
    }

    @Override
    public void dibujar() {
        System.out.println("Dibujando un triangulo de color " + color + " con base " + base + " y altura " + altura);
    }

    @Override
    public double calcularArea() {
        return 0.5 * base * altura;
    }
}

class Cuadrado extends Formas {
    protected double lado;

    public Cuadrado(String color, double lado) {
        super(color);
        this.lado = lado;
    }

    @Override
    public void dibujar() {
        System.out.println("Dibujando un cuadrado de color " + color + " con lado " + lado);
    }

    @Override
    public double calcularArea() {
        return lado * lado;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.print("Elige una forma para dibujar (circulo, linea, triangulo, cuadrado): ");
            String tipoForma = scanner.nextLine().toLowerCase();

            Formas forma = null;

            System.out.print("Introduce el color de la forma: ");
            String color = scanner.nextLine();

            switch (tipoForma) {
                case "circulo":
                    System.out.print("Introduce el radio del circulo: ");
                    double radio = scanner.nextDouble();
                    forma = new Circulo(color, radio);
                    break;

                case "linea":
                    System.out.print("Introduce el largo de la linea: ");
                    double largo = scanner.nextDouble();
                    forma = new Linea(color, largo);
                    break;

                case "triangulo":
                    System.out.print("Introduce la base del triangulo: ");
                    double base = scanner.nextDouble();
                    System.out.print("Introduce la altura del triangulo: ");
                    double altura = scanner.nextDouble();
                    forma = new Triangulo(color, base, altura);
                    break;

                case "cuadrado":
                    System.out.print("Introduce el lado del cuadrado: ");
                    double lado = scanner.nextDouble();
                    forma = new Cuadrado(color, lado);
                    break;

                default:
                    System.out.println("Tipo de forma no reconocido.");
                    continue;
            }

            scanner.nextLine(); 

            forma.dibujar();
            System.out.println("El area de la forma es: " + forma.calcularArea());

            System.out.print("Deseas dibujar otra forma? (si/no): ");
            String respuesta = scanner.nextLine().toLowerCase();
            continuar = respuesta.equals("si");
        }

        System.out.println("Programa finalizado.");
        scanner.close();
    }
}
