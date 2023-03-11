package tcampy.pidev.Services;

import tcampy.pidev.Entity.CommandLine;


public interface ICommandLine {

        void calculateLoyaltyPointsEarned(CommandLine commandLine);
        void updateCommandLine(long id);

}
