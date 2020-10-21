package com.lksback.springboot.entity.eleva;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @Classname LksNrealExtateEntity
 * @Description TODO
 * @Date 2020/10/21 17:02
 * @Created by 18416
 * @Auther: henk
 */
@Entity
@Table(name = "lks_nreal_extate", schema = "j2ee_20__lockis_elevator", catalog = "")
public class LksNrealExtateEntity {
    private int id;
    private String reference;
    private String name;
    private String englishName;
    private String address;
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
    @Column(name = "address", nullable = true, length = 128)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        LksNrealExtateEntity that = (LksNrealExtateEntity) o;
        return id == that.id &&
                Objects.equals(reference, that.reference) &&
                Objects.equals(name, that.name) &&
                Objects.equals(englishName, that.englishName) &&
                Objects.equals(address, that.address) &&
                Objects.equals(remarks, that.remarks) &&
                Objects.equals(made, that.made) &&
                Objects.equals(revised, that.revised) &&
                Objects.equals(purged, that.purged);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reference, name, englishName, address, remarks, made, revised, purged);
    }
}
