package com.example.easynotes.controller;

import com.example.easynotes.model.LoginUserModel;
import com.example.easynotes.repository.UserRegistrationRepository;
import com.example.easynotes.service.AmazonS3ClientServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserRegistrationRepository userRegistrationRepository;
    @Autowired
    private AmazonS3ClientServiceImpl amazonS3ClientService;

    Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @RequestMapping(value = "/validateLoginUser", method = RequestMethod.GET)
    public LoginUserModel validateLoginUser(@RequestParam String userName,@RequestParam String password) {
        System.out.println(userName.toString());
        // other statement
        Optional<UserRegistrationRepository> userRegistration = userRegistrationRepository.validateLoginUser(userName,password);
       /* HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);*/
        LoginUserModel loginUserModel1=new LoginUserModel();
        byte[] userImageFromS3 = this.amazonS3ClientService.getFileFromS3Bucket(userName);
        if(userImageFromS3!= null) {
            loginUserModel1.setImage(userImageFromS3);
        }
        loginUserModel1.setUserName(userName);
        loginUserModel1.setStatus(userRegistration.isPresent() ? "success": "Unauthorized");
        return loginUserModel1;
    }
}
