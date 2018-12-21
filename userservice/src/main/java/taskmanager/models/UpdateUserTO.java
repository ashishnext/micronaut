package taskmanager.models;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class UpdateUserTO {

    @NotNull
    @NotBlank
    private String username;

//    @NotNull
//    @NotBlank
//    private String password;
//    private Date dateOfBirth;
    private String firstName;
    private String lastName;

    public UpdateUserTO(){

    }

//    public UpdateUserTO(String username, String password, Date dateOfBirth) {
//        this.username = username;
//        this.password = password;
//        this.dateOfBirth = dateOfBirth;
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public Date getDateOfBirth() {
//        return dateOfBirth;
//    }
//
//    public void setDateOfBirth(Date dateOfBirth) {
//        this.dateOfBirth = dateOfBirth;
//    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
