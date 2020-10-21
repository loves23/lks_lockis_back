package com.lksback.springboot.Repository.eleva;

import com.lksback.springboot.entity.eleva.LksNmobileDevicesEntity;
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
public interface LksNmobileDevicesRepository extends JpaRepository<LksNmobileDevicesEntity,Integer> {

    @Query("SELECT COUNT(1) FROM LksNmobileDevicesEntity WHERE purged IS NULL") Integer countAll();

    LksNmobileDevicesEntity findFirstByReference(String reference);

    //LksNmobileDevicesEntity findFirstByObject(LksNmobileDevicesEntity lksNmobileDevicesEntity);

    List<LksNmobileDevicesEntity> findAllByPurgedIsNullOrderByIdDesc();

    List<LksNmobileDevicesEntity> findAllByPurgedIsNullOrderByIdDesc(Pageable pageable);
}
