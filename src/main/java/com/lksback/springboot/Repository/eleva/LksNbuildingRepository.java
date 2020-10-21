package com.lksback.springboot.Repository.eleva;

import com.lksback.springboot.entity.eleva.LksNbuildingEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Classname LksNbuildingService
 * @Description TODO
 * @Date 2020/10/2 10:53
 * @Created by 18416
 * @Auther: henk
 */
public interface LksNbuildingRepository extends  JpaRepository<LksNbuildingEntity,Integer> {


    @Query("SELECT COUNT(1) FROM LksNbuildingEntity WHERE purged IS NULL") Integer countAll();

    LksNbuildingEntity findFirstByReference(String reference);

    //LksNbuildingEntity findFirstByObject(LksNbuildingEntity lksNbuildingEntity);

    List<LksNbuildingEntity> findAllByPurgedIsNullOrderByIdDesc();

    List<LksNbuildingEntity> findAllByPurgedIsNullOrderByIdDesc(Pageable pageable);
}
