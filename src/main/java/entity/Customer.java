package entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Customer {
    @Id
    private String customerId;
    private String customerName;
    private String customerAddress;
    private int customerContactNumber;
    private String customerEmail;
}



