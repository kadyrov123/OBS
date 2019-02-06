package com.demo.OBS.Controller;

import com.demo.OBS.Model.Centers;
import com.demo.OBS.Model.Fields;
import com.demo.OBS.Service.AdminService;
import com.demo.OBS.Service.CentersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Field;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    CentersService centersService;
    @Autowired
    AdminService adminService;


    @RequestMapping("/home")
    public String openAdminPage(ModelMap modelMap,Authentication auth){
        modelMap.addAttribute("fields",centersService.findFieldsByCenterId(adminService.getAdminsCenterId(auth.getName())));
        modelMap.addAttribute("field" , new Fields());
        modelMap.addAttribute("name",auth.getName());
        return "admin/admin";
    }



    @RequestMapping("/addField")
    public String addField(Fields field , Authentication auth){
        field.setCenterId(adminService.getAdminsCenterId(auth.getName()));
        adminService.addNewField(field);
        return "redirect:/admin/home";
    }

    @RequestMapping("/deleteField")
    public String deleteField(@RequestParam int id){
        adminService.deleteField(id);
        //System.out.println(id);
        return "redirect:/admin/home";
    }

}
