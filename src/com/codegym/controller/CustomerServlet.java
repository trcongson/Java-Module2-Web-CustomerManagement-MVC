package com.codegym.controller;

import com.codegym.service.CustomerService;
import com.codegym.service.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {
    private CustomerService customerService = new CustomerServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String action = request.getParameter("action");
if (action == null){
    action = "";
}
switch (action){
    case "create":
        createCustomer(request,response);
        break;
    case "edit":
        updateCustomer(request,response);
        break;
    case "delete":
        delateCustomer(request, response);
        break;
        default:
            break;
}
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String action = request.getParameter("action");
if (action == null){
    action = "";
}
switch (action){
    case "create":
        showCreateForm(request,response);
        break;
    case "edit":
        showEditForm(request,response);
        break;
    case "delete":
        showDeleteForm(request,response);
        break;
    case "view":
        viewCustomer(request,response);
        break;
        default:
            listCustomers(request,response);
            break;
}
    }
}
