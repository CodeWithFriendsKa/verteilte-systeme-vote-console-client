package de.dhbw.vote.view;

public class ContentViewer {

    public ContentViewer() {
    }
    
    public void showTitleAndMenue(){
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("  / / / /___  ________  _____   / /__/ /__  (_)___  ___  _____   / ____/ (_)__  ____  / /_\n" +
                           " / / / / __ \\/ ___/ _ \\/ ___/  / //_/ / _ \\/ / __ \\/ _ \\/ ___/  / /   / / / _ \\/ __ \\/ __/\n" +
                           "/ /_/ / / / (__  )  __/ /     / ,< / /  __/ / / / /  __/ /     / /___/ / /  __/ / / / /_  \n" +
                          "\\____/_/ /_/____/\\___/_/     /_/|_/_/\\___/_/_/ /_/\\___/_/      \\____/_/_/\\___/_/ /_/\\__/");   
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        
        System.out.println();
        System.out.println("==========================================================================================");
        System.out.println("Folgende Optionen stehen zur Auswahl:");
        System.out.println("quit                                 : Beendet den Client");
        System.out.println("clear                                : Console bereinigen"); 
        System.out.println("get voter -all                       : Gebe alle Voter aus");
        System.out.println("get voter -username -{username}      : Finde einen Voter anhand seines Usernamen");
        System.out.println("get updownvote -all                  : Gebe alle UpDownVotes aus");
        System.out.println("get updownvote -username -{username} : Finde alle UpDownVotes eines Users anhand des Usernamens");       
        System.out.println("==========================================================================================");
    }
    
    public void goodBye(){
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");        
        System.out.println("   ____ _____  ____  ____/ / /_  __  _____ \n" +
                           "  / __ `/ __ \\/ __ \\/ __  / __ \\/ / / / _ \\\n" +
                           " / /_/ / /_/ / /_/ / /_/ / /_/ / /_/ /  __/\n" +
                           " \\__, /\\____/\\____/\\__,_/_.___/\\__, /\\___/ \n" +
                            "/____/                        /____/       "
        );
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");    
    }
    
    public void showCannotInterpret(){
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("Entchuldigung. Ich kann Ihr Kommando leider nicht verstehen");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }    
      
    public void showWaitForCommand(){
        System.out.print("enter command : > ");
    }
}
