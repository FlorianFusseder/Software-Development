/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;


import Entity.Adresse;
import Entity.Email;
import Entity.Professor;
import Entity.Student;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


public class DBService
{
    @PersistenceContext(unitName = "FussederPU")
    private EntityManager em;
    
    @Transactional
    public Student addStudent(String VorName, String NachName, Adresse Adresse, Email Email, Professor erstPruefer, Professor zweitPruefer){
        
        Student s = new Student();
        s.setVorName(VorName);
        s.setNachName(NachName);
        s.setAdresse(Adresse);
        s.setEmailAdresse(Email);
        s.setErstpruefer(erstPruefer);
        s.setZweitPruefer(zweitPruefer);
        em.persist(s);
        
        return s;
    }
    
}
