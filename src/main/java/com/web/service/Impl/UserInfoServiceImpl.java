package com.web.service.Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.web.common.MybatisConfig;
import com.web.service.UserInfoService;
import com.web.vo.UserInfoVO;

import con.web.dao.UserInfoDAO;
import con.web.dao.Impl.UserInfoDAOImpl;

public class UserInfoServiceImpl implements UserInfoService {
	private UserInfoDAO uiDAO =new UserInfoDAOImpl();

	@Override
	public List<UserInfoVO> selectUserInfoList(UserInfoVO user) {
		// TODO Auto-generated method stub
		try(SqlSession session =MybatisConfig.getSqlSessionFactory().openSession()){
		  return uiDAO.selectUserInfoList(session,user);
		 
		}
	}

	@Override
	public UserInfoVO selectUserInfo(int uiNum) {
		// TODO Auto-generated method stub
		
		try(SqlSession session =MybatisConfig.getSqlSessionFactory().openSession()){
			  return uiDAO.selectUserInfo(session,uiNum);
			 
			}
	}

	@Override
	public int insertUserInfo(UserInfoVO user) {
		// TODO Auto-generated method stub
		try(SqlSession session =MybatisConfig.getSqlSessionFactory().openSession()){
			  return uiDAO.insertUserInfo(session,user);
			 
			}
	}

	@Override
	public int updateUserInfo(UserInfoVO user) {
		try(SqlSession session =MybatisConfig.getSqlSessionFactory().openSession()){
			  return uiDAO.updateUserInfo(session,user);
			 
			}
	}

	@Override
	public int deleteUserInfo(int uiNum) {
		try(SqlSession session =MybatisConfig.getSqlSessionFactory().openSession()){
			  return uiDAO.deleteUserInfo(session,uiNum);
			 
			}
	}

}
