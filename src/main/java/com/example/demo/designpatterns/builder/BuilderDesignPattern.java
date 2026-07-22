package com.example.demo.designpatterns.builder;

class User{
    private String name;
    private int age;
    private String email;
    private String address;
    private User(Builder builder){
        this.name = builder.name;
        this.age = builder.age;
        this.email = builder.email;
        this.address = builder.address;

    }

    public static class Builder{
        private String name;
        private int age;
        private String email;
        private String address;

        public Builder name(String name){
           this.name = name;
           return this;
        }
        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public User build(){
            return new User(this);
        }


    }

}
public class BuilderDesignPattern {
    public static void main(String[] args) {
        User user = new User.Builder().name("ddfwws").build();
        System.out.println(user);

    }
}
