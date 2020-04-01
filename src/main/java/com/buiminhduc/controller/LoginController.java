package com.buiminhduc.controller;

import com.buiminhduc.exception.ObjectNotFoundException;
import com.buiminhduc.model.request.Auth;
import com.buiminhduc.security.Authen;
import com.buiminhduc.util.FormUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/login.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException { //khi login se goi vao day
        Auth auth = FormUtil.toModel(Auth.class,req);
        try {
            String url = Authen.of().auth(auth,req);
            resp.sendRedirect(url);
        } catch (IllegalAccessException |InvocationTargetException|InstantiationException|SQLException|NoSuchMethodException|NoSuchFieldException e) {
            e.printStackTrace();
        } catch (ObjectNotFoundException e){
            RequestDispatcher requestDispatcher= req.getRequestDispatcher("/WEB-INF/view/404.jsp");
            requestDispatcher.forward(req,resp);
        }
    }

}
