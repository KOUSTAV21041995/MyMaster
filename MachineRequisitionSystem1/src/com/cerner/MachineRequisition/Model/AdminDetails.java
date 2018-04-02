/**
* This is the Model class for Admin Details from "division" table with the getters and setters
*  
* @author Rahul Ghata
*/
package com.cerner.MachineRequisition.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "division")
public class AdminDetails {
    @Id
    @Column(name = "DivisionName")
    private String divName;
    @Column(name = "AdminName")
    private String adminName;
    @Column(name = "AdminEmail")
    private String adminEmail;
    @Column(name = "DivisionCode")
    private String divCode;

    public AdminDetails() {
        super();
    }

    public String getDivName() {
        return divName;
    }

    public void setDivName(String divName) {
        this.divName = divName;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getDivCode() {
        return divCode;
    }

    public void setDivCode(String divCode) {
        this.divCode = divCode;
    }
}
