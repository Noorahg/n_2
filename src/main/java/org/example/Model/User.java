package org.example.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String role;
    private String lastName;
    private String firstName;
    private String email;
    private String password;
    private String phoneNumber;

}
