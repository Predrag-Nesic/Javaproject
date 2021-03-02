package models;

public class Reservation extends Model {
    protected String table = "reservations";
    
    private String username;
    private String event_name;
    private Long gfloor_tickets;
    private Long balcony_tickets;

    public Reservation() {
        
    }
    
    public Reservation(String username, String event_name, Long gfloor_tickets, Long balcony_tickets) {
        this.username = username;
        this.event_name = event_name;
        this.gfloor_tickets = gfloor_tickets;
        this.balcony_tickets = balcony_tickets;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
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
}
