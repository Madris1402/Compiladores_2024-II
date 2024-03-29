package fes.aragon.tareas.tarea05;

import javax.swing.*;

import  java.lang.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Automata1 {

        private int indice=0;
        private String cadena="";
        private final int error=-1;
        private final int aceptado=1;


        public static void main(String[] args) {
            Automata1 app=new Automata1();

            // Leer Archivos
            Scanner scanner = new Scanner(System.in);
            System.out.println("Buscar Nombre del Archivo: ");
            String archivo = scanner.nextLine();

            ArrayList<String> palabras = new ArrayList<>();
            File f = new File(System.getProperty("user.dir") + File.separator + "files" + File.separator +  archivo);
            if (f.exists()) {
                System.out.println("Archivo encontrado");
                System.out.println("Contenido: ");

                try {
                    BufferedReader obj = new BufferedReader(new FileReader(f));
                    String palabra;
                    while ((palabra = obj.readLine()) != null){
                        if (!palabra.trim().isEmpty()) {
                            palabras.add(palabra);
                        }
                    }
                    System.out.println(palabras);
                }
                catch(FileNotFoundException e){
                    e.printStackTrace();
                }
                catch (IOException e1){
                    e1.printStackTrace();
                }
            }
            else{
                System.out.println("No se encontro el archivo");
            }

            for (String palabra : palabras) {
                app.cadena = palabra;
                int valor = app.estado_A();
                if (valor == app.aceptado) {
                    System.out.println(palabra + ": Cadena Valida");
                    app.reinicioIndice();
                } else {
                    System.out.println(palabra + ": Cadena Invalida");
                    app.reinicioIndice();
                }
            }
        }

    private void reinicioIndice() {
        indice = 0;
    }
        private char siguienteCaracter() {
            char caracter = ' ';
            if (indice < cadena.length()) {
                caracter = cadena.charAt(indice);
                indice++;
            }
            return caracter;
        }

        private int estado_A() {
            char c=siguienteCaracter();
            switch(c){
                case '0': return estado_B();
                case '1': return estado_C();
                default: return error;
            }
        }

        private int estado_B() {
            char c=siguienteCaracter();
            switch(c){
                case '0': return estado_B();
                case '1': return estado_C();
                default: return error;
            }
        }

        private int estado_C() {
            char c=siguienteCaracter();
            switch(c){
                case '0': return estado_D();
                case '1': return estado_E();
                default: return error;
            }
        }

        private int estado_D() {
            char c=siguienteCaracter();
            switch(c){
                case '0': return estado_D();
                case '1': return estado_D();
                default: return error;
            }
        }

        private int estado_E() {
            char c=siguienteCaracter();
            switch(c){
                case '0': return estado_F();
                case '1': return estado_D();
                case ' ': return aceptado;
                default: return error;
            }
        }

        private int estado_F() {
            char c=siguienteCaracter();
            switch(c){
                case '0': return estado_F();
                case '1': return estado_D();
                case ' ': return aceptado;
                default: return error;
            }
        }
    }