package com.example.demo;

public class Concert implements Event, Comparable<Concert>{
    private Integer id;
    private String artist;
    private String date;
    private int ticketPrice;
    private Arena arena;
    private String concertDescription;
    private int ticketsSold;
    private String pictureAddress;

    public Concert(Integer id, String artist, String date, int ticketPrice, Arena arena, String concertDescription, int ticketsSold, String pictureAddress) {
        this.id = id;
        this.artist = artist;
        this.date = date;
        this.ticketPrice = ticketPrice;
        this.arena = arena;
        this.concertDescription = concertDescription;
        this.ticketsSold = ticketsSold;
        this.pictureAddress = pictureAddress;
    }

    public Concert() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Arena getArena() {
        return arena;
    }

    public void setArena(Arena arena) {
        this.arena = arena;
    }

    public void setConcertDescription(String concertDescription) {
        this.concertDescription = concertDescription;
    }

    public String getConcertDescription() {
        return concertDescription;
    }

    public int getTicketsSold() {
        return ticketsSold;
    }

    public void setTicketsSold(int ticketsSold) {
        this.ticketsSold = ticketsSold;
    }

    public String getPictureAddress() {
        return pictureAddress;
    }

    public void setPictureAddress(String pictureAddress) {
        this.pictureAddress = pictureAddress;
    }

    public boolean isNotFull(int tickets) {
        if( ticketsSold + tickets <= arena.getArenaCapacity()) {
            return true;
        }
    return false;
    }

    public void buyTicket(int tickets) {
      ticketsSold += tickets;
    }

    @Override
    public int compareTo(Concert concert) {
        if (this.artist.charAt(0) == concert.artist.charAt(0)) {
            return 0;
        } else if (this.artist.charAt(0) < concert.artist.charAt(0)) {
            return -1;
        }
        return 1;
    }

    @Override
    public String toString() {
        return "Concert{" +
                "concertId=" + id +
                ", artist='" + artist + '\'' +
                ", date='" + date + '\'' +
                ", ticketPrice=" + ticketPrice +
                ", arena=" + arena +
                ", concertDescription='" + concertDescription + '\'' +
                ", ticketsSold=" + ticketsSold +
                '}';
    }

    public int getFreeSpots() {
        return arena.getArenaCapacity() - ticketsSold;
    }


}
