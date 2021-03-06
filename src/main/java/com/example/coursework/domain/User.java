package com.example.coursework.domain;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "usr")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String username;
    String password;

    @Transient
    String password2;

    boolean active;
    String email;
    String activationCode;
    String restoreCode;


    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable( name = "user_role", joinColumns = @JoinColumn( name = "user_id"))
    @Enumerated(EnumType.STRING)
    Set<Role> roles;

}
