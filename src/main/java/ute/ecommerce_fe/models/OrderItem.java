package ute.ecommerce_fe.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
    private Long id;

    private Order order;

    private Product product;

    private int quantity;
}
