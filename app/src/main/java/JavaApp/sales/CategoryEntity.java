package JavaApp.sales;

import javax.persistence.*;







@Entity
@Table(name="category")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="name")
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name="branch_id")
    private BranchEntity branch;

    public CategoryEntity(String name, BranchEntity branch) {
        this.name = name;
        this.branch = branch;
    }
    public CategoryEntity() {

    }

    public CategoryEntity(String name) {
        this.name = name;
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

    public BranchEntity getBranch() {
        return branch;
    }

    public void setBranch(BranchEntity branch) {
        this.branch = branch;
    }
}
