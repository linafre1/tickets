package com.example.demo;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class EventService {
/*
    @Autowired
    ConcertRepository concertRepository;

    public EventService() {
        this.concertRepository = new ConcertRepository();
    }

    public void addConcert(Concert concert) {
        concertRepository.addConcert(concert);
    }

    public List<Concert> sortByArtistName() {
        List<Concert> concertList = concertRepository.getConcerts();
        Collections.sort(concertList);
        return concertList;
    }

    public List<Concert> sortByPrice() {
        List<Concert> concertList = concertRepository.getConcerts();
        concertList.sort(Comparator.comparingInt(Concert::getTicketPrice));
        return concertList;
    }

    public List<Concert> getAllConcerts() {
        return concertRepository.getConcerts();
    }

    public Concert getConcertById(int eventId) {
        for (Concert c : concertRepository.getConcerts()){
            if (c.getId() == eventId) {
                return c;
            }
        }
        return null;
    }

    public List<Concert> getCityFilteredConcerts(String city) {
        List<Concert> filteredList = new ArrayList<>();
        for (Concert c : concertRepository.getConcerts()){
            if (c.getArena().getCity().equalsIgnoreCase(city)) {
                filteredList.add(c);
            }
        }
        return filteredList;
    }

    //Maybe break into two methods, one checking and one buying
    public boolean buyTickets(HttpSession session, HashMap<Concert, Integer> shoppingCartList, int tickets) {
        Concert tempConcert = (Concert)session.getAttribute("concert");
        if(!tempConcert.isNotFull(tickets)) {
            session.setAttribute("buyAlert", "Misslyckades! Du försökte köpa " + tickets + " biljetter men det finns bara " + tempConcert.getFreeSpots() + " biljetter kvar.");
            return false;
        }
        tempConcert.buyTicket(tickets);
        Integer tempQuantity = shoppingCartList.get(session.getAttribute("concert"));
            if(tempQuantity == null){
                shoppingCartList.put((Concert)session.getAttribute("concert"), tickets);
            } else {
                shoppingCartList.put((Concert)session.getAttribute("concert"), tickets + tempQuantity);
            }
        session.setAttribute("buyAlert", "Lyckades! Du lade till " + tickets + " biljetter till din kundkorg.");
            return true;
    }

*/
}
