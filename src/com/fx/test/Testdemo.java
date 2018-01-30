package com.fx.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.fx.domain.User;

public class Testdemo {
	@Test
	public void findUser() throws IOException{
		String resource="SqlMapConfig.xml";
	InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession=sqlSessionFactory.openSession();
		User user = sqlSession.selectOne("test.findUser", 1);
		System.out.println(user.getId()+">>>"+user.getUsername());
		
		//5¡¢¹Ø±ÕSqlSession
		sqlSession.close();
	}
}
