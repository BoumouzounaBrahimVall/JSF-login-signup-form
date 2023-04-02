package bean;

import dao.Account;
import dao.DAOAccount;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
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

        return "register";
    }
    public void validateDateOfBirth(FacesContext context, UIComponent component, Object value) throws ValidatorException{
        Date dateOfBirth = (Date) value;
        System.out.println(value);
        if (dateOfBirth == null) {
            FacesMessage message = new FacesMessage("date incorrecte");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
    }
    private String mno;

    public String getMno() {
        return mno;
    }

    public void setMno(String mno) {
        this.mno = mno;
    }

    public void validateModelNo(FacesContext context, UIComponent comp,
                                Object value) {

        System.out.println("inside validate method");

        String date = (String) value;

        if (date.length() < 4) {
            ((UIInput) comp).setValid(false);

            FacesMessage message = new FacesMessage(
                    "Minimum length of model number is 4");
            context.addMessage(comp.getClientId(context), message);

        }

    }
}
