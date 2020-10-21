package com.lksback.springboot.service.eleva;

import com.lksback.springboot.dto.eleva.LksNbuildingDto;
import com.lksback.springboot.entity.eleva.LksNbuildingEntity;


import java.util.List;

/**
 * @Classname LksNbuildingService
 * @Description TODO
 * @Date 2020/10/2 10:53
 * @Created by 18416
 * @Auther: henk
 */
public interface LksNbuildingService {


    Integer countAll();

    LksNbuildingDto findOne(Integer id);

    LksNbuildingDto findByReference(String reference);

    //LksNbuildingDto findFirstByElevator(LksNbuildingDto lysNbuildingDto);

    LksNbuildingDto save(LksNbuildingDto lksNbuildingDto);

    LksNbuildingDto delete(LksNbuildingDto lksNbuildingDto);

    List<LksNbuildingDto> findAll();

    List<LksNbuildingDto> findAll(Integer page, Integer size);

    List<LksNbuildingDto> map(List<LksNbuildingEntity> source);

    List<LksNbuildingEntity> mapReversed(List<LksNbuildingDto> source);
}
