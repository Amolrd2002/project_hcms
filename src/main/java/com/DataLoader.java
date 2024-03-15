package com;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.dao.DepartmentDAO;
import com.dao.EmployeesDAO;
import com.dao.RolesDAO;
import com.entity.ApplicationStatus;
import com.entity.AppraisalForms;
import com.entity.CandidateProfiles;
import com.entity.Certifications;
import com.entity.Departments;
import com.entity.EducationDetails;
import com.entity.EmployeeManagers;
import com.entity.Employees;
import com.entity.ExternalTrainers;
import com.entity.LeaveApprovals;
import com.entity.LeaveRequests;
import com.entity.LeaveTypes;
import com.entity.Payroll;
import com.entity.Projects;
import com.entity.Roles;
import com.entity.SkillMatrix;
import com.entity.SkillUpgradation;
import com.entity.Trainers;
import com.entity.TrainingFeedback;
import com.entity.TrainingModules;
import com.entity.TrainingSchedules;
import com.entity.Users;
import com.entity.Vacancies;
import com.services.ApplicationStatusServices;
import com.services.AppraisalFormServices;
import com.services.CandidateProfileService;
import com.services.CertificationsService;
import com.services.DepartmentServices;
import com.services.EducationDetailService;
import com.services.EmployeeManagersService;
import com.services.EmployeeServices;
import com.services.ExternalTrainersService;
import com.services.LeaveApprovalService;
import com.services.LeaveRequestService;
import com.services.LeaveTypeService;
import com.services.PayrollService;
import com.services.ProjectService;
import com.services.RolesService;
import com.services.SkillMatrixService;
import com.services.SkillUpgradationService;
import com.services.TrainerService;
import com.services.TrainingFeedbackService;
import com.services.TrainingModulesService;
import com.services.TrainingScheduleService;
import com.services.UsersService;
import com.services.VacancieService;

@Component
public class DataLoader implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

