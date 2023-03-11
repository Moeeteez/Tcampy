package tcampy.pidev.Services;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tcampy.pidev.Entity.CommandLine;
import tcampy.pidev.Repository.CommandLineRepository;
@Service
@Slf4j
@AllArgsConstructor
public class CommandLineImpl  implements ICommandLine{

        @Autowired
        private final CommandLineRepository commandLineRepository;
        public void calculateLoyaltyPointsEarned(CommandLine commandLine) {
            int loyaltyPointsEarned = 0;
            double totalCmd = commandLine.getTotalCmd();
            if (totalCmd >= 100 && totalCmd < 200) {
                loyaltyPointsEarned = 10;
            } else if (totalCmd >= 200 && totalCmd < 500) {
                loyaltyPointsEarned = 30;
            } else if (totalCmd >= 500) {
                loyaltyPointsEarned = 50;
            }
            commandLine.setLoyaltyPointsEarned(loyaltyPointsEarned);
        }
        @Override
        public void updateCommandLine(long id) {
            CommandLine commandLine = commandLineRepository.findById(id).orElseThrow(() -> new RuntimeException("CommandLine not found"));
            calculateLoyaltyPointsEarned(commandLine);
            commandLineRepository.save(commandLine);
        }
}
