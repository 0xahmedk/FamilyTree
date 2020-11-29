/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package familytree;

/**
 *
 * @author ideal
 */
//This cl;ass is designed to hold data
abstract public class CurrentData {
    private FamilyMember rootMember;

    public void initializeData(){
        rootMember = new FamilyMember();
    }
    public CurrentData() {
        rootMember = new FamilyMember(); 
    }

    public FamilyMember getRootMember() {
        return rootMember;
    }

    public void setRootMember(FamilyMember rootMembe) {
        rootMember = rootMembe;
    }
    
}
