package com.lksback.springboot.service.eleva.Impl;

import com.lksback.springboot.Repository.eleva.LksNelevatorRepository;
import com.lksback.springboot.dto.eleva.LksNelevatorDto;
import com.lksback.springboot.entity.eleva.LksNelevatorEntity;
import com.lksback.springboot.service.eleva.LksNelevatorService;
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
public class LksNelevatorServiceImpl implements LksNelevatorService {

    @Autowired
    private LksNelevatorRepository model;

    /*todo: 不是很明白*/
    @Override
    public LksNelevatorDto findOne(Integer id) {
        LksNelevatorDto dto = new LksNelevatorDto();
        Optional<LksNelevatorEntity> lksNelevatorEntity= model.findById(id);
        if (lksNelevatorEntity.orElse(null)!=null){
            new ModelMapper().map(lksNelevatorEntity.get(),dto );
        }
        return null;
    }
    /*todo: 不是很明白*/
    @Override
    public LksNelevatorDto findByReference(String reference) {
        LksNelevatorDto dto = new LksNelevatorDto();
        LksNelevatorEntity firstByReference = model.findFirstByReference(reference);
        if (firstByReference!=null){
            new ModelMapper().map(firstByReference, dto);
            return dto;
        }
        return null;
    }

    /*根据eleNelevator*/
 /*    @Override
   public LksNelevatorDto findFirstByElevator(LksNelevatorDto lksNelevatorDto) {
        LksNelevatorDto dto = new LksNelevatorDto();
        LksNelevatorEntity lksNelevatorEntity = new LksNelevatorEntity();
        LksNelevatorEntity firstByElevator = lksNbuttonSettingsRepository.findFirstByElevator(lksNelevatorEntity);
        if (firstByElevator!=null){
            new ModelMapper().map(firstByElevator, dto);
            return dto;
        }
        return null;
    }*/


    @Override
    public LksNelevatorDto save(LksNelevatorDto LksNelevatorDto) {
        ModelMapper mapper = new ModelMapper();
        LksNelevatorEntity LksNelevatorEntity = new LksNelevatorEntity();
        mapper.map(LksNelevatorDto, LksNelevatorEntity);
        LksNelevatorEntity save = model.save(LksNelevatorEntity);
        mapper.map(save, LksNelevatorDto);
        return LksNelevatorDto;
    }
    /*添加时间作为物理删除*/
    @Override
    public LksNelevatorDto delete(LksNelevatorDto LksNelevatorDto) {
        LksNelevatorDto.setPurged(new Timestamp(System.currentTimeMillis()));
        LksNelevatorEntity lksNelevatorEntity = new LksNelevatorEntity();
        ModelMapper mapper = new ModelMapper();
        mapper.map(LksNelevatorDto, lksNelevatorEntity);

        /*这里调用了save方法*/
        LksNelevatorEntity save = model.save(lksNelevatorEntity);
        mapper.map(save, LksNelevatorDto);
        return LksNelevatorDto;
    }
    /*查总数*/
    @Override
    public Integer countAll() {
        return model.countAll();
    }

    @Override
    /*查询所有*/
    public List<LksNelevatorDto> findAll() {
        return map(model.findAllByPurgedIsNullOrderByIdDesc());
    }

    @Override
    /*分页查询*/
    public List<LksNelevatorDto> findAll(Integer page, Integer size) {
        return map(model.findAllByPurgedIsNullOrderByIdDesc(PageRequest.of(page, size)));
    }


    @Override
    public List<LksNelevatorDto> map(List<LksNelevatorEntity> source) {
        /* ModelMapper mapper = new ModelMapper();
        * 在项目中很多时候需要把Model和DTO两个模型类来回转换,
        * 保证Model对外是隐私的,同时类似密码之类的属性也能很好地避免暴露在外了.
           那么ModelMapper就是为了方便转换而实现的一个类库,下面根据使用场景不断增加案例.
        *
        * */
        ModelMapper mapper = new ModelMapper();
        ArrayList<LksNelevatorDto> rtn = new ArrayList<>();
        for (LksNelevatorEntity entity: source) {
            LksNelevatorDto dto = new LksNelevatorDto();
            mapper.map(entity, dto);
            rtn.add(dto);
        }
        return rtn;
    }

    @Override
    public List<LksNelevatorEntity> mapReversed(List<LksNelevatorDto> source) {
        ModelMapper mapper = new ModelMapper();
        ArrayList<LksNelevatorEntity> rtn = new ArrayList<>();
        for (LksNelevatorDto dto: source) {
            LksNelevatorEntity entity = new LksNelevatorEntity();
            mapper.map(dto, entity);
            rtn.add(entity);
        }
        return rtn;
    }

}
