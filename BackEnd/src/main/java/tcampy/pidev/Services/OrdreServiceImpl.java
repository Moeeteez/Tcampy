package tcampy.pidev.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;
import tcampy.pidev.Entity.*;
import tcampy.pidev.Repository.CommandLineRepository;
import tcampy.pidev.Repository.OrdreRepository;
import tcampy.pidev.Repository.ProductRepository;
import tcampy.pidev.Repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class OrdreServiceImpl  implements  IOrdreService{

    private  static final String ORDER_PLACED ="Placed" ;
    @Autowired
    private OrdreRepository ordreRepository ;
    public OrdreServiceImpl(OrdreRepository OrdreRepository,
                            ProductRepository productRepository) {
        this.ordreRepository = OrdreRepository;
        this.productRepository = productRepository;
    }
    @Override
        public List<Order> getAllOrders() {return this.ordreRepository.findAll();}
        @Override
        public void update(Order order) {
            this.ordreRepository.save(order);
        }

    @Override
    public Order getOrderById(int id) {{return ordreRepository.findById(id).orElse(null);}}

    @Override
    public Order create(Order order) {return this.ordreRepository.save(order);}

    @Override
    public void deleteOrderById(int Id) {ordreRepository.deleteById(Id);}

    @Override
    public void assignProductToOrder(int orderId, long productId, int quantity) {

    }

    @Autowired
    private OrdreRepository orderRepository;
    @Autowired
    private UserRepository userRepository ;

    @Autowired
    private CommandLineRepository commandLineRepository;
    private final ProductRepository productRepository;


//    @Override
//    public void assignProductToOrder(int orderId, long productId , int quantity) {
//
//        Order order = orderRepository.findById(orderId).orElse(null);
//
//        Product product = productRepository.findById(productId).orElse(null);
//
//        CommandLine commandLine = new CommandLine();
//        commandLine.setQuantityProds(quantity);
//        CommandLineKey pk = new CommandLineKey();
//        pk.setOrdre(order);
//        pk.setProduct(product);
//        commandLine.setPk(pk);
//
//
//        order.getCommandLines().add(commandLine);
//
//
//        orderRepository.save(order);
//        commandLineRepository.save(commandLine);
//    }

    public void placeOrder (OrderInput orderInput){
        List<OrderProductQuantity>productQuantityList = orderInput.getOrderProductQuantityList();
        for (OrderProductQuantity o : productQuantityList) {
            User user = new User("moeeteez","moetez","hammadi","moet1544");
            Product product = productRepository.findById(Long.valueOf(o.getProductId())).get() ;
//            Order order = new Order(
//                    orderInput.getFullName(),
//                    orderInput.getFullAddress(),
//                    orderInput.getContactNumber(),
//                    orderInput.getAlternateContactNumber(),
//                    ORDER_PLACED,
//                    product.getPriceSale()*o.getQuantity() ,
//                    product,
//                    user
//
//            ) ;
//            ordreRepository.save(order) ;
        }
    }



}












//    private final ICommandLine commandLineService;
//    @Autowired
//    public OrdreServiceImpl(ICommandLine commandLineService) {
//        this.commandLineService = commandLineService;
//    }

//    @Override
//    public Order getOrderById(int id) {return ordreRepository.findById(id).orElse(null);}
//    @Override
//    public Order updateOrder(Order order) {{return ordreRepository.save(order);}}
//    @Override
//    public void deleteOrderById(int Id) {{ordreRepository.deleteById(Id);}}
//    @Override
//    public List<Order> getAllOrders() {{return ordreRepository.findAll();}}


//    public CommandLine createCommandLine(CommandLineDTO commandLineDto, Order order) {
//        // Vérification de l'existence du produit
//        Product product = productService.retrieveProductById(commandLineDto.getProductId());
//
//        // Mise à jour de la quantité de produit
//        product.setQuantity(product.getQuantity() - commandLineDto.getQuantity());
//        productService.updateProduct(product);
//
//        // Création de la ligne de commande
//        CommandLine commandLine = new CommandLine();
//        commandLine.setQuantityProds(commandLineDto.getQuantity());
//        commandLine.setProduct(product);
//        commandLine.setOrder(order);
//
//        order.getCommandLines().add(commandLine);
//        order.setTotalPrice(order.getTotalPrice() + commandLineDto.getPrice() * commandLineDto.getQuantity());
//        order.setTotalquantity(order.getTotalquantity() + commandLineDto.getQuantity());
//
//        commandLine = commandLineRepository.save(commandLine);
//        order = ordreRepository.save(order);
//
//        return commandLine;
//    }







