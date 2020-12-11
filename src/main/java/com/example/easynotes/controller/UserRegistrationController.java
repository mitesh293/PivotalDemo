package com.example.easynotes.controller;

import com.example.easynotes.model.LoginUserModel;
import com.example.easynotes.model.UserImage;
import com.example.easynotes.model.UserRegistrationModel;
import com.example.easynotes.repository.UserRegistrationRepository;
import com.example.easynotes.service.AmazonS3ClientServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
public class UserRegistrationController {
    @Autowired
    UserRegistrationRepository userRegistrationRepository;
    @Autowired
    private AmazonS3ClientServiceImpl amazonS3ClientService;

    @RequestMapping( method = RequestMethod.GET,value = "/getAllUserRegister", produces = {"application/JSON"})
   public @ResponseBody
    List<UserRegistrationModel> getAllUserRegister(){
        List<UserRegistrationModel> userRegistrationModelsList = userRegistrationRepository.findAll();
        for (UserRegistrationModel userRegistrationModel: userRegistrationModelsList) {
            byte[] userImageFromS3 = this.amazonS3ClientService.getFileFromS3Bucket(userRegistrationModel.getFirstName());
            if(userImageFromS3!= null)
                userRegistrationModel.setUserImage(new UserImage(userRegistrationModel.getFirstName(),"image",userImageFromS3));
        }
        log.info(" Logged getAllUserRegister()");
        return userRegistrationModelsList;
    }

    @RequestMapping(value = "/saveUserRegistration", method = RequestMethod.POST)
    public ResponseEntity<?> saveUserRegistration(@RequestBody UserRegistrationModel userRegistrationModel) {
        saveOrUpdate(userRegistrationModel);
        return ResponseEntity.ok().build();
    }
    @RequestMapping(value = "/deleteUserRegistration", method = RequestMethod.POST)
    public ResponseEntity<?> deleteUserRegistration(@RequestBody UserRegistrationModel userRegistrationModel) {
        System.out.println(userRegistrationModel.toString());
        this.amazonS3ClientService.deleteFileFromS3Bucket(userRegistrationModel.getFirstName());
        // other statement
        userRegistrationRepository.delete(userRegistrationModel);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/updateUserRegistration", method = RequestMethod.POST)
    public ResponseEntity<?> updateUserRegistration(@RequestBody UserRegistrationModel userRegistrationModel) {
        saveOrUpdate(userRegistrationModel);
        return ResponseEntity.ok().build();
    }

    public void saveOrUpdate(UserRegistrationModel userRegistrationModel){
        System.out.println("Calling server side save "+userRegistrationModel.toString());
        // other statement
        this.userRegistrationRepository.save(userRegistrationModel);
        log.debug("User saved/update successfully..");
        if(userRegistrationModel.getUserImage()!=null && userRegistrationModel.getUserImage().getImage()!=null){
            this.amazonS3ClientService.uploadFileToS3Bucket(userRegistrationModel.getFirstName(), userRegistrationModel.getUserImage().getImage());
        }
    }
}
