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

    @Column(name="branch_id")
    private Long branch_id;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }
    public Category(String name, Long branch_id) {
        this.name = name;
        this.branch_id = branch_id;
    }

    public Category (Long id, String name, Long branch_id) {
        this.id = id;
        this.name = name;
        this.branch_id = branch_id;
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

    public Long getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(Long branchId) {
        this.branch_id = branchId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id) &&
                Objects.equals(name, category.name) &&
                Objects.equals(branch_id, category.branch_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getBranch_id());
    }
}




























