package com.yaashall.bankapp.entity;

import com.yaashall.bankapp.utils.AccountUtils.AccountStatus;
import com.yaashall.bankapp.utils.AccountUtils.AccountType;
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
@Table(name = "account",
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
            name = "balance",
            columnDefinition = "decimal(10,2) default '0.00'"
    )
    private BigDecimal balance;

    @Column(
            name = "status",
            nullable = false,
            columnDefinition = "text"
    )
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

    @Column(
            name = "account_type",
            columnDefinition = "text"
    )
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @CreationTimestamp
    private LocalDateTime createdOn;

    @UpdateTimestamp
    private LocalDateTime updatedOn;

    @OneToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "owner_id",
            referencedColumnName = "user_id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "user_account_fk"
            )
    )
    private User user;
}
