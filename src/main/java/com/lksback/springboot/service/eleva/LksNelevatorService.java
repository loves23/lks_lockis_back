package com.lksback.springboot.service.eleva;

import com.lksback.springboot.dto.eleva.LksNelevatorDto;
import com.lksback.springboot.entity.eleva.LksNelevatorEntity;


import java.util.List;

/**
 * @Classname LksNbuttonSettingsRepository
 * @Description TODO
 * @Date 2020/10/2 10:53
 * @Created by 18416
 * @Auther: henk
 */
public interface LksNelevatorService  {


    Integer countAll();

    LksNelevatorDto findOne(Integer id);

    LksNelevatorDto findByReference(String reference);

    //LksNbuttonSettingsDto findFirstByElevator(LksNelevatorDto lksNelevatorDto);

    LksNelevatorDto save(LksNelevatorDto lksNelevatorDto);

    LksNelevatorDto delete(LksNelevatorDto lksNelevatorDto);

    List<LksNelevatorDto> findAll();

    List<LksNelevatorDto> findAll(Integer page, Integer size);

    List<LksNelevatorDto> map(List<LksNelevatorEntity> source);

    List<LksNelevatorEntity> mapReversed(List<LksNelevatorDto> source);
}
