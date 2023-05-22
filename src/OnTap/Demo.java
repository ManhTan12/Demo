/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OnTap;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class Demo {
    private static Demo demo = new Demo();
    private TreeSet<HocVienDH> treeSet = new TreeSet<>();
    private String fileName = "E:hocVienDH.txt";
    private static DBEngine db = new DBEngine();
    
    public static void main(String[] args) {
        demo.fakeHocVien();
        System.out.println("\t\t\t\t\t\t---------- DANH SACH DU LIEU MAU ----------");
        demo.inDanhSach();
        
        System.out.println("\nNHAP THEM DU LIEU (Nhap ho ten rong de dung):");
        demo.nhapDanhSach();
        System.out.println("\n\t\t\t\t\t\t---------- DANH SACH SAU KHI NHAP THEM ----------");
        demo.inDanhSach();
        
        System.out.println("\nHOC VIEN CO HOC PHI CAO NHAT LA:");
        HocVienDH.inTieuDe();
        System.out.println(demo.timHocVienDHHocPhiCaoNhat());
        
        System.out.print("\n\tLUU RA FILE: ");
        demo.luuFile();
        demo.docFile();
        System.out.println("\n\t\t\t\t\t\t---------- TAP HOP DOC FILE DUOC LA ----------");
        demo.inDanhSach();
    }
    
    public void fakeHocVien() {
        HocVienDH hocVienDH1 = new HocVienDH("Hoang Van Hiep", "Ninh Binh", 
                "Loai 2", "Do hoa", 12, 320000);
        HocVienDH hocVienDH2 = new HocVienDH("Doan Duc Duy",  "Nam Dinh", 
                "Loai 1", "Do hoa", 15, 380000);
        HocVienDH hocVienDH3 = new HocVienDH("Vuong Tung Duong", "Ha Noi",
                "Loai 2", "Do hoa", 10, 450000);
        treeSet.add(hocVienDH1);
        treeSet.add(hocVienDH2);
        treeSet.add(hocVienDH3);
    }
    
    public void inDanhSach() {
        HocVienDH.inTieuDe();
        Iterator iter = treeSet.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
    
    public void nhapDanhSach() {
        int i = treeSet.size();
        while(true) {
            System.out.println("\tNhap thong tin hoc vien thu " + (i+1));
            HocVienDH hocVien = new HocVienDH();
            hocVien.nhapThongTin();
            if (hocVien.getHoTen().isEmpty()) return;
            treeSet.add(hocVien);
            i++;
        }
    }
    
    public HocVienDH timHocVienDHHocPhiCaoNhat() {
        HocVienDH hocVienHocPhiCaoNhat = Collections.max(treeSet, new Comparator<HocVienDH>(){
            @Override
            public int compare(HocVienDH o1, HocVienDH o2) {
                return Long.compare(o1.hocPhi(), o2.hocPhi());
            }
        });
        return hocVienHocPhiCaoNhat;
    }
    
    public void luuFile() {
        try {
            db.LuuFile(fileName, treeSet);
            System.out.println("Luu tap hop thanh cong!");
        } catch (Exception e) {
            System.out.println("Loi: " + e.toString());
        }
    }
    
    public void docFile() {
        try {
            treeSet = (TreeSet<HocVienDH>) db.docFile(fileName);
        } catch (Exception e) {
            System.out.println("Khong doc duoc File! " + e.toString());
        }
    }
}
