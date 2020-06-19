package com.zhzt.pmpweb.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_IttoItemCateg", schema = "PMPWEB", catalog = "")
public class TIttoItemCateg {
    private int ittoCid;
    private String ittoCName;
    private String details;

    @Id
    @Column(name = "ittoCID", nullable = false)
    public int getIttoCid() {
        return ittoCid;
    }

    public void setIttoCid(int ittoCid) {
        this.ittoCid = ittoCid;
    }

    @Basic
    @Column(name = "ittoCName", nullable = false, length = 255)
    public String getIttoCName() {
        return ittoCName;
    }

    public void setIttoCName(String ittoCName) {
        this.ittoCName = ittoCName;
    }

    @Basic
    @Column(name = "details", nullable = true, length = -1)
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TIttoItemCateg that = (TIttoItemCateg) o;
        return ittoCid == that.ittoCid &&
                Objects.equals(ittoCName, that.ittoCName) &&
                Objects.equals(details, that.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ittoCid, ittoCName, details);
    }
}
