package com.syhd.user.test;

import com.syhd.user.config.StartSpringBootSyhdUser;
import com.syhd.user.exception.DataException;
import com.syhd.user.mapper.IUserTokenMapper;
import com.syhd.user.model.UserTokenEbo;
import com.syhd.user.util.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = StartSpringBootSyhdUser.class)
public class TestUserTokenService {

    @Autowired
    private IUserTokenMapper userTokenMapper;

    @Test
    public void testGetUserTokenByToken(){
        try {
            List<UserTokenEbo> userToken=userTokenMapper.getUTokenByToken(null,-1);
            System.out.println(userToken);
            System.out.println(DateUtil.TimeStampFormatDay(userToken.get(0).getCreateTime()));
        } catch (DataException e) {

        }
    }
}
