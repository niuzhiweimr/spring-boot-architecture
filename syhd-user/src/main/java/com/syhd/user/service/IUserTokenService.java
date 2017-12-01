package com.syhd.user.service;

import com.syhd.user.eto.UserTokenEto;
import com.syhd.user.exception.DataException;
import com.syhd.user.model.UserTokenEbo;

import java.util.List;

public interface IUserTokenService {


    //获取 token
    public List<UserTokenEbo> getUTokenByToken(String token)throws DataException;

    //通过 token+status 获取有效性token
    public UserTokenEbo validityToken(String token, Integer status)throws DataException;

    //获取用户的有效token
    public UserTokenEbo getValidityTokenByUId( String userId)throws DataException;

    //token有效性检查  isHdl是否处理如果处理重新生成token 不从新处理抛出token过期异常
    public boolean checkToken(String token,boolean isHdl)throws DataException;

   //添加token
    public UserTokenEbo addUserToken(UserTokenEto userToken) throws DataException;


   //通过 id token 修改token令牌是否有效
    public void updataUTokenStatus( String id , String token, String status)throws DataException;
}
