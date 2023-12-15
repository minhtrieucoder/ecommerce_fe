package ute.ecommerce_fe.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.time.LocalDate;
import java.util.Collection;
// import java.util.Date;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long id;

    private String orderState;

    private double totalAmount;

    private LocalDate orderDate;

    private String user;

    // @ManyToMany
    // @JoinTable(
    // name = "order_product",
    // joinColumns = @JoinColumn(name = "order_id"),
    // inverseJoinColumns = @JoinColumn(name = "product_id")
    // )
    // private Collection<Product> products;

    private Collection<OrderItem> orderItems;

    private Orderer orderer;

    private Receiver receiver;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
