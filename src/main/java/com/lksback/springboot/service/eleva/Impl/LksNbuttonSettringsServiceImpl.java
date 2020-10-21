package com.lksback.springboot.service.eleva.Impl;

import com.lksback.springboot.Repository.eleva.LksNbuttonSettingsRepository;
import com.lksback.springboot.dto.eleva.LksNbuttonSettingsDto;
import com.lksback.springboot.entity.eleva.LksNbuttonSettingsEntity;
import com.lksback.springboot.service.eleva.LksNButtonSettingsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by Tree.Yip on 11/02/2020.
 */
@Service
public class LksNbuttonSettringsServiceImpl implements LksNButtonSettingsService {

    @Autowired
    private LksNbuttonSettingsRepository lksNbuttonSettingsRepository;

    /*todo: 不是很明白*/
    @Override
    public LksNbuttonSettingsDto findOne(Integer id) {
        LksNbuttonSettingsDto dto = new LksNbuttonSettingsDto();
        Optional<LksNbuttonSettingsEntity> lksNbuttonSettingsEntity = lksNbuttonSettingsRepository.findById(id);
        if (lksNbuttonSettingsEntity.orElse(null)!=null){
            new ModelMapper().map(lksNbuttonSettingsEntity.get(),dto );
            return dto;
        }
        return null;
    }
    /*todo: 不是很明白*/
    @Override
    public LksNbuttonSettingsDto findByReference(String reference) {
        LksNbuttonSettingsDto dto = new LksNbuttonSettingsDto();
        LksNbuttonSettingsEntity firstByReference = lksNbuttonSettingsRepository.findFirstByReference(reference);
        if (firstByReference!=null){
            new ModelMapper().map(firstByReference, dto);
            return dto;
        }
        return null;
    }

    /*根据eleNelevator*/
 /*    @Override
   public LksNbuttonSettingsDto findFirstByElevator(LksNelevatorDto lksNelevatorDto) {
        LksNbuttonSettingsDto dto = new LksNbuttonSettingsDto();
        LksNelevatorEntity lksNelevatorEntity = new LksNelevatorEntity();
        LksNbuttonSettingsEntity firstByElevator = lksNbuttonSettingsRepository.findFirstByElevator(lksNelevatorEntity);
        if (firstByElevator!=null){
            new ModelMapper().map(firstByElevator, dto);
            return dto;
        }
        return null;
    }*/


    @Override
    public LksNbuttonSettingsDto save(LksNbuttonSettingsDto lksNbuttonSettingsDto) {
        ModelMapper mapper = new ModelMapper();
        LksNbuttonSettingsEntity lksNbuttonSettingsEntity = new LksNbuttonSettingsEntity();
        mapper.map(lksNbuttonSettingsDto, lksNbuttonSettingsEntity);
        LksNbuttonSettingsEntity save = lksNbuttonSettingsRepository.save(lksNbuttonSettingsEntity);
        mapper.map(save, lksNbuttonSettingsDto);
        return lksNbuttonSettingsDto;
    }
    /*添加时间作为物理删除*/
    @Override
    public LksNbuttonSettingsDto delete(LksNbuttonSettingsDto lksNbuttonSettingsDto) {
        lksNbuttonSettingsDto.setPurged(new Timestamp(System.currentTimeMillis()));
        LksNbuttonSettingsEntity lksNbuttonSettingsEntity = new LksNbuttonSettingsEntity();
        ModelMapper mapper = new ModelMapper();
        mapper.map(lksNbuttonSettingsDto, lksNbuttonSettingsEntity);

        /*这里调用了save方法*/
        LksNbuttonSettingsEntity save = lksNbuttonSettingsRepository.save(lksNbuttonSettingsEntity);
        mapper.map(save, lksNbuttonSettingsDto);
        return lksNbuttonSettingsDto;
    }
    /*查总数*/
    @Override
    public Integer countAll() {
        return lksNbuttonSettingsRepository.countAll();
    }

    @Override
    /*查询所有*/
    public List<LksNbuttonSettingsDto> findAll() {
        return map(lksNbuttonSettingsRepository.findAllByPurgedIsNullOrderByIdDesc());
    }

    @Override
    /*分页查询*/
    public List<LksNbuttonSettingsDto> findAll(Integer page, Integer size) {
        return map(lksNbuttonSettingsRepository.findAllByPurgedIsNullOrderByIdDesc(PageRequest.of(page, size)));
    }


    @Override
    public List<LksNbuttonSettingsDto> map(List<LksNbuttonSettingsEntity> source) {
        /* ModelMapper mapper = new ModelMapper();
        * 在项目中很多时候需要把Model和DTO两个模型类来回转换,
        * 保证Model对外是隐私的,同时类似密码之类的属性也能很好地避免暴露在外了.
           那么ModelMapper就是为了方便转换而实现的一个类库,下面根据使用场景不断增加案例.
        *
        * */
        ModelMapper mapper = new ModelMapper();
        ArrayList<LksNbuttonSettingsDto> rtn = new ArrayList<>();
        for (LksNbuttonSettingsEntity entity: source) {
            LksNbuttonSettingsDto dto = new LksNbuttonSettingsDto();
            mapper.map(entity, dto);
            rtn.add(dto);
        }
        return rtn;
    }

    @Override
    public List<LksNbuttonSettingsEntity> mapReversed(List<LksNbuttonSettingsDto> source) {
        ModelMapper mapper = new ModelMapper();
        ArrayList<LksNbuttonSettingsEntity> rtn = new ArrayList<>();
        for (LksNbuttonSettingsDto dto: source) {
            LksNbuttonSettingsEntity entity = new LksNbuttonSettingsEntity();
            mapper.map(dto, entity);
            rtn.add(entity);
        }
        return rtn;
    }



}
