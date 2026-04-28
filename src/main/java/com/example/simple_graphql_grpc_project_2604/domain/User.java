package com.example.simple_graphql_grpc_project_2604.domain;

public class User {

    public static int MIN_NAME_LENGTH = 1;
    public static int MAX_NAME_LENGTH = 50;

    private Long id;
    private String name;

    private User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static User create(String name) {
        return new User(null, name);
    }

    public static User restore(Long id, String name) {
        return new User(id, name);
    }

    public void validateName(String name) {
        if (name.isBlank() || name.length() > MAX_NAME_LENGTH || name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException("이름을 다시 확인해 주세요.");
        }
    }

    public Long id() {
        return this.id;
    }

    public String name() {
        return this.name;
    }

    public String changeName(String newName) {
        validateName(newName);
        this.name = newName;
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        User user = (User) obj;

        if (this.id == null || user.id == null) {
            return false;
        }

        return this.id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
