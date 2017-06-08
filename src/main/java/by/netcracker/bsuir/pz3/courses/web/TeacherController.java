package by.netcracker.bsuir.pz3.courses.web;

import by.netcracker.bsuir.pz3.courses.service.TeacherService;
import by.netcracker.bsuir.pz3.courses.service.exception.ServiceException;
import by.netcracker.bsuir.pz3.courses.web.constant.RequestOrAttributeParameter;
import by.netcracker.bsuir.pz3.courses.web.constant.WebPage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TeacherController {
    private static Logger logger = LogManager.getLogger(TeacherController.class);

    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "/teacher/teachers", method = RequestMethod.GET)
    public ModelAndView getTeachersPage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            request.setAttribute(RequestOrAttributeParameter.TEACHERS, teacherService.getAll());
        }  catch (ServiceException e) {
            logger.debug(e);
            modelAndView.setViewName(WebPage.ERROR);
            return modelAndView;
        }
        modelAndView.setViewName(WebPage.TEACHER);
        return modelAndView;
    }
}
