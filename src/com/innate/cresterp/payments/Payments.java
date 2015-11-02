package com.innate.cresterp.payments;

/**
 *
 * @author Simbarashe Clever
 */
public class Payments {
    private int id;
    private String username;
    private String activation;
    private String installation;
    private String password;
    private String balance;
    private String wfield1;
    private String wfield2;
    private String wfield3;
    private String wfield4;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getActivation() {
        return activation;
    }

    public void setActivation(String activation) {
        this.activation = activation;
    }

    public String getInstallation() {
        return installation;
    }

    public void setInstallation(String installation) {
        this.installation = installation;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getWfield1() {
        return wfield1;
    }

    public void setWfield1(String wfield1) {
        this.wfield1 = wfield1;
    }

    public String getWfield2() {
        return wfield2;
    }

    public void setWfield2(String wfield2) {
        this.wfield2 = wfield2;
    }

    public String getWfield3() {
        return wfield3;
    }

    public void setWfield3(String wfield3) {
        this.wfield3 = wfield3;
    }

    public String getWfield4() {
        return wfield4;
    }

    public void setWfield4(String wfield4) {
        this.wfield4 = wfield4;
    }
    
      public String createHTML() {
        return "<p><strong>Title: </strong>" + getUsername() + "</p>"
                + ""
                + "<p><strong>Description:</strong> " + getWfield1() + "</p>"
                + "<p><strong>Visual:</strong> </p>"
                + "<p><strong>Company:</strong> " + getWfield2()+ "</p>"
                + "<p><strong>Website:</strong> " + getWfield3() + "</p>"
                + ""
                + "<p><strong>Mobile:</strong> " + getWfield4() + "</p>"
            
                + "<p>&nbsp;</p>"
                + ""
                + "<p>&nbsp;</p>";

    }
}
