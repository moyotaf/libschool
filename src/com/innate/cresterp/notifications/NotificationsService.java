package com.innate.cresterp.notifications;

import com.codename1.components.InfiniteProgress;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Simbarashe Clever
 */
public class NotificationsService {
     private final List<Notifications> dailyNotifications = new ArrayList<Notifications>();

    public List<Notifications> findNotifications() {
        // convert the object to a JSON document
        dailyNotifications.clear();
        NetworkManager networkManager = NetworkManager.getInstance();
        networkManager.start();
        networkManager.addErrorListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                NetworkEvent n = (NetworkEvent) evt;
                n.getError().printStackTrace();
                System.out.println(n.getError());
            }
        });

        ConnectionRequest request;
        request = new ConnectionRequest() {

            int chr;
            StringBuffer sb = new StringBuffer();
            String response = "";

            @Override
            protected void readResponse(InputStream input) throws IOException {

                JSONParser parser = new JSONParser();
                Hashtable hm = parser.parse(new InputStreamReader(input));

                Vector vector = new Vector();
                vector = (Vector) hm.get("notifications");

                if (vector.size() > 0) {
                    for (int i = 0; i < vector.size(); i++) {

                        Hashtable h = (Hashtable) vector.get(i);
                        Notifications notifications = new Notifications();
                        notifications.setId(Integer.parseInt(h.get("id").toString()));
                        notifications.setUsername(h.get("username").toString());
                        notifications.setActivation(h.get("actiovation").toString());
                        notifications.setInstallation(h.get("installation").toString());
                        notifications.setPassword(h.get("password").toString());
                        notifications.setResults(h.get("results").toString());
                        notifications.setWfield1(h.get("wfield1").toString());
                        notifications.setWfield2(h.get("wfield2").toString());
                        notifications.setWfield3(h.get("wfield3").toString());
                        notifications.setWfield4(h.get("wfield4").toString());
                        dailyNotifications.add(notifications);

                    }
                } else {
                    Notifications homework = new Notifications();
                    homework.setUsername("Sorry...");
                    //homework.setDescription("No messages today");
                    dailyNotifications.add(homework);
                }
            }

            @Override
            protected void handleException(Exception err) {
                System.err.println(err);
                 Notifications notifications = new Notifications();
                    notifications.setUsername("Ooops...");
                    //notifications.setDescription("Please check your internet connection ");
                    dailyNotifications.add(notifications);

            }

        };

        String url = new com.innate.cresterp.homework.UrlManager().getUrl();
        request.setUrl(url);
        request.setPost(false);
         InfiniteProgress ip = new InfiniteProgress();
         
        networkManager.addToQueueAndWait(request);

        return dailyNotifications;
    }
}
