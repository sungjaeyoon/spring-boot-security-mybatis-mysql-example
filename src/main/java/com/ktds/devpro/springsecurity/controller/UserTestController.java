package com.ktds.devpro.springsecurity.controller;

import com.ktds.devpro.springsecurity.dao.UserMapper;
import com.ktds.devpro.springsecurity.domain.Member;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@AllArgsConstructor
public class UserTestController {

    private UserMapper userMapper;

    @RequestMapping("/openapi/readUser/{username}")
    public @ResponseBody
    String openApiReadUser(@PathVariable String username) {
        Member member = userMapper.readUser(username);
        return member.getName();
    }

    @RequestMapping("/openapi/readAuthority/{username}")
    public @ResponseBody
    String openApiReadAuthority(@PathVariable String username) {
        List<String> auths = userMapper.readAuthority(username);

        StringBuffer buf = new StringBuffer();
        for (String auth : auths) {
            buf.append(auth);
            buf.append(" ");
        }
        return buf.toString();
    }
}

