package pl.coderslab.controller;

import pl.coderslab.model.User;
import pl.coderslab.model.UserDao;
import pl.coderslab.model.UserGroup;
import pl.coderslab.model.UserGroupDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/edit-user")
public class EditUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        User user = new User();

        if (id!=0) {
            user = UserDao.getById(id);
        } else {
            user.setUsername("New User");
        }

        List<UserGroup> groups = UserGroupDao.loadAll();

        req.setAttribute("user", user);
        req.setAttribute("groups", groups);

        req.getRequestDispatcher("WEB-INF/views/panel_admin_edit_user.jsp").forward(req, resp);

    }
}
