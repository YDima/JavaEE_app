package JavaApp.sales;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;








@Entity
@Table(name="category")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="name")
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name="branch_id")
    private Branch branch;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }
    public Category(String name, Branch branch) {
        this.name = name;
        this.branch = branch;
    }

    public Category (Long id, String name, Branch branch) {
        this.id = id;
        this.name = name;
        this.branch = branch;
    }

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

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id) &&
                Objects.equals(name, category.name) &&
                Objects.equals(branch, category.branch);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getBranch());
    }
}




























