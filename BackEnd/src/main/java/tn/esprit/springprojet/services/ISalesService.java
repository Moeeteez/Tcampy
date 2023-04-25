package tn.esprit.springprojet.services;

import tn.esprit.springprojet.entities.Product;
import tn.esprit.springprojet.entities.Sales;

import java.util.Date;
import java.util.List;

public interface ISalesService {

        Sales addVente(Sales sales);
        Sales updateVente(Sales sales);
        void deleteSalesById(Long idSales);
        Sales getSalesById(Long idSales);
        List<Sales> getAllSales();
        List<Sales> getSalesByProduct(Product product);
        List<Sales> getSalesByDate(Date date);
       // List<Sales> getSalesByClient(Client client);
     //  double getTotalPrixVentesByClient(Client client);
      //  int getNombreVentesByClient(Client client);
        int getNombreSalesByProduct(Product product);
        double getTotalPrixVentesByProduct(Product product);
     Sales sale(long idUser, long idProduct, Sales sale) ;
    }