package ute.ecommerce_fe.models;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Orderer {
    private Long id;

    private String ordererName;
    private String ordererPhoneNumber;

    private String ordererAddress;

    // @OneToMany(mappedBy = "orderer")
    // private Collection<Order> orders;
}
