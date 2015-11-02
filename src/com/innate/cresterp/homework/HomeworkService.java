package com.innate.cresterp.homework;

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
public class HomeworkService {
     private final List<Homework> dailyHomework = new ArrayList<Homework>();

    public List<Homework> findHomework() {
        // convert the object to a JSON document
        dailyHomework.clear();
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
                vector = (Vector) hm.get("homework");

                if (vector.size() > 0) {
                    for (int i = 0; i < vector.size(); i++) {

                        Hashtable h = (Hashtable) vector.get(i);
                        Homework homework = new Homework();
                        homework.setId(Integer.parseInt(h.get("id").toString()));
                        homework.setUsername(h.get("username").toString());
                        homework.setActivation(h.get("activation").toString());
                        homework.setInstallation(h.get("installation").toString());
                        homework.setPassword(h.get("password").toString());
                        homework.setSubject(h.get("subject").toString());
                        homework.setStudentclass(h.get("studentclass").toString());
                        homework.setDescription(h.get("description").toString());
                        homework.setTeacher(h.get("teacher").toString());
                        homework.setAssignedDate(h.get("assignedDate").toString());
                        homework.setDueDate(h.get("dueDate").toString());
                        homework.setWfield1(h.get("wfield1").toString());
                        homework.setWfield2(h.get("wfield2").toString());
                        homework.setWfield3(h.get("wfield3").toString());
                        homework.setWfield4(h.get("wfield4").toString());
                        dailyHomework.add(homework);

                    }
                } else {
                    Homework homework = new Homework();
                    homework.setUsername("Sorry...");
                    homework.setDescription("No messages today");
                    dailyHomework.add(homework);
                }
            }

            @Override
            protected void handleException(Exception err) {
                System.err.println(err);
                 Homework homework = new Homework();
                    homework.setUsername("Ooops...");
                    homework.setDescription("Please check your internet connection ");
                    dailyHomework.add(homework);

            }

        };

        String url = new UrlManager().getUrl();
        request.setUrl(url);
        request.setPost(false);
         
        networkManager.addToQueueAndWait(request);

        return dailyHomework;
    }

}
