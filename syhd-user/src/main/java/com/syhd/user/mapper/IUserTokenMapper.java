package com.syhd.user.mapper;

import com.syhd.user.exception.DataException;
import com.syhd.user.model.UserTokenEbo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userTokenMapper")
public interface IUserTokenMapper {


    /**
     *
     * 通过 token 和状态 获取UserTokenEbo对象
     * @param token
     *   用户token
     * @param token
     *  token 状态
     * @return
     * @throws DataException
     */
    public List<UserTokenEbo> getUTokenByToken(@Param("token") String token,@Param("status") Integer status)throws DataException;

    /**
     *
     * @param userId
     *  用户ID
     * @param status
     *  用户token 的状态
     * @return
     * @throws DataException
     */
    public List<UserTokenEbo> getUTokenByUId(@Param("userId") String userId, @Param("status") Integer status)throws DataException;

    /**
     * 添加token
     *
     * @param userToken 传入userEbo对象
     * @throws DataException
     */
    public void addUserToken(UserTokenEbo userToken) throws DataException;


    /**
     * 通过id修改token状态
     *
     * @param id
     * syhd_user_token表id
     * @param status
     * syhd_user_token表status
     */
    public void updataUTokenStatus(@Param("id") String id , @Param("token") String token, @Param("status") String status)throws DataException;

}
