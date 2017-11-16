package by.netcracker.bsuir.pz3.courses.web;

import by.netcracker.bsuir.pz3.courses.entity.Course;
import by.netcracker.bsuir.pz3.courses.service.CourseService;
import by.netcracker.bsuir.pz3.courses.service.TeacherService;
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
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/course")
public class CourseController {
        private static Logger logger = LogManager.getLogger(TeacherController.class);

        @Autowired
        private CourseService courseService;

        @Autowired
        private TeacherService teacherService;

        private ModelAndView getCoursesList(HttpServletRequest request) {
                ModelAndView modelAndView = new ModelAndView();
                try {
                        request.setAttribute(RequestParameterOrAttribute.COURSES, courseService.getAll());
                } catch (ServiceException e) {
                        logger.debug(e);
                        modelAndView.setViewName(WebPage.ERROR);
                        return modelAndView;
                }
                return modelAndView;
        }

        @RequestMapping(value = "/courses", method = RequestMethod.GET)
        public ModelAndView getCoursesPage(HttpServletRequest request) {
                ModelAndView modelAndView = getCoursesList(request);
                modelAndView.setViewName(WebPage.COURSES);
                return modelAndView;
        }

        @RequestMapping(value = "/coursesToChange", method = RequestMethod.GET)
        public ModelAndView getCoursesToChangePage(HttpServletRequest request) {
                ModelAndView modelAndView = getCoursesList(request);
                modelAndView.setViewName(WebPage.COURSES_TO_CHANGE);
                return modelAndView;
        }

        @RequestMapping(value = "/addingCoursePage", method = RequestMethod.GET)
        public ModelAndView getAddingCoursePage(HttpServletRequest request) {
                try {
                        request.setAttribute(RequestParameterOrAttribute.TEACHERS, teacherService.getAll());
                } catch (ServiceException e) {
                        logger.debug(e);
                        return new ModelAndView(WebPage.ERROR);
                }
                return new ModelAndView(WebPage.ADDING_COURSE_PAGE);
        }

        @RequestMapping(value = "/updatingCoursePage", method = RequestMethod.POST)
        public ModelAndView getUpdatingCoursePage(HttpServletRequest request, HttpSession session) {
                try {
                        String courseId = request.getParameter("itemToUpdate");
                        int id = Integer.parseInt(courseId);
                        session.setAttribute("courseId", id);

                        request.setAttribute(RequestParameterOrAttribute.COURSE, courseService.getById(id));
                        request.setAttribute(RequestParameterOrAttribute.TEACHERS, teacherService.getAll());
                } catch (ServiceException e) {
                        logger.debug(e);
                        return new ModelAndView(WebPage.ERROR);
                }
                return new ModelAndView(WebPage.UPDATING_COURSE_PAGE);
        }

        @RequestMapping(value = "/addCourse", method = RequestMethod.POST)
        public ModelAndView addCourseAndGoToCoursesToChangePage(HttpServletRequest request, HttpSession session) {
                ModelAndView modelAndView = new ModelAndView();

                String courseName = request.getParameter(RequestParameterOrAttribute.COURSE_NAME);
                String subject = request.getParameter(RequestParameterOrAttribute.SUBJECT);
                String lessonsCount = request.getParameter(RequestParameterOrAttribute.LESSONS_COUNT);
                String lessonDuration = request.getParameter(RequestParameterOrAttribute.LESSON_DURATION);
                String teacherId = request.getParameter(RequestParameterOrAttribute.TEACHER_ID);

                if (InputValidation.validateCourseInput(courseName, subject, lessonsCount, lessonDuration, teacherId)) {
                        try {
                                courseService.add(
                                        new Course(
                                                subject, courseName,
                                                Integer.parseInt(lessonsCount),
                                                Integer.parseInt(lessonDuration),
                                                teacherService.getById(Integer.parseInt(teacherId))));

                                modelAndView = getCoursesToChangePage(request);
                        } catch (ServiceException exception) {
                                logger.error(exception);
                                modelAndView.setViewName(WebPage.ERROR);
                                return modelAndView;
                        }
                } else {
                        logger.info(LoggingAndExceptionMessage.WRONG_INPUT);
                        request.setAttribute(
                                RequestParameterOrAttribute.SOMETHING_WRONG_MESSAGE,
                                LoggingAndExceptionMessage.WRONG_INPUT);
                        modelAndView = getAddingCoursePage(request);
                }
                return modelAndView;
        }

        @RequestMapping(value = "/updateCourse", method = RequestMethod.POST)
        public ModelAndView updateCourseAndGoToCoursesToChangePage(HttpServletRequest request, HttpSession session) {
                ModelAndView modelAndView = new ModelAndView();

                String courseName = request.getParameter(RequestParameterOrAttribute.COURSE_NAME);
                String subject = request.getParameter(RequestParameterOrAttribute.SUBJECT);
                String lessonsCount = request.getParameter(RequestParameterOrAttribute.LESSONS_COUNT);
                String lessonDuration = request.getParameter(RequestParameterOrAttribute.LESSON_DURATION);
                String teacherId = request.getParameter(RequestParameterOrAttribute.TEACHER_ID);

                if (InputValidation.validateCourseInput(courseName, subject, lessonsCount, lessonDuration, teacherId)) {
                        try {
                                Course courseToUpdate = courseService.getById((Integer) session.getAttribute("courseId"));
                                courseToUpdate.setCourseName(courseName);
                                courseToUpdate.setSubject(subject);
                                courseToUpdate.setLessonsCount(Integer.parseInt(lessonsCount));
                                courseToUpdate.setLessonDuration(Integer.parseInt(lessonDuration));
                                courseToUpdate.setTeacher(teacherService.getById(Integer.parseInt(teacherId)));

                                courseService.update(courseToUpdate);

                                modelAndView = getCoursesToChangePage(request);
                        } catch (ServiceException exception) {
                                logger.error(exception);
                                modelAndView.setViewName(WebPage.ERROR);
                                return modelAndView;
                        }
                } else {
                        logger.info(LoggingAndExceptionMessage.WRONG_INPUT);
                        request.setAttribute(
                                RequestParameterOrAttribute.SOMETHING_WRONG_MESSAGE,
                                LoggingAndExceptionMessage.WRONG_INPUT);
                        modelAndView = getUpdatingCoursePage(request, session);
                }
                return modelAndView;
        }

        @RequestMapping(value = "/coursesToChange/delete", method = RequestMethod.POST)
        public ModelAndView deleteCourse(HttpServletRequest request) {
                try {
//                        String courseId = request.getParameter(RequestParameterOrAttribute.RADIO_ID);
                        String courseId = request.getParameter("itemToDelete");
                        int id = Integer.parseInt(courseId);
                        courseService.delete(id);
                } catch (NumberFormatException ex) {
                        request.setAttribute(
                                RequestParameterOrAttribute.SOMETHING_WRONG_MESSAGE,
                                LoggingAndExceptionMessage.NO_CHECKED_ITEM);
                } catch (ServiceException e) {
                        logger.debug(e);
                        return new ModelAndView(WebPage.ERROR);
                }
                return getCoursesToChangePage(request);
        }
}
