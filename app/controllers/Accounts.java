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
}
