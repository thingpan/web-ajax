package con.web.dao.Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.web.common.MybatisConfig;
import com.web.vo.UserInfoVO;

import con.web.dao.UserInfoDAO;

public class UserInfoDAOImpl implements UserInfoDAO {

	@Override
	public List<UserInfoVO> selectUserInfoList(SqlSession session, UserInfoVO user) {
		// TODO Auto-generated method stub
		return session.selectList("com.web.mapper.UserInfoMapper.selectUserInfoList",user);
	}

	@Override
	public UserInfoVO selectUserInfo(SqlSession session, int uiNum) {
		// TODO Auto-generated method stub
		return session.selectOne("com.web.mapper.UserInfoMapper.selectUserInfo",uiNum);
	}

	@Override
	public int insertUserInfo(SqlSession session, UserInfoVO user) {
		// TODO Auto-generated method stub
		return session.insert("com.web.mapper.UserInfoMapper.insertUserInfoList",user);
	}

	@Override
	public int updateUserInfo(SqlSession session, UserInfoVO user) {
		// TODO Auto-generated method stub
		return session.update("com.web.mapper.UserInfoMapper.updateUserInfoList",user);
	}

	@Override
	public int deleteUserInfo(SqlSession session,int uiNum) {
		// TODO Auto-generated method stub
		return session.delete("com.web.mapper.UserInfoMapper.deleteUserInfoList",uiNum);
	}
	public static void main(String[] args) {
		try(SqlSession session =MybatisConfig.getSqlSessionFactory().openSession()){
			UserInfoDAO uiDAO =new UserInfoDAOImpl();
			List<UserInfoVO> userList =uiDAO.selectUserInfoList(session, null);
			for(UserInfoVO user: userList) {
				System.out.println(user);
			}
			UserInfoVO user =uiDAO.selectUserInfo(session, 2);
			System.out.println("select one :" +user);
		}
	}

}
