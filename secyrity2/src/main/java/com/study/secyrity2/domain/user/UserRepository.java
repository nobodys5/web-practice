package com.study.secyrity2.domain.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {

	//1 회원가입,로그인 추상메소드 작성
	public int save(User user) throws Exception;
	public User finduserByUsername(String username) throws Exception;
}
