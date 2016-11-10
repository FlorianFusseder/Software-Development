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
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public class DBService
{

    @PersistenceContext(unitName = "FussederPU")
    private EntityManager em;

    @Transactional
    public Student addStudent(Student s)
    {
        em.persist(s);
        return s;
    }
    
    @Transactional
    public Professor addProfessor(Professor p)
    {
        em.persist(p);
        return p;
    }

    @Transactional
    public Student addStudent(String VorName, String NachName, Adresse Adresse, Email EmailAdresse)
    {
        return addStudent(VorName, NachName, Adresse, EmailAdresse, null, null);
    }

    @Transactional
    public Student addStudent(String VorName, String NachName, Adresse Adresse, Email EmailAdresse, Professor ErstPruefer, Professor ZweitPruefer)
    {
        Student s = new Student();
        s.setVorName(VorName);
        s.setNachName(NachName);
        s.setAdresse(Adresse);
        s.setEmailAdresse(EmailAdresse);

        if (ErstPruefer != null)
        {
            s.setErstPruefer(ErstPruefer);
        }
        if (ZweitPruefer != null)
        {
            s.setZweitPruefer(ZweitPruefer);
        }

        em.persist(s);
        return s;
    }

    @Transactional
    public Adresse addAdresse(String Strasse, int PZahl, String Stadt)
    {
        Adresse a = new Adresse();
        a.setStrasse(Strasse);
        a.setPostleitzahl(PZahl);
        a.setStadt(Stadt);

        em.persist(a);
        return a;
    }

    @Transactional
    public Professor addProfessor(String VorName, String NachName, Adresse Adresse, Email EmailAdresse)
    {
        return addProfessor(VorName, NachName, Adresse, EmailAdresse, new ArrayList<Student>(), new ArrayList<Student>());
    }

    @Transactional
    public Professor addBachelor(Professor p, Student s)
    {
        p = em.merge(p);
        s = em.merge(s);
        s.setErstPruefer(p);
        p.addBachelorPruefer(s);
        
        
        
        //em.persist(p);
        return p;
    }
    

    @Transactional
    public Professor addProfessor(String VorName, String NachName, Adresse Adresse, Email EmailAdresse, ArrayList<Student> BachelorPruefer, ArrayList<Student> BachelorZweitPruefer)
    {
        Professor p = new Professor();

        p.setVorName(VorName);
        p.setNachName(NachName);
        p.setAdresse(Adresse);
        p.setEmailAdresse(EmailAdresse);
        p.setBachelorPruefer(BachelorPruefer);
        p.setBachelorZweitPruefer(BachelorZweitPruefer);

        em.persist(p);
        return p;
    }
}
