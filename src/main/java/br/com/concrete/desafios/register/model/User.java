package br.com.concrete.desafios.register.model;



public class User {

    private Long id;
    private String nome;
    private String email;

    public User(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
}
