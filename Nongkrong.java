package com.muliamaulana.medannongkrong;

/**
 * Created by muliamaulana on 11/5/16.
 */

public class Nongkrong {
    private String id;
    private String nama;
    private String tempat;

    public Nongkrong(String id, String nama, String tempat) {
        this.id = id;
        this.nama = nama;
        this.tempat = tempat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTempat() {
        return tempat;
    }

    public void setTempat(String tempat) {
        this.tempat = tempat;
    }
}

