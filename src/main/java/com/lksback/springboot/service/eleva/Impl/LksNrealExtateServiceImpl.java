package com.lksback.springboot.service.eleva.Impl;

import com.lksback.springboot.Repository.eleva.LksNrealExtateRepository;
import com.lksback.springboot.dto.eleva.LksNrealExtateDto;
import com.lksback.springboot.entity.eleva.LksNrealExtateEntity;
import com.lksback.springboot.service.eleva.LksNrealExtateService;
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
public class LksNrealExtateServiceImpl implements LksNrealExtateService {

    @Autowired
    private LksNrealExtateRepository model;

    /*todo: 不是很明白*/
    @Override
    public LksNrealExtateDto findOne(Integer id) {
        LksNrealExtateDto dto = new LksNrealExtateDto();
        Optional<LksNrealExtateEntity> LksNrealExtateEntity = model.findById(id);
        if (LksNrealExtateEntity.orElse(null)!=null){
            new ModelMapper().map(LksNrealExtateEntity.get(),dto );
        }
        return null;
    }
    /*todo: 不是很明白*/
    @Override
    public LksNrealExtateDto findByReference(String reference) {
        LksNrealExtateDto dto = new LksNrealExtateDto();
        LksNrealExtateEntity firstByReference = model.findFirstByReference(reference);
        if (firstByReference!=null){
            new ModelMapper().map(firstByReference, dto);
            return dto;
        }
        return null;
    }

    /*根据eleNelevator*/
 /*    @Override
   public LksNrealExtateDto findFirstByElevator(LksNelevatorDto lksNelevatorDto) {
        LksNrealExtateDto dto = new LksNrealExtateDto();
        LksNelevatorEntity lksNelevatorEntity = new LksNelevatorEntity();
        LksNrealExtateEntity firstByElevator = lksNbuttonSettingsRepository.findFirstByElevator(lksNelevatorEntity);
        if (firstByElevator!=null){
            new ModelMapper().map(firstByElevator, dto);
            return dto;
        }
        return null;
    }*/


    @Override
    public LksNrealExtateDto save(LksNrealExtateDto LksNrealExtateDto) {
        ModelMapper mapper = new ModelMapper();
        LksNrealExtateEntity LksNrealExtateEntity = new LksNrealExtateEntity();
        mapper.map(LksNrealExtateDto, LksNrealExtateEntity);
        LksNrealExtateEntity save = model.save(LksNrealExtateEntity);
        mapper.map(save, LksNrealExtateDto);
        return LksNrealExtateDto;
    }
    /*添加时间作为物理删除*/
    @Override
    public LksNrealExtateDto delete(LksNrealExtateDto LksNrealExtateDto) {
        LksNrealExtateDto.setPurged(new Timestamp(System.currentTimeMillis()));
        LksNrealExtateEntity LksNrealExtateEntity = new LksNrealExtateEntity();
        ModelMapper mapper = new ModelMapper();
        mapper.map(LksNrealExtateDto, LksNrealExtateEntity);

        /*这里调用了save方法*/
        LksNrealExtateEntity save = model.save(LksNrealExtateEntity);
        mapper.map(save, LksNrealExtateDto);
        return LksNrealExtateDto;
    }
    /*查总数*/
    @Override
    public Integer countAll() {
        return model.countAll();
    }

    @Override
    /*查询所有*/
    public List<LksNrealExtateDto> findAll() {
        return map(model.findAllByPurgedIsNullOrderByIdDesc());
    }

    @Override
    /*分页查询*/
    public List<LksNrealExtateDto> findAll(Integer page, Integer size) {
        return map(model.findAllByPurgedIsNullOrderByIdDesc(PageRequest.of(page, size)));
    }


    @Override
    public List<LksNrealExtateDto> map(List<LksNrealExtateEntity> source) {
        /* ModelMapper mapper = new ModelMapper();
        * 在项目中很多时候需要把Model和DTO两个模型类来回转换,
        * 保证Model对外是隐私的,同时类似密码之类的属性也能很好地避免暴露在外了.
           那么ModelMapper就是为了方便转换而实现的一个类库,下面根据使用场景不断增加案例.
        *
        * */
        ModelMapper mapper = new ModelMapper();
        ArrayList<LksNrealExtateDto> rtn = new ArrayList<>();
        for (LksNrealExtateEntity entity: source) {
            LksNrealExtateDto dto = new LksNrealExtateDto();
            mapper.map(entity, dto);
            rtn.add(dto);
        }
        return rtn;
    }

    @Override
    public List<LksNrealExtateEntity> mapReversed(List<LksNrealExtateDto> source) {
        ModelMapper mapper = new ModelMapper();
        ArrayList<LksNrealExtateEntity> rtn = new ArrayList<>();
        for (LksNrealExtateDto dto: source) {
            LksNrealExtateEntity entity = new LksNrealExtateEntity();
            mapper.map(dto, entity);
            rtn.add(entity);
        }
        return rtn;
    }

}
