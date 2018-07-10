package am.soccer.service.forldcup;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class SoccerServiceImpl implements SoccerService {

    @Override
    public String getSoccerJson() {
        URL url;
        HttpURLConnection con;
        StringBuilder content = new StringBuilder("");
        try {
            url = new URL("https://raw.githubusercontent.com/openfootball/world-cup.json/master/2018/worldcup.json");
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");


            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return content.toString();
    }
}
