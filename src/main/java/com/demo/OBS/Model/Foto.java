package com.demo.OBS.Model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Foto {
    private int id;
    private String foto1;
    private String foto2;
    private String foto3;
    private String foto4;
    private String foto5;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "foto1", nullable = false, length = 100)
    public String getFoto1() {
        return foto1;
    }

    public void setFoto1(String foto1) {
        this.foto1 = foto1;
    }

    @Basic
    @Column(name = "foto2", nullable = true, length = 100)
    public String getFoto2() {
        return foto2;
    }

    public void setFoto2(String foto2) {
        this.foto2 = foto2;
    }

    @Basic
    @Column(name = "foto3", nullable = true, length = 100)
    public String getFoto3() {
        return foto3;
    }

    public void setFoto3(String foto3) {
        this.foto3 = foto3;
    }

    @Basic
    @Column(name = "foto4", nullable = true, length = 100)
    public String getFoto4() {
        return foto4;
    }

    public void setFoto4(String foto4) {
        this.foto4 = foto4;
    }

    @Basic
    @Column(name = "foto5", nullable = true, length = 100)
    public String getFoto5() {
        return foto5;
    }

    public void setFoto5(String foto5) {
        this.foto5 = foto5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Foto foto = (Foto) o;

        if (id != foto.id) return false;
        if (foto1 != null ? !foto1.equals(foto.foto1) : foto.foto1 != null) return false;
        if (foto2 != null ? !foto2.equals(foto.foto2) : foto.foto2 != null) return false;
        if (foto3 != null ? !foto3.equals(foto.foto3) : foto.foto3 != null) return false;
        if (foto4 != null ? !foto4.equals(foto.foto4) : foto.foto4 != null) return false;
        if (foto5 != null ? !foto5.equals(foto.foto5) : foto.foto5 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (foto1 != null ? foto1.hashCode() : 0);
        result = 31 * result + (foto2 != null ? foto2.hashCode() : 0);
        result = 31 * result + (foto3 != null ? foto3.hashCode() : 0);
        result = 31 * result + (foto4 != null ? foto4.hashCode() : 0);
        result = 31 * result + (foto5 != null ? foto5.hashCode() : 0);
        return result;
    }
}
