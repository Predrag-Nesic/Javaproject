package models;

public class Event extends Model {
    
    protected String table = "event";
    
    private String name;
    private String date;
    private Long gfloor_tickets;
    private Long balcony_tickets;
    private String location;
    
    public Event() {
        
    }

    public Event(String name, String date, Long gfloor_tickets, Long balcony_tickets, String location) {
        this.name = name;
        this.date = date;
        this.gfloor_tickets = gfloor_tickets;
        this.balcony_tickets = balcony_tickets;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getGfloor_tickets() {
        return gfloor_tickets;
    }

    public void setGfloor_tickets(Long gfloor_tickets) {
        this.gfloor_tickets = gfloor_tickets;
    }

    public Long getBalcony_tickets() {
        return balcony_tickets;
    }

    public void setBalcony_tickets(Long balcony_tickets) {
        this.balcony_tickets = balcony_tickets;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
