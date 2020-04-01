package com.buiminhduc.service;

import com.buiminhduc.exception.ObjectNotFoundException;
import com.buiminhduc.model.entity.Role;
import com.buiminhduc.model.respond.RoleRepond;

import java.lang.reflect.InvocationTargetException;

public interface RoleService {
    RoleRepond findById(int id) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ObjectNotFoundException;
}
