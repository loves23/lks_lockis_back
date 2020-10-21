package com.lksback.springboot.service.eleva;

import com.lksback.springboot.dto.eleva.LksNmobileDevicesDto;
import com.lksback.springboot.entity.eleva.LksNmobileDevicesEntity;
import java.util.List;

/**
 * @Classname LksNbuttonSettingsRepository
 * @Description TODO
 * @Date 2020/10/2 10:53
 * @Created by 18416
 * @Auther: henk
 */
public interface LksNmobileDevicesService  {


    Integer countAll();

    LksNmobileDevicesDto findOne(Integer id);

    LksNmobileDevicesDto findByReference(String reference);

    //LksNmobileDevicesDto findFirstByElevator(LksNelevatorDto lksNelevatorDto);

    LksNmobileDevicesDto save(LksNmobileDevicesDto lksNmobileDevicesDto);

    LksNmobileDevicesDto delete(LksNmobileDevicesDto lksNmobileDevicesDto);

    List<LksNmobileDevicesDto> findAll();

    List<LksNmobileDevicesDto> findAll(Integer page, Integer size);

    List<LksNmobileDevicesDto> map(List<LksNmobileDevicesEntity> source);

    List<LksNmobileDevicesEntity> mapReversed(List<LksNmobileDevicesDto> source);
}
