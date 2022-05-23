package controllers;

import play.Logger;
import play.mvc.Controller;

import models.Member;

public class Accounts extends Controller
{
    /**
     * Renders registration page. Once registered the member is redirected to the dashboard.
     *
     * @param firstname
     * @param lastname
     * @param email
     * @param password
     */
    public static void register(String firstname, String lastname, String email, String password)
    {
        Logger.info("Registering new user " + email);
        Member member = new Member(firstname, lastname, email, password);
        member.save();
        redirect("/dashboard");
    }

    /**
     * Sign Up page
     */
    public static void signup()
    {
        render("signup.html");
    }

    /**
     * Login page
     */
    public static void login(){
        render("login.html");
    }

    /**
     * User logout
     */
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

    /**
     * Checks to see if a user has logged in.
     * User identified through memberid. If there is no memberid, the user is redirected to login page.
     *
     * @return member
     */
    public static Member getLoggedInMember()
    {
        Member member = null;
        if (session.contains("logged_in_Memberid")) {
            String memberid = session.get("logged_in_Memberid");
            member = Member.findById(Long.parseLong(memberid));
        }
        else {
            login();
        }
        return member;
    }

    /**
     * Renders accounts.html page for the logged in user.
     */
    public static void account(){
        Member member = getLoggedInMember();
        render("accounts.html", member);
    }

    /**
     * Update user account details.
     *
     * @param firstname User desired first name
     * @param lastname  User desired last name
     * @param email     User desired email
     * @param password  User desired password
     */
    public static void updateDetails(String firstname, String lastname, String email, String password){
        // Get the member in question
        Member member = getLoggedInMember();

        member.firstname = firstname;
        member.lastname = lastname;
        member.email = email;
        member.password = password;
        Logger.info("Updating user info " + email);
        member.save();
        redirect("/account");
    }
}
