package com.zhzt.pmpweb.controller;


import com.zhzt.pmpweb.entity.ProcessGroupName;
import com.zhzt.pmpweb.entity.TKnowledgeName;
import com.zhzt.pmpweb.entity.TProcessName;
import com.zhzt.pmpweb.entity.TToolCateg;
import com.zhzt.pmpweb.repo.ProcessGroupNameRepo;
import com.zhzt.pmpweb.repo.TKnowledgeNameRepo;
import com.zhzt.pmpweb.repo.TProcessNameRepo;
import com.zhzt.pmpweb.repo.TToolCategRepo;
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

    private ProcessGroupName tempPgName;
    private TKnowledgeName tempKsName;
    private TProcessName tempPnName;
    private TToolCateg temptcName;

    /*get method
    *
    * */

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
    /*
    * add methods
    * */

    @PostMapping("/addpg")
    public String addNewpg(@RequestParam("pgname") String pgname) {
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
        return "new Progress Group Name has been saved.";
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

    /*
    * update methods
    *
    * */



    @GetMapping("/test")
    public String testReturn(@RequestParam("tv") String testString){

        return testString;

    }



}
