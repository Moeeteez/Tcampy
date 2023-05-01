package tcampy.pidev.Controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tcampy.pidev.DTO.CommandDTO;
import tcampy.pidev.DTO.CommandLineDto;
import tcampy.pidev.Entity.CommandLine;
import tcampy.pidev.Entity.Order;
import tcampy.pidev.Entity.OrderInput;
import tcampy.pidev.Entity.Product;
import tcampy.pidev.Services.EmailSender;
import tcampy.pidev.Services.ICommandLine;
import tcampy.pidev.Services.IOrdreService;
import tcampy.pidev.Services.IProductService;
import tcampy.pidev.exception.ResourceNotFoundException;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@AllArgsConstructor

@RestController
@Slf4j
@RequestMapping("/orders")
@CrossOrigin(origins = "*")
public class OrderController {
    @Autowired
    IOrdreService iOrdreService;
    IProductService productService;
    IOrdreService orderService;
    ICommandLine commandLine;

//    @GetMapping("/getAll")
//    @ResponseStatus(HttpStatus.OK)
//    public @NotNull Iterable<Order> list() {
//        return this.orderService.getAllOrders();
//    }
//    @PostMapping("/add")
//    public void create(@RequestBody OrderForm form) {
//        List<CommandLineDto> formDtos = form.getCommandLine();
//      //  validateProductsExistence(formDtos);
//        Order order = new Order();
//        //order.setStatus(OrderStatus.PAID.name());
//        order = this.orderService.create(order);
////
//        List<CommandLine> CommandLineDto = new ArrayList<>();
//        for (CommandLineDto dto : formDtos) {
//            CommandLineDto.add(commandLine.create(new CommandLine(order, productService.retrieveProductById(dto
//                    .getProduct()
//                    .getIdProduct()), dto.getQuantity())));
//        }
//        order.setCommandLines(CommandLineDto);
//
//        this.orderService.update(order);

//        String uri = ServletUriComponentsBuilder
//                .fromCurrentServletMapping()
//                .path("/orders/{id}")
//                .buildAndExpand(order.getIdOrder())
//                .toString();
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Location", uri);
//
//        return new ResponseEntity<>(order, headers, HttpStatus.CREATED);


//    private void validateProductsExistence(List<CommandLineDto> commandLineDtos) {
//        List<CommandLineDto> list = commandLineDtos
//                .stream()
//                .filter(op -> Objects.isNull(productService.retrieveProductById(op
//                        .getProduct()
//                        .getIdProduct())))
//                .collect(Collectors.toList());
//
//        if (!CollectionUtils.isEmpty(list)) {
//            new ResourceNotFoundException("Product not found");
//        }
//    }
//    public static class OrderForm {
//
//        private List<CommandLineDto> commandLineDtos;
//
//        public List<CommandLineDto> getCommandLine() {
//            return commandLineDtos;
//        }
//
//        public void setProductOrders(List<CommandLineDto> commandLineDtos)
//        {
//            this.commandLineDtos = commandLineDtos;
//        }
//    }
//

    @PostMapping("/placeOrder")
    public void AddOrder(@RequestBody OrderInput orderInput) {
         iOrdreService.placeOrder(orderInput);
    }


//    @GetMapping("/get/{id}")
//    Order retriveOrdre(@PathVariable int id) {
//        return iOrdreService.getOrderById(id);
//    }
//
//    @PostMapping
//    public ResponseEntity<Order> createOrder(@RequestBody List<CommandLineDTO> commandLineDtos) {
//        Order order = iOrdreService.createOrder(commandLineDtos);
//        return ResponseEntity.ok().body(order);
//    }
    private final EmailSender emailSender ;


    @PutMapping("/{idO}/{idP}/{Q}")
    public ResponseEntity<Void> assignProductsToOrder(@PathVariable("idO") int idOrder,
                                                      @PathVariable ("idP") long idProduct,
                                                      @PathVariable("Q") int quantity) {
        orderService.assignProductToOrder(idOrder, idProduct, quantity);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getAll")
    List<Order> retriveAllProduct() {
        return orderService.getAllOrders();
    }


    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestParam String to, @RequestParam String email) {
        try {
            emailSender.send(to, email);
            return ResponseEntity.ok("Email sent successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send email: " + e.getMessage());
        }
    }
}
