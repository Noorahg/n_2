package org.example.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    private int id;
    private String name;
    private double price;
    private String category;

    public Menu(String name, double price, String category) {
    }
}
