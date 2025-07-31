package model;

public class Server {
    private int serverId;
    private String name;

    public Server() {
        // default constructor
    }

    public Server(int serverId, String name) {
        this.serverId = serverId;
        this.name = name;
    }

    public int getServerId() {
        return serverId;
    }

    public void setServerId(int serverId) {
        this.serverId = serverId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Server{" +
                "serverId=" + serverId +
                ", name='" + name + '\'' +
                '}';
    }
}
