package edu.eci.parcialT2.service.impl;

import edu.eci.parcialT2.service.HttpConnectionService;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service("HttpConnectionServiceImpl")
public class HttpConnectionServiceImpl implements HttpConnectionService
{
    @Override
    public String weatherByCity(String name) throws IOException {
        String USER_AGENT = "Mozilla/5.0";
        String GET_URL = "http://api.openweathermap.org/data/2.5/weather?q="+name+"&appid=dfe0bcf2c9fa6e5cd6cf29a71de1ae77";
        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("x-rapidapi-host", "cometari-airportsfinder-v1.p.rapidapi.com");
        con.setRequestProperty("x-rapidapi-key", "44e05e8a84msh20cfe27fb6ce493p1e0dcdjsnb2c38f63528b");

        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {

                response.append(inputLine);
            }
            in.close();

            return response.toString();
        } else {

            return "GET request not worked";
        }

    }
}
