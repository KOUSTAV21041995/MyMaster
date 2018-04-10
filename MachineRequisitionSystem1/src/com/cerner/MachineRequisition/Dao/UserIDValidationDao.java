/**
* This is the Dao Interface for UserIDValidation 
*
* @author Rahul Ghata
*/

package com.cerner.MachineRequisition.Dao;

public interface UserIDValidationDao {
    public boolean isValidUserID(String associateId);
}
