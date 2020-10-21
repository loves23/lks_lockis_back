package com.lksback.springboot.dto.eleva;

import java.sql.Timestamp;

/**
 * @Classname LksNrealExtateDto(楼盘)
 * @Description TODO
 * @Date 2020/10/4 16:17
 * @Created by 18416
 * @Auther: henk
 */

public class LksNrealExtateDto {
    private int id;
    private String reference;
    private String name;
    private String english_name;
    private String address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
