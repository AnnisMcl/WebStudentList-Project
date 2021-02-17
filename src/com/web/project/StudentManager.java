package com.web.project;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.bean.ViewScoped;

@ManagedBean
@SessionScoped
public class StudentManager {
	private Student student=new Student();
	private Student selectedStudent;
	private List<Student> listeStudents;
	private StudentDbUtil StudentDbUtil = new StudentDbUtil();
	
public StudentManager() {
	this.listeStudents=new ArrayList<Student>();
}

public String  add() {
	StudentDbUtil.ajouter(this.student);
	return "List-students.xhtml?faces-redirect=true";
	
}

public String  modifier() {
	StudentDbUtil.modifier(this.selectedStudent);
	return "List-students.xhtml?faces-redirect=true";
	
}

public String  supprimer() {
	StudentDbUtil.supprimer(this.selectedStudent);
	return "List-students.xhtml?faces-redirect=true";
	
}
//Initialise le "DataTable" avec la liste des élèves
	public void initDataTable() throws Exception {
		listeStudents = StudentDbUtil.listerTous();
		
	}
	
	// Récupére le code client à  modifier  et initialise le formulaire avec ses informations
		public void initForm() {
			int id;		
			id = Integer.parseInt(FacesContext.getCurrentInstance()
							.getExternalContext().getRequestParameterMap()
							.get("id"));

			Student sdt =new Student();
			sdt= StudentDbUtil.Consulter(id);
			
			if (sdt!=null)
				this.selectedStudent = sdt;
				
		}

	

public Student getStudent() {
	return student;
}

public void setClient(Student client) {
	this.student = client;
}

public List<Student> getListeStudents() throws Exception {
	this.listeStudents = StudentDbUtil.listerTous();
	return this.listeStudents;
}

public void setListeStudents(List<Student> listeStudents) {
	this.listeStudents = listeStudents;
}

public Student getSelectedStudent() {
	return selectedStudent;
}

public void setSelectedClient(Student selectedStudent) {
	this.selectedStudent = selectedStudent;
}


}


