package com.company.facade;

public class PcGamingFacade {
    private final OC OC;
    private final DriverSoft DriverSoft;
    private final DotaExecutor DotaExecutor;

    public PcGamingFacade(){
        OC = new OC();
        DriverSoft = new DriverSoft();
        DotaExecutor = new DotaExecutor();
    }

    public void exec(){
        OC.exec();
        DriverSoft.exec();
        DotaExecutor.exec();
    }
}
