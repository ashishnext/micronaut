package taskmanager.domain;

import org.hibernate.annotations.ColumnDefault;
import taskmanager.models.UpdateUserTO;
import taskmanager.models.UserTO;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @NotNull
    @Column(name = "username", nullable = false, unique = true)
    private String userName;

    @NotNull
    @NotBlank
    private String password;

    private Boolean isActive = Boolean.FALSE;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_created")
    private Date dateCreated;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_updated")
    private Date lastUpdated;

    private String firstName;
    private String lastName;

    public User(){

    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.isActive = false;
        this.dateCreated = new Date();
        this.lastUpdated = new Date();
    }

    public User(UserTO userTO) {
        this.userName = userTO.getUsername();
        this.password = userTO.getPassword();
        this.isActive = false;
        this.dateCreated = new Date();
        this.lastUpdated = new Date();
        this.firstName = userTO.getFirstName();
        this.lastName = userTO.getLastName();
    }
    public User(UpdateUserTO updateUserTO) {
        firstName = updateUserTO.getFirstName();
        lastName = updateUserTO.getLastName();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

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
