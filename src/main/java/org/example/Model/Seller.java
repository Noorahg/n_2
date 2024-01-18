package org.example.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seller extends User {
    private String position;
    private double hourlyRate;//Почасовая ставка продавца
    public Seller(Long id, String role, String lastName, String firstName, String email, String password, String phoneNumber, String position, double hourlyRate) {
        super(id, role, lastName, firstName, email, password, phoneNumber);
        this.position = position;
        this.hourlyRate = hourlyRate;
    }
    public Seller(long id, String role, String lastName, String firstName, String email, String password, String phoneNumber, String position, double hourlyRate) {
    }
}
