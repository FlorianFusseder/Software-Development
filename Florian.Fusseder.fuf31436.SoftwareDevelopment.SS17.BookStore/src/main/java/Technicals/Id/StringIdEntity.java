/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Technicals.Id;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Florian
 */
@MappedSuperclass
@NoArgsConstructor
public class StringIdEntity extends SingleIdEntity<String> {

    @Id
	@Setter
    private String Id;
	
    @Override
    public String getID() {
        return this.Id;
    }
}
