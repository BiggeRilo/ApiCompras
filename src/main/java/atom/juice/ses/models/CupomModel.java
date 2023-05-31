package atom.juice.ses.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "cupom", schema = "sesdb", catalog = "sesbase")
public class CupomModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cupom_id", nullable = false)
    private int cupomId;
    
    @Column(name = "code", nullable = false, length = 50)
    private String code;
    
    @Column(name = "description", nullable = false, length = 255)
    private String description;
    
    @Column(name = "discount", nullable = false, precision = 2)
    private BigDecimal discount;
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

    public int getCupomId() {
        return cupomId;
    }

    public void setCupomId(int cupomId) {
        this.cupomId = cupomId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
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

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CupomModel that)) return false;

        if (cupomId != that.cupomId) return false;
        if (active != that.active) return false;
        if (!code.equals(that.code)) return false;
        if (!description.equals(that.description)) return false;
        if (!discount.equals(that.discount)) return false;
        if (!createdAt.equals(that.createdAt)) return false;
        return updatedAt.equals(that.updatedAt);
    }

    @Override
    public int hashCode() {
        int result = cupomId;
        result = 31 * result + code.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + discount.hashCode();
        result = 31 * result + createdAt.hashCode();
        result = 31 * result + updatedAt.hashCode();
        result = 31 * result + (active ? 1 : 0);
        return result;
    }
}
