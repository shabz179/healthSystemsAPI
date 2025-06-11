/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.healthsystem;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shabnoor
 */

import java.util.ArrayList;
import java.util.List;

public class Doctor extends Person{
   
    private int id;
    private String specialisation;
    private List<Patient> patients;

    public Doctor(String name, String contactInformation, String address) {
        super(name, contactInformation, address);
    }
    
    public Doctor(){
        
    }
 
    public Doctor(int id, String name,String contactInformation,String address,String specialisation){
        super(name, contactInformation, address);
        this.id = id;
        this.specialisation = specialisation;
        this.patients = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }
    
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void deletePatient(Patient patient) {
        patients.remove(patient);
    }

}
