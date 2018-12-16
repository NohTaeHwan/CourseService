package kr.ac.hansung.controller;

import java.util.List;
import java.util.Vector;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.model.Course;
import kr.ac.hansung.service.CourseService;

@Controller
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	//수강내역보기 뷰 처리 ( 학기별 목록.) 여기서 각학기별 수강내역을 뿌려줌
	@RequestMapping("/showcourse")
	public String showCourses(Model model) {
		List<Course> courses = courseService.getCurrent();
		
		int [] semesterCredits =new int [4];
		for(int i=0;i<semesterCredits.length;i++) {
			semesterCredits[i]=0;
		}
		
		
		for(Course course:courses) {
			
			if(course.getSemester()==1&&course.getYear()==2017) {
				semesterCredits[0]+=course.getCredit();
			}
			else if(course.getSemester()==2&&course.getYear()==2017) {
				semesterCredits[1]+=course.getCredit();
			}
			else if(course.getSemester()==1&&course.getYear()==2018) {
				semesterCredits[2]+=course.getCredit();
			}
			else if(course.getSemester()==2&&course.getYear()==2018) {
				semesterCredits[3]+=course.getCredit();
			}
			
		}
		
		
		
		
		model.addAttribute("credits",semesterCredits);
		
		return "showcourse";
	}
	
	//수강신청 뷰 처리
	@RequestMapping("/createcourse")
	public String createCourse(Model model) {
	
		model.addAttribute("course",new Course());
		return "createcourse";
	}
	
	//수강신청 완료 뷰 처리
	@RequestMapping("/coursecreated")
	public String showNewCourse(Model model, @Valid Course course, BindingResult result) {
		
	
		
		if(result.hasErrors()) {
			System.out.println("Form data does not validated");
			List<ObjectError> errors = result.getAllErrors();			
			for(ObjectError error: errors) {
				System.out.println(error.getDefaultMessage());
			}
			return "createcourse";
		}
		
		courseService.insert(course);
		
		return "coursecreated";
	}
	
	//수강신청 내용 보기
	@RequestMapping("/newcourse")
	public String showNewCourse(Model model) {
		List<Course> courses = courseService.getCurrent();
		
		List<Course> newCourses = new Vector<>();
		
		for(Course course:courses) {
			if(course.getSemester()==1&&course.getYear()==2019) {
				newCourses.add(course);
			}
		}
		
		model.addAttribute("courses", newCourses);
		
		return "newcourse";
	}
	
	@RequestMapping("/2017-1view")
	public String show2017_1Course(Model model) {
		List<Course> courses = courseService.getCurrent();
		
		List<Course> courses2017_1 = new Vector<>();
		
		for(Course course:courses) {
			if(course.getSemester()==1&&course.getYear()==2017) {
				courses2017_1.add(course);
			}
		}
		
		model.addAttribute("courses", courses2017_1);
		
		return "2017-1view";
	}
	
	@RequestMapping("/2017-2view")
	public String show2017_2Course(Model model) {
		List<Course> courses = courseService.getCurrent();
		
		List<Course> courses2017_2 = new Vector<>();
		
		for(Course course:courses) {
			if(course.getSemester()==2&&course.getYear()==2017) {
				courses2017_2.add(course);
			}
		}
		
		model.addAttribute("courses", courses2017_2);
		
		return "2017-2view";
	}
	
	@RequestMapping("/2018-1view")
	public String show2018_1Course(Model model) {
		List<Course> courses = courseService.getCurrent();
		
		List<Course> courses2018_1 = new Vector<>();
		
		for(Course course:courses) {
			if(course.getSemester()==1&&course.getYear()==2018) {
				courses2018_1.add(course);
			}
		}
		
		model.addAttribute("courses", courses2018_1);
		
		return "2018-1view";
	}
	
	@RequestMapping("/2018-2view")
	public String show2018_2Course(Model model) {
		List<Course> courses = courseService.getCurrent();
		
		List<Course> courses2018_2 = new Vector<>();
		
		for(Course course:courses) {
			if(course.getSemester()==2&&course.getYear()==2018) {
				courses2018_2.add(course);
			}
		}
		
		model.addAttribute("courses", courses2018_2);
		
		return "2018-2view";
	}
	
	
	
	
	
}
