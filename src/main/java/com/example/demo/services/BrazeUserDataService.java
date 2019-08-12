package com.example.demo.services;

import com.example.demo.models.request.DeleteUserDataRequest;
import com.example.demo.models.request.EditUserDataRequest;
import com.example.demo.models.response.UserDeleteResponse;
import com.example.demo.models.response.UserTrackResponse;
import com.example.demo.services.clients.BrazeUserDataClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BrazeUserDataService {

    private BrazeUserDataClient brazeUserDataClient;

    public BrazeUserDataService(BrazeUserDataClient brazeUserDataClient) {
        this.brazeUserDataClient = brazeUserDataClient;
    }

    public ResponseEntity<UserTrackResponse> addUserAttributes(EditUserDataRequest editUserDataRequest) {
        return brazeUserDataClient.addUserAttributes(editUserDataRequest);
    }

    public ResponseEntity<UserDeleteResponse> deleteUser(DeleteUserDataRequest deleteUserDataRequest) {
        return brazeUserDataClient.deleteUser(deleteUserDataRequest);
    }


}
