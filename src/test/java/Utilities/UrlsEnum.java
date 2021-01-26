package Utilities;

public enum UrlsEnum {
    RegisterAPI("/api/register"),
    UsersListAPI("/api/users?page=2");

    String resource;

    UrlsEnum(String resource) {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }
}
