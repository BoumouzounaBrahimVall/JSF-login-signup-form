package bean;

import dao.Account;
import dao.DAOAccount;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import java.util.*;

//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;

//@ManagedBean
//@SessionScoped
public class User {

    private String login;

    private String password;
    private String genre;
    private String firstName;
    private String lastName;
    private String  dateNais;
    private String numTel;
    private String email;
    private String country;


    private List<String> genres = Arrays.asList("Homme ", "Femme ");

    public User() {
    }
    public String  getCountry() {
        return country;
    }

    public void setCountry(String selectedCountry) {
        this.country = selectedCountry;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getGenre() {
        return genre;
    }
    public String getDateNais() {
        return dateNais;
    }

    public void setDateNais(String dateNais) {
        this.dateNais = dateNais;
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
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
        Account account=dao.getAccount(login);
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
        Account account=new Account( login,  password,  genre,  firstName,  lastName,  dateNais,  numTel,  email,country);
        if(account.getPassword()!=null && account.getLogin()!=null ){
            dao.create(account);
            return "success";

        }

        return "register";
    }

    public void validateDateNais(FacesContext context, UIComponent comp,
                                Object value) {

        System.out.println("inside validate method");

        String date = (String) value;

        if (!date.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/(19|20)\\d\\d$")) {
            ((UIInput) comp).setValid(false);

            FacesMessage message = new FacesMessage(
                    "date incorrecte: ex: 31/12/2000");
            context.addMessage(comp.getClientId(context), message);

        }

    }

    public void validateNumTel(FacesContext context, UIComponent comp,
                                 Object value) {

        System.out.println("inside validate method");

        String num = (String) value;

        if (!num.matches("^(0[567][0-9]{8})$")) {
            ((UIInput) comp).setValid(false);

            FacesMessage message = new FacesMessage(
                    "numero telephone incorrecte: ex: 0XXXXXXXXXX");
            context.addMessage(comp.getClientId(context), message);

        }

    }

    public void validateEmail(FacesContext context, UIComponent comp,
                               Object value) {

        System.out.println("inside validate method");

        String num = (String) value;

        if (!num.matches("^((?!\\.)[\\w-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])$")) {
            ((UIInput) comp).setValid(false);

            FacesMessage message = new FacesMessage(
                    "Email incorrect");
            context.addMessage(comp.getClientId(context), message);

        }

    }




    public List<String> getCountryOptions() {
        List<String> lesPays=new ArrayList<>();
        for (String countryCode : Locale.getISOCountries()) {
            lesPays.add(new Locale("fr", countryCode).getDisplayCountry(Locale.FRENCH));
        }
        return lesPays;
    }
}
