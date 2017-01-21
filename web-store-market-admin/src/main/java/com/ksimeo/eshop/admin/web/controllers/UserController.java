package com.ksimeo.eshop.admin.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Ksimeo. Created on 16.01.2017 at 18:28 for "web-store-market" project.
 * @version 1.0
 * @since 1.0
 */
@Controller
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

//    @Autowired
//    private UserService userServ;
//    @Autowired
//    UserFormValidator userFormValidator;

//    protected void initBinder(WebDataBinder binder) {
//        binder.setValidator(userFormValidator);
//    }

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String index(Model model) {
//        logger.debug("index()");
//        System.out.println("Получилось!");
//        return "redirect:/main";
//    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(Model model) {
        logger.debug("main()");
//        model.addAttribute("usr", userServ.getAll());
        return "users/main";
    }
}
