package atom.juice.ses.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "order", schema = "sesdb", catalog = "sesbase")
public class OrderModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "order_id", nullable = false)
    private long orderId;

    @Column(name = "cupom_id", nullable = false)
    private int cupomId;

    @Column(name = "user_id", nullable = false)
    private long userId;

    @Column(name = "total", nullable = false, precision = 2)
    private BigDecimal total;

    @Column(name = "order_payment_details_id", nullable = false)
    private long orderPaymentDetailsId;

    @Column(name = "order_status_id", nullable = false)
    private int orderStatusId;

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

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public int getCupomId() {
        return cupomId;
    }

    public void setCupomId(int cupomId) {
        this.cupomId = cupomId;
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

    public long getOrderPaymentDetailsId() {
        return orderPaymentDetailsId;
    }

    public void setOrderPaymentDetailsId(long orderPaymentDetailsId) {
        this.orderPaymentDetailsId = orderPaymentDetailsId;
    }

    public int getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(int orderStatusId) {
        this.orderStatusId = orderStatusId;
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
        if (!(o instanceof OrderModel that)) return false;

        if (orderId != that.orderId) return false;
        if (cupomId != that.cupomId) return false;
        if (userId != that.userId) return false;
        if (orderPaymentDetailsId != that.orderPaymentDetailsId) return false;
        if (orderStatusId != that.orderStatusId) return false;
        if (active != that.active) return false;
        if (!total.equals(that.total)) return false;
        if (!createdAt.equals(that.createdAt)) return false;
        return updatedAt.equals(that.updatedAt);
    }

    @Override
    public int hashCode() {
        int result = (int) (orderId ^ (orderId >>> 32));
        result = 31 * result + cupomId;
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + total.hashCode();
        result = 31 * result + (int) (orderPaymentDetailsId ^ (orderPaymentDetailsId >>> 32));
        result = 31 * result + orderStatusId;
        result = 31 * result + createdAt.hashCode();
        result = 31 * result + updatedAt.hashCode();
        result = 31 * result + (active ? 1 : 0);
        return result;
    }
}
