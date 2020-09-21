package com.aust.healthmate;

public class medicine {
 private String drug,companyName,dosage,medicalCondition,expiryName,sideEffects;

    public medicine(String drug, String companyName, String dosage, String medicalCondition, String expiryName, String sideEffects) {
        this.drug = drug;
        this.companyName = companyName;
        this.dosage = dosage;
        this.medicalCondition = medicalCondition;
        this.expiryName = expiryName;
        this.sideEffects = sideEffects;
    }

    public String getDrug() {
        return drug;
    }

    public void setDrug(String drug) {
        this.drug = drug;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getMedicalCondition() {
        return medicalCondition;
    }

    public void setMedicalCondition(String medicalCondition) {
        this.medicalCondition = medicalCondition;
    }

    public String getExpiryName() {
        return expiryName;
    }

    public void setExpiryName(String expiryName) {
        this.expiryName = expiryName;
    }

    public String getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
    }
}
