package com.bindstone.graphbank.service.bpm;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CalcBpm implements JavaDelegate {
    static Logger log = LoggerFactory.getLogger(CalcBpm.class);
    //http://stackoverflow.com/questions/36599614/alfresco-activiti-java-delegates-show-process-variable-to-worflow-form

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info("FLOW, FLOW, FLOW");
    }
}