package org.example.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Store {
    private long id;
    private String address;
    private String  phoneNumber;
    private String email;
    private List<Menu> menu;

    public Store(long id, String address, String phoneNumber, String email) {
        this.id = id;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }


}