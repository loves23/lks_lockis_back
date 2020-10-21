package com.lksback.springboot.Repository.eleva;

import com.lksback.springboot.entity.eleva.LksNrealExtateEntity;
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
public interface LksNrealExtateRepository extends JpaRepository<LksNrealExtateEntity,Integer> {


    @Query("SELECT COUNT(1) FROM LksNrealExtateEntity WHERE purged IS NULL") Integer countAll();

    LksNrealExtateEntity findFirstByReference(String reference);

    //LksNbuttonSettingsEntity findFirstByObject(LksNrealExtateEntity lksNrealExtateEntity);

    List<LksNrealExtateEntity> findAllByPurgedIsNullOrderByIdDesc();

    List<LksNrealExtateEntity> findAllByPurgedIsNullOrderByIdDesc(Pageable pageable);
}
