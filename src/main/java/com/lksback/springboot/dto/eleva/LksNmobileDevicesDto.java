package com.lksback.springboot.dto.eleva;

import com.lksback.springboot.entity.eleva.LksNbuildingEntity;
import com.lksback.springboot.entity.eleva.LksNelevatorEntity;
import com.lksback.springboot.entity.eleva.LksNrealExtateEntity;
import java.sql.Timestamp;

/**
 * @Classname LksNmobileDevicesDto(移动设备)
 * @Description TODO
 * @Date 2020/10/4 16:17
 * @Created by 18416
 * @Auther: henk
 */

public class LksNmobileDevicesDto {
    private int id;
    private String reference;
    private String name;
    private String english_name;
    private String useTheSystem;
    private String model;
    private int user;
    private LksNelevatorEntity LksNelevator;
    private LksNbuildingEntity LksNbuilding;
    private LksNrealExtateEntity LksNrealExtate;
    private String qrCode;
    private String deviceCode;
    private String remarks;
    private Timestamp made;
    private Timestamp revised;
    private Timestamp purged;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnglish_name() {
        return english_name;
    }

    public void setEnglish_name(String english_name) {
        this.english_name = english_name;
    }

    public String getUseTheSystem() {
        return useTheSystem;
    }

    public void setUseTheSystem(String useTheSystem) {
        this.useTheSystem = useTheSystem;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LksNelevatorEntity getLksNelevator() {
        return LksNelevator;
    }

    public void setLksNelevator(LksNelevatorEntity LksNelevator) {
        this.LksNelevator = LksNelevator;
    }

    public LksNbuildingEntity getLksNbuilding() {
        return LksNbuilding;
    }

    public void setLksNbuilding(LksNbuildingEntity LksNbuilding) {
        this.LksNbuilding = LksNbuilding;
    }

    public LksNrealExtateEntity getLksNrealExtate() {
        return LksNrealExtate;
    }

    public void setLksNrealExtate(LksNrealExtateEntity LksNrealExtate) {
        this.LksNrealExtate = LksNrealExtate;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Timestamp getMade() {
        return made;
    }

    public void setMade(Timestamp made) {
        this.made = made;
    }

    public Timestamp getRevised() {
        return revised;
    }

    public void setRevised(Timestamp revised) {
        this.revised = revised;
    }

    public Timestamp getPurged() {
        return purged;
    }

    public void setPurged(Timestamp purged) {
        this.purged = purged;
    }

}
