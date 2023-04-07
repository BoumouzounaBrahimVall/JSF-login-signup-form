package dao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNT")
public class Account {
    @Id
    private String login;

    private String password;
    private String genre;
    private String firstName;
    private String lastName;
    private String  dateNais;
    private String numTel;
    private String email;
    private String pays;

    public Account() {

    }

    public Account(String login, String password, String genre, String firstName, String lastName, String dateNais, String numTel, String email,String pays) {
        this.login = login;
        this.password = password;
        this.genre = genre;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateNais = dateNais;
        this.numTel = numTel;
        this.email = email;
        this.pays=pays;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
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

    public String getDateNais() {
        return dateNais;
    }

    public void setDateNais(String dateNais) {
        this.dateNais = dateNais;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }
}
