package at.savovuksan.VSMServer.User;

import java.util.Map;

public class UserException extends Exception{
    private Map<String, String> errors;
   
   public UserException(Map<String, String> errors){
       this.errors = errors;
   }

   public Map<String, String> getErrors() {
       return errors;
   }


}
