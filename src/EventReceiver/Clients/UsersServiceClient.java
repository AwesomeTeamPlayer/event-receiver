package EventReceiver.Clients;

import EventReceiver.Clients.ValueObjects.User;
import EventReceiver.HttpRequestMaker;
import org.json.JSONObject;

import java.io.IOException;

public class UsersServiceClient
{
    private final HttpRequestMaker usersService;

    public UsersServiceClient(HttpRequestMaker sourceListener)
    {
        this.usersService = sourceListener;
    }

    public void createUser(User user)  throws IOException
    {
        JSONObject json = new JSONObject();

        json.put("name", user.getName());
        json.put("email", user.getEmail());
        json.put("isActive", user.isActive());

        this.usersService.makePutRequest(
           "users",
            json
        );
    }

    public void updateUser(User user) throws IOException
    {
        JSONObject json = new JSONObject();

        json.put("name", user.getName());
        json.put("email", user.getEmail());
        json.put("isActive", user.isActive());

        this.usersService.makePostRequest(
            "users",
            json
        );
    }

    public User findUser(String email) throws IOException
    {
        String response = this.usersService.makeGetRequest(
            "/users?email=" + email
        );

        JSONObject responseJson = new JSONObject(response);
        return new User(
            responseJson.getString("name"),
            responseJson.getString("email"),
            responseJson.getBoolean("isActive")
        );
    }
}
