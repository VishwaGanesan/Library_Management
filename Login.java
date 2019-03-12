import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Login {
    public static void get() throws Exception {
      try
      {
          URL url = new URL("https://2factor.in/API/V1/d82f364f-44c8-11e9-8806-0200cd936042/BAL/SMS");
          HttpURLConnection con = (HttpURLConnection) url.openConnection();
          con.setRequestMethod("GET");
          con.connect();
          int code = con.getResponseCode();
          BufferedReader reader = null;
          reader= new BufferedReader(new InputStreamReader(con.getInputStream()));
          //reading response
          String response;
          while ((response = reader.readLine()) != null)
              //print response
              System.out.println(response);

          //finally close connection
          reader.close();
       }
      catch (Exception e)
      {
          System.out.print(e);
      }
    }
    public static  void  main(String args[])
    {
        try {
            get();
            System.out.print("end");
        }
        catch (Exception e)
        {

        }
    }

}
