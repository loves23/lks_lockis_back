package com.lksback.springboot.service.eleva;


import com.lksback.springboot.dto.eleva.LksNrealExtateDto;
import com.lksback.springboot.entity.eleva.LksNrealExtateEntity;

import java.util.List;

/**
 * @Classname LksNbuttonSettingsRepository
 * @Description TODO
 * @Date 2020/10/2 10:53
 * @Created by 18416
 * @Auther: henk
 */
public interface LksNrealExtateService{


    Integer countAll();

    LksNrealExtateDto findOne(Integer id);

    LksNrealExtateDto findByReference(String reference);

    //LksNrealExtateDto findFirstByElevator(LksNelevatorDto lksNelevatorDto);

    LksNrealExtateDto save(LksNrealExtateDto LksNrealExtateDto);

    LksNrealExtateDto delete(LksNrealExtateDto LksNrealExtateDto);

    List<LksNrealExtateDto> findAll();

    List<LksNrealExtateDto> findAll(Integer page, Integer size);

    List<LksNrealExtateDto> map(List<LksNrealExtateEntity> source);

    List<LksNrealExtateEntity> mapReversed(List<LksNrealExtateDto> source);
}
