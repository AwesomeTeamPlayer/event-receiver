package EventReceiver.Clients.ValueObjects;

public class User
{
    private String name;
    private String email;
    private boolean isActive;

    public User(String name, String email, boolean isActive)
    {
        this.name = name;
        this.email = email;
        this.isActive = isActive;
    }

    public String getName()
    {
        return this.name;
    }

    public String getEmail()
    {
        return this.email;
    }

    public boolean isActive()
    {
        return this.isActive;
    }
}
