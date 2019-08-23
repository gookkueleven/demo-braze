package com.example.demo.services.clients;

import com.example.demo.configurations.BrazeConfiguration;
import com.example.demo.models.request.DeleteUserDataRequest;
import com.example.demo.models.request.EditUserDataRequest;
import com.example.demo.models.request.UserDeleteRequest;
import com.example.demo.models.request.UserTrackRequest;
import com.example.demo.models.response.UserDeleteResponse;
import com.example.demo.models.response.UserTrackResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BrazeUserDataClient {

    public static final String BRAZE_EXTERNAL_ID = "external_id";

    private RestTemplate defaultRestTemplate;

    private BrazeConfiguration brazeConfiguration;

    public BrazeUserDataClient(RestTemplate defaultRestTemplate, BrazeConfiguration brazeConfiguration) {
        this.defaultRestTemplate = defaultRestTemplate;
        this.brazeConfiguration = brazeConfiguration;
    }

    public ResponseEntity<UserTrackResponse> addUserAttributes(EditUserDataRequest editUserDataRequest) {
        String url = brazeConfiguration.getUserTrackEndPoint();

        UserTrackRequest userTrackRequest = createBrazeUserTrackRequest(editUserDataRequest);
        try {
            return defaultRestTemplate.postForEntity(url, userTrackRequest, UserTrackResponse.class);
        } catch (HttpStatusCodeException e) {
            UserTrackResponse response = new UserTrackResponse();
            response.setMessage("error");
            return new ResponseEntity<>(response, e.getStatusCode());
        }
    }

    private UserTrackRequest createBrazeUserTrackRequest(EditUserDataRequest editUserDataRequest) {
        List<Map<String, String>> requestUserAttributes = createAttributesListWithExternalId(editUserDataRequest);

        UserTrackRequest userTrackRequest = new UserTrackRequest();
        userTrackRequest.setApiKey(brazeConfiguration.getApiKey());
        userTrackRequest.setUserAttributesList(requestUserAttributes);
        return userTrackRequest;
    }

    private List<Map<String, String>> createAttributesListWithExternalId(EditUserDataRequest editUserDataRequest) {
        return editUserDataRequest.getUserDataAttributes()
                    .stream().map(editUserDataAttributes -> {
                        editUserDataAttributes.getAttributes().put(BRAZE_EXTERNAL_ID, editUserDataAttributes.getTmnId());
                        return editUserDataAttributes.getAttributes();
                    }).collect(Collectors.toList());
    }

    public ResponseEntity<UserDeleteResponse> deleteUser(DeleteUserDataRequest deleteUserDataRequest) {
        String url = brazeConfiguration.getUserDeleteEndPoint();

        UserDeleteRequest userDeleteRequest = createBrazeUserDeleteRequest(deleteUserDataRequest);
        try {
            return defaultRestTemplate.postForEntity(url, userDeleteRequest, UserDeleteResponse.class);
        } catch (HttpStatusCodeException e) {
            UserDeleteResponse userDeleteResponse = new UserDeleteResponse();
            userDeleteResponse.setMessage("error");

            return new ResponseEntity<>(userDeleteResponse, e.getStatusCode());
        }
    }

    private UserDeleteRequest createBrazeUserDeleteRequest(DeleteUserDataRequest deleteUserDataRequest) {
        UserDeleteRequest userDeleteRequest = new UserDeleteRequest();

        userDeleteRequest.setApiKey(brazeConfiguration.getApiKey());
        userDeleteRequest.setExternalIdList(deleteUserDataRequest.getDeleteUserList());
        return userDeleteRequest;
    }
}
