package com.can.springbootsoap.endpoint;

import com.can.springbootsoap.service.UserService;
import com.client.springbootsoap.*;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.BeanUtils;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Endpoint
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class UserEndPoint {

    UserService userService;
    private static final String NAMESPACE_URI = "http://springbootsoap.client.com";


    @ResponsePayload
    @PayloadRoot(namespace= NAMESPACE_URI, localPart="getUserRequest")
    public GetUserResponse getUserRequest(@RequestPayload GetUserRequest userRequest){
        GetUserResponse userResponse = new GetUserResponse();
        User user = new User();
        BeanUtils.copyProperties(userService.getUserById(userRequest.getUserId()),user);
        userResponse.setUser(user);
        return userResponse;
    }

    @PayloadRoot(namespace= NAMESPACE_URI, localPart="addUserRequest")
    @ResponsePayload
    public AddUserResponse addUserRequest(@RequestPayload AddUserRequest addUserRequest){
        AddUserResponse userResponse = new AddUserResponse();
        User user = new User();
        BeanUtils.copyProperties(addUserRequest.getUser(),user);
        userResponse.setUser(user);
        return userResponse;
    }

}
