package com.lksback.springboot.dto.eleva;

import com.lksback.springboot.entity.eleva.LksNelevatorEntity;
import java.sql.Timestamp;

/**
 * @Classname LksNbuttonSettingsDto(按钮设置)
 * @Description TODO
 * @Date 2020/10/2 10:30
 * @Created by 18416
 * @Auther: henk
 */
public class LksNbuttonSettingsDto {
    private int id;
    private String reference;
    private String buttonScheme;
    private String name;
    private String english_name;
    private LksNelevatorEntity LksNelevator;
    private Timestamp effective_date;
    private Timestamp deadline;
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

    public String getButtonScheme() {
        return buttonScheme;
    }

    public void setButtonScheme(String buttonScheme) {
        this.buttonScheme = buttonScheme;
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

    public LksNelevatorEntity getLksNelevator() {
        return LksNelevator;
    }

    public void setLksNelevator(LksNelevatorEntity LksNelevator) {
        this.LksNelevator = LksNelevator;
    }

    public Timestamp getEffective_date() {
        return effective_date;
    }

    public void setEffective_date(Timestamp effective_date) {
        this.effective_date = effective_date;
    }

    public Timestamp getDeadline() {
        return deadline;
    }

    public void setDeadline(Timestamp deadline) {
        this.deadline = deadline;
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
