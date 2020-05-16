package com.ktds.devpro.springsecurity.dao;

import com.ktds.devpro.springsecurity.domain.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public Member readUser(String username);
    public List<String> readAuthority(String username);
}
