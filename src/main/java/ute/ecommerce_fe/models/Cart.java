package ute.ecommerce_fe.models;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    private Long id;

    private Product product;

    private int quantity;

    private String userEmail;
}
