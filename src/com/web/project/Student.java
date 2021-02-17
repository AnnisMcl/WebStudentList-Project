package com.web.project;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "student")
public class Student implements Serializable{

		private static final long serialVersionUID = 1L;

 @Id 
 @GeneratedValue (strategy=GenerationType.IDENTITY) 
//pour autoincrement 
 private int id;
 private String nom;
 private String prenom;
 private String email;
 
 public Student()
 {
	 
 }
 public Student(int id,String nom,String prenpm,String email)
 {
	 this.id=id;
	 this.nom=nom;
	 this.prenom=prenpm;
	 this.email=email;
 }
 
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}

public String toString() {
	return this.id + " "+this.nom+" "+this.prenom+" "+this.email;
	
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
 }
