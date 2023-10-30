package com.yaashall.bankapp.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "Account")
@Table(name = "accounts",
        uniqueConstraints = @UniqueConstraint(
                name = "account_number_unique",
                columnNames = "account_number"
        )
)
public class Account {

    @Id
    @SequenceGenerator(
            name = "account_sequence",
            sequenceName = "account_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "account_sequence"
    )
    private Long accountId;

    @Column(name = "account_number",
            unique = true,
            nullable = false,
            columnDefinition = "text"
    )
    private String accountNumber;

    @Column(
            name = "balence",
            columnDefinition = "decimal(10,2) default '0.00'"
    )
    private BigDecimal balance;

    @Column(
            name = "status",
            nullable = false,
            columnDefinition = "text"
    )
    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    @Column(
            name = "account_type",
            columnDefinition = "text"
    )
    private String accountType;

    @CreationTimestamp
    private LocalDateTime createdOn;

    @UpdateTimestamp
    private LocalDateTime updatedOn;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "user_account_fk"
            )
    )
    private User user;
}
