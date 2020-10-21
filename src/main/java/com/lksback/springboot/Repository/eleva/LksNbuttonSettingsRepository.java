package com.lksback.springboot.Repository.eleva;

import com.lksback.springboot.entity.eleva.LksNbuttonSettingsEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Classname LksNbuttonSettingsRepository
 * @Description TODO
 * @Date 2020/10/2 10:53
 * @Created by 18416
 * @Auther: henk
 */
public interface LksNbuttonSettingsRepository extends JpaRepository<LksNbuttonSettingsEntity,Integer> {


    @Query("SELECT COUNT(1) FROM LksNbuttonSettingsEntity WHERE purged IS NULL") Integer countAll();

    LksNbuttonSettingsEntity findFirstByReference(String reference);

    //LksNbuttonSettingsEntity findFirstByObject(LksNelevatorEntity lksNelevatorEntity);

    List<LksNbuttonSettingsEntity> findAllByPurgedIsNullOrderByIdDesc();

    List<LksNbuttonSettingsEntity> findAllByPurgedIsNullOrderByIdDesc(Pageable pageable);
}
