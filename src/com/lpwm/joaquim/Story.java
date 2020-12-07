package com.lpwm.joaquim;


   //class that does nothing but storing methods to print out every part of the story
public class Story {
	
	public static void printIntro(){
		Game.clearConsole();
		Game.printSeperator(30);
		System.out.println("STORY");
		Game.printSeperator(30);
		System.out.println("You are the last man standing after your village got raided by the henchmen of the evil emperor.");
		System.out.println("Every single one of your friends, family and neighbours got murdered. You are standing in burning ruins of this once beautiful village.");
		System.out.println("All you want now is revenge, so you begin planning your journey to defeat the evil emperor and free the lands!");
		Game.anythingToContinue();
	}
	
	public static void printFirstActIntro(){
		Game.clearConsole();
		Game.printSeperator(30);
		System.out.println("ACT I - INTRO");
		Game.printSeperator(30);
		System.out.println("As you begin your journey, you start travelling trough the nearby woods to reach the everlasting mountains.");
		System.out.println("The everlasting mountains are a very dangerous place. It says nobody came back alive from there.");
		System.out.println("\nAfter a long day of walking through the woods, you finally reach the everlasting mountains.");
		System.out.println("You don't care about the things you've heard about this dangerous place and start your journey to defeat the evil emperor.");
		Game.anythingToContinue();
	}
	
	public static void printFirstActOutro(){
		Game.clearConsole();
		Game.printSeperator(30);
		System.out.println("ACT I - OUTRO");
		Game.printSeperator(30);
		System.out.println("You did it! You crossed the everlasting mountains and you're still alive!");
		System.out.println("As you climb down the last hill, you're more than happy to feel hard ground underneath your feet again.");
		System.out.println("\nYou feel empowered and the experience you gained allows you to learn another trait!");
		Game.anythingToContinue();
	}
	
	public static void printSecondActIntro(){
		Game.clearConsole();
		Game.printSeperator(30);
		System.out.println("ACT II - INTRO");
		Game.printSeperator(30);
		System.out.println("You begin travelling across a lifeless desertic land of this once well populated countryside.");
		System.out.println("You collected some gold from the monsters you killed along the way.");
		System.out.println("Luckily you know that every once in a while a travelling trader comes across these lands.");
		System.out.println("You know exactly where the castle of the evil emperor is, but you have to cross this cursed territory first...");
		Game.anythingToContinue();
	}
	
	public static void printSecondActOutro(){
		Game.clearConsole();
		Game.printSeperator(30);
		System.out.println("ACT II - OUTRO");
		Game.printSeperator(30);
		System.out.println("You managed to cross these haunted lands without being spotted by the Emperor's Henchmen!");
		System.out.println("You are just a few hours away from your final destination; the castle of the Evil Emperor!");
		System.out.println("You know that you probably can't rest there, so you make a last break before the serious things begin.");
		System.out.println("\nAfter all you've seen you feel empowered to learn another trait.");
		Game.anythingToContinue();
	}
	
