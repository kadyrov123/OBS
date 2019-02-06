package com.demo.OBS.Model;

import javax.persistence.*;

@Entity
public class Fields {
    private int id;
    private int centerId;
    private String size;
    private String price;
    private String fieldType;

    public Fields( int centerId, String size, String price, String fieldType) {
        this.centerId = centerId;
        this.size = size;
        this.price = price;
        this.fieldType = fieldType;
    }

    public Fields() {
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "center_id", nullable = false)
    public int getCenterId() {
        return centerId;
    }

    public void setCenterId(int centerId) {
        this.centerId = centerId;
    }

    @Basic
    @Column(name = "size", nullable = true, length = 10)
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Basic
    @Column(name = "price", nullable = false, length = 10)
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Basic
    @Column(name = "field_type", nullable = false, length = 20)
    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fields fields = (Fields) o;

        if (id != fields.id) return false;
        if (centerId != fields.centerId) return false;
        if (size != null ? !size.equals(fields.size) : fields.size != null) return false;
        if (price != null ? !price.equals(fields.price) : fields.price != null) return false;
        if (fieldType != null ? !fieldType.equals(fields.fieldType) : fields.fieldType != null) return false;

        return true;
    }

    public Fields(String size, String price, String fieldType) {
        this.size = size;
        this.price = price;
        this.fieldType = fieldType;
    }

    @Override
    public int hashCode() {

        int result = id;
        result = 31 * result + centerId;
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (fieldType != null ? fieldType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Fields{" +
                "id=" + id +
                ", centerId=" + centerId +
                ", size='" + size + '\'' +
                ", price='" + price + '\'' +
                ", fieldType='" + fieldType + '\'' +
                '}';
    }
}
