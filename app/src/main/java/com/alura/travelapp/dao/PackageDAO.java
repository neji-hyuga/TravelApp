package com.alura.travelapp.dao;

import com.alura.travelapp.model.TravelPackage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PackageDAO {
    public List<TravelPackage> list() {
        List<TravelPackage> packages = new ArrayList<>(Arrays.asList(
                new TravelPackage("oslo", "sao_paulo_sp", 2, new BigDecimal(243.99)),
                new TravelPackage("bergen", "belo_horizonte_mg", 1, new BigDecimal(400.99)),
                new TravelPackage("stavanger", "recife_pe", 7, new BigDecimal(500.99)),
                new TravelPackage("arendal", "rio_de_janeiro_rj", 2, new BigDecimal(150.99)),
                new TravelPackage("drammen", "salvador_ba", 3, new BigDecimal(900.99)),
                new TravelPackage("larviki", "foz_do_iguacu_pr", 2, new BigDecimal(500.99))));

        return packages;
    }
}
