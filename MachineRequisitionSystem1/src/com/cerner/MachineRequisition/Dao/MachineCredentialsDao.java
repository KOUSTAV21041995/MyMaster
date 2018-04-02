<<<<<<< HEAD
package com.cerner.MachineRequisition.Dao;

public interface MachineCredentialsDao {
	public String getDivisionNamebyIP(String credential);
	public String getDivisionNamebyServer(String credential);
=======
/**
* This is the Dao Interface for MachineCredentials concerned with
* the retrieval of division name on the basis of credential value 
* i.e. IP Address and Server Name
*
* @author Varsha Das
*/

package com.cerner.MachineRequisition.Dao;

public interface MachineCredentialsDao {
    public String getDivisionNamebyIP(String credential);

    public String getDivisionNamebyServer(String credential);
>>>>>>> ba8381470b6d1618adabb0bad9570f789d92ab1a
}
