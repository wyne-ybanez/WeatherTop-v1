# WeatherTop

WeatherTop is a web application where members can submit weather reports from their stations to
the website where their entries are recorded, capturing the reading from a specific time. Each
member can create any number of weather stations records. The web application utilises weather 
analytics and conversions for each reading which is automatically calculated when a report is made.

View the live project here: https://rocky-wildwood-27122.herokuapp.com/

## Project Goal

The goal of the project is to create a web app that incorporates the principles of CRUD and designed
according to the MVC pattern. The project will achieve this by allowing users to create accounts, 
stations, weather reports and either edit or delete these as the user pleases. The web app provides 
only a very specific function by recording weather reports and providing a date/time recording of 
these reports. Thus, each recording will not be edited, however, user information can be edited by 
the user.

## UX

### Strategy

- The user would like to record weather reports on the web app. The application must portray that it
functions to serve this exact purpose from the get go. The application will be simple in design and
will have a logical, almost natural flow where a page will have necessary and useful links and forms
to help the user begin recording reports.

### Scope

Features planned:

- Website Title and purpose immediately communicated.
- Navigation Menu.
- ElephantSQL database to store records and users profiles.
- Login functionality.
- Logout functionality.
- CRUD functionality for records and profiles.
- Registered user station creation and management.
- Admin dashboard for reviewing data.

### Structure

The following main pages will be implemented:

- Base Page - main.html

- Sign Up Page - signup.html

- Log In Page - login.html

- About page, explains the web app and its purpose - about.html

- Home page, displays what the app is about - start.html
  - Menu should the user have logged in - menu.html
  - Menu if there is no user session ID - welcomemenu.html

- Dashboard, displays user records (Stations), allows users to add stations and delete stations - dashboard.html
  - Create station - addstation.html

- Station details - station.html
  - Displays a list of the readings relating to the station - listreadings.html
  - Create a report and record it in the station's readings list - addreading.html

- Account details Page - accounts.html
  - Edit account details page - editaccount.html
  
- Admin Dashboard - admin.html

- Error Handlers
  - Error 404 - 404.html (error 404 handling)
  - Error 500 - 500.html (error 500 handling)


### Skeleton

Display images of web app here...

### Surface

Color scheme and website design plan, fomantic ui...

## Design - In Depth

### Colour Scheme

- ...
    * #...
    * #...
    * #...

- ...

### Fonts

- ...

## Features

### Simple Design:

...

### Efficiency:

...

### Convenience:

...

## Testing

... 

## Technologies used:

### Languages
- [HTML5](https://en.wikipedia.org/wiki/HTML5)
- [CSS3](https://en.wikipedia.org/wiki/Cascading_Style_Sheets)
- [Java](https://www.java.com/en/download/help/whatis_java.html)

### IDE
- [IntelliJ idea](https://www.jetbrains.com/idea/) - The IDE used to code the website.

### Frameworks, Libraries, CDN's, Resources etc.
- [Play Framework](https://www.playframework.com/)
- [Fomantic UI](https://fomantic-ui.com/)

## Version Control

### Github & Sourcetree

1. Log into Github/Register for a Github account. Here is a link: https://github.com/
2. Log into Bitbucket/Register for a Bitbucket account: https://bitbucket.org/
3. Install Sourcetree: https://www.sourcetreeapp.com/
4. In the Sourcetree settings, select Authentication and add a Github account (if you already have 
a Github account set up, it might be simpler to use your personal access token).
5. Go to your github profile settings and click on "Developer settings" at the side menu.
6. Go to Personal Access Tokens, Press generate token.
7. The token can be set to unlimited (which is not recommended). Perhaps select 90 days. Give the 
token a name and press the Generate token button. You will then see the generated token and be able 
to copy it to the clipboard.
8. Back in Sourcetree, click 'Refresh Password'.
9. Here you will be pasting in the token generated on the Github site (in your clipboard hopefully).
Press Ok.
10. Create a new repository on Github.
11. Back in Sourcetree, press the local button.
12. Create a repository with the local project folder on your device.
13. You can now 'stage' all of the sources in the project by pressing the 'Stage All' button.
14. You can enter a commit message down below the Sourcetree app, which is your commit message.
15. Select master on the left, update the repository with the commit message.
16. In Sourcetree, select Repository-Repository Settings, Press add, and enter the remote name: 'origin', the URL path
is the repository path we have created.
17. Back in the main Sourcetree window, press 'Push'. Thus, sending your files to the github remote
repository.

### Forking the Repository

You can fork the repository through the following steps. Forking the repository means you will have a copy of the repository and any changes you make will not affect the original repository.

1. Log in to GitHub and locate the GitHub Repository. Here is a link for the [repository](...)
2. At the top of the Repository (not top of page) just above the "Settings" Button on the menu. Looking towards the right of the page. Locate the button "Fork" then click
3. You should now have a copy of the original repository in your GitHub account

### Local Clone

This is used when you would like to make changes to the project code

1. Should you wish to use a different IDE like VSCode. You first log in to Github and locate the required repository. Here is the link for this [repository](...)
2. Open a new terminal on Git Bash
3. Type `git clone`, and then paste the URL you copied

```
$ git clone https://github.com/wyne-ybanez/weather-top
```

Here is a link that can explain this process further. [Click Here](https://help.github.com/en/github/creating-cloning-and-archiving-repositories/cloning-a-repository#cloning-a-repository-to-github-desktop)


## Deployment

1. For deployment we will be using 2 external services: 
   - https://www.heroku.com
   - https://www.elephantsql.com

2. Sign up for Heroku and once confirmed on heroku, log in and go you your Dashboard: https://dashboard.heroku.com/apps

3. On ElephanSQL, once you have authorised/signed in with GitHub, you will be asked to create a team:
   - https://www.elephantsql.com




## Credits

### Code

- ...

### Content

- ...

### Media

- Image for Banner Section obtained from [Wherever](...)

## Known Bugs

- ...

## Design Changes

- ...

## Future Implementations

- ...

## Acknowledgements

- ...


Citations:
    - Solution for finding the last item in an array list:
        - https://stackoverflow.com/questions/687833/how-to-get-the-last-value-of-an-arraylist#:~:text=The%20size()%20method%20returns,to%20retrieve%20the%20last%20element.
    
    - Solution for DateTime feature:
        - https://stackoverflow.com/questions/23068676/how-to-get-current-timestamp-in-string-format-in-java-yyyy-mm-dd-hh-mm-ss/23068721#23068721

    - Images:
        - Login Page image: https://www.decolore.net/weather-forecast-icon-sets/
        - Registration page image: https://metro.co.uk/2018/02/26/iphone-weather-symbols-mean-7343734/