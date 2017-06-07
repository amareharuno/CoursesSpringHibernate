package by.netcracker.bsuir.pz3.courses.web;

import by.netcracker.bsuir.pz3.courses.service.UserService;
import by.netcracker.bsuir.pz3.courses.service.exception.ServiceException;
import by.netcracker.bsuir.pz3.courses.web.constant.LoggingAndExceptionMessage;
import by.netcracker.bsuir.pz3.courses.web.constant.RequestParameter;
import by.netcracker.bsuir.pz3.courses.web.constant.WebPage;
import by.netcracker.bsuir.pz3.courses.web.util.InputValidation;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller("/userController")
public class UserController {

    private Logger logger = LogManager.getLogger(UserService.class.getName());

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public ModelAndView getSignInPage() {
        return new ModelAndView(WebPage.SIGN_IN);
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public ModelAndView getSignUpPage() {
        return new ModelAndView(WebPage.SIGN_UP);
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView getIndexPage() {
        return new ModelAndView(WebPage.INDEX);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public void signInUser(HttpServletRequest request) {
        logger.info(LoggingAndExceptionMessage.USER_CONTROLLER_SIGN_IN);

        if (InputValidation.validateInput(
                request.getParameter(RequestParameter.LOGIN),
                request.getParameter(RequestParameter.PASSWORD))){
            try {
                userService.signInUser(
                        request.getParameter(RequestParameter.LOGIN),
                        request.getParameter(RequestParameter.PASSWORD));

            } catch (ServiceException exception) {
                logger.error(exception);
            }
        } else {
            logger.info(LoggingAndExceptionMessage.EMPTY_FIELDS);
            // вывод на страницу сообщения о некорректности введенных данных
        }
    }

    @ResponseBody
    @RequestMapping(value = "coursesSpring/user1", method = RequestMethod.POST)
    public void signUpUser(HttpServletRequest request) {
        logger.info(LoggingAndExceptionMessage.USER_CONTROLLER_SIGN_UP);

        if (InputValidation.validateInput(
                request.getParameter(RequestParameter.LOGIN),
                request.getParameter(RequestParameter.PASSWORD),
                request.getParameter(RequestParameter.FIRST_NAME),
                request.getParameter(RequestParameter.LAST_NAME),
                request.getParameter(RequestParameter.MIDDLE_NAME))){
            try {
                userService.signUpUser(
                        request.getParameter(RequestParameter.LOGIN),
                        request.getParameter(RequestParameter.PASSWORD),
                        request.getParameter(RequestParameter.FIRST_NAME),
                        request.getParameter(RequestParameter.LAST_NAME),
                        request.getParameter(RequestParameter.MIDDLE_NAME),
                        request.getParameter(RequestParameter.ROLE));
            } catch (ServiceException exception) {
                logger.error(exception);
            }
        } else {
            logger.info(LoggingAndExceptionMessage.EMPTY_FIELDS);
            // вывод на страницу сообщения о некорректности введенных данных
        }
    }
}