//	
//	@Autowired
//	private RolesService rolesService;
//
//	@Autowired
//	private EmployeeServices employeeService;
//
//	@Autowired
//	private DepartmentServices departmentService;
//	
//	@Autowired
//	private PayrollService payrollService;
//	
//	@Autowired
//	private AppraisalFormServices appraisalFormServices;
//	
//	@Autowired
//	private TrainingModulesService trainingModulesService;
//	
//	@Autowired
//	private TrainerService trainerService;
//	
//	@Autowired
//	private TrainingScheduleService trainingScheduleService;
//	
//	@Autowired
//	private TrainingFeedbackService trainingFeedbackService;
//	
//	@Autowired
//	private VacancieService vacancieService;
//	
//	@Autowired
//	private CandidateProfileService candidateProfileService;
//	
//	@Autowired
//	private ApplicationStatusServices applicationStatusService;
//	
//	@Autowired
//	private SkillMatrixService skillMatrixService;
//	
//	@Autowired
//	private SkillUpgradationService skillUpgradationService;
//	
//	@Autowired
//	private LeaveTypeService leaveTypeService;
//	
//	@Autowired
//	private LeaveRequestService leaveRequestService;
//	
//	@Autowired
//	private LeaveApprovalService leaveApprovalService;
//	
//	@Autowired 
//	private CertificationsService certificationsService;
//	
//	@Autowired
//	private EducationDetailService educationDetailService;
//	
//	@Autowired
//	private EmployeeManagersService employeeManagersService;
//	
//	@Autowired
//	private UsersService usersService;
//	
//	@Autowired
//	private ProjectService projectService;
//	
//	@Autowired
//	private ExternalTrainersService externalTrainersService;
//	
//	@Override
//	public void run(String... args) throws Exception {
//		Roles role1 = new Roles();
//		role1.setRoleName("Manager");
//		role1.setDescription("Manager role desc");
//		rolesService.addRole(role1);
//
//		Roles role2 = new Roles();
//		role2.setRoleName("Developer");
//		role2.setDescription("Developer role desc");
//		rolesService.addRole(role2);
//
//		Departments d1 = new Departments();
//		d1.setDepartmentName("IT");
//		d1.setDescription("IT Desc");
//		departmentService.addDepartment(d1);
//
//		Departments d2 = new Departments();
//		d2.setDepartmentName("HR");
//		d2.setDescription("HR Desc");
//		departmentService.addDepartment(d2);
//
//		Employees manager = new Employees();
//		manager.setFirstName("Rohit");
//		manager.setLastName("Sharma");
//		manager.setAddress("Mumbai");
//		manager.setEmail("Rohit123@gmail.com");
//		manager.setGender("M");
//		manager.setDateOfBirth(LocalDate.of(1996, 9, 24));
//		manager.setPhone("9876654432");
//		manager.setNationalId("8654678");
//		manager.setMaritalStatus("Married");
//		manager.setEmergencyContactName("XYZ");
//		manager.setEmergencyContactPhone("987655677");
//		manager.setPosition("Software Manager");
//		manager.setSkillSet("Java , Spring Boot,AWS,Microservices");
//		manager.setEmploymentStartDate(LocalDate.of(2014, 7, 27));
//		manager.setEmploymentEndDate(null);
//		manager.setSalary(new BigDecimal("150000.0"));
//		manager.setEmploymentStatus("Active");
//		manager.setBankAccountNumber("7477479749733");
//		manager.setManager(null);
//		
//		manager.setDepartment(d1);
//		manager.setRole(role1);
//		
//		Employees emp1 = new Employees();
//		emp1.setFirstName("Amol");
//		emp1.setLastName("Dhawale");
//		emp1.setAddress("Pune");
//		emp1.setEmail("amol123@gmail.com");
//		emp1.setGender("M");
//		emp1.setDateOfBirth(LocalDate.of(2002, 9, 24));
//		emp1.setPhone("1234567890");
//		emp1.setNationalId("123453");
//		emp1.setMaritalStatus("Single");
//		emp1.setEmergencyContactName("ABC");
//		emp1.setEmergencyContactPhone("1234567");
//		emp1.setPosition("Software Developer");
//		emp1.setSkillSet("Java , Spring Boot");
//		emp1.setEmploymentStartDate(LocalDate.of(2020, 1, 1));
//		emp1.setEmploymentEndDate(null);
//		emp1.setSalary(new BigDecimal("80000.0"));
//		emp1.setEmploymentStatus("Active");
//		emp1.setBankAccountNumber("2432453242343");
//		emp1.setManager(manager);
//		emp1.setRole(role2);
//		emp1.setDepartment(d1);
//		
//		
//		Employees emp2 = new Employees();
//		emp2.setFirstName("Rahul");
//		emp2.setLastName("Kumar");
//		emp2.setAddress("Gujarat");
//		emp2.setEmail("rahul123@gmail.com");
//		emp2.setGender("M");
//		emp2.setDateOfBirth(LocalDate.of(2002, 9, 12));
//		emp2.setPhone("1234567890");
//		emp2.setNationalId("85933");
//		emp2.setMaritalStatus("Married");
//		emp2.setEmergencyContactName("XYZ");
//		emp2.setEmergencyContactPhone("4765739");
//		emp2.setPosition("Senior Software Developer");
//		emp2.setSkillSet("AWS , Spring Boot");
//		emp2.setEmploymentStartDate(LocalDate.of(2020, 3, 1));
//		emp2.setEmploymentEndDate(null);
//		emp2.setSalary(new BigDecimal("20000.0"));
//		emp2.setEmploymentStatus("Active");
//		emp2.setBankAccountNumber("7583793793");
//		emp2.setManager(null);
//		emp2.setRole(role2);
//		emp2.setDepartment(d1);
//
//		employeeService.addEmployee(manager);
//		employeeService.addEmployee(emp1);
//		employeeService.addEmployee(emp2);
//		
//		Payroll payroll = new Payroll();
//		payroll.setSalaryMonth("2000000");
//		payroll.setSalaryYear(2022);
//		payroll.setBasicSalary(new BigDecimal(40000));
//		payroll.setAllowances(new BigDecimal(10000));
//		payroll.setDeductions(new BigDecimal(20000));
//		payroll.setNetSalary(new BigDecimal(2100000));
//		payroll.setPaymentDate(LocalDate.of(2023, 5, 7));
//		payroll.setEmployee(manager);
//		payrollService.addPayroll(payroll);
//		
//		AppraisalForms af = new AppraisalForms();
//		af.setSubmissionDate(LocalDate.of(2024, 10, 7));
//		af.setRating(4);
//		af.setComments("Well Good");
//		af.setEmployee(emp1);
//		af.setReviewer(manager);
//		appraisalFormServices.addAppraisalForm(af);
//		
//		TrainingModules tm = new TrainingModules();
//		tm.setModuleName("OOPS Concept");
//		tm.setDescription("Interitance , Polymorphism , Encapsulation,Abstraction");
//		tm.setDuration(3);
//		trainingModulesService.addTrainingModule(tm);
//		
//		Trainers t1 = new Trainers();
//		t1.setExternal(true);
//		t1.setEmployee(emp2);
//		trainerService.addTrainer(t1);
//		
//		TrainingSchedules ts = new TrainingSchedules();
//		ts.setStartDate(LocalDate.of(2024, 1, 2));
//		ts.setEndDate(LocalDate.of(2024, 5, 2));
//		ts.setLocation("Pune");
//		ts.setMaxParticipants(200);
//		ts.setTrainer(t1);
//		ts.setTrainingModule(tm);
//		trainingScheduleService.addTrainingSchedule(ts);
//		
//		TrainingFeedback tf = new TrainingFeedback();
//		tf.setFeedbackComments("Very Good Session I learn Lot of things");
//		tf.setSatisfactionRating(4);
//		tf.setTrainingSchedule(ts);
//		tf.setParticipant(emp1);
//		trainingFeedbackService.addTrainingFeedback(tf);
//		
//		Vacancies vc = new Vacancies();
//		vc.setPosition("Developer");
//		vc.setRequiredSkillSet("Java Spring Boot Angular");
//		vc.setNumberOfOpenings(5);
//		vc.setDepartment(d1);
//		vacancieService.addVacancie(vc);
//		
//		CandidateProfiles cp = new CandidateProfiles();
//		cp.setEmployee(emp1);
//		candidateProfileService.addCandidateProfile(cp);
//		
//		ApplicationStatus as = new ApplicationStatus();
//		as.setStatus("Interview Schedule");
//		as.setApplicationDate(LocalDate.of(2024, 4, 3));
//		as.setApplicationNotes("Work Friendly");
//		as.setCandidate(cp);
//		as.setVacancies(vc);
//		applicationStatusService.addApplicationStatus(as);
//		
//		SkillMatrix sm = new SkillMatrix();
//		sm.setSkillName("Spring Boot");
//		sm.setSkillLevel(7);
//		sm.setLastUpdated(LocalDate.of(2024, 3, 10));
//		sm.setEmployee(emp1);
//		skillMatrixService.addSkillMatrix(sm);
//		
//		SkillUpgradation su = new SkillUpgradation();
//		su.setSkillName("Docker");
//		su.setPreviousSkillLevel(3);
//		su.setNewSkillLevel(5);
//		su.setUpgradationDate(LocalDate.of(2024, 10, 3));
//		su.setUpgradedBy(manager);
//		su.setEmployee(emp1);
//		skillUpgradationService.addSkillUpgradation(su);
//		
//		LeaveTypes lt = new LeaveTypes();
//		lt.setLeaveTypeName("Medical");
//		lt.setDescription("If Serioues Issue");
//		leaveTypeService.addLeaveType(lt);
//		
//		LeaveRequests lr = new LeaveRequests();
//		lr.setStartDate(LocalDate.of(2024, 3, 10));
//		lr.setEndDate(LocalDate.of(2024,3, 15));
//		lr.setLeaveReason("Medical Issue");
//		lr.setStatus("Active");
//		lr.setEmployee(emp1);
//		lr.setLeaveType(lt);
//		leaveRequestService.addLeaveRequests(lr);
//		
//		LeaveApprovals la = new LeaveApprovals();
//		la.setApprovalDate(LocalDate.of(2024, 3, 9));
//		la.setComments("Take Care !");
//		la.setStatus("Approved");
//		la.setLeaveRequest(lr);
//		la.setApprover(manager);
//		leaveApprovalService.addLeaveApproval(la);
//		
//		Certifications cs = new Certifications();
//		cs.setCertificationName("Spring Boot");
//		cs.setCertificationAuthority("Udemy");
//		cs.setIssueDate(LocalDate.of(2024, 2, 25));
//		cs.setExpiryDate(LocalDate.of(2029, 2, 25));
//		cs.setEmployee(emp1);
//		certificationsService.addCertification(cs);
//		
//		EducationDetails ed = new EducationDetails();
//		ed.setDegree("BE");
//		ed.setGpa(new BigDecimal(9.85));
//		ed.setGraduationYear(2019);
//		ed.setInstitute("COEP");
//		ed.setMajor("Computer");
//		ed.setEmployee(emp1);
//		educationDetailService.addEducationDetail(ed);
//		
//		EmployeeManagers em = new EmployeeManagers();
//		em.setRelationshipType("Manager");
//		em.setEmployee(emp2);
//		em.setManager(manager);
//		employeeManagersService.addEmployeeManager(em);
//		
//		Users u1 = new Users();
//		u1.setUsername("ad123");
//		u1.setPassword("1234");
//		u1.setEmployee(emp2);
//		usersService.addUsers(u1);
//		
//		Projects p1 = new Projects();
//		p1.setProjectName("Banking System");
//		p1.setStartDate(LocalDate.of(2024, 2, 20));
//		p1.setEndDate(LocalDate.of(2024, 3, 15));
//		p1.setStatus("Active");
//		p1.setProjectDescription("Implement the CRUD Operation of Transaction Management");
//		projectService.addProject(p1);
//		
//		ExternalTrainers et = new ExternalTrainers();
//		et.setFirstName("Rohit");
//		et.setLastName("Mane");
//		et.setGender("M");
//		et.setDateOfBirth(LocalDate.of(2002, 2, 8));
//		et.setEmail("rohit@gmail.com");
//		et.setPhone("23456234789");
//		et.setAddress("Pune");
//		externalTrainersService.addExternalTrainer(et);
//	
//	}

	

}
