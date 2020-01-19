package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] menu = {"invierteBi", "calculaDeterminante", "cuadradoMagico", "compruebaSudoku", "hundirLaFlota"};
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        String cualquierTecla;
        int opcion; //Guardamos la opcion del usuario
        while (!salir) {
            imprimeMenu(menu);
            try {
                System.out.print("Eliga opción: ");
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        int[][] ejercicio1;
                        ejercicio1 = new int[5][5];
                        RellenaAleatorioBi(ejercicio1);
                        escribeArrayBi(ejercicio1);
                        invierteBi(ejercicio1);
                        escribeArrayBi(ejercicio1);
                        break;
                    case 2:
                        int[][] ejercicio2;
                        ejercicio2 = new int[3][3];
                        RellenaAleatorioBi(ejercicio2);
                        escribeArrayBi(ejercicio2);
                        System.out.println("Determinante: " + calculaDeterminante(ejercicio2));
                        break;
                    case 3:
                        int[][] ejercicio3 = {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}};
                        escribeArrayBi(ejercicio3);
                        if(cuadradoMagico(ejercicio3))
                        {
                            System.out.println("Es un cuadrado mágico");
                        }
                        else
                        {
                            System.out.println("No es un cuadrado mágico");
                        }
                        break;
                    case 4:
                        // Sudoku correcto
                        int[][] ejercicio4 = {{5, 7, 6, 9, 8, 3, 1, 4, 2}, {4, 8, 9, 5, 1, 2, 6, 7, 3}, {1, 2, 3, 4, 6, 7, 8, 5, 9},
                                              {6, 5, 2, 1, 3, 4 ,9, 8, 7}, {8, 9, 4, 6, 7, 5, 2, 3, 1}, {3, 1, 7, 2, 9, 8, 4, 6, 5},
                                              {7, 4, 1, 3, 2, 6, 5, 9, 8}, {2, 3, 5, 8, 4, 9, 7, 1, 6}, {9, 6, 8, 7, 5, 1, 3, 2, 4}};
                        // Sudoku incorrecto
                        /* int[][] ejercicio4 = {{5, 7, 6, 9, 8, 3, 1, 4, 2}, {4, 8, 9, 5, 1, 2, 6, 7, 3}, {1, 2, 3, 4, 6, 7, 8, 5, 9},
                                              {6, 5, 2, 1, 3, 4 ,9, 8, 7}, {8, 9, 4, 6, 7, 5, 9, 3, 1}, {3, 1, 7, 2, 9, 8, 4, 6, 5},
                                              {7, 4, 1, 3, 2, 6, 5, 9, 8}, {2, 3, 5, 8, 4, 9, 7, 1, 6}, {9, 6, 8, 7, 3, 1, 3, 2, 4}};
                         */
                        escribeArrayBi(ejercicio4);
                        if(compruebaSudoku(ejercicio4))
                        {
                            System.out.println("Sudoku Correcto ☺");
                        }
                        else
                        {
                            System.out.println("Sudoku incorrecto");
                        }
                        break;
                    case 5:
                        int[][] ejercicio5 = {{0, 0, 0, 0, 0, 1, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 1},
                                              {1, 0, 1, 1, 1, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0, 1, 0},
                                              {1, 1, 0, 0, 1, 0, 1, 0}, {0, 0, 0, 0, 0, 0, 0, 0}};
                        while(quedanBarcos(ejercicio5))
                        {
                            imprimeBarcos(ejercicio5);
                            System.out.println("Introduzca disparo tecleando coordenadas (A1): ");
                            String a = sc.next();
                            disparaBarco(ejercicio5, a);
                        }
                        System.out.println("    FIN DE LA PARTIDA");
                        imprimeBarcos(ejercicio5);
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

    private static void disparaBarco(int[][] array, String a)
    {
        // efecto visual desplazamiento de lineas de consola
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        String ANSI_GREEN="\u001B[32m";
        String ANSI_RED="\u001B[31m";
        String ANSI_RESET="\u001B[0m";
        char columna = a.charAt(0);
        String fila = a.substring(1);
        int col = (int)columna - 65;
        int fil = Integer.parseInt(fila) - 1;
        if (col < 0 || col > 7 || fil < 0 || fil > 7)
        {
            System.out.println(ANSI_RED + "    COORDENADAS INCORRECTAS" + ANSI_RESET);
        }
        else {
            int valor = array[fil][col];
            if (valor == 0) {
                array[fil][col] = 100;
                System.out.println(ANSI_GREEN + "    AGUA" + ANSI_RESET);
            }
            if (valor == 1) {
                array[fil][col] = 101;
                if (compruebaHundido(array, fil, col)) {
                    System.out.println(ANSI_RED + "    TOCADO Y HUNDIDO" + ANSI_RESET);
                } else {
                    System.out.println(ANSI_RED + "    TOCADO" + ANSI_RESET);
                }
            }
        }
    }

    private static boolean compruebaHundido(int[][] array, int fil, int col)
    {
        // hacia arriba desde fil
        if(fil > 0)
        {
            for (int i = fil; i > 0; i--) {
                if (array[i][col] == 1) return false;
                if (array[i][col] == 0) i = 0;
            }
        }
        // hacia abajo desde fil
        if(fil < 8)
        {
            for (int i = fil; i < 8; i++) {
                if (array[i][col] == 1) return false;
                if (array[i][col] == 0) i = 8;
            }
        }
        // hacia la izquierda desde col
        if(col > 0)
        {
            for (int i = col; i > 0; i--) {
                if (array[fil][i] == 1) return false;
                if (array[fil][i] == 0) i = 0;
            }
        }
        // hacia la derecha desde col
        if(col < 8)
        {
            for (int i = col; i < 8; i++) {
                if (array[fil][i] == 1) return false;
                if (array[fil][i] == 0) i = 8;
            }
        }
        return true;
    }

    private static void imprimeBarcos(int[][] array)
    {
        String ANSI_RED="\u001B[31m";
        String ANSI_RESET="\u001B[0m";
        int i, j;
        System.out.println("   A    B   C   D   E   F   G   H");
        System.out.println("  ┌───┬───┬───┬───┬───┬───┬───┬───┐");
        for(i = 0; i < 8; i++)
        {
            System.out.print(i + 1 + " │");
            for(j = 0; j < 8; j++)
            {
                switch (array[i][j])
                {
                        case 100:
                            System.out.print(" · │");
                            break;
                        case 101:
                            System.out.print(ANSI_RED + " x" + ANSI_RESET + " │");
                            break;
                        default:
                            System.out.print("   │");
                }
            }
            System.out.println();
            if(i < 7)
            {
                System.out.println("  ├───┼───┼───┼───┼───┼───┼───┼───┤");
            }
            else
            {
                System.out.println("  └───┴───┴───┴───┴───┴───┴───┴───┘");
            }
        }
    }

    private static boolean quedanBarcos(int[][] array)
    {
        int i, j;
        for(i = 0; i < 8; i++)
        {
            for(j = 0; j < 8; j++)
            {
                if(array[i][j] == 1)
                {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean compruebaArray19(int[] array)
    {
        int i, j;
        // búsqueda de repetidos
        List<Integer> compruebaRepetidos;
        compruebaRepetidos = new ArrayList<>();
        for(i = 0; i < 9; i++) {
            if (compruebaRepetidos.contains(array[i]))
            {
                return false;
            }
            compruebaRepetidos.add(array[i]);
        }
        return true;
    }

    private static boolean compruebaSudoku(int[][] array)
    {
        int[] auxiliar;
        int i, j;
        int numFilas = array.length;
        auxiliar = new int[9];
        // filas
        for(i = 0; i < 9; i++)
        {
            for(j = 0; j < 9; j++)
            {
                auxiliar[j] = array[i][j];
            }
            if(!compruebaArray19(auxiliar))
            {
                return false;
            }
        }
        // columnnas
        for(i = 0; i < 9; i++)
        {
            for(j = 0; j < 9; j++)
            {
                auxiliar[j] = array[j][i];
            }
            if(!compruebaArray19(auxiliar))
            {
                return false;
            }
        }
        //submatrices
        int cont;
        for(i = 0; i <=6 ; i = i + 3)
        {
            cont = 0;
            for(j = 0; j <=6; j = j + 3) {
                auxiliar[cont++] = array[i][j];
                auxiliar[cont++] = array[i][j + 1];
                auxiliar[cont++] = array[i][j + 2];
                //
                auxiliar[cont++] = array[i + 1][j];
                auxiliar[cont++] = array[i + 1][j + 1];
                auxiliar[cont++] = array[i + 1][j + 2];
                //
                auxiliar[cont++] = array[i + 2][j];
                auxiliar[cont++] = array[i + 2][j + 1];
                auxiliar[cont] = array[i + 2][j + 2];
                if(!compruebaArray19(auxiliar))
                {
                    return false;
                }
                cont = 0;
            }
        }
        return true;
    }

    private static boolean cuadradoMagico(int[][] array)
    {
        int i, j, cont = 0;
        int[] sumas = new int[8];
        int sumando;
        //filas
        for(i = 0; i < 3; i++)
        {
            sumando = 0;
            for (j = 0; j < 3; j++) {
                sumando += array[i][j];
            }
            sumas[cont] = sumando;
            cont++;
        }
        //columnas
        for(i = 0; i < 3; i++)
        {
            sumando = 0;
            for (j = 0; j < 3; j++) {
                sumando += array[j][i];
            }
            sumas[cont] = sumando;
            cont++;
        }
        // diagonal1
        sumas[6] = array[0][0] + array[1][1] + array[2][2];
        sumas[7] = array[0][2] + array[1][1] + array[2][0];
        for(i = 1; i < 8; i++)
        {
            if(sumas[i]!=sumas[0]) {
                return false;
            }
        }
        // búsqueda de repetidos
        List<Integer> compruebaRepetidos;
        compruebaRepetidos = new ArrayList<>();
        for(i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                if (compruebaRepetidos.contains(array[i][j]))
                {
                    return false;
                }
                compruebaRepetidos.add(array[i][j]);
            }

        }
        return true;
    }

    private static int calculaDeterminante(int[][] array)
    {
        // Los determinantes 3x3 se resuelven directamente aplicando la regla de Sarrus
        int calc = 1;
        int i, j;
        //sumas
        calc = array[0][0] * array[1][1] * array[2][2];
        calc += array[0][1] * array[1][2] * array[2][0];
        calc += array[0][2] * array[1][0] * array[2][1];
        //restas
        calc -= array[0][2] * array[1][1] * array[2][0];
        calc -= array[0][1] * array[1][0] * array[2][1];
        calc -= array[0][0] * array[1][2] * array[2][1];
        return calc;
    }

    private static void invierteBi(int[][] array)
    {
        int[][] auxiliar;
        int i, j;
        int numFilas = array.length;
        auxiliar = new int[numFilas][numFilas];
        for(i = 0; i < numFilas; i++) {
            for (j = 0; j < numFilas; j++) {
                auxiliar[i][j] = array[j][i];
            }
        }
        // sobreescribir
        for(i = 0; i < numFilas; i++) {
            for (j = 0; j < numFilas; j++) {
                array[i][j] = auxiliar[i][j];
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
