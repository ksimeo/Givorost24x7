package com.ksimeo.givorost.admin.web.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by @author Ksimeo on 23.02.17 at 19:49. For project: givorost24x7.
 */
@Controller
public class CommonController {

    private final static Logger logger = LoggerFactory.getLogger(CommonController.class);

    @RequestMapping( value = "/logout", method = RequestMethod.GET )
    public String logOut() {
        logger.debug("logOut()");
        return "order/index";
    }
}
