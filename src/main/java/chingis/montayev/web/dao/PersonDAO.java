package chingis.montayev.web.dao;

import chingis.montayev.web.model.Person;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {
//    private static int PEOPLE_ID_GENEREIT;
//    private List<Person> people;
//
//     {
//        people = new ArrayList<>();
//         people.add(new Person(++PEOPLE_ID_GENEREIT, "Daneen"));
//         people.add(new Person(++PEOPLE_ID_GENEREIT, "Chingis"));
//         people.add(new Person(++PEOPLE_ID_GENEREIT, "Alaya"));
//    }

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person>index(){
        return entityManager.createQuery("from Person").getResultList();

    }
    public Person show(long id){
        TypedQuery<Person> query = entityManager.createQuery(
                "SELECT user FROM Person user WHERE user.id = :id", Person.class);
        Person person = query
                .setParameter("id", id)
                .getSingleResult();
        return person;    }

    public void save(Person person) {

        entityManager.persist(person);

    }

    public void update(long id, Person person) {
        Person userToBeUpdated = show(id);
        userToBeUpdated.setName(person.getName());

    }

    public void delete(long id) {
        entityManager.remove(entityManager.find(Person.class, id));
    }
}
