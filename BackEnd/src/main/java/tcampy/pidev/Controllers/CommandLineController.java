//package tcampy.pidev.Controllers;
//
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import tcampy.pidev.Entity.CategoryProduct;
//import tcampy.pidev.Entity.CommandLine;
//import tcampy.pidev.Entity.CommandLineKey;
//import tcampy.pidev.Services.ICategoryService;
//import tcampy.pidev.Services.ICommandLine;
//
//import java.util.List;
//
//@AllArgsConstructor
//
//@RestController
//@Slf4j
//@RequestMapping("CommandLine")
//public class CommandLineController {
//    @Autowired
//    ICommandLine icommandLine  ;
////    @PostMapping("/add")
////    @ResponseBody
////    public CommandLine AddCommandLine(@RequestBody CommandLine commandLine) {
////        return icommandLine.addCommandLine (commandLine);}
//        @GetMapping("/getAll")
//        public List<CommandLine> getAllCommandLines() {
//            return icommandLine.getAllCommandLines();
//        }
//        @GetMapping("/get/{id}")
//        public CommandLine getCommandLineById(@PathVariable("id") CommandLineKey id) {
//            return icommandLine.getCommandLineById(id);
//        }
//        @DeleteMapping("/delete/{id}/{id2}")
//        public void deleteCommandLine(@PathVariable("id") Long CommandLine,@PathVariable("id2") int CommandLine2) {
//            icommandLine.deleteCommandLineByIds(CommandLine,CommandLine2);
//        }
//    }
//
