package com.application.beatbox;

public class Sound {

    private String mAssetPath;
    private String mName;
    private Integer id;

    public Sound(String path){
        this.mAssetPath=path;
        String[] components=mAssetPath.split("/");
        mName=components[components.length-1];
        mName.replace(".wav","");
    }

    public String getAssetPath() {
        return mAssetPath;
    }

    public String getName() {
        return mName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
