package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class ConcertController {



    @Autowired
    ConcertRepository concertRepository;

    @GetMapping("/")
    public String allConcerts(Model model, HttpSession session)  {
        model.addAttribute("concertList", concertRepository.getAll());
        session.setAttribute("wasSuccessfulPurchase", null);

        return "allEvents";
    }

    @GetMapping("/event")
    public String detailPage(HttpSession session, Model model, @RequestParam int eventId)    {
        model.addAttribute("currentConcert", concertRepository.getConcertById(eventId));
        session.setAttribute("concert", concertRepository.getConcertById(eventId));

        return "masterDetailConcert";
    }


    @GetMapping("/shoppingcart")
    public String displayToShoppingCart(HttpSession session){

        return ("/shoppingCart");
    }

    @PostMapping ("/shoppingcart")
    public String addToShoppingCart(HttpSession session, Model model, @RequestParam int ticketQuantity){
        HashMap<Concert, Integer> shoppingCartList = (HashMap<Concert, Integer>)session.getAttribute("shoppingCart");
        if(shoppingCartList == null) {
            shoppingCartList = new HashMap<>();
        }

        session.setAttribute("wasSuccessfulPurchase", false);
        Concert concert = (Concert) session.getAttribute("concert");

        if(concert.isNotFull(ticketQuantity)) {
            concert.buyTicket(ticketQuantity);
            concertRepository.updateConcertTicketsSold(concert);
            session.setAttribute("wasSuccessfulPurchase", true);
            shoppingCartList.put(concert, ticketQuantity);
            session.setAttribute("buyAlert", "Biljetter tillagda i kundkorgen.");
        } else  {
            int ticketsRemaining = concert.getArena().getArenaCapacity() - concert.getTicketsSold();
            session.setAttribute("buyAlert", "För stort antal. Det finns bara " + ticketsRemaining + " biljetter kvar...");
        }

        session.setAttribute("itemsInCart", shoppingCartList.size());
        session.setAttribute("shoppingCart", shoppingCartList);

        //need for redirect
        return "redirect:/event?eventId=" + concert.getId();
    }

    @GetMapping("/sort/{sort}")
    public String sorting(Model model, @PathVariable String sort) {
        if (sort.equalsIgnoreCase("Pris"))   {
            model.addAttribute("concertList", concertRepository.getConcertsByPrice());
        }
        else if (sort.equalsIgnoreCase("Artist"))    {
            model.addAttribute("concertList", concertRepository.getConcertsByArtistSafe());
        }

        return "allEvents";
    }

    @GetMapping("/filter/{filter}")
    public String filtering(@PathVariable String filter, Model model) {
        switch (filter) {
            case "Goteborg":
                model.addAttribute("concertList", concertRepository.getConcertsByCity("Göteborg"));
                break;
            case "Stockholm":
                model.addAttribute("concertList", concertRepository.getConcertsByCity("Stockholm"));
                break;
            case "Malmo":
                model.addAttribute("concertList", concertRepository.getConcertsByCity("Malmö"));
                break;
            case "Orebro":
                model.addAttribute("concertList", concertRepository.getConcertsByCity("Örebro"));
                break;
        }

        return "allEvents";
    }
}
