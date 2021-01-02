package chingis.montayev.web.model;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;


    public Person() {
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person(Person person) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +

                '}';
    }
}
