package JavaApp.sales.jpa;

import javax.persistence.*;


@Entity
@Table(name="parameter")
public class Parameter {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parameter() {
    }


    public Parameter(Long id, String name) {
        this.id = id;
        this.name = name;
    }


}
