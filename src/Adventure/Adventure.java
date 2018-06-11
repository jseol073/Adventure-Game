package Adventure;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class Adventure {

    private static final int STATUS_OK = 200;
    private static final String QUIT = "QUIT";
    private static final String EXIT = "EXIT";

    public static void main(String[] args) {
	    Layout layout = new Layout();
        int gameRoomIndex = GamePlay.getStartingRoom(layout);
        String jsonInfo = "";
        Gson gson = new Gson();


        // this is a 'for each' loop; they are useful when you want to do something to
        // every element of a collection and you don't care about the index of the element
        for (String arg : args) {
            System.out.print("\"" + arg + "\" ");
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Press any key to play");
        while (sc.hasNextLine() && (!(sc.nextLine().equalsIgnoreCase(QUIT))
                || !(sc.nextLine().equalsIgnoreCase(EXIT)))) {
            System.out.println(GamePlay.jsonInfo(gameRoomIndex, layout));
        }
    }
}
