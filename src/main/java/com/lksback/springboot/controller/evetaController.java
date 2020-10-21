package com.lksback.springboot.controller;

import com.lksback.springboot.Repository.eleva.LksNbuildingRepository;
import com.lksback.springboot.entity.eleva.LksNbuildingEntity;
import com.lksback.springboot.util.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @Classname evetaController
 * @Description TODO
 * @Date 2020/10/21 15:16
 * @Created by 18416
 * @Auther: henk
 */
@RestController
public class evetaController {

    @Autowired
    private LksNbuildingRepository buildingdao;
    @GetMapping(value = "/test",produces = {"text/plain;charset=UTF-8"})
    public String test(){
        Integer integer = buildingdao.countAll();
        String str = "查询的数字为:"+integer;
        List<LksNbuildingEntity> allByPurgedIsNullOrderByIdDesc = buildingdao.findAllByPurgedIsNullOrderByIdDesc();
        HashMap<String, Object> map = new HashMap<>();
        map.put("obj", allByPurgedIsNullOrderByIdDesc);
        String s = MapperUtils.mapToJson(map);
        return s;
    }
}
