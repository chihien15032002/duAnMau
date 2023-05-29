/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo;

import dao.nhanVienDAO;
import helper.jdbcHelper;
import java.util.ArrayList;
import model.nhanVien;

/**
 *
 * @author Admin
 */
public class demo {
    public static void main(String[] args) {
        nhanVienDAO nv = new nhanVienDAO();
        ArrayList<nhanVien> list = (ArrayList<nhanVien>) nv.select();
        System.out.println(list.size());
      
       
    }
}
