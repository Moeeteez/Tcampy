package tcampy.pidev.Services;
import org.springframework.validation.annotation.Validated;
import tcampy.pidev.Entity.CommandLine;
import tcampy.pidev.Entity.CommandLineKey;
import tcampy.pidev.Entity.Offer;
import tcampy.pidev.Entity.Order;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated

public interface ICommandLine {

     //   void calculateLoyaltyPointsEarned(CommandLine commandLine);
     public CommandLine updateCommandLine(CommandLine commandLine) ;
       public CommandLine addCommandLine(CommandLine commandLine) ;
   public CommandLine getCommandLineById(CommandLineKey id) ;
    public List<CommandLine> getAllCommandLines();
 public void deleteCommandLine(CommandLineKey id) ;
//    public CommandLine createCommandLine(CommandLineDTO commandLineDto, Order order);
//    public void deleteCommandLineByIds(long productId, int orderId) ;

   // CommandLine create(@NotNull(message = "The products for order cannot be null.") @Valid CommandLine commandLine);

}
