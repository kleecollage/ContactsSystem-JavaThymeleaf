package gm.contacts.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
// @ToString
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idContact;
    String name;
    String phone;
    String email;

    @Override
    public String toString() {
        return "Contact{" +
                "idContact=" + idContact +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
