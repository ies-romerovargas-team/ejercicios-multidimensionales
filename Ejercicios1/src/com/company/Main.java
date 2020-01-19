package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] menu = {"escribeArray3x3", "rellena3x3", "RellenaAleatorio3x3", "sumaArray3x3", "escribeArrayBi",
                        "rellenaAleatorioBi", "rellenaEnordenBi", "sumaArrayBi", "suma2ArraysBi", "copiaArrayBi",
                        "copiaArrayBiPro", "rellenaArrayAjedrez", "rellenaDiagonal", "rellenaX", "rellenaCuadros" };
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        String cualquierTecla;
        int opcion; //Guardaremos la opcion del usuario
        while (!salir) {
            imprimeMenu(menu);
            try {
                System.out.print("Eliga opción: ");
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        int[][] ejercicio1 = {{100, 20, 30}, {4, -5, 6}, {-72, 8, -9}};
                        escribeArray3x3(ejercicio1);
                        break;
                    case 2:
                        int[][] ejercicio2;
                        ejercicio2 = new int[3][3];
                        rellena3x3(ejercicio2);
                        escribeArray3x3(ejercicio2);
                        break;
                    case 3:
                        int[][] ejercicio3;
                        ejercicio3 = new int[3][3];
                        RellenaAleatorio3x3(ejercicio3);
                        escribeArray3x3(ejercicio3);
                        break;
                    case 4:
                        int[][] ejercicio4;
                        ejercicio4 = new int[3][3];
                        RellenaAleatorio3x3(ejercicio4);
                        escribeArray3x3(ejercicio4);
                        System.out.println("Suma: " + sumaArray3x3(ejercicio4));
                        break;
                    case 5:
                        int[][] ejercicio5;
                        ejercicio5 = new int[3][3];
                        RellenaAleatorio3x3(ejercicio5);
                        escribeArrayBi(ejercicio5);
                        break;
                    case 6:
                        int[][] ejercicio6;
                        ejercicio6 = new int[6][5];
                        RellenaAleatorioBi(ejercicio6);
                        escribeArrayBi(ejercicio6);
                        break;
                    case 7:
                        int[][] ejercicio7;
                        ejercicio7 = new int[7][4];
                        rellenaEnordenBi(ejercicio7);
                        escribeArrayBi(ejercicio7);
                        break;
                    case 8:
                        int[][] ejercicio8;
                        ejercicio8 = new int[2][3];
                        RellenaAleatorioBi(ejercicio8);
                        escribeArrayBi(ejercicio8);
                        System.out.println("Suma: " + sumaArrayBi(ejercicio8));
                        break;
                    case 9:
                        int[][] ejercicio9_1;
                        int[][] ejercicio9_2;
                        int[][] ejercicio9_3;
                        ejercicio9_1 = new int[4][4];
                        ejercicio9_2 = new int[4][4];
                        ejercicio9_3 = new int[4][4];
                        RellenaAleatorioBi(ejercicio9_1);
                        RellenaAleatorioBi(ejercicio9_2);
                        RellenaAleatorioBi(ejercicio9_3);
                        escribeArrayBi(ejercicio9_1);
                        escribeArrayBi(ejercicio9_2);
                        escribeArrayBi(ejercicio9_3);
                        System.out.println("Suma: " + suma2ArraysBi(ejercicio9_1, ejercicio9_2, ejercicio9_3));
                        break;
                    case 10:
                        int[][] ejercicio10_1;
                        int[][] ejercicio10_2;
                        ejercicio10_1 = new int[4][5];
                        ejercicio10_2 = new int[4][5];
                        RellenaAleatorioBi(ejercicio10_1);
                        System.out.println("Original");
                        escribeArrayBi(ejercicio10_1);
                        escribeArrayBi(ejercicio10_2);
                        copiaArrayBi(ejercicio10_1, ejercicio10_2);
                        System.out.println("Procesado");
                        escribeArrayBi(ejercicio10_1);
                        escribeArrayBi(ejercicio10_2);
                        break;
                    case 11:
                        int[][] ejercicio11_1;
                        int[][] ejercicio11_2;
                        ejercicio11_1 = new int[4][5];
                        RellenaAleatorioBi(ejercicio11_1);
                        System.out.println("Original");
                        escribeArrayBi(ejercicio11_1);
                        ejercicio11_2 = copiaArrayBi(ejercicio11_1);
                        System.out.println("Procesado");
                        escribeArrayBi(ejercicio11_2);
                        break;
                    case 12:
                        int[][] ejercicio12;
                        ejercicio12 = new int[8][8];
                        rellenaArrayAjedrez(ejercicio12);
                        escribeArrayBi(ejercicio12);
                        break;
                    case 13:
                        int[][] ejercicio13;
                        ejercicio13 = new int[8][8];
                        rellenaDiagonal(ejercicio13);
                        escribeArrayBi(ejercicio13);
                        break;
                    case 14:
                        int[][] ejercicio14;
                        ejercicio14 = new int[8][8];
                        rellenaX(ejercicio14);
                        escribeArrayBi(ejercicio14);
                        break;
                    case 15:
                        int[][] ejercicio15;
                        ejercicio15 = new int[8][8];
                        rellenaCuadros(ejercicio15);
                        escribeArrayBi(ejercicio15);
                        break;
                    case 0:
                        salir = true;
                        break;
                    default:
                        System.out.println("ERROR: Opcion no válida");
                }
                if(!salir) {
                    System.out.println("Introduzca cualquier carácter + Intro para continuar:");
                    cualquierTecla = sc.next();
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Debes insertar un número");
                sc.next();
            }
        }
    }

    private static void rellenaCuadros(int[][] array)
    {
        // array bidimensional cuadrado (filas = columnas) y por
        int i, j;
        int numFilas = array.length;
        int mitad = numFilas / 2;
        for(i = 0; i < numFilas; i++)
        {
            for(j = 0; j < numFilas; j++)
            {
                if(i < mitad && j < mitad)
                {
                    array[i][j] = 1;
                }
                else if(i < mitad && j >= mitad)
                {
                    array[i][j] = 2;
                }
                else if(i >= mitad && j < mitad)
                {
                    array[i][j] = 3;
                }
                else if(i >= mitad && j >= mitad)
                {
                    array[i][j] = 4;
                }
            }
        }
    }

    private static void rellenaX(int[][] array)
    {
        int i, j;
        int numFilas = array.length;
        for(i = 0; i < numFilas; i++)
        {
            for(j = 0; j < numFilas; j++)
            {
                if(i == j)
                {
                    array[i][j] = 1;
                }
                else if(i + j == numFilas - 1)
                {
                    array[i][j] = 1;
                }
                else {
                    array[i][j] = 2;
                }

            }
        }
    }

    private static void rellenaDiagonal(int[][] array)
    {
        int i, j;
        int numFilas = array.length;
        for(i = 0; i < numFilas; i++)
        {
            for(j = 0; j < numFilas; j++)
            {
                if(i == j) array[i][j] = 1;
                if(i < j) array[i][j] = 2;
                if(i > j) array[i][j] = 3;
            }
        }
    }

    private static void rellenaArrayAjedrez(int[][] array)
    {
        int i, j;
        int color = 1;
        for(i = 0; i < 8; i++)
        {
            for(j = 0; j < 8; j++)
            {
                array[i][j] = color;
                color = color==1 ? 0 : 1;
            }
            color = color==1 ? 0 : 1;
        }
    }

    private static int[][] copiaArrayBi(int[][] array1)
    {
        int[][] copia;
        int i, j;
        int numFilas = array1.length;
        int numCols = array1[0].length;
        copia = new int[numFilas][numCols];
        for(i = 0; i < numFilas; i++)
        {
            for(j = 0; j < numCols; j++)
            {
                copia[i][j] = array1[i][j];
            }
        }
        return copia;
    }

    private static void copiaArrayBi(int[][] array1, int[][] array2)
    {
        int i, j;
        int numFilas = array1.length;
        int numCols = array1[0].length;
        for(i = 0; i < numFilas; i++)
        {
            for(j = 0; j < numCols; j++)
            {
                array2[i][j] = array1[i][j];
            }
        }
    }

    private static int suma2ArraysBi(int[][] array1, int[][] array2, int[][] array3)
    {
        // Suma los elementos de 3 arrays bidimensionales de idénticas dimensiones
        int i, j, suma = 0;
        int numFilas = array1.length;
        int numCols = array1[0].length;
        for(i = 0; i < numFilas; i++)
        {
            for(j = 0; j < numCols; j++)
            {
                suma += array1[i][j];
                suma += array2[i][j];
                suma += array3[i][j];
            }
        }
        return suma;
    }

    private static int sumaArrayBi(int[][] array)
    {
        int i, j, suma = 0;
        int numFilas = array.length;
        int numCols = array[0].length;
        for(i = 0; i < numFilas; i++)
        {
            for(j = 0; j < numCols; j++)
            {
                suma += array[i][j];
            }
        }
        return suma;
    }

    public static void rellenaEnordenBi(int[][] array)
    {
        int i, j, cont = 1;
        int numFilas = array.length;
        int numCols = array[0].length;
        for(i = 0; i < numFilas; i++)
        {
            for(j = 0; j < numCols; j++)
            {
                array[i][j] = cont;
                cont++;
            }
        }
    }

    public static void RellenaAleatorioBi(int[][] array)
    {
        Random r = new Random();
        int i, j;
        int numFilas = array.length;
        int numCols = array[0].length;
        for(i = 0; i < numFilas; i++)
        {
            for(j = 0; j < numCols; j++)
            {
                // Números aleatorios desde el -50 al 50
                array[i][j] = r.nextInt(101) - 50;
            }
        }
    }

    public static void escribeArrayBi(int[][] array)
    {
        // Esta función escribe correctamente tabulados los valores comprendidos entre -99 y 999
        int i, j;
        int numFilas = array.length;
        int numCols = array[0].length;
        for (i = 0; i < numFilas; i++)
        {
            for (j = 0; j < numCols; j++)
            {
                if (i == 0 && j == 0) // primera fila
                {
                    System.out.print("╔");
                }
                else if (i == numFilas - 1 && j == 0) // ultima fila
                {
                    System.out.print("╚");
                }
                else if (j == 0)
                {
                    System.out.print("║");
                }
                // asumimos un máximo de 3 espacios para cada número
                if(array[i][j]<100 && array[i][j]> -100) System.out.print(" ");
                if(array[i][j]<10 && array[i][j]> -10) System.out.print(" ");
                if(array[i][j]>=0) System.out.print(" ");
                System.out.print(array[i][j]);
                System.out.print(" ");

                if (i == 0 && j == numCols - 1) // ultima fila
                {
                    System.out.print("╗");
                }
                else if (i == numFilas - 1 && j == numCols - 1) // ultima fila
                {
                    System.out.print("╝");
                }
                else if (j == numCols - 1)
                {
                    System.out.print("║");
                }
            }
            System.out.println();
        }
    }

    public static int sumaArray3x3(int[][] array)
    {
        int i, j, suma = 0;
        for(i = 0; i < 3; i++)
        {
            for(j = 0; j < 3; j++)
            {
                suma += array[i][j];
            }
        }
        return suma;
    }

    public static void RellenaAleatorio3x3(int[][] array)
    {
        Random r = new Random();
        int i, j;
        for(i = 0; i < 3; i++)
        {
            for(j = 0; j < 3; j++)
            {
                // Números aleatorios desde el -50 al 50
                array[i][j] = r.nextInt(101) - 50;
            }
        }
    }

    public static void rellena3x3(int[][] array)
    {
        int i, j, cont = 1;
        for(i = 0; i < 3; i++)
        {
            for(j = 0; j < 3; j++)
            {
             array[i][j] = cont;
             cont++;
            }
        }
    }

    public static void escribeArray3x3(int[][] array3x3)
    {
        // Esta función escribe correctamente tabulados los valores comprendidos entre -99 y 999
        int i, j;
        for (i = 0; i < 3; i++)
        {
            for (j = 0; j < 3; j++)
            {
                if (i == 0 && j == 0) // primera fila
                {
                    System.out.print("╔");
                }
                else if (i == 2 && j == 0) // ultima fila
                {
                    System.out.print("╚");
                }
                else if (j == 0)
                {
                    System.out.print("║");
                }
                // asumimos un máximo de 3 espacios para cada número
                if(array3x3[i][j]<100 && array3x3[i][j]> -100) System.out.print(" ");
                if(array3x3[i][j]<10 && array3x3[i][j]> -10) System.out.print(" ");
                if(array3x3[i][j]>=0) System.out.print(" ");
                System.out.print(array3x3[i][j]);
                System.out.print(" ");

                if (i == 0 && j == 2) // ultima fila
                {
                    System.out.print("╗");
                }
                else if (i == 2 && j == 2) // ultima fila
                {
                    System.out.print("╝");
                }
                else if (j == 2)
                {
                    System.out.print("║");
                }
            }
            System.out.println();
        }
    }

    public static void imprimeMenu(String[] opciones)
    {
        System.out.println("╔══════════════════════════════════╗");
        System.out.println("║              M E N U             ║");
        System.out.println("╠══════════════════════════════════╣");
        for (int i = 1; i <= opciones.length; i++)
        {
            System.out.print("║");
            if(i < 10) System.out.print(" ");
            System.out.print(i + ". " + opciones[i-1]);
            for (int j = 0; j < 30 - opciones[i-1].length(); j++) {
                System.out.print(" ");
            }
            System.out.print("║");
            System.out.println();
        }
        System.out.println("╠══════════════════════════════════╣");
        //System.out.print("\u001B[101m" + "\u001B[97m");
        System.out.println("║ 0. Salir                         ║");
        //System.out.println("\u001B[0m");
        System.out.println("╚══════════════════════════════════╝");
    }
}
