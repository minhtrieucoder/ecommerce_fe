package ute.ecommerce_fe.models;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long id;

    private String productName;

    private String productDescription;

    private Double productPrice;


    private String productImage;


    private int productQuantity;


    private Category category;


    private Provider provider;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    // @ManyToMany(mappedBy = "products")
    // private Collection<Order> orders;
}
