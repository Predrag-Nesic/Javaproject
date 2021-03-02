/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Timestamp;

/**
 *
 * @author dusan
 */
public class Message extends Model {
    protected String table = "messages";

    private String message;
    private Timestamp time;
    private int user_id;
    
    public User getKorisnik() {
        User u = new User();
        u = (User)u.find((int)user_id);
        return u;
    }

    public Message() { }

    public Message(String message, Timestamp time, int user_id) {
        this.message = message;
        this.time = time;
        this.user_id = user_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
    
//    public Message(String poruka, int korisnik_id) {
//        this.poruka = poruka;
//        this.korisnik_id = korisnik_id;
//    }
//
//    public String getPoruka() {
//        return poruka;
//    }
//
//    public void setPoruka(String poruka) {
//        this.poruka = poruka;
//    }
//
//    public Timestamp getVreme() {
//        return vreme;
//    }
//
//    public void setVreme(Timestamp vreme) {
//        this.vreme = vreme;
//    }
//
//    public int getKorisnik_id() {
//        return korisnik_id;
//    }
//
//    public void setKorisnik_id(int korisnik_id) {
//        this.korisnik_id = korisnik_id;
//    }
//

    @Override
    public String toString() {
        User u = new User();
        u = (User)u.find((int)user_id);
        return id + ". " + u.getFirst_name() + ", " + message + " " + time;
    }
}
