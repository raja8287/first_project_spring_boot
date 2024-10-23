package loginpageapi.rea_red_sb.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "newCreateuser")

public class userEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String username;
    public String email;
    public String password;
    public LocalDateTime createdDate;

    public userEntity(Long id, String username, String email, String password, LocalDateTime createdDate) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.createdDate = LocalDateTime.now();
    }

    public userEntity() {
        this.createdDate = LocalDateTime.now(); // Set current date and time

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
