package com.mys.meisiniu.controller;

import com.mys.meisiniu.model.Menu;
import com.mys.meisiniu.service.MenuService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private MenuService menuService;
    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }@RequestMapping(value = "/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/welcome")
    public String index_v1(){
        return "welcome";
    }
    @RequestMapping("/home")
    public String home(HttpSession session, HttpServletRequest request) {
        String msg = "";
        String username = request.getParameter("username");
        String pwd = request.getParameter("password");
        UsernamePasswordToken token=new UsernamePasswordToken(username, pwd);
        token.setRememberMe(true);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            List<Menu> menu = menuService.findTree(username);
            session.setAttribute("muneList",menu);
            session.setAttribute("username",username);
            return "index";
        }  catch (IncorrectCredentialsException e) {
            msg = "登录密码错误. Password for account " + token.getPrincipal() + " was incorrect.";
        } catch (ExcessiveAttemptsException e) {
            msg = "登录失败次数过多";
        } catch (LockedAccountException e) {
            msg = "帐号已被锁定. The account for username " + token.getPrincipal() + " was locked.";
        } catch (DisabledAccountException e) {
            msg = "帐号已被禁用. The account for username " + token.getPrincipal() + " was disabled.";
        } catch (ExpiredCredentialsException e) {
            msg = "帐号已过期. the account for username " + token.getPrincipal() + "  was expired.";
        } catch (UnknownAccountException e) {
            msg = "帐号不存在. There is no user with username of " + token.getPrincipal();
        } catch (UnauthorizedException e) {
            msg = "您没有得到相应的授权！" + e.getMessage();
        }
        request.setAttribute("msg",msg);
        return "login";


    }

    /**
     * 退出
     * @param session
     * @return
     */
    @RequestMapping("/logOut")
    public String logOut(HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
//        session.removeAttribute("user");
        return "login";
    }

}
