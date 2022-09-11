package com.example.model;

import io.micronaut.core.annotation.Introspected;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Introspected
@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue()
    private int id;
    @NonNull
    @Column
    private String name;
    @NonNull
    @Column
    private String mobileNumber;
    @NonNull
    @Column
    private String email;
}
