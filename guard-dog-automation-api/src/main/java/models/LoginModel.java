package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class LoginModel {

    @JsonProperty("$schema")
    public String schema;
    public String title;
    public String description;
    public String type;
    public Properties properties;
    public List<String> required;
}


class Kind{
    public String description;
    public String type;
}

class LocalId{
    public String description;
    public String type;
}

class Email{
    public String description;
    public String type;
}

class DisplayName{
    public String description;
    public String type;
}

class IdToken{
    public String description;
    public String type;
}

class Registered{
    public String description;
    public String type;
}

class RefreshToken{
    public String description;
    public String type;
}

class ExpiresIn{
    public String description;
    public String type;
}

class Properties{
    public Kind kind;
    public LocalId localId;
    public Email email;
    public DisplayName displayName;
    public IdToken idToken;
    public Registered registered;
    public RefreshToken refreshToken;
    public ExpiresIn expiresIn;
}


