package com.innate.cresterp.notifications;

/**
 *
 * @author Simbarashe Clever
 */
public class UrlManager {
    private final String notificationsUrl = "http://localhost/school/notifications.php?action=2";
    
    public String getUrl(){
        return notificationsUrl;
    }
}
