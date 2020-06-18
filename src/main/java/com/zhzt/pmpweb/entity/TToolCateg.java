package com.zhzt.pmpweb.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_ToolCateg", schema = "PMPWEB", catalog = "")
public class TToolCateg {
    private int tcId;
    private String tcName;

    @Id
    @Column(name = "tcID", nullable = false)
    public int getTcId() {
        return tcId;
    }

    public void setTcId(int tcId) {
        this.tcId = tcId;
    }

    @Basic
    @Column(name = "tcName", nullable = false, length = 255)
    public String getTcName() {
        return tcName;
    }

    public void setTcName(String tcName) {
        this.tcName = tcName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TToolCateg that = (TToolCateg) o;
        return tcId == that.tcId &&
                Objects.equals(tcName, that.tcName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tcId, tcName);
    }
}
