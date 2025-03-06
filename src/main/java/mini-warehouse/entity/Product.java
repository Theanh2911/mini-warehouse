package week1.internJava.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "product")
public class Product {
    @Id
    private int id;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "import_at")
    private Instant importAt;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "export_at")
    private Instant exportAt;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "modified_by", nullable = false)
    private week1.internJava.entity.User modifiedBy;

    @Column(name = "position", nullable = false, length = 2)
    private String position;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public week1.internJava.entity.User getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(week1.internJava.entity.User modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Instant getImportAt() {
        return importAt;
    }

    public void setImportAt(Instant importAt) {
        this.importAt = importAt;
    }

    public Instant getExportAt() {
        return exportAt;
    }

    public void setExportAt(Instant exportAt) {
        this.exportAt = exportAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
