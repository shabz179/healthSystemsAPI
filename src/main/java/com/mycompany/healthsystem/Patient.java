/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.healthsystem;

/**
 *
 * @author shabnoor
 */

public class Patient extends Person {
   
    private int id;
    private int age;
    private String medicalHistory;
    private String currentHealthStatus;
    private Doctor doctor;
    
    public Patient(){
        
    }

    public Patient(int id, String name, int age, String address, String contactInformation, String medicalHistory, String currentHealthStatus) {
        super(name, contactInformation, address);
        this.id = id;
        this.age = age;
        this.medicalHistory = medicalHistory;
        this.currentHealthStatus = currentHealthStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getCurrentHealthStatus() {
        return currentHealthStatus;
    }

    public void setCurrentHealthStatus(String currentHealthStatus) {
        this.currentHealthStatus = currentHealthStatus;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
