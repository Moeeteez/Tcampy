package tcampy.pidev.Services;


import tcampy.pidev.DTO.ProductSaleDTO;
import tcampy.pidev.Entity.Sales;

import java.util.Date;
import java.util.List;

public interface ISalesService {

        Sales addVente(Sales sales);
        Sales updateVente(Sales sales);
        void deleteSalesById(Long idSales);
        Sales getSalesById(Long idSales);
        List<Sales> getAllSales();

        public List<ProductSaleDTO> getTopSellingProducts(int n) ;
        //   List<Sales> getSalesByDate(Date date);
       // List<Sales> getSalesByClient(Client client);
     //  double getTotalPrixVentesByClient(Client client);
      //  int getNombreVentesByClient(Client client);
      //  int getNombreSalesByProduct(Product product);
       // double getTotalPrixVentesByProduct(Product product);
    }