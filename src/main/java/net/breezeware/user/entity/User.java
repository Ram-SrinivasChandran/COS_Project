package net.breezeware.user.entity;

/**
 * Represents a user entity with attributes such as ID, name, username, password, and role.
 */
public class User {
    private int id;          // Unique identifier for the user.
    private String name;     // Full name of the user.
    private String username; // User's username.
    private String password; // User's password.
    private String role;     // User's role.

    /**
     * Constructs a new User object with the specified attributes.
     *
     * @param id       The unique identifier for the user.
     * @param name     The full name of the user.
     * @param username The username chosen by the user.
     * @param password The user's password.
     * @param role     The role or permission level of the user.
     */
    public User(int id, String name, String username, String password, String role) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    /**
     * Get the unique identifier of the user.
     *
     * @return The user's ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Set the unique identifier of the user.
     *
     * @param id The user's ID.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the full name of the user.
     *
     * @return The user's full name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the full name of the user.
     *
     * @param name The user's full name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the username of the user.
     *
     * @return The user's username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the username of the user.
     *
     * @param username The user's username.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get the password of the user.
     *
     * @return The user's password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the password of the user.
     *
     * @param password The user's password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the role or permission level of the user.
     *
     * @return The user's role.
     */
    public String getRole() {
        return role;
    }

    /**
     * Set the role or permission level of the user.
     *
     * @param role The user's role.
     */
    public void setRole(String role) {
        this.role = role;
    }
}