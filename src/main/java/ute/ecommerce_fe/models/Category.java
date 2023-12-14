package ute.ecommerce_fe.models;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    private Long id;

    private String categoryName;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    // @OneToMany(mappedBy = "category")
    // private Collection<Product> products;
}
