package by.netcracker.bsuir.pz3.courses.web;

import by.netcracker.bsuir.pz3.courses.entity.User;
import by.netcracker.bsuir.pz3.courses.service.StudentService;
import by.netcracker.bsuir.pz3.courses.service.TeacherService;
import by.netcracker.bsuir.pz3.courses.service.UserService;
import by.netcracker.bsuir.pz3.courses.service.exception.ServiceException;
import by.netcracker.bsuir.pz3.courses.web.constant.LoggingAndExceptionMessage;
import by.netcracker.bsuir.pz3.courses.web.constant.RequestParameterOrAttribute;
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

@Controller
public class UserController {

    private Logger logger = LogManager.getLogger(UserService.class.getName());

    @Autowired
    private UserService userService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/teacher", method = RequestMethod.GET)
    public ModelAndView getTeacherPage() {
        return new ModelAndView(WebPage.TEACHER);
    }

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public ModelAndView getStudentPage() {
        return new ModelAndView(WebPage.STUDENT);
    }

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

        String login = request.getParameter(RequestParameterOrAttribute.LOGIN);
        String password = request.getParameter(RequestParameterOrAttribute.PASSWORD);
        String firstName = request.getParameter(RequestParameterOrAttribute.FIRST_NAME);
        String lastName = request.getParameter(RequestParameterOrAttribute.LAST_NAME);
        String middleName = request.getParameter(RequestParameterOrAttribute.MIDDLE_NAME);
        String role = request.getParameter(RequestParameterOrAttribute.ROLE);

        if (InputValidation.validateInput(login, password, firstName, lastName, middleName)){
            try {
                boolean userCreated = userService.signUpUser(login, password, firstName, lastName, middleName, role);
                if (userCreated) {
                    if (role.equals(RequestParameterOrAttribute.STUDENT)) {
                        modelAndView.setViewName(WebPage.STUDENT);
                    } else if (role.equals(RequestParameterOrAttribute.TEACHER)) {
                        modelAndView.setViewName(WebPage.TEACHER);
                    }
                } else {
                    logger.info(LoggingAndExceptionMessage.USER_ALREADY_EXISTS);
                    request.setAttribute(
                            RequestParameterOrAttribute.SOMETHING_WRONG_SIGN_UP_MESSAGE,
                            LoggingAndExceptionMessage.USER_ALREADY_EXISTS); // сообщение о том, что такой юзер уже есть
                    modelAndView.setViewName(WebPage.SIGN_UP);
                }
            } catch (ServiceException exception) {
                logger.error(exception);
                modelAndView.setViewName(WebPage.ERROR);
                return modelAndView;
            }
        } else {
            logger.info(LoggingAndExceptionMessage.EMPTY_FIELDS);
            request.setAttribute(
                    RequestParameterOrAttribute.SOMETHING_WRONG_SIGN_UP_MESSAGE,
                    LoggingAndExceptionMessage.EMPTY_FIELDS); // сообщение о некорректности введенных данных (пустые поля)
            modelAndView.setViewName(WebPage.SIGN_UP);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/signedInUser", method = RequestMethod.POST)
    public ModelAndView signInUser(HttpServletRequest request) {
        logger.info(LoggingAndExceptionMessage.USER_CONTROLLER_SIGN_IN_USER);
        ModelAndView modelAndView = new ModelAndView();

        if (InputValidation.validateInput(request.getParameter(RequestParameterOrAttribute.LOGIN),
                request.getParameter(RequestParameterOrAttribute.PASSWORD))){
            try {
                User userFound = userService.signInUser(request.getParameter(RequestParameterOrAttribute.LOGIN),
                        request.getParameter(RequestParameterOrAttribute.PASSWORD));
                if (userFound != null) {
                    if (teacherService.getByUserId(userFound.getId()) != null) {
                        modelAndView.setViewName(WebPage.TEACHER);
                    } else if (studentService.getByUserId(userFound.getId()) != null) {
                        modelAndView.setViewName(WebPage.STUDENT);
                    } else {
                        request.setAttribute(RequestParameterOrAttribute.SOMETHING_WRONG_SIGN_IN_MESSAGE,
                                LoggingAndExceptionMessage.NO_ROLE_DEFINED_TO_THE_USER); // сообщение о том, что не существует такого пользователя
                        modelAndView.setViewName(WebPage.SIGN_IN);
                    }
                } else {
                    logger.info(LoggingAndExceptionMessage.NO_SUCH_USER);
                    request.setAttribute(RequestParameterOrAttribute.SOMETHING_WRONG_SIGN_IN_MESSAGE,
                            LoggingAndExceptionMessage.NO_SUCH_USER); // сообщение о том, что не существует такого пользователя
                    modelAndView.setViewName(WebPage.SIGN_IN);
                }
            } catch (ServiceException exception) {
                logger.error(exception);
            }
        } else {
            logger.info(LoggingAndExceptionMessage.EMPTY_FIELDS);
            request.setAttribute(RequestParameterOrAttribute.SOMETHING_WRONG_SIGN_IN_MESSAGE,
                    LoggingAndExceptionMessage.EMPTY_FIELDS); // сообщение о некорректности введенных данных (пустые поля)
            modelAndView.setViewName(WebPage.SIGN_IN);
        }
        return modelAndView;
    }
}
