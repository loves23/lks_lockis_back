package com.lksback.springboot.entity.eleva;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @Classname LksNmobileDevicesEntity
 * @Description TODO
 * @Date 2020/10/21 17:02
 * @Created by 18416
 * @Auther: henk
 */
@Entity
@Table(name = "lks_nmobile_devices", schema = "j2ee_20__lockis_elevator", catalog = "")
public class LksNmobileDevicesEntity {
    private int id;
    private String reference;
    private String name;
    private String englishName;
    private String useTheSystem;
    private String model;
    private Integer user;
    private Integer elevatorId;
    private Integer buildingId;
    private Integer realExtateId;
    private String qrCode;
    private String deviceCode;
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
    @Column(name = "use_the_system", nullable = true, length = 10)
    public String getUseTheSystem() {
        return useTheSystem;
    }

    public void setUseTheSystem(String useTheSystem) {
        this.useTheSystem = useTheSystem;
    }

    @Basic
    @Column(name = "model", nullable = true, length = 10)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "user", nullable = true)
    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
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
    @Column(name = "building_id", nullable = true)
    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    @Basic
    @Column(name = "real_extate_id", nullable = true)
    public Integer getRealExtateId() {
        return realExtateId;
    }

    public void setRealExtateId(Integer realExtateId) {
        this.realExtateId = realExtateId;
    }

    @Basic
    @Column(name = "qr_code", nullable = true, length = 10)
    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    @Basic
    @Column(name = "device_code", nullable = true, length = 10)
    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
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
        LksNmobileDevicesEntity that = (LksNmobileDevicesEntity) o;
        return id == that.id &&
                Objects.equals(reference, that.reference) &&
                Objects.equals(name, that.name) &&
                Objects.equals(englishName, that.englishName) &&
                Objects.equals(useTheSystem, that.useTheSystem) &&
                Objects.equals(model, that.model) &&
                Objects.equals(user, that.user) &&
                Objects.equals(elevatorId, that.elevatorId) &&
                Objects.equals(buildingId, that.buildingId) &&
                Objects.equals(realExtateId, that.realExtateId) &&
                Objects.equals(qrCode, that.qrCode) &&
                Objects.equals(deviceCode, that.deviceCode) &&
                Objects.equals(remarks, that.remarks) &&
                Objects.equals(made, that.made) &&
                Objects.equals(revised, that.revised) &&
                Objects.equals(purged, that.purged);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reference, name, englishName, useTheSystem, model, user, elevatorId, buildingId, realExtateId, qrCode, deviceCode, remarks, made, revised, purged);
    }
}
