package com.lksback.springboot.controller.eleva;


//import io.swagger.annotations.ApiOperation;
import com.lksback.springboot.dto.eleva.LksNbuttonSettingsDto;
import com.lksback.springboot.dto.exception.LksErrors;
import com.lksback.springboot.dto.exception.LksException;
import com.lksback.springboot.service.eleva.LksNButtonSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Classname LksNlockis
 * @Description TODO
 * @Date 2020/10/2 11:00
 * @Created by 18416
 * @Auther: henk
 */
@RestController
@RequestMapping("/buttonsettings")
public class LksNButtonSettingsEndpoint {
    @Autowired
    private LksNButtonSettingsService modelByService;

    /**
     * 总数
     * @return  Integer
     */

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public Integer countButtonSettings(){
        return modelByService.countAll();
    }

    /**
     * 查询全部
     * fetch ButtonSettings list
     * @return
     */

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<LksNbuttonSettingsDto> fetchButtonSettings(){
        return modelByService.findAll();
    }

    /**
     * 分页查询
     * fetch ButtonSettings list
     * @return
     */
    @RequestMapping(value = "/{page}/{size}", method = RequestMethod.GET)
    public List<LksNbuttonSettingsDto> fetchButtonSettings(@PathVariable Integer page
                                                                ,@PathVariable Integer size){
        return modelByService.findAll(page,size);
    }

    /**
     * 根据uuid 查对象
     * @return 对象
     */
    @RequestMapping(value = "/{reference}", method = RequestMethod.GET)
    public LksNbuttonSettingsDto fetchButtonSettings(@PathVariable String reference){
        LksNbuttonSettingsDto byReference = modelByService.findByReference(reference);
        if (byReference == null){
            throw new LksException(LksErrors.LKS_L_BRAND_NOT_EXISTS);
        }
        return modelByService.findByReference(reference);
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)

    public LksNbuttonSettingsDto SaveButtonSettings(@RequestBody LksNbuttonSettingsDto buttonDto){
        System.out.println("================");
        System.out.println("test:"+buttonDto.toString());
        buttonDto = modelByService.save(buttonDto);
        buttonDto = modelByService.findOne(buttonDto.getId());
        return buttonDto;
    }
    @RequestMapping(value = "/update", method = RequestMethod.PUT)

    public LksNbuttonSettingsDto UpdateButtonSettings(@RequestBody LksNbuttonSettingsDto buttonDto){
        LksNbuttonSettingsDto byReference = modelByService.findByReference(buttonDto.getReference());

        if (byReference==null){
            throw new LksException(LksErrors.LKS_K_CUSTOMER_NOT_EXISTS);
        }
        buttonDto.setId(byReference.getId());
        buttonDto = modelByService.save(buttonDto);
        return buttonDto;
    }

    @RequestMapping(value = "/{reference}/purge", method = RequestMethod.DELETE)

    public LksNbuttonSettingsDto deleteModel(@PathVariable String reference) {
        LksNbuttonSettingsDto deleteModelDto = modelByService.findByReference(reference);

        if (deleteModelDto == null) {
            throw new LksException(LksErrors.LKS_L_BRAND_NOT_EXISTS);
        }

        deleteModelDto = modelByService.delete(deleteModelDto);

        return deleteModelDto;
    }


}
