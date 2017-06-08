package by.netcracker.bsuir.pz3.courses.web;

import by.netcracker.bsuir.pz3.courses.service.UserService;
import by.netcracker.bsuir.pz3.courses.service.exception.ServiceException;
import by.netcracker.bsuir.pz3.courses.util.RoleChecker;
import by.netcracker.bsuir.pz3.courses.web.constant.LoggingAndExceptionMessage;
import by.netcracker.bsuir.pz3.courses.web.constant.RequestOrAttributeParameter;
import by.netcracker.bsuir.pz3.courses.web.constant.WebPage;
import by.netcracker.bsuir.pz3.courses.web.util.InputValidation;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller("/userController")
public class UserController {

    private Logger logger = LogManager.getLogger(UserService.class.getName());

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public ModelAndView getSignInPage() {
        logger.info(LoggingAndExceptionMessage.USER_CONTROLLER_SIGN_IN);
        return new ModelAndView(WebPage.SIGN_IN);
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public ModelAndView getSignUpPage() {
        logger.info(LoggingAndExceptionMessage.USER_CONTROLLER_SIGN_UP);
        return new ModelAndView(WebPage.SIGN_UP);
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView getIndexPage() {
        logger.info(LoggingAndExceptionMessage.USER_CONTROLLER_GET_INDEX_PAGE);
        return new ModelAndView(WebPage.INDEX);
    }

    @RequestMapping(value = "/signedUpUser", method = RequestMethod.POST)
    public ModelAndView signUpUser(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        logger.info(LoggingAndExceptionMessage.USER_CONTROLLER_SIGN_UP_USER);

        String login = request.getParameter(RequestOrAttributeParameter.LOGIN);
        String password = request.getParameter(RequestOrAttributeParameter.PASSWORD);
        String firstName = request.getParameter(RequestOrAttributeParameter.FIRST_NAME);
        String lastName = request.getParameter(RequestOrAttributeParameter.LAST_NAME);
        String middleName = request.getParameter(RequestOrAttributeParameter.MIDDLE_NAME);
        String role = request.getParameter(RequestOrAttributeParameter.ROLE);

        if (InputValidation.validateInput(login, password, firstName, lastName, middleName)){
            try {
                userService.signUpUser(login, password, firstName, lastName, middleName, role);
                if (RoleChecker.INSTANCE.isStudent(role)) {
                    modelAndView.setViewName(WebPage.STUDENT);
                } else if (RoleChecker.INSTANCE.isTeacher(role)) {
                    modelAndView.setViewName(WebPage.TEACHER);
                }
                modelAndView.addObject(RequestOrAttributeParameter.LOGIN, login);
                modelAndView.addObject(RequestOrAttributeParameter.PASSWORD, password);
                modelAndView.addObject(RequestOrAttributeParameter.FIRST_NAME, firstName);
                modelAndView.addObject(RequestOrAttributeParameter.LAST_NAME, lastName);
                modelAndView.addObject(RequestOrAttributeParameter.MIDDLE_NAME, middleName);
                modelAndView.addObject(RequestOrAttributeParameter.ROLE, role);
            } catch (ServiceException exception) {
                logger.error(exception);
                modelAndView.setViewName(WebPage.ERROR);
                return modelAndView;
            }
        } else {
            logger.info(LoggingAndExceptionMessage.EMPTY_FIELDS);
            // вывод на страницу сообщения о некорректности введенных данных
            modelAndView.setViewName(WebPage.ERROR); // пока так
        }
        return modelAndView;
    }

    @RequestMapping(value = "/signedInUser", method = RequestMethod.POST)
    public ModelAndView signInUser(HttpServletRequest request) {
        logger.info(LoggingAndExceptionMessage.USER_CONTROLLER_SIGN_IN_USER);

        if (InputValidation.validateInput(
                request.getParameter(RequestOrAttributeParameter.LOGIN),
                request.getParameter(RequestOrAttributeParameter.PASSWORD))){
            try {
                userService.signInUser(
                        request.getParameter(RequestOrAttributeParameter.LOGIN),
                        request.getParameter(RequestOrAttributeParameter.PASSWORD));

            } catch (ServiceException exception) {
                logger.error(exception);
            }
        } else {
            logger.info(LoggingAndExceptionMessage.EMPTY_FIELDS);
            // вывод на страницу сообщения о некорректности введенных данных
        }
        return new ModelAndView(WebPage.TEACHER);
    }
}
