package za.ac.wsu.s220128251.exceptions.emptyList;

import za.ac.wsu.s220128251.exceptions.ComputerListEmpty;

import java.util.ArrayList;

public class IsEmptyList {
    public IsEmptyList(ArrayList<String> computers,ArrayList<Double> values) throws ComputerListEmpty{
        if(computers.isEmpty() && values.isEmpty()){
            throw new ComputerListEmpty("Not Yet Added Computer!!");
        }
    }
}
