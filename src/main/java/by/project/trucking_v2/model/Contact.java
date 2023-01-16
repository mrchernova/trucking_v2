package by.project.trucking_v2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Contact implements Serializable {

    private Integer unp;
    private String phone;

    @Override
    public String toString() {
        return "УНП: " + unp + ", тел. " + phone;
    }
}