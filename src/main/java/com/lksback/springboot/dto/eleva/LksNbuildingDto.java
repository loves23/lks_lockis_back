package com.lksback.springboot.dto.eleva;

import com.lksback.springboot.entity.eleva.LksNrealExtateEntity;

import java.sql.Timestamp;

/**
 * @Classname LksNbuildingDto(建筑物)
 * @Description TODO
 * @Date 2020/10/4 16:17
 * @Created by 18416
 * @Auther: henk
 */

public class LksNbuildingDto {
    private int id;
    private String reference;
    private String name;
    private String english_name;
    private String floorNumber;
    private LksNrealExtateEntity LksNrealExtate;
    private String remarks;
    private Timestamp made;
    private Timestamp revised;
    private Timestamp purged;
    public int getId() {
        return id;
    }

    public String getEnglish_name() {
        return english_name;
    }

    public void setEnglish_name(String english_name) {
        this.english_name = english_name;
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

    public String getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(String floorNumber) {
        this.floorNumber = floorNumber;
    }

    public LksNrealExtateEntity getLksNrealExtate() {
        return LksNrealExtate;
    }

    public void setLksNrealExtate(LksNrealExtateEntity LksNrealExtate) {
        this.LksNrealExtate = LksNrealExtate;
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
