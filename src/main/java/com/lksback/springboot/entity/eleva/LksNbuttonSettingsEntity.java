package com.lksback.springboot.entity.eleva;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @Classname LksNbuttonSettingsEntity
 * @Description TODO
 * @Date 2020/10/21 17:02
 * @Created by 18416
 * @Auther: henk
 */
@Entity
@Table(name = "lks_nbutton_settings", schema = "j2ee_20__lockis_elevator", catalog = "")
public class LksNbuttonSettingsEntity {
    private int id;
    private String reference;
    private String buttonScheme;
    private String name;
    private String englishName;
    private Integer elevatorId;
    private Timestamp effectiveDate;
    private Timestamp deadline;
    private String remarks;
    private Timestamp made;
    private Timestamp revised;
    private Timestamp purged;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "reference", nullable = true, length = 36)
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Basic
    @Column(name = "button_scheme", nullable = true, length = 128)
    public String getButtonScheme() {
        return buttonScheme;
    }

    public void setButtonScheme(String buttonScheme) {
        this.buttonScheme = buttonScheme;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 128)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "english_name", nullable = true, length = 128)
    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    @Basic
    @Column(name = "elevator_id", nullable = true)
    public Integer getElevatorId() {
        return elevatorId;
    }

    public void setElevatorId(Integer elevatorId) {
        this.elevatorId = elevatorId;
    }

    @Basic
    @Column(name = "effective_date", nullable = true)
    public Timestamp getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Timestamp effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    @Basic
    @Column(name = "deadline", nullable = true)
    public Timestamp getDeadline() {
        return deadline;
    }

    public void setDeadline(Timestamp deadline) {
        this.deadline = deadline;
    }

    @Basic
    @Column(name = "remarks", nullable = true, length = 10)
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Basic
    @Column(name = "made", nullable = false)
    public Timestamp getMade() {
        return made;
    }

    public void setMade(Timestamp made) {
        this.made = made;
    }

    @Basic
    @Column(name = "revised", nullable = true)
    public Timestamp getRevised() {
        return revised;
    }

    public void setRevised(Timestamp revised) {
        this.revised = revised;
    }

    @Basic
    @Column(name = "purged", nullable = true)
    public Timestamp getPurged() {
        return purged;
    }

    public void setPurged(Timestamp purged) {
        this.purged = purged;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LksNbuttonSettingsEntity that = (LksNbuttonSettingsEntity) o;
        return id == that.id &&
                Objects.equals(reference, that.reference) &&
                Objects.equals(buttonScheme, that.buttonScheme) &&
                Objects.equals(name, that.name) &&
                Objects.equals(englishName, that.englishName) &&
                Objects.equals(elevatorId, that.elevatorId) &&
                Objects.equals(effectiveDate, that.effectiveDate) &&
                Objects.equals(deadline, that.deadline) &&
                Objects.equals(remarks, that.remarks) &&
                Objects.equals(made, that.made) &&
                Objects.equals(revised, that.revised) &&
                Objects.equals(purged, that.purged);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reference, buttonScheme, name, englishName, elevatorId, effectiveDate, deadline, remarks, made, revised, purged);
    }
}
