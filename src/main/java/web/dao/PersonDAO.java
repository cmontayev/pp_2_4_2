package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.config.HibernateConfig;
import web.model.Person;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {
    private static int PEOPLE_ID_GENEREIT;
    private List<Person> people;

     {
        people = new ArrayList<>();
         people.add(new Person(++PEOPLE_ID_GENEREIT, "Daneen"));
         people.add(new Person(++PEOPLE_ID_GENEREIT, "Chingis"));
         people.add(new Person(++PEOPLE_ID_GENEREIT, "Alaya"));
    }

    private SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
    public void createUsersTable() {
        Transaction createTableT = null;
        try (Session session = sessionFactory.openSession()) {
            createTableT = session.beginTransaction();
            String createTableQuery = "CREATE TABLE IF NOT EXISTS user" +
                    "(id BIGINT NOT NULL AUTO_INCREMENT, " +
                    " name VARCHAR(50) NOT NULL, " +
                    " PRIMARY KEY (id))";
            session.createSQLQuery(createTableQuery).executeUpdate();
            createTableT.commit();
        } catch (Exception e) {
            if (createTableT != null) {
                createTableT.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Person>index(){
        Transaction getAllUsersT = null;
        List<Person> usersList = null;
        try (Session session = sessionFactory.openSession()) {
            getAllUsersT = session.beginTransaction();
            usersList = session.createQuery("FROM Person").list(); // работает
//            usersList = session.createCriteria(User.class).list(); // работает
            getAllUsersT.commit();
        } catch (Exception e) {
            if (getAllUsersT != null) {
                getAllUsersT.rollback();
            }
            e.printStackTrace();
        }
        return usersList;
    }
    public Person show(int id){
         return people.stream().filter(person -> person.getId()==id).findAny().orElse(null);
    }

    public void save(Person person) {

        Transaction saveUserT = null;
        try (Session session = sessionFactory.openSession()) {
            saveUserT = session.beginTransaction();
            session.save(new Person(person));
            saveUserT.commit();
        } catch (Exception e) {
            if (saveUserT != null) {
                saveUserT.rollback();
            }
            e.printStackTrace();
        }
    }

    public void update(int id, Person person) {
        Person persoToUpdate = show(id);
        persoToUpdate.setName(person.getName());

    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
