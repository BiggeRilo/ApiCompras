package atom.juice.ses.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "shopping_session", schema = "sesdb", catalog = "sesbase")
public class ShoppingSessionModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "shopping_session_id", nullable = false)
    private long shoppingSessionId;

    @Column(name = "user_id", nullable = false)
    //TODO IMPLEMENT RELATION
    private long userId;

    @Column(name = "total", nullable = false, precision = 2)
    private BigDecimal total;

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

    public long getShoppingSessionId() {
        return shoppingSessionId;
    }

    public void setShoppingSessionId(long shoppingSessionId) {
        this.shoppingSessionId = shoppingSessionId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
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
        if (!(o instanceof ShoppingSessionModel that)) return false;

        if (shoppingSessionId != that.shoppingSessionId) return false;
        if (userId != that.userId) return false;
        if (active != that.active) return false;
        if (!total.equals(that.total)) return false;
        if (!createdAt.equals(that.createdAt)) return false;
        return updatedAt.equals(that.updatedAt);
    }

    @Override
    public int hashCode() {
        int result = (int) (shoppingSessionId ^ (shoppingSessionId >>> 32));
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + (active ? 1 : 0);
        return result;
    }
}
