package ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "addresses",schema = "e_commerce")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String city;
    private String district;
    private String address;
    private String zipcode;
    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "users_addresses",schema = "e_commerce",joinColumns = @JoinColumn(name = "addresses_id"),
            inverseJoinColumns = @JoinColumn(name = "users_id"))
    private List<User> users;
}
