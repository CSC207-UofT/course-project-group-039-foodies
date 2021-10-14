import java.util.HashMap;

public class UserManager {
    HashMap<String, User> user_map;


    public UserManager() { user_map = new HashMap<>();}


    /* If the ID string does not appear as a key in user_map,
       then add the pair to user_map.
       Return true if the user was successfully added to user_map,
       and false otherwise.
     */
    public boolean addUser(User user){
        String userName = user.getUsername();
        if (user_map.containsKey(userName)) {
            return false;
        }
        else {
            user_map.put(userName, user);
            return true;
        }
    }



    /* If the ID string appears as a key in user_map,
       then remove the pair from user_map.
       Return true if the user was successfully deleted from user_map,
       and false otherwise.
    */
    public boolean deleteUser(User user) {
        String userName = user.getUsername();
        if ((user_map.containsKey(userName)) && user_map.get(userName).equals(user)) {
            user_map.remove(userName);
            return true;
        } else {
            return false;
        }
    }
}


