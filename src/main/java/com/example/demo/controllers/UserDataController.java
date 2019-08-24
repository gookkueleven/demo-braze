package com.example.demo.controllers;

import com.example.demo.models.InnerModel;
import com.example.demo.models.TestSerializeModel;
import com.example.demo.models.request.DeleteUserDataRequest;
import com.example.demo.models.request.EditUserDataRequest;
import com.example.demo.models.response.UserDeleteResponse;
import com.example.demo.models.response.UserTrackResponse;
import com.example.demo.services.BrazeUserDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/data")
public class UserDataController {

    private BrazeUserDataService brazeUserDataService;

    public UserDataController(BrazeUserDataService brazeUserDataService) {
        this.brazeUserDataService = brazeUserDataService;
    }

    @PostMapping("/track")
    public ResponseEntity<UserTrackResponse> getUserData(@RequestBody EditUserDataRequest editUserDataRequest) {
        return brazeUserDataService.addUserAttributes(editUserDataRequest);
    }

    @DeleteMapping("/track")
    public ResponseEntity<UserDeleteResponse> deleteUserData(@RequestBody DeleteUserDataRequest deleteUserDataRequest) {
        return brazeUserDataService.deleteUser(deleteUserDataRequest);
    }

    @GetMapping("/serialize")
    public TestSerializeModel getBahtSymbol() {
        InnerModel innerModel = new InnerModel();
        innerModel.setMessage("1000");

        TestSerializeModel testSerializeModel = new TestSerializeModel();
        testSerializeModel.setInner(innerModel);

        return testSerializeModel;
    }
}