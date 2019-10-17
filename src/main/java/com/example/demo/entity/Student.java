package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_table")
public class Student {
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="student_Id")
	    private int studentId;
		
		@Column(name="first_name")
	    private String firstName;
		
		@Column(name="last_name")
	    private String lastName;
		
		@Column(name="gender")
		private String gender;
		
		@Column(name="marital_status")
		private String maritalStatus;
		
		@Column(name="email")
	    private String email;
		
		@Column(name="phone")
	    private long phone;
	    
		public Student() {}
		
		

		public Student(int studentId, String firstName, String lastName, String gender, String maritalStatus,
				String email, long phone) {
			super();
			this.studentId = studentId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.gender = gender;
			this.maritalStatus = maritalStatus;
			this.email = email;
			this.phone = phone;
		}



		public Student(String firstName, String lastName, String gender, String maritalStatus, String email,
				long phone) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.gender = gender;
			this.maritalStatus = maritalStatus;
			this.email = email;
			this.phone = phone;
		}

		public int getStudentId() {
			return studentId;
		}

		public void setStudentId(int id) {
			this.studentId = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getMaritalStatus() {
			return maritalStatus;
		}

		public void setMaritalStatus(String maritalStatus) {
			this.maritalStatus = maritalStatus;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public long getPhone() {
			return phone;
		}

		public void setPhone(long phone) {
			this.phone = phone;
		}

		@Override
		public String toString() {
			return "Student [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName
					+ ", gender=" + gender + ", maritalStatus=" + maritalStatus + ", email=" + email + ", phone="
					+ phone + "]";
		}
		
		
		
	
	    
}
