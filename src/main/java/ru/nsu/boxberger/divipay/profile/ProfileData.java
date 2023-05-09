package ru.nsu.boxberger.divipay.profile;

public class ProfileData {
    private String name;
    private String nickname;
    private int age;

    private String email;

    public ProfileData(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname(){
        return nickname;
    }

    public void setNickname(String nickname){
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Дополнительные методы, если необходимо
}
