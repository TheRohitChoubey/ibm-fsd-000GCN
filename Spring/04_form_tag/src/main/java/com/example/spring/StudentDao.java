package com.example.spring;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "eDao")
public class StudentDao {

	@Autowired
	JtemplateClass jdbcTemplate;

	public JtemplateClass getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JtemplateClass jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void createStudent(Student student) {
		String query = "insert into student(firstname) values(?)";
		Object obj[] = { student.getFirstName() };
		jdbcTemplate.update(query, obj);
		System.out.println("done");
	}

	public void deleteStudent(String order) {
		String query = "delete from student where id = ?";
		Object obj[] = { (Integer.parseInt(order)) };
		jdbcTemplate.update(query, obj);
		System.out.println("done");
	}

	public List searchStudent(Student stud) {
		String query = "select * from student where firstname like '%"+stud.getFirstName()+"%'";
		List<Map<String, Object>> students = jdbcTemplate.queryForList(query);
		
		if (students != null && !students.isEmpty()) {

			for (Map<String, Object> student : students) {

				for (Iterator<Map.Entry<String, Object>> it = student.entrySet().iterator(); it.hasNext();) {
					Map.Entry<String, Object> entry = it.next();
					String key = entry.getKey();
					Object value = entry.getValue();
					System.out.println(key + " = " + value);
				}
				System.out.println();
			}
		}
		System.out.println("done");
		return students;
	}

	public List getStudents() {
		String query = "select * from student";

		List<Map<String, Object>> students = jdbcTemplate.queryForList(query);
		if (students != null && !students.isEmpty()) {

			for (Map<String, Object> student : students) {

				for (Iterator<Map.Entry<String, Object>> it = student.entrySet().iterator(); it.hasNext();) {
					Map.Entry<String, Object> entry = it.next();
					String key = entry.getKey();
					Object value = entry.getValue();
					System.out.println(key + " = " + value);
				}
				System.out.println();
			}
		}
		System.out.println("done");
		return students;
	}

}