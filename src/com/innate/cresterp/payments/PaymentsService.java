package com.innate.cresterp.payments;

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
public class PaymentsService {
     private final List<Payments> myPayments = new ArrayList<Payments>();

    public List<Payments> findPayments() {
        // convert the object to a JSON document
        myPayments.clear();
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
                vector = (Vector) hm.get("payments");

                if (vector.size() > 0) {
                    for (int i = 0; i < vector.size(); i++) {

                        Hashtable h = (Hashtable) vector.get(i);
                        Payments payments = new Payments();
                        payments.setId(Integer.parseInt(h.get("id").toString()));
                        payments.setUsername(h.get("username").toString());
                        payments.setActivation(h.get("activation").toString());
                        payments.setInstallation(h.get("installation").toString());
                        payments.setPassword(h.get("password").toString());
                        payments.setBalance(h.get("balance").toString());
                        payments.setWfield1(h.get("wfield1").toString());
                        payments.setWfield2(h.get("wfield2").toString());
                        payments.setWfield3(h.get("wfield3").toString());
                        payments.setWfield4(h.get("wfield4").toString());
                        myPayments.add(payments);

                    }
                } else {
                    Payments payments = new Payments();
                    payments.setUsername("Sorry...");
                    //payments.setDescription("No messages today");
                    myPayments.add(payments);
                }
            }

            @Override
            protected void handleException(Exception err) {
                System.err.println(err);
                 Payments payments = new Payments();
                    payments.setUsername("Ooops...");
                    //payments.setDescription("Please check your internet connection ");
                    myPayments.add(payments);

            }

        };

        String url = new com.innate.cresterp.homework.UrlManager().getUrl();
        request.setUrl(url);
        request.setPost(false);
         InfiniteProgress ip = new InfiniteProgress();
         
        networkManager.addToQueueAndWait(request);

        return myPayments;
    }
}
