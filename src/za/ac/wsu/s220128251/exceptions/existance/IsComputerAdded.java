package za.ac.wsu.s220128251.exceptions.existance;

import za.ac.wsu.s220128251.exceptions.ExistException;

import java.util.ArrayList;

public class IsComputerAdded {

    public IsComputerAdded(ArrayList<String> compsList, String comp) throws ExistException {
        if(compsList.contains(comp)){
            throw new ExistException("Computer Already available");
        }
    }
}