	public static void printThirdActIntro(){
		Game.clearConsole();
		System.out.println("                           .-----.");
		System.out.println("             ^v^         .'       `.");
		System.out.println("                        :           :");
		System.out.println("                        '           :");
		System.out.println("         |~        www   `.       .'");
		System.out.println("        /.\\       /#^^\\_   `-/\\--'");
		System.out.println("       /#  \\     /#%    \\   /# \\");
		System.out.println("      /#%   \\   /#%______\\ /#%__\\");
		System.out.println("     /#%     \\   |= I I ||  |- |");
		System.out.println("     ~~|~~~|~~   |_=_-__|'  |[]|");
		System.out.println("       |[] |_______\\__|/_ _ |= |`.");
		System.out.println("^V^    |-  /= __   __    /-\\|= | :;");
		System.out.println("       |= /- /\\/  /\\/   /=- \\.-' :;");
		System.out.println("       | /_.=========._/_.-._\\  .:'");
		System.out.println("       |= |-.'.- .'.- |  /|\\ |.:'");
		System.out.println("       \\  |=|:|= |:| =| |~|~||'|");
		System.out.println("        |~|-|:| -|:|  |-|~|~||=|      ^V^");
		System.out.println("        |=|=|:|- |:|- | |~|~|| |");
		System.out.println("        | |-_~__=_~__=|_^^^^^|/___");
		System.out.println("        |-(=-=-=-=-=-(|=====/=_-=/\\");
		System.out.println("       | |=_-= _=- _=| -_=/=_-_/__\\ ");
		System.out.println("       | |- _ =_-  _-|=_- |]#| I II");
		System.out.println("       |=|_/ \\_-_= - |- = |]#| I II");
		System.out.println("       | /  _/ \\. -_=| =__|]!!!I_II!!");
		System.out.println("      _|/-'/  ` \\_/ \\|/' _ ^^^^`.==_^.");
		System.out.println("    _/  _/`-./`-; `-.\\_ / \\_'\\`. `. ===`.");
		System.out.println("   / .-'  __/_   `.   _/.' .-' `-. ; ====;\\");
		System.out.println("  /.   `./    \\ `. \\ / -  /  .-'.' ====='  >");
		System.out.println(" /  \\  /  .-' `--.  / .' /  `-.' ======.' /\n");
		Game.printSeperator(30);
		System.out.println("ACT III - INTRO");
		Game.printSeperator(30);
		System.out.println("You see the huge black castle in front of you.");
		System.out.println("As you stand in front of the gates, you know there's no going back.");
		System.out.println("You're disguised as a mercenary and enter the castle. You don't know how much time you have left before someone discovers you!");
		System.out.println("A discreet entrance seems to be on the left...");
		Game.anythingToContinue();
	}
	
	
	public static void printThirdActOutro(){
		Game.clearConsole();
		Game.printSeperator(30);
		System.out.println("ACT III - OUTRO");
		Game.printSeperator(30);
		System.out.println("You came so far. You defeated all of the Evil Emperor's minions.");
		System.out.println("As you stand in front of the door to his throne room, you know there's no going back.");
		System.out.println("You get the chance to learn a last trait before entering the throne room and restore your health.");
		System.out.println("A heavy silence reigns...");
		Game.anythingToContinue();
	}
	
	public static void printFourthActIntro(){
		Game.clearConsole();
		
		System.out.println("                            ==(W{==========-      /===-                        ");
		System.out.println("                              ||  (.--.)         /===-_---~~~~~~~~~------____  ");
		System.out.println("                              | \\_,|**|,__      |===-~___                _,-' `");
		System.out.println("                 -==\\\\        `\\ ' `--'   ),    `//~\\\\   ~~~~`---.___.-~~      ");
		System.out.println("             ______-==|        /`\\_. .__/\\ \\    | |  \\\\           _-~`         ");
		System.out.println("       __--~~~  ,-/-==\\\\      (   | .  |~~~~|   | |   `\\        ,'             ");
		System.out.println("    _-~       /'    |  \\\\     )__/==0==-\\<>/   / /      \\      /               ");
		System.out.println("  .'        /       |   \\\\      /~\\___/~~\\/  /' /        \\   /'                ");
		System.out.println(" /  ____  /         |    \\`\\.__/-~~   \\  |_/'  /          \\/'                  ");
		System.out.println("/-'~    ~~~~~---__  |     ~-/~         ( )   /'        _--~`                   ");
		System.out.println("                  \\_|      /        _) | ;  ),   __--~~                        ");
		System.out.println("                    '~~--_/      _-~/- |/ \\   '-~ \\                            ");
		System.out.println("                   {\\__--_/}    / \\\\_>-|)<__\\      \\                           ");
		System.out.println("                   /'   (_/  _-~  | |__>--<__|      |                          ");
		System.out.println("                  |   _/) )-~     | |__>--<__|      |                          ");
		System.out.println("                  / /~ ,_/       / /__>---<__/      |                          ");
		System.out.println("                 o-o _//        /-~_>---<__-~      /                           ");
		System.out.println("                 (^(~          /~_>---<__-      _-~                            ");
		System.out.println("                ,/|           /__>--<__/     _-~                               ");
		System.out.println("             ,//('(          |__>--<__|     /  -               .----_          ");
		System.out.println("            ( ( '))          |__>--<__|    |                 /' _---_~\\        ");
		System.out.println("         `-)) )) (           |__>--<__|    |               /'  /     ~\\`\\      ");
		System.out.println("        ,/,'//( (             \\__>--<__\\    \\            /'  //        ||      ");
		System.out.println("      ,( ( ((, ))              ~-__>--<_~-_  ~--____---~' _/'/        /'       ");
		System.out.println("    `~/  )` ) ,/|                 ~-_~>--<_/-__       __-~ _/                  ");
		System.out.println("  ._-~//( )/ )) `                    ~~-'_/_/ /~~~~~~~__--~                    ");
		System.out.println("   ;'( ')/ ,)(                              ~~~~~~~~~~                         ");
		System.out.println("  ' ') '( (/                                                                   ");
		System.out.println("   '   '  `");

		Game.printSeperator(30);
		System.out.println("ACT IV - INTRO");
		Game.printSeperator(30);
		System.out.println("You enter the throne room of the Evil Emperor.");
		System.out.println("He stares you dead in the eyes. But he is not alone... a jet of flame sets the room ablaze! He rides a dragon.");
		System.out.println("He takes out the holy sword of darkness, the mightiest weapon known to man.");
		System.out.println("All you can do is fighting for your life and pray to come out as the winner...");
		Game.anythingToContinue();
	}

