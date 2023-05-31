package atom.juice.ses.data.dto.v1;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Date;

public class UserDTO extends RepresentationModel<UserDTO> implements Serializable {



    private long userId;


    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String celphoneNumber;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCelphoneNumber() {
        return celphoneNumber;
    }

    public void setCelphoneNumber(String celphoneNumber) {
        this.celphoneNumber = celphoneNumber;
    }
}
