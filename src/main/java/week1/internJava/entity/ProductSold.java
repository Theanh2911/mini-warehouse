package week1.internJava.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Entity
@Table(name = "productstockout")
public class ProductSold {

    @Id
    private int stockOutId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "quantity_out", nullable = false)
    private Integer quantityOut;

    @Column(name = "stock_out_date", nullable = false)
    private Instant stockOutDate;

    public int getStockOutId() {
        return stockOutId;
    }

    public void setStockOutId(int stockOutId) {
        this.stockOutId = stockOutId;
    }

    public Instant getStockOutDate() {
        return stockOutDate;
    }

    public void setStockOutDate(Instant stockOutDate) {
        this.stockOutDate = stockOutDate;
    }

    public Integer getQuantityOut() {
        return quantityOut;
    }

    public void setQuantityOut(Integer quantityOut) {
        this.quantityOut = quantityOut;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
