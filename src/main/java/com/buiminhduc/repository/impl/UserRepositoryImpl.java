package com.buiminhduc.repository.impl;

import com.buiminhduc.common.annotation.Repository;
import com.buiminhduc.model.entity.UserEntity;
import com.buiminhduc.repository.UserRepository;
import com.buiminhduc.util.ObjectUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class UserRepositoryImpl extends BasicQuery<UserEntity, Integer> implements UserRepository {
    @Override
    public Optional<UserEntity> findByUserNameAndPassWord(String userName, String password) throws SQLException, IllegalAccessException, NoSuchFieldException, InstantiationException {
        String sql = "SELECT * FROM user WHERE user_name = ? AND password = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setObject(1, userName);
        ps.setObject(2, password);
        ResultSet rs = ps.executeQuery();
        UserEntity userEntity = null;
        while (rs.next()) {
            userEntity = (UserEntity) ObjectUtil.map(tClass, rs);
        }
        return Optional.ofNullable(userEntity);
    }

}
