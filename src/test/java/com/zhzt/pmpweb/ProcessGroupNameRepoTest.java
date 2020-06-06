package com.zhzt.pmpweb;

import com.zhzt.pmpweb.repo.ProcessGroupNameRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class ProcessGroupNameRepoTest extends PmpwebApplicationTests{
    @Autowired
    private ProcessGroupNameRepo TprocessGroupNameRepo;

    @Test
    public void testPGNRepo(){
        if (TprocessGroupNameRepo.findAll() != null) {
            System.out.print("Alright");
            System.out.print(TprocessGroupNameRepo.findById(1));

        };
    }
}
