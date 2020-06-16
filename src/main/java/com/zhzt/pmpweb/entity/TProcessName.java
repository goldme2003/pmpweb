package com.zhzt.pmpweb.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_ProcessName", schema = "PMPWEB", catalog = "")
public class TProcessName {
    private int pId;
    private String pName;
    private String details;

    @Id
    @Column(name = "pID", nullable = false)
    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    @Basic
    @Column(name = "pName", nullable = false, length = 255)
    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
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
        TProcessName that = (TProcessName) o;
        return pId == that.pId &&
                Objects.equals(pName, that.pName) &&
                Objects.equals(details, that.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pId, pName, details);
    }
}
