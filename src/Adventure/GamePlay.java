package Adventure;

import java.util.ArrayList;
import java.util.HashMap;

public class GamePlay {
    public static final String GO = "go";
    public static final String TAKE_OR_DROP = "takeOrDrop";
    public static final String LIST = "list";
    public static final String PLAYER_INFO = "playerinfo";
    public static final String DUAL = "dual";
    public static final String FALSE_COMMAND = "I don't understand";
    private static final int MIN_ARR_LENGTH = 2;
    private static final int MIN_STR_LENGTH = 4;

    public static int getStartingRoom(Layout layout) {
        Room[] allRooms = layout.getRooms();
        String startingRoom = layout.getStartingRoom();
        int startingRoomIndex = 0;
        for (int roomIndex = 0; roomIndex < allRooms.length; roomIndex++) {
            if (allRooms[roomIndex].getName().equalsIgnoreCase(startingRoom)) {
                startingRoomIndex = roomIndex;
            }
        }
        return startingRoomIndex;
    }

    public static String jsonInfo(int roomIndex, Layout layout) {
        String roomName = layout.getRooms()[roomIndex].getName();
        String description = layout.getRooms()[roomIndex].getDescription();
        Directions[] directions = layout.getRooms()[roomIndex].getDirections();
        ArrayList<String> directionNamesList = new ArrayList<>();
        for (int dirIndex = 0; dirIndex < directions.length; dirIndex++) {
            directionNamesList.add(directions[dirIndex].getDirectionName());
        }
        String directionNames = "From here you can go: " +directionNamesList.toString();
        Item[] itemArr = layout.getRooms()[roomIndex].getItems();
        HashMap<String, Double> itemMap = new HashMap<>();
        for (int itemIndex = 0; itemIndex < itemArr.length; itemIndex++) {
            itemMap.put(itemArr[itemIndex].getName(), itemArr[itemIndex].getDamage());
        }
        String itemInfo = "This room has these items: " + itemMap.toString();
        if (itemMap == null || itemMap.isEmpty()) {
            itemInfo = "This room is empty.";
        }
        return String.format("%s\n%s\n%s\n%s", roomName, description, directionNames, itemInfo);
    }

    public static String handleUserInput(String userInput, int roomIndex, Layout layout) {
        String userInputLwrCase = userInput.toLowerCase();
        String lwrCaseTrimmed = userInputLwrCase.trim();
        String[] inputSplitArr = lwrCaseTrimmed.split("\\s+", MIN_ARR_LENGTH);
        if (inputSplitArr[0].equalsIgnoreCase(GO)) {
            //return goToNextRoom(inputSplitArr[1], roomIndex, layout);
        } else if (inputSplitArr[0].equalsIgnoreCase(TAKE_OR_DROP)) {

        } else if (inputSplitArr[0].equalsIgnoreCase(LIST)) {

        } else if (inputSplitArr[0].equalsIgnoreCase(PLAYER_INFO)) {

        } else if (inputSplitArr[0].equalsIgnoreCase(DUAL)) {

        }
        return FALSE_COMMAND;
    }
}
