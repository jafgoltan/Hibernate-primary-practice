package entity;

import javax.persistence.*;

@Table(name = "person")//SQL
@Entity(name = "personEntity")//JPQL
@NamedQueries({@NamedQuery(name = "x1", query = "select oo from personEntity oo"),
        @NamedQuery(name = "x2", query = "select oo from personEntity oo")})
public class Person {

    //GLOBAL
    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)*/

    //PRIVATE
    @Id
    @SequenceGenerator(name = "personSeq", sequenceName = "PERSON_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "personSeq")
    @Column(name = "PERSON_ID", columnDefinition = "NUMBER")
    private long id;
    @Column(name = "FIRST_NAME", columnDefinition = "NVARCHAR2(20)")
    private String name;
    @Column(name = "LAST_NAME", columnDefinition = "NVARCHAR2(20)")
    private String family;

    public Person() {
    }

    public Person(String name, String family) {
        this.name = name;
        this.family = family;
    }

    public long getId() {
        return id;
    }

    public Person setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public String getFamily() {
        return family;
    }

    public Person setFamily(String family) {
        this.family = family;
        return this;
    }
}
