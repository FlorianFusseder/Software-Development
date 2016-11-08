/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
abstract public class SingleIdEntity<T> implements Serializable
{
    @Id
    @GeneratedValue
    private T Id;

    public T getId()
    {
        return Id;
    }

    public void setId(T Id)
    {
        this.Id = Id;
    }

    @Override
    public int hashCode()
    {
        return (Id != null)? Id.hashCode() : 0;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final SingleIdEntity<?> other = (SingleIdEntity<?>) obj;
        if (!Objects.equals(this.Id, other.Id))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "SingleIdEntity{" + "Id=" + Id + '}';
    }
}
