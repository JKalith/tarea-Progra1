/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listprogram;

import java.util.Scanner;

import java.util.Stack;
/**
 *
 * @author james
 * La clase tiene la funcion de crear un procedimiento que identifique palindromos
 */
public class Palindrome {


Stack<Character> stack = null;



/**
 * Funciona como escaner para la escritura de palabras tipo string
 * @return 
 * retorna la palabra digitada
 */
    public String insertWord() {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        return word;
    }
    /**
     * 
     * @param word variable palabra que recive el palindromo
     @return Retorna un valor verdadero o falso en funcion a la equivalencia de
     * la palabra que se le envia si en caso de que sea palindromo retorna true
     *
     */
       public boolean isPalindrome(String word) {
           word = word.toLowerCase().replaceAll(" ","");
            String reverse = new StringBuilder(word).reverse().toString();
     return word.equals(reverse);
    }
       
       /**
        * Comprueba si la palabra esta vacia 
     * @param word 
     * recive la palabra a revisar
        * @return retorna verdadero en caso de que si posea datos
        */
       public boolean palidromeEmpty(String word){
       return !word.equalsIgnoreCase("");
       }   
       
       
       
       /**
 * Esta es una funcion la cual tiene como funcion mostrar si una palabra es 
 * paindromo
 */
    public void palindrome(){
        System.out.println("Digite una palabra para saber si es palindromo");
String word = insertWord();
        if (palidromeEmpty(word) == true) {
            boolean resultado = isPalindrome(word);
            if (resultado == true) {
                System.out.println("es un palindromo");
            } else {
                System.out.println("nop eso no es un palindromo");
            }
        } else {
            System.out.println("No hay ninguna PALABRA");
        }


}

 
}
    
    
    
    
    
    

 
