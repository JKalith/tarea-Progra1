/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listprogram;

import java.util.Objects;

/**
 *clase lista donde se encuentran los get,set y atributos de estudiante
 * @author james
 */
public class ListStudents {
    private String card;
    private String StudentsName;

    public ListStudents() {
    }

    public ListStudents(String card, String studentsName) {
        this.card = card;
        this.StudentsName = studentsName;
    }

    /**
     * @return the card
     * 
     */
    public String getCard() {
        return card;
    }

    /**
     * @param card the card to set
     */
    public void setCard(String card) {
        this.card = card;
    }

    /**
     * @return the StudentsName
     */
    public String getStudentsName() {
        return StudentsName;
    }

    public void setStudentsName(String StudentsName) {
        this.StudentsName = StudentsName;
    }

 

    
    
    
    
    
   
    @Override
    public int hashCode(){
     return Objects.hash(card,StudentsName);
    
    
    }

    @Override
    /**
     * verifica que no haya estudiantes repetidos y evita su almacenamiento
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ListStudents other = (ListStudents) obj;
        if (!Objects.equals(this.card, other.card)) {
            return false;
        }
        if (!Objects.equals(this.StudentsName, other.StudentsName)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
    
    
    
    
    @Override
    public String toString() {
        return "" +"card " + card + ", name " + StudentsName + "";
    }
}