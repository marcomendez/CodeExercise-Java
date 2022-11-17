package helpers;

public class MyString {

    private String value;

    public MyString(String value) {
        try {
            this.value = new String(value.replace(Constants.USER_TOKEN, (String) ScenarioContent.get(Constants.USER_TOKEN)));
            this.value = new String(this.value.replace(Constants.REFRESH_TOKEN, (String) ScenarioContent.get(Constants.REFRESH_TOKEN)));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public String toString() {
        return this.value;
    }

}
