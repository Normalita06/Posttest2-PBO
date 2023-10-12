/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PD;


public class Pengurus {
    private int id;
    private String nama;
    private String ulangTahun;

    public Pengurus(int id, String nama, String ulangTahun) {
    this.id = id;
    this.nama = nama;
    this.ulangTahun = ulangTahun;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUlangTahun() {
        return ulangTahun;
    }

    public void setUlangTahun(String ulangTahun) {
        this.ulangTahun = ulangTahun;
    }
    
    //override
    public String toString(){
        return "Pengurus{" +
                "id=" + getId() +
                ", nama='" + getNama() +'\'' +
                ", ulangTahun='" + getUlangTahun() + '\'' +
                '}';
    }
}
