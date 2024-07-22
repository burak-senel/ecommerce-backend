package ecommerce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.Mapping;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="roles",schema = "e_commerce")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String authority;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
    private List<User> users;
    public void addUser(User user){
        if(users == null){
            users = new ArrayList<>();
        }
        users.add(user);
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
