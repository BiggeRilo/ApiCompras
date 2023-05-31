package atom.juice.ses.models;

import jakarta.persistence.*;

@Entity
@Table(name = "country", schema = "sesdb", catalog = "sesbase")
public class CountryModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "country_id", nullable = false)
    private int countryId;

    @Column(name = "country_name", nullable = false, length = 255)
    private String countryName;

    @Column(name = "iso", nullable = false, length = 2)
    private String iso;

    @Column(name = "iso3", nullable = false, length = 3)
    private String iso3;

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public String getIso3() {
        return iso3;
    }

    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CountryModel that)) return false;

        if (countryId != that.countryId) return false;
        if (!countryName.equals(that.countryName)) return false;
        if (!iso.equals(that.iso)) return false;
        return iso3.equals(that.iso3);
    }

    @Override
    public int hashCode() {
        int result = countryId;
        result = 31 * result + countryName.hashCode();
        result = 31 * result + iso.hashCode();
        result = 31 * result + iso3.hashCode();
        return result;
    }
}
