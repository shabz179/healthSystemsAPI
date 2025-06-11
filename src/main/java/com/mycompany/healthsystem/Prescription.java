/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.healthsystem;

/**
 *
 * @author shabnoor
 */
public class Prescription {
    private String medication;
    private String dosage;
    private String instructions;
    private String duration;
    private int id;
    private String doctor;
    private String patient;

    public Prescription(int par, String medication, String dosage, String instructions) {
        this.medication = medication;
        this.dosage = dosage;
        this.instructions = instructions;
        this.duration = duration;
    }

    public Prescription(int id, String medication, String dosage, String instructions, String duration, String doctor, String patient) {
        this.id = id;
        this.medication = medication;
        this.dosage = dosage;
        this.instructions = instructions;
        this.duration = duration;
        this.doctor = doctor;
        this.patient = patient;
    }

    public Prescription() {
    }
    
    

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }
}

