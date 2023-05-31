package atom.juice.ses.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "address", schema = "sesdb", catalog = "sesbase")
public class AddressModel {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "address_id", nullable = false)
    private long addressId;

    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel cliente;


    @Column(name = "adress_type_id", nullable = false)
    private long adressTypeId;

    @Column(name = "country_id", nullable = false)
    private long countryId;

    @Column(name = "phone_number", nullable = true, length = 15)
    private String phoneNumber;

    @Column(name = "city", nullable = false, length = 255)
    private String city;

    @Column(name = "state", nullable = false, length = 255)
    private String state;

    @Column(name = "street", nullable = false, length = 255)
    private String street;



    @Column(name = "zipcode", nullable = false, length = 255)
    private String zipcode;
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;
    @Column(name = "active", nullable = false)
    private boolean active;

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public long getAdressTypeId() {
        return adressTypeId;
    }

    public void setAdressTypeId(long adressTypeId) {
        this.adressTypeId = adressTypeId;
    }

    public long getCountryId() {
        return countryId;
    }

    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddressModel that)) return false;

        if (addressId != that.addressId) return false;
        if (adressTypeId != that.adressTypeId) return false;
        if (countryId != that.countryId) return false;
        if (active != that.active) return false;
        if (!phoneNumber.equals(that.phoneNumber)) return false;
        if (!city.equals(that.city)) return false;
        if (!state.equals(that.state)) return false;
        if (!street.equals(that.street)) return false;
        if (!zipcode.equals(that.zipcode)) return false;
        if (!createdAt.equals(that.createdAt)) return false;
        return updatedAt.equals(that.updatedAt);
    }

    @Override
    public int hashCode() {
        int result = (int) (addressId ^ (addressId >>> 32));
        result = 31 * result + (int) (adressTypeId ^ (adressTypeId >>> 32));
        result = 31 * result + (int) (countryId ^ (countryId >>> 32));
        result = 31 * result + phoneNumber.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + state.hashCode();
        result = 31 * result + street.hashCode();
        result = 31 * result + zipcode.hashCode();
        result = 31 * result + createdAt.hashCode();
        result = 31 * result + updatedAt.hashCode();
        result = 31 * result + (active ? 1 : 0);
        return result;
    }
}
