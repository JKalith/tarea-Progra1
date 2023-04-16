/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listprogram;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;

/**
 *almacena las funciones de cargado de informacion 
 * @author james
 */
public class ChargeData {
    
    
        /**
         * Posee como funcion la seleccion del archivo txt a leer 
         * @return 
         * Retorna la ubicacion del archivo seleccionado
         */
        public String selectFile() {
        String ubicationFile = null;

        JFileChooser file = new JFileChooser();
        file.showOpenDialog(file);

        int checkInput = file.showOpenDialog(null);

        if (checkInput == JFileChooser.APPROVE_OPTION) {
            File openedFile = file.getSelectedFile();
            System.out.println("▄▄──▄▄──▄▄──▄▄──▄▄──▄▄─▄▄──▄▄──▄▄──▄▄");
            System.out.println("Nombre del archivo: " + openedFile.getName());
            System.out.println("Ubicacion del archivo: " + openedFile.getAbsolutePath());
            System.out.println("▄▄____▄▄____▄▄___▄▄___▄▄___▄▄__▄▄___▄▄___▄▄___▄▄");

            ubicationFile = openedFile.getAbsolutePath();
        } 
        return (ubicationFile);
    }
        
        
        
        
 
        
        
      /**
       * Lee los datos de un txt en base a la ubicacion proporcionada
       * @param ubicationFile 
       * recive una ubicacion de el escritorio para la lectura de txt o .doc
       */ 
     public void readerData(String ubicationFile){
     
      try (FileReader fr = new FileReader(ubicationFile);
             BufferedReader br = new BufferedReader(fr)) {

            String linea;
            // Leer cada línea del archivo de texto
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }


         } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

     }
        
        
        
        
}
