package org.sid.ebankingbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("SA")
@Data @NoArgsConstructor @AllArgsConstructor
public class SavingAccount extends BankAccount {
    private double interestRate;
    @Override
    public void debit(double amount, String description) {
        super.debit(amount, description);
    }
    @Override
    public void credit(double amount, String description) {
        super.credit(amount,description);
    }
}
