package Technicals.Id;

import java.io.Serializable;
import javax.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@MappedSuperclass
@NoArgsConstructor
@EqualsAndHashCode
@ToString
abstract public class SingleIdEntity<T> implements Serializable {

    public abstract T getID();

}
