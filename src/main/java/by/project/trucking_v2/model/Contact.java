package by.project.trucking_v2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Contact implements Serializable {

    private int unp;
    private String phone;

    @Override
    public String toString() {
        return "УНП: " + unp + ", тел. " + phone;
    }
}