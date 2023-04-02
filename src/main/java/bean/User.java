package bean;

import dao.Account;
import dao.DAOAccount;

import java.util.Date;

//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;

//@ManagedBean
//@SessionScoped
public class User {

    private String username;

    private String password;
    private String firstName;
    private String lastName;
    private Date dateNais;
    public User() {
    }

    public Date getDateNais() {
        return dateNais;
    }

    public void setDateNais(Date dateNais) {
        this.dateNais = dateNais;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
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

    public String login(){
        DAOAccount dao=new DAOAccount();
        Account account=dao.getAccount(username);
        if(account!=null){
            if(account.getPassword().equals(password)){
                firstName=account.getFirstName()+" ";
                lastName=account.getLastName();
                return "success";
            }
        }

        return "error-page";
    }

    public String register(){
        DAOAccount dao=new DAOAccount();
        Account account=new Account(username,password,firstName,lastName);
        if(account.getPassword()!=null && account.getUsername()!=null ){
            dao.create(account);
            return "success";

        }

        return "index";
    }

}
