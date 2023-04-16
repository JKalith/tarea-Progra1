/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package listprogram;

import java.io.FileNotFoundException;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

import listprogram.Palindrome;
import listprogram.ChargeData;

/**
 *
 * @author james
 *
 */
public class ListProgram {

    static Palindrome palindromo = new Palindrome();
    static ChargeData chargeData = new ChargeData();
    static ListProcedures listProcedures = new ListProcedures();

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.println("seleccione la lista de estudiantes");

        menu();

    }

    /**
     * Funciona como escaner para la escritura de numeros tipo int
     *
     * @return retorna el numero digitado
     */
    public static int insertNum() {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        return num;
    }

    /**
     * Funciona como escaner para la escritura palabras tipo string
     *
     * @return retorna la frase digitada
     */
    public static String insertString() {
        Scanner scanner = new Scanner(System.in);
        String Strin = scanner.nextLine();
        return Strin;
    }

    /**
     * Es una funcion que almadena la lista de funciones del menu
     */
    public static void menuOptions() {
        System.out.println("_______________________________________________");
        System.out.println("1)Palindromo");
        System.out.println("2)estudiantes repetidos");
        System.out.println("3)orden alfabetico");
        System.out.println("4)Buscar");
        System.out.println("5)Remover y editar");
        System.out.println("6)Añadir estudiantes");
        System.out.println("7)Ver lista de estudiantes");
        System.out.println("_______________________________________________");
    }

    /**
     * Imprime opciones del CRUD
     */
    public static void menuCrud() {
        System.out.println("_______________________________________________");
        System.out.println("1)Remover");
        System.out.println("2)Editar");
        System.out.println("_______________________________________________");

    }

    /**
     * Este es el menu donde se encuentran los casos de las operaciones
     */
    public static void menu() throws FileNotFoundException, IOException {
        String filePath = chargeData.selectFile();
        repeatStudents(filePath);
        LinkedList<ListStudents> students = listProcedures.changeDataType();

        boolean exit = false;

        while (exit == false) {
            menuOptions();

            switch (insertNum()) {
                case 1:
                    palindromo.palindrome();

                    break;

                case 2:

                    break;

                case 3:
                    System.out.println("_______________________________________________");
                    System.out.println("En orden alfabetico ");
                    LinkedList<ListStudents> data = listProcedures.orderData(students);
                    System.out.println("__________________________________________________");
                    for (ListStudents listStudents : data) {
                        System.out.println(listStudents);

                    }
                    break;

                case 4:
                    System.out.println("Digite por medio de carnet al estudiante que decea buscar");
                    listProcedures.searchCard(insertString());

                    break;

                case 5:

                    menuCrud();
                    switch (insertNum()) {

                        case 1:
                            System.out.println("digite el carnet a eliminar");
                            listProcedures.removeStudent(insertString());
break;
                        case 2:
                            System.out.println("Digite el carnet del estudiante que desea editar");
                            String card = insertString();
                            int indexId = listProcedures.indexStudent(card);
                            selectEdit(indexId);

                            break;

                    }

                    break;

                case 6:
                    System.out.println("Digite una opcion");
                    System.out.println("1)Añadir primero");
                    System.out.println("2)Añadir ultimo");
                    switch (insertNum()) {
                        case 1:

                            listProcedures.addFirst();
                            System.out.println("_______________________________________________________________");
                            listProcedures.seeStudents();
                            System.out.println("_______________________________________________________________");

                            break;

                        case 2:
                            listProcedures.addlast();
                            ;
                            System.out.println("_______________________________________________________________");
                            listProcedures.seeStudents();
                            System.out.println("_______________________________________________________________");
                            break;

                    }

                case 7:
                    System.out.println("Lista de estudiantes");
                    listProcedures.seeStudents();

                    break;

            }
        }
    }

    /**
     * Imprime si hay estudiantes repetidos
     *
     * @param filePath
     * @throws IOException
     */
    public static void repeatStudents(String filePath) throws IOException {

        boolean studentRepeated = listProcedures.loadList(filePath);
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
        if (studentRepeated = true) {
            System.out.println("habia estudiantes repetidos");
        } else {
            System.out.println("no habia estudiantes repetidos");
        }
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");

    }

    /**
     * almacena las funciones de Crud
     *
     * @param index
     * Recibe el indice de la lista donde se encuentra el estudiante
     */
    public static void selectEdit(int index) {
        System.out.println("digite una opcion");
        System.out.println("1)nuevo carnet");
        System.out.println("2)nuevo nombre");
        System.out.println("3)todos los datos");
        switch (insertNum()) {

            case 1:
                System.out.println("digite el nuevo carnet");
                listProcedures.editStudentC(index);
                System.out.println("estudiante editado");
                System.out.println(listProcedures.list.get(index).toString());

                break;
            case 2:
                System.out.println("digite el nuevo nombre");
                listProcedures.editStudentN(index);
                System.out.println("estudiante editado");
                System.out.println(listProcedures.list.get(index).toString());

                break;

            case 3:
                System.out.println("digite el nuevo carnet");
                listProcedures.editStudentC(index);

                System.out.println("digite el nuevo nombre");
                listProcedures.editStudentN(index);

                System.out.println("estudiante editado");
                System.out.println(listProcedures.list.get(index).toString());

                break;

        }

    }

}
