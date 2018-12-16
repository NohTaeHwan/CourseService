package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Course;


@Repository
public class CourseDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int getRowCount() {
		String sqlStatement = "select count(*) from course";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
	}

	// query and return a single object
	public Course getCourse(String subject) {
		String sqlStatement = "select * from course where suject=?";// ?ดย placeholder

		return jdbcTemplate.queryForObject(sqlStatement, new Object[] { subject }, new RowMapper<Course>() {

			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				Course course = new Course();
				course.setYear(rs.getInt("year"));
				course.setSemester(rs.getInt("semester"));
				course.setSubjectcode(rs.getString("subjectcode"));
				course.setSubject(rs.getString("subject"));
				course.setDivision(rs.getString("division"));
				course.setCredit(rs.getInt("credit"));
				
				return course;
			}
		});
	}

	// query and return a multiple objects
	public List<Course> getCourses() {
		String sqlStatement = "select * from course";// ?ดย placeholder

		return jdbcTemplate.query(sqlStatement, new RowMapper<Course>() {

			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				Course course = new Course();
				course.setYear(rs.getInt("year"));
				course.setSemester(rs.getInt("semester"));
				course.setSubjectcode(rs.getString("subjectcode"));
				course.setSubject(rs.getString("subject"));
				course.setDivision(rs.getString("division"));
				course.setCredit(rs.getInt("credit"));
				
				return course;
			}
		});
	}

	// insert to DB
	public boolean insert(Course course) {
		String subjectcode = course.getSubjectcode();
		int year = course.getYear();
		int semester = course.getSemester();
		String subject = course.getSubject();
		String division = course.getDivision();
		int credit = course.getCredit();
		
		String sqlStatement = "insert into course (subjectcode,year,semester,subject,division,credit) values (?,?,?,?,?,?)";

		return (jdbcTemplate.update(sqlStatement, new Object[] { subjectcode,year, semester, subject , division, credit }) == 1);
	}

	// update DB
	public boolean update(Course course) {

		String subjectcode = course.getSubjectcode();
		int year = course.getYear();
		int semester = course.getSemester();
		String subject = course.getSubject();
		String division = course.getDivision();
		int credit = course.getCredit();

		String sqlStatement = "update course set year=?, semester=?, subject=?, division=?, credit=? where subjectcode=?";

		return (jdbcTemplate.update(sqlStatement, new Object[] { year, semester, subject , division, credit , subjectcode}) == 1);
	}

	// delete object in db
	public boolean delete(String subjectcode) {
		String sqlStatement = "delete from course where subjectcode=?";

		return (jdbcTemplate.update(sqlStatement, new Object[] { subjectcode }) == 1);
	}

}
