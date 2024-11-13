package org.springsecurity.securityregisterlogin.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springsecurity.securityregisterlogin.entity.Category;
import org.springsecurity.securityregisterlogin.entity.User;
import org.springsecurity.securityregisterlogin.repository.UserRepo;
import org.springsecurity.securityregisterlogin.service.ICategoryService;
import org.thymeleaf.util.StringUtils;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/profile")
    public String profile(Principal principal, Model model) {
        String email = principal.getName();
        User user = userRepo.findByEmail(email);
        model.addAttribute("user", user);
        return "admin/profile";
    }

    @GetMapping("/")
    public String index(){
        return "admin/index";
    }

    @GetMapping("/loadAddItem")
    public String loadAddItem(){
        return "admin/add_item";
    }

    @GetMapping("/category")
    public String category(Model m){
        m.addAttribute("categories", categoryService.getAllCategory());
        return "admin/category";
    }

    @PostMapping("/saveCategory")
    public String saveCategory(@ModelAttribute Category category, HttpSession session){
        Boolean existCategory = categoryService.existCategory(category.getName());
        if(existCategory){
            session.setAttribute("errorMsg", "Category Name already exist");
        } else {
            Category saveCategory = categoryService.saveCategory(category);
            if(saveCategory != null){
                session.setAttribute("succMsg", "Category Saved Successfully");
            } else {
                session.setAttribute("errorMsg", "Category Saved Failed");
            }
        }
        return "redirect:/admin/category";
    }

    @GetMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable int id, HttpSession session){
        Boolean deleteCategory = categoryService.deleteCategory(id);
        if(deleteCategory){
            session.setAttribute("succMsg", "Category Deleted Successfully");
        } else {
            session.setAttribute("errorMsg", "Category Deleted Failed");
        }
        return "redirect:/admin/category";
    }
}