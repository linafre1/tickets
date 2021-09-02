package com.example.demo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UnitTest {

    @Autowired
    ConcertRepository repository;



    @Test
    public void buyTickets(){
        Concert concert = repository.getConcertById(1);
        concert.buyTicket(10);
        repository.updateConcertTicketsSold(concert);

        Concert concertFromDatabase = repository.getConcertById(1);
        Assert.assertEquals(10, concertFromDatabase.getTicketsSold());
    }
}
