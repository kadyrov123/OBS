package com.demo.OBS.Model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Centers {
    private int id;
    private String title;
    private int locationId;
    private int fotoId;
    private String phoneNumber;
    private Double rating;
    private String address;
    private Integer numFields;
    private int adminId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 100)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "location_id", nullable = false)
    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    @Basic
    @Column(name = "foto_id", nullable = false)
    public int getFotoId() {
        return fotoId;
    }

    public void setFotoId(int fotoId) {
        this.fotoId = fotoId;
    }

    @Basic
    @Column(name = "phone_number", nullable = false, length = 25)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "rating", nullable = true, precision = 0)
    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "address", nullable = false, length = 100)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "num_fields", nullable = true)
    public Integer getNumFields() {
        return numFields;
    }

    public void setNumFields(Integer numFields) {
        this.numFields = numFields;
    }

    @Basic
    @Column(name = "admin_id", nullable = false)
    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Centers centers = (Centers) o;

        if (id != centers.id) return false;
        if (locationId != centers.locationId) return false;
        if (fotoId != centers.fotoId) return false;
        if (adminId != centers.adminId) return false;
        if (title != null ? !title.equals(centers.title) : centers.title != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(centers.phoneNumber) : centers.phoneNumber != null) return false;
        if (rating != null ? !rating.equals(centers.rating) : centers.rating != null) return false;
        if (address != null ? !address.equals(centers.address) : centers.address != null) return false;
        if (numFields != null ? !numFields.equals(centers.numFields) : centers.numFields != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + locationId;
        result = 31 * result + fotoId;
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (numFields != null ? numFields.hashCode() : 0);
        result = 31 * result + adminId;
        return result;
    }
}
