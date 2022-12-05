import com.sun.jdi.Value;

import javax.lang.model.element.Name;
import java.io.IOException;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        ArrayList<Admin> admins = new ArrayList<>();
        ArrayList<User> users = new ArrayList<>();
        Scanner scn = new Scanner(System.in);
        int x=0 ,Password ,ID;
        Admin admin= new Admin(111,000,"Amin","Amin@fawry.com");
        User user=new User(1500,125,"Ali","Ali@fawry.com");
        Admin admin1= new Admin(1110,0100,"Amin","Amin@fawry.com");
        User user1=new User(15001,1250,"Ali","Ali@fawry.com");
        Admin admin2= new Admin(1118,0007,"Amin","Amin@fawry.com");
        User user2=new User(15002,1252,"Ali","Ali@fawry.com");
        users.add(user);
        admins.add(admin);
        users.add(user1);
        admins.add(admin1);
        users.add(user2);
        admins.add(admin2);
        String temp,Email,Name;

        while(x!=3){

            System.out.println("please choose your type: ");
            System.out.println(" 1) Admin ");
            System.out.println(" 2) User ");
            System.out.println(" 3) Exit ");
            System.out.println("your choice : " );
            x=scn.nextInt();
            if(x==1) {
                System.out.println("    \tChoose \n-----------------------\n1- sigin\t2- signup\n");
                temp = scn.next();
                if (temp.equals("2")) {
                    System.out.println("Enter Email:");
                    Email = scn.next();
                    System.out.println("Enter Name: ");
                    Name = scn.next();
                    System.out.println("Enter ID");
                    ID = scn.nextInt();
                    System.out.println("Enter Password");
                    Password = scn.nextInt();
                    int ok = 1;
                  
                    for (Admin value : admins) {
                        if (value.getEmail().equals(Email) && value.getName().equals(Name) && value.getPass() == (Password) && value.getID() == (ID)) {
                            System.out.println("user signedin to the System before ");
                            ok = 0;
                            break;
                        }
                    }
                    if (ok == 1) { 
                        System.out.println("Registered Successfully");
                        admins.add(new Admin(ID, Password, Name, Email));

                        break;
                    }
                }
                System.out.println(" Please Enter Info. For Signin : ");
                System.out.println(" ID : ");
                ID = scn.nextInt();
                System.out.println(" Password : ");
                Password = scn.nextInt();
                int ok = 0;
                for (Admin value : admins) {
                    if (value.getID() == ID &&value.getPass() == Password) {
                        System.out.println("Signin Successfully");
                        ok = 1;
                        while (ok==1){
                            System.out.println(" Hello Admin \n What Do You Want To Do ?\n 1.Add Discount \n 2.View Request Refunds\n 3.Add Service Provider\n 4.List of Transactions\n 5.Get Info\n .Sign Out");
                            temp=scn.next();
                            if(temp.equals("6")){
                                break;

                            }
                            else if(temp.equals("5")){
                                System.out.println(" ID : "+value.getID() +"\n Name : "+ value.getName());
                                System.out.println(" Email : "+value.getEmail() +"\n Password : "+ value.getPass());
                            }
              
                            else if (temp.equals("4")) {
                              
                                value.list_transaction();

                            }
                            else if (temp.equals("3")) {
                                value.add_service();

                            }
                            else if (temp.equals("2")) {
                                value.approve_refund();

                            }
                            else if (temp.equals("1")) {
                                value.add_discount();

                            }
                        }

                        break;
                    }
                }
                if (ok == 0) {
                    System.out.println("No such user SignedUp to the System");
                }
            }
            if (x==2){
                System.out.println("    \tChoose \n-----------------------\n1- Signin\t2- Signup\n");
                temp = scn.next();
                if (temp.equals("2")) {
                    System.out.println("Enter Email:");
                    Email = scn.next();
                    System.out.println("Enter Name: ");
                    Name = scn.next();
                    System.out.println("Enter ID");
                    ID = scn.nextInt();
                    System.out.println("Enter Password");
                    Password = scn.nextInt();
                    int ok = 1;
                    for (User value : users) {
                        if (value.getEmail().equals(Email) && value.getName().equals(Name) && value.getPass() == (Password) && value.getID() == (ID)) {
                            System.out.println("user registered to the System before ");
                            ok = 0;
                            break;
                        }
                    }
                    if (ok == 1) { 
                        System.out.println("Registered Successfully");
                        users.add(new User(ID, Password, Name, Email));

                        break;
                    }
                }
                System.out.println(" Please Enter Info. For Signin : ");
                System.out.println(" ID : ");
                ID = scn.nextInt();
                System.out.println(" Password : ");
                Password = scn.nextInt();
                int ok = 0;
                for (User value : users) {
                    if (value.getID() == ID &&value.getPass() == Password) {
                        System.out.println("Login Successfully");
                        ok = 1;
                        while (ok==1){
                            System.out.println(" Hello User \n What Do You Want To Do ?\n 1.Add amount to Wallet \n 2.Shaw avaiable discount\n 3.Select Service \n 4.List of Refund Request\n5.Make Refund\n 6.Get Info\n 7.Sign Out");
                            temp=scn.next();
                            if(temp.equals("7")){
                                break;
                            }
                            else if(temp.equals("6")){
                                System.out.println(" ID : "+value.getID() +"\n Name : "+ value.getName());
                                System.out.println(" Email : "+value.getEmail() +"\n Password : "+ value.getPass());
                            }
                         
                            else if (temp.equals("5")) {
                                value.refund();
                            }
                            else if (temp.equals("4")) {
                                value.history();
                            }
                            else if (temp.equals("3")) {
                                value.applyservice();
                            }
                            else if (temp.equals("2")) {
                                value.get_discount();
                            }
                            else if (temp.equals("1")) {
                                value.wallet();
                            }
                        }

                        break;
                    }
                }

                if (ok == 0) {
                    System.out.println("No such user registered to the System");
                }
            }
        }

    }
}
