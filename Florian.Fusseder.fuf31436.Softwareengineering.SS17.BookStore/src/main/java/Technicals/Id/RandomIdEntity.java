/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Technicals.Id;

import java.util.UUID;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Florian
 */
@MappedSuperclass
public class RandomIdEntity extends SingleIdEntity<String> {

    @Id
    private String Id;

    public RandomIdEntity() {
        this.Id = UUID.randomUUID().toString();
    }

    @Override
    public String getID() {
        return this.Id;
    }

    @Override
    public String toString() {
        return "RandomIdEntity{" + "Id=" + Id + '}';
    }
}
