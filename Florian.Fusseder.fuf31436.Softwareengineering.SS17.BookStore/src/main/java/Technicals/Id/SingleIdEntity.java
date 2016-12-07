package Technicals.Id;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@MappedSuperclass
@NoArgsConstructor
@ToString
abstract public class SingleIdEntity<T> implements Serializable {

	public abstract T getID();

	@Override
	public int hashCode() {
		return (this.getID() != null) ? this.getID().hashCode() : 0;
	}

	@Override
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
		final SingleIdEntity<?> other = (SingleIdEntity<?>) obj;
		if (!Objects.equals(this.getID(), other.getID())) {
			return false;
		}
		return true;
	}
}
