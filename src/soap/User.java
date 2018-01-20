
package soap;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "User", targetNamespace = "http://soap/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface User {


    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "userCheckResult", targetNamespace = "")
    @RequestWrapper(localName = "checkUser", targetNamespace = "http://soap/", className = "soap.CheckUser")
    @ResponseWrapper(localName = "checkUserResponse", targetNamespace = "http://soap/", className = "soap.CheckUserResponse")
    @Action(input = "http://soap/User/checkUserRequest", output = "http://soap/User/checkUserResponse")
    public String checkUser(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        String arg3);

    /**
     * 
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod
    @WebResult(name = "userList", targetNamespace = "")
    @RequestWrapper(localName = "listUsers", targetNamespace = "http://soap/", className = "soap.ListUsers")
    @ResponseWrapper(localName = "listUsersResponse", targetNamespace = "http://soap/", className = "soap.ListUsersResponse")
    @Action(input = "http://soap/User/listUsersRequest", output = "http://soap/User/listUsersResponse")
    public List<String> listUsers();

}
