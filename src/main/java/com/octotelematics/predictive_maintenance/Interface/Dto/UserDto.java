package com.octotelematics.predictive_maintenance.Interface.Dto;

public class UserDto {
    private String serialNumber;
    private String taxId;
    private String name;
    private String surname;
    private String mail;

    public UserDto(String serialNumber, String taxId, String name, String surname, String mail) {
        this.serialNumber = serialNumber;
        this.taxId = taxId;
        this.name = name;
        this.surname = surname;
        this.mail = mail;
    }

    public String getSerialNumber() {
        return serialNumber;
    }
    public String getTaxId() {
        return taxId;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getMail() {
        return mail;
    }
}
