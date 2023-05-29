/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import helper.jdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.nhanVien;

/**
 *
 * @author Sieu Nhan Bay
 */
public class nhanVienDAO {
    
public void insert(nhanVien model){
        String sql="INSERT INTO NhanVien (MaNV, MatKhau, HoTen, VaiTro) VALUES (?, ?, ?, ?)";
         jdbcHelper.executeUpdate(sql, 
                model.getMaNV(), 
                model.getMatKhau(), 
                model.getHoTen(), 
                model.isVaiTro());
    }
    
    public void update(nhanVien model){
        String sql="UPDATE NhanVien SET MatKhau=?, HoTen=?, VaiTro=? WHERE MaNV=?";
        jdbcHelper.executeUpdate(sql, 
                model.getMatKhau(), 
                model.getHoTen(), 
                model.isVaiTro(),
                model.getMaNV());
    }
    
    public void delete(String MaNV){
        String sql="DELETE FROM NhanVien WHERE MaNV=?";
        jdbcHelper.executeUpdate(sql, MaNV);
    }
    
    public List<nhanVien> select(){
        String sql="SELECT * FROM NhanVien";
        return select(sql);
    }
    
    public nhanVien findById(String manv){
        String sql="SELECT * FROM NhanVien WHERE MaNV=?";
        List<nhanVien> list = select(sql, manv);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    private List<nhanVien> select(String sql, Object...args){
        List<nhanVien> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbcHelper.executeQuery(sql, args);
                while(rs.next()){
                    nhanVien model=readFromResultSet(rs);
                    list.add(model);
                }
            } 
            finally{
                rs.getStatement().getConnection().close();
            }
        } 
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
    
    private nhanVien readFromResultSet(ResultSet rs) throws SQLException{
       nhanVien model=new nhanVien();
        model.setMaNV(rs.getString("MaNV"));
        model.setMatKhau(rs.getString("MatKhau"));
        model.setHoTen(rs.getString("HoTen"));
        model.setVaiTro(rs.getBoolean("VaiTro"));
        return model;
    }
}
