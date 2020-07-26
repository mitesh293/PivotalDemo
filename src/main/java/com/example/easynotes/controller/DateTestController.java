package com.example.easynotes.controller;

import com.example.easynotes.model.ResponseObject;
import org.springframework.boot.system.ApplicationTemp;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DateTestController {

    @RequestMapping(value={"/"}, method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(name = "status",required = false) String status){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        System.out.println("index called...");
        return modelAndView;
    }

    @GetMapping(value="consumer/dashboard")
    public ResponseObject getCriteria(@RequestParam(name="startDate", required = false) String startDate,@RequestParam(name="endDate", required = false) String endDate){
        ResponseObject responseObject=new ResponseObject();
        responseObject.setStartDate(startDate);
        responseObject.setEndDate(endDate);
        responseObject.setOrderCount(150000);
        responseObject.setTotalRevenue(2536444);

        return responseObject;
    }
}
