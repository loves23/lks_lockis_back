package com.lksback.springboot.service.eleva.Impl;

import com.lksback.springboot.Repository.eleva.LksNbuildingRepository;
import com.lksback.springboot.dto.eleva.LksNbuildingDto;
import com.lksback.springboot.entity.eleva.LksNbuildingEntity;
import com.lksback.springboot.service.eleva.LksNbuildingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Tree.Yip on 11/02/2020.
 */
@Service
public class LksNbuildingServiceImpl implements LksNbuildingService {

    @Autowired
    private LksNbuildingRepository model;

    /*todo: id查询*/
    @Override
    public LksNbuildingDto  findOne(Integer id) {
        LksNbuildingDto dto = new LksNbuildingDto();
        Optional<LksNbuildingEntity> lksNbuildingEntity = model.findById(id);
        if (lksNbuildingEntity.orElse(null)!=null){
            new ModelMapper().map(lksNbuildingEntity.get(),dto );
        }
        return null;
    }
    /*todo: 根据UUID查询*/
    @Override
    public LksNbuildingDto findByReference(String reference) {
        LksNbuildingDto dto = new LksNbuildingDto();
        LksNbuildingEntity firstByReference = model.findFirstByReference(reference);
        if (firstByReference!=null){
            new ModelMapper().map(firstByReference, dto);
            return dto;
        }
        return null;
    }

    /*根据eleNelevator*/
 /*    @Override
   public LksNbuildingDto findFirstByElevator(LksNelevatorDto lksNelevatorDto) {
        LksNbuildingDto dto = new LksNbuildingDto();
        LksNelevatorEntity lksNelevatorEntity = new LksNelevatorEntity();
        LksNbuildingEntity firstByElevator = lksNbuttonSettingsRepository.findFirstByElevator(lksNelevatorEntity);
        if (firstByElevator!=null){
            new ModelMapper().map(firstByElevator, dto);
            return dto;
        }
        return null;
    }*/


    @Override
    public LksNbuildingDto save(LksNbuildingDto LksNbuildingDto) {
        ModelMapper mapper = new ModelMapper();
        LksNbuildingEntity LksNbuildingEntity = new LksNbuildingEntity();
        mapper.map(LksNbuildingDto, LksNbuildingEntity);
        LksNbuildingEntity save = model.save(LksNbuildingEntity);
        mapper.map(save, LksNbuildingDto);
        return LksNbuildingDto;
    }
    /*添加时间作为物理删除*/
    @Override
    public LksNbuildingDto delete(LksNbuildingDto LksNbuildingDto) {
        LksNbuildingDto.setPurged(new Timestamp(System.currentTimeMillis()));
        LksNbuildingEntity lksNbuildingEntity = new LksNbuildingEntity();
        ModelMapper mapper = new ModelMapper();
        mapper.map(LksNbuildingDto, lksNbuildingEntity);

        /*这里调用了save方法*/
        LksNbuildingEntity save = model.save(lksNbuildingEntity);
        mapper.map(save, LksNbuildingDto);
        return LksNbuildingDto;
    }
    /*查总数*/
    @Override
    public Integer countAll() {
        return model.countAll();
    }

    @Override
    /*查询所有*/
    public List<LksNbuildingDto> findAll() {
        return map(model.findAllByPurgedIsNullOrderByIdDesc());
    }

    @Override
    /*分页查询*/
    public List<LksNbuildingDto> findAll(Integer page, Integer size) {
        return map(model.findAllByPurgedIsNullOrderByIdDesc(PageRequest.of(page, size)));
    }


    @Override
    public List<LksNbuildingDto> map(List<LksNbuildingEntity> source) {
        /* ModelMapper mapper = new ModelMapper();
        * 在项目中很多时候需要把Model和DTO两个模型类来回转换,
        * 保证Model对外是隐私的,同时类似密码之类的属性也能很好地避免暴露在外了.
           那么ModelMapper就是为了方便转换而实现的一个类库,下面根据使用场景不断增加案例.
        *
        * */
        ModelMapper mapper = new ModelMapper();
        ArrayList<LksNbuildingDto> rtn = new ArrayList<>();
        for (LksNbuildingEntity entity: source) {
            LksNbuildingDto dto = new LksNbuildingDto();
            mapper.map(entity, dto);
            rtn.add(dto);
        }
        return rtn;
    }

    @Override
    public List<LksNbuildingEntity> mapReversed(List<LksNbuildingDto> source) {
        ModelMapper mapper = new ModelMapper();
        ArrayList<LksNbuildingEntity> rtn = new ArrayList<>();
        for (LksNbuildingDto dto: source) {
            LksNbuildingEntity entity = new LksNbuildingEntity();
            mapper.map(dto, entity);
            rtn.add(entity);
        }
        return rtn;
    }

}
