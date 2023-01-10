package by.project.trucking_v2.model;

import lombok.*;

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
    private String email;
    private Role role;

    public User(String login, String password, Role role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

//    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "le_id")
    private LegalEntity legalEntity;



}
