package com.buiminhduc.converter;

import com.buiminhduc.model.entity.UserEntity;
import com.buiminhduc.model.request.UserRequest;
import com.buiminhduc.model.respond.UserResponse;
import com.buiminhduc.util.ObjectUtil;

import java.lang.reflect.InvocationTargetException;

public class UserConverter {
    public static UserEntity converToEntity(UserRequest userRequet){   // Bien UserRequest thanh UserEntity
        UserEntity userEntity = new UserEntity();
        return userEntity;
    }



    public static UserResponse converToRespond(UserEntity entity) {
        UserResponse respond = new UserResponse();
        try {
            ObjectUtil.copyProperties(entity, respond);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return respond;
    }
}
