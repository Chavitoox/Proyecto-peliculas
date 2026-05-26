package com.example.idioma.model;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Idioma {
    @Id
    private String id;
    private String version;
    private String lenguaje;
public Idioma(){}

public String getId(){
    return id;
}
public String getVersion(){
    return version;
}
public String getLenguaje(){
    return lenguaje;
}
public void setVersion( String version){
    this.version=version;
}
public void setLenguaje (String lenguaje){
    this.lenguaje=lenguaje;
}
}
