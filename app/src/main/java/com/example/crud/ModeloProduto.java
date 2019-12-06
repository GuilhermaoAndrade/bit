package com.example.crud;

import java.io.Serializable;

public class ModeloProduto implements Serializable {

    private String produto;

    public String getProduto(){
        return produto;
    }

    public void setProduto(String Fproduto) {
        produto = Fproduto;
    }
}
