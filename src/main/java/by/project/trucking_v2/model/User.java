package by.project.trucking_v2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(unique = true)
    private String login;
    private String password;
    private Role role;

    public User(int i, String login, String password, Role role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    @OneToOne(mappedBy = "user")
    private LegalEntity legalEntity;
}
