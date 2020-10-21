package com.lksback.springboot.controller.eleva;

import com.lksback.springboot.dto.eleva.LksNelevatorDto;
import com.lksback.springboot.dto.exception.LksErrors;
import com.lksback.springboot.dto.exception.LksException;
import com.lksback.springboot.service.eleva.LksNelevatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Classname LksNElevatorEndpoint
 * @Description TODO
 * @Date 2020/10/8 23:31
 * @Created by 18416
 * @Auther: henk
 */
@RestController
@RequestMapping("/elevator")
public class LksNElevatorEndpoint {

    @Autowired
    private LksNelevatorService modelByService;



    /**
     * 总数
     * @return  Integer
     */

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public Integer countAllByModel(){
        return modelByService.countAll();
    }

    /**
     * 查询全部
     * fetch elevator list
     * @return
     */

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<LksNelevatorDto> fetchelevator(){
        return modelByService.findAll();
    }

    /**
     * 分页查询
     * fetch elevator list
     * @return
     */
    @RequestMapping(value = "/{page}/{size}", method = RequestMethod.GET)
    public List<LksNelevatorDto> fetchelevator(@PathVariable Integer page
            , @PathVariable Integer size){
        return modelByService.findAll(page,size);
    }

    /**
     * 根据uuid 查对象
     * @return 对象
     */
    @RequestMapping(value = "/{reference}", method = RequestMethod.GET)
    public LksNelevatorDto fetchelevator(@PathVariable String reference){
        LksNelevatorDto byReference = modelByService.findByReference(reference);
        if (byReference == null){
            throw new LksException(LksErrors.LKS_L_BRAND_NOT_EXISTS);
        }
        return modelByService.findByReference(reference);
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public LksNelevatorDto Saveelevator(@RequestBody LksNelevatorDto modelDto){
        System.out.println("================");
        System.out.println("test:"+modelDto.toString());
        modelDto = modelByService.save(modelDto);
        modelDto = modelByService.findOne(modelDto.getId());
        return modelDto;
    }
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public LksNelevatorDto Updateelevator(@RequestBody LksNelevatorDto modelDto){
        LksNelevatorDto byReference = modelByService.findByReference(modelDto.getReference());

        if (byReference==null){
            throw new LksException(LksErrors.LKS_K_CUSTOMER_NOT_EXISTS);
        }
        modelDto.setId(byReference.getId());
        modelDto = modelByService.save(modelDto);
        return modelDto;
    }

    @RequestMapping(value = "/{reference}/purge", method = RequestMethod.DELETE)
    public LksNelevatorDto deleteModel(@PathVariable String reference) {
        LksNelevatorDto deleteModelDto = modelByService.findByReference(reference);

        if (deleteModelDto == null) {
            throw new LksException(LksErrors.LKS_L_BRAND_NOT_EXISTS);
        }

        deleteModelDto = modelByService.delete(deleteModelDto);

        return deleteModelDto;
    }



}
