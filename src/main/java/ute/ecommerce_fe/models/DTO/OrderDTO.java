package ute.ecommerce_fe.models.DTO;

import lombok.*;

import java.util.Collection;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private String orderState;

    private double totalAmount;

    private String user;

    private Collection<OrderItemDTO> orderItems;

    private String ordererName;

    private String ordererPhoneNumber;

    private String ordererAddress;

    private String receiverName;

    private String receiverPhoneNumber;

    private String receiverAddress;
}
