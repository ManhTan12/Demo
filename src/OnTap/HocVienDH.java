/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OnTap;

import java.io.Serializable;
import java.util.Scanner;

public class HocVienDH extends HocVien 
        implements Comparable<HocVienDH>, Serializable {
    
    private int soBuoi;
    private long donGia;

    public HocVienDH() {
        super();
        soBuoi = 0;
        donGia = 0;
    }

    public HocVienDH(int soBuoi, long donGia) {
        this.soBuoi = soBuoi;
        this.donGia = donGia;
    }

    public HocVienDH(String hoTen, String diaChi, String loaiUuTien, String loaiChuongTrinh, int soBuoi, long donGia) {
        super(hoTen, diaChi, loaiUuTien, loaiChuongTrinh);
        this.soBuoi = soBuoi;
        this.donGia = donGia;
    }

    public long getSoBuoi() {
        return soBuoi;
    }

    public void setSoBuoi(int soBuoi) throws Exception {
        if (soBuoi <= 0) {
            throw new Exception("So buoi phai > 0");
        }
        this.soBuoi = soBuoi;
    }
    public void setDonGia(int donGia) throws Exception {
        if (donGia <= 0) {
            throw new Exception("So buoi phai > 0");
        }
        this.donGia = donGia;
    }

    public long getdonGia() {
        return donGia;
    }

    public void setDonGia(long donGia) {
        
        this.donGia = donGia;
    }

    public long uUTien() {
        if (getLoaiUuTien().equalsIgnoreCase("loai 1")) {
            return 1000000;
        }
        return 500000;
    }

    @Override
    public long hocPhi() {
        return soBuoi * donGia - uUTien();
    }

    @Override
    public void nhapThongTin() {
        super.nhapThongTin();
        if (hoTen.isEmpty()) {
            return;
        }
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Nhap so buoi: ");
            setSoBuoi(Integer.parseInt(sc.next()));
            System.out.print("Nhap don gia: ");
            setDonGia(Long.parseLong(sc.next()));
            
        } catch (Exception e) {
            System.out.println("Loi: " + e.toString());
        }
        
    }

    @Override
    public int compareTo(HocVienDH o) {
        if (this.soBuoi > o.soBuoi) {
            return 1;
        } else if (this.soBuoi < o.soBuoi) {
            return -1;
        } else {
            return 0;
        }
    }

    public static void inTieuDe() {
        System.out.printf("%20s%20s%20s%20s%15s%15s%15s\n", "Ho ten", "Dia chi",
                "Loai uu tien", "Loai chuong trinh", "So buoi", "Don gia", "Hoc phi");
    }

//    @Override
//    public String toString() {
//
//        return String.format("%80s%15d%15d%15d", super.toString(), soBuoi, donGia, hocPhi());
//    }
    
     @Override
    public String toString() {

        return String.format("%20s%20s%20s%20ss%15d%15d%15d", hoTen, diaChi, loaiUuTien, loaiChuongTrinh, soBuoi, donGia, hocPhi());
    }
}
