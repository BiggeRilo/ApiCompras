package atom.juice.ses.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "order_payment_details", schema = "sesdb", catalog = "sesbase")
public class OrderPaymentDetailsModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "order_payment_details_id", nullable = false)
    private long orderPaymentDetailsId;
    @Basic
    @Column(name = "code", nullable = false, length = 50)
    private String code;
    @Basic
    @Column(name = "provider", nullable = false, length = 255)
    private String provider;
    @Basic
    @Column(name = "amount", nullable = false)
    private int amount;
    @Basic
    @Column(name = "order_payment_status_id", nullable = false)
    private long orderPaymentStatusId;
    @Basic
    @Column(name = "description", nullable = false, length = 255)
    private String description;
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

    public long getOrderPaymentDetailsId() {
        return orderPaymentDetailsId;
    }

    public void setOrderPaymentDetailsId(long orderPaymentDetailsId) {
        this.orderPaymentDetailsId = orderPaymentDetailsId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public long getOrderPaymentStatusId() {
        return orderPaymentStatusId;
    }

    public void setOrderPaymentStatusId(long orderPaymentStatusId) {
        this.orderPaymentStatusId = orderPaymentStatusId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (o == null || getClass() != o.getClass()) return false;

        OrderPaymentDetailsModel that = (OrderPaymentDetailsModel) o;

        if (orderPaymentDetailsId != that.orderPaymentDetailsId) return false;
        if (amount != that.amount) return false;
        if (orderPaymentStatusId != that.orderPaymentStatusId) return false;
        if (active != that.active) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (provider != null ? !provider.equals(that.provider) : that.provider != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (orderPaymentDetailsId ^ (orderPaymentDetailsId >>> 32));
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (provider != null ? provider.hashCode() : 0);
        result = 31 * result + amount;
        result = 31 * result + (int) (orderPaymentStatusId ^ (orderPaymentStatusId >>> 32));
        result = 31 * result + (active ? 1 : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }
}
