/**
* This is a Model class which maps to the request table
* in machine_requisition mysql database
*
* @author  Varsha Das 
*          Software Intern,DevAcademy India 
*/
package com.cerner.MachineRequisition.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "request")
public class RequestDetails {
    @Id
    @Column(name = "RequestId")
    private int requestid;
    @Column(name = "Credential")
    private String credential;
    @Column(name = "AssociateId")
    private String associd;
    @Column(name = "StartDate")
    private String startdate;
    @Column(name = "EndDate")
    private String enddate;
    @Column(name = "DivisionName")
    private String divname;

    public RequestDetails() {
        super();
    }

    public int getRequestid() {
        return requestid;
    }

    public void setRequestid(int requestid) {
        this.requestid = requestid;
    }

    public String getDivname() {
        return divname;
    }

    public void setDivname(String divname) {
        this.divname = divname;
    }

    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credential;
    }

    public String getAssocid() {
        return associd;
    }

    public void setAssocid(String associd) {
        this.associd = associd;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }
}
