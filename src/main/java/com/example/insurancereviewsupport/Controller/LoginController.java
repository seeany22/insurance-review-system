package com.example.insurancereviewsupport.Controller;

import com.example.insurancereviewsupport.Model.Employee;
import com.example.insurancereviewsupport.Service.LoginService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService  = loginService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam String empNo,
            @RequestParam String password,
            HttpSession session
    ){
        boolean result  = loginService.login(empNo, password);

        System.out.println("로그인 직원: " + result);
        if (result) {
            Employee employee = loginService.findEmployee(empNo);

            session.setAttribute("empNo" , empNo);
            session.setAttribute("empName", employee.getEmpName());
            return "review-list";
        }
        return "login";
    }
}
