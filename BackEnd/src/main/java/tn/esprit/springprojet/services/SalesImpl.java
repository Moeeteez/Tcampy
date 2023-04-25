package tn.esprit.springprojet.services;


import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.springprojet.entities.Product;
import tn.esprit.springprojet.entities.Sales;
import tn.esprit.springprojet.repositories.ProductRepository;
import tn.esprit.springprojet.repositories.SalesRepository;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
    public class SalesImpl implements ISalesService {

        @Autowired
        private SalesRepository salesRepository;
    private MailService mailService;
    @Autowired
    IProductService productRepo;

        @Override
        public Sales addVente(Sales sales) {
            return salesRepository.save(sales);
        }

        @Override
        public Sales updateVente(Sales sales) {
            return salesRepository.save(sales);
        }

        @Override
        public void deleteSalesById(Long idSales) {
            salesRepository.deleteById(idSales);
        }

        @Override
        public Sales getSalesById(Long idSales) {
            return salesRepository.findById(idSales).orElse(null);
        }

        @Override
        public List<Sales> getAllSales() {
            return salesRepository.findAll();
        }

        @Override
        public List<Sales> getSalesByProduct(Product product) {
            return salesRepository.findByProduct(product);
        }

        @Override
        public List<Sales> getSalesByDate(Date date) {
            return salesRepository.findBySaleDate(date);
        }

        @Override
        public int getNombreSalesByProduct(Product product) {
            return salesRepository.countByProduct(product);
        }

        @Override
        public double getTotalPrixVentesByProduct(Product product) {
            return salesRepository.sumPrixByProduct(product);
        }


    @SneakyThrows
    @Override
    @Transactional
    public Sales sale(long idUser, long idProduct, Sales sale)  {
       // User u = userRepo.findById(idUser).orElse(null);
        Product product = productRepo.retrieveProduct(idProduct);

        //sale.setUser(u);
        sale.setProduct(product);
        sale.setPrice(sale.getQuantity() * product.getPriceSale());
        mailService.sendEmailSale(idUser,idProduct);
        salesRepository.save(sale);
        product.setQuantity(product.getQuantity()-sale.getQuantity());
        return sale;
    }

}
