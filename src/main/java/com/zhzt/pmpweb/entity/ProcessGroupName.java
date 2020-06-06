package com.zhzt.pmpweb.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_ProcessGroupName", schema = "PMPWEB", catalog = "")
public class ProcessGroupName {
    private int pgId;
    private String pgName;

    @Id
    @Column(name = "pgID", nullable = false)
    public int getPgId() {
        return pgId;
    }

    public void setPgId(int pgId) {
        this.pgId = pgId;
    }

    @Basic
    @Column(name = "pgName", nullable = false, length = 255)
    public String getPgName() {
        return pgName;
    }

    public void setPgName(String pgName) {
        this.pgName = pgName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProcessGroupName that = (ProcessGroupName) o;
        return pgId == that.pgId &&
                Objects.equals(pgName, that.pgName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pgId, pgName);
    }
}
