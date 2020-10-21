package com.lksback.springboot.dto.eleva;

import com.lksback.springboot.entity.eleva.LksNbuildingEntity;
import com.lksback.springboot.entity.eleva.LksNbuttonSettingsEntity;


import java.sql.Timestamp;

/**
 * @Classname LksNelevatorDto(电梯)
 * @Description TODO
 * @Date 2020/10/4 16:17
 * @Created by 18416
 * @Auther: henk
 */

public class LksNelevatorDto {
    private int id;
    private String reference;
    private String name;
    private String english_name;
    private String sn_code;
    private String mac_code;
    private String key_code;
    private LksNbuttonSettingsEntity lksNbuttonSettingsEntity;
    private LksNbuildingEntity lksNbuilding;
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

    public String getSn_code() {
        return sn_code;
    }

    public void setSn_code(String sn_code) {
        this.sn_code = sn_code;
    }

    public String getMac_code() {
        return mac_code;
    }

    public void setMac_code(String mac_code) {
        this.mac_code = mac_code;
    }

    public String getKey_code() {
        return key_code;
    }

    public void setKey_code(String key_code) {
        this.key_code = key_code;
    }

    public LksNbuttonSettingsEntity getLksNbuttonSettingsEntity() {
        return lksNbuttonSettingsEntity;
    }

    public void setLksNbuttonSettingsEntity(LksNbuttonSettingsEntity LksNbuttonSettingsEntity) {
        this.lksNbuttonSettingsEntity = LksNbuttonSettingsEntity;
    }

    public LksNbuildingEntity getLksNbuilding() {
        return lksNbuilding;
    }

    public void setLksNbuilding(LksNbuildingEntity LksNbuilding) {
        this.lksNbuilding = LksNbuilding;
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
