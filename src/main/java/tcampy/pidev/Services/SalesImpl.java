package tcampy.pidev.Services;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tcampy.pidev.Entity.Sales;
import tcampy.pidev.Repository.ProductRepository;
import tcampy.pidev.Repository.SalesRepository;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
    public class SalesImpl implements ISalesService {

    @Autowired
    private SalesRepository salesRepository;
//        @Autowired
//    private MailService mailService;
    @Autowired
    ProductRepository productRepo;
        @Override
        public Sales updateVente(Sales sales) {return salesRepository.save(sales);}
    @Override
    public Sales addVente(Sales sales) {return salesRepository.save(sales);}
    @Override
    public void deleteSalesById(Long idSales) {salesRepository.deleteById(idSales);}
        @Override
        public Sales getSalesById(Long idSales) {return salesRepository.findById(idSales).orElse(null);}
        @Override
        public List<Sales> getAllSales() {return salesRepository.findAll();}
//        @Override
//        public List<Sales> getSalesByDate(Date date) {
//            return salesRepository.findBySaleDate(date);}
   // @SneakyThrows
//    @Override
//    @Transactional
//    public Sales sale(long idUser, long idProduct, Sales sale)  {
//       // User u = userRepo.findById(idUser).orElse(null);
////        Product product = productRepo.retrieveProduct(idProduct);
////
////        //sale.setUser(u);
////        sale.setProduct(product);
////        sale.setPrice(sale.getQuantity() * product.getPriceSale());
////        mailService.sendEmailSale(idUser,idProduct);
////        salesRepository.save(sale);
////        product.setQuantity(product.getQuantity()-sale.getQuantity());
////        return sale;
//        return  null ;
//    }

}
