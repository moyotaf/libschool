package com.innate.cresterp.payments;

/**
 *
 * @author Simbarashe Clever
 */
public class UrlManager {
    private final String paymentsUrl = "http://localhost/school/payments.php?action=2";
    
    public String getUrl(){
        return paymentsUrl;
    }
}
