package org.example.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin extends User {
    private String position; // Должность администратора (например, главный администратор)
    private double salary; // Заработная плата администратора
    private List<User> managedUsers; // Список пользователей, управляемых администратором

}
