package atom.juice.ses.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "cart_item", schema = "sesdb", catalog = "sesbase")
public class CartItemModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cart_item_id", nullable = false)
    private long cartItemId;
    
    @Column(name = "shopping_session_id", nullable = false)
    private long shoppingSessionId;
    
    @Column(name = "product_id", nullable = false)
    private long productId;
    
    @Column(name = "quantity", nullable = false)
    private int quantity;
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

    public long getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(long cartItemId) {
        this.cartItemId = cartItemId;
    }

    public long getShoppingSessionId() {
        return shoppingSessionId;
    }

    public void setShoppingSessionId(long shoppingSessionId) {
        this.shoppingSessionId = shoppingSessionId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
        if (!(o instanceof CartItemModel that)) return false;

        if (cartItemId != that.cartItemId) return false;
        if (shoppingSessionId != that.shoppingSessionId) return false;
        if (productId != that.productId) return false;
        if (quantity != that.quantity) return false;
        if (active != that.active) return false;
        if (!createdAt.equals(that.createdAt)) return false;
        return updatedAt.equals(that.updatedAt);
    }

    @Override
    public int hashCode() {
        int result = (int) (cartItemId ^ (cartItemId >>> 32));
        result = 31 * result + (int) (shoppingSessionId ^ (shoppingSessionId >>> 32));
        result = 31 * result + (int) (productId ^ (productId >>> 32));
        result = 31 * result + quantity;
        result = 31 * result + createdAt.hashCode();
        result = 31 * result + updatedAt.hashCode();
        result = 31 * result + (active ? 1 : 0);
        return result;
    }
}
