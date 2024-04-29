package org.example.service;

import org.example.dao.CustomerDAO;
import org.example.dao.EvenDAO;
import org.example.dao.TicketDAO;
import org.example.models.Event;
import org.example.models.Ticket;
import org.example.utils.DatabaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TicketService implements ITicketService<Ticket>{
    private CustomerDAO customerDAO;
    private EvenDAO evenDAO;
    private TicketDAO ticketDAO;
    private Connection connection;
    public TicketService() throws SQLException {
        connection = new DatabaseManager().getConnection();
        ticketDAO = new TicketDAO(connection);
        evenDAO = new EvenDAO(connection);
        customerDAO= new CustomerDAO(connection);
    }
    public boolean BuyATicket(Ticket ticket) {
        try {
            Event event = evenDAO.get(ticket.getIdEvent());
            if (event.getTicketsSoldNumber()> ticket.getPurchasedTicketCount()){
                return ticketDAO.save(ticket);
            } else {
                System.out.println("Il n'y a plus de places disponibles !");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }



    @Override
    public boolean modifyById(Ticket ticket) {
        try {
            return evenDAO.updateTicketSoldNumber(ticket);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public Ticket getById(int id) {
        try {
            return ticketDAO.get(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Ticket> getAll(int id) {
        return null;
    }

}





