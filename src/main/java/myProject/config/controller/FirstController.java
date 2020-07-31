package myProject.config.controller;
import myProject.config.Calculate;
import myProject.config.MyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import sun.jvm.hotspot.ui.EditableAtEndDocument;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FirstController {
    @Autowired
    private MyRepository repo;
    @Value("0")
    private int id;

    @GetMapping("/ProjectRaspberry_war/test")
    public String test(@RequestParam String Cpu) {

        System.out.println(Cpu);
        return "test.html";

    }

    @GetMapping("/")
    public String start(Model model) {
        Iterable<MyData> dataList;
        List<MyData> data= new ArrayList<>();;
        if(id<=60) {
            dataList = repo.findAll();
            dataList.forEach(data::add);
        }
        else
            data=Calculate.set(id,repo);
        model.addAttribute("mass", Calculate.calcALL(data));
        return "startPage";

    }

    @GetMapping("/save")
    public String greeting(@RequestParam float Cpu, @RequestParam float mem, @RequestParam float memD,@RequestParam float freemem, @RequestParam int myID,@RequestParam String date, Model model) {
        MyData data = new MyData();
        data.setAll(Cpu,mem,memD,freemem,myID,date);
        model.addAttribute("data",data);
        model.addAttribute("d",id);
        repo.save(data);
        id++;



        return "save";
    }
    @GetMapping("/cpu")
    public String getCPU(Model model) {
        Iterable<MyData> dataList;
        List<MyData> data= new ArrayList<>();;
        if(id<=60) {
            dataList = repo.findAll();
            dataList.forEach(data::add);
        }
        else
            data=Calculate.set(id,repo);
      /*  Iterable<MyData> dataList =repo.findAll();
        List<MyData> data = new ArrayList<>();
        dataList.forEach(data::add);*/
        model.addAttribute("mass", Calculate.calcCPU(data));
        model.addAttribute("avg","AVG="+Calculate.calcAVGCPU(data)+"%");
        return "statisticCPU";
    }
    @GetMapping("/ram")
    public String getRAM(Model model) {
        Iterable<MyData> dataList;
        List<MyData> data= new ArrayList<>();;
        if(id<=60) {
            dataList = repo.findAll();
            dataList.forEach(data::add);
        }
        else
            data=Calculate.set(id,repo);
        model.addAttribute("mass", Calculate.calcRAM(data));
        model.addAttribute("avg","AVG="+Calculate.calcAVGRAM(data)+"%");
        return "statisticRAM";
    }
    @GetMapping("/disc")
    public String getDISC(Model model) {
        Iterable<MyData> dataList;
        List<MyData> data= new ArrayList<>();;
        if(id<=60) {
            dataList = repo.findAll();
            dataList.forEach(data::add);
        }
        else
            data=Calculate.set(id,repo);
        model.addAttribute("mass", Calculate.calcDISCLoad(data));
        model.addAttribute("avg","AVG="+Calculate.calcAVGDISC(data)+"%");
        model.addAttribute("mass1", Calculate.calcDISCFreeSpace(data));
        return "statisticDISC";
    }

}
