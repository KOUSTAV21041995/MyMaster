/**
* This is the Model class for Associate Details with the getters and setters for associateId
*  
* @author Rahul Ghata
*/

package com.cerner.MachineRequisition.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "associate")
public class AssociateDetails {
    @Id
    @Column(name = "AssociateId")
    private String associateId;

    public AssociateDetails() {
        super();
    }

    public String getAssociateId() {
        return associateId;
    }

    public void setAssociateId(String associateId) {
        this.associateId = associateId;
    }
}
