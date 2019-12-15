package JavaApp.sales;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;








@Entity
@Table(name="category")
public class CategoryEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="name")
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name="branch_id")
    private BranchEntity branch;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BranchEntity getBranch() {
        return branch;
    }

    public void setBranch(BranchEntity branch) {
        this.branch = branch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryEntity category = (CategoryEntity) o;
        return Objects.equals(id, category.id) &&
                Objects.equals(name, category.name) &&
                Objects.equals(branch, category.branch);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getBranch());
    }
}




























