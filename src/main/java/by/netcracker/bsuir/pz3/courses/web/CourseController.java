package by.netcracker.bsuir.pz3.courses.web;

import by.netcracker.bsuir.pz3.courses.service.CourseService;
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
public class CourseController {
    private static Logger logger = LogManager.getLogger(TeacherController.class);

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/course/courses", method = RequestMethod.GET)
    public ModelAndView getAppointmentAirplanePage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            request.setAttribute(RequestOrAttributeParameter.COURSES, courseService.getAll());
        }  catch (ServiceException e) {
            logger.debug(e);
            modelAndView.setViewName(WebPage.ERROR);
            return modelAndView;
        }
        modelAndView.setViewName(WebPage.COURSES);
        return modelAndView;
    }
}
