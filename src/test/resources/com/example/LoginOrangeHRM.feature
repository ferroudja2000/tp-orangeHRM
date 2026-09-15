Feature: connexion a orangeHRM

    Background: 
        Given visiter le site de orangeHRM "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
        

    Scenario: parcours de connexion

        When je saisis de username "Admin"
        And je saisis le password "admin123"
        And je clique sur le bouton login
        Then je suis redirige vers le Dashbord 
        And  la section My Actions est  visible  
        And la section Quick launch est visible 

