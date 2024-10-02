package org.sid.ebankingbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CA")
@Data @NoArgsConstructor @AllArgsConstructor
public class CurrentAccount extends BankAccount {
    private static final double OVERDRAFT_LIMIT = 500.0; // Example overdraft limit
    private double overDraft;
    @Override
    public void debit(double amount,String description) {
        // Allow overdraft
        if (amount > getBalance() + OVERDRAFT_LIMIT) {
            throw new IllegalArgumentException("Overdraft limit exceeded");
        }
        super.debit(amount, description);
    }

    @Override
    public void credit(double amount, String description) {
        // Allow overdraft
        if (amount > getBalance() + OVERDRAFT_LIMIT) {
            throw new IllegalArgumentException("Overdraft limit exceeded");
        }
        super.debit(amount,description);
    }
}
