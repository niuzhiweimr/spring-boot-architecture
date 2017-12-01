package com.syhd.user.test;

import com.syhd.user.config.StartSpringBootSyhdUser;
import com.syhd.user.dto.UserDto;
import com.syhd.user.exception.DataException;
import com.syhd.user.model.UserEbo;
import com.syhd.user.service.IUserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

/**
 * 
 * @author niuzhiwei 单元测试案例
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = StartSpringBootSyhdUser.class)
public class TestUserService {

    @Autowired
	private IUserService userService;

	private static final Logger logger=Logger.getLogger(TestUserService.class);

	//测试通过id 获取用户
	@Test
	public void testGetUserById() {
		String id="1111";
		try {
			logger.info("查询用户的id为："+id);
            UserDto user=userService.getUserById(id);
			logger.info("查询成功:"+user);
		} catch (DataException e) {
			e.printStackTrace();
		}
	}
}
