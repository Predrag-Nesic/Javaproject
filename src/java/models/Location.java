/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Predrag
 */
public class Location extends Model {

    protected String table = "locations";

    private String name;
    private String address;
    private Long gfloor_capacity;
    private Long balcony_capacity;

    public Location() {

    }

    public Location(String name, String address, Long gfloor_capacity, Long balcony_capacity) {
        this.name = name;
        this.address = address;
        this.gfloor_capacity = gfloor_capacity;
        this.balcony_capacity = balcony_capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getGfloor_capacity() {
        return gfloor_capacity;
    }

    public void setGfloor_capacity(Long gfloor_capacity) {
        this.gfloor_capacity = gfloor_capacity;
    }

    public Long getBalcony_capacity() {
        return balcony_capacity;
    }

    public void setBalcony_capacity(Long balcony_capacity) {
        this.balcony_capacity = balcony_capacity;
    }

}
