package com.buiminhduc.controller.admin;

import com.buiminhduc.autowire.BeanFactory;
import com.buiminhduc.model.respond.UserResponse;
import com.buiminhduc.paging.PageRequest;
import com.buiminhduc.service.UserService;
import com.buiminhduc.service.session.SessionUtil;
import com.buiminhduc.util.FormUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/home")
public class HomeController extends HttpServlet {
    private UserService userService;
    public HomeController(){
        userService= (UserService) BeanFactory.getBeans().get("userService");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PageRequest pageRequest = FormUtil.toModel(PageRequest.class,req);
        req.setAttribute("namePage","users");
        req.setAttribute("MODEL",((UserResponse)SessionUtil.getSession(req,"USER")));
        try {
            List<UserResponse> responds = userService.findAll();
            req.setAttribute("list",responds);
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/table.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
