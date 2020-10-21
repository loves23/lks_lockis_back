package com.lksback.springboot.service.eleva.Impl;

import com.lksback.springboot.Repository.eleva.LksNmobileDevicesRepository;
import com.lksback.springboot.dto.eleva.LksNmobileDevicesDto;
import com.lksback.springboot.entity.eleva.LksNmobileDevicesEntity;
import com.lksback.springboot.service.eleva.LksNmobileDevicesService;
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
public class LksNmobileDevicesServiceImpl implements LksNmobileDevicesService {

    @Autowired
    private LksNmobileDevicesRepository model;

    /*todo: 不是很明白*/
    @Override
    public LksNmobileDevicesDto findOne(Integer id) {
        LksNmobileDevicesDto dto = new LksNmobileDevicesDto();
        Optional<LksNmobileDevicesEntity> LksNmobileDevicesEntity = model.findById(id);
        if (LksNmobileDevicesEntity.orElse(null)!=null){
            new ModelMapper().map(LksNmobileDevicesEntity.get(),dto );
        }
        return null;
    }
    /*todo: 不是很明白*/
    @Override
    public LksNmobileDevicesDto findByReference(String reference) {
        LksNmobileDevicesDto dto = new LksNmobileDevicesDto();
        LksNmobileDevicesEntity firstByReference = model.findFirstByReference(reference);
        if (firstByReference!=null){
            new ModelMapper().map(firstByReference, dto);
            return dto;
        }
        return null;
    }

    /*根据eleNelevator*/
 /*    @Override
   public LksNmobileDevicesDto findFirstByElevator(LksNelevatorDto lksNelevatorDto) {
        LksNmobileDevicesDto dto = new LksNmobileDevicesDto();
        LksNelevatorEntity lksNelevatorEntity = new LksNelevatorEntity();
        LksNmobileDevicesEntity firstByElevator = lksNbuttonSettingsRepository.findFirstByElevator(lksNelevatorEntity);
        if (firstByElevator!=null){
            new ModelMapper().map(firstByElevator, dto);
            return dto;
        }
        return null;
    }*/


    @Override
    public LksNmobileDevicesDto save(LksNmobileDevicesDto LksNmobileDevicesDto) {
        ModelMapper mapper = new ModelMapper();
        LksNmobileDevicesEntity lksNmobileDevicesEntity = new LksNmobileDevicesEntity();
        mapper.map(LksNmobileDevicesDto, lksNmobileDevicesEntity);
        LksNmobileDevicesEntity save = model.save(lksNmobileDevicesEntity);
        mapper.map(save, LksNmobileDevicesDto);
        return LksNmobileDevicesDto;
    }
    /*添加时间作为物理删除*/
    @Override
    public LksNmobileDevicesDto delete(LksNmobileDevicesDto LksNmobileDevicesDto) {
        LksNmobileDevicesDto.setPurged(new Timestamp(System.currentTimeMillis()));
        LksNmobileDevicesEntity lksNmobileDevicesEntity = new LksNmobileDevicesEntity();
        ModelMapper mapper = new ModelMapper();
        mapper.map(LksNmobileDevicesDto, lksNmobileDevicesEntity);

        /*这里调用了save方法*/
        LksNmobileDevicesEntity save = model.save(lksNmobileDevicesEntity);
        mapper.map(save, LksNmobileDevicesDto);
        return LksNmobileDevicesDto;
    }
    /*查总数*/
    @Override
    public Integer countAll() {
        return model.countAll();
    }

    @Override
    /*查询所有*/
    public List<LksNmobileDevicesDto> findAll() {
        return map(model.findAllByPurgedIsNullOrderByIdDesc());
    }

    @Override
    /*分页查询*/
    public List<LksNmobileDevicesDto> findAll(Integer page, Integer size) {
        return map(model.findAllByPurgedIsNullOrderByIdDesc(PageRequest.of(page, size)));
    }


    @Override
    public List<LksNmobileDevicesDto> map(List<LksNmobileDevicesEntity> source) {
        /* ModelMapper mapper = new ModelMapper();
        * 在项目中很多时候需要把Model和DTO两个模型类来回转换,
        * 保证Model对外是隐私的,同时类似密码之类的属性也能很好地避免暴露在外了.
           那么ModelMapper就是为了方便转换而实现的一个类库,下面根据使用场景不断增加案例.
        *
        * */
        ModelMapper mapper = new ModelMapper();
        ArrayList<LksNmobileDevicesDto> rtn = new ArrayList<>();
        for (LksNmobileDevicesEntity entity: source) {
            LksNmobileDevicesDto dto = new LksNmobileDevicesDto();
            mapper.map(entity, dto);
            rtn.add(dto);
        }
        return rtn;
    }

    @Override
    public List<LksNmobileDevicesEntity> mapReversed(List<LksNmobileDevicesDto> source) {
        ModelMapper mapper = new ModelMapper();
        ArrayList<LksNmobileDevicesEntity> rtn = new ArrayList<>();
        for (LksNmobileDevicesDto dto: source) {
            LksNmobileDevicesEntity entity = new LksNmobileDevicesEntity();
            mapper.map(dto, entity);
            rtn.add(entity);
        }
        return rtn;
    }

}
