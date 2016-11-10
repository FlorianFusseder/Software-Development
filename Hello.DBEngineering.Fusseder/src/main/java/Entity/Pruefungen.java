/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Florian Fußeder
 */
@Table(name = "pruefungen")
public class Pruefungen extends SingleIdEntity
{

    private String name;

    @ElementCollection
    @ManyToMany(mappedBy = "Pruefungen")
    private List<Student> teilnehmer;

    public Pruefungen()
    {
        this.teilnehmer = new ArrayList<>();
    }

    public Pruefungen(String name)
    {
        this();
        this.name = name;
    }

    public Pruefungen(String name, List<Student> teilnehmer)
    {
        this.name = name;
        this.teilnehmer = teilnehmer;
    }
    
    

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Student> getTeilnehmer()
    {
        return teilnehmer;
    }

    public void setTeilnehmer(ArrayList<Student> teilnehmer)
    {
        this.teilnehmer = teilnehmer;
    }

    public void addStudent(Student s)
    {
        this.teilnehmer.add(s);
    }
}
