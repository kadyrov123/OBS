package com.demo.OBS.Controller;

import com.demo.OBS.Dao.*;
import com.demo.OBS.Model.Booked;
import com.demo.OBS.Model.Day;
import com.demo.OBS.Model.Time;
import com.demo.OBS.Model.Timetable;
import com.demo.OBS.Service.CentersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Controller
public class IndexController {
    @Autowired
    private DaoCenters daoCenters;
    @Autowired
    private DaoUsers daoUsers;
    private DaoFields daoFields;
    @Autowired
    private DaoLocation daoLocation;
    @Autowired
    CentersService centersService;

    Authentication auth = SecurityContextHolder.getContext().getAuthentication();


    @RequestMapping("/")
    public String index(ModelMap modelMap){
        modelMap.addAttribute("centers",centersService.findAllCenters());
        return "index";
    }

    @RequestMapping("/alga")
    public String go_to_fields(){
        return "alga";
    }

    @RequestMapping("/map")
    public String map(ModelMap modelMap){
        modelMap.addAttribute("location",centersService.findLocations());
        return "map";
    }

    //@PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping("/admin")
    public String secured(){
        return "admin";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping("/users")
    public String users(ModelMap m){
        m.addAttribute("users", daoUsers.findAllByUsername("a"));
        return "users" ;
    }

    @RequestMapping("/kgsport")
    public String kgSport(){
        return "kgsport";
    }

    @RequestMapping(value="/alga" , method = RequestMethod.GET)
    public String goToFields(@RequestParam("id") int id, ModelMap modelMap){
        modelMap.addAttribute("centers" , daoCenters.findCentersById(id));
        modelMap.addAttribute("fields" ,centersService.findFieldsByCenterId(id));
        modelMap.addAttribute("today" , centersService.getCurrentDate());
        modelMap.addAttribute("week",centersService.getWeek());
        modelMap.addAttribute("timetable", new Timetable());
        return "alga";
    }

}