	public static void printFourthActOutro(){
		Game.clearConsole();
		
		Game.printSeperator(30);
		System.out.println("ACT IV - OUTRO");
		Game.printSeperator(30);
		System.out.println("You defeated of the Evil Emperor.");
		System.out.println("But when you thought you had finally conquered the evil that reigned...");
		System.out.println("A huge noise is heard, the temperature rises, and the light disappears.");
		System.out.println("\nIn his last entrenchments, the Emperor pronounces something in an ancient language.");
		System.out.println("What the hell is happening?!");
		System.out.println("*huge earthquake*");
		Game.anythingToContinue();
	}

	public static void printFinalActIntro(){
		Game.clearConsole();
		
		System.out.println("           _/          ,          .                                          ");
		System.out.println("       , -' )         ( \\-------.,')            (\\_________________________  ");
		System.out.println("     , ,-/ |          /\\_) )     \\/            ,' _.----------------------,\\ ");
		System.out.println("   ,',  /, |         /      >--. ,)           / /\\\\                          ");
		System.out.println("  / ,  //|,'        /'     '\\--'\\\\)          /,'  \\\\     `         `   ,     ");
		System.out.println(" / ,  // ||       ,'     (.--^( `')         //     \\\\                \\       ");
		System.out.println("( ,  //  ||,___,-'    (___\\\\  '^^^'        //       \\\\              ,        ");
		System.out.println(" \\  //   ||--.__     (     \\`^--)  _____.-'/         \\\\   `                  ");
		System.out.println("  >'/    ||,        (       \\|_(\\-'      ,'           \\\\         \\,          ");
		System.out.println(" /,'     ||          \\           \\      /              \\\\                    ");
		System.out.println("(/       ||           \\           )  ,'(     `     `    \\\\      ,            ");
		System.out.println(" `       ||\\           \\      ) ,'  /_  )                \\\\    \\             ");
		System.out.println("         || `.          `.    ,'   /( `.\\  \\ , \\ \\,       \\\\   ,             ");
		System.out.println("   `     || (_`.          ` .'   .'  )  `)'            ,   \\\\                ");
		System.out.println("         ||  (_ `-v-------  ^--v' , )                      '\\\\,              ");
		System.out.println("         ||    (    , _,-  /  -./ )'                         `)              ");
		System.out.println("     `   '|     ),  ,'    '     )'                                           ");
		System.out.println("        ' ;    /  ,'          ,'                                             ");
		System.out.println("       /,'    /  /      '    /     , - --- .                                 ");
		System.out.println("       \\|    /  (          ,'   '           `.                               ");
		System.out.println("       ('  ,'    `.    \"  / ,'                \\                              ");
		System.out.println("         ,'        \\    ,/,'        '`)   (_   )                             ");
		System.out.println("        /           \\ , /'          ,      /  /                              ");
		System.out.println("       .             )  ,       ,         '  /                               ");
		System.out.println("                      )      ,              /                                ");
		System.out.println("       .            ' `|   ,'              /                                 ");
		System.out.println("                    '  |  /              ,'                                  ");
		System.out.println("        |\\             | <    ______,---'                                    ");
		System.out.println("        ` \\            ','   (                                               ");
		System.out.println("         \\ '          /(____ ,`-._,-.                                        ");
		System.out.println("          `.         /.     `._, )---)                                       ");
		System.out.println("            `-------' \\        `/ \\                                          ");
		System.out.println("               )   )   \\         ` \\                                         ");
		System.out.println("              /  '(     `.        `                                          ");
		System.out.println("         ___,' _, /       `.        .                                        ");
		System.out.println("        ('.---/ \\(          .      '|                                        ");
		System.out.println("        /'    `|^'           .     ,                                         ");
		System.out.println("                             .     /                                         ");
		System.out.println("                                  '                                          ");
		System.out.println("                       ,^.  '    '                                           ");
		System.out.println("                       | ','  ,                                              ");
		System.out.println("                        `. _ '                                               ");
		System.out.println("");

		Game.printSeperator(30);
		System.out.println("FINAL FIGHT - THE TRUE ENEMY");
		Game.printSeperator(30);
		System.out.println("An enemy can hide an other ! As we all thought that the evil that reigned here was the Emperor...");
		System.out.println("It was in fact... NO! THAT'S NOT POSSIBLE! THIS IS A MYTH!!!");
		System.out.println("You feel the darkness around you.");
		System.out.println("The one we thought was extinct for millennia is back.");
		System.out.println("GOTHMOD THE LORD OF DARKNESS sprang from the bowels of the underworld and stands in front of us !");
		System.out.println("Praying is the only thing we can do...");
		Game.anythingToContinue();
	}
	
