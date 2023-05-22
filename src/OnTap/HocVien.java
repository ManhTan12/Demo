/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OnTap;

import java.io.Serializable;
import java.util.Scanner;

public abstract class HocVien implements Serializable {

    protected String hoTen;
    protected String diaChi;
    protected String loaiUuTien;
    protected String loaiChuongTrinh;

    public HocVien() {
        hoTen = diaChi = loaiUuTien = loaiChuongTrinh = "";
    }

    public HocVien(String hoTen, String diaChi, String loaiUuTien, String loaiChuongTrinh) {
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.loaiUuTien = loaiUuTien;
        this.loaiChuongTrinh = loaiChuongTrinh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getLoaiUuTien() {
        return loaiUuTien;
    }

    public void setLoaiUuTien(String loaiUuTien) {
        this.loaiUuTien = loaiUuTien;
    }

    public String getLoaiChuongTrinh() {
        return loaiChuongTrinh;
    }

    public void setLoaiChuongTrinh(String loaiChuongTrinh) {
        this.loaiChuongTrinh = loaiChuongTrinh;
    }

    public void nhapThongTin() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ho ten: ");
        setHoTen(sc.nextLine());
        if (hoTen.isEmpty()) return;
        System.out.print("Nhap dia chi: ");
        setDiaChi(sc.nextLine());
        System.out.print("Nhap loai uu tien (loai 1 | loai 2): ");
        setLoaiUuTien(sc.nextLine());
        System.out.print("Nhap loai chuong trinh dang ky (do hoa | lap trinh): ");
        setLoaiChuongTrinh(sc.nextLine());
    }

    public void inThongTin() {
        System.out.println("Ho ten: " + getHoTen());
        System.out.println("Dia chi: " + getDiaChi());
        System.out.println("Loai uu tien: " + getLoaiUuTien());
        System.out.println("Loai chuong trinh dang ky hoc: " + getLoaiChuongTrinh());
        System.out.println("Hoc phi: " + hocPhi());
    }

    public abstract long hocPhi();

//    @Override
//    public String toString() {
//        return String.format("%20s%20s%20s%20s", hoTen, diaChi, loaiUuTien, loaiChuongTrinh);
//    }
}
