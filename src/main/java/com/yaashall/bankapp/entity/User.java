package com.yaashall.bankapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "User")
@Table(name = "users",
        uniqueConstraints = {@UniqueConstraint(
                name = "email_unique",
                columnNames = "email"
        ),
        @UniqueConstraint(
                name = "phone_number_unique",
                columnNames = "phone_number"
        )
}
)
public class User {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    @Column(name = "user_id",
            updatable = false,
            nullable = false,
            columnDefinition = "bigint",
            unique = true
    )
    private Long userId;

    @Column(name = "first_name",
            nullable = false,
            columnDefinition = "text"
    )
    private String firstName;

    @Column(name = "last_name",
            nullable = false,
            columnDefinition = "text"
    )
    private String lastName;

    @Column(name = "gender",
            nullable = false,
            columnDefinition = "text"
    )
    private String gender;

    @Column(
            name = "address",
            nullable = false,
            columnDefinition = "text"
    )
    private String address;

    @Column(
            name = "city",
            nullable = false,
            columnDefinition = "text"
    )
    private String birthPlace;

    @Column(
            name = "birth_date",
            nullable = false,
            columnDefinition = "date"
    )
    private LocalDate birthDate;

    @Column(
            name = "phone_number",
            nullable = false,
            columnDefinition = "text"
    )
    private String phoneNumber;

    @Column(name = "email",
            nullable = false,
            columnDefinition = "text"
    )
    private String email;

    @Column(name = "password",
            nullable = false,
            columnDefinition = "text",
            length = 12
    )
    private String password;

    @OneToOne(
            mappedBy = "user",
            orphanRemoval = true,
            cascade = {CascadeType.ALL}
    )
    private Account account;

}
