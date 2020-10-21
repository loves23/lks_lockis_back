package com.lksback.springboot.Repository.eleva;

import com.lksback.springboot.entity.eleva.LksNelevatorEntity;
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
public interface LksNelevatorRepository extends JpaRepository<LksNelevatorEntity,Integer> {


   @Query("SELECT COUNT(1) FROM LksNelevatorEntity WHERE purged IS NULL") Integer countAll();

    LksNelevatorEntity findFirstByReference(String reference);

    //LksNelevatorEntity findFirstByObject(LksNelevatorEntity lksNelevatorEntity);

    List<LksNelevatorEntity> findAllByPurgedIsNullOrderByIdDesc();

    List<LksNelevatorEntity> findAllByPurgedIsNullOrderByIdDesc(Pageable pageable);
}
