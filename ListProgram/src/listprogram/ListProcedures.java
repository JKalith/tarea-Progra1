/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listprogram;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

/**
 *Almacena las funciones de la lista
 * @author james
 */
public class ListProcedures {

    Set<ListStudents> listStudents = new HashSet<ListStudents>();
    ListStudents listStudent = new ListStudents();
    Scanner scanner = new Scanner(System.in);

    LinkedList<ListStudents> list;

    /**
     * Carga la lista de estudiantes y muestra los estudiantes repetidos
     *
     * @param filePath es la ubicacion del txt o doc c;user/docs
     * @throws FileNotFoundException
     * @throws IOException
     * @return envia verdadero en el caso que haya elementos repetidos
     */
    public boolean loadList(String filePath) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        boolean studentRepeated = false;
        while ((line = br.readLine()) != null) {

            String data[] = line.split(",");
            String name = data[1];
            String card = data[0];
            listStudent = new ListStudents(card, name);

            if (!listStudents.add(listStudent)) {

                System.out.println("nombre repetido" + name);
                studentRepeated = true;

            }
        }
        br.close();
        return studentRepeated;

    }

    /**
     * pasa los datos de un hash set a un linked list
     *
     * @return
     */
    public LinkedList<ListStudents> changeDataType() {
        list = new LinkedList<>(listStudents);
        return list;
    }

    public LinkedList<ListStudents> orderData(LinkedList<ListStudents> lis) {

        Collections.sort(lis, (o1, o2) -> o1.getStudentsName().compareTo(o2.getStudentsName()));
        return list;

    }

    /**
     * Busca a traves del carnet del estudiante
     *
     * @param card variable donde se envia el carnet a buscar
     * @return
     */
    public boolean searchCard(String card) {

        for (ListStudents listStudents : list) {
            if (listStudents.getCard().equalsIgnoreCase(card)) {
                System.out.println("se encontro el estudiante");
                System.out.println("el estudiante es " + listStudents.toString());

                return true;
            }
        }
        System.out.println("no se encontro ningun estudiante asignado a ese carnet");
        return false;
    }

    /**
     * remueve el estudiante segun su carnet
     *
     * @param found es el carnet q el que se va a eliminar
     */
    public void removeStudent(String found) {

        int index = indexStudent(found);
        if (index > -1) {
            System.out.println("se eliminó el estudiante: " + list.get(index).getStudentsName());
            list.remove(index);
        } else {
            System.out.println("El estudiante no se encontró");
        }

    }

    /**
     * busca el estudiante y retorna la posicion del indice
     *
     * @param found
     * @return
     */
    public int indexStudent(String found) {
        int index = -1;

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).getCard().equalsIgnoreCase(found)) {
                index = i;
                break;
            }
        }
        return index;

    }

    /**
     * Esdita el carnet del estudiante
     *
     * @param index
     * @return
     */
    public int editStudentC(int index) {

        String card = insertString();
        list.get(index).setCard(card);

        return index;

    }

    /**
     * Edita el Nombre el estudiante
     *
     * @param index
     * @return
     */
    public int editStudentN(int index) {

        String studentName = insertString();
        list.get(index).setStudentsName(studentName);
        return 0;

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
 * Añade un estudiante al inicio de la lista
 */
    public void addFirst() {
        System.out.println("digite el carnet");
        String card = insertString();

        System.out.println("digite el nombre");
        String studentName = insertString();
        ListStudents listS = new ListStudents(card, studentName);
        list.addFirst(listS);
        System.out.println("se añadio el estudiante " + listS.toString() + " al inicio de la lista");

    }
/**
 * Imprime la lista completa de estudianetes 
 */
    public void seeStudents() {

        for (ListStudents listStudent1 : list) {
            System.out.println(listStudent1);
        }

    }
    /**
     * Añade un estudiante en el final de la lista
     */
 public void addlast() {
        System.out.println("digite el carnet");
        String card = insertString();

        System.out.println("digite el nombre");
        String studentName = insertString();
        ListStudents listS = new ListStudents(card, studentName);
        list.addLast(listS);
        System.out.println("se añadio el estudiante " + listS.toString() + " al final de la lista");

    }
}
