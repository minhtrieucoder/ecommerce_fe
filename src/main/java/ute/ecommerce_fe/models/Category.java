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

    // @OneToMany(mappedBy = "category")
    // private Collection<Product> products;
}
