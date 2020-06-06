package com.zhzt.pmpweb.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_KnowledgeScopeName", schema = "PMPWEB", catalog = "")
public class TKnowledgeName {
    private int ksId;
    private String ksName;

    @Id
    @Column(name = "ksID", nullable = false)
    public int getKsId() {
        return ksId;
    }

    public void setKsId(int ksId) {
        this.ksId = ksId;
    }

    @Basic
    @Column(name = "ks_name", nullable = false, length = 255)
    public String getKsName() {
        return ksName;
    }

    public void setKsName(String ksName) {
        this.ksName = ksName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TKnowledgeName that = (TKnowledgeName) o;
        return ksId == that.ksId &&
                Objects.equals(ksName, that.ksName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ksId, ksName);
    }
}
