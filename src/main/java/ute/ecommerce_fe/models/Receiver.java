package ute.ecommerce_fe.models;


import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Receiver {
    private Long id;


    private String receiverName;


    private String receiverPhoneNumber;

    private String receiverAddress;

    // @OneToMany(mappedBy = "receiver")
    // private Collection<Order> orders;
}