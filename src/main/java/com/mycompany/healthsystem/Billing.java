/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.healthsystem;

/**
 *
 * @author shabnoor
 */

public class Billing {
    private Patient patient;
    private double invoiceAmount;
    private double amount;
    private double outstandingBalance;
    private String paymentStatus; 
     private String doctor; 
    private int id;

    public Billing(Patient patient, double invoiceAmount, double amount, double outstandingBalance, String paymentStatus, String doctor) {
        this.patient = patient;
        this.invoiceAmount = invoiceAmount;
        this.amount = amount;
        this.outstandingBalance = outstandingBalance;
        this.paymentStatus = paymentStatus;
        this.doctor = doctor;
    }

    public Billing() {
    }


    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public double getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(double invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public double getOutstandingBalance() {
        return outstandingBalance;
    }

    public void setOutstandingBalance(double outstandingBalance) {
        this.outstandingBalance = outstandingBalance;
    }
    
    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

