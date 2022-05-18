package controllers;

import play.Logger;
import play.mvc.Controller;

import models.Member;

public class Accounts extends Controller
{
    public static void register(String firstname, String lastname, String email, String password)
    {
        Logger.info("Registering new user " + email);
        Member member = new Member(firstname, lastname, email, password);
        member.save();
        redirect("/");
    }

    public static void signup()
    {
        render("signup.html");
    }

    public static void login(){
        render("login.html");
    }

    public static void logout(){
        session.clear();
        redirect("/");
    }

    /**
     * User Authentication
     * Finds member through the user email.
     * Adds memberId to the session should authentication be successful.
     *
     * @param email
     * @param password
     */
    public static void authenticate(String email, String password){
        Logger.info("Attempting to authenticate with " + email + ":" + password);

        Member member = Member.findByEmail(email);
        if ((member != null) && (member.checkPassword(password) == true)){
            Logger.info("Authentication successful");
            session.put("logged_in_Memberid", member.id);
            redirect("/dashboard");
        }
        else {
            Logger.info("Authentication failed");
            redirect("/login");
        }
    }
}
