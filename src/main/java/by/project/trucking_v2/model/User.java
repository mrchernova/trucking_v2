
package by.project.trucking_v2.model;

import lombok.*;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(unique = true)
    private String login;
    private String password;
    @Column(unique = true)
    private String email;
    @Enumerated(value = EnumType.STRING)
    private Role role;
//    @Enumerated(value = EnumType.STRING)
//    private Status status;

    public User(String login, String password, Role role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "le_id")
    private LegalEntity legalEntity;


}