	public static void printEnd(Player player){
		Game.clearConsole();
		Game.printSeperator(30);
		System.out.println("Congratulations " + player.name + " ! INCREDIBLE You puted back the Lord of Darkness in hell !");
		System.out.println("You have become a true hero whose praises will be sung forever !");
		System.out.println(" _______  _______    _ ");
		System.out.println("(  ____ \\(  ____ \\  ( )");
		System.out.println("| (    \\/| (    \\/  | |");
		System.out.println("| |      | |        | |");
		System.out.println("| | ____ | | ____   | |");
		System.out.println("| | \\_  )| | \\_  )  (_)");
		System.out.println("| (___) || (___) |   _ ");
		System.out.println("(_______)(_______)  (_)");
		Game.printSeperator(30);
		System.out.println("This game was developed by Joaquim Dimitrov");
		System.out.println("I hope you enjoyed it!");
	}
} 




// System.out.println("                                 ____                                         ");
// System.out.println("                              .-\"    `-.      ,                               ");
// System.out.println("                            .'          '.   /j\\                              ");
// System.out.println("                           /              \\,/:/#\\                /\\           ");
// System.out.println("                          ;              ,//' '/#\\              //#\\          ");
// System.out.println("                          |             /' :   '/#\\            /  /#\\         ");
// System.out.println("                          :         ,  /' /'    '/#\\__..--\"\"\"\"/    /#\\__      ");
// System.out.println("                           \\       /'\\'-._:__    '/#\\        ;      /#, \"\"\"---");
// System.out.println("                            `-.   / ;#\\']\" ; \"\"\"--./#J       ':____...!       ");
// System.out.println("                               `-/   /#\\  J  [;[;[;Y]         |      ;        ");
// System.out.println("\"\"\"\"\"\"---....             __.--\"/    '/#\\ ;   \" \"  |     !    |   #! |        ");
// System.out.println("             \"\"--.. _.--\"\"     /      ,/#\\'-..____.;_,   |    |   '  |        ");
// System.out.println("                   \"-.        :_....___,/#} \"####\" | '_.-\",   | #['  |        ");
// System.out.println("                      '-._      |[;[;[;[;|         |.;'  /;\\  |      |        ");