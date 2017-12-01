package com.syhd.user.service.impl;

import com.syhd.user.constant.Constant;
import com.syhd.user.dto.UserDto;
import com.syhd.user.eto.UserTokenEto;
import com.syhd.user.exception.DataException;
import com.syhd.user.mapper.IUserMapper;
import com.syhd.user.mapper.IUserTokenMapper;
import com.syhd.user.model.UserTokenEbo;
import com.syhd.user.service.IUserTokenService;
import com.syhd.user.util.DataValUtil;
import com.syhd.user.util.DateUtil;
import com.syhd.user.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userTokenService")
public class UserTokenService implements IUserTokenService {

    @Autowired
    private IUserTokenMapper userTokenMapper;
    @Autowired
    private IUserMapper userMapper;

    //获取 token
    public List<UserTokenEbo> getUTokenByToken(String token) throws DataException {
        //参数空值检查
        boolean isNull = Util.isNull(token) ? true : false;
        if (isNull)
            return null;
        else
            return userTokenMapper.getUTokenByToken(token, Constant.N0_VALUE);
    }

    //通过 token+status 获取有效性token
    public UserTokenEbo validityToken(String token, Integer status) throws DataException {
        if (Util.isNull(token))
            throw new DataException("必要参数[token]不能空");
        if (status != 1)
            throw new DataException("必要参数[status]必须为[1]");
        boolean isNull = Util.isNull(token) && status < 0 ? true : false;
        if (isNull)
            return null;
        else
            //判断 token列表是否为空 不是空直接取  是空直接返回null
            return userTokenMapper.getUTokenByToken(token, status) != null ? userTokenMapper.getUTokenByToken(token, status).get(0) : null;
    }

    //获取用户的有效token
    public UserTokenEbo getValidityTokenByUId(String userId) throws DataException {
        boolean isNull = Util.isNull(userId) ? true : false;
        if (isNull)
            return null;
        return userTokenMapper.getUTokenByUId(userId, Constant.TOKEN_YES) != null ? userTokenMapper.getUTokenByUId(userId, Constant.TOKEN_YES).get(0) : null;
    }


    public boolean checkToken(String token, boolean isHdl) throws DataException {
        UserTokenEbo userToken = validityToken(token, Constant.TOKEN_YES);
        if (userToken == null) {
            if (!isHdl)//如果为flase 不进行处理 直接抛出异常
                throw new DataException("token已失效");
            //TODO:有待处理 重新生成
        }
        if (userToken != null) {
            //TODO:检查是否过期判定
        }

        return false;
    }

    @Override
    public UserTokenEbo addUserToken(UserTokenEto userToken) throws DataException {
        //必要参数空值验证
        DataValUtil.dataValidation(userToken.getClass(), userToken);
        UserDto user = userMapper.getUserById(userToken.getSyhdUserId());
        if (user == null)
            throw new DataException("系统无此用户");
        //过期时长必须大于当前时间
        boolean isFlag = DateUtil.getTimeStamp(userToken.getCreateTime()) >= DateUtil.getTimeStamp(userToken.getExpireTime()) ? true : false;
        if(isFlag)
            throw new DataException("创建时间不能大于过期时间");


        return null;
    }

    @Override
    public void updataUTokenStatus(String id, String token, String status) throws DataException {

    }
}
