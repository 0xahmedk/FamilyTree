/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package familytree;
import java.util.*;
import java.io.Serializable;
/**
 *
 * @author ideal
 */
public class FamilyMember implements Serializable{
    private static final long serialVersionUID = 1L;
    private String name, surname, gender, life_description;
    private String street_no, street_name, city, postal_code;
    private FamilyMember father, mother, spouse;
    private ArrayList<FamilyMember> children;
    
    public FamilyMember(){
        children = new ArrayList<>();
        name = "N/A";
        surname = "N/A";
        gender = "N/A";
        life_description = "N/A";
        
        street_no = "N/A";
        street_name = "N/A";
        city = "N/A";
        postal_code = "N/A";
//        father = new FamilyMember();
//        mother = new FamilyMember();
//        spouse = new FamilyMember();
//        father.setName("N/A");
//        mother.setName("N/A");
//        spouse.setName("N/A");
    }
    public FamilyMember(FamilyMember fm){
        children = new ArrayList<>();
        name = fm.name;
        surname = fm.surname;
        gender = fm.gender;
        life_description = fm.life_description;
        
        street_no = fm.street_no;
        street_name = fm.street_name;
        city = fm.city;
        postal_code = fm.postal_code;
        father = new FamilyMember();
        mother = new FamilyMember();
        spouse = new FamilyMember();
        father.setName("N/A");
        mother.setName("N/A");
        spouse.setName("N/A");
    }
    public FamilyMember(String member_name) {
        name = member_name;
        
        surname = "N/A";
        gender = "N/A";
        life_description = "N/A";
        
        street_no = "N/A";
        street_name = "N/A";
        city = "N/A";
        postal_code = "N/A";
        father = new FamilyMember();
        mother = new FamilyMember();
        spouse = new FamilyMember();
        father.setName("N/A");
        mother.setName("N/A");
        spouse.setName("N/A");
        children = new ArrayList<>();
    }
//    public static void assignForFile(FamilyMember fm){
//        children = new ArrayList<>();
//        name = fm.name;
//        surname = fm.surname;
//        gender = fm.gender;
//        life_description = fm.life_description;
//        
//        street_no = fm.street_no;
//        street_name = fm.street_name;
//        city = fm.city;
//        postal_code = fm.postal_code;
//        father = new FamilyMember();
//        mother = new FamilyMember();
//        spouse = new FamilyMember();
//        father.setName("N/A");
//        mother.setName("N/A");
//        spouse.setName("N/A");
//    }
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLife_description() {
        return life_description;
    }

    public void setLife_description(String life_description) {
        this.life_description = life_description;
    }

    public String getStreet_no() {
        return street_no;
    }

    public void setStreet_no(String street_no) {
        this.street_no = street_no;
    }

    public String getStreet_name() {
        return street_name;
    }

    public void setStreet_name(String street_name) {
        this.street_name = street_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FamilyMember getFather() {
        return father;
    }

    public void setFather(FamilyMember father) {
        this.father = father;
    }

    public FamilyMember getMother() {
        return mother;
    }

    public void setMother(FamilyMember mother) {
        this.mother = mother;
    }

    public FamilyMember getSpouse() {
        return spouse;
    }

    public void setSpouse(FamilyMember spouse) {
        this.spouse = spouse;
    }

    public ArrayList<FamilyMember> getChildren() {
        return children;
    }

    public void setChildren(FamilyMember child) {
        children.add(child);
    }
    public void addChild(FamilyMember fm){
        children.add(new FamilyMember(fm));
    }
    
    
}
