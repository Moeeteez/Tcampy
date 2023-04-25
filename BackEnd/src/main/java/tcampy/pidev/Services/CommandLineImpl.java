package tcampy.pidev.Services;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tcampy.pidev.Entity.CommandLine;
import tcampy.pidev.Entity.CommandLineKey;
import tcampy.pidev.Entity.Order;
import tcampy.pidev.Entity.Product;
import tcampy.pidev.Repository.CommandLineRepository;
import tcampy.pidev.Repository.OrdreRepository;
import tcampy.pidev.Repository.ProductRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
@Transactional

public class CommandLineImpl  implements ICommandLine {
    @Autowired
    private final OrdreRepository ordreRepository;
    @Autowired
    private final CommandLineRepository commandLineRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    private IProductService productService;
    @Autowired
    private IOrdreService orderService;
//@Override
//    public CommandLine createCommandLine(CommandLineDTO commandLineDto, Order order) {
//        // Vérification de l'existence du produit
//        Product product = productService.retrieveProductById(commandLineDto.getProductId());
//        // Mise à jour de la quantité de produit
//        product.setQuantity(product.getQuantity() - commandLineDto.getQuantity());
//        productService.updateProduct(product);
//        // Création de la ligne de commande
//        CommandLineKey commandLineKey = new CommandLineKey(product.getIdProduct(), order.getIdOrder());
//        CommandLine commandLine = new CommandLine();
//        commandLine.setId(commandLineKey);
//        commandLine.setQuantityProds(commandLineDto.getQuantity());
//        commandLine.setProduct(product);
//        commandLine.setOrder(order);
//        commandLine = commandLineRepository.save(commandLine);
//        return commandLine;
//    }
//    public CommandLine createCommandLine(CommandLineDTO commandLineDto, Order order) {
//        // Vérification de l'existence du produit
//        Product product = productService.retrieveProductById(commandLineDto.getProductId());
//        // Mise à jour de la quantité de produit
//        product.setQuantity(product.getQuantity() - commandLineDto.getQuantity());
//        productService.updateProduct(product);
//        // Création de la ligne de commande
//        CommandLine commandLine = new CommandLine();
//        commandLine.setQuantityProds(commandLineDto.getQuantity());
//        commandLine.setProduct(product);
//        commandLine.setOrder(order);
//        commandLine = commandLineRepository.save(commandLine);
//        return commandLine;
//    }


//    public void deleteCommandLineByIds(long productId, int orderId) {
//        CommandLineKey id = new CommandLineKey();
//        id.setIdProduct(productId);
//        id.setIdOrder(orderId);
//        CommandLine commandLine = commandLineRepository.findById(id).orElse(null);
//        Product product = commandLine.getProduct();
//        product.setQuantity(product.getQuantity() + commandLine.getQuantityProds());
//        productService.updateProduct(product);
//        commandLineRepository.delete(commandLine);
//    }
//    public List<CommandLine> getCommandLinesByOrderId(int orderId) {
//        Order order = orderService.getOrderById(orderId);
//        return order.getCommandLines();
//    }

    @Override
    public CommandLine getCommandLineById(CommandLineKey id) {
        return commandLineRepository.findById(id).orElse(null);
    }

//    public void calculateLoyaltyPointsEarned(CommandLine commandLine) {
//        int loyaltyPointsEarned = 0;
//        double totalCmd = commandLine.getTotalCmd();
//        if (totalCmd >= 100 && totalCmd < 200) {
//            loyaltyPointsEarned = 10;
//        } else if (totalCmd >= 200 && totalCmd < 500) {
//            loyaltyPointsEarned = 30;
//        } else if (totalCmd >= 500) {
//            loyaltyPointsEarned = 50;
//        }
//        commandLine.setLoyaltyPointsEarned(loyaltyPointsEarned);
//    }
//

    //
    @Override
    public CommandLine updateCommandLine(CommandLine commandLine) {
        return commandLineRepository.save(commandLine);
    }

    @Override
    public List<CommandLine> getAllCommandLines() {
        return commandLineRepository.findAll();
    }

    @Override
    public void deleteCommandLine(CommandLineKey id) {
        {
            commandLineRepository.deleteById(id);
        }
    }


    @Override
    public CommandLine addCommandLine(CommandLine commandLine) {
        return this.commandLineRepository.save(commandLine);
    }

//    @Override
//    public String AssigneProductToCommandLine(CommandLine commandLine) {
//        CommandLine cmdline = new CommandLine();
//        cmdline.setQuantityProds(commandLine.getQuantityProds());
//        Product product = productRepository.findById(cmdline.getProduct().getIdProduct()).orElse(null);
//        if (product == null) {
//            return "Product not found.";
//        } else {
//            cmdline.set(product);
//            lineCmdRepository.save(lineCmd);
//            return "LineCmd created and product assigned successfully."; } }


}
