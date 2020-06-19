package com.zhzt.pmpweb.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_Tool", schema = "PMPWEB", catalog = "")
public class TTool {
    private int tId;
    private String toolName;
    private String details;
    private int belongedToolCateg;

    @Id
    @Column(name = "tID", nullable = false)
    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    @Basic
    @Column(name = "toolName", nullable = false, length = 255)
    public String getToolName() {
        return toolName;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName;
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
    @Column(name = "belongedToolCateg", nullable = false, length = 11)
    public int getBelongedToolCateg() {
        return belongedToolCateg;
    }

    public void setBelongedToolCateg(int belongedToolCateg) {
        this.belongedToolCateg = belongedToolCateg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TTool tTool = (TTool) o;
        return tId == tTool.tId &&
                Objects.equals(toolName, tTool.toolName) &&
                Objects.equals(details, tTool.details) &&
                Objects.equals(belongedToolCateg, tTool.belongedToolCateg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tId, toolName, details, belongedToolCateg);
    }
}
