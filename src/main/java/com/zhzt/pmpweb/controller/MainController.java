package com.zhzt.pmpweb.controller;


import com.zhzt.pmpweb.entity.ProcessGroupName;
import com.zhzt.pmpweb.entity.TKnowledgeName;
import com.zhzt.pmpweb.entity.TProcessName;
import com.zhzt.pmpweb.repo.ProcessGroupNameRepo;
import com.zhzt.pmpweb.repo.TKnowledgeNameRepo;
import com.zhzt.pmpweb.repo.TProcessNameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/pmpweb")
public class MainController {

    @Autowired
    private ProcessGroupNameRepo processGroupNameRepo;
    @Autowired
    private TKnowledgeNameRepo tKnowledgeNameRepo;
    @Autowired
    private TProcessNameRepo tProcessNameRepo;

    private ProcessGroupName tempPgName;

    @GetMapping("/getallpg")
    public Iterable<ProcessGroupName> getAllPGN() {

        return processGroupNameRepo.findAll();
    }

    @PostMapping("/addpg")
    public String addNewpg(@RequestParam("name") String pgname) {
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

    @GetMapping("/getallks")
    public Iterable<TKnowledgeName> getAllKSN() {

        return tKnowledgeNameRepo.findAll();
    }

    @GetMapping("/getallpn")
    public Iterable<TProcessName> getAllPN() {

        return tProcessNameRepo.findAll();
    }

    @GetMapping("/test")
    public String testReturn(@RequestParam("tv") String testString){

        return testString;

    }



}
