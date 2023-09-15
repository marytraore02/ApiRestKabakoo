package com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String nomEtPrenom;

    @NotBlank
    @Size(max = 20)
    private String contact;

    @NotBlank
    @Size(max = 20)
    private String date;

    @NotBlank
    @Size(max = 200)
    private String image;

    @NotBlank
    @Size(max = 20)
    @Column(unique = true)
    private String username;

    @NotBlank
    @Size(max = 100)
    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    @Size(max = 120)
    private String password;
    //    private boolean active;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "admin_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    Set<Role> roles = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    List<Commentaires> listCommentaire = new ArrayList<>();

    public User(String nomEtPrenom, String contact, String date, String image, String username, String email, String password) {
        this.nomEtPrenom = nomEtPrenom;
        this.contact = contact;
        this.date = date;
        this.image = image;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(String nomEtPrenom, String contact, String date, String username, String email, String password) {
        this.nomEtPrenom = nomEtPrenom;
        this.contact = contact;
        this.date = date;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    //    public Utilisateur(String username, String email, String password) {
////        super(id);
//        this.username = username;
//        this.email = email;
//        this.password = password;
//    }

}
