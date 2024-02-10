package org.example.app;

import org.example.Enums.DayOfWeek;
import org.example.Enums.TicketExportFormat;
import org.example.Exporter.ExportFactory;
import org.example.Exporter.IExportOrder;

import java.util.ArrayList;

public class Order {
    private int orderNr;
    private boolean isStudentOrder;
    private ArrayList<MovieTicket> tickets;
    private int totalFreeTickets;


    public Order(int orderNr, boolean isStudentOrder) {
        this.orderNr = orderNr;
        this.isStudentOrder = isStudentOrder;
        tickets = new ArrayList<>();
    }

    public int getOrderNr() {
        return orderNr;
    }

    public void addSeatReservation(MovieTicket ticket) {
        tickets.add(ticket);
    }

    public double calculatePrice() {
        calculateBasePrice();
        applyDiscount();

        return calculateTotalPrice();
    }

    private void calculateBasePrice() {
        for (MovieTicket ticket : tickets) {
            ticket.setPrice(isStudentOrder, ticket.isPremiumTicket());
        }
    }

    private double calculateTotalPrice() {
        double totalPrice = 0.0;
        for (MovieTicket ticket : tickets) {
            totalPrice += ticket.getPrice();
        }

        if (!isStudentOrder && !isWeekDay() && tickets.size() > 5) {
            totalPrice *= 0.9;
        }

        return totalPrice;
    }

    private void applyDiscount() {
        if (isStudentOrder || isWeekDay()) {
            for (int i = 1; i <= tickets.size(); i++) {
                if (i % 2 == 0) {
                    tickets.get(i-1).setPriceForFree();
                    i++;
                }
            }
        }
    }

    private boolean isWeekDay() {
        for (MovieTicket ticket : tickets) {
            return ticket.getDayOfMovie().equals(DayOfWeek.MONDAY) ||
                    ticket.getDayOfMovie().equals(DayOfWeek.TUESDAY) ||
                    ticket.getDayOfMovie().equals(DayOfWeek.WEDNESDAY) ||
                    ticket.getDayOfMovie().equals(DayOfWeek.THURSDAY);
        }
        return false;
    }

    public void export(TicketExportFormat exportFormat) {
        IExportOrder exporter = ExportFactory.getExporter(String.valueOf(exportFormat));
        exporter.exportOrder(this, exportFormat);
    }
}