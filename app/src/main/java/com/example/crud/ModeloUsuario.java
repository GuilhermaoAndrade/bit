package com.example.crud;

public class ModeloUsuario {
    private static final String LOGIN = "adm";
    private static final String SENHA = "adm";

    private String login;
    private String senha;

    public String getLogin(){
        return login;
    }
    public String getSenha(){
        return senha;
    }


    public void setLogin(String SLogin)
    {
        login = SLogin;
    }
    public void setSenha(String Ssenha)
    {
        senha = Ssenha;
    }



    public boolean ValidarLogin() {
       if(senha.equals(SENHA) && login.equals(LOGIN)){
            return true;
        }else{
           return false;
       }
    }
}



