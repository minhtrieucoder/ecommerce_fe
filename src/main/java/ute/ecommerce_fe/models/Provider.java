package ute.ecommerce_fe.models;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Provider {
    private Long id;

    private String providerName;


    private String providerAddress;

    private String providerPhoneNumber;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    // @OneToMany(mappedBy = "provider")
    // private Collection<Product> products;
}
