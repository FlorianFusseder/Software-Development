/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Technicals.Repo;

import Technicals.Id.SingleIdEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Florian
 * @param <K>
 * @param <E>
 */
public abstract class SingleEntityRepository<K, E extends SingleIdEntity> {

    @PersistenceContext(unitName = "BookStorePU")
    public EntityManager manager;

    private final Class<E> type;

    public SingleEntityRepository(Class<E> type) {
        this.type = type;
    }

    public EntityManager getManager() {
        return manager;
    }

    public void setManager(EntityManager manager) {
        this.manager = manager;
    }

    public void perist(List<E> entityList) {
        entityList.forEach(e -> this.persist(e));
    }

    public void persist(E entity) {
        this.manager.persist(entity);
    }

    public E merge(E entity) {
        return this.manager.merge(entity);
    }

    public void remove(E entity) {
        this.manager.remove(entity);
    }

    public E findById(K Id) {
        return this.manager.find(type, Id);
    }

    public List<E> findAll() {

        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<E> cq = cb.createQuery(type);
        Root<E> rootEntry = cq.from(type);
        CriteriaQuery<E> all = cq.select(rootEntry);
        TypedQuery<E> allQuery = manager.createQuery(all);

        return (List<E>) allQuery.getResultList();
    }

    public List<E> findByRange(int from, int to) {
        return findAll().subList(from, to);
    }

}
