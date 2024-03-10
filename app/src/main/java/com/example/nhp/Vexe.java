package com.example.nhp;

public class Vexe {
    String tuyen;
    String nhaxe;
    String gio;
    String ngaydi;
    int soluong;
    int id;
    String maghe;
    int tamtinh;
    String tenkhachhang;
    String sodienthoai;

    public Vexe() {
    }

    public Vexe(String tuyen, String nhaxe, String gio, String ngaydi, int soluong, int id, String maghe, int tamtinh, String tenkhachhang, String sodienthoai) {
        this.tuyen = tuyen;
        this.nhaxe = nhaxe;
        this.gio = gio;
        this.ngaydi = ngaydi;
        this.soluong = soluong;
        this.id = id;
        this.maghe = maghe;
        this.tamtinh = tamtinh;
        this.tenkhachhang = tenkhachhang;
        this.sodienthoai = sodienthoai;
    }

    public String getTenkhachhang() {
        return tenkhachhang;
    }

    public void setTenkhachhang(String tenkhachhang) {
        this.tenkhachhang = tenkhachhang;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public String getTuyen() {
        return tuyen;
    }

    public void setTuyen(String tuyen) {
        this.tuyen = tuyen;
    }

    public String getNhaxe() {
        return nhaxe;
    }

    public void setNhaxe(String nhaxe) {
        this.nhaxe = nhaxe;
    }

    public String getGio() {
        return gio;
    }

    public void setGio(String gio) {
        this.gio = gio;
    }

    public String getNgaydi() {
        return ngaydi;
    }

    public void setNgaydi(String ngaydi) {
        this.ngaydi = ngaydi;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaghe() {
        return maghe;
    }

    public void setMaghe(String maghe) {
        this.maghe = maghe;
    }

    public int getTamtinh() {
        return tamtinh;
    }

    public void setTamtinh(int tamtinh) {
        this.tamtinh = tamtinh;
    }
}
