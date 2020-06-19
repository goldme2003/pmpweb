package com.zhzt.pmpweb.entity;

import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_IttoItem", schema = "PMPWEB", catalog = "")
public class TIttoItem {
    private int ittoiId;
    private String ittoItemName;
    private String details;
    private int belongedIttoItemCateg;

    @Id
    @Column(name = "ittoiID", nullable = false)
    public int getIttoiId() {
        return ittoiId;
    }

    public void setIttoiId(int ittoiId) {
        this.ittoiId = ittoiId;
    }

    @Basic
    @Column(name = "ittoItemName", nullable = false, length = 255)
    public String getIttoItemName() {
        return ittoItemName;
    }

    public void setIttoItemName(String ittoItemName) {
        this.ittoItemName = ittoItemName;
    }

    @Basic
    @Column(name = "details", nullable = true, length = -1)
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Basic
    @Column(name = "belongedIttoItemCateg", nullable = false, length = 11)
    public int getBelongedIttoItemCateg() {
        return belongedIttoItemCateg;
    }

    public void setBelongedIttoItemCateg(int belongedIttoItemCateg) {
        this.belongedIttoItemCateg = belongedIttoItemCateg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TIttoItem tIttoItem = (TIttoItem) o;
        return ittoiId == tIttoItem.ittoiId &&
                Objects.equals(ittoItemName, tIttoItem.ittoItemName) &&
                Objects.equals(details, tIttoItem.details) &&
                Objects.equals(belongedIttoItemCateg, tIttoItem.belongedIttoItemCateg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ittoiId, ittoItemName, details);
    }
}
