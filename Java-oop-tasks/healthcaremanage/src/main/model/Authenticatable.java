package main.model;

public interface Authenticatable {
    boolean authenticate(String username, String password);
}
