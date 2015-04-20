package com.wave.command;



public class RoleCommand {

    private Long Id;
    private String name;
    private String description;

    public Long getId(){
        return Id;
    }

    public  void setId(Long Id){
        this.Id=Id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
