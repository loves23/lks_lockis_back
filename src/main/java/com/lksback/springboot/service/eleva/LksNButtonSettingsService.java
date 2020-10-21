package com.lksback.springboot.service.eleva;


import com.lksback.springboot.dto.eleva.LksNbuttonSettingsDto;
import com.lksback.springboot.entity.eleva.LksNbuttonSettingsEntity;

import java.util.List;

/**
 * Created by Tree.Yip on 11/03/2020.
 */
public interface LksNButtonSettingsService {

    Integer countAll();

    LksNbuttonSettingsDto findOne(Integer id);

    LksNbuttonSettingsDto findByReference(String reference);

    //LksNbuttonSettingsDto findFirstByElevator(LksNelevatorDto lksNelevatorDto);

    LksNbuttonSettingsDto save(LksNbuttonSettingsDto LksNbuttonSettingsDto);

    LksNbuttonSettingsDto delete(LksNbuttonSettingsDto LksNbuttonSettingsDto);

    List<LksNbuttonSettingsDto> findAll();

    List<LksNbuttonSettingsDto> findAll(Integer page, Integer size);

    List<LksNbuttonSettingsDto> map(List<LksNbuttonSettingsEntity> source);

    List<LksNbuttonSettingsEntity> mapReversed(List<LksNbuttonSettingsDto> source);
}
