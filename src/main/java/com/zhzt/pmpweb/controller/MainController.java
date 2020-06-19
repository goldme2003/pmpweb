package com.zhzt.pmpweb.controller;


import com.zhzt.pmpweb.entity.*;
import com.zhzt.pmpweb.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/pmpweb")
public class MainController {

    @Autowired
    private ProcessGroupNameRepo processGroupNameRepo;
    @Autowired
    private TKnowledgeNameRepo tKnowledgeNameRepo;
    @Autowired
    private TProcessNameRepo tProcessNameRepo;
    @Autowired
    private TToolCategRepo tToolCategRepo;
    @Autowired
    private TToolRepo tToolRepo;
    @Autowired
    private TIttoCategRepo tIttoCategRepo;
    @Autowired
    private TIttoRepo tIttoRepo;

    private ProcessGroupName tempPgName;
    private TKnowledgeName tempKsName;
    private TProcessName tempPnName;
    private TToolCateg temptcName;
    private TTool temptoolName;
    private TIttoItemCateg tempIttoCategName;
    private TIttoItem tempIttoName;

    /*
    * swagger
    * */
    @RequestMapping(value = "/swagger")
    public String index() {
        System.out.println("swagger-ui.html");
        return "redirect:swagger-ui.html";
    }


    /*get method
    *
    * */
    @GetMapping("/getallitto")
    public Iterable<TIttoItem> getAllITTO() {

        return tIttoRepo.findAll();
    }

    @GetMapping("/getallittocateg")
    public Iterable<TIttoItemCateg> getAllITTOCateg() {

        return tIttoCategRepo.findAll();
    }

    @GetMapping("/getallpg")
    public Iterable<ProcessGroupName> getAllPGN() {

        return processGroupNameRepo.findAll();
    }

    @GetMapping("/getallks")
    public Iterable<TKnowledgeName> getAllKSN() {

        return tKnowledgeNameRepo.findAll();
    }

    @GetMapping("/getallpn")
    public Iterable<TProcessName> getAllPN() {

        return tProcessNameRepo.findAll();
    }

    @GetMapping("/getalltc")
    public Iterable<TToolCateg> getAllTC() {

        return tToolCategRepo.findAll();
    }

    @GetMapping("/getalltool")
    public Iterable<TTool> getAllTool() {

        return tToolRepo.findAll();
    }
    /*
    * add methods
    * */

    @PostMapping("/addpg")
    public void addNewpg(@RequestParam("pgname") String pgname) {
        tempPgName = new ProcessGroupName();
        tempPgName.setPgName(pgname);
        try
        {
            processGroupNameRepo.save(tempPgName);
            System.out.println("new Process Group has been saved!!");
        }
        catch (Exception e)
        {
            System.out.print(e);
        }
    }

    @PostMapping("/addks")
    public void addNewks(@RequestParam("ksname") String ksname) {
        tempKsName = new TKnowledgeName();
        tempKsName.setKsName(ksname);
        try
        {
            tKnowledgeNameRepo.save(tempKsName);
            System.out.println("new Knowledge scope has been saved!!");
        }
        catch (Exception e)
        {
            System.out.print(e);
        }
//        return "new Knowledge Scope has been saved.";
    }

    @PostMapping("/addpn")
    public void addNewpn(@RequestParam("pnname") String pnname, @RequestParam("bks") Integer bks, @RequestParam("bpg") Integer bpg, @RequestParam("dt") String dt) {

        tempPnName = new TProcessName();
        if (bks != null && bpg != null && pnname != null) {
            tempPnName.setpName(pnname);
            tempPnName.setBelongedKnowledgeScopeId(bks);
            tempPnName.setBelongedProcessGroupId(bpg);
            tempPnName.setDetails(dt);
        }

        try
        {
            tProcessNameRepo.save(tempPnName);
            System.out.println("new process has been saved!!");
        }
        catch (Exception e)
        {
            System.out.print(e);
        }
//        return "new Knowledge Scope has been saved.";
    }

    @PostMapping("/addtc")
    public void addNewtc(@RequestParam("tcname") String tcname) {
         temptcName = new TToolCateg();
         temptcName.setTcName(tcname);

        try
        {
            tToolCategRepo.save(temptcName);
            System.out.println("new Knowledge scope has been saved!!");
        }
        catch (Exception e)
        {
            System.out.print(e);
        }
//        return "new Knowledge Scope has been saved.";
    }

    @PostMapping("/addtool")
    public void addNewtool(@RequestParam("tname") String tname, @RequestParam("btc") Integer btc, @RequestParam("dt") String tdt) {

        temptoolName = new TTool();
        if (btc != null && tname != null) {
            temptoolName.setToolName(tname);
            temptoolName.setBelongedToolCateg(btc);
            temptoolName.setDetails(tdt);
        }

        try
        {
            tToolRepo.save(temptoolName);
            System.out.println("new tool has been saved!!");
        }
        catch (Exception e)
        {
            System.out.print(e);
        }

    }

    @PostMapping("/additto")
    public void addNewItto(@RequestParam("itton") String ittoname, @RequestParam("bittoc") Integer bittoc, @RequestParam("ittodt") String ittodt) {

        tempIttoName = new TIttoItem();
        if (bittoc != null && ittoname != null) {
            tempIttoName.setIttoItemName(ittoname);
            tempIttoName.setBelongedIttoItemCateg(bittoc);
            tempIttoName.setDetails(ittodt);

        }

        try
        {
            tIttoRepo.save(tempIttoName);
            System.out.println("new itto has been saved!!");
        }
        catch (Exception e)
        {
            System.out.print(e);
        }

    }

    @PostMapping("/addittocateg")
    public void addNewIttoC(@RequestParam("ittocname") String ittocname, @RequestParam("ittocdt") String ittocdt) {

        tempIttoCategName = new TIttoItemCateg();
        if (ittocname != null) {
            tempIttoCategName.setIttoCName(ittocname);
            tempIttoCategName.setDetails(ittocdt);
        }

        try
        {
            tIttoCategRepo.save(tempIttoCategName);
            System.out.println("new Itto category has been saved!!");
        }
        catch (Exception e)
        {
            System.out.print(e);
        }

    }

    /*
    * update methods
    *
    * */



    @GetMapping("/test")
    public String testReturn(@RequestParam("tv") String testString){

        return testString;

    }



}
